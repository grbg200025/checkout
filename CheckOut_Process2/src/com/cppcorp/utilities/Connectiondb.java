/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.utilities;
import java.sql.*;
import com.cppcorp.entities.Area;
/**
 *
 * @author grbg
 */
public class Connectiondb {
    public ResultSet query(String query) {
        ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/process_checkout","root",""
                        );
                        
                        Statement stmt =con.createStatement();  
                        rs = stmt.executeQuery(query);
                        
		}catch(Exception e) {
			e.printStackTrace();
		}
        return rs;        
	}
}
