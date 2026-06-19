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
import lk.ijse.aurasams.dao.custom.LecturerDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.entity.LecturerEntity;

/**
 *
 * @author TechWave
 */
public class LecturerDAOImpl implements LecturerDAO{

    @Override
    public boolean save(LecturerEntity entity) throws Exception {
        
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "INSERT INTO lecturer(lec_id,name,email,tel) VALUES (?,?,?,?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, entity.getId());
        pstm.setString(2, entity.getName());
        pstm.setString(3, entity.getEmail());
        pstm.setString(4, entity.getTel());
        
        boolean result = pstm.executeUpdate()>0;
        return result;
        
     
    }

    @Override
    public boolean update(LecturerEntity entity) throws Exception {
        
         Connection conn = DBConnection.getInstance().getconnection();
        String sql = "UPDATE lecturer SET name=?, email=?, tel=? WHERE lec_id=?";
        
        
         PreparedStatement pstm = conn.prepareStatement(sql);
        
        
        pstm.setString(1, entity.getName());
        pstm.setString(2, entity.getEmail());
        pstm.setString(3, entity.getTel());
        pstm.setString(4, entity.getId());
        
        boolean result = pstm.executeUpdate()>0;
        return result;
        
        
        
    }

@Override    
    public boolean updateLecturerSubMapping(String lecId, String subId, Connection conn) throws Exception{
             String sql = "UPDATE lecturer_subjects SET sub_id =? WHERE lec_id=?";
             
             PreparedStatement pstm = conn.prepareStatement(sql);
             pstm.setString(1,lecId);
             pstm.setString(2,subId );
             
             boolean result = pstm.executeUpdate() >0;
             return result;
             
    }
    
    
    
    
    @Override
    public boolean delete(String id) throws Exception {
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "DELETE FROM lecturer WHERE lec_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, id);
        
        boolean result = pstm.executeUpdate() > 0;
        return result;
        
    }

    @Override
    public LecturerEntity search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LecturerEntity> getAll() throws Exception {
    
        Connection conn = DBConnection.getInstance().getconnection();
  
        String sql = "SELECT * FROM lecturer";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet result =pstm.executeQuery();
        
        List<LecturerEntity > allLectures = new ArrayList<>();
            
        while(result.next()){
            
            String id = result.getString("lec_id");
            String name = result.getString("name");
            String email = result.getString("email");
            String tel = result.getString("tel");
            
            LecturerEntity entity = new LecturerEntity(id, name, email, tel);
            allLectures.add(entity);
        
        }
        
        return allLectures;
                
        
    }
    
    
    
    
}
