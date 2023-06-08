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

a=Integer.parseInt(request.getParameter("num1"));
b=Integer.parseInt(request.getParameter("num2"));
add();
%>
<%!
	static int a;static int b;static int add;
	public static void add(){
	add=a+b;
}
%>
<%=add +" : is addition of two numbers" %>
</body>
</html>
