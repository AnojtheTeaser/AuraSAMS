/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.aurasams.bo.BOFactory;
import lk.ijse.aurasams.bo.custom.SubjectBO;
import lk.ijse.aurasams.dao.custom.SubjectDAO;
import lk.ijse.aurasams.dto.SubjectDTO;

/**
 *
 * @author TechWave
 */
public class SubjectPanelController implements Initializable  {
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadTableAllSubjects();
        tableMouseClick();
        
    }
    
    SubjectBO subjectBo = (SubjectBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.SUBJECTS);
    

    @FXML
    private TextField SubjectIDTextField;
    @FXML
    private TextField subjectNameTextFields;
    @FXML
    private Button subSaveBtn;
    @FXML
    private Button subUpdateBtn;
    @FXML
    private Button subDeleteBtn;
    @FXML
    private Button subResetBtn;
    @FXML
    private TableView<SubjectDTO> subTable;
    @FXML
    private TableColumn<SubjectDTO, String> tableSubID;
    @FXML
    private TableColumn<SubjectDTO, String> tableSubName;

    @FXML
    private void btnSaveSubject(ActionEvent event) {
         System.out.println("subject save btn clicked");
         try{
             String id = SubjectIDTextField.getText();
             String name = subjectNameTextFields.getText();
             
             SubjectDTO subdto =new SubjectDTO(id, name);
             
             boolean result = subjectBo.saveSubject(subdto);
             
             if(result){
                         new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully").show();
                         loadTableAllSubjects();
             }else{
                  new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
             }
             
             
         
         }catch(Exception e){
         e.printStackTrace();
          new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
         }
        
    }

    @FXML
    private void btnUpdateSubject(ActionEvent event) {
         System.out.println("subject update btn clicked");
         
          try{
             String id = SubjectIDTextField.getText();
             String name = subjectNameTextFields.getText();
             
             SubjectDTO subdto =new SubjectDTO(id, name);
             
             boolean result = subjectBo.updateSubject(subdto);
             
             if(result){
                         new Alert(Alert.AlertType.CONFIRMATION,"Update successfully").show();
                         loadTableAllSubjects();
             }else{
                  new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
             }
             
         
          }catch(Exception e){
         e.printStackTrace();
          new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
         }
    }

    @FXML
    private void btnDeleteSubject(ActionEvent event) {
         System.out.println("subject delete btn clicked");
         try{
         
             String id =SubjectIDTextField.getText();
             boolean result = subjectBo.deleteSubject(id);
         
              if(result){
                         new Alert(Alert.AlertType.CONFIRMATION,"Delete successfully").show();
                         loadTableAllSubjects();
             }else{
                  new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
             }
             
         }catch(Exception e){
         e.printStackTrace();
          new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
         }
    }

    @FXML
    private void btnResetSubject(ActionEvent event) {
        
        SubjectIDTextField.clear();
        subjectNameTextFields.clear();
        
    }
    
    
    
     private void loadTableAllSubjects(){
        
    try{
        
        tableSubID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableSubName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        List<SubjectDTO> allcourse = subjectBo.getAllSubject();
        
        ObservableList<SubjectDTO> dtoList = FXCollections.observableArrayList(allcourse);
        subTable.setItems(dtoList);
        
  
    }catch(Exception e){
        e.printStackTrace();
        System.out.println("course table load erro");
    }
  
    }

     
     
      
    private void tableMouseClick(){
        
        // this method use Lamda Expression -> 
        
       subTable.setOnMouseClicked(event ->{
            SubjectDTO selectTableline = subTable.getSelectionModel().getSelectedItem();
            
            if(selectTableline != null){
                
                SubjectIDTextField.setText(selectTableline.getId());
                subjectNameTextFields.setText(selectTableline.getName());
              
            }
        
        });
        
        
    }   

    
}
