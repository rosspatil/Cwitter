package com.rosspatil;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class FileUpload {

	public FileUpload(InputStream in,String userId) {
	
		
		
		
			try {
				Connection connection = Database.getConnection(); 
				PreparedStatement pst=connection.prepareStatement("UPDATE images set photo=? where userid=?");
				pst.setBlob(1, in);
				pst.setString(2, userId);
				pst.executeUpdate();
				System.out.println("uploading image.....");
				pst.close(); 
				connection.close(); 
			} 
			catch (SQLException e) {
				
			System.err.println(e.getMessage());
			} 
			
			
			
		
	}

}
