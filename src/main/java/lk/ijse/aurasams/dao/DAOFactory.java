/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dao;

import lk.ijse.aurasams.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.ClassScheduleDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.CourseDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.Course_SubjectDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.LecturerDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.LecturerSubjectDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.ReportsDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.StudentDAOImpl;
import lk.ijse.aurasams.dao.custom.impl.SubjectDAOImpl;

/**
 *
 * @author TechWave
 */
public class DAOFactory {
    
public static DAOFactory daoFactory;

    public DAOFactory() {
    }
        
    public static enum DAOTypes{
       COURSE_SUBJECT,LECTURER_SUBJECTS,COURSE,SUBJECTS,STUDENTS,LECTURER,CLASSSCHED,ATTENDANCE,REPORTS
    
    }
    
public static DAOFactory getInstance(){
    
    return daoFactory == null ? (daoFactory = new DAOFactory()): daoFactory;
}

public SuperDAO getDAO(DAOTypes type){
    
    switch(type){
        
        case DAOTypes.COURSE:
            return new CourseDAOImpl();
        case DAOTypes.SUBJECTS:
            return new SubjectDAOImpl();
        case DAOTypes.STUDENTS:
             return new StudentDAOImpl();
         case DAOTypes.LECTURER_SUBJECTS:
            return new LecturerSubjectDAOImpl();
        case DAOTypes.LECTURER:
            return new LecturerDAOImpl();
        case DAOTypes.COURSE_SUBJECT:
            return new Course_SubjectDAOImpl();
        case DAOTypes.CLASSSCHED:
            return new ClassScheduleDAOImpl();
        case DAOTypes.ATTENDANCE:
            return new AttendanceDAOImpl();
        case DAOTypes.REPORTS:
              return new ReportsDAOImpl();
        
        default:
            return null;
            
        
        
    }

}


    
    
    
    
    
    
    
}
