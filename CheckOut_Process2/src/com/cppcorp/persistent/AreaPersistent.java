/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.entities.Area;
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
public class AreaPersistent extends Area {
    /**
     * This gets all Areas
     * @param aux
     * @return all areas in the data base
     * @throws SQLException 
     */
    
    /**
     * Insert a new Area to the data base
     * @param aux 
     */
    public void insert(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "INSERT INTO area (name) VALUES (?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.execute();
            
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            
        }finally{
            try {
                if(rs != null)rs.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(ps != null)ps.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(conn != null)conn.close();
            } catch (SQLException e) {
                /* ignored */ }
        }
        
    }
    
    /**
     * Check if the name exists in the data base
     * @param name 
     * @return 
     */
    public boolean nameExists(String name){
        //What is going to return
        boolean result = true;
        
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        
        try{
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "SELECT * FROM area  WHERE name = (?)";
            
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            result = rs.next();
            
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            
        }finally{
            try {
                if(rs != null)rs.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(ps != null)ps.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(conn != null)conn.close();
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return result;
        
    }
    
    /**
     * 
     * @return get all the areas
     * @throws SQLException 
     */
    public List<Area> getAll() throws SQLException{
        
        //What is going to return
        List<Area> areas = new ArrayList();
        
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        
        try{
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "SELECT * FROM area";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            rs = preparedStmt.executeQuery();
            
            while(rs.next()){
                Area area = new Area();
                area.id = rs.getInt("id");
                area.name = rs.getString("name");
                areas.add(area);
            }
            
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            
        }finally{
            //Close everything avoid get any error for multiple conections
            try {
                if(rs != null)rs.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(ps != null)ps.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(conn != null)conn.close();
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return areas;
        
    }
    
    /**
     * 
     * @param id the id of the Area what is require
     * @return Area by id
     * @throws SQLException 
     */
    public Area getById(int id) throws SQLException{
        
        //What is going to return
        Area area = new Area();
        
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "SELECT * FROM area WHERE id = ?";
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            area.id = rs.getInt("id");
            area.name = rs.getString("name");
            }
        }    
        catch(SQLException e){
            
        }catch (ClassNotFoundException ex) {
            
        }finally{
            try {
                if(rs != null)rs.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(ps != null)ps.close();
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if(conn != null)conn.close();
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return area;
        
    }
}
