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
import lk.ijse.aurasams.dao.custom.ClassScheduleDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.ClassScheduleEntity;

/**
 *
 * @author TechWave
 */
public class ClassScheduleDAOImpl implements ClassScheduleDAO{

    @Override
    public boolean save(ClassScheduleEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "INSERT INTO class_schedule VALUES (null,?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        // set object use for make easy to convert ant data type to in db . it is make esy to handel DATE ,TIME
        pstm.setObject(1,entity.getCourse_id());
        pstm.setObject(2,entity.getSub_id());
        pstm.setObject(3,entity.getLec_id());
        pstm.setObject(4,entity.getDate());
        pstm.setObject(5,entity.getTime());
        
       boolean result =pstm.executeUpdate() >0;
        return result;
        
        
        
        
    }

    @Override
    public boolean update(ClassScheduleEntity entity) throws Exception {
        
         Connection conn = DBConnection.getInstance().getconnection();
         
        String sql = "UPDATE class_schedule SET course_id=?, sub_id=?, lec_id=?, date=?, time=? WHERE sched_id=?";
        
         PreparedStatement pstm = conn.prepareStatement(sql);
        
        // set object use for make easy to convert ant data type to in db . it is make esy to handel DATE ,TIME
        pstm.setObject(1,entity.getCourse_id());
        pstm.setObject(2,entity.getSub_id());
        pstm.setObject(3,entity.getLec_id());
        pstm.setObject(4,entity.getDate());
        pstm.setObject(5,entity.getTime());
        pstm.setString(6, entity.getSched_id());
        
       boolean result =pstm.executeUpdate() >0;
        return result;
        

    }

    @Override
    public boolean delete(String id) throws Exception {
        
        String sql = "DELETE FROM class_schedule WHERE sched_id=?";
        Connection connection = DBConnection.getInstance().getconnection();
        PreparedStatement pstm = connection.prepareStatement(sql); pstm.setObject(1, id);
        pstm.setString(1, id);
        
         boolean result =pstm.executeUpdate() >0;
         return result;
        
    }

    @Override
    public ClassScheduleEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClassScheduleEntity> getAll() throws Exception {
        
          String sql = "SELECT * FROM class_schedule";
        Connection connection = DBConnection.getInstance().getconnection(); 
        PreparedStatement pstm = connection.prepareStatement(sql); 
        ResultSet result = pstm.executeQuery();
        
        List<ClassScheduleEntity> scheduleList =new ArrayList<>();
        while(result.next()){
            String schedid =result.getString("sched_id");
            String courseid = result.getString("course_id");
            String subid =  result.getString("sub_id");
            String lecid= result.getString("lec_id");
            String date = result.getString("date");
            String  time = result.getString("time");

            ClassScheduleEntity classsced = new ClassScheduleEntity(schedid, courseid, subid, lecid, date, time);
            scheduleList.add(classsced);
     
        }
        return scheduleList;
        
    }
    
}
