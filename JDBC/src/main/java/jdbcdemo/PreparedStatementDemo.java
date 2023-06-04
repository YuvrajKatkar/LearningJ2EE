package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("ENter the id number");
		 
		PreparedStatement preparedStatement= DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql")
		 .prepareStatement("Select * from student where id = ?");
		preparedStatement.setInt(1, new Scanner(System.in).nextInt());
		//preparedStatement.execute();
		ResultSet output =  preparedStatement.executeQuery();
		
		if(output.next()) {
			System.out.println(output.getInt(1));
			System.out.println(output.getString(2));
			System.out.println(output.getInt(3));
		}
		else {
			System.out.println("Error 404");
		}
		System.out.println("Done");
	}
}
