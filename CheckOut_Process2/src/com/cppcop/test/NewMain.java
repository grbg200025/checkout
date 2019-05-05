/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcop.test;

import com.cppcorp.business.*;
import com.cppcorp.entities.Area;
import com.cppcorp.entities.User;
import com.cppcorp.persistent.AreaPersistent;
import com.cppcorp.persistent.ProcessPersistent;
import com.cppcorp.utilities.viewController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grbg
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        AreaBusiness ab = new AreaBusiness();
        System.out.println(ab.getById(1).name);
        User user = viewController.user;
        user.name = "steve";
        System.out.println(user.name);
    }
    
    
}
