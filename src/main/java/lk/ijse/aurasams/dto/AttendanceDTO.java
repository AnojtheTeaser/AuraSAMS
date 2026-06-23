/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dto;

/**
 *
 * @author TechWave
 */
public class AttendanceDTO {
     private String attID;
    private String schedID;
    private String stuID;
    private String status;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String attID, String schedID, String stuID, String status) {
        this.attID = attID;
        this.schedID = schedID;
        this.stuID = stuID;
        this.status = status;
    }

    public AttendanceDTO(String schedID, String stuID, String status) {
        this.schedID = schedID;
        this.stuID = stuID;
        this.status = status;
    }
    
    

    public String getAttID() {
        return attID;
    }

    public String getSchedID() {
        return schedID;
    }

    public String getStuID() {
        return stuID;
    }

    public String getStatus() {
        return status;
    }

    public void setAttID(String attID) {
        this.attID = attID;
    }

    public void setSchedID(String schedID) {
        this.schedID = schedID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" + "attID=" + attID + ", schedID=" + schedID + ", stuID=" + stuID + ", status=" + status + '}';
    }
    
    
}
