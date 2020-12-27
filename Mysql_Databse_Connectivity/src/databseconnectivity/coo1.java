package databseconnectivity;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class coo1
 */
@WebServlet("/coo1")
public class coo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coo1() {
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alph","root","");
			System.out.println("Connection Established...");
			String id=request.getParameter("id"); 
			String name=request.getParameter("name"); 
			
			/*Statement st= con.createStatement();
			String s = "insert into login values('"+id+"','"+name+"')";
			st.execute(s);
			System.out.println("DATA INSERTED.....");*/
			PreparedStatement st = con.prepareStatement("insert into login(id,name) values(?,?)");
			st.setString(1, id);
			st.setString(2, name);
			int x = st.executeUpdate();
			if(x>0)
			{
				request.setAttribute("msg", "insert.....");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			else
			{
				{
					request.setAttribute("msg", " not insert.....");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			/*
			 * PreparedStatement st = con.
			 * prepareStatement("insert into details(fname,lname,uname,password) values(?,?,?,?)"
			 * ); st.setString(1,fname); st.setString(2,lname); st.setString(3,uname);
			 * st.setString(4,pass); System.out.println("DATA INSERTED.....");
			 * request.setAttribute("msg", "inserted....");
			 */
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
