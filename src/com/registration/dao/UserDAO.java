package com.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.registration.model.User;

//Data Access Object
public class UserDAO {
	public UserDAO() {}
	
	private Connection getDBConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info_db","root","root");
		return conn;
	}
	public int insertUser(User user) throws Exception {
		String sql="insert into users(name, emailId, country) values(?,?,?)";
		PreparedStatement ps = getDBConnection().prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmailId());
		ps.setString(3, user.getCountry());
		return ps.executeUpdate();
	}
	public List<User> getAllUsers() throws Exception{
		PreparedStatement ps = getDBConnection().prepareStatement("Select * from users");
		ResultSet rs = ps.executeQuery();
		List<User> users = new ArrayList<User>();
		while(rs.next()) {
			User user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmailId(rs.getString(3));
			user.setCountry(rs.getString(4));
			users.add(user);
		}
		return users;
	}
	public User getUser(int id) throws Exception {
		PreparedStatement ps = getDBConnection().prepareStatement("Select * from users where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		User user=new User();
		while(rs.next()) {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmailId(rs.getString(3));
			user.setCountry(rs.getString(4));
		}
		return user;
	}
	public boolean deleteUser(int id) throws Exception {
		PreparedStatement ps = getDBConnection().prepareStatement("delete from users where id = ?");
		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	}
	public boolean updateUser(User user) throws Exception {
		PreparedStatement ps = getDBConnection().prepareStatement("update users set name=?, emailId=?, country=? where id=?");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmailId());
		ps.setString(3, user.getCountry());
		ps.setInt(4, user.getId());
		return ps.executeUpdate() > 0;
		
	}
}
