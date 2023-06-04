package jdbcdemo;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.a.TextResultsetReader;
import com.mysql.cj.xdevapi.Statement;

public class AllInOne {
	static java.sql.Statement statement ;
	static void read() throws SQLException {
		ResultSet rs = statement.executeQuery("Select * from student");
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
		System.out.println("Done");
	}
	static void insert() throws SQLException {
		statement.execute("insert into student values (15,'ert',3);");
		System.out.println("Done");

	}
	static void update() throws SQLException{
		statement.execute("Update student set name='abc' where id=5;");
		System.out.println("Done");
	}
	static void delete() throws SQLException{
		statement.execute("delete from student where id = 2 ;");
		System.out.println("Zala re");
	}
public static void main(String[] args) throws SQLException {
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql");
	statement = connection.createStatement();
	//statement.execute("create table teacher(id int, name varchar(20), age int, subject varchar(30))");
	while (true) {
		System.out.println("1. read 2.update 3.delete 4. insert");
		switch (new Scanner(System.in).nextInt()) {
		case 1:
			read();
			break;
		case 2:{
			update();
			break;
		}
		case 3:{
			update();
			break;
		}
		case 4:{
			delete();
			break;
		}
		case 5:{
			System.out.println("Application closed");
			return;
		}
		}
	}
	
}
}




