package HTTPSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteDataFromSession
 */
@WebServlet("/deleteSessionObject")
public class DeleteDataFromSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession= request.getSession();
		httpSession.setAttribute("name", "ABC");
		httpSession.setAttribute("id", 10);
		System.out.println(httpSession.getAttribute("id"));
		System.out.println(httpSession.getAttribute("name"));
		httpSession.removeAttribute("name");
		System.out.println(httpSession.getAttribute("name"));
		httpSession.invalidate();
		//httpSession.getAttribute("name");
		//Throws exception
	}

}
