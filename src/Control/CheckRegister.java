package Control;

import Control.User;
import Control.UserList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: CheckRegister
 * description: Used to check the data format when user creat an account
 */
public class CheckRegister {
    private User user;
    List<User> userList = UserList.getUserList();
    private  String saccount;
    private List<String> newUser = new ArrayList <String>();//Used for storing all new users' information


    public String assignAccount(){//Assign 8 bits number randomly as loyalty number
        while (true) {
            int account = (int) ((Math.random() * 9 + 1) * 10000000);
            saccount = String.valueOf(account);
            if (!user.findUserNum(saccount)) {
                break;
            }
        }
        return saccount;
    }

    public boolean isPhone(String phone){//Validate if the format of mobile phone is correct
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        boolean isMatch;
        if(phone.length()!=11){
            return false;
        }
        else{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            isMatch = m.matches();
            if(!isMatch)
                return false;
            else {
                return true;
            }
        }
    }

    public boolean isEmail(String email){//Validate the format of email
        String regex = "^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(regex);
        Matcher m=p.matcher(email);
        if(m.matches()){
            return true;
        }else
            return false;
    }

    public boolean isPwd(char[] pwd){//Valid the format of password, the length should be between 8 and 16, must containing both character and digit.
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        String s=String .valueOf(pwd);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if(m.matches()){
            return true;
        }else
            return false;
    }

    public boolean reCheck(char[] pwd, char[] repwd){//Re-input password
        if(!new String(pwd).equals(new String(repwd))){
            return false;
        }
        else
            return true;
    }

    public boolean isName(String name){//Judge the format of name
        Pattern pattern = Pattern.compile("[0-9a-zA-Z\\u4E00-\\u9FA5]+");
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()) {
            return true;
        }
        else
            return false;
    }
    public void saveData(String s){//Store the data into CSV file
        User nuser = new User(s);
        userList.add(nuser);
        UserList.exportCsv(new File("src/Database/UserList.csv"), UserList.setUserList(userList));
    }
}
