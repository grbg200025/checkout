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
    
    
    public ResultSet querySelect(String query) {
        ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/process_checkout","root",""
                        );
                        
                        Statement stmt =conn.createStatement();  
                        rs = stmt.executeQuery(query);
                        
		}catch(Exception e) {
			e.printStackTrace();
		}
                
        return rs;        
	}
    public void queryInsert(String query, PreparedStatement preparedstatement){
        
    }
}
