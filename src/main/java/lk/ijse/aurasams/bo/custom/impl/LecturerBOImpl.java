/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.LecturerBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.LecturerDAO;
import lk.ijse.aurasams.dao.custom.LecturerSubjectDAO;
import lk.ijse.aurasams.db.DBConnection;
import lk.ijse.aurasams.dto.LecturerDTO;
import lk.ijse.aurasams.dto.SubjectDTO;
import lk.ijse.aurasams.entity.LecturerEntity;

/**
 *
 * @author TechWave
 */
public class LecturerBOImpl implements LecturerBO{
    
//    LecturerSubjectDAO lecturerSubjectDao = (LecturerSubjectDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LECTURER_SUBJECTS);
//    LecturerDAO lecturerDao = (LecturerDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LECTURER);
   
    LecturerDAO lecturerDao = (LecturerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LECTURER);

LecturerSubjectDAO lecturerSubjectDao = (LecturerSubjectDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LECTURER_SUBJECTS);
    
    
    
    @Override
    public boolean saveLecturer(LecturerDTO dto) throws Exception {
        
        
        LecturerEntity entity = new LecturerEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getTel());
        
           boolean result  =lecturerDao.save(entity);
           return result ; 
    }

    @Override
    public boolean updateLecturer(LecturerDTO dto) throws Exception {
        
//          LecturerEntity entity = new LecturerEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getTel());
//        
//          boolean result  =lecturerDao.update(entity);
//           return result ;
        Connection conn = null;
        try{
             conn =DBConnection.getInstance().getconnection();
            
            conn.setAutoCommit(false);
            
            String id = dto.getId();
            String name = dto.getName();
            String email = dto.getEmail();
            String tel = dto.getTel();
            String subID = dto.getTempSubject();
            
            LecturerEntity lecEnti = new LecturerEntity(id, name, email, tel);
            
            boolean islecUpdate = lecturerDao.update(lecEnti);
            
            if (islecUpdate){
            
            boolean isMapUpodte = lecturerDao.updateLecturerSubMapping(id ,subID,conn);
            
            if (isMapUpodte){
            conn.commit();
            return true;
            
            
            }
            
            }
            
            conn.rollback();
            return false;
           
        }catch(Exception e){
            
            if (conn != null){
                conn.rollback();
            }
            e.printStackTrace();
            
            
        } finally {
            if(conn != null){
        conn.setAutoCommit(true);
        }
        

        }
        return false;
        
    }

    @Override
    public boolean deleteLecturer(String id) throws Exception {
        
        boolean result  =lecturerDao.delete(id);
           return result ;
    }

    @Override
    public LecturerDTO searchLecturer(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LecturerDTO> getAllLecturer() throws Exception {
        
        List<LecturerEntity> allLecEnti = lecturerDao.getAll();
        
        List<LecturerDTO> dtoList = new ArrayList<>();
        
        for (LecturerEntity entity:allLecEnti){
            
            String id = entity.getId();
            String name = entity.getName();
            String email = entity.getEmail();
            String tel = entity.getTel();
            
            LecturerDTO dto = new LecturerDTO(id, name, email, tel);
            dtoList.add(dto);
            
        
        
        }
        
        return dtoList;
    }

    @Override
    public boolean saveLecturerSubMapping(String lecId, String subId) throws Exception {
        
        boolean result = lecturerSubjectDao.saveLecturerSubMapping(lecId, subId);
        return result;
        
    }

   
    @Override
    public List<SubjectDTO> getSubjectByLecturerID(String lecId) throws Exception {
        return lecturerDao.getSubjectByLecturerID(lecId);
    }

}