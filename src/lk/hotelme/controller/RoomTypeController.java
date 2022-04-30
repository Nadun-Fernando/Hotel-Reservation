/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import lk.hotelme.dto.Room_TypeDTO;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class RoomTypeController implements Initializable {

    @FXML
    private JFXTextField txtRoomTypeID;
    @FXML
    private JFXTextField txtRoomTypeName;
    private JFXTextField txtRoomPrice;
    @FXML
    private JFXTextField txtMaxGuests;
    @FXML
    private JFXButton btnAddRoom;
    @FXML
    private TableView<Room_TypeDTO> tblRoomTypeManagement;
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
    @FXML
    private AnchorPane RoomTypePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblRoomTypeManagement.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblRoomTypeManagement.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblRoomTypeManagement.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        
        
        //-------------------------------------------------// TODO
        tblRoomTypeManagement.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Room_Type_ID"));
        tblRoomTypeManagement.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Room_Type_Name"));
        tblRoomTypeManagement.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Max_Guests"));
        
        try {
            ArrayList<Room_TypeDTO> loadtypes = RoomTypeMethodController.loadtypes();
            tblRoomTypeManagement.setItems(FXCollections.observableArrayList(loadtypes));
            // TODO
        } catch (Exception ex) {
            Logger.getLogger(RoomTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnAddRoomActionPerformed(ActionEvent event) {
        try {
            int max_guests=Integer.parseInt(txtMaxGuests.getText());
            boolean addtype = RoomTypeMethodController.addtype(new Room_TypeDTO(txtRoomTypeID.getText(), txtRoomTypeName.getText(), max_guests));
            if(addtype){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Done Room Type Added Successfully");
                alert.setContentText("Keep Going");
                alert.showAndWait();
                ArrayList<Room_TypeDTO> loadtypes = RoomTypeMethodController.loadtypes();
                tblRoomTypeManagement.setItems(FXCollections.observableArrayList(loadtypes));
            }
//        }catch (MySQLIntegrityConstraintViolationException e){
//            Alert a = new Alert(Alert.AlertType.ERROR);
//            a.setHeaderText("You Cannot Duplicate the ID");
//            a.setContentText(e.getMessage());
//            a.show();
//        
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("You Cannot Duplicate the ID");
            a.setContentText(ex.getMessage());
            a.show();
        }
            
              
    }

    @FXML
    private void btnDeleteActionPerformed(ActionEvent event) {
        try {
            Room_TypeDTO selectedItem = tblRoomTypeManagement.getSelectionModel().getSelectedItem();
            RoomTypeMethodController.deletetype(selectedItem.getRoom_Type_ID());
            ArrayList<Room_TypeDTO> loadtypes = RoomTypeMethodController.loadtypes();
            tblRoomTypeManagement.setItems(FXCollections.observableArrayList(loadtypes));
        } catch (Exception ex) {
            Logger.getLogger(RoomTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnReloadActionPerformed(ActionEvent event) {
        try {
            ArrayList<Room_TypeDTO> loadtypes = RoomTypeMethodController.loadtypes();
            tblRoomTypeManagement.setItems(FXCollections.observableArrayList(loadtypes));
        } catch (Exception ex) {
            Logger.getLogger(RoomTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateActionPerformed(ActionEvent event) {
        int guest=Integer.parseInt(txtMaxGuests.getText());
        try {
            boolean updatetype = RoomTypeMethodController.updatetype(new Room_TypeDTO(txtRoomTypeID.getText(), txtRoomTypeName.getText(), guest));
            if(updatetype){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("RoomType UPDATED!");
                alert.setContentText("RoomType Successfully UPDATED");
                alert.show();
                
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearchActionPerformed(ActionEvent event) {
        try {
            Room_TypeDTO searchtype = RoomTypeMethodController.searchtype(txtSearchbyID.getText());
            txtRoomTypeID.setText(searchtype.getRoom_Type_ID());
            txtRoomTypeName.setText(searchtype.getRoom_Type_Name());
            txtMaxGuests.setText(searchtype.getMax_Guests()+"");
        } catch (Exception ex) {
            Logger.getLogger(RoomTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tblRoomTypeMouseClicked(MouseEvent event) {
        Room_TypeDTO selectedItem = tblRoomTypeManagement.getSelectionModel().getSelectedItem();
        txtRoomTypeID.setText(selectedItem.getRoom_Type_ID());
        txtMaxGuests.setText(selectedItem.getMax_Guests()+"");
        txtRoomTypeName.setText(selectedItem.getRoom_Type_Name());
    }
    
}
