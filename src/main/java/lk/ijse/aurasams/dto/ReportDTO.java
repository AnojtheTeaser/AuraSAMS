/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dto;

/**
 *
 * @author TechWave
 */
public class ReportDTO {
    
    private String stuID;
    private String stuName;
    private String courseName;
    private String subjectName;
    private String date;
    private String status;

    public ReportDTO() {
    }

    public ReportDTO(String stuID, String stuName, String courseName, String subjectName, String date, String status) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.courseName = courseName;
        this.subjectName = subjectName;
        this.date = date;
        this.status = status;
    }

    public String getStuID() {
        return stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AttendanceRepiortDTO{" + "stuID=" + stuID + ", stuName=" + stuName + ", courseName=" + courseName + ", subjectName=" + subjectName + ", date=" + date + ", status=" + status + '}';
    }

    
    
}
