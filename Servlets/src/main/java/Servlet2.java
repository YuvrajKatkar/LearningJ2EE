import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/second")
public class Servlet2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Servlet 2 invoked");
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("password"));
	}

}
