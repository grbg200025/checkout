/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.business.ProcessBusiness;
import com.cppcorp.business.UserBusiness;
import com.cppcorp.entities.Area;
import com.cppcorp.entities.ProcessC;
import com.cppcorp.entities.User;
import com.cppcorp.utilities.Connectiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author grbg
 */
public class UserPersistent extends User {
    /**
     * 
     * @return returns all the users in the data base
     * @throws SQLException 
     */
    public List<User> getAll() throws SQLException{
        List<User> users = new ArrayList<>();
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM user");
        AreaPersistent a = new AreaPersistent();
        while(rs.next()){
            User user = new User();
            user.id = rs.getInt("id");
            user.area = a.getById(rs.getInt("id_area"));
            user.name = rs.getString("name");
            user.last_name = rs.getString("last_name");
            user.username = rs.getString("username");
            user.password = rs.getString("password");
            user.admin = rs.getInt("admin");
            user.turn = rs.getInt("turn");
            
            user.process = getProcesses(user.id);
            
            users.add(user);
        }
        return users;
    }
    
    public List <ProcessC>getProcesses(int id){
        ProcessBusiness pb = new ProcessBusiness();
            List<ProcessC> processes = new ArrayList();
        try {
            
            AreaPersistent ap = new AreaPersistent();
            //Aqui hay que hacer el desmadre para obtener el area en el proceso
            Connectiondb conn = new Connectiondb();
            ResultSet rs = conn.querySelect("SELECT * FROM processuser WHERE id_user = "+id);
            
            while(rs.next()){
                processes.add(pb.getById(rs.getInt("id_process")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return processes;
    }
    
    public List<User> search(String s) throws SQLException, ClassNotFoundException{
        List<User> users = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
        String query  = "SELECT * FROM user WHERE name = ? OR last_name = ? OR username = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, s);
        ps.setString(2, s);
        ps.setString(3, s);
        
        ResultSet rs = ps.executeQuery();
        AreaPersistent a = new AreaPersistent();
        while(rs.next()){
            User user = new User();
            user.id = rs.getInt("id");
            user.area = a.getById(rs.getInt("id_area"));
            user.name = rs.getString("name");
            user.last_name = rs.getString("last_name");
            user.username = rs.getString("username");
            user.password = rs.getString("password");
            user.admin = rs.getInt("admin");
            user.turn = rs.getInt("turn");
            users.add(user);
        }
        conn.close();
        return users;
    }
    /**
     * Checks if the username exist in login
     * @param aux
     * @param username
     * @return
     * @throws SQLException 
     */
    public boolean usernameExist(String aux) throws SQLException{
        boolean found = false;
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT *  FROM user WHERE username ='"+aux+"'");
        while(rs.next()){
            found = true;
        }
        return found;
    }
    
    /**
     * 
     * @param username
     * @param password
     * @return 
     */
    public User login(String username, String password){
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"'");
        User u = null;
        try {
            if(rs.next()){
            u = new User();
            AreaPersistent ap = new AreaPersistent();
            
            
            u.id = rs.getInt("id");
            u.area = ap.getById(rs.getInt("id_area"));
            u.name = rs.getString("name");
            u.last_name = rs.getString("last_name");
            u.username = rs.getString("username");
            u.password = rs.getString("password");
            u.admin = rs.getInt("admin");
            u.process = getProcesses(u.id);
            u.turn = rs.getInt("turn");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error : "+ex.toString());
            
        }
        return u;
    }
    
    public User getByUsername(String username){
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM user WHERE username = '"+username+"'");
        User u = new User();
        try {
            rs.next();
            
            AreaPersistent ap = new AreaPersistent();
            
            
            u.id = rs.getInt("id");
            u.area = ap.getById(rs.getInt("id_area"));
            u.name = rs.getString("name");
            u.last_name = rs.getString("last_name");
            u.username = rs.getString("username");
            u.password = rs.getString("password");
            u.admin = rs.getInt("admin");
            u.turn = rs.getInt("turn");
            u.process = getProcesses(u.id);
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error : "+ex.toString());
            
        }
        return u;
    }
    
     public User getById(int id){
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM user WHERE  id = "+id);
        User u = new User();
        try {
            
            if(rs.next()){
              
            AreaPersistent ap = new AreaPersistent();
            
            
            u.id = rs.getInt("id");
            u.area = ap.getById(rs.getInt("id_area"));
            u.name = rs.getString("name");
            u.last_name = rs.getString("last_name");
            u.username = rs.getString("username");
            u.password = rs.getString("password");
            u.admin = rs.getInt("admin");
            u.turn = rs.getInt("turn");
            u.process = getProcesses(u.id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error : "+ex.toString());
            
        }
        return u;
    }
    
    public List<User> getByAreaId(int id){
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM user WHERE  id_area = "+id);
        List<User> users = new ArrayList();
        try {
            
            while(rs.next()){
            User u = new User();    
            AreaPersistent ap = new AreaPersistent();
            
            
            u.id = rs.getInt("id");
            u.area = ap.getById(rs.getInt("id_area"));
            u.name = rs.getString("name");
            u.last_name = rs.getString("last_name");
            u.username = rs.getString("username");
            u.password = rs.getString("password");
            u.admin = rs.getInt("admin");
            u.turn = rs.getInt("turn");
            u.process = getProcesses(u.id);
            users.add(u);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error : "+ex.toString());
            
        }
        return users;
    }
    
    public void Insert(User u){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/process_checkout","root",""
            );
            
            String query = "INSERT INTO user (id_area, name, last_name, username, password, admin, turn) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, u.area.id);
            preparedStmt.setString(2, u.name);
            preparedStmt.setString(3, u.last_name);
            preparedStmt.setString(4, u.username);
            preparedStmt.setString(5, u.password);
            preparedStmt.setInt(6, u.admin);
            preparedStmt.setInt(7, u.turn);
            preparedStmt.execute();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
