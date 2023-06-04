package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValues {
	public static void main(String[] args) throws SQLException {
		DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql")
		.createStatement()
		.execute("delete from teacher where id = 3 ;");
		
		
		System.out.println("Zala re");
	}
}
