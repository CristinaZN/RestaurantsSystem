package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MenuList {
    public static boolean exportCsv(File file, List<String> dataList){//返回值为是否写入成功
        boolean isSucess=false;

        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    public static List<String> importCsv(File file){//读取数据返回值为全部数据，注意！第一行为表头
        List<String> dataList=new ArrayList<String>();

        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    public static List<Menu> getMenuList () {//使用方法List<Menu> menuList = MenuList.getMenuList();

        List<String> dataList=MenuList.importCsv(new File("src/Database/MenuList.csv"));
        List<Menu> menuList = new ArrayList<Menu>(dataList.size());
        if(dataList!=null && !dataList.isEmpty()){
            //打印所有数据
            for(int i=0; i<dataList.size();i++ ){
                if(i!=0){
                    String s=dataList.get(i);
                    //System.out.println("s  "+s);
                    menuList.add(new Menu(s));
                }
            }
        }
        return menuList;
    }

    public static List<String> setMenuList (List<Menu> mList){//使用方法boolean isSuccess=MenuList.exportCsv(new File("MenuList.csv"), MenuList.setMenuList(MenuList));
        List<String> dataList= new ArrayList<String>();
        List<Menu> menuList = new ArrayList<Menu>(MenuList.checkInventory(mList));
        if(menuList != null && !menuList.isEmpty()) {
            for(int i = 0; i < menuList.size()+1; i++) {
                if(i == 0) {
                    dataList.add("Type,Name,Level,Price,Sales,Inventory");
                }
                else {
                    String s = menuList.get(i-1).getType();s += ",";
                    s += menuList.get(i-1).getName();s += ",";
                    s += Integer.toString(menuList.get(i-1).getLevel());s += ",";
                    s += Integer.toString(menuList.get(i-1).getPrice());s += ",";
                    s += Integer.toString(menuList.get(i-1).getSales());s += ",";
                    s += Integer.toString(menuList.get(i-1).getInventory());
                    dataList.add(s);
                }
            }
        }

        return dataList;
    }

    public static int getAddonePrice (String name) {//用法 getAddonePrice("Nori")
        String type = "AddOne";
        List<Menu> menuList = MenuList.getMenuList();
        if(menuList != null && !menuList.isEmpty()) {
            for(int i = 0; i < menuList.size()+1; i++) {
                if(menuList.get(i).getType().equals(type)) {
                    if(menuList.get(i).getName().equals(name)) {
                        return menuList.get(i).getPrice();
                    }
                }
            }
        }
        return -1;
    }

    public static List<Menu> checkInventory (List<Menu> menuList) {//使用方法List<Menu> menuList = new ArrayList<Menu>(MenuList.checkInventory(mList));
        if(menuList != null && !menuList.isEmpty()) {
            for(int i = 0; i < menuList.size(); i++) {
                if(menuList.get(i).getInventory() >= 0) {
                    for(int j = 0; j < menuList.size(); j++) {
                        if(menuList.get(j).getName().equals(menuList.get(i).getName())) {
                            if(menuList.get(j).getInventory()*menuList.get(j).getLevel() < menuList.get(i).getInventory()*menuList.get(i).getLevel()) {
                                menuList.get(i).setInventory(menuList.get(j).getInventory()*menuList.get(j).getLevel() / menuList.get(i).getLevel());
                            }
                            else {
                                menuList.get(j).setInventory(menuList.get(i).getInventory()*menuList.get(i).getLevel() / menuList.get(j).getLevel());
                            }
                        }
                    }
                }
            }
        }
        return menuList;
    }

    public static void main(String[] args){
        List<Menu> menuList = MenuList.getMenuList();
        boolean isSuccess=MenuList.exportCsv(new File("MenuList.csv"), MenuList.setMenuList(menuList));


    }

}
