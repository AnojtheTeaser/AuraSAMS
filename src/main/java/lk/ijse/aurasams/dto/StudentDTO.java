/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dto;

/**
 *
 * @author TechWave
 */
public class StudentDTO {
    
    private String id;
    private String name;
    private String email;
    private String tel;
    private String courseid;

    public StudentDTO() {
    }

    public StudentDTO(String id, String name, String email, String tel, String courseid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.courseid = courseid;
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

    public String getCourseid() {
        return courseid;
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

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "id=" + id + ", name=" + name + ", email=" + email + ", tel=" + tel + ", courseid=" + courseid + '}';
    }
    
    
    
}
