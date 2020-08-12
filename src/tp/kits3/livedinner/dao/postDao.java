package tp.kits3.livedinner.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import tp.kits3.livedinner.vo.*;

public class postDao extends generalDao{

	public void getDataFormTablePost(Post post) {
		String sql = "select * from post";

		ResultSet rs = getData(sql);
		
		try {
			while (rs.next()) {
				post.setPid(rs.getInt("pid"));
				post.setTitle(rs.getNString("title"));
				post.setByname(rs.getNString("byname"));
				post.setRegdate(rs.getTimestamp("regdate"));
				post.setContent(rs.getNString("content"));
				post.setVisible(rs.getBoolean("visible"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
}
