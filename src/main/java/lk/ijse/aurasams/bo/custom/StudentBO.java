/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.StudentDTO;
import lk.ijse.aurasams.entity.StudentEntity;

/**
 *
 * @author TechWave
 */
public interface StudentBO extends SuperBO {
    
       boolean saveStudent(StudentDTO dto) throws Exception;
            boolean updateStudent(StudentDTO dto) throws Exception;
            boolean deleteStudent(String id ) throws Exception;
            
            StudentDTO searchStudent(String id) throws Exception;
            public List<StudentDTO> getAllStudent() throws Exception;
            
             List<StudentDTO> getStudentByCourseID(String courseId) throws Exception;
    
}
