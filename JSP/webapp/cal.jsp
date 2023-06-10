<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="lasun.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("choice");
		if(op.equals("add")){
			int add= num1+num2;
			%>
			Addition of two numbers is <%=add %>
			<%
		}
		else if(op.equals("sub")){
			int add= num1-num2;
			%>
			Subtraction of two numbers is <%=add %>
			<%
		}
		else if(op.equals("mul")){
			int add= num1*num2;
			%>
			Multiplication of two numbers is <%=add %>
			<%
		}
		else if(op.equals("div")){
			int add= num1/num2;
			%>
			Division of two numbers is <%=add %>
			<%
		}
	%>
</body>
</html>
