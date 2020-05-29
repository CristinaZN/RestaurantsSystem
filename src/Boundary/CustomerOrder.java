package Boundary;

import Control.MenuList;
import Entity.Customer;
import Entity.Dish;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ClassName: CustomerOrder
 * description: This page is used by customers to order.
 */

public class CustomerOrder extends JFrame {

    private JPanel contentPane;
    private Customer customer;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerOrder frame = new CustomerOrder(new Customer());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create frame.
     * @param customer Ordering customer information
     */
    public CustomerOrder(Customer customer) {
        this.customer=customer;
        setTitle("Welcome guest!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 638, 709);
        contentPane = new JPanel();
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        //Set up contentPane.

        JPanel panel_N = new JPanel();
        panel_N.setBorder(new LineBorder(new Color(0, 0, 0)));
        contentPane.add(panel_N, BorderLayout.NORTH);
        panel_N.setLayout(new BorderLayout(0, 0));
        //Set up northern pane.

        JButton btnBack = new JButton("Back");
        btnBack.setHorizontalAlignment(SwingConstants.LEFT);
        btnBack.addActionListener(this::btnBackActionPerformed);
        panel_N.add(btnBack, BorderLayout.WEST);
        //Back button

        JLabel lblStamp = new JLabel("stamps:");
        lblStamp.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_N.add(lblStamp, BorderLayout.CENTER);
        JLabel lblStampNum = new JLabel(String.valueOf(customer.getVStamp()));
        panel_N.add(lblStampNum, BorderLayout.EAST);
        //User's virtual stamp information.

        JPanel panel_S = new JPanel();
        contentPane.add(panel_S, BorderLayout.SOUTH);
        panel_S.setLayout(new BorderLayout(0, 0));
        //Set up southern pane

        JButton btnCheck = new JButton("Check");
        btnCheck.addActionListener(this::btnCheckActionPerformed);
        panel_S.add(btnCheck, BorderLayout.EAST);
        //Check button

        JPanel panel_C = new JPanel();
        contentPane.add(panel_C, BorderLayout.CENTER);
        panel_C.setLayout(new GridLayout(0, 1, 0, 0));
        //Set central pane
        JPanel panel_Menu = new JPanel();
        panel_Menu.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_C.add(panel_Menu);
        panel_Menu.setLayout(new GridLayout(10, 0, 0, 0));
        //Set menu pane

        JLabel lbl_SingleDish = new JLabel("Single Dish  \u00A39.99");
        lbl_SingleDish.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Menu.add(lbl_SingleDish);
        //Single dish label

        JPanel panel_Soup = new JPanel();
        panel_Soup.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Soup);
        panel_Soup.setLayout(new GridLayout(0, 4, 0, 0));
        //Soup pane

        JLabel lbl_Soup = new JLabel("Soup");
        lbl_Soup.setBackground(new Color(0, 0, 0));
        lbl_Soup.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Soup.add(lbl_Soup);
        //soup的label
        JRadioButton rdbtn_Soup1 = new JRadioButton("Tonkotsu");
        rdbtn_Soup1.setActionCommand("Tonkotsu");
        panel_Soup.add(rdbtn_Soup1);
        //Tonkoutsu Soup

        JRadioButton rdbtn_Soup2 = new JRadioButton("Shoyu");
        rdbtn_Soup2.setActionCommand("Shoyu");
        rdbtn_Soup2.setSelected(true);
        panel_Soup.add(rdbtn_Soup2);
        //Shoyu soup

        JRadioButton rdbtn_Soup3 = new JRadioButton("Shio");
        rdbtn_Soup3.setActionCommand("Shio");
        panel_Soup.add(rdbtn_Soup3);
        //Shio soup

        ButtonGroup group1=new ButtonGroup();
        group1.add(rdbtn_Soup1);
        group1.add(rdbtn_Soup2);
        group1.add(rdbtn_Soup3);
        //Single choice

        JPanel panel_Noodles = new JPanel();
        panel_Noodles.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Noodles);
        panel_Noodles.setLayout(new GridLayout(0, 4, 0, 0));
        //Panel for selecting noodles
        JLabel lbl_Noodles = new JLabel("Noodles");
        lbl_Noodles.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Noodles.add(lbl_Noodles);
        //label for selecting noodles
        JRadioButton rdbtn_Noodles1 = new JRadioButton("Soft");
        rdbtn_Noodles1.setActionCommand("Soft");
        rdbtn_Noodles1.setSelected(true);
        panel_Noodles.add(rdbtn_Noodles1);
        //Soft noodles

