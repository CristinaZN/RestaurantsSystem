package Boundary;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * ClassName: ShowLoyaltyNum
 * description: This page is to display the loyalty number after successful registration
 */
public class ShowLoyaltyNum extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowLoyaltyNum frame = new ShowLoyaltyNum("12345678");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param LoyaltyNum loyalty number
     */

    public ShowLoyaltyNum(String LoyaltyNum) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        //set up contentPane.

        JLabel lblNewLabel = new JLabel("<html><body>Your LoyaltyNum is: "+ LoyaltyNum+"<br>"+"If you remember your loyalty number, please click OK<body></html>");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel, BorderLayout.CENTER);
        //show loyalty number.

        JButton btnNewButton = new JButton("OK");
        btnNewButton.addActionListener(this::btnOkActionPerformed);
        contentPane.add(btnNewButton, BorderLayout.SOUTH);

    }

    /**
     * I've memorized the loyalty number and started to log in
     * @param evt Click
     */
    private void btnOkActionPerformed(ActionEvent evt) {
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

