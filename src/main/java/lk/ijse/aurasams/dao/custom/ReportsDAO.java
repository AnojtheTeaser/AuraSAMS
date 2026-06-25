/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import java.util.List;
import lk.ijse.aurasams.dao.CrudDAO;
import lk.ijse.aurasams.entity.ReportEntity;

/**
 *
 * @author TechWave
 */
public interface ReportsDAO extends CrudDAO<ReportEntity> {
    
    
    List<ReportEntity> getAttendanceByStudent(String courseId,String stuId) throws Exception;
    
    List<ReportEntity> getAttendanceBySubjects(String courseId, String subId) throws Exception;
    
    List<ReportEntity> getAttendanceByDateRange(String courseId, String stuId ,String fromDate ,String toDate) throws Exception;
}
