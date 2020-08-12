package tp.kits3.livedinner.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tp.kits3.livedinner.vo.*;
import tp.kits3.livedinner.dao.*;

import tp.kits3.livedinner.connectDB.ConnectDB;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/category/list")
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		categoryDao dao = new categoryDao();
		
		List<Category> list = dao.findAll();
		if(list.size() == 0) {
			System.out.println("No data");
		}
		
		String divList = "<div class='ctgList'>";
		for(Category ct : list) {
			divList += "<p><a href='update?ctgid="+ct.getCtgid()+"'>"+ct.toString()+"</a></p>";
		}
		divList += "</div>";
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(divList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
