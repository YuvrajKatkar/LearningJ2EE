import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/first")
public class Servlet1 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		res.getWriter().print(name);
		res.getWriter().print(email);
		res.getWriter().print(password);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcome2.html");
		requestDispatcher.include(req, res);
		res.setContentType("text/html");
		
	}

}
