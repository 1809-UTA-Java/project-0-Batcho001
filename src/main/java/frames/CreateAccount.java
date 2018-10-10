package frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.revature.Connection.Bank.BankDao;

public class CreateAccount extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField FName;
	private static JTextField LName;
	private static JTextField Username;
	private static JTextField Age;
	private static JTextField Email;
	private static JTextField PhoneNum;
	private JTextField Password;

	/**
	 * Create the frame.
	 */
	public CreateAccount() {
		setResizable(false);
		setFont(new Font("Ubuntu Light", Font.PLAIN, 16));
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		FName = new JTextField();
		FName.setHorizontalAlignment(SwingConstants.CENTER);
		FName.setColumns(20);
		
		
		LName = new JTextField();
		LName.setHorizontalAlignment(SwingConstants.CENTER);
		LName.setColumns(20);
		
		Username = new JTextField();
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setColumns(20);
		
		Age = new JTextField();
		Age.setHorizontalAlignment(SwingConstants.CENTER);
		Age.setColumns(20);
		
		Email = new JTextField();
		Email.setHorizontalAlignment(SwingConstants.CENTER);
		Email.setColumns(20);
		
		PhoneNum = new JTextField();
		PhoneNum.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNum.setColumns(20);
		
		Password = new JTextField();
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setColumns(20);
		
		JLabel lblFirstName = new JLabel("First Name");
		
		JLabel lblLastName = new JLabel("Last Name");
		
		JLabel lblUsername = new JLabel("Username");
		
		JLabel lblAge = new JLabel("Age");
		
		JLabel lblEmail = new JLabel("E-Mail");
		
		JLabel lblPhone = new JLabel("Phone");
		
		JLabel lblPassword = new JLabel("Password");
		
		JButton AccountSubmit = new JButton("Submit");
		
		AccountSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fname = FName.getText();
				String lname = LName.getText();
				String uname = Username.getText();
				String email = Email.getText();
				String age = Age.getText();
				int a = Integer.parseInt(age);
				String phone = PhoneNum.getText();
				int p = Integer.parseInt(phone);
				String password = Password.getText();
				
				BankDao bank = new BankDao();
				try {
					if (fname.isEmpty() || lname.isEmpty() || uname.isEmpty() || email.isEmpty() || password.isEmpty()) {
						System.out.println("Missing Parameters");
					} else if (a > 120) {
						JOptionPane.showMessageDialog(null, "Yor are too old");
					} else if (a < 18) {
						JOptionPane.showMessageDialog(null, "You are too young.");
					} else {
						bank.insertTable(fname, lname, uname, a, email, p, password);
						JOptionPane.showMessageDialog(null, "Successful Creation");
					}
					System.out.println("Made it through");
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(AccountSubmit, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFirstName)
						.addComponent(lblPassword)
						.addComponent(lblPhone)
						.addComponent(lblEmail)
						.addComponent(lblAge)
						.addComponent(lblUsername)
						.addComponent(lblLastName))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Password, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(FName, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(LName, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(Age, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(Email, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(PhoneNum, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(Username, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addGap(84))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(FName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(LName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(Age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(PhoneNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFirstName)
							.addGap(39)
							.addComponent(lblLastName)
							.addGap(36)
							.addComponent(lblUsername)
							.addGap(33)
							.addComponent(lblAge)
							.addGap(34)
							.addComponent(lblEmail)
							.addGap(41)
							.addComponent(lblPhone)
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword)
								.addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(55)
					.addComponent(AccountSubmit)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
