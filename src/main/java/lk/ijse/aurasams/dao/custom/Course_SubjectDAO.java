/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import java.util.List;
import lk.ijse.aurasams.dao.CrudDAO;
import lk.ijse.aurasams.entity.Course_SubjectEntity;

/**
 *
 * @author TechWave
 */
public interface Course_SubjectDAO extends CrudDAO<Course_SubjectEntity> {
    
    List <Course_SubjectEntity> getSubByCourseId (String courseId)throws Exception;
    
    boolean DeletefromMapping(String courseId) throws Exception;
    
}
