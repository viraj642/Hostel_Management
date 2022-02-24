package host;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hostdb.adminlogindao;

@WebServlet("/admin")
public class adminlogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		response.setContentType("text/html");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		System.out.println(username+" "+password);
		
		adminlogindao dao = new adminlogindao();
		
		try {
			Boolean x = dao.check(username, password);
			if(x)
			{
				response.sendRedirect("admincomplaint.jsp");
				return;
			}
			else
			{
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><b>Incorrect username or password"
							+ "</b></body></html>");
				response.sendRedirect("AdminLogin_form.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
