package host;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostdb.logindao;

@WebServlet("/login")
public class login extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		logindao dao = new logindao();
		
		try {
			Boolean x = dao.check(username, password,request,response);
			if(x)
			{
				response.sendRedirect("complaint_page.html"); 
			}
			else
			{
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><b>Incorrect username or password"
							+ "</b></body></html>");
				response.sendRedirect("StudentLogin_form.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
