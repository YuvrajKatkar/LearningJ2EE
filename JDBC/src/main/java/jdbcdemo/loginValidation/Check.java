package jdbcdemo.loginValidation;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Check {
	public static void main(String[] args) throws SQLException {
		String query = "select * from login where email=? and password = ?;";
		PreparedStatement ps= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql").prepareStatement(query);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter email:");
		String emailString = scanner.next();
		System.out.println("Enter Password:");
		String paString = scanner.next();
		ps.setString(2, paString);
		ps.setString(1, emailString);
		ResultSet a= ps.executeQuery();
		if(a.next()) {
			System.out.println("Correct login");
		}
		else {
			System.out.println("Wrong login");
		}
		
	}
}
