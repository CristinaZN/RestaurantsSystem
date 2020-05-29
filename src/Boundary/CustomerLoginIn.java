package Boundary;

import Control.CheckCusLog;
import Entity.Customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
/**
 *Classname: CustomerLogin
 *description: This is the customer's login interface. Enter the correct member number and password to complete the login and enter the order interface.
 */
public class CustomerLoginIn extends JFrame {

    private JPanel contentPane;
    private JTextField LoyaltyNum;
    private JPasswordField pwd;
    private JLabel remind;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerLoginIn frame = new CustomerLoginIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CustomerLoginIn() {
        setTitle("Customer Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 341);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        //set up frame

        JPanel panel_N = new JPanel();
        contentPane.add(panel_N, BorderLayout.NORTH);
        //set up the northern panel.

        JLabel lblNewLabel = new JLabel("Customer Log In");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel_N.add(lblNewLabel);
        //label in northern panel.

        JPanel panel_C = new JPanel();
        contentPane.add(panel_C, BorderLayout.CENTER);
        panel_C.setLayout(null);
        //set up the central panel.

        JLabel lbl_Username = new JLabel("LoyaltyNum");
        lbl_Username.setFont(new Font("SimSun", Font.PLAIN, 15));
        lbl_Username.setBounds(54, 26, 100, 18);
        panel_C.add(lbl_Username);
        LoyaltyNum = new JTextField();
        LoyaltyNum.setBounds(140, 23, 200, 24);
        panel_C.add(LoyaltyNum);
        LoyaltyNum.setColumns(10);
        //Loyalty number label and its text area.

        JLabel lbl_Password = new JLabel("Password");
        lbl_Password.setBounds(54, 73, 72, 18);
        panel_C.add(lbl_Password);
        pwd = new JPasswordField();
        pwd.setBounds(140, 70, 200, 24);
        panel_C.add(pwd);
        //Password label and its password field.

        remind = new JLabel("");
        remind.setForeground(Color.RED);
        remind.setBounds(54, 118, 310, 24);
        panel_C.add(remind);
        //Prompt label, used to remind when login fails.

        JButton btnLogin = new JButton("Log in");
        btnLogin.setBounds(68, 169, 113, 27);
        btnLogin.addActionListener(this::btnLoginInActionPerformed);
        panel_C.add(btnLogin);
        //Login button

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);
        btnBack.setBounds(230, 169, 113, 27);
        panel_C.add(btnBack);
        //Back button

        JPanel panel_S = new JPanel();
        contentPane.add(panel_S, BorderLayout.SOUTH);
        //set up southern panel

        panel_S.setLayout(new BorderLayout(0, 0));
        JButton btnSkip = new JButton("Skip");
        btnSkip.addActionListener(this::btnSkipActionPerformed);
        btnSkip.setFont(new Font("Times New Roman", Font.PLAIN, 7));
        panel_S.add(btnSkip, BorderLayout.EAST);
        //Skip button
    }

    /**
     * This is the event listener for the login button. When the login button is pressed, obtain the loyalty number and password for verification.
     * @param evt Click
     */
    private void btnLoginInActionPerformed(ActionEvent evt) {
        List<String> userInfo = new ArrayList<String>();
        CheckCusLog checkCusLog=new CheckCusLog();
        if (LoyaltyNum.getText()!=null&&LoyaltyNum.getText()!=""){
            userInfo=checkCusLog.isAccount(LoyaltyNum.getText());
        }
        else {
            remind.setText("Please enter your loyalty number.");
            userInfo = null;
        }
        //Verify whether the loyalty number exists.

        if (userInfo!=null){
            if (checkCusLog.isPwd(new String(pwd.getPassword()), userInfo)) {
                //Verify whether the loyalty number and password match.

                Customer customer=new Customer(userInfo);
                this.dispose();
                //close this interface.

                EventQueue.invokeLater(() -> {
                    CustomerOrder customerOrder = new CustomerOrder(customer);
                    customerOrder.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    customerOrder.setVisible(true);
                });
            }
            else
                remind.setText("Wrong password, please re-enter.");
        }
        else
            remind.setText("Wrong loyalty number, please re-enter");
    }

    /**
     * This is the event listener for the back button. When the back button is pressed, back to the beginning page.
     * @param evt Click
     */
    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        //close this interface.
        EventQueue.invokeLater(() -> {
            Begin begin = new Begin();
            begin.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            begin.setVisible(true);
            //back to the beginning page.
        });
    }

    /**
     *This is the event listener for the skip button. When the skip button is pressed, enter the order interface as an ordinary customer
     */
    private void btnSkipActionPerformed(ActionEvent evt) {
        this.dispose();
        //close this interface.

        EventQueue.invokeLater(() -> {
            Customer customer = new Customer();
            CustomerOrder customerOrder = new CustomerOrder(customer);
            //Create an customer instance without user information and pass it to the order interface.

            customerOrder.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            customerOrder.setVisible(true);
        });
    }
}
