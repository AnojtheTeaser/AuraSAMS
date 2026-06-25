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
import lk.ijse.aurasams.entity.ReportEntity;
import lk.ijse.aurasams.dao.custom.ReportsDAO;
import lk.ijse.aurasams.db.DBConnection;

/**
 *
 * @author TechWave
 */
public class ReportsDAOImpl implements ReportsDAO{

    @Override
    public List<ReportEntity> getAttendanceByStudent(String courseId, String stuId) throws Exception {
        
         Connection conn = DBConnection.getInstance().getconnection();
    

    String sql = "SELECT s.stu_id, s.name, c.course_name, sub.sub_name, cs.date, a.status " +
                 "FROM Attendance a " +
                 "JOIN students s ON a.stu_id = s.stu_id " +
                 "JOIN class_schedule cs ON a.sched_id = cs.sched_id " +
                 "JOIN course c ON cs.course_id = c.course_id " +
                 "JOIN subjects sub ON cs.sub_id = sub.sub_id " +
                 "WHERE cs.course_id = ? AND s.stu_id = ?";
    
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, courseId);
    pstm.setString(2, stuId);
    
    System.out.println("DB courseID "+ courseId);
     System.out.println("DB studentid "+ stuId);
    ResultSet result = pstm.executeQuery();
    
    List<ReportEntity> list = new ArrayList<>();
    while (result.next()) {
     
       
            String id = result.getString("stu_id");
            String name = result.getString("name");
            String courseName = result.getString("course_name");
            String subName =result.getString("sub_name");
            String date =result.getString("date");
            String status =result.getString("status");
   
            
            ReportEntity entity = new ReportEntity(id, name, courseName, subName, date, status);
            list.add(entity);
    }
    return list; 
       
        
    }

    @Override
    public List<ReportEntity> getAttendanceBySubjects(String courseId, String subId) throws Exception {
        
        
         Connection conn = DBConnection.getInstance().getconnection();


    String sql = "SELECT s.stu_id, s.name, c.course_name, sub.sub_name, cs.date, a.status " +
                 "FROM attendance a " +
                 "JOIN students s ON a.stu_id = s.stu_id " +
                 "JOIN class_schedule cs ON a.sched_id = cs.sched_id " +
                 "JOIN course c ON cs.course_id = c.course_id " +
                 "JOIN subjects sub ON cs.sub_id = sub.sub_id " +
                 "WHERE cs.course_id = ? AND cs.sub_id = ?";

    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, courseId);
    pstm.setString(2, subId);
    
    System.out.println("Subject Report DAO Course ID: " + courseId ); 
    System.out.println("Subject Report DAO Subject ID: "+ subId  );

    ResultSet result = pstm.executeQuery();
    List<ReportEntity> list = new ArrayList<>();

    while (result.next()) {
        String id = result.getString("stu_id");
        String name = result.getString("name");
        String courseName = result.getString("course_name");
        String subName = result.getString("sub_name");
        String date = result.getString("date");
        String status = result.getString("status");


        ReportEntity entity = new ReportEntity(id, name, courseName, subName, date, status);
        list.add(entity);
    }
    return list;
        
        
        
    }

    @Override
    public List<ReportEntity> getAttendanceByDateRange(String courseId, String stuId, String fromDate, String toDate) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean save(ReportEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(ReportEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ReportEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReportEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
