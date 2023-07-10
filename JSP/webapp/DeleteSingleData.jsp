<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "mysql");
	String query = "Delete from student where id =?";
	PreparedStatement preparedStatement =  connection.prepareStatement(query);
	preparedStatement.setInt(1, id);
	preparedStatement.execute();
	%>
	Student with id <%=id%> is delete
	<%
	RequestDispatcher requestDispatcher=  request.getRequestDispatcher("FetchAllData.jsp");
	requestDispatcher.forward(request, response);
	%>
</body>
</html>
