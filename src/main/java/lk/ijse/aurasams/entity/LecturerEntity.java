/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.entity;

/**
 *
 * @author TechWave
 */
public class LecturerEntity {
    
    private String id ;
    private String name;
    private String email;
    private String tel;

    public LecturerEntity() {
    }

    public LecturerEntity(String id, String name, String email, String tel) {
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

    @Override
    public String toString() {
        return "LecturerEntity{" + "id=" + id + ", name=" + name + ", email=" + email + ", tel=" + tel + '}';
    }
    
    
}
