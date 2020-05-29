package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import Entity.*;

/**
 * ClassName: PrintTicket
 * description: generate the ticket as txt
 */

public class PrintTicket
{
    private Customer customer;
    private PrintData prt;
    private List<String> bill;

    private String loyaltyNum;
    private String firstName;
    private String lastName;
    private int vStamp;
    private int dishNum;
    private String orderNum;
    private int method;
    private Boolean istakeout;
    private double price;

    //instructor need 3 arguments, a customer instance, a int identify payment method
    //and a boolean identify eat-in or take-out
    public PrintTicket(Customer cusInfo, int method, Boolean isTakeOut){
        this.customer = cusInfo;
        this.method = method;
        this.istakeout = isTakeOut;
    }

    // method to print ticket
    public void printTic() throws IOException{

        // degine 3 kinds of data format
        SimpleDateFormat datePtrn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat billdatePtrn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat orderDatePtrn = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = datePtrn.format(new Date());
        String billTime = billdatePtrn.format(new Date());

        //generate order number
        orderNum = orderDatePtrn.format(new Date()) + customer.getLoyaltyNum();

        //creat txt file
        prt = new PrintData("src/Database/Ticket/");
        prt.creatTxt(orderNum);

        loyaltyNum = customer.getLoyaltyNum();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        vStamp = customer.getVStamp();
        dishNum = customer.getDishNum();

        //content of the ticket
        prt.writeTxt("Welcome to the restaurant " + firstName + lastName);
        prt.writeTxt("Order Number : " + orderNum);
        prt.writeTxt("Date : " + time);
        prt.writeTxt("Loyalty Number : " + loyaltyNum);
        prt.writeTxt("Your have been order :");

        // if customer have 10 more virtual ticket, they can get a free dish
        if(vStamp < 10){
            customer.update();
        }
        else{
            customer.clearVStamp();
            customer.update();
            dishNum --;
            method = 3;
        }

        //print all the dish ordered by customer and calculate total price
        for(int i = 1; i <= dishNum; i++){
            Dish dish = customer.getOrder(i);
            if(dish.isIsvalid()){
                price = price + dish.calculationPrice();
                prt.writeTxt(dish.getNoodles() + "     " + dish.calculationPrice());
                dish.updateSale();
                customer.incVStamp();
            }
        }

        // update new number of virtual stamps to the database
        if(customer.getLoyaltyNum() != "00000000"){
            customer.update();
        }

        prt.writeTxt("Total Price : " + price);
        prt.writeTxt("Number of Virtual Stamp : " + customer.getVStamp());

        if(method == 0){
            if(istakeout == true){
                prt.writeTxt("Take out   By Cash");
            }
            else prt.writeTxt("Eat in   By Cash");
        }
        else if(method == 1){
            if(istakeout == true){
                prt.writeTxt("Take out   By Card");
            }
            else prt.writeTxt("Eat in   By Card");
        }
        else{
            if(istakeout == true){
                prt.writeTxt("Take out   By Virtual Stamp");
            }
            else prt.writeTxt("Eat in   By Virtual Stamp");
        }

        //generate an arraylist used to update bills to database
        bill = new ArrayList<String>();
        bill.add(orderNum);
        System.out.println(bill.get(0));
        bill.add(loyaltyNum);
        bill.add(billTime);
        bill.add(String.valueOf(price));
        bill.add(String.valueOf(method));
        if(istakeout){
            bill.add("true");
        }else bill.add("false");

        //update bill information to database
        Bill billins = new Bill();
        billins .setOrder(bill);
    }
}