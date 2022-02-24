package host;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hostdb.registerdao;

@WebServlet("/register")
public class register extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
        int room_no = Integer.parseInt(request.getParameter("roomno"));
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);
        session.setAttribute("roomno",room_no);
		System.out.println(name+" "+username+" "+gender+" "+email+" "+password+" "+room_no);
		registerdao dao = new registerdao();
		try {
				Boolean x=dao.check(name, email, username, password, gender, room_no);
				if(x)
				{
					PrintWriter out = response.getWriter(); 
					out.println("<html><body><b>Successfuly registered"
								+ "</b></body></html>");
					response.sendRedirect("StudentLogin_form.html");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
