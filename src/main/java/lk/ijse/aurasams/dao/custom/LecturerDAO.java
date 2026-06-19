/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao.custom;

import java.sql.Connection;
import lk.ijse.aurasams.dao.CrudDAO;
import lk.ijse.aurasams.entity.LecturerEntity;

/**
 *
 * @author TechWave
 */
public interface LecturerDAO extends CrudDAO<LecturerEntity> {
    
    public boolean updateLecturerSubMapping(String lecId, String subId, Connection conn) throws Exception;
    
}
