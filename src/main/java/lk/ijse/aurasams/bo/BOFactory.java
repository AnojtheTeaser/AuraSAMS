/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo;

import lk.ijse.aurasams.bo.custom.impl.CourseBOImpl;
import lk.ijse.aurasams.bo.custom.impl.StudentBOImpl;
import lk.ijse.aurasams.bo.custom.impl.SubjectBOImpl;

/**
 *
 * @author TechWave
 */
public class BOFactory {
    
    private static BOFactory boFactory;

    private BOFactory() {
    }
    
   public static enum BOTypes{
       
       COURSE,SUBJECTS,STUDENTS,LECTURER,CLASSSCHED,ATTENDANCE,REPORTS

}
    
   
   public static BOFactory getInstance(){
       
       return (boFactory == null)? boFactory = new BOFactory():boFactory;
   
   }
    
   public SuperBO getBO(BOTypes type){
    
    switch(type){
        
        case BOTypes.COURSE:
            return new CourseBOImpl();
        case BOTypes.SUBJECTS:
            return new SubjectBOImpl();
        case BOTypes.STUDENTS:
            return new StudentBOImpl();
        case BOTypes.LECTURER:
        case BOTypes.CLASSSCHED:
        case BOTypes.ATTENDANCE:
        case BOTypes.REPORTS:
            
        default:
            return null;
            
        
        
    }

}
    
    
    
}
