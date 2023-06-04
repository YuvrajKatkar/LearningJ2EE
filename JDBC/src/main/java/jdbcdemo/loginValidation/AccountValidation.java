package jdbcdemo.loginValidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountValidation {
	static Scanner scanner = new Scanner(System.in);
	static Connection con;
	static Statement statement;
	static PreparedStatement ps;
	public static void main(String[] args) throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql");
		statement = con.createStatement();
		System.out.println("1. create account 2.login");
		if(scanner.nextInt()==1) {
			System.out.println("Enter your acount number");
			int accountNumber = scanner.nextInt();
			System.out.println("Enter your name");
			String nameString = scanner.next();
			System.out.println("Enter a new pin");
			int pin = scanner.nextInt();
			System.out.println("Enter amount");
			int amount = scanner.nextInt();
			String queryString="insert into account(name,accountno,pin,balance) values (?,?,?,?);";
			ps = con.prepareStatement(queryString);
			ps.setString(1, nameString);
			ps.setInt(2, accountNumber);
			ps.setInt(3,pin);
			ps.setInt(4, amount);
			ps.execute();
			System.out.println("Account successfully registered");
		}
		else {
			System.out.println("Enter your account number");
			int accountNumber = scanner.nextInt();
			System.out.println("Enter your pin");
			int pin = scanner.nextInt();
			String query = "select * from account where accountno = ? and pin = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, accountNumber);
			ps.setInt(2,pin);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Logged in");
				
				System.out.println("1. add money 2.remove money");
				switch(scanner.nextInt()) {
					case 1: {
						String q = "Select * from account where accountno = ?";
						ps = con.prepareStatement(q);
						ps.setInt(1, accountNumber);
						ResultSet rSet = ps.executeQuery();
						int oldBal=0;
						if (rSet.next()) {
							 oldBal = rSet.getInt("balance");
						}
						System.out.println("Enter amount you want to add:");
						int money = scanner.nextInt()+oldBal;
						String query1 = "update account set balance=? where accountno=?";
						ps = con.prepareStatement(query1);
						ps.setInt(1, money);
						ps.setInt(2, accountNumber);
						ps.executeUpdate();
						System.out.println("money added successfully!!");
					}break;
					case 2: {
						System.out.println("Enter amount you to withdraw");
						int money = scanner.nextInt();
						String query2= "Select * from account where accountno=?";
						ps = con.prepareStatement(query2);
						ps.setInt(1, accountNumber);
						ResultSet rs1 = ps.executeQuery();
						if (rs1.next()) {
							int bal = rs1.getInt("balance");
							if (bal>money) {
								System.out.println("Collect the cash");
								int newBal = bal-money;
								String query3= "update account set balance=? where accountno=?";
								ps = con.prepareStatement(query3);
								ps.setInt(1, newBal);
								ps.setInt(2, accountNumber);
								ps.executeUpdate();
								System.out.println("Balance updated successfully");
							}
							else {
								System.out.println("Insufficient balance");
							}
						}
					}break;
				}
				
			}
			else {
				System.out.println("Wrong credentials");
			}
		}
	}
}
