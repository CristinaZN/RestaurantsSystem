package Control;

import java.util.*;

//membershipNumber,password,firstName,surname,email,phoneNumber,isAdmin,virtualStamps
/**
 * ClassName: User
 * description: store user information from the database
 */

public class User {
    int membershipNumber;
    String password;
    String firstName;
    String surName;
    String email;
    String phoneNumber;
    boolean isAdmin;
    int virtualStamps;

    public User (String s) {
        String[] as = s.split(",");
        this.setMembershipNumber(Integer.parseInt(as[0]));
        this.setPassword(as[1]);
        this.setFirstName(as[2]);
        this.setSurName(as[3]);
        this.setEmail(as[4]);
        this.setPhoneNumber(as[5]);
        this.setIsAdmin(as[6].equals("true"));
        this.setVirtualStamps(Integer.parseInt(as[7]));
    }

    public static boolean findUserNum (String lNum) {
        List<User> userList = UserList.getUserList();
        if(userList != null && !userList.isEmpty()) {
            for(int i = 0; i < userList.size()+1; i++) {
                if(i != 0) {
                    if(lNum.equals(Integer.toString(userList.get(i-1).getMembershipNumber()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean findUserName (String firstName,String surName) {
        List<User> userList = UserList.getUserList();//user list
        if(userList != null && !userList.isEmpty()) {//list
            for(int i = 0; i < userList.size()+1; i++) {
                if(i != 0) {
                    if(firstName.equals(userList.get(i-1).getFirstName())) {
                        if(surName.equals(userList.get(i-1).getSurName())) {
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    public static List<String> findUser (String lNum){//
        List<String> user = new ArrayList<String>();
        List<User> userList = UserList.getUserList();//user list
        if(userList != null && !userList.isEmpty()) {//list
            for(int i = 0; i < userList.size()+1; i++) {
                if(i != 0) {
                    if(lNum.equals(Integer.toString(userList.get(i-1).getMembershipNumber()))) {
                        user.add(Integer.toString(userList.get(i-1).getMembershipNumber()));
                        user.add(userList.get(i-1).getPassword());
                        user.add(userList.get(i-1).getFirstName());
                        user.add(userList.get(i-1).getSurName());
                        user.add(userList.get(i-1).getEmail());
                        user.add(userList.get(i-1).getPhoneNumber());
                        if(userList.get(i-1).getIsAdmin()) {
                            user.add("true");
                        }
                        else {
                            user.add("false");
                        }
                        user.add(Integer.toString(userList.get(i-1).getVirtualStamps()));
                        return user;
                    }
                }
            }
        }
        return null;
    }

    public List<String> findUserByName (String firstName,String surName){
        List<String> user = new ArrayList<String>();
        List<User> userList = UserList.getUserList();//user list
        if(userList != null && !userList.isEmpty()) {//list
            for(int i = 0; i < userList.size()+1; i++) {
                if(i != 0) {
                    if(firstName.equals(userList.get(i-1).getFirstName())){
                        if(surName.equals(userList.get(i-1).getSurName())) {
                            user.add(Integer.toString(userList.get(i-1).getMembershipNumber()));
                            user.add(userList.get(i-1).getPassword());
                            user.add(userList.get(i-1).getFirstName());
                            user.add(userList.get(i-1).getSurName());
                            user.add(userList.get(i-1).getEmail());
                            user.add(userList.get(i-1).getPhoneNumber());
                            if(userList.get(i-1).getIsAdmin()) {
                                user.add("true");
                            }
                            else {
                                user.add("false");
                            }
                            user.add(Integer.toString(userList.get(i-1).getVirtualStamps()));
                            return user;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void setMembershipNumber (int m) {
        this.membershipNumber = m;
    }

    public void setPassword (String p) {
        this.password = p;
    }

    public void setFirstName (String fN) {
        this.firstName = fN;
    }

    public void setSurName (String sN) {
        this.surName = sN;
    }

    public void setEmail (String e) {
        this.email = e;
    }

    public void setPhoneNumber (String p) {
        this.phoneNumber = p;
    }

    public void setIsAdmin (boolean i) {
        this.isAdmin = i;
    }

    public void setVirtualStamps (int v) {
        this.virtualStamps = v;
    }

    public int getMembershipNumber () {
        return this.membershipNumber;
    }

    public String getPassword () {
        return this.password;
    }

    public String getFirstName () {
        return this.firstName;
    }

    public String getSurName () {
        return this.surName;
    }

    public String getEmail () {
        return this.email;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }


    public boolean getIsAdmin () {
        return this.isAdmin;
    }

    public int getVirtualStamps () {
        return this.virtualStamps;
    }


}
