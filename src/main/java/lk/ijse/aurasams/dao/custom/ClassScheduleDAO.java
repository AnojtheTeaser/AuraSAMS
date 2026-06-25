/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import java.util.List;
import lk.ijse.aurasams.dao.CrudDAO;
import lk.ijse.aurasams.entity.ClassScheduleEntity;

/**
 *
 * @author TechWave
 */
public interface ClassScheduleDAO extends CrudDAO<ClassScheduleEntity>{
    
    public List<String> getSubjectsByCourse(String courseId) throws Exception;
    
    public List<String> getLecturersBySubject(String subId) throws Exception;
    
}
