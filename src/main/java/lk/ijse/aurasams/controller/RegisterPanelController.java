/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.aurasams.db.DBConnection;

/**
 *
 * @author TechWave
 */
public class RegisterPanelController {

    @FXML
    private TextField createUsername;
    @FXML
    private TextField createPassword;

    @FXML
    private void createBtnOnAction(ActionEvent event) {
        
        //  concept is mine and use AI Support to do some developments
        
         try {
            String username = createUsername.getText();
            String password = createPassword.getText();


            if (username.isEmpty() || password.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Please enter  Username and Password!").show();
                return;
            }


            if (!username.toUpperCase().startsWith("ADM") && !username.toUpperCase().startsWith("LEC")) {
                new Alert(Alert.AlertType.ERROR, "Username must start with 'ADM' (Admin) or 'LEC' (Lecturer)!").show();
                return;
            }


            Connection conn = DBConnection.getInstance().getconnection();
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);

            int result = pstm.executeUpdate();
            if (result > 0) {
                new Alert(Alert.AlertType.INFORMATION, "User Account Created Successfully!").show();
                

                createUsername.clear();
                createPassword.clear();
            }

        } catch  (SQLIntegrityConstraintViolationException e) {

            new Alert(Alert.AlertType.ERROR, "This Username already exists! Please try another name.").show();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Something went wrong while creating the account!").show();
        }
        
        
        
    }
    
}
