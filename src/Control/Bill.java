package Control;

import java.io.File;
import java.util.List;

public class Bill {
    //membershipNumber,password,firstName,surname,email,phoneNumber,isAdmin,virtualStamps
    String BillNumber;
    int MembershipNumber;
    String Data;
    double Price;
    int Payment;
    boolean TakeOut;

    public Bill (String s) {
        String[] as = s.split(",");
        this.setBillNumber(as[0]);
        this.setMenbershipNumber(Integer.parseInt(as[1]));
        this.setData(as[2]);
        this.setPrice(Double.valueOf(as[3]));
        this.setPayment(Integer.parseInt(as[4]));
        this.setTakeOut(as[5].equals("true"));
    }

    public Bill() {

    }

    public void setBillNumber (String m) {
        this.BillNumber = m;
    }

    public void setMenbershipNumber (int m) {
        this.MembershipNumber = m;
    }

    public void setData (String d) {
        this.Data = d;
    }

    public void setPrice (double v) {
        this.Price = v;
    }

    public void setPayment (int i) {
        this.Payment = i;
    }

    public void setTakeOut (boolean i) {
        this.TakeOut = i;
    }

    public String getBillNumber () {
        return this.BillNumber;
    }

    public int getMenbershipNumber () {
        return this.MembershipNumber;
    }

    public String getData () {
        return this.Data;
    }

    public double getPrice () {
        return this.Price;
    }

    public int getPayment () {
        return this.Payment;
    }

    public boolean getTakeOut () {
        return this.TakeOut;
    }

    public void  setOrder(List<String> order){//用法，Bill.setOrder(所有信息的list);信息顺序为订单号，会员号，日期，价格，交易方式，是否外带。
        Bill newBill = new Bill();
        newBill.setBillNumber(order.get(0));
        newBill.setMenbershipNumber(Integer.parseInt(order.get(1)));
        newBill.setData(order.get(2));//格式yyyy-mm-dd
        newBill.setPrice(Double.valueOf(order.get(3)));
        newBill.setPayment(Integer.parseInt(order.get(4)));//如果现金，为0，如果刷卡，为1，如果是用virtualStamps，则为2，
        newBill.setTakeOut(order.get(5).equals("true"));

        List<Bill> billList = BillList.getBillList();
        billList.add(newBill);
        BillList.exportCsv(new File("src/Database/BillList.csv"),BillList.setBillList(billList));
    }

}




