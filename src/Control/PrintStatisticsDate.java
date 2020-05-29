package Control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PrintStatisticsDate {
    /**
     * ClassName: PrintStatisticDate
     * description: creat and store the statistic information in database
     */

    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        Calendar cal = Calendar.getInstance(); // Acquire a calender 
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // someday in a week
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static void printWeekBill()throws IOException {//PrintStatisticsDate.printWeekBill(date);yyyy-mm-dd
        Date date=new Date();//read time
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = formatter.format(date);
        PrintData ptr = new PrintData("src/Database/Statistics/");

        int thisWeek = 0;
        int lastWeek = 0;
        List<Bill> billList = BillList.getBillList();
        if(billList != null && !billList.isEmpty()) {
            for(int i = 0; i < billList.size(); i++) {
                if(i != 0) {
                    if(dateToWeek(datetime).equals(dateToWeek(billList.get(i).getData()))){
                        System.out.println(datetime);
                        System.out.println(billList.get(i).getData());
                        if (datetime.equals(billList.get(i).getData())){
                            thisWeek = i;
                        }
                        else {
                            lastWeek = i;
                        }
                    }
                }
            }
        }
        ptr.creatTxt("Bill for" + billList.get(thisWeek).getData() + "to" + billList.get(lastWeek).getData());
        System.out.println(lastWeek);
        System.out.println(thisWeek);
        for(int i = 0; i < billList.size(); i++) {
            if(i >= lastWeek && i <= thisWeek) {
                ptr.writeTxt("Order Number : " + billList.get(i).getBillNumber());

                ptr.writeTxt("Date : " + billList.get(i).getData());
                ptr.writeTxt("Loyalty Number : " + billList.get(i).getMenbershipNumber());
                ptr.writeTxt("Total Price : " + billList.get(i).getPrice());
                if(billList.get(i).getPayment() == 0){
                    if(billList.get(i).getTakeOut()){
                        ptr.writeTxt("Take out   By Cash");
                    }
                    else ptr.writeTxt("Eat in   By Cash");
                }
                else if(billList.get(i).getPayment() == 1){
                    if(billList.get(i).getTakeOut()){
                        ptr.writeTxt("Take out   By Card");
                    }
                    else ptr.writeTxt("Eat in   By Card");
                }
                else{
                    if(billList.get(i).getTakeOut()){
                        ptr.writeTxt("Take out   By Virtual Stamp");
                    }
                    else ptr.writeTxt("Eat in   By Virtual Stamp");
                }
                ptr.writeTxt("\n");
            }
        }
    }

    public static String showWeekBill()throws IOException {//PrintStatisticsDate.printWeekBill(date);yyyy-mm-dd
        Date date=new Date();//read time
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String datetime = formatter.format(date);
        System.out.println(date);
        int thisWeek = 0;
        int lastWeek = 0;
        List<Bill> billList = BillList.getBillList();
        if(billList != null && !billList.isEmpty()) {
            for(int i = 0; i < billList.size(); i++) {
                if(i != 0) {
                    if(dateToWeek(datetime).equals(dateToWeek(billList.get(i).getData()))){

                        if (datetime.equals(billList.get(i).getData())){
                            thisWeek = i;
                        }
                        else {
                            lastWeek = i;
                        }
                    }
                }
            }
        }


        StringBuilder list = new StringBuilder();
        for(int i = 0; i < billList.size(); i++) {
            if(i >= lastWeek && i <= thisWeek) {

                list.append("Order Number : ").append(billList.get(i).getBillNumber()).append("\n");
                list.append("Date : ").append(billList.get(i).getData()).append("\n");
                list.append("Loyalty Number : ").append(billList.get(i).getMenbershipNumber()).append("\n");
                list.append("Total Price : ").append(billList.get(i).getPrice()).append("\n");
                if(billList.get(i).getPayment() == 0){
                    if(billList.get(i).getTakeOut()){
                        list.append("Take out   By Cash" + "\n");
                    }
                    else list.append("Eat in   By Cash" + "\n");
                }
                else if(billList.get(i).getPayment() == 1){
                    if(billList.get(i).getTakeOut()){
                        list.append("Take out   By Card" + "\n");
                    }
                    else list.append("Eat in   By Card" + "\n");
                }
                else{
                    if(billList.get(i).getTakeOut()){
                        list.append("Take out   By Virtual Stamp" + "\n");
                    }
                    else list.append("Eat in   By Virtual Stamp" + "\n");
                }
            }
        }


        return list.toString();
    }


    public static String showBeastSale()throws IOException {//PrintStatisticsDate.printBeastSale();
        StringBuilder list = new StringBuilder();
        List<Menu> menuList = MenuList.getMenuList();
        int temp = 0;
        if (menuList != null && !menuList.isEmpty()) {
            for (int i = 0; i < menuList.size(); i++) {
                if (menuList.get(i).getType().equals("Soup")) {
                    if (temp == 0) {
                        temp = i;
                    } else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Soup")) {
                        list.append("Best sale in").append(menuList.get(i).getType()).append(" : ").append(menuList.get(temp).getName()+ "\n");
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("Noodles")) {
                    if (temp == 0) {
                        temp = i;
                    } else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Noodles")) {
                        list.append("Best sale in" + menuList.get(i).getType() + " : " + menuList.get(temp).getName()+ "\n");
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("Onion")) {
                    if (temp == 0) {
                        temp = i;
                    } else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Onion")) {
                        if (menuList.get(temp).getName().equals("No")) {
                            list.append("Best sale in" + menuList.get(i).getType() + " : " + menuList.get(temp).getName()+ "\n");
                        } else if (menuList.get(temp).getLevel() == 2) {
                            list.append("Best sale in" + menuList.get(i).getType() + " : Lot"+ "\n");
                        } else {
                            list.append("Best sale in" + menuList.get(i).getType() + " : Little"+ "\n");

                        }
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("Nori")) {
                    if (temp == 0) {
                        temp = i;
                    }
                    else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Nori")) {
                        if (menuList.get(temp).getName().equals("No")) {
                            list.append("Best sale in" + menuList.get(i).getType() + " : No" + "\n");
                        } else {
                            list.append("Best sale in" + menuList.get(i).getType() + " : " + menuList.get(temp).getName()+ "\n");
                        }
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("Chashu")) {
                    if (temp == 0) {
                        temp = i;
                    } else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Chashu")) {
                        if (menuList.get(temp).getName().equals("No")) {
                            list.append("Best sale in" + menuList.get(i).getType() + " : No"+ "\n");
                        } else {
                            list.append("Best sale in" + menuList.get(i).getType() + " : "+ menuList.get(temp).getName()+ "\n");
                        }
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("Egg")) {
                    if (temp == 0) {
                        temp = i;
                    } else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Egg")) {
                        if (menuList.get(temp).getName().equals("No")) {
                            list.append("Best sale in" + menuList.get(i).getType() + " : No"+ "\n");
                        } else {
                            list.append("Best sale in" + menuList.get(i).getType() + " : " + menuList.get(temp).getName()+ "\n");
                        }
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("Spiciness")) {
                    if (temp == 0) {
                        temp = i;
                    } else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                    if (!menuList.get(i + 1).getType().equals("Spiciness")) {
                        list.append("Best sale in" + menuList.get(i).getType() + " : " + menuList.get(temp).getLevel()+ "\n");
                        temp = 0;
                    }
                }
                if (menuList.get(i).getType().equals("AddOne")) {
                    if (temp == 0) {
                        temp = i;
                    }
                    else {
                        if (menuList.get(i).getSales() > menuList.get(temp).getSales()) {
                            temp = i;
                        }
                    }
                }
            }
            list.append("Best sale in" + menuList.get(temp).getType() + " : " + menuList.get(temp).getName()+ "\n");
            temp = 0;
        }
        return list.toString();
    }
}
