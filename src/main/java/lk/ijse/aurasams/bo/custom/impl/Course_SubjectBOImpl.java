/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.Course_SubjectBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.Course_SubjectDAO;
import lk.ijse.aurasams.dto.Course_SubjectDTO;
import lk.ijse.aurasams.entity.Course_SubjectEntity;

/**
 *
 * @author TechWave
 */
public class Course_SubjectBOImpl implements Course_SubjectBO {
    
    private final Course_SubjectDAO courseSubjectDao = (Course_SubjectDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE_SUBJECT);

    @Override
    public boolean saveCourseSubject(Course_SubjectDTO dto) throws Exception {
        
        Course_SubjectEntity entity = new Course_SubjectEntity(dto.getCourseID(), dto.getSubID());
        boolean result = courseSubjectDao.save(entity);
        return result;
        
    }

    @Override
    public List<Course_SubjectDTO> getSubjectsByCourseID(String courseId) throws Exception {
        
        List <Course_SubjectEntity> entityList = courseSubjectDao.getSubByCourseId(courseId);
        List <Course_SubjectDTO> dtoList = new ArrayList<>();
        
        for (Course_SubjectEntity  entity : entityList){
        
            String courseID = entity.getCourseID();
            String subID = entity.getSubID();
            String subName = entity.getSubName();
            
            Course_SubjectDTO dto = new Course_SubjectDTO(courseID, subID, subName);
            dtoList.add(dto);
        
        }
        return dtoList;
        
    }

    @Override
    public boolean deleteCourseSubject(String courseId) throws Exception {
        
        boolean result =  courseSubjectDao.DeletefromMapping(courseId);
        return result;
        
        
    }
    
}
