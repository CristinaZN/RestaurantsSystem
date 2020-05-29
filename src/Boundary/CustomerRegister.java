package Boundary;

import Control.CheckRegister;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/**
 * ClassName: CustomerRegister
 * description: This is the customer's registration interface. When all the registration information meets the requirements, you can register as a member/
 */
public class CustomerRegister extends JFrame {

    private JPanel contentPane;
    private JTextField Fname;
    private JTextField pNum;
    private JTextField Email;
    private JPasswordField pwd;
    private JPasswordField confirm;
    private JTextField Surname;
    private JLabel remind;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerRegister frame = new CustomerRegister();
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
    public CustomerRegister() {
        setTitle("Customer Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 374);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        //Set contentPane layout.

        JPanel pan_C = new JPanel();
        contentPane.add(pan_C, BorderLayout.CENTER);
        pan_C.setLayout(null);
        //ser up central panel

        JLabel lbl_Fname = new JLabel("First name");
        lbl_Fname.setBounds(40, 13, 106, 18);
        pan_C.add(lbl_Fname);
        Fname = new JTextField();
        Fname.setBounds(160, 10, 200, 24);
        pan_C.add(Fname);
        Fname.setColumns(10);
        //First name label and its text area.

        JLabel lbl_Surname = new JLabel("Surname");
        lbl_Surname.setBounds(40, 43, 72, 18);
        pan_C.add(lbl_Surname);
        Surname = new JTextField();
        Surname.setBounds(160, 40, 200, 24);
        pan_C.add(Surname);
        Surname.setColumns(10);
        //Sur name label and its text area.

        JLabel lbl_PhoneNum = new JLabel("Phone num");
        lbl_PhoneNum.setBounds(40, 73, 72, 18);
        pan_C.add(lbl_PhoneNum);
        pNum = new JTextField();
        pNum.setColumns(10);
        pNum.setBounds(160, 70, 200, 24);
        pan_C.add(pNum);
        //Phone number label and its text area.

        JLabel lbl_Email = new JLabel("Email");
        lbl_Email.setBounds(40, 103, 72, 18);
        pan_C.add(lbl_Email);
        Email = new JTextField();
        Email.setBounds(160, 100, 200, 24);
        pan_C.add(Email);
        Email.setColumns(10);
        //Email label and its text area.

        JLabel lbl_pwd = new JLabel("Password");
        lbl_pwd.setBounds(40, 133, 72, 18);
        pan_C.add(lbl_pwd);
        pwd = new JPasswordField();
        pwd.setBounds(160, 130, 200, 24);
        pan_C.add(pwd);
        //Password label and its password field.

        JLabel lbl_Confirm = new JLabel("Confirm");
        lbl_Confirm.setBounds(40, 163, 72, 18);
        pan_C.add(lbl_Confirm);
        confirm = new JPasswordField();
        confirm.setBounds(160, 160, 200, 24);
        pan_C.add(confirm);
        //Confirm password.

        remind = new JLabel("");
        remind.setForeground(Color.RED);
        remind.setBounds(71, 185, 350, 18);
        pan_C.add(remind);
        //Prompt label, used to remind when the registration conditions are not met

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(55, 210, 113, 27);
        btnSubmit.addActionListener(this::btnSubmitActionPerformed);
        pan_C.add(btnSubmit);
        //Submit button, save the information and enter the login interface.

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(247, 210, 113, 27);
        btnBack.addActionListener(this::btnBackActionPerformed);
        pan_C.add(btnBack);
       //Back button, return to the begin interface

        JPanel pan_N = new JPanel();
        contentPane.add(pan_N, BorderLayout.NORTH);
        //Set up northern panel
        JLabel label1 = new JLabel("Welcome to Register");
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan_N.add(label1);
        label1.setBackground(new Color(240, 240, 240));
    }

    /**
     * This is the event listener for the submit button. When the submit button is pressed, Save all user information and generate loyalty number.
     * @param evt Click
     */
    private void btnSubmitActionPerformed(ActionEvent evt) {
        CheckRegister checkRegister=new CheckRegister();
        if (!checkRegister.isPwd(pwd.getPassword()))//Check password format.
            remind.setText("Password format error, please re-enter.");
        else if(!checkRegister.reCheck(pwd.getPassword(),confirm.getPassword()))//Check whether the two password entries are consistent.
            remind.setText("The two passwords do not match, please re-enter.");
        else if (!checkRegister.isName(Fname.getText()))//Check first name format.
            remind.setText("Your first name is not in the correct format. Please re-enter it");
        else if (!checkRegister.isName(Surname.getText()))//Check surname format.
            remind.setText("Your surname is not in the correct format. Please re-enter it");
        else if (!checkRegister.isEmail(Email.getText()))//Check email format.
            remind.setText("Your e-mail is not in the correct format. Please re-enter it");
        else if (!checkRegister.isPhone(pNum.getText()))//Check phone number format.
            remind.setText("Your phone is not in the correct format. Please re-enter it");
        else {//If all meet the requirements.
            String LoyaltyNum=checkRegister.assignAccount();
            String s = LoyaltyNum;s += ",";//loyalty number
            s += new String(pwd.getPassword());s += ",";//pwd
            s += Fname.getText();s += ",";//first name
            s += Surname.getText();;s += ",";//sur name
            s += Email.getText();;s += ",";//email
            s += pNum.getText();s += ",";//phone
            s += "false,";//isAdmin
            s += Integer.toString(0);		//Vs
            System.out.println(s);
            checkRegister.saveData(s);//save user information.
            this.dispose();
            EventQueue.invokeLater(() -> {
                ShowLoyaltyNum showLoyaltyNum = new ShowLoyaltyNum(LoyaltyNum);//show Loyalty number
                showLoyaltyNum.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                showLoyaltyNum.setVisible(true);
            });
        }
    }

    /**
     * This is the event listener for the back button. When the back button is pressed, back to the beginning page.
     * @param evt Click
     */
    private void btnBackActionPerformed(ActionEvent evt) {
        this.dispose();
        EventQueue.invokeLater(() -> {
            Begin begin = new Begin();
            begin.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            begin.setVisible(true);
        });
    }
}
