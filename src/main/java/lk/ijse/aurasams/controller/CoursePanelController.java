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
import lk.ijse.aurasams.bo.custom.CourseBO;
import lk.ijse.aurasams.dto.CourseDTO;
import lk.ijse.aurasams.entity.CourseEntity;

/**
 *
 * @author TechWave
 */
public class CoursePanelController implements Initializable {
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadAllCourse();
        tableMouseClick();
    }
    
    
   
    private final CourseBO courseBo = (CourseBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);

    @FXML
    private TextField courseIDTextField;
    @FXML
    private TextField courseNameTextField;
    @FXML
    private Button courseSaveBtn;
    @FXML
    private Button courseUpdateBtn;
    @FXML
    private Button courseDeleteBtn;
    @FXML
    private Button courseResetBtn;
    @FXML
    private TableView<CourseDTO> courseTable;
    @FXML
    private TableColumn<CourseDTO, String> courseIDCol;
    @FXML
    private TableColumn<CourseDTO, String> courseNameCol;

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        
        System.out.println("course save btn clicked");
         
        
        try{
            String id = courseIDTextField.getText();
            String name = courseNameTextField.getText();
            
            CourseDTO dto =new CourseDTO(id, name);
            boolean result = courseBo.saveCourse(dto);
            
            if(result){
            new Alert(Alert.AlertType.INFORMATION,"Saved successfully").show();
            loadAllCourse();
                btnResetOnAction(event);
            } else{
            
             new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();

            }
            
        }catch(Exception e){
            e.printStackTrace();
               new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();

            
        
        }
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
        System.out.println("update btn cliked");
        try{
        String id = courseIDTextField.getText();
        String name = courseNameTextField.getText();
        
        CourseDTO dto = new CourseDTO(id, name);
        boolean result = courseBo.updateCourse(dto);
        
        if(result){
        
            
              new Alert(Alert.AlertType.CONFIRMATION,"Update successfully").show();
              loadAllCourse();
              btnResetOnAction(event);
             
            } else{
            
             new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
        }
        
        } catch (Exception e){
            e.printStackTrace();
             new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
        }            

         loadAllCourse();
        
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        try{
        String id = courseIDTextField.getText();
        boolean result = courseBo.deleteCourse(id);
        
        if(result){
        new Alert(Alert.AlertType.CONFIRMATION,"Delete successfully").show();
        loadAllCourse();
        btnResetOnAction(event);
        }else{
         new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
        }
        
        } catch(Exception e ){
            e.printStackTrace();
             new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
        
        }
    }

    @FXML
    private void btnResetOnAction(ActionEvent event) {
        
        courseIDTextField.clear();
        courseNameTextField.clear();
    }

    
    private void loadAllCourse(){
        
    try{
        
        courseIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        courseNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        List<CourseDTO> allcourse = courseBo.getAllCourse();
        
        ObservableList<CourseDTO> dtoList = FXCollections.observableArrayList(allcourse);
        courseTable.setItems(dtoList);
        
  
    }catch(Exception e){
        e.printStackTrace();
        System.out.println("course table load erro");
    }
  
    }

    
    
    
    private void tableMouseClick(){
        
        // this method use Lamda Expression -> 
        
        courseTable.setOnMouseClicked(event ->{
            CourseDTO selectTableline = courseTable.getSelectionModel().getSelectedItem();
            
            if(selectTableline != null){
                
                courseIDTextField.setText(selectTableline.getId());
                courseNameTextField.setText(selectTableline.getName());
              
            }
        
        });
        
        
    
    }
   
}
