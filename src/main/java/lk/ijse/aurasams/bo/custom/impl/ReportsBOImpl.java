/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.ReportsBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.ReportsDAO;
import lk.ijse.aurasams.dto.ReportDTO;
import lk.ijse.aurasams.entity.ReportEntity;

/**
 *
 * @author TechWave
 */
public class ReportsBOImpl implements ReportsBO{
    
    private final ReportsDAO reportsdao = (ReportsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.REPORTS);
    
    
    @Override
    public List<ReportDTO> getAttendanceByStudent(String courseId, String stuId) throws Exception {
        
        List<ReportEntity> entityList = reportsdao.getAttendanceByStudent(courseId, stuId);
        
        List<ReportDTO> reportDto = new ArrayList<>();
        
        for(ReportEntity entity : entityList){
            
            String id = entity.getStuID();
            String stuname = entity.getStuName();
            String coursename = entity.getCourseName();
            String subjectName = entity.getSubjectName();
            String date =entity.getDate();
            String status = entity.getStatus();
            
            ReportDTO dto =new ReportDTO(id, stuname, coursename, subjectName, date, status);
            
             reportDto.add(dto);
        
    
    
    }
        return reportDto;
    }

    @Override
    public List<ReportDTO> getAttendanceBySubject(String courseId, String subId) throws Exception {
        
           List<ReportEntity> entityList = reportsdao.getAttendanceBySubjects(courseId, subId);
    
            List<ReportDTO> reportDtoList = new ArrayList<>();
    
   
    for (ReportEntity entity : entityList) {
        
            String id =entity.getStuID();
            String stuname = entity.getStuName();
            String courseName =entity.getCourseName();
            String subName =entity.getSubjectName();
            String date = entity.getDate();
            String status = entity.getStatus();
            
            
      ReportDTO dto = new ReportDTO(id, stuname, courseName, subName, date, status);
      reportDtoList.add(dto);
    }
    return reportDtoList;
        
    }

    @Override
    public List<ReportDTO> getAttendanceByDateRange(String courseId, String stuId, String fromDate, String toDate) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
