package tp.kits3.livedinner.dao;

import tp.kits3.livedinner.connectDB.*;

import java.io.IOException;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import tp.kits3.livedinner.vo.*;

public class generalDao {

	public ResultSet getData(String sql) {
		Connection conn = null;
		ResultSet result = null;
		Statement state = null;
		conn = ConnectDB.connectDB();

		try {
			state = conn.createStatement();
			result = state.executeQuery(sql);

			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return null;
	}
}
