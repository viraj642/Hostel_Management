package host;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostdb.resetpassdao;

@WebServlet("/resetpass")
public class resetpass extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String username = request.getParameter("uname");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		System.out.println(username+" "+password1+" "+password2);
		
		if(true)
		{
			resetpassdao dao = new resetpassdao();
			
			Boolean x = null;
			try {
				x = dao.check(username, password1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x)
			{
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><b>Password changed successfuly"
							+ "</b></body></html>");
				response.sendRedirect("StudentLogin_form.html"); 
			}
		}
		else
		{
			PrintWriter out = response.getWriter(); 
			out.println("<html><body><b>Password did not match: Please try again..."
						+ "</b></body></html>");
			response.sendRedirect("ResetPassword.html");
		}
	}

}
