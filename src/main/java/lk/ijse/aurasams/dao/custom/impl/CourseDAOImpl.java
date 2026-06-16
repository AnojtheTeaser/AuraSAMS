/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CourseEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CourseEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
