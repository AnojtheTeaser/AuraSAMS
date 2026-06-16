/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.aurasams.bo.BOFactory;
import lk.ijse.aurasams.bo.custom.CourseBO;
import lk.ijse.aurasams.dto.CourseDTO;

/**
 *
 * @author TechWave
 */
public class CoursePanelController {
   
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
    private TableView<?> courseTable;
    @FXML
    private TableColumn<?, ?> courseIDCol;
    @FXML
    private TableColumn<?, ?> courseNameCol;

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        System.out.println("course save btn clicked");
         
        
        try{
            String id = courseIDTextField.getText();
            String name = courseNameTextField.getText();
            
            CourseDTO dto =new CourseDTO(id, name);
            boolean result = courseBo.saveCourse(dto);
            
            if(result){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully").show();
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
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
    }

    @FXML
    private void btnResetOnAction(ActionEvent event) {
    }

    
    
    
}
