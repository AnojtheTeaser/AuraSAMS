/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.AttendanceBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.AttendanceDAO;
import lk.ijse.aurasams.dto.AttendanceDTO;
import lk.ijse.aurasams.entity.AttendanceEntity;

/**
 *
 * @author TechWave
 */
public class AttendanceBOImpl implements AttendanceBO {
  
    private final AttendanceDAO attendanceDao = (AttendanceDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
   
    
    @Override
    
    public boolean saveAtt(AttendanceDTO dto) throws Exception {
//        
        boolean isExists = attendanceDao.checkAttendanceExists(dto.getSchedID(), dto.getStatus());
        
        AttendanceEntity entity = new AttendanceEntity(null, dto.getSchedID(), dto.getStuID(), dto.getStatus());
        
        if(isExists){
            System.out.println("already exsist");
            boolean result =attendanceDao.update(entity);
            return result;
        
        }else{
         boolean result =attendanceDao.save(entity);
            return result;
        
        }
    
    }

    @Override
    public boolean updateAtt(AttendanceDTO dto) throws Exception {
        
        AttendanceEntity entity = new AttendanceEntity(dto.getSchedID(), dto.getStuID(), dto.getStatus());
        return attendanceDao.update(entity);


   
}
        
        
    

    @Override
    public boolean deleteAtt(String id,String stuId) throws Exception {
        
        boolean result = attendanceDao.Delete(id, stuId);
        return result;
        
    }

    @Override
    public AttendanceDTO searchAtt(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AttendanceDTO> getAllAtt() throws Exception {
        
        List<AttendanceEntity> allentity = attendanceDao.getAll(); 
        List<AttendanceDTO> alldto = new ArrayList<>();

                    for (AttendanceEntity attendance : allentity) { 
                        String attId = attendance.getAttID(); 
                         String schedId = attendance.getSchedID(); 
                         String stuID = attendance.getStuID(); 
                         String status = attendance.getStatus(); 
                         
                   AttendanceDTO dto = new AttendanceDTO(attId, schedId, stuID, status); 
                     alldto.add(dto);
                 } 
   return alldto; 
   }
        
        
    
    
}
