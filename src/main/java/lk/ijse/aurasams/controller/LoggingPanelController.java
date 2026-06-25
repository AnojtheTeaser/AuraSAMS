/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.aurasams.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.aurasams.db.DBConnection;

/**
 *
 * @author TechWave
 */
public class LoggingPanelController implements Initializable{
    
    // use Ai support

    @FXML
    private TextField userNAmeTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button logginbtn;

    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    
    
    
    
    
    
    @FXML
    private void LoggingbtnOnAction(ActionEvent event) {
        
           try {
        String username = userNAmeTextField.getText().trim();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields!").show();
            return;
        }

        
        Connection conn = DBConnection.getInstance().getconnection();
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);

        ResultSet result = pstm.executeQuery();

        if (result.next()) {
         
            UserSession.createSession(username);

            new Alert(Alert.AlertType.INFORMATION, "Login Successful!").show();

          
            Parent mainView = FXMLLoader.load(getClass().getResource("/lk/ijse/aurasams/MainPanel.fxml"));
            Stage stage = (Stage) userNAmeTextField.getScene().getWindow();
            stage.setScene(new Scene(mainView));
            stage.centerOnScreen();
            stage.show();

        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid Username or Password!").show();
        }

    } catch (Exception e) {
        e.printStackTrace();
        new Alert(Alert.AlertType.ERROR, "Something went wrong during login!").show();
    }
        
    }

   
}
