package pract7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class DatabseServelet
 */
@WebServlet("/DatabseServelet")
public class DatabseServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DatabseServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
        String no=request.getParameter("eid");
        String no1=request.getParameter("eid1");
        String name=request.getParameter("name");  
        String sal=request.getParameter("salary");  
        String age1=request.getParameter("age");  

        
        
		try {
			//ctrl+shif+T
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			Statement st = con.createStatement();
			String check="select * from marksheet where id ='"+no1+"'";
			ResultSet rs1=st.executeQuery(check);
			if(rs1.next())
			{
				String id =rs1.getString("id");
				String name1 =rs1.getString("name");
				String salary =rs1.getString("salary");
				String age =rs1.getString("age");
				out.println("<center><h3>");
				out.println("Hello Information of ID "+ id+ "is......<br>");
				out.println("Id is....."+id+"<br>");
				out.println("Name is...."+name1+"<br>");
				out.println("Salary is...."+salary+"<br>");
				out.println("Age is...."+age+"<br>");
				out.println("</center></h3>");
			}
			else {
				String s ="insert into marksheet(id,name,age,salary) values('"+no+"','"+ name+"','"+age1+"','"+sal+"')";
				rs1 =st.executeQuery(s);
				out.println("<center><h3>");
				out.println("SuccessFully inserted....");
				out.println("</center></h3>");
			}
			/*String s ="insert into marksheet values('"+no+"','"+ name+"','"+age1+"','"+salary+"')";
			ResultSet rs =st.executeQuery(s);
			out.println("SuccessFully inserted....");
			if(rs.next())
			{
				
				/*String id =rs.getString("id");
				String name1 =rs.getString("name");
				String salary =rs.getString("salary");
				String age =rs.getString("age");
				out.println("<center><h3>");
				out.println("Hello Information of ID "+ no+ "is......<br>");
				out.println("Id is....."+no+"<br>");
				out.println("Name is...."+name+"<br>");
				out.println("Salary is...."+sal+"<br>");
				out.println("Age is...."+age1+"<br");
				out.println("</center></h3>");
							
			}*/
			
			
		}catch(Exception ae)
		{
			out.println(ae);
		}
		
			}

}
