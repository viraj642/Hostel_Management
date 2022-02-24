package hostdb;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class complaintdao 
{
	Connection con = null;
    PreparedStatement st = null;
    String url="jdbc:mysql://localhost:3306/hostel";
    String uname="root";
    String pass="viraj@642";
    String query;
	public boolean check(String name,String comptype,String complain,java.sql.Date date,InputStream inputStream,int room_no) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
		if(inputStream!=null)
		{
			query = "INSERT INTO complaint (room_no,name,comptype,complaint,date,file) VALUES(?,?,?,?,?,?)";
			st = con.prepareStatement(query);
			st.setInt(1, room_no);
			st.setString(2, name);
			st.setString(3, comptype);
			st.setString(4, complain);
			st.setDate(5, date);
			st.setBlob(6, inputStream);
		}
		else
		{
			query = "INSERT INTO complaint (room_no,name,comptype,complaint,date) VALUES(?,?,?,?,?)";
			st = con.prepareStatement(query);
			st.setInt(1, room_no);
			st.setString(2, name);
			st.setString(3, comptype);
			st.setString(4, complain);
			st.setDate(5, date);
		}
			 
		int rs = st.executeUpdate();
		if(rs>0)
		{
			return true;
		}
		return false;	
	}
}
