/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
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
import lk.ijse.aurasams.bo.custom.ClassScheduleBO;
import lk.ijse.aurasams.dto.ClassScheduleDTO;

/**
 *
 * @author TechWave
 */
public class ClassSchedulePanelController implements Initializable{
private final ClassScheduleBO classschedBo = (ClassScheduleBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.CLASSSCHED);
    
    @FXML
    private TextField schedIDTextField;
    @FXML
    private TextField courseIDTextFields;
    @FXML
    private TextField subIDTextFields;
    @FXML
    private TextField lecIDTextFields;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField timeTextField;
    @FXML
    private Button schedSaveBtn;
    @FXML
    private Button schedUpdateBtn;
    @FXML
    private Button schedDeleteBtn;
    @FXML
    private Button schedResetBtn;
    @FXML
    private TableView<ClassScheduleDTO> shedTable;
    @FXML
    private TableColumn<ClassScheduleDTO, String> schedIDCol;
    @FXML
    private TableColumn<ClassScheduleDTO, String> courseIDCol;
    @FXML
    private TableColumn<ClassScheduleDTO, String> subIDCol;
    @FXML
    private TableColumn<ClassScheduleDTO, String> lecIDCol;
    @FXML
    private TableColumn<ClassScheduleDTO, Date> dateCol;
    @FXML
    private TableColumn<ClassScheduleDTO, Time> timeCol;
    
    
    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Loadtable();
        tableMouseClick();
        
        
        
        
        
    }

    
    
    @FXML
    private void saveOnAction(ActionEvent event) {
        try{
            String schedid = schedIDTextField.getText();
            String courseId = courseIDTextFields.getText(); 
            String subId = subIDTextFields.getText(); 
            String lecId = lecIDTextFields.getText(); 
            String date = dateTextField.getText(); 
            String time = timeTextField.getText();
            
            if ( courseId.isEmpty() || subId.isEmpty() || lecId.isEmpty() || date.isEmpty()|| time.isEmpty()){
              new Alert(Alert.AlertType.ERROR,"empty values input").show();
              return;
            }
            
            ClassScheduleDTO dto = new ClassScheduleDTO(schedid, courseId, subId, lecId, date, time);
            boolean res = classschedBo.saveSched(dto);
            if(res){
                 new Alert(Alert.AlertType.INFORMATION,"Saved successfully").show();
                 resetOnAction(event);
                 Loadtable();
            }else {
                   new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
            }

            }catch(Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
            }
    }

    @FXML
    private void updateOnAction(ActionEvent event) {
        
        try { 
String schedId = schedIDTextField.getText(); 
 String courseId = courseIDTextFields.getText();
  String subId = subIDTextFields.getText(); 
  String lecId = lecIDTextFields.getText(); 
  String date = dateTextField.getText(); 
  String time = timeTextField.getText(); 

  if (schedId.isEmpty()) { 
  new Alert(Alert.AlertType.WARNING, "empty value input").show();
   return; 
   }
    ClassScheduleDTO dto = new ClassScheduleDTO(schedId, courseId, subId, lecId, date, time); 
    boolean res = classschedBo.updateSched(dto);

     if (res) { 

     new Alert(Alert.AlertType.INFORMATION, " Updated Successfull").show();
         resetOnAction(event);
         Loadtable();

     
    
     } else {
      new Alert(Alert.AlertType.ERROR, "some thing went wrong").show(); 
      } 
      } catch (Exception e) { 
      e.printStackTrace(); 
      new Alert(Alert.AlertType.ERROR, "some thing went wrong").show();
       } 
       }
        
  
    @FXML
    private void deleteOnAction(ActionEvent event) {
        
        try {
 String schedId = schedIDTextField.getText();
  if (schedId.isEmpty()) { 
  new Alert(Alert.AlertType.WARNING, "empty value input").show(); 
  return; 
  }
   boolean isDeleted = classschedBo.deleteSched(schedId);
   if (isDeleted) {
    new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully!").show();
    resetOnAction(event);
         Loadtable();

    
    } else { 
    new Alert(Alert.AlertType.ERROR, "something went wrong").show(); 
    } 
    } catch (Exception e) {
    e.printStackTrace();
     new Alert(Alert.AlertType.ERROR, "something went wrong").show();
    }
        
        
        
        
    }

    @FXML
    private void resetOnAction(ActionEvent event) {
        
        
            schedIDTextField.clear();
            courseIDTextFields.clear();
            subIDTextFields.clear();
            lecIDTextFields.clear(); 
            dateTextField.clear();
            timeTextField.clear();
        
        
    }

  private void Loadtable(){
      try{
        schedIDCol.setCellValueFactory(new PropertyValueFactory<>("sched_id"));
        courseIDCol.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        subIDCol.setCellValueFactory(new PropertyValueFactory<>("sub_id"));
        lecIDCol.setCellValueFactory(new PropertyValueFactory<>("lec_id"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date")); 
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
                
        List<ClassScheduleDTO> allcourse = classschedBo.getAllSched();
        
        ObservableList<ClassScheduleDTO> dtoList = FXCollections.observableArrayList(allcourse);
        shedTable.setItems(dtoList);
        
      }catch(Exception e){
      e.printStackTrace();
      }
        
  
  
  }
   
  
  public void tableMouseClick(){
  
    shedTable.setOnMouseClicked(event ->{
            ClassScheduleDTO selectTableline = shedTable.getSelectionModel().getSelectedItem();
            
            if(selectTableline != null){
                
              
            schedIDTextField.setText(selectTableline.getSched_id());
            courseIDTextFields.setText(selectTableline.getCourse_id());
            subIDTextFields.setText(selectTableline.getSub_id());
            lecIDTextFields.setText(selectTableline.getLec_id());
            dateTextField.setText(selectTableline.getDate());
            timeTextField.setText(selectTableline.getTime());
                
                
            }
        
        });
        
        
    
    }
   
  
  }

