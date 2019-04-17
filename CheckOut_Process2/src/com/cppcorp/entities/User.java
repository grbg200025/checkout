/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.entities;

import java.util.List;

/**
 *
 * @author grbg2
 */
public class User {
    public int id;
    public Area area;
    public List<ProcessC> process;
    public String name;
    public String username;
    public String password;
    public int admin;
    public int turn;
}
