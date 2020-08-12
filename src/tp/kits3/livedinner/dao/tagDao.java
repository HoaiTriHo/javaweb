package tp.kits3.livedinner.dao;

import tp.kits3.livedinner.connectDB.ConnectDB;
import tp.kits3.livedinner.vo.*;
import java.sql.*;

public class tagDao extends generalDao{
	
	public void getDataFormTableTag(Tag tag) {
		String sql_SelectAll = "select * from tag";
		
		ResultSet result  =  getData(sql_SelectAll);
		
		try {
			while(result.next()) {
				tag.setTagid(result.getInt("tagid"));
				tag.setTgname(result.getNString("tgname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void save(Tag tag) {
		String sql_insert = "insert into tag(tgname) values(?)";
		Connection conn;
		conn = ConnectDB.connectDB();
		
		try {
			PreparedStatement pre  = conn.prepareStatement(sql_insert);
			pre.setString(1, tag.getTgname());
			if(!pre.execute()) {
				System.out.println("Insert sucess");
			}
			else {
				System.out.println("Insert fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(Tag tag) {
		if(tag.getTagid() <= 0) {
			save(tag);
			return;
		}
		String sql_insert = "update tag set tgname = ?"+"where tagid = ?";
		Connection conn;
		conn = ConnectDB.connectDB();
		
		try {
			PreparedStatement pre  = conn.prepareStatement(sql_insert);
			pre.setString(1, tag.getTgname());
			pre.setInt(2, tag.getTagid());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
