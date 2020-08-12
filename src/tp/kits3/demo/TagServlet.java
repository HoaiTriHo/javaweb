package tp.kits3.demo;

import java.io.*;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import tp.kits3.livedinner.connectDB.ConnectDB;

@WebServlet("/tag")
public class TagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TagServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/livedinner", "root", "hoaitri7");
//			
//			String sql = "select*from tag";
//			
//			Statement state = conn.createStatement();
//			
//			ResultSet result = state.executeQuery(sql);
//			
//			while(result.next()) {
//				response.getWriter().println("Id: "+result.getInt("tagid")+"</br>"+"Name: "+result.getNString("tgname"));
//				
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Connection conn = ConnectDB.connectDB();
		
		String sql = "select*from tag";
		
		Statement state;
		try {
			state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			while(result.next()) {
				response.getWriter().println("Id: "+result.getInt("tagid")+"</br>"+"Name: "+result.getNString("tgname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
