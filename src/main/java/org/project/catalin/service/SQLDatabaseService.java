package org.project.catalin.service;

/**
 * Created by cci on 17.09.2017.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

public class SQLDatabaseService implements ServletContextListener {

    static Connection con = null;

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb?useSSL=false", "root", "root");
            System.out.println("SQL ... Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static boolean validateLogin(String user, String pass) {
        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from Credentials");
            while (rs.next()) {
                if (rs.getString("user").equals(user) && rs.getString("password").equals(pass)) return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
