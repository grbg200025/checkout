/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.business;

import com.cppcorp.entities.Area;
import com.cppcorp.entities.User;
import com.cppcorp.persistent.AreaPersistent;
import com.cppcorp.persistent.UserPersistent;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author grbg2
 */
public class UserBusiness extends User{
    UserPersistent up = new UserPersistent();
    
    public User login(String username, String password) throws SQLException{
        User user = null;
        if(up.usernameExist(username)){
            User aux = up.getByUsername(username);
            if(aux.password.equals(password)) user = aux;
                
            
        }else{
            System.out.println("The username doesn't exist");
        }
        return user;
    }

    public List<User> getAll() throws SQLException{
        return up.getAll();
    }
    
    public Area getAreaById(int id) throws SQLException{
        AreaPersistent ap = new AreaPersistent();
        return ap.getById(id);
    }
}
