package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revature.Connection.Bank.BankDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepositWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Deposit;

	/**
	 * Create the frame.
	 */
	public DepositWindow(int id, int b) {
		setTitle("Deposit");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Deposit = new JTextField();
		Deposit.setHorizontalAlignment(SwingConstants.CENTER);
		Deposit.setColumns(15);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Ubuntu Light", Font.BOLD, 16));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDao bank = new BankDao();
				String depo = Deposit.getText();
				int de = Integer.parseInt(depo);
				
				if (de < 0) {
					JOptionPane.showMessageDialog(null, "Try the Withdraw window");
				} else {
					bank.deposit(id, de);
					JOptionPane.showMessageDialog(null, "Successful Deposit");
				}
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(111)
							.addComponent(lblDeposit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(Deposit, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(btnSubmit)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeposit)
					.addGap(15)
					.addComponent(Deposit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
