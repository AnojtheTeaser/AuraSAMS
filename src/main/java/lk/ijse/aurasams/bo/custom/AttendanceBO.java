/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.AttendanceDTO;

/**
 *
 * @author TechWave
 */
public interface AttendanceBO extends SuperBO {
    
            boolean saveAtt(AttendanceDTO dto) throws Exception;
            boolean updateAtt(AttendanceDTO dto) throws Exception;
            boolean deleteAtt(String schedId, String stuId ) throws Exception;
            
            AttendanceDTO searchAtt(String id) throws Exception;
            public List<AttendanceDTO> getAllAtt() throws Exception;
    
}
