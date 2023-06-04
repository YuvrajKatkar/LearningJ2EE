package ServletCookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fetchCookie")
public class FetchCookie extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies =  req.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie= cookies[i];
				System.out.println(cookie.getValue());
			}
		}
		else {
			System.out.println("Cookies are not present");
		}
	}
}
