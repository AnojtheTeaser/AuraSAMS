/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import java.util.List;
import lk.ijse.aurasams.dao.SuperDAO;

/**
 *
 * @author TechWave
 */
public interface LecturerSubjectDAO extends SuperDAO {
    
       boolean saveLecturerSubMapping(String lecId , String subId) throws Exception;
    
       // public List<String> getLecturersBySubject(String subId) throws Exception;
    
}
