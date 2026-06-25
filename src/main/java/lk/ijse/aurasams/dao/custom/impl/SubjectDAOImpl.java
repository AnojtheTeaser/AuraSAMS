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
import lk.ijse.aurasams.dao.custom.SubjectDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.SubjectEntity;

/**
 *
 * @author TechWave
 */
public class SubjectDAOImpl implements SubjectDAO {

    @Override
    
    public boolean save(SubjectEntity entity) throws Exception {
        
        Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "INSERT INTO subjects (sub_id,sub_name) VALUES (?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, entity.getId());
        pstm.setString(2,entity.getName());
        
        boolean result = pstm.executeUpdate() > 0;
        
        return result;
        
        
        
    }

    @Override
    public boolean update(SubjectEntity entity) throws Exception {
        
         Connection conn = DBConnection.getInstance().getconnection();
         
         String sql = "UPDATE subjects SET sub_name=? WHERE sub_id=?";
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1,entity.getName());
         pstm.setString(2,entity.getId());
         
         boolean result = pstm.executeUpdate() > 0;
         return result;
                

    }

    @Override
    public boolean delete(String id) throws Exception {
        
       Connection conn = DBConnection.getInstance().getconnection();
        
        String sql = "DELETE FROM subjects  WHERE sub_id=?";
        
        PreparedStatement pstm =conn.prepareStatement(sql);
        pstm.setString(1, id);
        
        boolean result = pstm.executeUpdate() > 0;
        
        return result;
        
    }

    @Override
    public SubjectEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SubjectEntity> getAll() throws Exception {
        
           Connection conn = DBConnection.getInstance().getconnection();
             String sql = "SELECT * FROM subjects";
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet result = pstm.executeQuery();
             
             ArrayList<SubjectEntity> allsubentity = new ArrayList<>();
             
             while(result.next()){
                 String id = result.getString("sub_id");
                 String name = result.getString("sub_name");
                 
                 SubjectEntity subenti =new SubjectEntity(id,name);
                 allsubentity.add(subenti);
             
             
             }
        
        return allsubentity;
    }

    @Override
    public List<SubjectEntity> getSubjectByCourseID(String courseId) throws Exception {
        
     Connection conn = DBConnection.getInstance().getconnection();
    

    String sql = "SELECT s.sub_id, s.sub_name FROM subjects s " +
                 "JOIN course_subjects cs ON s.sub_id = cs.sub_id " +
                 "WHERE cs.course_id = ?";
                 
    PreparedStatement pstm = conn.prepareStatement(sql);
    pstm.setString(1, courseId);
    
    ResultSet result = pstm.executeQuery();
    List<SubjectEntity> list = new ArrayList<>();
    
    while (result.next()) {
       
           String id = result.getString("sub_id");
           String name = result.getString("sub_name");
           
           SubjectEntity entity = new SubjectEntity(id, name);
           list.add(entity);
        
    }
    return list;
    }
}
