/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.business;

import com.cppcorp.entities.ProcessC;
import com.cppcorp.entities.User;
import com.cppcorp.persistent.ProcessPersistent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grbg2
 */
public class ProcessBusiness extends ProcessPersistent{
    UserBusiness ub = new UserBusiness();
    
    public List<User> getNoAdded(ProcessC p){
        List <User> allUsers = ub.getByAreaId(p.area.id);
        List <User> pUsers = p.user;
        
        List<User> fUsers = new ArrayList();
        
        for(User au : allUsers){
            boolean exists = false;
            for(User user : pUsers){
                exists = (au.id == user.id)? true : false;
            }
            if(false)fUsers.add(au);
        }
        return fUsers;
        
    }
}
