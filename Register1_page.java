package rhd1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Datasheet")
public class Register1_page  extends HttpServlet{  
	//private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
			{  
			res.setContentType("text/html");  
			PrintWriter pw=res.getWriter();  
			
				int Slno=Integer.parseInt(req.getParameter("Slno"));;
				String rhd_names=req.getParameter("rhd_names");
				String Address=req.getParameter("Address");
				String Phone_number=req.getParameter("Phone_Number");
				pw.println("<h1>");
				pw.println("<br/>Slno "+Slno); 
				pw.println("<br/>rhd_names:"+rhd_names);
				pw.println("<br/>Address:"+Address);
				pw.println("<br/>Phone_number:"+Phone_number+"<br/>"); 
				
				pw.println("</h1>");
				
				pw.println("Slno "+Slno); 
				pw.println("rhd_names"+rhd_names);
				pw.println("Address"+Address);
				pw.println("Phone_number"+Phone_number);
			

			//pw.println("Welcome "+ snname);  
			  //System.out.println(name);
			  try 
			  {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rhd1", "root", "root");
			         PreparedStatement stmt=con.prepareStatement("insert into rhd2 values(?,?,?,?)");
			         stmt.setInt(1, Slno);
			         stmt.setString(2, rhd_names);
			         stmt.setString(3, Address);
			         stmt.setString(4, Phone_number);
			         
			         int rs=stmt.executeUpdate();
			         pw.println(rs+ "records inserted");
	
			       
			         if (rs >= 1) {
			        	
						System.out.println("Success");
			         }
                            else {
							System.out.println("Not success");

						}
			       
						con.close();
					} 
			 
			  catch (Exception e) {
						System.out.println(e);
					}
			 
			pw.close();  
			}
	{
	}
}
	