        JRadioButton rdbtn_Noodles2 = new JRadioButton("Medium");
        rdbtn_Noodles2.setActionCommand("Medium");
        panel_Noodles.add(rdbtn_Noodles2);
        //Medium noodles

        JRadioButton rdbtn_Noodles3 = new JRadioButton("Firm");
        rdbtn_Noodles3.setActionCommand("Firm");
        panel_Noodles.add(rdbtn_Noodles3);
        //Firm noodles

        ButtonGroup group2=new ButtonGroup();
        group2.add(rdbtn_Noodles1);
        group2.add(rdbtn_Noodles2);
        group2.add(rdbtn_Noodles3);
        //Single choice

        JPanel panel_Spring = new JPanel();
        panel_Spring.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Spring);
        panel_Spring.setLayout(new GridLayout(0, 4, 0, 0));
        //Panel for selecting spring onion

        JLabel lbl_Spring = new JLabel("Spring onion");
        lbl_Spring.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Spring.add(lbl_Spring);
        //label for selecting spring onion

        JRadioButton rdbtn_Spring1 = new JRadioButton("No please");
        rdbtn_Spring1.setActionCommand("No");
        rdbtn_Spring1.setSelected(true);
        panel_Spring.add(rdbtn_Spring1);
        //No spring onion.

        JRadioButton rdbtn_Spring2 = new JRadioButton(" A little");
        rdbtn_Spring2.setActionCommand("Little");
        panel_Spring.add(rdbtn_Spring2);
        //A little spring onion.

        JRadioButton rdbtn_Spring3 = new JRadioButton("A lot!");
        rdbtn_Spring3.setActionCommand("Lot");
        panel_Spring.add(rdbtn_Spring3);
        //A lot of spring onion.

        ButtonGroup group3=new ButtonGroup();
        group3.add(rdbtn_Spring1);
        group3.add(rdbtn_Spring2);
        group3.add(rdbtn_Spring3);
        //Single choice

        JPanel panel_adds = new JPanel();
        panel_adds.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_adds);
        panel_adds.setLayout(new GridLayout(0, 4, 0, 0));
        //Adds on

        JLabel lbl_Adds = new JLabel("Adds");
        panel_adds.add(lbl_Adds);
        lbl_Adds.setBorder(BorderFactory.createLineBorder(Color.black));
        //label
        JCheckBox chckbx_Nori = new JCheckBox("Nori");
        panel_adds.add(chckbx_Nori);
        //Nori

        JCheckBox chckbx_Chashu = new JCheckBox("Chashu");
        panel_adds.add(chckbx_Chashu);
        //chashu
        JCheckBox chckbx_Egg = new JCheckBox("Boiled egg");
        panel_adds.add(chckbx_Egg);
        //Bolied egg

        JPanel panel_Spiciness = new JPanel();
        panel_Spiciness.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_Spiciness);
        panel_Spiciness.setLayout(new GridLayout(0, 7, 0, 0));
        //Panel for selecting spiciness

        JLabel lbl_Spiciness = new JLabel("Spiciness");
        lbl_Spiciness.setBackground(Color.RED);
        lbl_Spiciness.setBorder(BorderFactory.createLineBorder(Color.black));
        panel_Spiciness.add(lbl_Spiciness);
        //Label for selecting spiciness

        JRadioButton rdbtn_Spiciness0 = new JRadioButton("0(No)");
        rdbtn_Spiciness0.setActionCommand("0");
        rdbtn_Spiciness0.setSelected(true);
        panel_Spiciness.add(rdbtn_Spiciness0);
        //no
        JRadioButton rdbtn_Spiciness1 = new JRadioButton("1");
        rdbtn_Spiciness1.setActionCommand("1");
        panel_Spiciness.add(rdbtn_Spiciness1);
        //1
        JRadioButton rdbtn_Spiciness2 = new JRadioButton("2");
        rdbtn_Spiciness2.setActionCommand("2");
        panel_Spiciness.add(rdbtn_Spiciness2);
        //2
        JRadioButton rdbtn_Spiciness3 = new JRadioButton("3");
        rdbtn_Spiciness3.setActionCommand("3");
        panel_Spiciness.add(rdbtn_Spiciness3);
        //3
        JRadioButton rdbtn_Spiciness4 = new JRadioButton("4");
        rdbtn_Spiciness4.setActionCommand("4");
        panel_Spiciness.add(rdbtn_Spiciness4);
        //4
        JRadioButton rdbtn_Spiciness5 = new JRadioButton("5(Max)");
        rdbtn_Spiciness5.setActionCommand("5");
        panel_Spiciness.add(rdbtn_Spiciness5);
        //max
        ButtonGroup group4=new ButtonGroup();
        group4.add(rdbtn_Spiciness0);
        group4.add(rdbtn_Spiciness1);
        group4.add(rdbtn_Spiciness2);
        group4.add(rdbtn_Spiciness3);
        group4.add(rdbtn_Spiciness4);
        group4.add(rdbtn_Spiciness5);
        //Single choice

        JLabel lbl_Addson = new JLabel("Adds on");
        panel_Menu.add(lbl_Addson);
        //adds on label
        JPanel panel_addson1 = new JPanel();
        panel_addson1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_addson1);
        panel_addson1.setLayout(new GridLayout(0, 2, 0, 0));
        //first adds on panel
        JPanel panel_Nori = new JPanel();
        panel_Nori.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson1.add(panel_Nori);
        //Nori panel
        JLabel lbl_XrNori = new JLabel("Extra Nori(\u00A3"+ MenuList.getAddonePrice("Nori") + " )");
        panel_Nori.add(lbl_XrNori);
        JLabel lbl_NoriNum = new JLabel("0");
        //Nori Num
        JButton btnAdd1 = new JButton("+1");
        btnAdd1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_NoriNum.getText());
                num++;
                lbl_NoriNum.setText(String.valueOf(num));
            }
        });
        panel_Nori.add(btnAdd1);
        //+1 button
        panel_Nori.add(lbl_NoriNum);
        //add label
        JButton btn_Reduce1 = new JButton("-1");
        btn_Reduce1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_NoriNum.getText());
                if(num>0)
                    num--;
                lbl_NoriNum.setText(String.valueOf(num));
            }
        });
        panel_Nori.add(btn_Reduce1);
        //-1 button
        JPanel panel_egg = new JPanel();
        panel_egg.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson1.add(panel_egg);
        //Extra boiled egg
        JLabel lbl_egg = new JLabel("Extra boiled egg(\u00A3"+ MenuList.getAddonePrice("Egg") + " )");
        panel_egg.add(lbl_egg);
        //Extra boiled egg label
        JButton btn_Add2 = new JButton("+1");
        JLabel lbl_EggNum = new JLabel("0");
        btn_Add2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_EggNum.getText());
                num++;
                lbl_EggNum.setText(String.valueOf(num));
            }
        });
        panel_egg.add(btn_Add2);
        //+1 button
        panel_egg.add(lbl_EggNum);
        //Number of boiled eggs

        JButton btn_Reduce2 = new JButton("-1");
        btn_Reduce2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_EggNum.getText());
                if(num>0)
                    num--;
                lbl_EggNum.setText(String.valueOf(num));
            }
        });
        panel_egg.add(btn_Reduce2);
        //-1 button

        JPanel panel_addson2 = new JPanel();
        panel_addson2.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Menu.add(panel_addson2);
        panel_addson2.setLayout(new GridLayout(0, 2, 0, 0));
        //Second adds on panel
        JPanel panel_Bamboo = new JPanel();
        panel_Bamboo.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson2.add(panel_Bamboo);
        //panel of bamboo shoots
        JLabel lbl_Bamboo = new JLabel("Bamboo shoots(\u00A3"+ MenuList.getAddonePrice("Bamboo") + ")");
        panel_Bamboo.add(lbl_Bamboo);
        //label of bamboo shoots
        JLabel lbl_BambooNum = new JLabel("0");
        JButton btnAdd3 = new JButton("+1");
        btnAdd3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_BambooNum.getText());
                num++;
                lbl_BambooNum.setText(String.valueOf(num));
            }
        });
        panel_Bamboo.add(btnAdd3);
        //+1 button
        panel_Bamboo.add(lbl_BambooNum);
        //number of bamboo shoots

        JButton btn_reduce3 = new JButton("-1");
        btn_reduce3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_BambooNum.getText());
                if(num>0)
                    num--;
                lbl_BambooNum.setText(String.valueOf(num));
            }
        });
        panel_Bamboo.add(btn_reduce3);
        //-1button

        JPanel panel_Chashu = new JPanel();
        panel_Chashu.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_addson2.add(panel_Chashu);
        panel_Chashu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        //chashu panel
        JLabel lbl_Chashu = new JLabel("Extra Chashu(\u00A3"+ MenuList.getAddonePrice("Chashu") + ")");
        panel_Chashu.add(lbl_Chashu);
        //chashu label
        JLabel lbl_ChashuNum = new JLabel("0");
        JButton btn_Add4 = new JButton("+1");
        btn_Add4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_ChashuNum.getText());
                num++;
                lbl_ChashuNum.setText(String.valueOf(num));
            }
        });
        panel_Chashu.add(btn_Add4);
        //+1 button

        panel_Chashu.add(lbl_ChashuNum);
        //chashu Num

        JButton btn_redece = new JButton("-1");
        btn_redece.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int num=Integer.parseInt(lbl_ChashuNum.getText());
                if(num>0)
                    num--;
                lbl_ChashuNum.setText(String.valueOf(num));

            }});
        panel_Chashu.add(btn_redece);
        JPanel panel = new JPanel();
        panel_Menu.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        //-1 button
        JButton btn_OK = new JButton("OK");
        panel.add(btn_OK, BorderLayout.EAST);
        //ok button
        JLabel lbl_Remind = new JLabel("");
        lbl_Remind.setForeground(Color.RED);
        panel.add(lbl_Remind, BorderLayout.CENTER);
        //remind label
        JPanel panel_Info = new JPanel();
        panel_Info.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_Info.setLayout(new GridLayout(10,1));
        btn_OK.addActionListener(new ShowABowl(panel_Info,group1, group2,group3,group4,
                chckbx_Nori,chckbx_Chashu,chckbx_Egg,
                lbl_NoriNum,lbl_EggNum,lbl_BambooNum,lbl_ChashuNum,this.customer));
        JScrollPane sp=new JScrollPane(panel_Info);
        panel_C.add(sp);
    }

    /**
     * End of order, view the ordered menu
     * @param evt Click
     */
    private void btnCheckActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            CustomerPayment customerPayment = new CustomerPayment(this.customer);
            customerPayment.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerPayment.setVisible(true);
        });
    }

    /**
     * Back to login interface.
     * @param evt
     */
    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            CustomerLoginIn customerLoginIn = new CustomerLoginIn();
            customerLoginIn.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerLoginIn.setVisible(true);
        });
    }

}
/**
 * ClassName: ShowABowel
 * description: This panel is presented when the customer press the button
 *
 **/
