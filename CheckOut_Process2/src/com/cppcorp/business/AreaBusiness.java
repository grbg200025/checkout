/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.business;

import com.cppcorp.entities.Area;
import com.cppcorp.persistent.AreaPersistent;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author grbg2
 */
public class AreaBusiness extends Area {
    AreaPersistent a = new AreaPersistent();
    public List<Area> getAll () throws SQLException{
        return a.getAll();
    }
    public void Insert (String name){
        a.add(name);
    }
}
