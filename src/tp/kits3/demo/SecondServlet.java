package tp.kits3.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/second")
public class SecondServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out =  res.getWriter();
		
		out.println("<html><head><title>SecondServlet</title></head>");
		out.println("<body>");
		out.println("<h1>Second Servlet by response object </h1>");
		out.println("</body></html>");
	}
	
}
