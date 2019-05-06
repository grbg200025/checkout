/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author grbg2
 */
public class Turn {
    /**
     * This class is for return the hours
     * acording the turn is running, the
     * hours are going to have a 
     */
    
    public void Turn(){
        
    }
    
    
    public List<Date[]> getTimes(int turn) throws ParseException{
        List<Date[]> dates = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        
        Date [] adates;
        switch(turn){
        case 1:
            for(int i = 0; i <= 12 ; i++){
                adates = new Date [2];
                int start = 6 + i;
                int end = 7 + i;
                
                System.out.println(start);
                System.out.println(end);
                System.out.println(i);
                
                Date t1 = dateFormat.parse(String.valueOf(start)+":40");
                Date t2 = dateFormat.parse(String.valueOf(end)+":39");
                adates [0] = t1;
                adates [1] = t2;
                dates.add(adates);
            }
            break;
            
        case 2:
            for(int i = 0; i <= 11 ; i++){
                //variable = (condition) ? expressionTrue : expressionFalse;
                adates = new Date [2];
                int start = 18 + i;
                int end = 19 + i;
                
                System.out.println(start);
                System.out.println(end);
                System.out.println(i);
                System.out.println("");
                
                Date t1 = dateFormat.parse(String.valueOf(start)+":40");
                Date t2 = dateFormat.parse(String.valueOf(end)+":39");
                
                t1 = dateFormat.parse(t1.getHours()+":"+t1.getMinutes());
                t2 = dateFormat.parse(t2.getHours()+":"+t2.getMinutes());
                
                adates [0] = t1;
                adates [1] = t2;
                dates.add(adates);
            }    
            break;
        }
        
        for(Date aux [] : dates){
            System.out.println(aux[0]+ " - "+aux[1]);
        }
        
        return dates;
    }
    
    
    /*public String[] getTurnHours(int i){
        switch (i){
            case 1:
                hours[0] = "7:40";
                hours[1] = "8:40";
                hours[2] = "9:40";
                hours[3] = "10:40";
                hours[4] = "11:40";
                hours[5] = "12:40";
                hours[6] = "13:40";
                hours[7] = "14:40";
                hours[8] = "15:40";
                hours[9] = "16:40";
                hours[10] = "17:40";
                hours[11] = "18:40";
            case 2:    
        }
                
    }*/

    
}
