package Control;

import java.io.File;
import java.util.List;

/**
 * ClassName: Menu
 * description: Store the menu information
 */
public class Menu {
    String type;
    String name;
    int level;
    int price;
    int sales;
    int inventory;

    public Menu (String s) {
        String[] as = s.split(",");
        this.setType(as[0]);
        this.setName(as[1]);
        this.setLevel(Integer.parseInt(as[2]));
        this.setPrice(Integer.parseInt(as[3]));
        this.setSales(Integer.parseInt(as[4]));
        this.setInventory(Integer.parseInt(as[5]));
    }

    public static String findAddOneName (int j) {
        List<Menu> menrList = MenuList.getMenuList();//user list
        int count= 0;
        if(menrList != null && !menrList.isEmpty()) {//list
            for(int i = 0; i < menrList.size()+1; i++) {
                if(i != 0) {
                    if(menrList.get(i).getType().equals("AddOne")) {
                        if( count == j){
                            return menrList.get(i).getName();
                        }
                        else count++;
                    }
                }
            }
        }
        return null;
    }

    public static int findAddOnePrice (int j) {
        List<Menu> menrList = MenuList.getMenuList();//user list
        int count= 0;
        if(menrList != null && !menrList.isEmpty()) {//list
            for(int i = 0; i < menrList.size()+1; i++) {
                if(i != 0) {
                    if(menrList.get(i).getType().equals("AddOne")) {
                        if( count == j){
                            return menrList.get(i).getPrice();
                        }
                        else count++;
                    }
                }
            }
        }
        return 0;
    }

    public void setType (String t) {
        this.type = t;
    }

    public void setName (String n) {
        this.name = n;
    }

    public void setLevel (int l) {
        this.level = l;
    }

    public void setPrice (int p) {
        this.price = p;
    }

    public void setSales (int s) {
        this.sales = s;
    }

    public void setInventory (int i) {
        this.inventory = i;
    }

    public String getType () {
        return this.type;
    }

    public String getName () {
        return this.name;
    }

    public int getLevel () {
        return this.level;
    }

    public int getPrice () {
        return this.price;
    }

    public int getSales () {
        return this.sales;
    }

    public int getInventory () {
        return this.inventory;
    }

    public static boolean findMenuName(String name) {//check is there a same name in database
        List<Menu> menuList = MenuList.getMenuList();
        if(menuList != null && !menuList.isEmpty()) {//list
            for(int i = 0; i < menuList.size()+1; i++) {
                if(i != 0) {
                    if(name.equals(menuList.get(i-1).getName())) {
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public static void changeMenuPrice(String name, int price) {//check is there a same name in database
        List<Menu> menuList = MenuList.getMenuList();
        if(menuList != null && !menuList.isEmpty()) {//list
            for(int i = 0; i < menuList.size()+1; i++) {
                if(i != 0) {
                    if(name.equals(menuList.get(i-1).getName())) {
                        menuList.get(i-1).setPrice(price);
                    }
                }
            }
        }
        MenuList.exportCsv(new File("src/Database/MenuList.csv"), MenuList.setMenuList(menuList));
    }

}
