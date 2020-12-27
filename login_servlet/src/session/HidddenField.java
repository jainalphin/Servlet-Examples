package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HidddenField")
public class HidddenField extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HidddenField() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//out.print("ok");
		//String session=request.getParameter("session");
	
		if(id.equals("alph") && pwd.equals("alph"))
		{
			rd=request.getRequestDispatcher("welcome");
			rd.forward(request, response);
		}
		else
		{
			out.print("<p><h1>Incorrect pwd</p></h1>");
			rd=request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		
	}

}
