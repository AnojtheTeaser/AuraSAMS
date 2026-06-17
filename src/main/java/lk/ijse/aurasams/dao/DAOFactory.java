/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.dao;

import lk.ijse.aurasams.dao.custom.impl.CourseDAOImpl;
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
        COURSE,SUBJECTS,STUDENTS,LECTURER,CLASSSCHED,ATTENDANCE,REPORTS
    
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
        case DAOTypes.LECTURER:
        case DAOTypes.CLASSSCHED:
        case DAOTypes.ATTENDANCE:
        case DAOTypes.REPORTS:
            
        default:
            return null;
            
        
        
    }

}


    
    
    
    
    
    
    
}
