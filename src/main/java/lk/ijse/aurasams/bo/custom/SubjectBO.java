/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.StudentDTO;
import lk.ijse.aurasams.dto.SubjectDTO;

/**
 *
 * @author TechWave
 */
public interface SubjectBO extends SuperBO {
    
       boolean saveSubject(SubjectDTO dto) throws Exception;
            boolean updateSubject(SubjectDTO dto) throws Exception;
            boolean deleteSubject(String id ) throws Exception;
            
            SubjectDTO searchSubject(String id) throws Exception;
            public List<SubjectDTO> getAllSubject() throws Exception;
            
             public List<SubjectDTO> getSubjectByCourseID(String courseId) throws Exception;
    
    
}