class ShowABowl implements ActionListener{
    private JPanel where; //where to show the dish
    private Dish dish;
    private ButtonGroup group1,group2,group3,group4;
    private JCheckBox chckbx_Nori,chckbx_Chashu,chckbx_Egg;
    private JLabel lbl_NoriNum,lbl_EggNum,lbl_BambooNum,lbl_ChashuNum;
    private Customer customer;

    public ShowABowl(JPanel where, ButtonGroup group1, ButtonGroup group2, ButtonGroup group3, ButtonGroup group4, JCheckBox chckbx_Nori, JCheckBox chckbx_Chashu, JCheckBox chckbx_Egg, JLabel lbl_NoriNum, JLabel lbl_EggNum, JLabel lbl_BambooNum, JLabel lbl_ChashuNum,Customer customer) {
        this.where = where;
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;
        this.group4 = group4;
        this.chckbx_Nori = chckbx_Nori;
        this.chckbx_Chashu = chckbx_Chashu;
        this.chckbx_Egg = chckbx_Egg;
        this.lbl_NoriNum = lbl_NoriNum;
        this.lbl_EggNum = lbl_EggNum;
        this.lbl_BambooNum = lbl_BambooNum;
        this.lbl_ChashuNum = lbl_ChashuNum;
        this.customer=customer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dish=new Dish(group1.getSelection().getActionCommand(),
                group2.getSelection().getActionCommand(),group3.getSelection().getActionCommand(),
                chckbx_Nori.isSelected(),chckbx_Chashu.isSelected(),chckbx_Egg.isSelected(),
                Integer.parseInt(group4.getSelection().getActionCommand()),
                Integer.parseInt(lbl_NoriNum.getText()),Integer.parseInt(lbl_EggNum.getText()),
                Integer.parseInt(lbl_BambooNum.getText()),Integer.parseInt(lbl_ChashuNum.getText()));
        //generate an instance of dish with customer's option
        customer.setOrder(this.dish); //add this dish to the customer
        where.add(new ANoodle(where,dish));
        where.validate(); //repaint the panel
    }
}
/**
 * ClassName: Deleitem
 * description: This class is used to delete a noodle if customer doesn't want
 *
 **/
