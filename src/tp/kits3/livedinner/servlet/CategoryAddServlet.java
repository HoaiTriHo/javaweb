package tp.kits3.livedinner.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.kits3.livedinner.dao.categoryDao;
import tp.kits3.livedinner.vo.Category;

/**
 * Servlet implementation class CategoryAddServlet
 */
@WebServlet("/category/add")
public class CategoryAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CategoryAddServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form = "<div><form method='post' action='add'>";
		
		form += "Name: <input type='text' name='ctgname'>";
		form += "Service: <input type='text' name='service'>";
		form += "<input type='submit' value='Ok'>";

		
		form += "</form></div>";
		
		response.getWriter().println(form);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categoryDao dao = new categoryDao();
		Category category = new Category();
		
		category.setCtname(request.getParameter("ctgname"));
		category.setService(request.getParameter("service"));
		
		dao.save(category);
	}

}
