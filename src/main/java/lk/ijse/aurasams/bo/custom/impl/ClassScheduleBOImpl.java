/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.ClassScheduleBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.ClassScheduleDAO;
import lk.ijse.aurasams.dto.ClassScheduleDTO;
import lk.ijse.aurasams.entity.ClassScheduleEntity;

/**
 *
 * @author TechWave
 */
public class ClassScheduleBOImpl implements ClassScheduleBO{
    
 private final ClassScheduleDAO classschedDao = (ClassScheduleDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CLASSSCHED);


    @Override
    public boolean saveSched(ClassScheduleDTO dto) throws Exception {
        
        ClassScheduleEntity entity = new ClassScheduleEntity(dto.getSched_id(), dto.getCourse_id(), dto.getSub_id(), dto.getLec_id(), dto.getDate(),dto.getTime());
       
        boolean result = classschedDao.save(entity);
        return result;
        
    }

    @Override
    public boolean updateSched(ClassScheduleDTO dto) throws Exception {
        
        ClassScheduleEntity entity = new ClassScheduleEntity(dto.getSched_id(), dto.getCourse_id(), dto.getSub_id(), dto.getLec_id(), dto.getDate(),dto.getTime());
       
        boolean result = classschedDao.update(entity);
        return result;
    }

    @Override
    public boolean deleteSched(String id) throws Exception {
        
        boolean result = classschedDao.delete(id);
        return result;
        
    }

    @Override
    public ClassScheduleDTO searchSched(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClassScheduleDTO> getAllSched() throws Exception {
        
        List <ClassScheduleEntity> entityList = classschedDao.getAll();
        List <ClassScheduleDTO>  dtoList = new ArrayList<>();
        
        for (ClassScheduleEntity entity : entityList){
        
             String schedid = entity.getSched_id();
            String courseid = entity.getCourse_id();
            String subid =   entity.getSub_id();
            String lecid= entity.getLec_id();
            String date = entity.getDate();
            String  time =  entity.getTime();
            
            ClassScheduleDTO dtos = new ClassScheduleDTO(schedid, courseid, subid, lecid, date, time);
            dtoList.add(dtos);

        
        }
        
        return dtoList;
    }
    
}
