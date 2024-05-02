package rhd1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SignIn1")
public class Signin extends HttpServlet{  
	//private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
			{  
			res.setContentType("text/html");  
			PrintWriter pw=res.getWriter();  
			    String Username=req.getParameter("Username");
				String Passwords=req.getParameter("Passwords");
				String cpasswords=req.getParameter("Confirm passwords");
				String email=req.getParameter("email");
				int ContactNumber=Integer.parseInt(req.getParameter("ContactNumber"));
			
				pw.println("<h1>");
				pw.println("<br/>Username "+Username); 
				pw.println("<br/>Passwords:"+Passwords);
				pw.println("<br/>confirmpassword:"+cpasswords);
				pw.println("<br/>email:"+email);
				pw.println("<br/>ContactNumber:"+ContactNumber+"<br/>"); 
				
				pw.println("Username "+Username); 
				pw.println("Password:"+Passwords);
				pw.println("confirmpassword:"+cpasswords);
				pw.println("email:"+email);
				pw.println("ContactNumber:"+ContactNumber); 
				
				try 
			  {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signin", "root", "root");
			         PreparedStatement stmt=con.prepareStatement("insert into details values(?,?,?,?)");
			         stmt.setString(1, Username);
			         stmt.setString(2, Passwords);
			         stmt.setString(3, cpasswords);
			         stmt.setString(4, email);
			         stmt.setInt(5, ContactNumber);
			         
			         int rs=stmt.executeUpdate();
			         pw.println(rs+ "records inserted");
			         if (rs >= 1) {
						System.out.println("Success");
			         } else {
							System.out.println("Not success");

						}
						con.close();
					} catch (Exception e) {
						System.out.println(e);
					}
			pw.close();  
			}
	{
	}
}
