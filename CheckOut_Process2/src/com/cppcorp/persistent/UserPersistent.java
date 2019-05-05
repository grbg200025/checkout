/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.entities.Area;
import com.cppcorp.entities.User;
import com.cppcorp.utilities.Connectiondb;
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
            user.area = a.getById(rs.getInt("id"));
            user.name = rs.getString("name");
            user.username = rs.getString("username");
            user.password = rs.getString("password");
            user.admin = rs.getInt("admin");
            user.turn = rs.getInt("turn");
        }
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
        User u = new User();
        try {
            rs.next();
            
            AreaPersistent ap = new AreaPersistent();
            
            
            u.id = rs.getInt("id");
            u.area = ap.getById(rs.getInt("id_area"));
            u.name = rs.getString("name");
            u.username = rs.getString("username");
            u.password = rs.getString("password");
            u.admin = rs.getInt("admin");
            u.turn = rs.getInt("turn");
            
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
            u.username = rs.getString("username");
            u.password = rs.getString("password");
            u.admin = rs.getInt("admin");
            u.turn = rs.getInt("turn");
            
        } catch (SQLException ex) {
            Logger.getLogger(UserPersistent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error : "+ex.toString());
            
        }
        return u;
    }
}
