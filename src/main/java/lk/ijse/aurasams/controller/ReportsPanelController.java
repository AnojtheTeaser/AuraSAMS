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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.aurasams.bo.BOFactory;
import lk.ijse.aurasams.bo.custom.CourseBO;
import lk.ijse.aurasams.bo.custom.ReportsBO;
import lk.ijse.aurasams.bo.custom.StudentBO;
import lk.ijse.aurasams.bo.custom.SubjectBO;
import lk.ijse.aurasams.dto.CourseDTO;
import lk.ijse.aurasams.dto.ReportDTO;
import lk.ijse.aurasams.dto.StudentDTO;
import lk.ijse.aurasams.dto.SubjectDTO;

/**
 *
 * @author TechWave
 */
public class ReportsPanelController implements Initializable{
    
    
private final ReportsBO reportsBO = (ReportsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REPORTS);
private final ObservableList<ReportDTO> reportTableList = FXCollections.observableArrayList();


private final CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);
private final StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENTS);
private final SubjectBO subjectBO = (SubjectBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUBJECTS);
    

    @FXML
    private ComboBox<String> studentViaCourseID;
    @FXML
    private ComboBox<String> studentViaStudentID;
    @FXML
    private Button stuViseReportGenarateBtn;
    @FXML
    private ComboBox<String> subjectViaCourseID;
    @FXML
    private ComboBox<String> subjectViaSubjectID;
    @FXML
    private Button subViseReportGenarateBtn;
    @FXML
    private ComboBox<String> dateViaCourseID;
    @FXML
    private ComboBox<String> dateViaStudentID;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private Button dateViseReportGenarateBtn;
    @FXML
    private TableView<ReportDTO> ReportTable;
    @FXML
    private TableColumn<ReportDTO, String> stuIDCol;
    @FXML
    private TableColumn<ReportDTO, String> stuNameCol;
    @FXML
    private TableColumn<ReportDTO, String> courseNameCol;
    @FXML
    private TableColumn<ReportDTO, String> SubjectCol;
    @FXML
    private TableColumn<ReportDTO, String> dateCol;
    @FXML
    private TableColumn<ReportDTO, String> statusCol;
    @FXML
    private Button tableResetBtn;
    @FXML
    private Button print;
    @FXML
    private Button stuViseResetBtn;
    @FXML
    private Button subViseResetBtn;
    @FXML
    private Button dateViseResetBtn;

    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
      
   
    stuIDCol.setCellValueFactory(new PropertyValueFactory<>("stuID"));
    stuNameCol.setCellValueFactory(new PropertyValueFactory<>("stuName"));
    courseNameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
    SubjectCol.setCellValueFactory(new PropertyValueFactory<>("subjectName")); 
    dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

 
    ReportTable.setItems(reportTableList);
    
    loadAllCourseID();
