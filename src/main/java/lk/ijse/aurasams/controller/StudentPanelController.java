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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.aurasams.bo.BOFactory;
import lk.ijse.aurasams.bo.custom.CourseBO;
import lk.ijse.aurasams.bo.custom.StudentBO;
import lk.ijse.aurasams.dao.custom.StudentDAO;
import lk.ijse.aurasams.dto.CourseDTO;
import lk.ijse.aurasams.dto.StudentDTO;

/**
 *
 * @author TechWave
 */
public class StudentPanelController implements Initializable  {
    
    StudentBO studentBo = (StudentBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENTS);
        CourseBO courseBo = (CourseBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);

    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         loadCourseCombo();
         tableMouseClick();
         loadStudentTable();
    }

    @FXML
    private TextField studentIDTextField;
    @FXML
    private TextField studentNameTextField;
    @FXML
    private TextField studentEmailTextField;
    @FXML
    private TextField studentTelTextField;
    @FXML
    private ComboBox<String> courseidComboBox;
    @FXML
    private Button studentSaveBtn;
    @FXML
    private Button studentUpdateBtn;
    @FXML
    private Button studentDeleteBtn;
    @FXML
    private Button studentResetBtn;
    @FXML
    private TableView<StudentDTO> StudentsTable;
    @FXML
    private TableColumn<StudentDTO, String> tableStudentID;
    @FXML
    private TableColumn<StudentDTO, String> tableStudentName;
    @FXML
    private TableColumn<StudentDTO, String> tableStudentEmail;
    @FXML
    private TableColumn<StudentDTO, String> tableStudentTel;
    @FXML
    private TableColumn<StudentDTO, String> tableStudentCourseID;

    @FXML
    private void btnStudentsSave(ActionEvent event) {
        System.out.println("student save buttn clicked");
        
        try{
             String id = studentIDTextField.getText();
             String name = studentNameTextField.getText();
             String email = studentEmailTextField.getText();
             String tel = studentTelTextField.getText();
             
             String courseid = courseidComboBox.getValue();
             if (courseid==null){
              new Alert(Alert.AlertType.ERROR,"Empty combo box").show();
             }
            
             StudentDTO dto = new StudentDTO(id, name, email, tel, courseid);
             
             boolean result =studentBo.saveStudent(dto);
             
             if (result){
                    new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully").show();
                    loadStudentTable();
                    btnReset(event);

             }
        
        }catch(Exception e){
            e.printStackTrace();
             new Alert(Alert.AlertType.ERROR,"somthig went wrong").show();

        }
    }

    @FXML
    private void btnStudentUpdate(ActionEvent event) {
        
          try{
             String id = studentIDTextField.getText();
             String name = studentNameTextField.getText();
             String email = studentEmailTextField.getText();
             String tel = studentTelTextField.getText();
             
             String courseid = courseidComboBox.getValue();
             if (courseid==null){
              new Alert(Alert.AlertType.ERROR,"Empty combo box").show();
             }
            
             StudentDTO dto = new StudentDTO(id, name, email, tel, courseid);
             
             boolean result =studentBo.updateStudent(dto);
             
             if (result){
                    new Alert(Alert.AlertType.CONFIRMATION,"update successfully").show();
                     loadStudentTable();
                     btnReset(event);
             }
        
        }catch(Exception e){
            e.printStackTrace();
             new Alert(Alert.AlertType.ERROR,"somthig went wrong").show();

        }
        
    }

    @FXML
    private void btnStudentDelet(ActionEvent event) {
         System.out.println("subject delete btn clicked");
         try{
         
             String id =studentIDTextField.getText();
             boolean result = studentBo.deleteStudent(id);
         
              if(result){
                         new Alert(Alert.AlertType.CONFIRMATION,"Delete successfully").show();
                          loadStudentTable();
                          btnReset(event);
                        
             }else{
                  new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
             }
             
         }catch(Exception e){
         e.printStackTrace();
          new Alert(Alert.AlertType.ERROR,"Somthing went wrong").show();
         }
        
    }

    @FXML
    private void btnReset(ActionEvent event) {
        
            studentIDTextField.clear();
            studentNameTextField.clear();
             studentEmailTextField.clear();
              studentTelTextField.clear();
              courseidComboBox.getSelectionModel().clearSelection();
        
       
        
    }

 
    
    
    private void loadCourseCombo(){
            try{
            List<CourseDTO> allcourse = courseBo.getAllCourse();
            courseidComboBox.getItems().clear();
            
            for(CourseDTO course: allcourse){
                courseidComboBox.getItems().add(course.getId());
            }
            
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("combo box load error");
                
            }
            }
    
    
    
    
    private void loadStudentTable(){
        
        
         try{
        
        tableStudentID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableStudentEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableStudentTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tableStudentCourseID.setCellValueFactory(new PropertyValueFactory<>("courseid"));
       
        List<StudentDTO> allcourse = studentBo.getAllStudent();
        
        ObservableList<StudentDTO> dtoList = FXCollections.observableArrayList(allcourse);
        StudentsTable.setItems(dtoList);
        
  
    }catch(Exception e){
        e.printStackTrace();
        System.out.println("course table load erro");
    }
  
    }
    
    
    
    
    
    
     private void tableMouseClick(){
        
        // this method use Lamda Expression -> 
        
       StudentsTable.setOnMouseClicked(event ->{
            StudentDTO selectTableline = StudentsTable.getSelectionModel().getSelectedItem();
            
            if(selectTableline != null){
                
                studentIDTextField.setText(selectTableline.getId());
                studentNameTextField.setText(selectTableline.getName());
                studentEmailTextField.setText(selectTableline.getEmail());
                studentTelTextField.setText(selectTableline.getTel());
                courseidComboBox.setValue(selectTableline.getCourseid());
                
                
              
            }
        
        });
        
     }
}
    
    

