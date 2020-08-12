package tp.kits3.livedinner.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tp.kits3.livedinner.dao.*;
import tp.kits3.livedinner.vo.Tag;
import tp.kits3.livedinner.connectDB.ConnectDB;

/**
 * Servlet implementation class tagServlet
 */
@WebServlet("/tagServlet/*")
public class tagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public tagServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		tagDao dao = new tagDao();
		Tag tag = new Tag();
		getActionUser(tag,request);
		dao.getDataFormTableTag(tag);
		
		String table = "<table>";
		table += "<tr>"+"<th>"+"ID"+"</th>" +"<th>" +"Name"+"</th>" + "</tr>";
		table += "<tr>"+"<th>"+tag.getTagid()+"</th>" +"<th>" +tag.getTgname()+"</th>" + "</tr>";
		table += "</table>";
		response.getWriter().print(table);
	}
	public void getActionUser(Tag tag, HttpServletRequest request) {
		
		String[] uri = request.getRequestURI().split("/");
		System.out.println(uri[uri.length-1]);
		String cmd = uri[uri.length-1];
		tagDao dao = new tagDao();
		
		if("insert".equals(cmd)) {
			String req = request.getParameter("tagname");
			tag.setTgname(req);
			dao.save(tag);
		}
		if("update".equals(cmd)) {
			String req = request.getParameter("tagname");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
