/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.main;

import com.cppcorp.entities.Area;
import com.cppcorp.entities.ProcessC;
import com.cppcorp.persistent.AreaPersistent;
import com.cppcorp.persistent.ProcessPersistent;
import com.cppcorp.persistent.UserPersistent;
import com.cppcorp.utilities.Connectiondb;
import com.cppcorp.views.fLogin;
//import com.cppcorp.views.fLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author grbg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        fLogin view = new fLogin();
        view.setVisible(true);
    }
}
