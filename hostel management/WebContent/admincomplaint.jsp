<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@page import= "java.sql.Connection"
import ="java.sql.DriverManager"
import ="java.sql.PreparedStatement"
import ="java.sql.ResultSet"
import ="java.sql.Statement"%>
<link rel="stylesheet" href="admincomplaint.css">
</head>
<body style="background: linear-gradient(135deg, #71b7e6, #9b59b6);">
	<h2 style="text-align:center">Student Complaints</h2>
	<%
	Connection con = null;
    String url="jdbc:mysql://localhost:3306/hostel";
    String uname="root";
    String pass="viraj@642";
    String query;
    try
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from complaint;");
    %><table border=1 style="text-align:center">
          <tr class ="tbhead" style="background-color: rgba(0,0,0,0.9); color: white">
             <th>Room No.</th>
             <th>Name</th>
             <th>Complaint Type</th>
             <th>Complaint</th>
             <th>Date Of Complaint</th>
          </tr>
        <%while(rs.next())
        {
            %>
            <tr>
                <td><%=rs.getInt(1) %></td>
                <td><%=rs.getString(2) %></td>
                <td><%=rs.getString(3) %></td>
                <td><%=rs.getString(4) %></td>
                <td><%=rs.getString(5) %></td>
                </tr>
            <%}%>
        </table><br>
    <%}
    catch(Exception e){
        out.print(e.getMessage());%><br><%
    }
    %>
</body>
</html>