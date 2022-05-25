/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author abhi
 */
public class Db {
    
    static private final String URL = "jdbc:mysql://localhost:3306/employee_managment_db";
    static private final String UN = "root";
    static private final String PW = "1234"; 
    static private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection conn;

    static private Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, UN, PW);
        } catch (Exception ex) {
            ex.printStackTrace();
          
        }
        return conn;
    }

    public static int iud(String q) {
        int r = 0;
        try {
            r = getConnection().createStatement().executeUpdate(q);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return r;
    }

    public static ResultSet search(String q){
        ResultSet rs =null;
        try {
            rs = getConnection().createStatement().executeQuery(q);
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        return rs;
    }
   
    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
