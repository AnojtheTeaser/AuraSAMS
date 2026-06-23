/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.CourseBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.CourseDAO;
import lk.ijse.aurasams.dto.CourseDTO;
import lk.ijse.aurasams.entity.CourseEntity;

/**
 *
 * @author TechWave
 */
public class CourseBOImpl implements CourseBO {
    
    private final CourseDAO courseDao = (CourseDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        
       CourseEntity entity = new CourseEntity(dto.getId(),dto.getName());
     boolean result = courseDao.save(entity);
       
       return result;
        
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        
        CourseEntity entity = new CourseEntity(dto.getId(), dto.getName());
        boolean result = courseDao.update(entity);
        
        return result;
                
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
    
      boolean result = courseDao.delete(id);
      return result;

    }

    @Override
    public CourseDTO searchCourse(String id) throws Exception {
    return null;

    }

    @Override
    public List<CourseDTO> getAllCourse() throws Exception {
        
       List<CourseEntity> allentity = courseDao.getAll();
       
       List<CourseDTO> alldto = new ArrayList<>();
       
       for (CourseEntity course :allentity ){
       
           String id = course.getId();
           String name = course.getName();
           
           CourseDTO dto = new CourseDTO(id, name);
           alldto.add(dto);
       
       }
        return alldto;
     

    }
    
}
