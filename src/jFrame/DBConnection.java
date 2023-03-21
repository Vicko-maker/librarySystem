package jFrame;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class DBConnection {
    static Connection con = null;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms?allowPublicKeyRetrieval=true&useSSL=false","root","Korir#001");
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
