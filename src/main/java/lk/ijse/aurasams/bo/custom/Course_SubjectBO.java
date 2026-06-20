/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.Course_SubjectDTO;

/**
 *
 * @author TechWave
 */
public interface Course_SubjectBO extends SuperBO{
    
      boolean saveCourseSubject(Course_SubjectDTO dto) throws Exception;
       List<Course_SubjectDTO> getSubjectsByCourseID(String courseId) throws Exception;
       boolean deleteCourseSubject(String courseId) throws Exception;

      
    
}
