/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.LecturerDTO;

/**
 *
 * @author TechWave
 */
public interface LecturerBO extends SuperBO{
     boolean saveLecturer(LecturerDTO dto) throws Exception;
            boolean updateLecturer(LecturerDTO dto) throws Exception;
            boolean deleteLecturer(String id ) throws Exception;
            
            LecturerDTO searchLecturer(String id) throws Exception;
            public List<LecturerDTO> getAllLecturer() throws Exception;
            
            boolean saveLecturerSubMapping(String lecId,String subId) throws Exception;
            
            
         
    
    
}
