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
import lk.ijse.aurasams.dao.custom.StudentDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.StudentEntity;

/**
 *
 * @author TechWave
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(StudentEntity entity) throws Exception {
        
             
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "INSERT INTO students(stu_id,name,email,tel,course_id) VALUES (?,?,?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, entity.getId());
        pstm.setString(2,entity.getName());
        pstm.setString(3, entity.getEmail());
        pstm.setString(4, entity.getTel());
        pstm.setString(5, entity.getCourseid());
        
        boolean result = pstm.executeUpdate() > 0;
        
        return result;
        
    }

    @Override
    public boolean update(StudentEntity entity) throws Exception {
        
                
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "UPDATE students SET name=? , email=? ,tel=? , course_id=? WHERE stu_id=?";
       
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
       
        pstm.setString(1,entity.getName());
        pstm.setString(2, entity.getEmail());
        pstm.setString(3, entity.getTel());
        pstm.setString(4, entity.getCourseid());
        pstm.setString(5, entity.getId());
        
        
        boolean result = pstm.executeUpdate() > 0;
        
        return result;
        
    }

    @Override
    public boolean delete(String id) throws Exception {
        
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "DELETE FROM students WHERE stu_id=?";
        
        PreparedStatement pstm =conn.prepareStatement(sql);
        pstm.setString(1, id);
        
        boolean result = pstm.executeUpdate() > 0;
        
        return result;
        
        
        
    }

    @Override
    public StudentEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StudentEntity> getAll() throws Exception {
        
         Connection conn = DBConnection.getInstance().getconnection();
             String sql = "SELECT * FROM students";
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet result = pstm.executeQuery();
             
             ArrayList<StudentEntity> allstuentity = new ArrayList<>();
             
             while(result.next()){
                 String id = result.getString("stu_id");
                 String name = result.getString("name");
                 String email =result.getString("email");
                 String tel =result.getString("tel");
                 String courseid = result.getString("course_id");
                 
                 StudentEntity stuenti =new StudentEntity(id, name, email, tel, courseid);
                 allstuentity.add(stuenti);
             
             
             }
        
        return allstuentity;
        
        
    }

    @Override
    public List<StudentEntity> getStudentByCourseID(String courseId) throws Exception {
        
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "SELECT stu_id, name FROM students WHERE course_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, courseId);
        
        ResultSet res = pstm.executeQuery();
        
        List<StudentEntity> studentList = new ArrayList<>();
        
        while (res.next()){
            String id = res.getString("stu_id");
            String name = res.getString("name");
            
            StudentEntity entity = new StudentEntity(id, name, null, null, null);
            studentList.add(entity);
        
        }
        
        return studentList;
        
    }
    
}
