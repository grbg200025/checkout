/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.entities.ProcessC;
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
        List<ProcessC> processesc = new ArrayList<>();
        AreaPersistent ap = new AreaPersistent();
        //Aqui hay que hacer el desmadre para obtener el area en el proceso
        Connectiondb conn = new Connectiondb();
        ResultSet rs = conn.querySelect("SELECT * FROM process WHERE id_area = "+id);
        
        while(rs.next()){
             ProcessC p = new ProcessC();
             p.id = rs.getInt(1);
             p.area = ap.getById(rs.getInt(2));
             p.name = rs.getString(3);
             processesc.add(p);
        }
        return processesc;
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
             processesc.add(p);
        }
        return processesc;
    }
}
