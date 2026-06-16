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
import lk.ijse.aurasams.dao.custom.CourseDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.CourseEntity;

/**
 *
 * @author TechWave
 */
public class CourseDAOImpl implements CourseDAO{

    @Override
    public boolean save(CourseEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "INSERT INTO course (course_id,course_name) VALUES (?,?)";
        PreparedStatement pstm =conn.prepareStatement(sql);
        pstm.setString(1, entity.getId());
        pstm.setString(2, entity.getName());
        
        boolean result = pstm.executeUpdate() > 0;
        
        return result;
        
    }

    @Override
    public boolean update(CourseEntity entity) throws Exception {
         Connection conn = DBConnection.getInstance().getconnection();
         
         String sql = "UPDATE course SET course_name=? WHERE course_id=?";
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1,entity.getName());
         pstm.setString(2,entity.getId());
         
         boolean result = pstm.executeUpdate() > 0;
         return result;
                

    }

    @Override
    public boolean delete(String id) throws Exception {
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "DELETE FROM course  WHERE course_id=?";
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1,id);
         
         boolean result = pstm.executeUpdate() > 0;
         return result;
        
        
        
    }

    @Override
    public CourseEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CourseEntity> getAll() throws Exception {
            Connection conn = DBConnection.getInstance().getconnection();
             String sql = "SELECT * FROM course";
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet result = pstm.executeQuery();
             
             ArrayList<CourseEntity> allcourse = new ArrayList<>();
             
             while(result.next()){
                 
                 String id = result.getString("course_id");
                 String name = result.getString("course_name");
                 
                  CourseEntity entity = new CourseEntity(id, name);
                  allcourse.add(entity);
                
             }
return allcourse;

        
    }
    
}
