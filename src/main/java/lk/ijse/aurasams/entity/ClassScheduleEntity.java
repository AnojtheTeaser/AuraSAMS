/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author TechWave
 */
public class ClassScheduleEntity {
    
    private String sched_id;
    private String course_id;
    private String sub_id;
    private String lec_id;
    private String  date  ;
    private String time;

    public ClassScheduleEntity() {
    }

    public ClassScheduleEntity(String sched_id, String course_id, String sub_id, String lec_id, String date, String time) {
        this.sched_id = sched_id;
        this.course_id = course_id;
        this.sub_id = sub_id;
        this.lec_id = lec_id;
        this.date = date;
        this.time = time;
    }

    public String getSched_id() {
        return sched_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public String getLec_id() {
        return lec_id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setSched_id(String sched_id) {
        this.sched_id = sched_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ClassScheduleEntity{" + "sched_id=" + sched_id + ", course_id=" + course_id + ", sub_id=" + sub_id + ", lec_id=" + lec_id + ", date=" + date + ", time=" + time + '}';
    }
    
    
    
    
}
