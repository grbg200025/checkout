/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cppcorp.persistent;

import com.cppcorp.business.AreaBusiness;
import com.cppcorp.business.ProcessBusiness;
import com.cppcorp.business.UserBusiness;
import com.cppcorp.entities.Area;
import com.cppcorp.entities.ProcessC;
import com.cppcorp.entities.User;
import com.cppcorp.utilities.Connectiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author grbg
 */
public class UserPersistent extends User {

    /**
     *
     * @return returns all the users in the data base
     * @throws SQLException
     */
    public List<User> getAll() throws SQLException {
        //What is going to return
        List<User> users = new ArrayList<>();

        //Other stuff you may need
        AreaBusiness ab = new AreaBusiness();

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            String query = "SELECT * FROM user";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            rs = preparedStmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.id = rs.getInt("id");
                user.area = ab.getById(rs.getInt("id_area"));
                user.name = rs.getString("name");
                user.last_name = rs.getString("last_name");
                user.username = rs.getString("username");
                user.password = rs.getString("password");
                user.admin = rs.getInt("admin");
                user.turn = rs.getInt("turn");
                users.add(user);
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return users;

    }

    /**
     *
     * @param id
     * @return all process of the user
     */
    public List<ProcessC> getProcesses(int id) {
        //What is going to return
        List<ProcessC> processes = new ArrayList();

        //Other stuff you may need
        ProcessBusiness pb = new ProcessBusiness();
        ProcessC process;

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            String query = "SELECT * FROM processuser WHERE id_user = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                process = pb.getById(rs.getInt("id_process"));
                processes.add(process);
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return processes;

    }

    /**
     * This method get a String and search for a user
     *
     * @param s
     * @return
     */
    public List<User> search(String s) {

        //What is going to return
        List<User> users = new ArrayList<>();

        //Other stuff you may need
        AreaBusiness ab = new AreaBusiness();

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            String query = "SELECT * FROM user WHERE name = ? OR last_name = ? OR username = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, s);
            ps.setString(2, s);
            ps.setString(3, s);

            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.id = rs.getInt("id");
                user.area = ab.getById(rs.getInt("id_area"));
                user.name = rs.getString("name");
                user.last_name = rs.getString("last_name");
                user.username = rs.getString("username");
                user.password = rs.getString("password");
                user.admin = rs.getInt("admin");
                user.turn = rs.getInt("turn");
                users.add(user);
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return users;
    }

    /**
     * Checks if the username exist in login
     *
     * @param aux
     * @param username
     * @return
     * @throws SQLException
     */
    public boolean usernameExist(String username) throws SQLException {
        //What is going to return
        boolean found = false;

        //Other stuff you may need
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //The process goes here...
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            String query = "SELECT *  FROM user WHERE username = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            while (rs.next()) {
                found = true;
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return found;

    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        //What is going to return
        User user = null;

        //Other stuff you may need
        AreaBusiness ab = new AreaBusiness();

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            //The process goes here...
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";

            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.id = rs.getInt("id");
                user.area = ab.getById(rs.getInt("id_area"));
                user.name = rs.getString("name");
                user.last_name = rs.getString("last_name");
                user.username = rs.getString("username");
                user.password = rs.getString("password");
                user.admin = rs.getInt("admin");
                user.process = getProcesses(user.id);
                user.turn = rs.getInt("turn");
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return user;

    }

    /**
     *
     * @param username
     * @return the user from the username
     */
    public User getByUsername(String username) {
        //What is going to return
        User user = new User();

        //Other stuff you may need
        AreaBusiness ab = new AreaBusiness();

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            //The process goes here...
            String query = "SELECT * FROM user WHERE username = ?";

            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {
                user.id = rs.getInt("id");
                user.area = ab.getById(rs.getInt("id_area"));
                user.name = rs.getString("name");
                user.last_name = rs.getString("last_name");
                user.username = rs.getString("username");
                user.password = rs.getString("password");
                user.admin = rs.getInt("admin");
                user.turn = rs.getInt("turn");
                user.process = getProcesses(user.id);
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return user;

    }

    /**
     *
     * @param id
     * @return user by the id
     */
    public User getById(int id) {
        //What is going to return
        User user = new User();

        //Other stuff you may need
        AreaBusiness ab = new AreaBusiness();

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            //The process goes here...
            String query = "SELECT * FROM user WHERE  id = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {

                user.id = rs.getInt("id");
                user.area = ab.getById(rs.getInt("id_area"));
                user.name = rs.getString("name");
                user.last_name = rs.getString("last_name");
                user.username = rs.getString("username");
                user.password = rs.getString("password");
                user.admin = rs.getInt("admin");
                user.turn = rs.getInt("turn");
                user.process = getProcesses(user.id);
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return user;
    }

    /**
     *
     * @param id
     * @return the user from a Area
     */
    public List<User> getByAreaId(int id) {
        //What is going to return
        List<User> users = new ArrayList();

        //Other stuff you may need
        User user = new User();
        AreaBusiness ab = new AreaBusiness();

        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            //The process goes here...
            String query = "SELECT * FROM user WHERE  id_area = ?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();

                user.id = rs.getInt("id");
                user.area = ab.getById(rs.getInt("id_area"));
                user.name = rs.getString("name");
                user.last_name = rs.getString("last_name");
                user.username = rs.getString("username");
                user.password = rs.getString("password");
                user.admin = rs.getInt("admin");
                user.turn = rs.getInt("turn");
                user.process = getProcesses(user.id);
                users.add(user);
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {

        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
        //What is going to return goes here...
        return users;

    }

    /**
     * Insert the user in the data base
     */
    public void insert() {
        //Values to do the query
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/process_checkout", "root", ""
            );

            String query = "INSERT INTO user (id_area, name, last_name, username, password, admin, turn) VALUES (?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, area.id);
            ps.setString(2, name);
            ps.setString(3, last_name);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setInt(6, admin);
            ps.setInt(7, turn);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close everything avoid get any error for multiple conections
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                /* ignored */ }
        }
    }
}
