package jdbcdemo.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Library{
	static Scanner scanner = new Scanner(System.in);
	static Connection connection;
	static Statement statement;
	static PreparedStatement preparedStatement;
	static String query;
	void addBook() throws SQLException {
		System.out.println("Enter book id:");
		int id= scanner.nextInt();
		System.out.println("Enter book name:");
		String name= scanner.next();
		System.out.println("Enter book author:");
		String author = scanner.next();
		System.out.println("Enter book genre:");
		String genre= scanner.next();
		query = "Insert into books values (?,?,?,?);";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, author);
		preparedStatement.setString(4, genre);
		preparedStatement.execute();
		System.out.println("Book added");
	}
	void viewBookById() throws SQLException {
		query = "Select * from books where id = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter id of book");
		int id = scanner.nextInt(); 
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if  (resultSet.next()) {
			System.out.println("id :"+resultSet.getInt(1));
			System.out.println("name :"+resultSet.getString(2));
			System.out.println("author :"+resultSet.getString(3));
			System.out.println("genre:"+resultSet.getString(4));
		}
		System.out.println("Done");
	}
	void updateBook()throws SQLException{
		query  =  "update books set name = ? where id =?";
		System.out.println("Enter which book id you want to update");
		int id = scanner.nextInt();
		System.out.println("Enter new book name");
		String nameString = scanner.next();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, nameString);
		preparedStatement.setInt(2, id);
		preparedStatement.execute();
		System.out.println("Name has been changed");
	}
	void viewAllBooks() throws SQLException{
		ResultSet resultSet = statement.executeQuery("Select * from books");
		while  (resultSet.next()) {
			System.out.println("id :"+resultSet.getInt(1));
			System.out.println("name :"+resultSet.getString(2));
			System.out.println("author :"+resultSet.getString(3));
			System.out.println("genre:"+resultSet.getString(4));
			System.out.println("__________________________");
		}
	}
	void deleteBookByID() throws SQLException{
		query  =  "Delete from books where id =?";
		System.out.println("Enter which book id you want to delete");
		int id = scanner.nextInt();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		System.out.println("Book deleted");
	}
	void addUser() throws SQLException{
		System.out.println("Enter user id:");
		int id= scanner.nextInt();
		System.out.println("Enter user name:");
		String name= scanner.next();
		System.out.println("Enter user age:");
		int author = scanner.nextInt();
		
		query = "Insert into user values (?,?,?);";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, author);
		preparedStatement.execute();
		System.out.println("User added");
	}
	void viewUserById() throws SQLException{
		query = "Select * from user where id = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter id of user");
		int id = scanner.nextInt(); 
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if  (resultSet.next()) {
			System.out.println("id :"+resultSet.getInt(1));
			System.out.println("name :"+resultSet.getString(2));
			System.out.println("age :"+resultSet.getInt(3));
		}
		System.out.println("Done");
	}
	void viewBookByGenre() throws SQLException{
		query = "Select * from books where genre = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter genre of Book");
		String id = scanner.next(); 
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if  (resultSet.next()) {
			System.out.println("id :"+resultSet.getInt(1));
			System.out.println("name :"+resultSet.getString(2));
			System.out.println("author :"+resultSet.getString(3));
			System.out.println("genre :"+resultSet.getString(4));
		}
		System.out.println("Done");
	}
	void viewAllUser() throws SQLException{
		ResultSet resultSet = statement.executeQuery("Select * from user");
		while  (resultSet.next()) {
			System.out.println("id :"+resultSet.getInt(1));
			System.out.println("name :"+resultSet.getString(2));
			System.out.println("age :"+resultSet.getInt(3));
			
			System.out.println("__________________________");
		}
	}
	void deleteUserById() throws SQLException{
		query  =  "Delete from user where id =?";
		System.out.println("Enter which user id you want to delete");
		int id = scanner.nextInt();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		System.out.println("user deleted");
	}
	void viewBookByAuthor() throws SQLException{
		query = "Select * from books where author = ?";
		preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter id of book");
		String id = scanner.next(); 
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if  (resultSet.next()) {
			System.out.println("id :"+resultSet.getInt(1));
			System.out.println("name :"+resultSet.getString(2));
			System.out.println("author :"+resultSet.getString(3));
			System.out.println("genre:"+resultSet.getString(4));
		}
		System.out.println("Done");
	}
	public static void  main(String[] args) throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","mysql");
		statement = connection.createStatement();
		
		Library l1 = new Library();
		System.out.println("1. admin 2.user");
		if (scanner.nextInt()==1) {
			System.out.println("Logged in as admin");
			System.out.println("1.add Book  2.view book by id");
			System.out.println("3.update book  4.View all books");
			System.out.println("5.Delete book ");
			System.out.println("6.add user  7.view user by id");
			System.out.println("8.View all user  9.delete user by id");
			switch(scanner.nextInt()) {
				case 1:{
					l1.addBook();
					break;
				}
				case 2:{
					l1.viewBookById();
					break;
				}
				case 3:{
					l1.updateBook();
					break;
				}
				case 4:{
					l1.viewAllBooks();
					break;
				}
				case 5:{
					l1.deleteBookByID();
					break;
				}
				case 6:{
					l1.addUser();
					break;
				}
				case 7:{
					l1.viewUserById();
					break;
				}
				case 8:{
					l1.viewAllUser();
					break;
				}
				case 9:{
					l1.deleteUserById();
					break;
				}
			}
		}
		else {
			System.out.println("Entered as user");
			System.out.println("1. create user  2. viewBook by author");
			System.out.println("3. viewBook by id  4. viewBook by genre");
			//System.out.println("5. update user");
			switch (scanner.nextInt()) {
			case 1->{
				l1.addUser();
				
			}
			case 3 ->{
				l1.viewBookById();
				
			}
			case 2->{
				l1.viewBookByAuthor();
				
			}
			case 4->{
				l1.viewBookByGenre();
			}
			}
		}
	}
}

