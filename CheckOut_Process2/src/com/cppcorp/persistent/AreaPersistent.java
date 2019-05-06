/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.entities.Area;
import com.cppcorp.utilities.Connectiondb;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grbg
 */
public class AreaPersistent {
    /**
     * This gets all Areas
     * @param aux
     * @return all areas in the data base
     * @throws SQLException 
     */
    
    public void Insert(String aux){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "INSERT INTO area (name) VALUES (?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, aux);
            preparedStmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean NameExists(String name){
        boolean result = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "SELECT * FROM area  WHERE name = (?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            ResultSet rs = preparedStmt.executeQuery();
            result = rs.next();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Area> getAll() throws SQLException{
        List<Area> areas = new ArrayList<>();
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM area");
        
        
        while(rs.next()){
            Area area = new Area();
            area.id = rs.getInt("id");
            area.name = rs.getString("name");
            areas.add(area);
        }
        
        return areas;
    }
    
    public Area getById(int id) throws SQLException{
        Area a = new Area();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "SELECT * FROM area WHERE id = ?";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            rs.next();
            a.id = rs.getInt("id");
            a.name = rs.getString("name");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
}
