package com.revature.Connection.Bank;

import java.io.IOException;
import java.sql.SQLException;

import frames.*;

public class App 
{
    public static void main( String[] args )
    {		
    	try {
			if (MyBankConnection.getConnection() != null) {
				System.out.println("Connection Works");
				Login log = new Login();
				log.setVisible(true);
			}
			else 
				System.out.println("Connection Failed");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
