package hostdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerdao {
	Connection con = null;
    PreparedStatement st = null;
    String url="jdbc:mysql://localhost:3306/hostel";
    String uname="root";
    String pass="viraj@642";
    String query;
	public boolean check(String name,String email,String username,String password,String gender,int room_no) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
		query = "INSERT INTO student (name,email,gender,room_no,username,password) VALUES(?,?,?,?,?,?)";
		st = con.prepareStatement(query);
		st.setString(1,name);
		st.setString(2, email);
		st.setString(3, gender);
		st.setInt(4, room_no);
		st.setString(5, username);
		st.setString(6, password);
		 
		int rs = st.executeUpdate();
		if(rs>0)
		{
			return true;
		}
		return false;
	}

}
