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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static void main(String[] args) throws ParseException{
        UserBusiness ub = new UserBusiness();
        AreaBusiness ab = new AreaBusiness();
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date date1 = sdf.parse("10:20");
            Date date2 = sdf.parse("09:40");
            System.out.println(date1.compareTo(date2));
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
