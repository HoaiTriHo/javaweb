package tp.kits3.livedinner.connectDB;

import java.sql.*;


public class ConnectDB {
	public static Connection connectDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mariadb://localhost:3306/livedinner", "root", "hoaitri7");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
