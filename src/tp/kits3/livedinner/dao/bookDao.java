package tp.kits3.livedinner.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp.kits3.livedinner.vo.*;

public class bookDao extends generalDao {
	
	public void getDataFormTableBook(Book bk) {
		String sql = "select * from book";

		ResultSet rs = getData(sql);
		
		try {
			while (rs.next()) {
				bk.setBkid(rs.getInt("bkid"));
				bk.setBkname(rs.getNString("bkname"));
				bk.setBkemail(rs.getNString("bkemail"));
				bk.setBkphone(rs.getNString("bkphone"));
				bk.setBktime(rs.getTimestamp("bktime"));
				bk.setBknum(rs.getInt("bknum"));
				bk.setBooking(rs.getNString("booking"));
				bk.setBkmemo(rs.getNString("bkmemo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
}
