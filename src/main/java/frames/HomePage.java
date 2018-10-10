package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.io.Serializable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class HomePage extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HomePage(int id, String fn, String ln, int b, int a) {
		setFont(new Font("Ubuntu Light", Font.PLAIN, 16));
		setTitle("Home Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel welcomeName = new JLabel(fn + " " + ln);
	
		JLabel lblBalance = new JLabel("" + b + "");
		lblBalance.updateUI();
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBackground(Color.WHITE);
		super.update(this.getGraphics());
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositWindow depo = new DepositWindow(id, b);
				depo.setVisible(true);
			}
		});
		
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawWindow withdraw = new WithdrawWindow(id, b);
				withdraw.setVisible(true);
			}
		});
		
		JButton btnTransferFunds = new JButton("Transfer Funds");
		btnTransferFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteWindow delete = new DeleteWindow(id, a);
				delete.setVisible(true);
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeName)
					.addGap(29)
					.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnWithdraw, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
						.addComponent(btnDeleteAccount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
						.addComponent(btnTransferFunds, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
						.addComponent(btnDeposit, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addGap(82))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(welcomeName)
						.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnDeposit)
					.addGap(18)
					.addComponent(btnWithdraw)
					.addGap(18)
					.addComponent(btnDeleteAccount)
					.addGap(18)
					.addComponent(btnTransferFunds)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
