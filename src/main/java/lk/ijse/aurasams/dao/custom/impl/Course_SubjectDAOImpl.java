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
import lk.ijse.aurasams.dao.custom.Course_SubjectDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.Course_SubjectEntity;

/**
 *
 * @author TechWave
 */
public class Course_SubjectDAOImpl  implements Course_SubjectDAO {

//    @Override
//    public List<Course_SubjectEntity> getSubByCourseId(String courseId) throws Exception {
//        String sql = "SELECT s.sub_id.s.sub_name FROM subjects s "+
//                "INNER JOIN  course_subjects cs ON s.sub_id=cs.sub_id"+
//                "WHERE cs.course_id=?";
//        
//       Connection conn = DBConnection.getInstance().getconnection();
//        PreparedStatement pstm = conn.prepareCall(sql);
//        pstm.setString(1, courseId);
//        
//        ResultSet result = pstm.executeQuery();
//        List<Course_SubjectEntity> list = new ArrayList<>();
//        
//        while(result.next()){
//        String id = result.getString("sub_id");
//        String name = result.getString("sub_name");
//        
//        Course_SubjectEntity subenti = new Course_SubjectEntity(id, name);
//        list.add(subenti);
//        
//        }
//                
//       return list; 
//    }
//
//    @Override
//    public boolean DeletefromMapping(String courseId) throws Exception {
//         Connection conn = DBConnection.getInstance().getconnection();
//        String sql = "DELETE FROM course_subjects WHERE course_id=?";
//        
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1, courseId);
//        
//            boolean result =pstm.executeUpdate() > 0;
//            return result;
//    }
//
//    @Override
//    public boolean save(Course_SubjectEntity entity) throws Exception {
//            
//        Connection conn = DBConnection.getInstance().getconnection();
//        String sql = "INSERT INTO COURSE_subjects(course_id,sub_id) VALUES (?,?)";
//        
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1, entity.getCourseID());
//        pstm.setString(2, entity.getSubID());
//        
//        boolean result = pstm.executeUpdate() > 0;
//        return result;
//    }
//
//    @Override
//    public boolean update(Course_SubjectEntity entity) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Course_SubjectEntity search(String id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<Course_SubjectEntity> getAll() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
    
    
    
     @Override
    public List<Course_SubjectEntity> getSubByCourseId(String courseId) throws Exception {
       
        String sql = "SELECT s.sub_id, s.sub_name FROM subjects s " +
                     " INNER JOIN course_subjects cs ON s.sub_id=cs.sub_id " +
                     " WHERE cs.course_id=?";
        
        Connection conn = DBConnection.getInstance().getconnection();
        PreparedStatement pstm = conn.prepareStatement(sql); 
        pstm.setString(1, courseId);
        
        ResultSet result = pstm.executeQuery();
        List<Course_SubjectEntity> list = new ArrayList<>();
        
        while(result.next()){
            String id = result.getString("sub_id");
            String name = result.getString("sub_name");
            
            Course_SubjectEntity subenti = new Course_SubjectEntity(courseId,id, name);
            list.add(subenti);
        }
                
        return list; 
    }

    @Override
    public boolean DeletefromMapping(String courseId) throws Exception {
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "DELETE FROM course_subjects WHERE course_id=?";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, courseId);
        
        boolean result = pstm.executeUpdate() > 0;
        return result;
    }

    @Override
    public boolean save(Course_SubjectEntity entity) throws Exception {
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "INSERT INTO course_subjects(course_id,sub_id) VALUES (?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        
        String courseID = entity.getCourseID();
            if (courseID == null || courseID.trim().isEmpty()) {
                        courseID = entity.getSubName(); 
    }
        
            pstm.setString(1, courseID);
            pstm.setString(2, entity.getSubID());
            
                boolean result = pstm.executeUpdate() > 0;
        return result;
    }

    @Override
    public boolean update(Course_SubjectEntity entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Course_SubjectEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Course_SubjectEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

