/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.entity;

/**
 *
 * @author TechWave
 */
public class AttendanceEntity {
    
    private String attID;
    private String schedID;
    private String stuID;
    private String status;

    public AttendanceEntity() {
    }

    public AttendanceEntity(String attID, String schedID, String stuID, String status) {
        this.attID = attID;
        this.schedID = schedID;
        this.stuID = stuID;
        this.status = status;
    }

    public AttendanceEntity(String schedID, String stuID, String status) {
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
        return "AttendanceEntity{" + "attID=" + attID + ", schedID=" + schedID + ", stuID=" + stuID + ", status=" + status + '}';
    }
    
    
    
}
