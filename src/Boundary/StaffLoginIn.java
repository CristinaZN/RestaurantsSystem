package Boundary;

import Control.CheckCusLog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class StaffLoginIn extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 5050092661082459104L;
	private JPanel contentPane;
	private JTextField UserName;
	private JTextArea txtrStaffLoginIn;
	private JPasswordField password;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLoginIn frame = new StaffLoginIn();
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
	public StaffLoginIn() {
		setTitle("Staff Login In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.PINK);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		UserName = new JTextField();
		UserName.setBounds(102, 74, 283, 33);
		contentPane.add(UserName);
		UserName.setColumns(10);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnConfirm.addActionListener(this::btnConfirmActionPerformed);
		btnConfirm.setBounds(171, 220, 100, 33);
		contentPane.add(btnConfirm);

		JTextArea txtrUserName = new JTextArea();
		txtrUserName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtrUserName.setBackground(SystemColor.inactiveCaptionBorder);
		txtrUserName.setForeground(SystemColor.desktop);
		txtrUserName.setText("LoyaltyNum");
		txtrUserName.setBounds(10, 78, 82, 24);
		contentPane.add(txtrUserName);

		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtrPassword.setText("Password");
		txtrPassword.setForeground(Color.BLACK);
		txtrPassword.setBackground(SystemColor.inactiveCaptionBorder);
		txtrPassword.setBounds(10, 147, 82, 24);
		contentPane.add(txtrPassword);

		txtrStaffLoginIn = new JTextArea();
		txtrStaffLoginIn.setFont(new Font("Monospaced", Font.BOLD, 23));
		txtrStaffLoginIn.setBackground(SystemColor.inactiveCaptionBorder);
		txtrStaffLoginIn.setText("Staff Log In");
		txtrStaffLoginIn.setBounds(119, 10, 197, 33);
		contentPane.add(txtrStaffLoginIn);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(this::btnBackActionPerformed);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(344, 226, 82, 29);
		contentPane.add(btnBack);

		password = new JPasswordField();
		password.setBounds(102, 136, 283, 33);
		contentPane.add(password);
	}

	private void btnConfirmActionPerformed(ActionEvent actionEvent) {
		List<String> userInfo = new ArrayList<>();
		CheckCusLog checkCusLog = new CheckCusLog();
		if (UserName.getText()!=null&&UserName.getText()!=""){
			userInfo=checkCusLog.isAccount(UserName.getText());
		}
		else
			userInfo=null;
		if(userInfo != null){

			if(checkCusLog.isStaff(userInfo) && userInfo.get(1).equals(new String(password.getPassword()))){
				this.dispose();
				EventQueue.invokeLater(() -> {
					StaffOption staffOption = new StaffOption();
					staffOption.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							System.exit(0);
						}
					});
					staffOption.setVisible(true);
				});
			}
			else JOptionPane.showMessageDialog(null, "You are not a staff or incorrect password");

		}
		else JOptionPane.showMessageDialog(null, "Invalid username");


	}

	private void btnBackActionPerformed(ActionEvent actionEvent) {
		this.dispose();
		EventQueue.invokeLater(()->{
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
