/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.entity;

/**
 *
 * @author TechWave
 */
public class CourseEntity {
    private String id;
    private String name;

    public CourseEntity() {
    }
    
    

    public CourseEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseEntity{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
