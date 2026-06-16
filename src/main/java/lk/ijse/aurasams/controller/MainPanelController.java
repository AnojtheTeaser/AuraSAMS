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
        System.out.println("course");
    }

    @FXML
    private void btnSubjectManageOnAction(ActionEvent event) {
    }

    @FXML
    private void btnStudentManageOnAction(ActionEvent event) {
    }

    @FXML
    private void btnLecturerManageOnAction(ActionEvent event) {
    }

    @FXML
    private void btnClassSchedManageOnAction(ActionEvent event) {
    }

    @FXML
    private void btnAttendanceManageOnAction(ActionEvent event) {
    }

    @FXML
    private void btnReportManageOnAction(ActionEvent event) {
    }
    
    
    
    
    
    
}
