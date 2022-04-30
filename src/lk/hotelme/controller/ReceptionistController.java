/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.hotelme.dto.ReceptionistDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class ReceptionistController implements Initializable {

    @FXML
    private Pane ReceptionistPane;
    @FXML
    private JFXTextField txtReceptionistID;
    @FXML
    private JFXTextField txtReceptionistName;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private TableView<ReceptionistDTO> tblUsers;
    @FXML
    private JFXButton btnAddUser;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnReload;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private TextField txtSearchbyID;
    @FXML
    private JFXButton btnSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblUsers.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblUsers.getColumns().get(3).setStyle("-fx-alignment: CENTER;");

        //-------------------------------------------------// TODO
        tblUsers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Receptionist_ID"));
        tblUsers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Receptionist_Name"));
        tblUsers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Username"));
        tblUsers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Password"));

        try {
            ArrayList<ReceptionistDTO> loadallUsers = ReceptionistMethodController.loadallUsers();
            tblUsers.setItems(FXCollections.observableArrayList(loadallUsers));
        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void lblUserMouseClicked(MouseEvent event) {
        ReceptionistDTO selectedItem = tblUsers.getSelectionModel().getSelectedItem();
        txtPassword.setText(selectedItem.getPassword());
        txtReceptionistID.setText(selectedItem.getReceptionist_ID());
        txtReceptionistName.setText(selectedItem.getReceptionist_Name());
        txtUserName.setText(selectedItem.getUsername());
    }

    @FXML
    private void btnAddUserActionPerformed(ActionEvent event) {
        try {
            boolean addUser = ReceptionistMethodController.addUser(new ReceptionistDTO(txtReceptionistID.getText(), txtReceptionistName.getText(), txtUserName.getText(), txtPassword.getText()));
            ArrayList<ReceptionistDTO> loadallUsers = ReceptionistMethodController.loadallUsers();
            tblUsers.setItems(FXCollections.observableArrayList(loadallUsers));
            if (addUser) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("User Added Succesfully");
                alert.setContentText("User Added, Access Granted from Login");
                alert.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnDeleteActionPerformed(ActionEvent event) throws Exception {
       
            ReceptionistDTO selectedItem = tblUsers.getSelectionModel().getSelectedItem();
            boolean deleteUser = ReceptionistMethodController.deleteUser(selectedItem.getReceptionist_ID());
            ArrayList<ReceptionistDTO> loadallUsers = ReceptionistMethodController.loadallUsers();
            tblUsers.setItems(FXCollections.observableArrayList(loadallUsers));
            if (deleteUser) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("User DELETED Succesfully");
                alert.setContentText("User Deleted, Log in access Restricted");
                alert.show();
            }
       
    }

    @FXML
    private void btnReloadActionPerformed(ActionEvent event) {
        try {
            ArrayList<ReceptionistDTO> loadallUsers = ReceptionistMethodController.loadallUsers();
            tblUsers.setItems(FXCollections.observableArrayList(loadallUsers));
        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateActionPerformed(ActionEvent event) {
        try {
            ReceptionistMethodController.updateUser(new ReceptionistDTO(txtReceptionistID.getText(), txtReceptionistName.getText(), txtUserName.getText(), txtPassword.getText()));
            ArrayList<ReceptionistDTO> loadallUsers = ReceptionistMethodController.loadallUsers();
            tblUsers.setItems(FXCollections.observableArrayList(loadallUsers));
        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearchActionPerformed(ActionEvent event) {
        try {
            ReceptionistDTO search = ReceptionistMethodController.search(txtSearchbyID.getText());
            txtReceptionistID.setText(search.getReceptionist_ID());
            txtReceptionistName.setText(search.getReceptionist_Name());
            txtUserName.setText(search.getUsername());
            txtPassword.setText(search.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
