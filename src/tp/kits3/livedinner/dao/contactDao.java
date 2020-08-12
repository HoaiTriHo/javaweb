package tp.kits3.livedinner.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp.kits3.livedinner.vo.*;

public class contactDao extends generalDao{

	public void getDataFormTableContact(Contact cont) {
		String sql = "select * from contact";

		ResultSet rs = getData(sql);
		
		try {
			while (rs.next()) {
				cont.setCoid(rs.getInt("coid"));
				cont.setConame(rs.getNString("coname"));
				cont.setPriphone(rs.getNString("priphone"));
				cont.setSubphone(rs.getNString("subphone"));
				cont.setEmail(rs.getNString("email"));
				cont.setAddress(rs.getNString("address"));
				cont.setUnused(rs.getBoolean("unused"));
				cont.setOpening(rs.getNString("opening"));
				cont.setWeekday(rs.getNString("weekday"));
				cont.setWeekend(rs.getNString("weekend"));
				cont.setAboutus(rs.getNString("aboutus"));
				cont.setLatitude(rs.getDouble("latitude"));
				cont.setLogitude(rs.getDouble("logitude"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
}
