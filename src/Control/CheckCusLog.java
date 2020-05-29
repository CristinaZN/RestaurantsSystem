package Control;

import Control.User;
import java.util.*;
/**
 * ClassName: CheckCusLog
 * description: Used to check customer login information, and generate a list contain information
 */
public class CheckCusLog {

    List<String> userInfo = new ArrayList <String>();//The information of this user

    public List<String> isAccount(String account){//Check if this loyalty number exists in CSV file
        if (account==null){
            return null;
        }
        boolean isAccount = User.findUserNum(account);
        if(isAccount){
            userInfo = User.findUser(account);//Other information of this user found by loyalty number
            return userInfo;
        }else
            return null;
    }

    public boolean isPwd(String pwd,List<String> userInfo){//Validate the password
        if(userInfo.get(1).equals(pwd))
            return true;
        else
            return false;
    }

    public boolean isStaff(List<String> userInfo){
        if(userInfo.get(6).equals("false")){
            System.out.println(userInfo.get(6));
            return false;
        }
        else{
            System.out.println(userInfo.get(6));
            return true;
        }
    }

    public List<String> returnUserInfo(){

        return userInfo;
    }

}
