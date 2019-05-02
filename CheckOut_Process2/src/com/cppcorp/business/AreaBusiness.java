/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.business;

import com.cppcorp.entities.Area;
import com.cppcorp.persistent.AreaPersistent;

/**
 *
 * @author grbg2
 */
public class AreaBusiness extends Area {
    AreaPersistent a = new AreaPersistent();
    public void Insert (String name){
        a.add(name);
    }
}
