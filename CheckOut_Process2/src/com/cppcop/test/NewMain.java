/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcop.test;

import com.cppcorp.business.*;
import com.cppcorp.entities.Area;
import com.cppcorp.entities.ProcessC;
import com.cppcorp.entities.User;
import com.cppcorp.persistent.AreaPersistent;
import com.cppcorp.persistent.ProcessPersistent;
import com.cppcorp.utilities.Turn;
import com.cppcorp.utilities.viewController;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
        try {
            UserBusiness ub = new UserBusiness();
            AreaBusiness ab = new AreaBusiness();
            ProcessBusiness pb = new ProcessBusiness();
            Turn turn = new Turn();
            
            List<ProcessC> processes = pb.getAll();
            ProcessC p = processes.get(0);
            pb.getUsersById(p.id, p.area.id);
            pb.getUsersByIdNotIncluded(p.id, p.area.id);
            System.out.println("");
            /*
            List<Date[]> dates = turn.getTimes(1);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date currentTime = new Date();
            currentTime = dateFormat.parse(String.valueOf(currentTime.getHours())+":"+String.valueOf(currentTime.getMinutes()));
            boolean found = false;
            String output = "";
            for(Date[] date : dates){
            if(currentTime.after(date[0]) && currentTime.before(date[1]))
            if(found){output = date[0] + " -- " + date[1]; found = true;}
            else if(!found){
            output = dates.get(5)[0] +" -- "+dates.get(5)[1]; 
            }
            }
            System.out.println(output);*/
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
