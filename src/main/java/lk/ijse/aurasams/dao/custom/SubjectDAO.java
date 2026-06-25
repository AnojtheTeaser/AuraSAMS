/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import java.util.List;
import lk.ijse.aurasams.dao.CrudDAO;
import lk.ijse.aurasams.entity.SubjectEntity;

/**
 *
 * @author TechWave
 */
public interface SubjectDAO extends CrudDAO<SubjectEntity> {
    
    public List<SubjectEntity> getSubjectByCourseID(String courseId) throws Exception;
    
}
