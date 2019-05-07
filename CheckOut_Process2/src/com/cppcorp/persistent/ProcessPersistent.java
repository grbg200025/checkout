/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.business.AreaBusiness;
import com.cppcorp.business.UserBusiness;
import com.cppcorp.entities.ProcessC;
import com.cppcorp.entities.User;
import com.cppcorp.utilities.Connectiondb;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author grbg
 */
public class ProcessPersistent {
    
    /**
     * This method returns all the
     * processes of area
     * @param id is the id of the area
     * @return
     * @throws SQLException 
     */
    public List<ProcessC> getByAreaId(int id) throws SQLException{
        //What is going to return
        List<ProcessC> processes = new ArrayList();
        
        //Other stuff you may need
        AreaBusiness ap = new AreaBusiness();
        ProcessC process;
        
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
	    //The process goes here...
            String query  = "SELECT * FROM process WHERE id_area = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            

            rs = ps.executeQuery();
            
            while(rs.next()){
                process = new ProcessC();
                process.id = rs.getInt(1);
                process.area = ap.getById(rs.getInt(2));
                process.name = rs.getString(3);
                process.user = getUsersById(process.id, process.area.id);
                processes.add(process);
            }
            
            
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            
        }finally{
            //Close everything avoid get any error for multiple conections
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { ps.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }
        //What is going to return goes here...
        return processes;
        
        /*List<ProcessC> processesc = new ArrayList<>();
        AreaPersistent ap = new AreaPersistent();
        //Aqui hay que hacer el desmadre para obtener el area en el proceso
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM process WHERE id_area = "+id);
        
        while(rs.next()){
             ProcessC p = new ProcessC();
             p.id = rs.getInt(1);
             p.area = ap.getById(rs.getInt(2));
             p.name = rs.getString(3);
             p.user = getUsersById(p.id, p.area.id);
             processesc.add(p);
        }
       
        return processesc;*/
    }
    
    public ProcessC getById(int id) throws SQLException{
        //What is going to return
        ProcessC process = new ProcessC();
        
        //Other stuff you may need
        AreaPersistent ap = new AreaPersistent();
        
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
	    //The process goes here...
            String query  = "SELECT * FROM process WHERE id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            

            rs = ps.executeQuery();
            
            if(rs.next()){
             
                process.id = rs.getInt(1);
                process.area = ap.getById(rs.getInt(2));
                process.name = rs.getString(3);
                process.user = getUsersById(process.id, process.area.id);
             
            }
            
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            
        }finally{
            //Close everything avoid get any error for multiple conections
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { ps.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }
        //What is going to return goes here...
        return process;
        
    }
    
    
    
    public boolean exists(int id_area, String name) throws SQLException{
        
        //What is going to return
        boolean found = false;
        
        //Other stuff you may need
        
        
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
            
            String query  = "SELECT * FROM process WHERE id_area = ? AND name = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id_area);
            ps.setString(2, name);
            

            rs = ps.executeQuery();
            
            while(rs.next()){
                found = true;
            }
            
        }catch(SQLException e){
            
        } catch (ClassNotFoundException ex) {
            
        }finally{
            //Close everything avoid get any error for multiple conections
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { ps.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }
        //What is going to return goes here...
        return found;
        
    }
    /**
     * This get all the process
     * @return
     * @throws SQLException 
     */
    public List<ProcessC> getAll() throws SQLException{
        List<ProcessC> processesc = new ArrayList<>();
        AreaPersistent ap = new AreaPersistent();
        //Aqui hay que hacer el desmadre para obtener el area en el proceso
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM process");
        
        while(rs.next()){
             ProcessC p = new ProcessC();
             p.id = rs.getInt(1);
             p.area = ap.getById(rs.getInt(2));
             p.name = rs.getString(3);
             p.user = getUsersById(p.id, p.area.id);
             processesc.add(p);
        }
        return processesc;
    }
    
    public void insert(int id_area, String name){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "INSERT INTO process (id_area, name) VALUES (?, ?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id_area);
            preparedStmt.setString(2, name);
            preparedStmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void insertUser(int id_area, int id_process, int id_user){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "INSERT INTO processuser (id_area, id_process, id_user) VALUES (?, ?, ?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id_area);
            preparedStmt.setInt(2, id_process);
            preparedStmt.setInt(3, id_user);
            
            preparedStmt.execute();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public List<User> getUsersById(int id, int id_area) throws SQLException{
        UserBusiness ub = new UserBusiness();
        List<User> users = new ArrayList<>();
        AreaPersistent ap = new AreaPersistent();
        //Aqui hay que hacer el desmadre para obtener el area en el proceso
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM processuser WHERE id_area = ("+id_area+") AND id_process = "+id);
        
        while(rs.next()){
             users.add(ub.getById(rs.getInt("id_user")));
        }
        return users;
    }
    
    public List<User> getUsersByIdNotIncluded(int id_process, int id_area) throws SQLException{
        UserBusiness ub = new UserBusiness();
        List<User> aux = ub.getAll();
        List<User> users = new ArrayList<>();
        AreaPersistent ap = new AreaPersistent();
        Connectiondb conn = new Connectiondb();
        
        aux = ub.getByAreaId(id_area);
        
        ResultSet rs = conn.querySelect("SELECT * FROM processuser");
        
        for(User a : aux){
            boolean exist = false;
            while(rs.next()){
                exist = (
                        a.area.id == id_area  &&//Evaluate if it is in the same area
                                a.id != rs.getInt("id_user") && //If the user is already registered
                                    id_process != rs.getInt("id_process")//and if it is registered in the process
                                )? true : false;
            }if(!exist)users.add(a);
        }
        
        return users;
        
    }
}
