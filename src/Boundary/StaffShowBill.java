package Boundary;

import Control.PrintStatisticsDate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class StaffShowBill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffShowBill frame = new StaffShowBill();
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
	public StaffShowBill() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Change Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton.setBounds(10, 45, 152, 23);
		contentPane.add(btnNewButton);

		JButton btnSendBill = new JButton("Send Bill");
		btnSendBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintStatisticsDate.printWeekBill();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		btnSendBill.setBounds(10, 95, 152, 23);
		contentPane.add(btnSendBill);

		JTextArea textArea = new JTextArea(PrintStatisticsDate.showWeekBill());
		textArea.setBounds(198, 10, 228, 243);
		contentPane.add(textArea);

		JButton btnYearlyReport = new JButton("Weekly Report");
		btnYearlyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textArea.setText("");
					textArea.setText(PrintStatisticsDate.showBeastSale());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		btnYearlyReport.setBounds(10, 145, 152, 23);
		contentPane.add(btnYearlyReport);



		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(this::btnBackActionPerformed);
		btnNewButton_2_1.setBounds(10, 195, 70, 23);
		contentPane.add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Exit");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2_1_1.setBounds(92, 195, 70, 23);
		contentPane.add(btnNewButton_2_1_1);
	}

	private void btnBackActionPerformed(ActionEvent actionEvent) {
		dispose();
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
}
