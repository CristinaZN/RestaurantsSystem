package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

/**
 * @ClassName: CheckCusLog
 * @description: read and search menu from the database
 */
public class MenuList {
    public static boolean exportCsv(File file, List<String> dataList){//success-true
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

    public static List<String> importCsv(File file){//read all the data
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

    public static List<Menu> getMenuList () {//List<Menu> menuList = MenuList.getMenuList();

        List<String> dataList=MenuList.importCsv(new File("src/Database/MenuList.csv"));
        List<Menu> menuList = new ArrayList<Menu>(dataList.size());
        if(dataList!=null && !dataList.isEmpty()){
            //print all the data
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

    public static List<String> setMenuList (List<Menu> menuList){//boolean isSuccess=MenuList.exportCsv(new File("MenuList.csv"), MenuList.setMenuList(MenuList));
        List<String> dataList= new ArrayList<String>();
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

    public static int getAddonePrice (String name) {//getAddonePrice("Nori")
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

    public static List<Menu> checkInventory (List<Menu> menuList) {//List<Menu> menuList = new ArrayList<Menu>(MenuList.checkInventory(mList));
        if(menuList != null && !menuList.isEmpty()) {
            for(int i = 0; i < menuList.size(); i++) {
                if(menuList.get(i).getInventory() >= 0 && menuList.get(i).getSales() != 0) {
                    for(int j = 0; j < menuList.size(); j++) {
                        if(menuList.get(j).getName().equals(menuList.get(i).getName())) {
                            menuList.get(j).setInventory(round(menuList.get(j).getInventory() - menuList.get(i).getSales() / menuList.get(j).getLevel()));
                        }
                    }
                }
            }
        }
        return menuList;
    }

    public static void main(String[] args){

    }

}
