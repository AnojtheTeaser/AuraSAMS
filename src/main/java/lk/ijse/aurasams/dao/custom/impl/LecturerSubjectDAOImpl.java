/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import lk.ijse.aurasams.dao.custom.LecturerDAO;
import lk.ijse.aurasams.dao.custom.LecturerSubjectDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.LecturerEntity;

/**
 *
 * @author TechWave
 */
public class LecturerSubjectDAOImpl implements LecturerSubjectDAO{

    @Override
    public boolean saveLecturerSubMapping(String lecId, String subId) throws Exception {
        String sql = "INSERT INTO lecturer_subjects (lec_id , sub_id)VALUES(?,?)";
        Connection conn =DBConnection.getInstance().getconnection();
         PreparedStatement pstm = conn.prepareStatement(sql);
         
         pstm.setString(1, lecId);
         pstm.setString(2,subId);
         
         boolean result = pstm.executeUpdate() > 0;
         return result;
       
       
    }

    
}
