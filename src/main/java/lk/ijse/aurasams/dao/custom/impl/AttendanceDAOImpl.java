/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.dao.custom.AttendanceDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.AttendanceEntity;

/**
 *
 * @author TechWave
 */
public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public boolean save(AttendanceEntity entity) throws Exception {
        
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "INSERT INTO attendance (sched_id, stu_id, status) VALUES (?, ?, ?)"; 
        PreparedStatement pstm = conn.prepareStatement(sql); 
                pstm.setString(1, entity.getSchedID()); 
                pstm.setString(2, entity.getStuID());
                pstm.setString(3, entity.getStatus()); 
                 
                 boolean result = pstm.executeUpdate() > 0;

            return result;
  
        
    }

    @Override
    public boolean update(AttendanceEntity entity) throws Exception {
        
            Connection conn = DBConnection.getInstance().getconnection();
            
           String sql = "UPDATE attendance SET status = ? WHERE sched_id = ? AND stu_id = ?"; 
           PreparedStatement pstm =conn.prepareStatement(sql);
           pstm.setString(1, entity.getStatus());
           pstm.setString(2, entity.getSchedID());
           pstm.setString(3, entity.getStuID());
    
  
    return pstm.executeUpdate()> 0;
   }
  
  
        
    

    @Override
    public boolean delete(String id) throws Exception {
        
        Connection conn = DBConnection.getInstance().getconnection();
         String sql = "DELETE FROM attendance WHERE att_id = ?"; 
        PreparedStatement pstm = conn.prepareStatement(sql); 
                pstm.setString(1, id); 
                boolean result = pstm.executeUpdate() > 0; 
 return result;
        
    }
    
    
    
    
    
    
    
    @Override
    public boolean Delete(String schedId, String studId) throws Exception {
        
          Connection conn = DBConnection.getInstance().getconnection();
          String sql = "DELETE FROM attendance WHERE sched_id = ? AND stu_id = ?"; 
            PreparedStatement pstm = conn.prepareStatement(sql); 
            pstm.setInt(1, Integer.parseInt(schedId)); 
            pstm.setInt(2, Integer.parseInt(studId)); 
            
            
            int rowaffected = pstm.executeUpdate();
          //  boolean result = pstm.executeUpdate() > 0; 
            return rowaffected > 0;
        
        
          
        
        
        
    }

    
    

    @Override
    public AttendanceEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AttendanceEntity> getAll() throws Exception {
        
            Connection conn = DBConnection.getInstance().getconnection(); 
            String sql = "SELECT * FROM attendance"; 
            PreparedStatement pstm = conn.prepareStatement(sql); 
            ResultSet rst = pstm.executeQuery(); 
            
             List<AttendanceEntity> allAttendance = new ArrayList<>(); 
      while (rst.next()) {
 
                String attId = rst.getString("att_id"); 
                String schedId = rst.getString("sched_id"); 
                String stuId = rst.getString("stu_id"); 
                String status = rst.getString("status"); 

            AttendanceEntity entity = new AttendanceEntity(attId, schedId, stuId, status);
            allAttendance.add(entity); 
 } 
 return allAttendance;   
    
    }

    @Override
    public boolean checkAttendanceExists(String schedId, String stuId) throws Exception {
        
        
        Connection conn = DBConnection.getInstance().getconnection();
            String sql = "SELECT sched_id FROM attendance WHERE sched_id = ? AND stu_id = ?"; 
            PreparedStatement pstm = conn.prepareStatement(sql); 
                    pstm.setString(1, schedId); 
                    pstm.setString(2, stuId); 
                    ResultSet rst = pstm.executeQuery();
                    return rst.next();  // if alredy have true

    }

   
}
