package tp.kits3.livedinner.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp.kits3.livedinner.vo.*;

public class menuDao extends generalDao{

	public void getDataFormTableMenu(Menu menu) {
		String sql = "select * from menu";

		ResultSet rs = getData(sql);
		
		try {
			while (rs.next()) {
				menu.setMuid(rs.getInt("muid"));
				menu.setMuname(rs.getNString("muname"));
				menu.setIntro(rs.getNString("intro"));
				menu.setDetails(rs.getNString("details"));
				menu.setPrice(rs.getDouble("price"));
				menu.setCurrency(rs.getNString("currency"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
}
