/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.bo.custom;

import java.util.List;
import lk.ijse.aurasams.bo.SuperBO;
import lk.ijse.aurasams.dto.ReportDTO;

/**
 *
 * @author TechWave
 */
public interface ReportsBO extends SuperBO{

List<ReportDTO> getAttendanceByStudent(String courseId , String stuId) throws Exception;

List<ReportDTO> getAttendanceBySubject(String courseId , String subId) throws Exception;

List<ReportDTO> getAttendanceByDateRange(String courseId , String stuId ,String fromDate , String toDate) throws Exception;

    
}
