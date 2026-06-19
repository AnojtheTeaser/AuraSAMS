/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.CourseDTO;

/**
 *
 * @author TechWave
 */
public interface CourseBO extends SuperBO{
        
            boolean saveCourse(CourseDTO dto) throws Exception;
            boolean updateCourse(CourseDTO dto) throws Exception;
            boolean deleteCourse(String id ) throws Exception;
            
            CourseDTO searchCourse(String id) throws Exception;
            public List<CourseDTO> getAllCourse() throws Exception;
    
}
