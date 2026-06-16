/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.aurasams.dao;

import java.util.List;

/**
 *
 * @author TechWave
 */
public interface CrudDAO<T> extends SuperDAO {
    
            boolean save(T entity) throws Exception;
            boolean update(T entity) throws Exception;
            boolean delete(String id ) throws Exception;
            
            T search(String id) throws Exception;
            List<T> getAll() throws Exception;
    
    
}
