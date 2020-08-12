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
 * Servlet implementation class categoryUpdateServlet
 */
@WebServlet("/category/update")
public class categoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public categoryUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int ctgid = Integer.parseInt(request.getParameter("ctgid"));
		categoryDao dao = new categoryDao();
		Category category = dao.findOne(ctgid);

		if (category == null) {
			System.out.println("No data category");
		} else {
			String form = "<div><form method='post' action='update'>";
			
			form += "ID: <input type='text' name='ctgid' value='" + category.getCtgid() + "' readonly>";
			form += "Name: <input type='text' name='ctgname' value='" + category.getCtname() + "'>";
			form += "Name: <input type='text' name='service' value='" + category.getService() + "'>";
			form += "<input type='submit' value='Update'>";

			form += "</form></div>";

			response.getWriter().println(form);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		categoryDao dao = new categoryDao();
		Category category = new Category();
		
		category.setCtgid(Integer.parseInt(request.getParameter("ctgid")));
		category.setCtname(request.getParameter("ctgname"));
		category.setService(request.getParameter("service"));
		
		dao.update(category);
	}

}
