package Boundary;

import Control.Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

public class StaffModifyMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String name;
	private String price;
	private JTextField txtDish;
	private JTextField txtPrice;
	private ArrayList<JTextField> muneNameField = new ArrayList<JTextField>();
	private ArrayList<JTextField> munePriceField= new ArrayList<JTextField>();

	/**
	 * Launch the application.
	 * @param args
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
		panel.setBounds(0, 10, 354, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Trajan Pro", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(124, 10, 111, 38);
		panel.add(lblNewLabel);
		
		txtDish = new JTextField();
		txtDish.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		txtDish.setHorizontalAlignment(SwingConstants.CENTER);
		txtDish.setText("Dish");
		txtDish.setBounds(10, 50, 213, 38);
		panel.add(txtDish);
		txtDish.setColumns(10);
		txtDish.setEditable(false);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		txtPrice.setText("Price");
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setColumns(10);
		txtPrice.setBounds(233, 50, 111, 38);
		panel.add(txtPrice);
		txtPrice.setEditable(false);

		JButton btnChangePrice = new JButton("Change Price");
		btnChangePrice.setBounds(415, 193, 158, 42);
		contentPane.add(btnChangePrice);
		btnChangePrice.addActionListener(this::btnChangePricePerformed);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(this::btnBackActionPerformed);
		btnBack.setBounds(415, 245, 158, 42);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(this::btnExitActionPerformed);
		btnExit.setBounds(415, 297, 158, 42);
		contentPane.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBounds(415, 10, 158, 81);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(64, 10, 121, 29);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 138, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(415, 101, 158, 82);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Price");
		lblNewLabel_1_1.setBounds(50, 11, 134, 15);
		panel_1_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(14, 36, 134, 36);
		textField_1.setColumns(10);
		panel_1_1.add(textField_1);


		for(int i = 0;i < 4;i++) {
			JTextField muneNField = new JTextField();
			muneNField.setBounds(10, 90+i*38, 213, 38);
			muneNField.setColumns(10);
			panel.add(muneNField);
			muneNameField.add(muneNField);
			muneNameField.get(i).setText(Menu.findAddOneName(i));

			JTextField munePField = new JTextField();
			munePField.setBounds(233, 90+i*38, 111, 38);
			munePField.setColumns(10);
			panel.add(munePField);
			munePriceField.add(munePField);
			munePriceField.get(i).setText(Integer.toString(Menu.findAddOnePrice(i)));
		}

		
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

	private void btnChangePricePerformed(ActionEvent actionEvent){
		name = textField.getText();
		price = textField_1.getText();
		if (!Menu.findMenuName(name)){
			System.out.println("No such Dish");
		}
		else Menu.changeMenuPrice(name,Integer.parseInt(price));

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
