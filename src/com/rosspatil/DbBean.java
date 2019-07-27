package com.rosspatil;

import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.ArrayList; 
import java.util.Enumeration;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*; 

public class DbBean {
	
	
	public String loginCheck(String emailId, String password){
		String userId=null;
		try {
			
			Connection connection = Database.getConnection(); 
			Statement st = connection.createStatement(); 
			ResultSet rs=st.executeQuery("SELECT * FROM users WHERE emailId='"+emailId+"' AND password='"+password+"'");
			while(rs.next()){
				if(rs.getString(4).equals(emailId) && rs.getString(7).equals(password)){
					userId=rs.getString(1);
				}
			}
			st.close(); 
			connection.close(); 
		} 
		catch (SQLException e) {
			
		System.err.println(e.getMessage());
		} 
		
		return userId;
	}
	
	public byte[] getImage(String userId){
		byte[] photo=new byte[100000];
		try {
			Connection connection = Database.getConnection();
			PreparedStatement pst=connection.prepareStatement("Select photo From images where userid=?");
			pst.setString(1, userId);
			ResultSet rs=pst.executeQuery();
			InputStream in=rs.getBinaryStream(1);
			in.read(photo);
			System.out.println(userId);
			pst.close(); 
			connection.close(); 
		} 
		catch (SQLException e) {
			
		System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return photo;
	}
	
	public String singUp(UserInfo info,InputStream inputStream){
		String userId=" ";
		try {
			StringTokenizer stringTokenizer=new StringTokenizer(info.getEmailId(), "@");
			userId=stringTokenizer.nextToken();
			Connection connection = Database.getConnection(); 
			Statement st = connection.createStatement(); 
			st.execute("INSERT INTO users VALUES('"+userId+"','"+info.getFirstName()+"','"+info.getLastName()+"','"+info.getEmailId()+"','"+info.getDob()+"','"+info.getMobile()+"','"+info.getPassword()+"')");
			PreparedStatement pst=connection.prepareStatement("INSERT INTO images VALUES(?,?)");
			pst.setString(1, userId);
			pst.setBlob(2, inputStream);
			pst.execute();
			System.out.println(userId);
			st.close(); 
			connection.close(); 
		} 
		catch (SQLException e) {
			
		System.err.println(e.getMessage());
		} 
		
		
		return userId;
	}

	
	public  UserInfo getUser(String userId){
		UserInfo info=new UserInfo();
		try{
		Connection connection = Database.getConnection(); 
		Statement st = connection.createStatement(); 
		ResultSet rs=st.executeQuery("SELECT * FROM users WHERE userid='"+userId+"'");
		while (rs.next()) {
			info.setFirstName(rs.getString(2));
			info.setLastName(rs.getString(3));
			info.setEmailId(rs.getString(4));
			info.setDob(rs.getString(5));
			info.setMobile(rs.getString(6));
			info.setPassword("");
			
		}
		st.close();
		rs.close();
		
		}catch(Exception e){System.err.println(e.getMessage());}
		System.out.println(info);
		return info;
	}
	
	
	public ResultSet getTweets(){
		ResultSet rs=null;
		try {
			Connection connection = Database.getConnection(); 
			Statement s = connection.createStatement(); 
			String sql = "SELECT * FROM tweets;" ;
			 rs = s.executeQuery(sql); 
			 
			
		} 
		catch (SQLException e) {} 
		
		return rs;
	}

	public void storeTweets(String userId, String tweet) {
		try {
			Connection connection = Database.getConnection(); 
			PreparedStatement pst=connection.prepareStatement("INSERT INTO tweets VALUES(?,?)");
			pst.setString(1, userId);
			pst.setString(2, tweet);
			pst.execute();
			pst.close(); 
			connection.close(); 
		} 
		catch (SQLException e) {
			
		System.err.println(e.getMessage());
		} 
		
	}


}