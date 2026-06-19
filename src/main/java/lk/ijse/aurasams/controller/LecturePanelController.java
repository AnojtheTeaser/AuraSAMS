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
import lk.ijse.aurasams.bo.custom.LecturerBO;
import lk.ijse.aurasams.bo.custom.StudentBO;
import lk.ijse.aurasams.bo.custom.SubjectBO;
import lk.ijse.aurasams.dto.LecturerDTO;
import lk.ijse.aurasams.dto.SubjectDTO;

/**
 *
 * @author TechWave
 */
public class LecturePanelController implements Initializable  {
    
        SubjectBO subjectBo = (SubjectBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.SUBJECTS);
        LecturerBO lecturerBo = (LecturerBO)BOFactory.getInstance().getBO(BOFactory.BOTypes.LECTURER);
        private ObservableList<LecturerDTO> tempLecturerList = FXCollections.observableArrayList();


   
    
    
    @FXML
    private TextField lecIDTextField;
    @FXML
    private TextField lecNameTextField;
    @FXML
    private TextField lecEmailTextField;
    @FXML
    private TextField lecTelTextField;
    @FXML
    private ComboBox<String> subCombobox;
    @FXML
    private Button lecSaveBtn;
    @FXML
    private Button lecUpdateBtn;
    @FXML
    private Button lecDeleteBtn;
    @FXML
    private Button lecResetBtn;
    @FXML
    private TableView<LecturerDTO> lecturerTable;
    @FXML
    private TableColumn<LecturerDTO, String> lecIDCol;
    @FXML
    private TableColumn<LecturerDTO, String> lecNameCol;
    @FXML
    private TableColumn<LecturerDTO, String> lecEmailCol;
    @FXML
    private TableColumn<LecturerDTO, String> lecTelCol;
    @FXML
    private TableColumn<LecturerDTO, String> lecsubCol;
    @FXML
    private TableView<?> lectureSubtable;
    @FXML
    private TableColumn<?, ?> lectureSubCol;
    @FXML
    private Button lecAddBtn;
    @FXML
    private Button lecResetTablebtn;
    @FXML
    private Button loadTableBtn;

    
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        lecIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        lecNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lecEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        lecTelCol.setCellValueFactory(new PropertyValueFactory<>("tel")); 
        lecsubCol.setCellValueFactory(new PropertyValueFactory<>("tempSubject")); 
        
        lecturerTable.setItems(tempLecturerList);
        
        
        loadSubjectCombobox();
        tableMouseClick();
     
    }
    
    
    
    @FXML
    private void lectureSaveBtn(ActionEvent event) {
        try{
            if (tempLecturerList.isEmpty()){
                   new Alert(Alert.AlertType.ERROR,"Empty values input").show();
                   return;
            }
            
            for(LecturerDTO dto : tempLecturerList){
                    
                if(lecturerBo.saveLecturer(dto)){
                
                    lecturerBo.saveLecturerSubMapping(dto.getId(), dto.getTempSubject());
                    
                } else{
                   
                     new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
                }
        
            
            }
                 new Alert(Alert.AlertType.CONFIRMATION,"save successfully").show();
                tempLecturerList.clear();
                
       
                } catch(Exception e){
                    e.printStackTrace();
                    new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
                    
                }
                
                }


    @FXML
    private void lectureUpdateBtn(ActionEvent event) {
       try {
            String id = lecIDTextField.getText();
            String name = lecNameTextField.getText();
            String email = lecEmailTextField.getText();
            String tel = lecTelTextField.getText();
            String subid = subCombobox.getValue();
            
            if (id.isEmpty()||name.isEmpty()||subid == null){
                 new Alert(Alert.AlertType.ERROR,"emty inputs").show();
                 return;
            }
            
            LecturerDTO dto = new LecturerDTO(id, name, email, tel, subid);
            boolean result = lecturerBo.updateLecturer(dto);
            
            if(result){
                 new Alert(Alert.AlertType.CONFIRMATION,"updatesuccessfully").show();
                 lectureResetBtn(event);
            }else{
                    new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
            }
           
           
       }catch (Exception e){
           e.printStackTrace();
                    new Alert(Alert.AlertType.ERROR,"some thing went wrong").show();
       
       } 
        
    }

    @FXML
    private void lectureDeleteBtn(ActionEvent event) {
    }

    @FXML
    private void lectureResetBtn(ActionEvent event) {
        
         lecIDTextField.clear();
       lecNameTextField.clear();
       lecEmailTextField.clear();
       lecTelTextField.clear();
       subCombobox.getSelectionModel().clearSelection();
       
        
        
    }

    @FXML
    private void lectureAddtoTableBtn(ActionEvent event) {
        System.out.println("successfully added");
        
        try{
            String id = lecIDTextField.getText();
            String name = lecNameTextField.getText();
            String email = lecEmailTextField.getText();
            String tel = lecTelTextField.getText();
            String subid = subCombobox.getValue();
            
            if (id.isEmpty()|| name.isEmpty()|| subid == null){
                              new Alert(Alert.AlertType.ERROR,"Empty values input").show();
                              return;

            }
            
            for (LecturerDTO tabledto : tempLecturerList ){
                    if(tabledto.getId().equals(id) && tabledto.getTempSubject().equals(subid)){
                    
                         new Alert(Alert.AlertType.ERROR,"allredy exsist values").show();
                           return;
                    
                    }
            
            }
            
            LecturerDTO newRow = new LecturerDTO(id, name, email, tel, subid);
            tempLecturerList.add(newRow);
            
           //subCombobox.getSelectionModel().clearSelection();
            
        
        
        }catch(Exception e){
        e.printStackTrace();
        }
        
        
        
        
        
    }

    @FXML
    private void lecturResetTableBtn(ActionEvent event) {
      
        
        
    }

    @FXML
    private void lectureLoadTableBtn(ActionEvent event) {
        
        try{
            lecturerTable.getItems().clear();
            
            List<LecturerDTO> allLecturers = lecturerBo.getAllLecturer();
            
            ObservableList<LecturerDTO> oblist = FXCollections.observableArrayList(allLecturers);
            lecturerTable.setItems(oblist);
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        
        
        
        
        
        
    }

   
    
    private void loadSubjectCombobox(){
        try{
        List<SubjectDTO> allsub = subjectBo.getAllSubject();
        
        subCombobox.getItems().clear();
            for(SubjectDTO subject: allsub){
                
                subCombobox.getItems().add(subject.getId());
            
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        
        }
    
    
    }
          
    private void tableMouseClick(){
        
        // this method use Lamda Expression -> 
        
        lecturerTable.setOnMouseClicked(event ->{
            LecturerDTO selectTableline = lecturerTable.getSelectionModel().getSelectedItem();
            
            if(selectTableline != null){
                
                lecIDTextField.setText(selectTableline.getId());
                lecNameTextField.setText(selectTableline.getName());
                lecEmailTextField.setText(selectTableline.getEmail());
                lecTelTextField.setText(selectTableline.getTel());
                subCombobox.setValue(selectTableline.getTempSubject());
              
            }
        
        });
        
        
    
    }
    

    }
    

