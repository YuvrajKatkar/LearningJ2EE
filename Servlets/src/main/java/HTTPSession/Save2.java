package HTTPSession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Save2")
public class Save2 extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession httpSession=	req.getSession();
	String id = (String) httpSession.getAttribute("id");
	String name = (String) httpSession.getAttribute("Name");
	System.out.println(id);
	System.out.println(name);
	httpSession.removeAttribute("Name");
	System.out.println(httpSession.getAttribute("Name")	);
}
}
