/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dto;

import java.util.List;

/**
 *
 * @author TechWave
 */
public class LecturerDTO {
    
     private String id ;
    private String name;
    private String email;
    private String tel;
    
    private String tempSubject;
    private List<String> subjectList;
            

    public LecturerDTO() {
    }

    public LecturerDTO(String id, String name, String email, String tel, List<String> subjectList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.subjectList = subjectList;
    }

    public LecturerDTO(String id, String name, String email, String tel, String tempSubject) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.tempSubject = tempSubject;
    }

    public LecturerDTO(String id, String name, String email, String tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
    }
    
    
    
    
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getTempSubject() {
        return tempSubject;
    }
    

    public List<String> getSubjectList() {
        return subjectList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setTempSubject(String temsubject) {
        this.tempSubject = temsubject;
    }

    
    public void setSubjectList(List<String> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public String toString() {
        return "LecturerDTO{" + "id=" + id + ", name=" + name + ", email=" + email + ", tel=" + tel + ", tempSubject=" + tempSubject + ", subjectList=" + subjectList + '}';
    }

   

   

    
    
    
   
    
}
