package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revature.Connection.Bank.BankDao;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.SwingConstants;

public class Login extends JFrame implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;
	private JButton btnCreateAccount;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setForeground(new Color(255, 255, 0));
		setFont(new Font("Ubuntu Light", Font.PLAIN, 16));
		setTitle("Batcho Banking");
		setResizable(false);
		setBackground(new Color(0, 128, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Username = new JTextField();
		Username.setHorizontalAlignment(SwingConstants.CENTER);
		Username.setColumns(20);
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setLabelFor(lblUsername);

		Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setLabelFor(lblPassword);

		btnSubmit = new JButton("Submit");
		btnCreateAccount = new JButton("Create Account");
		
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uname = Username.getText();
				@SuppressWarnings("deprecation")
				String pass = Password.getText();
				
				BankDao info = new BankDao();
				info.getUser(uname, pass);
			}
		});
		
		btnCreateAccount.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CreateAccount account = new CreateAccount();
					account.setVisible(true);
				}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(Password)
								.addComponent(Username, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnCreateAccount)
								.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(27)
					.addComponent(btnSubmit)
					.addGap(34)
					.addComponent(btnCreateAccount)
					.addContainerGap(220, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
