

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pract5_c
 */
@WebServlet("/Pract5_c")
public class Pract5_c extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pract5_c() {
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
		PrintWriter o1 =response.getWriter();
		
		o1.print("<html><head><title>Context Attribute</title></head>");
		ServletContext context= getServletContext();
		String name1 =request.getParameter("name");
		String value1=request.getParameter("vlaue");
		String action =request.getParameter("action");
		
		
		
		if(action==null)
		{	
			o1.print("nothing is been choosed");
			
		}
		else if(action.equals("add"))
		{
			String getVal =(String) context.getAttribute(name1);
			if(getVal==null)
			{
				context.setAttribute(name1, value1);
				o1.print("Atribute added");
			}
			else
			{
				context.setAttribute(name1, value1);
				o1.print("Atribute replaced");
			}
		}
		else if(action.equals("remove"))
		{
			String getVal =(String) context.getAttribute(name1);
			if(getVal==null)
			{
				//context.setAttribute(name, value);
				o1.print("Atribute doesnt exists");
			}
			else
			{
				context.removeAttribute(name1);
				o1.print("Atribute removed");
			}
		}
		else {
			String getVal =(String) context.getAttribute(name1);
			if(getVal==null)
			{
				context.setAttribute(name1, value1);
				o1.print("Atribute added");
			}
			else
			{
				context.setAttribute(name1, value1);
				o1.print("Atribute replaced");
			}
			
		}
		o1.print("<center><br><br>");
        o1.print("<a href='index.html'>Back to homepage</a>");
        o1.print("</center></body></html>");		
		
		
	}

}
