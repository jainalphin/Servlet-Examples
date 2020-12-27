package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count =1;
    
    public login() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			
			Statement stmt = con.createStatement();
			String s = "insert into login1(name,email) values('"+name+"','"+ email+"')";
			stmt.executeQuery(s);
			
			//out.println("successfully inserted");
			Cookie ck = new Cookie("name",name);
			String sk = String.valueOf(count);
			Cookie ck1 =new Cookie("times",sk);
			response.addCookie(ck1);
			response.addCookie(ck);
			
				
			RequestDispatcher rd=request.getRequestDispatcher("/item_select");  
	        rd.forward(request, response);  

			
			//response.sendRedirect("item_select");
			/*out.print("<form action='item.html'>");  
		    out.print("<input type='submit' value='go'>");  
		    out.print("</form>"); */
			
		}catch(Exception ae)
		{
			//out.println("errror.........."+ae);
			out.print("Sorry already exists<br>");  
			out.println("<a href ='index.html'>Back to login page</a>");
	                      
		}
		
		//out.println("Welcome to our site<a href='item_select.java'>goes to");
		
		
		
	}

}