class Deleitem implements ActionListener{
    private ANoodle anoodle;
    private JPanel parent;
    private Dish dish;
    public Deleitem(ANoodle anoodle,JPanel parent,Dish dish){
        this.parent=parent;
        this.anoodle=anoodle;
        this.dish=dish;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dish.setIsvalid(false); //false means the customer delete the dish
        parent.remove(anoodle.parePanel); //remove the dish from the panel
        parent.revalidate(); //repaint again
        parent.repaint();
    }
}
/**ClassName:
 *  ANoodle
 * description: This panel is used to show the details of the customer's option
 *
 **/
class ANoodle extends JPanel{
    JButton delebutton=new JButton("Delete");
    JPanel parePanel=this;
    JPanel parent;
    Dish dish;
    public ANoodle(JPanel parent,Dish dish){
        this.dish=dish;
        this.parent=parent;
        this.add(new JLabel(dish.getSoup()+"   "+dish.getNoodles()+"  "+"  onion  "+dish.getOnion()
                +"  Nori: "+dish.isOrigNori()+"  Chashu   "+dish.isChashu()
                +"  BoiledEgg: "+dish.isBoiledEgg()+"  Spiciness: "+dish.getSpiciness()
                +"  exNori: "+dish.getExNori()+"  exEgg: "+dish.getExEgg()
                +"  exBamboo: "+dish.getExBamboo()+"  exChashu: "+dish.getExChashu()),BorderLayout.CENTER);
        this.add(delebutton,BorderLayout.EAST); //show the details
        delebutton.addActionListener(new Deleitem(this,parent,dish));
    }
}
