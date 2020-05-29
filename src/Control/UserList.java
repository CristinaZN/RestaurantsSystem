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

/**
 * @ClassName: UserList
 * @description: read and search user from the database
 */

public class UserList {

    public static boolean exportCsv(File file, List<String> dataList){//r
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


    public static List<String> importCsv(File file){//read all the data from database
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

    public static List<User> getUserList () {//List<User> userList = UserList.getUserList();

        List<String> dataList=UserList.importCsv(new File("src/Database/UserList.csv"));
        List<User> userList = new ArrayList<User>(dataList.size());
        if(dataList!=null && !dataList.isEmpty()){
            //print all the data
            System.out.println("1");
            for(int i=0; i<dataList.size();i++ ){
                if(i!=0){
                    String s=dataList.get(i);
                    //System.out.println("s  "+s);
                    userList.add(new User(s));
                }
            }
        }
        return userList;
    }

    public static List<String> setUserList (List<User> userList){//boolean isSuccess=UserList.exportCsv(new File("UserList.csv"), UserList.setUserList(userList));
        List<String> dataList=new ArrayList<String>();
        System.out.println(userList != null && !userList.isEmpty());
        if(userList != null && !userList.isEmpty()) {
            for(int i = 0; i < userList.size()+1; i++) {
                if(i == 0) {
                    dataList.add("membershipNumber,password,Name,email,phoneNumber,isAdmin,virtualStamps");
                }
                else {
                    String s = Integer.toString(userList.get(i-1).getMembershipNumber());s += ",";
                    s += userList.get(i-1).getPassword();s += ",";
                    s += userList.get(i-1).getFirstName();s += ",";
                    s += userList.get(i-1).getSurName();s += ",";
                    s += userList.get(i-1).getEmail();s += ",";
                    s += userList.get(i-1).getPhoneNumber();s += ",";
                    if(userList.get(i-1).getIsAdmin()) {
                        s += "true,";
                    }
                    else {
                        s += "false,";
                    }
                    s += Integer.toString(userList.get(i-1).getVirtualStamps());
                    dataList.add(s);
                }
            }
        }


        return dataList;
    }



    public static void main(String[] args){
        List<User> userList = UserList.getUserList();
        boolean isSuccess=UserList.exportCsv(new File("src/Database/UserList.csv"), UserList.setUserList(userList));
    }

/*for test
//read all info
    public static void importCsv()  {
        List<String> dataList=UserList.importCsv(new File("UserList.csv"));
        if(dataList!=null && !dataList.isEmpty()){
        	//print all info
            for(int i=0; i<dataList.size();i++ ){
                if(i!=0){
                    String s=dataList.get(i);
                    //System.out.println("s  "+s);
                      String[] as = s.split(",");
                      System.out.println(as[0]);
                      System.out.println(as[1]);
                      System.out.println(as[2]);
					  System.out.println(as[3]);
					  System.out.println(as[4]);
					  System.out.println(as[5]);
					  System.out.println(as[6]);
					  System.out.println(as[7]);
                }
            }
        }
    }*/

    //write to database
    public static void exportCsv() {
        List<String> dataList=new ArrayList<String>();
        dataList.add("membershipNumber,password,firstName,surnName,email,phoneNumber,isAdmin,virtualStamps");
        dataList.add("12345678,123456,San,Zhang,110@qq.com,12345678910,true,0");
        dataList.add("87654321,654321,Si,Li,120@qq.com,01987654321,false,5");
        dataList.add("12365478,111111,Wu,Wang,119@qq.com,11111111111,false,9");
        boolean isSuccess=UserList.exportCsv(new File("UserList.csv"), dataList);
        System.out.println(isSuccess);
    }

}

