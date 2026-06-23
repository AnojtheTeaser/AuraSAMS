/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.ClassScheduleDTO;

/**
 *
 * @author TechWave
 */
public interface ClassScheduleBO extends SuperBO{
    
    
      boolean saveSched(ClassScheduleDTO dto) throws Exception;
            boolean updateSched(ClassScheduleDTO dto) throws Exception;
            boolean deleteSched(String id ) throws Exception;
            
            ClassScheduleDTO searchSched(String id) throws Exception;
            public List<ClassScheduleDTO> getAllSched() throws Exception;
    
    
}
