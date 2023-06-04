package jdbcdemo;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.protocol.a.TextResultsetReader;
import com.mysql.cj.xdevapi.Statement;

public class EnableConnection {
public static void main(String[] args) throws SQLException {
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql");
	java.sql.Statement statement = connection.createStatement();
	//statement.execute("create table teacher(id int, name varchar(20), age int, subject varchar(30))");
	
	ResultSet rs = statement.executeQuery("Select * from student");
	while (rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getInt(3));
	}
	System.out.println("Done");
}
}




