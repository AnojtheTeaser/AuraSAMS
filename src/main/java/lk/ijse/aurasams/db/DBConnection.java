/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.db;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author TechWave
 */
public class DBConnection {
    
    private String URL = "jdbc:mysql://localhost:3306/auraeducation";
    private String USER = "root";
    private String PASSWORD = "1998@Apple";
    
    
    private static DBConnection dbc;
   private static Connection conn;
   
   
   
   private  DBConnection() throws Exception {
       
       conn = DriverManager.getConnection(URL,USER,PASSWORD);
  
   }
   
  public static DBConnection getInstance() throws Exception{
      
        return (dbc == null) ? dbc = new DBConnection() : dbc;
  
  }
  
  
  public static Connection getconnection(){
      
      System.out.println("db connected succsessfully");
      return conn;
  
  }
    
}
