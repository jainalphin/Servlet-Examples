

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int count=0; 
    public LoginCheck() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pass = request.getParameter("pass");
		String s=String.valueOf(count);
		Cookie c1 = new Cookie("visiting_times",s);
		response.addCookie(c1);
		 int j=Integer.parseInt(c1.getValue());
		if(name.equals("alph") && pass.equals("alph"))
		{
			count=0;
			response.sendRedirect("hello.jsp"); 
		}
		else
		{
			if(j>3)
			{
				HttpSession session = request.getSession();
				session.invalidate();
				response.getWriter().println("Session is destroyed try again pls try again<br>" + session);
			}
			else
			{
			out.println("login error.......");
			out.println("<a href='login.jsp'>Back to login page</a>");
			count++;
			}
		}
		
	}

}
