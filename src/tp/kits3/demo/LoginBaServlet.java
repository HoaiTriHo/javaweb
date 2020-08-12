package tp.kits3.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginBaServlet
 */
@WebServlet("/login3")
public class LoginBaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginBaServlet() {
        super();
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name =  request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		String message = "not valid info";
		
		if(!name.isEmpty()) {
			if(!pass.isEmpty() && pass.length() > 11) {
				message = "vailed info";
			}
		}
		
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(message);
	}
}
