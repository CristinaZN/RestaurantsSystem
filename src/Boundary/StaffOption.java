package Boundary;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class StaffOption extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffOption frame = new StaffOption();
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
	public StaffOption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Modify Menu");
		btnNewButton.addActionListener(this::btnNewButtonActionPerformed);
		btnNewButton.setBounds(130, 54, 168, 48);
		contentPane.add(btnNewButton);
		
		JButton btnShowBills = new JButton("Show Bills");
		btnShowBills.addActionListener(this::btnShowBillsActionPerformed);
		btnShowBills.setBounds(130, 154, 168, 48);
		contentPane.add(btnShowBills);
	}

	private void btnShowBillsActionPerformed(ActionEvent actionEvent) {
		this.dispose();
		EventQueue.invokeLater(()->{
			StaffShowBill staffShowBill = null;
			try {
				staffShowBill = new StaffShowBill();
			} catch (IOException e) {
				e.printStackTrace();
			}
			staffShowBill.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			staffShowBill.setVisible(true);
		});
	}

	private void btnNewButtonActionPerformed(ActionEvent actionEvent) {
		this.dispose();
		EventQueue.invokeLater(()->{
			StaffModifyMenu staffModifyMenu = new StaffModifyMenu();
			staffModifyMenu.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			staffModifyMenu.setVisible(true);
		});
	}

}
