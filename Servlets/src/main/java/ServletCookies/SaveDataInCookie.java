package ServletCookies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/csk")
public class SaveDataInCookie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailString = req.getParameter("email");
		String password = req.getParameter("pass");
		Cookie cookie = new Cookie("Yuvraj", "123");
		Cookie cookie1 = new Cookie("email", emailString);
		Cookie cookie2= new Cookie("password", password);
//		setMaxAge is used to set duration in second datatype is in int for cookies
		cookie.setMaxAge(60);
		cookie1.setMaxAge(60);
		cookie2.setMaxAge(60);
		resp.addCookie(cookie2);
		resp.addCookie(cookie1);
		resp.addCookie(cookie);
		RequestDispatcher requestDispatcher =  req.getRequestDispatcher("two.html");
		requestDispatcher.forward(req, resp);
		
	}
	
}
