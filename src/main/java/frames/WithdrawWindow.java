package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revature.Connection.Bank.BankDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class WithdrawWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Withdraw;

	/**
	 * Create the frame.
	 */
	public WithdrawWindow(int id, int b) {
		setFont(new Font("Ubuntu Light", Font.PLAIN, 16));
		setTitle("Withdraw");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Ubuntu Light", Font.BOLD, 16));
		
		Withdraw = new JTextField();
		Withdraw.setHorizontalAlignment(SwingConstants.CENTER);
		Withdraw.setColumns(15);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDao bank = new BankDao();
				String withdraw = Withdraw.getText();
				int wd = Integer.parseInt(withdraw);
				
				if (b == 0) {
					JOptionPane.showMessageDialog(null, "You don't have any money in your account yet");
					
				} else if (wd > b) {
					JOptionPane.showMessageDialog(null, "You don't have enough money in your account");
				}
				else {
					bank.withdraw(id, wd);
					JOptionPane.showMessageDialog(null, "Successful Withdraw");
				}
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(lblWithdraw))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(91)
							.addComponent(btnSubmit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(Withdraw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWithdraw)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Withdraw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
