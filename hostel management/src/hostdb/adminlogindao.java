package hostdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class adminlogindao 
{
	Connection con = null;
	PreparedStatement st = null;
    String url="jdbc:mysql://localhost:3306/hostel";
    String uname="root";
    String pass="viraj@642";
    String query;
	 public boolean check(String username,String password) throws SQLException, ClassNotFoundException
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
			query = "select * from admin where username=? and password=?";
			st = con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				/*HttpSession session = request.getSession();
				query = "select name, room_no from student where username=? and password=?";
				st = con.prepareStatement(query);
				st.setString(1, username);
				st.setString(2, password);
			    rs = st.executeQuery();
			    rs.next();
			    String name = rs.getString("name");
			    int room_no = rs.getInt("room_no");
			    session.setAttribute("name",name);
		        session.setAttribute("roomno",room_no);*/
				return true;
			}
			return false;
		}
}
