package frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revature.Connection.Bank.BankDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DeleteWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Delete;

	/**
	 * Create the frame.
	 */
	public DeleteWindow(int id, int account) {
		setTitle("Delete Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Delete = new JTextField();
		Delete.setHorizontalAlignment(SwingConstants.CENTER);
		Delete.setColumns(10);
		
		JLabel lblDeleteAccount = new JLabel("Account Number");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankDao bank = new BankDao();
				String delete = Delete.getText();
				int del = Integer.parseInt(delete);
				if (del != account) {
					JOptionPane.showMessageDialog(null, "Wrong account number");
				} else
					bank.delete(id, del);
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addComponent(lblDeleteAccount))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(btnSubmit))
								.addComponent(Delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDeleteAccount)
					.addGap(15)
					.addComponent(Delete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
