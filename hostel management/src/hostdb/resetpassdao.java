package hostdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class resetpassdao 
{
	Connection con = null;
	PreparedStatement st = null;
    String url="jdbc:mysql://localhost:3306/hostel";
    String uname="root";
    String pass="viraj@642";
    String query;
    
    public boolean check(String username,String password) throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
		query = "update student set password=? where username=?";
		st = con.prepareStatement(query);
		st.setString(1, password);
		st.setString(2, username);
		int rs = st.executeUpdate();
		if(rs>0)
		{
			return true;
		}
		return false;
    }
}
