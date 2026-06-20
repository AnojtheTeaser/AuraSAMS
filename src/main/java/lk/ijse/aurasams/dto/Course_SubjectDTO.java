/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dto;

/**
 *
 * @author TechWave
 */
public class Course_SubjectDTO {
      private  String courseID;
    private String subID;
    private String subName;

    public Course_SubjectDTO() {
    }

    public Course_SubjectDTO(String courseID, String subID, String subName) {
        this.courseID = courseID;
        this.subID = subID;
        this.subName = subName;
    }
//
//    public Course_SubjectDTO(String subID, String subName) {
//        this.subID = subID;
//        this.subName = subName;
//    }
    
    
     public Course_SubjectDTO(String courseID, String subName) {
        this.courseID =courseID;
        this.subName = subName;
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
        return "Course_SubjectDTO{" + "courseID=" + courseID + ", subID=" + subID + ", subName=" + subName + '}';
    }
    
    
    
    
}
