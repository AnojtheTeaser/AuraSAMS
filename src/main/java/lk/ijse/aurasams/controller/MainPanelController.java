/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;


public class MainPanelController implements Initializable{

    @FXML
    private AnchorPane contentArea;
    @FXML
    private Button courseM;
    @FXML
    private Button subjectM;
    @FXML
    private Button studentM;
    @FXML
    private Button lecturerM;
    @FXML
    private Button classschedM;
    @FXML
    private Button attendanceM;
    @FXML
    private Button reportM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //nothing
    }

    @FXML
    private void btnCourseManageOnAction(ActionEvent event) {
        System.out.println("course manage");
        setPanel("/lk/ijse/aurasams/CoursePanel.fxml");
    }

    @FXML
    private void btnSubjectManageOnAction(ActionEvent event) {
        System.out.println("SubjectManage");
        setPanel("/lk/ijse/aurasams/SubjectPanel.fxml");
    }

    @FXML
    private void btnStudentManageOnAction(ActionEvent event) {
        System.out.println("StudentManage");
        setPanel("/lk/ijse/aurasams/StudentPanel.fxml");
    }

    @FXML
    private void btnLecturerManageOnAction(ActionEvent event) {
        System.out.println("LecturerManage");
        setPanel("/lk/ijse/aurasams/LecturePanel.fxml");
    }

    @FXML
    private void btnClassSchedManageOnAction(ActionEvent event) {
        System.out.println("ClassSchedManage");
        setPanel("/lk/ijse/aurasams/ClassSchedulePanel.fxml");
    }

    @FXML
    private void btnAttendanceManageOnAction(ActionEvent event) {
        System.out.println("AttendanceManage");
        setPanel("/lk/ijse/aurasams/AttendancePanel.fxml");
    }

    @FXML
    private void btnReportManageOnAction(ActionEvent event) {
        System.out.println("ReportManage");
        setPanel("/lk/ijse/aurasams/ReportsPanel.fxml");
    }
    
     public void setPanel(String path){
    
        try{
            
            contentArea.getChildren().clear();
            
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource(path));
            
            anchorPane.prefWidthProperty().bind(contentArea.widthProperty());
            anchorPane.prefHeightProperty().bind(contentArea.heightProperty());

            contentArea.getChildren().add(anchorPane);
            
            
            
        
        }catch(Exception e){
          
          new Alert(Alert.AlertType.ERROR, "page not found").show();
          e.printStackTrace();
        }
    
    }

    
    
    
    
}
