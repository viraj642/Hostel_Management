package host;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import hostdb.complaintdao;

@WebServlet("/complaint")
public class complaint extends HttpServlet 
{

	/**
	 * 
	 */
	//Recently food quality is not good, please look into that and make sure it will be better. 
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		String comptype = request.getParameter("comptype");
		String complaint = request.getParameter("compdetails");
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		boolean isMultipart;
		InputStream inputStream = null;
		isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
        	Part filePart = request.getPart("document");
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            inputStream = filePart.getInputStream();
        }
        System.out.println(comptype+" "+complaint+" "+date);
        HttpSession session=request.getSession();
        int room_no = (int)session.getAttribute("roomno");
        String name = (String)session.getAttribute("name");
        System.out.println(name+" "+room_no+" "+comptype+" "+complaint+" "+date);
        complaintdao complaint1 = new complaintdao();
        try {
			Boolean x = complaint1.check(name, comptype, complaint, date, inputStream, room_no);
			if(x)
			{
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><b>Successfully Inserted"
							+ "</b></body></html>");
				response.sendRedirect("index.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
