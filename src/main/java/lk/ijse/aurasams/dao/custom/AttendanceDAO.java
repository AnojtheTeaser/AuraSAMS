/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import lk.ijse.aurasams.dao.CrudDAO;
import lk.ijse.aurasams.entity.AttendanceEntity;

/**
 *
 * @author TechWave
 */
public interface AttendanceDAO extends CrudDAO <AttendanceEntity>{
    
    boolean checkAttendanceExists(String schedId, String stuId) throws Exception;
    
    public boolean Delete(String schedId, String stuId) throws Exception;
    
    
}
