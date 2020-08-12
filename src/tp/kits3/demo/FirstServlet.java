package tp.kits3.demo;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/hai")
public class FirstServlet implements Servlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
		System.out.println("FirstServlet :: init");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FirstServlet :: service");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("FirstServlet :: destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
