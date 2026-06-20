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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.aurasams.bo.BOFactory;
import lk.ijse.aurasams.bo.custom.CourseBO;
import lk.ijse.aurasams.bo.custom.Course_SubjectBO;
import lk.ijse.aurasams.bo.custom.SubjectBO;
import lk.ijse.aurasams.dto.CourseDTO;
import lk.ijse.aurasams.dto.Course_SubjectDTO;
import lk.ijse.aurasams.dto.SubjectDTO;

/**
 *
 * @author TechWave
 */
public class Course_SubjectPanelController implements Initializable{
    
    private final Course_SubjectBO courseSubjectBo =(Course_SubjectBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE_SUBJECT);
    private final CourseBO  courseBo =(CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);
     private final SubjectBO subjectBo = (SubjectBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUBJECTS);
    
     private final ObservableList<Course_SubjectDTO> tempTableList = FXCollections.observableArrayList();
     
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        subIDCol.setCellValueFactory(new PropertyValueFactory<>("subID"));
        subNameCol.setCellValueFactory(new PropertyValueFactory<>("subName"));
        
        subTable.setItems(tempTableList); 

        
        
        loadCourseCombo();
        loadsubCombo();
        loadSrearchCourseCombo();
        
    }
    
    

    @FXML
    private ComboBox<String> courseCombo;
    @FXML
    private ComboBox<SubjectDTO> subCombo;
    @FXML
    private TableView<Course_SubjectDTO> subTable;
    @FXML
    private TableColumn<Course_SubjectDTO, String> subIDCol;
    @FXML
    private TableColumn<Course_SubjectDTO,String> subNameCol;
    @FXML
    private ComboBox<String> searchCourseCombo;

    
    
    
    
    
    
    @FXML
    private void addBtnOnAction(ActionEvent event) {
     
    

System.out.println("addbutton");

    
    String courseID = courseCombo.getSelectionModel().getSelectedItem();
                if (courseID == null || courseID.trim().isEmpty()) {
                    
             new Alert(Alert.AlertType.ERROR, "empty value input").show();
        return;  
    }

   
    SubjectDTO selectedSubject = subCombo.getSelectionModel().getSelectedItem();
     if (selectedSubject == null) {
                  new Alert(Alert.AlertType.ERROR, "empty value input").show();
                
                  return;  
    }

  
            for (Course_SubjectDTO dto : tempTableList) {
                String existingSubID = dto.getSubID();
                    String currentSubID = selectedSubject.getId();
                    
     if (existingSubID.equals(currentSubID)) {
            new Alert(Alert.AlertType.ERROR, "alrady enterd").show();
            return;  
        }
    }

   
    String subID = selectedSubject.getId();
    String subName = selectedSubject.getName();

    Course_SubjectDTO newRowData = new Course_SubjectDTO(courseID, subID, subName);
    tempTableList.add(newRowData);



    }
    @FXML
    private void saveBtnOnAction(ActionEvent event) {

        
if (tempTableList.isEmpty()) {
         new Alert(Alert.AlertType.ERROR,"empy value input").show();
        return; 
    }

    try {
        boolean allSaved = true;

        for (Course_SubjectDTO tableRow : tempTableList) {
            boolean isSaved = courseSubjectBo.saveCourseSubject(tableRow);
            if (!isSaved) {
                allSaved = false; 
            }
        }

        if (allSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Save successfully ").show();
            tempTableList.clear();
            courseCombo.getSelectionModel().clearSelection();
            subCombo.getSelectionModel().clearSelection();
        } else {
            new Alert(Alert.AlertType.ERROR, "something went wrong").show();
        }

    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "something went wrong").show();
    }


    }

    @FXML
    private void deleteBtnOnAction(ActionEvent event) {
        
          String selectedCourseID = courseCombo.getSelectionModel().getSelectedItem();

    if (selectedCourseID == null) {
         new Alert(Alert.AlertType.ERROR,"empty value input").show();
        return; 
    }

    try {
        boolean isDeleted = courseSubjectBo.deleteCourseSubject(selectedCourseID);

        if (isDeleted) {
           new Alert(Alert.AlertType.INFORMATION, "Delete successfully ").show();
            
            
            tempTableList.clear();
            courseCombo.getSelectionModel().clearSelection();
            subCombo.getSelectionModel().clearSelection();
            
        } else {
             new Alert(Alert.AlertType.ERROR, "No Data to Delete").show();
           
        }

    } catch (Exception e) {
        e.printStackTrace();
         new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
        ;
    }
        

        
    }

    @FXML
    private void resetBtnOnAction(ActionEvent event) {
        subCombo.getSelectionModel().clearSelection();
        courseCombo.getSelectionModel().clearSelection();
    }

    @FXML
    private void tableResetBtnOnAction(ActionEvent event) {
        System.out.println("table reset");
        
        searchCourseCombo.getSelectionModel().clearSelection();
        tempTableList.clear();;
        subTable.refresh();;
    }


    private void loadCourseCombo(){
            try{
            List<CourseDTO> allcourse = courseBo.getAllCourse();
            courseCombo.getItems().clear();
            
            for(CourseDTO course: allcourse){
                courseCombo.getItems().add(course.getId());
            }
            
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("combo box load error");
                
            }
            
            }
    
    
    
    
    private void loadsubCombo(){
              try {
        List<SubjectDTO> allcourse = subjectBo.getAllSubject();

        subCombo.getItems().clear();

        for (SubjectDTO subjects : allcourse) {
            subCombo.getItems().add(subjects);
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("combo box load error");
    }
            }

  
    
     private void loadSrearchCourseCombo(){
            try{
            List<CourseDTO> allcourse = courseBo.getAllCourse();
            searchCourseCombo.getItems().clear();
            
            for(CourseDTO course: allcourse){
                searchCourseCombo.getItems().add(course.getId());
            }
            
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("combo box load error");
                
            }
            
            }

    @FXML
    private void searchCourseComboBoxOnAction(ActionEvent event) {
        try{
            String selectedCourseId =searchCourseCombo.getSelectionModel().getSelectedItem();
            if(selectedCourseId == null){
                 new Alert(Alert.AlertType.ERROR, "Empty value input").show();
                 return;
            
            }
            tempTableList.clear();
            
            List<Course_SubjectDTO> subjects = courseSubjectBo.getSubjectsByCourseID(selectedCourseId);
            
            if(subjects != null){
                tempTableList.addAll(subjects);
                subTable.refresh();
                
            
            }else{
              new Alert(Alert.AlertType.ERROR, "No data Found").show();

            }
            
            
        
        }catch(Exception e){
        e.printStackTrace();
               new Alert(Alert.AlertType.ERROR, "something went wrong").show();

        }
        
        
        
    }

    @FXML
    private void ResetCourseIDBtnOnAction(ActionEvent event) {
        searchCourseCombo.getSelectionModel().clearSelection();
        
    }
    
    
    
    
}
    

