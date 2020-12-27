package items;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TotalBilling")
public class TotalBilling extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static int total;
    public TotalBilling() {
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
		PrintWriter out =response.getWriter();
		String [] total_shirt = request.getParameterValues("shirt");
		for(int i=0;i<total_shirt.length;i++)
		{
				if(total_shirt[i].equals("blue shirt"))
				{
					String m = request.getParameter("blue");
					int no = Integer.valueOf(m);
				total =total+no*2500;
				out.println("<center><b>");
				out.println("purchase blue shirt price is...."+2500+"<br>");
			}
			if(total_shirt[i].equals("red shirt"))
			{
				String m = request.getParameter("red");
				int no = Integer.valueOf(m);
				total =total+no*3500;
				out.println("purchase total red shirt "+no+" and price is of one red shirt is..."+3500+"<br>");
			}
			if(total_shirt[i].equals("white shirt"))
			{
				String m = request.getParameter("white");
				int no = Integer.valueOf(m);
				total =total+no*1500;
				out.println("purchase white shirt price is...."+1500+"<br>");
			}if(total_shirt[i].equals("green shirt"))
			{
				String m = request.getParameter("green");
				int no = Integer.valueOf(m);
				total =total+no*500;
				out.println("purchase green shirt price is...."+500+"<br>");
			}
		
		}
		out.println("<h2>total is...."+total+"</h2>");
		total=0;
		out.println("</center>");
	}

}
