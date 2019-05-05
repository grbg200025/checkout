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
        Area area = new Area();
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT *  FROM area WHERE id = '"+String.valueOf(id)+"'");
        rs.next();
        area.id = rs.getInt("id");
        area.name = rs.getString("name");
        //Aqui se agregaran los procesos
        return area;
    }
}
