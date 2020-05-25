package Boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StaffModifyMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffModifyMenu frame = new StaffModifyMenu();
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
	public StaffModifyMenu() {
		setTitle("ModifyMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 354, 378);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Menu");
		panel.add(lblNewLabel);
		
		JButton btnChangeName = new JButton("Change Name");
		btnChangeName.setBounds(415, 35, 158, 42);
		contentPane.add(btnChangeName);
		
		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.setBounds(415, 110, 158, 42);
		contentPane.add(btnChangePrice);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(this::btnBackActionPerformed);
		btnBack.setBounds(415, 185, 158, 42);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(this::btnExitActionPerformed);
		btnExit.setBounds(415, 260, 158, 42);
		contentPane.add(btnExit);
	}

	private void btnBackActionPerformed(ActionEvent actionEvent) {
		this.dispose();
		EventQueue.invokeLater(()->{
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

	private void btnExitActionPerformed(ActionEvent actionEvent) {
		System.exit(0);
	}


}
