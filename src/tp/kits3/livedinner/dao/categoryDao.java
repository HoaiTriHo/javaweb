package tp.kits3.livedinner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import tp.kits3.livedinner.vo.*;

public class categoryDao extends generalDao{
	DataSource datasource;
	
	public categoryDao() {
		try {
			Context ctx = new InitialContext();
			//get info tomcat
			Context envCtx = (Context)ctx.lookup("java:/comp/env");
			//get info context.xml
			this.datasource = (DataSource) envCtx.lookup("jdbc/mariadb");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getDataFormTableCategory(Category cate) {
		String sql = "select * from cateogy";

		ResultSet rs = getData(sql);
		
		try {
			while (rs.next()) {
				cate.setCtgid(rs.getInt("ctgid"));
				cate.setCtname(rs.getNString("ctname"));
				cate.setService(rs.getNString("service"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	public List<Category> findAll(){
		List<Category> list = new ArrayList<Category>();
		try {
			Connection conn = this.datasource.getConnection();
			
			String sql_SelectAll = "select * from cateory";
			
			PreparedStatement pre =  conn.prepareStatement(sql_SelectAll);
			
			ResultSet rs  = pre.executeQuery();
			
			
			while(rs.next()) {
				Category category = new Category();
				category.setCtgid(rs.getInt("ctgid"));
				category.setCtname(rs.getNString("ctname"));
				category.setService(rs.getNString("service"));
				list.add(category);
			}
			
			rs.close();
			pre.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public void save(Category cate) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			conn = this.datasource.getConnection();
			String sql_Insert = "insert into cateory(ctname, service) values(?,?)";
			pre = conn.prepareStatement(sql_Insert);
			pre.setString(1, cate.getCtname());
			pre.setString(2, cate.getService());
			
			if(!pre.execute())
				System.out.println("Insert sucess!");
			else
				System.out.println("No insert!!");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Category findOne(int ctgid) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pre = null;
		Category category = null;
		try {
			conn = this.datasource.getConnection();
			String sql_update = "select * from cateory where ctgid = ?";
			pre = conn.prepareStatement(sql_update);
			pre.setInt(1, ctgid);
			rs = pre.executeQuery();
			
			if(rs.next()) {
				category = new Category();
				category.setCtgid(rs.getInt("ctgid"));
				category.setCtname(rs.getNString("ctname"));
				category.setService(rs.getNString("service"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
	public void update(Category cate) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			conn = this.datasource.getConnection();
			String sql_Update = "update cateory set ctname = ?, service = ? where ctgid = ?";
			pre = conn.prepareStatement(sql_Update);
			
			pre.setNString(1, cate.getCtname());
			pre.setNString(2, cate.getService());
			pre.setInt(3, cate.getCtgid());
			
			if(!pre.execute())
				System.out.println("Update sucess!");
			else
				System.out.println("No insert!!");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
