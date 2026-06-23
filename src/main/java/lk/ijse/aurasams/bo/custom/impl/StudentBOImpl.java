/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.StudentBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.StudentDAO;
import lk.ijse.aurasams.dto.StudentDTO;
import lk.ijse.aurasams.entity.StudentEntity;

/**
 *
 * @author TechWave
 */
public class StudentBOImpl implements StudentBO {
    
    StudentDAO studentDao = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENTS);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        
        StudentEntity stuenti = new  StudentEntity(dto.getId(), dto.getName(), dto.getEmail(),dto.getTel(), dto.getCourseid());
        boolean result = studentDao.save(stuenti);
        return result;
        
        
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        
      
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        
        boolean result = studentDao.delete(id);
        return result;
        
    }

    @Override
    public StudentDTO searchStudent(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        
        
           
       List<StudentEntity> allentity = studentDao.getAll();
       
       List<StudentDTO> alldto = new ArrayList<>();
       
       for (StudentEntity students :allentity ){
       
           String id = students.getId();
           String name = students.getName();
           String email =students.getEmail();
           String tel = students.getTel();
           String courseid = students.getCourseid();
           
           
           StudentDTO dto = new StudentDTO(id, name, email, tel, courseid);
           alldto.add(dto);
       
       }
        return alldto;
     
        
        
        
    }

    @Override
    public List<StudentDTO> getStudentByCourseID(String courseId) throws Exception {
        
        List<StudentEntity> entityList = studentDao.getStudentByCourseID(courseId);
        
        List <StudentDTO> dtoList = new ArrayList<>();
        
        for (StudentEntity entity : entityList){
            
                String id = entity.getId();
                String name = entity.getName();
                
                
                StudentDTO dto = new StudentDTO(id, name, null, null, null);
                dtoList.add(dto);
        }
        
        return dtoList ;
    }
    
}
