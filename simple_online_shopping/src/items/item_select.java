package items;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class item_select
 */
@WebServlet("/item_select")
public class item_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public item_select() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		Cookie ck[]= request.getCookies();
		if(ck != null)
		{
			response.sendRedirect("item.html");
		}
		else
		{
			out.print("something goes wrong plz login first");
			out.println("<a href ='index.html'>Back to login page</a>");
			
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		Cookie ck[]= request.getCookies();
		if(ck != null)
		{
			response.sendRedirect("item.html");
			//out.print("something goes wrong plz login first");
		}
		else
		{
			out.print("something goes wrong plz login first");
			out.println("<a href ='index.html'>Back to login page</a>");
			
		}
		
		
	}

}
