/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.bo.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.aurasams.bo.custom.SubjectBO;
import lk.ijse.aurasams.dao.DAOFactory;
import lk.ijse.aurasams.dao.custom.SubjectDAO;
import lk.ijse.aurasams.dto.SubjectDTO;
import lk.ijse.aurasams.entity.SubjectEntity;

/**
 *
 * @author TechWave
 */
public class SubjectBOImpl implements SubjectBO {

    SubjectDAO subjectDao = (SubjectDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUBJECTS);
        
    @Override
    public boolean saveSubject(SubjectDTO dto) throws Exception {
        
        SubjectEntity subentity = new SubjectEntity(dto.getId(), dto.getName());
        boolean result = subjectDao.save(subentity);
        
      return result ;
        
        
    }

    @Override
    public boolean updateSubject(SubjectDTO dto) throws Exception {
        
         SubjectEntity subentity = new SubjectEntity(dto.getId(), dto.getName());
        boolean result = subjectDao.update(subentity);
        
      return result ;
        

    }

    @Override
    public boolean deleteSubject(String id) throws Exception {
        
        boolean result = subjectDao.delete(id);
       return result;
    }

    @Override
    public SubjectDTO searchSubject(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SubjectDTO> getAllSubject() throws Exception {
        
        List<SubjectEntity> allsubList = subjectDao.getAll();
         
        List <SubjectDTO> subdtos = new ArrayList<>();
        
        for(SubjectEntity subenti : allsubList){
        
                String id = subenti.getId();
                String name = subenti.getName();
                
                SubjectDTO dtos =new SubjectDTO(id, name);
                subdtos.add(dtos);
        
        
        }
        return subdtos;
        

    }
    
}
