package com.revature.Connection.Bank;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import frames.HomePage;

public class BankDao {
	
	public void insertTable(String fname, String lname, String uname, 
			int age, String email, int phone, String password) throws SQLException, IOException {
		CallableStatement cs = null;
		
		try (Connection con = MyBankConnection.getConnection()) {
			String sql = "{Call INSERTTABLE(?, ?, ?, ?, ?, ?, ?)}";
			cs = con.prepareCall(sql);
			cs.setString(1,  fname);
			cs.setString(2, lname);
			cs.setString(3, uname);
			cs.setInt(4, age);
			cs.setString(5, email);
			cs.setInt(6, phone);
			cs.setString(7, password);
			
			cs.execute();
			//cs.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public UserInfo getUser(String n, String p) {
		UserInfo info = null;
		
		try {
			Connection conn = MyBankConnection.getConnection();
			String sql = "SELECT * FROM UACCOUNT WHERE USER_UNAME=? AND USER_PASSWORD=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, n);
			statement.setString(2, p);
			
			ResultSet set = statement.executeQuery();
			

			if (set.next()) {
				int id = set.getInt("USER_ID");
				String fname = set.getString("USER_FNAME");
				String lname = set.getString("USER_LNAME");
				int balance = set.getInt("USER_BALANCE");
				int account = set.getInt("USER_ACCOUNTNUM");
					
				JOptionPane.showMessageDialog(null, "Login Success");
				HomePage home = new HomePage(id, fname, lname, balance, account);
				home.setVisible(true);
			} else 
				JOptionPane.showMessageDialog(null, "Login Failed");
					
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
		return info;
	}
	
	public void deposit (int id, int balance) {
		CallableStatement cs = null;
		
		try (Connection con = MyBankConnection.getConnection()) {
			String sql = "{Call DEPOSITE(?, ?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			cs.setInt(2, balance);
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public void withdraw (int id, int balance) {
		CallableStatement cs = null;
		
		try (Connection con = MyBankConnection.getConnection()) {
			String sql = "{Call WITHDRAW(?, ?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			cs.setInt(2, balance);
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public void delete (int id, int account) {
		CallableStatement cs = null;
		
		try (Connection con = MyBankConnection.getConnection()) {
			String sql = "{Call DELETEENTRY(?, ?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, id);
			cs.setInt(2, account);
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
}
