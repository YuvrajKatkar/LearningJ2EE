package HTTPSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/saveDataInSession")
public class SaveDataInSession extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession= req.getSession();
		String name= req.getParameter("name");
		String idString= req.getParameter("id");
		httpSession.setAttribute("id", idString);
		httpSession.setAttribute("Name", name);
		
		
//		int id= (Integer)httpSession.getAttribute("id");
//		String nameString = (String) httpSession.getAttribute("Name");
//		int age= (Integer)httpSession.getAttribute("age");
//		System.out.println(id);
//		System.out.println(nameString);
//		System.out.println(age);
		
		RequestDispatcher requestDispatcher= req.getRequestDispatcher("/Session2.html");
		requestDispatcher.forward(req, resp);
	}
}
