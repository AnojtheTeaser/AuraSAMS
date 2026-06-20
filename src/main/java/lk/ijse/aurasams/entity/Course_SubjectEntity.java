/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.entity;

/**
 *
 * @author TechWave
 */
public class Course_SubjectEntity {
    private  String courseID;
    private String subID;
    private String subName;

    public Course_SubjectEntity() {
    }

    public Course_SubjectEntity(String courseID, String subID, String subName) {
        this.courseID = courseID;
        this.subID = subID;
        this.subName = subName;
    }

    public Course_SubjectEntity(String courseID, String subID) {
        this.courseID = courseID;
        this.subID = subID;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getSubID() {
        return subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Course_SubjectEntity{" + "courseID=" + courseID + ", subID=" + subID + ", subName=" + subName + '}';
    }
    
    
    
}
