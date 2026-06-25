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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.aurasams.bo.BOFactory;
import lk.ijse.aurasams.bo.custom.AttendanceBO;
import lk.ijse.aurasams.bo.custom.StudentBO;
import lk.ijse.aurasams.dto.AttendanceDTO;
import lk.ijse.aurasams.dto.StudentDTO;

/**
 *
 * @author TechWave
 */
public class AttendancePanelController implements Initializable{
    
    private final StudentBO  studentBo= (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENTS);
    private ObservableList<StudentDTO> studentTableList = FXCollections.observableArrayList(); 
    private ObservableList<AttendanceDTO> attendanceTableList = FXCollections.observableArrayList(); 
    private final AttendanceBO  attendanceBo= (AttendanceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCE);

     

    @FXML
    private TextField courseIDtextField;
    @FXML
    private TextField schedIDTextField;
    @FXML
    private Button okBtn;
    @FXML
    private Button attSaveBtn;
    @FXML
    private Button attUpdateBtn;
    @FXML
    private Button attDeleteBtn;
    @FXML
    private Button attResetBtn;
    @FXML
    private TableView<AttendanceDTO> attendanceTable;
    @FXML
    private TableColumn<AttendanceDTO, String> statusCol;
    @FXML
    private TableView<StudentDTO> stuTable;
    @FXML
    private TableColumn<StudentDTO, String> stuIDColStuTable;
    @FXML
    private TableColumn<StudentDTO, String> stuNameColStuTable;
    @FXML
    private TextField attenStuIDTextField;
    @FXML
    private RadioButton presentRadio;
    @FXML
    private RadioButton absentRadio;
    @FXML
    private RadioButton lateRadio;
    @FXML
    private TableColumn<AttendanceDTO, String> schedidCol;
    @FXML
    private TableColumn<AttendanceDTO, String> stuidCol;
    @FXML
    private ToggleGroup statusToggleGroup;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        LoadstuTable();
        stutableMouseClicked();
        loadAttendTable();
         AttTablemouseClick();
        
    }

    @FXML
    private void OkOnAction(ActionEvent event) {
        try{
            
            String courseId = courseIDtextField.getText();
            String schedId = schedIDTextField.getText();
            
            if (courseId.isEmpty() || schedId.isEmpty()){
              new Alert(Alert.AlertType.ERROR,"empty values input").show();
              return;
            }
            
            studentTableList.clear();
            
            List <StudentDTO> studentList = studentBo.getStudentByCourseID(courseId);
            
            
            if (studentList == null){
                 new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
                 stuTable.refresh();
            }
        
            studentTableList.addAll(studentList);
            stuTable.refresh();
               
        }catch(Exception e){
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
        }
        
        
    }

    @FXML
    private void resetIDOnAction(ActionEvent event) {
        
        schedIDTextField.clear(); 
        attenStuIDTextField.clear(); 
        courseIDtextField.clear();
    }

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        
        try{
            if(attendanceTableList.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"empty values input").show();
            return;
            }
            
            boolean allsaved = true ;
            boolean allcheck =false;
            
           for (AttendanceDTO dto : attendanceTableList){
              System.out.println("Sending to DB -> SchedID: [" + dto.getSchedID() + "], StuID: [" + dto.getStuID() + "], Status: [" + dto.getStatus() + "]");
               boolean issaved = attendanceBo.saveAtt(dto);
               
               if(!issaved){
                   allsaved = false;
                   break;
               }
           
               if (allsaved ){
                //  new Alert(Alert.AlertType.INFORMATION,"Saved successfully").show();
                allcheck =true;
           
               }
            
           }
           if(allcheck){
                    new Alert(Alert.AlertType.INFORMATION,"Saved successfully").show();
                    resetBtnOnAction(event);
                   loadAttendTable();
           }
        
        }catch(Exception e){
        e.printStackTrace();
        }
    }

    @FXML
    private void updateBtnOnAction(ActionEvent event) {
        
        try{
            String schedId = schedIDTextField.getText();
            String stuId = attenStuIDTextField.getText();
            
            if (schedId.isEmpty()|| stuId.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"emty value 1 input").show(); 
            return;
            }
            
            String currentTableStatus = null;
            
            for(AttendanceDTO dto : attendanceTableList){
                 if (dto.getSchedID().equals(schedId) && dto.getStuID().equals(stuId)){
                 currentTableStatus = dto.getStatus();
                 break;
                 }
            }
            
            if(currentTableStatus == null){
             new Alert(Alert.AlertType.ERROR,"no recode found").show();
             return;
            }
            
           boolean rowExsists =false;
           List <AttendanceDTO> allAtendance = attendanceBo.getAllAtt();
           
           for(AttendanceDTO dbDto : allAtendance){
           if(dbDto.getSchedID().equals(schedId) && dbDto.getStuID().equals(stuId));
           rowExsists =true;
           break;
           }
           
           if(!rowExsists){
            new Alert(Alert.AlertType.ERROR,"no valid row found").show();
            return;
           }
            
           AttendanceDTO updateDto =new AttendanceDTO(schedId, stuId, currentTableStatus);
           boolean isUpdated = attendanceBo.updateAtt(updateDto);
           
           if(isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Update Successfully").show();
                resetBtnOnAction(event);
                loadAttendTable();
           }else{
            new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
           }
         
        }catch(Exception e){
        e.printStackTrace();
         new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
        }
        
          
    }

    @FXML
    private void resetBtnOnAction(ActionEvent event) {
        attendanceTableList.clear();
        attendanceTable.refresh(); 
        
   
         }
    


  private void LoadstuTable(){
  
     stuIDColStuTable.setCellValueFactory(new PropertyValueFactory<>("id"));
      stuNameColStuTable.setCellValueFactory(new PropertyValueFactory<>("name")); 
        stuTable.setItems(studentTableList); 
  
  
  }
    
  private void stutableMouseClicked(){
      
       stuTable.setOnMouseClicked(event ->{
            StudentDTO selectTableline = stuTable.getSelectionModel().getSelectedItem();
            
            if(selectTableline != null){
                
       
            attenStuIDTextField.setText(selectTableline.getId());
       
            }
        
        });

  }

    @FXML
    private void statusRadioBtnOnAction(ActionEvent event) {
        
        try{
                String schedId = schedIDTextField.getText();
                String stuId = attenStuIDTextField.getText();
                
                
                if(schedId.isEmpty() || stuId.isEmpty()){
                new Alert(Alert.AlertType.ERROR,"empty values input").show();
                statusToggleGroup.getSelectedToggle().setSelected(false);
                
                return;
              
                }
                     String statusValue ="";
                     Object statusofRadio = event.getSource();
                
        if(statusofRadio == presentRadio ){
             statusValue = "PRESENT";
             
        } else if(statusofRadio == absentRadio ) {
            statusValue = "ABSENT";
        
        }else if (statusofRadio == lateRadio){
            statusValue = "LATE";
        }
        
        boolean isAllreadyadded = false;
        for(AttendanceDTO dto : attendanceTableList){
            if(dto.getStuID().equals(stuId)){
                isAllreadyadded = true;
            break;
            }
        }
        
        if (!isAllreadyadded){
        AttendanceDTO attendanceLine = new AttendanceDTO(null, schedId, stuId, statusValue);
        attendanceTableList.add(attendanceLine);
        
        }
        attendanceTable.refresh();
        //attenStuIDTextField.clear();
        
        if (statusToggleGroup.getSelectedToggle() != null){
                statusToggleGroup.getSelectedToggle().setSelected(false);
        }
        
        
        
        }catch(Exception e ){
        e.printStackTrace();
        
        }
        
    }
  
  private void loadAttendTable(){
  
      schedidCol.setCellValueFactory(new PropertyValueFactory<>("schedID")); 
    stuidCol.setCellValueFactory(new PropertyValueFactory<>("stuID")); 
    statusCol.setCellValueFactory(new PropertyValueFactory<>("status")); 
    attendanceTable.setItems(attendanceTableList);
      
      
  }
  
  
  private void AttTablemouseClick(){
  
      
    attendanceTable.setOnMouseClicked(event -> {
        AttendanceDTO selectedAttendance = attendanceTable.getSelectionModel().getSelectedItem();
        
        if (selectedAttendance != null) {
          
            schedIDTextField.setText(selectedAttendance.getSchedID());
            attenStuIDTextField.setText(selectedAttendance.getStuID());
            
          
            String status = selectedAttendance.getStatus();
            if (status.equals("PRESENT")) {
                presentRadio.setSelected(true);
            } else if (status.equals("ABSENT")) {
                absentRadio.setSelected(true);
            } else if (status.equals("LATE")) {
                lateRadio.setSelected(true);
            }
        }
    });
}

    @FXML
    private void loadTableOnAction(ActionEvent event) {
        try{
        attendanceTableList.clear();
        List<AttendanceDTO> allattendance = attendanceBo.getAllAtt();
        if(allattendance != null){
            attendanceTableList.addAll(allattendance);
            
        }
        attendanceTable.setItems(attendanceTableList);
        attendanceTable.refresh();
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
        
        
        
        
    }

    @FXML
    private void deleteBtnOnAction(ActionEvent event) {
        
          try {

            AttendanceDTO selected = attendanceTable.getSelectionModel().getSelectedItem();

            if (selected == null) {
                new Alert(Alert.AlertType.ERROR, "Please select a row from table!").show();
                return;
            }

            System.out.println("Trying to Delete -> SchedID: [" + selected.getSchedID() + "], StuID: [" + selected.getStuID() + "]");

         
            boolean isDeleted = attendanceBo.deleteAtt(selected.getSchedID(), selected.getStuID());

            if (isDeleted) {
                attendanceTableList.remove(selected);
                attendanceTable.refresh();          
                new Alert(Alert.AlertType.INFORMATION, "Deleted Successfully! 🎉").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Delete Failed! No record found in DB.").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
         
            new Alert(Alert.AlertType.ERROR, "Exception Occurred: " + e.toString()).show();
        }
        
        
    }

    @FXML
    private void clrearTextfieldOnAction(ActionEvent event) {
        schedIDTextField.clear(); 
        attenStuIDTextField.clear(); 
        courseIDtextField.clear();
        studentTableList.clear();
            if (statusToggleGroup.getSelectedToggle() != null) { 
                statusToggleGroup.getSelectedToggle().setSelected(false); }
    }
  
  }