//    loadAllStudentsID();
//    loadAllSubjectID();

        
        
    }
    
    
    
    @FXML
    private void stuViseReportGenarateBtnONAction(ActionEvent event) {
        
            try {
    
        if (studentViaCourseID.getValue() == null || studentViaStudentID.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "empty value input").show();
            return;
        }

      
        String courseId = studentViaCourseID.getValue().toString();
        String stuId = studentViaStudentID.getValue().toString();

      
        reportTableList.clear();

        
        List<ReportDTO> resultList = reportsBO.getAttendanceByStudent(courseId, stuId);

        if (resultList == null || resultList.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "No records found").show();
            ReportTable.setItems(reportTableList); 
            return;
        }

        
        reportTableList.addAll(resultList);
        ReportTable.setItems((ObservableList) reportTableList);
        ReportTable.refresh();

    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Something went wrong ").show();
    }
    }

    @FXML
    private void subViseReportGenarateBtnOnAction(ActionEvent event) {
        
        

    String selectedCourseID = (String) subjectViaCourseID.getValue();
    String selectedSubID = (String) subjectViaSubjectID.getValue();

    if (selectedCourseID == null || selectedSubID == null) {
        new Alert(Alert.AlertType.WARNING, "empty value input").show();
        return;
    }

    try {

        reportTableList.clear();


        List<ReportDTO> dtoList = reportsBO.getAttendanceBySubject(selectedCourseID, selectedSubID);

        if (dtoList.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "No  records found!").show();
            return;
        }

        for (ReportDTO dto : dtoList) {
           
               String id = dto.getStuID();
                String name= dto.getStuName();
                String courseName =dto.getCourseName();
                String SubName= dto.getSubjectName();
                String date = dto.getDate();
                String status = dto.getStatus();
           
            
            ReportDTO dtos =new ReportDTO(id, name, courseName, SubName, date, status);
            reportTableList.add(dtos);
        }
        

        ReportTable.setItems(reportTableList);

    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Something went wrong while generating the report!").show();
    }
}
        
        
    

    @FXML
    private void dateViseReportGenarateBtnOnAction(ActionEvent event) {
        

    
    if (fromDate.getValue() == null || toDate.getValue() == null) {
        new Alert(Alert.AlertType.WARNING, "Empty value input").show();
        return;
    }

  
    String FromDate = fromDate.getValue().toString();
    String ToDate = toDate.getValue().toString();
    String SelectStuId =  dateViaStudentID.getValue().toString();

    try {
      
        reportTableList.clear();

        

        List<ReportDTO> dtoList = reportsBO.getAttendanceByDateRange(null, SelectStuId, FromDate, ToDate);

        if (dtoList.isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "No  records found ").show();
            ReportTable.setItems(reportTableList);
            return;
        }


        reportTableList.addAll(dtoList);
        ReportTable.setItems(reportTableList);
        ReportTable.refresh();

    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Something went wrong ").show();
    }
}
        
        
        
        
    

    @FXML
    private void tableResetBtnOnAction(ActionEvent event) {
        
        ReportTable.getItems().clear();

         ReportTable.setItems(reportTableList);
    }

    @FXML
    private void printOnAction(ActionEvent event) {
    }

   
      @FXML
    private void studentViaCourseIDOnAction(ActionEvent event) {
        
        String selectedId =(String) studentViaCourseID.getValue();
        try{
            studentViaStudentID.getItems().clear();
            
            List<StudentDTO> studentList = studentBO.getStudentByCourseID(selectedId);
            
            ObservableList<String> idList = FXCollections.observableArrayList();
            
            for(StudentDTO dto : studentList){
                
                idList.add(dto.getId());
           
            }
            studentViaStudentID.setItems(idList);
            
        }catch(Exception e){
        e.printStackTrace();
        }
        
    }
    
    
    
    
      @FXML
    private void subjectViaCourseIDOnAction(ActionEvent event) {
        
        
           String selectedCourseID = (String) subjectViaCourseID.getValue();
    
    if (selectedCourseID != null) {
        try {
        
            subjectViaSubjectID.getItems().clear();
            
       
            List<SubjectDTO> subjectList = subjectBO.getSubjectByCourseID(selectedCourseID);
            
            if (subjectList == null || subjectList.isEmpty()) {
                new Alert(Alert.AlertType.INFORMATION, "No recodes found ").show();
                return;
            }
            
        
            ObservableList<String> subIdList = FXCollections.observableArrayList();
            for (SubjectDTO dto : subjectList) {
                subIdList.add(dto.getId()); 
            }
            
         
            subjectViaSubjectID.setItems(subIdList);
            
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong ").show();
        }
    }
        
    }

    
    
    
    
    private void loadAllCourseID(){
        try{
         List <CourseDTO> allcourse = courseBO.getAllCourse();
         ObservableList<String> courseIDList = FXCollections.observableArrayList();
         
         for (CourseDTO dto : allcourse){
         
             courseIDList.add(dto.getId());
         
         }
         
         studentViaCourseID.setItems(courseIDList);
         subjectViaCourseID.setItems(courseIDList);
         dateViaCourseID.setItems(courseIDList);
        } catch(Exception e){
        e.printStackTrace();
        }
    
    }
    
    

    @FXML
    private void stuViseResetBtnOnAction(ActionEvent event) {
        
        studentViaCourseID.getSelectionModel().clearSelection();
        studentViaCourseID.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void subViseResetBtnOnAction(ActionEvent event) {
        subjectViaCourseID.getSelectionModel().clearSelection();
        subjectViaSubjectID.getSelectionModel().clearSelection();
        
        
    }

    @FXML
    private void dateViseResetBtnOnAction(ActionEvent event) {
        dateViaCourseID.getSelectionModel().clearSelection();
        dateViaStudentID.getSelectionModel().clearSelection();
        fromDate.setValue(null);
        toDate.setValue(null);
        
    }

    @FXML
    private void dateViaCourseIDOnAction(ActionEvent event) {
        
        
            String selectedCourseID = (String) dateViaCourseID.getValue();
    
    if (selectedCourseID != null) {
        try {
        
            dateViaStudentID.getItems().clear();
            
       
            List<StudentDTO> stuListDto = studentBO.getStudentByCourseID(selectedCourseID);
            
            if (stuListDto == null || stuListDto.isEmpty()) {
                new Alert(Alert.AlertType.INFORMATION, "No recodes found ").show();
                return;
            }
            
        
            ObservableList<String> stuList = FXCollections.observableArrayList();
            for (StudentDTO dto : stuListDto) {
                stuList.add(dto.getId()); 
            }
            
         
           dateViaStudentID.setItems(stuList);
            
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong ").show();
        }
    }
        
    }

  
  
    
}
