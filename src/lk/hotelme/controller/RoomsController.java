/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import lk.hotelme.dto.RoomDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
public class RoomsController implements Initializable {

    @FXML
    private Pane paneRooms;
    @FXML
    private Label lblRoomManagement;
    @FXML
    private JFXTextField txtRoomID;
    @FXML
    private JFXTextField txtRoomNO;
    @FXML
    private JFXTextField txtRoomFloor;
    @FXML
    private JFXComboBox<String> cmbRoomTypeName;
    @FXML
    private JFXComboBox<String> cmbPackageName;
    @FXML
    private JFXButton btnAddRoom;
    @FXML
    private TextField txtSearchbyID;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private TableView<RoomDTO> tblRooms;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnReload;
    @FXML
    private JFXButton btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblRooms.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblRooms.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblRooms.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblRooms.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblRooms.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        //-------------------------------------------------// TODO
        tblRooms.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Room_ID"));
        tblRooms.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Room_No"));
        tblRooms.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Type_ID"));
        tblRooms.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Package_ID"));
        tblRooms.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Room_Floor"));
        try {
            ArrayList<RoomDTO> loadallRooms = RoomsMethodController.loadallRooms();
            tblRooms.setItems(FXCollections.observableArrayList(loadallRooms));
            ObservableList<String> packageName = RoomsMethodController.getPackageName();
            cmbPackageName.setItems(packageName);
            ObservableList<String> roomType = RoomsMethodController.getRoomType();
            cmbRoomTypeName.setItems(roomType);
// TODO
        } catch (Exception ex) {
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAddRoomActionPerformed(ActionEvent event) {
        try {
            String packageID = RoomsMethodController.getPackageID(cmbPackageName.getSelectionModel().getSelectedItem());
            String typeID = RoomsMethodController.gettypeID(cmbRoomTypeName.getSelectionModel().getSelectedItem());
            boolean addRoom = RoomsMethodController.addRoom(new RoomDTO(txtRoomID.getText(), typeID, txtRoomNO.getText(), packageID, txtRoomFloor.getText()));
            if (addRoom) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Room Added Successfully");
                alert.setContentText("Room added Keep going!");
                alert.setResizable(false);
                alert.showAndWait();
                ArrayList<RoomDTO> loadallRooms = RoomsMethodController.loadallRooms();
                tblRooms.setItems(FXCollections.observableArrayList(loadallRooms));
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearchActionPerformed(ActionEvent event) {
        try {
            RoomDTO searchRoom = RoomsMethodController.searchRoom(txtSearchbyID.getText());
            txtRoomID.setText(searchRoom.getRoom_ID());
            txtRoomNO.setText(searchRoom.getRoom_No());
            txtRoomFloor.setText(searchRoom.getRoom_Floor());
            cmbRoomTypeName.getSelectionModel().select(searchRoom.getType_ID());
            cmbPackageName.getSelectionModel().select(searchRoom.getPackage_ID());
        } catch (Exception ex) {
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tblRoomsMouseClicked(MouseEvent event) {
        RoomDTO selectedItem = tblRooms.getSelectionModel().getSelectedItem();
        txtRoomFloor.setText(selectedItem.getRoom_Floor());
        txtRoomID.setText(selectedItem.getRoom_ID());
        txtRoomNO.setText(selectedItem.getRoom_No());
        cmbPackageName.getSelectionModel().select(selectedItem.getPackage_ID());
        cmbRoomTypeName.getSelectionModel().select(selectedItem.getType_ID());
    }

    @FXML
    private void btnDeleteActionPerformed(ActionEvent event) throws Exception {
        RoomDTO selectedItem = tblRooms.getSelectionModel().getSelectedItem();
        boolean deleteRoom = RoomsMethodController.deleteRoom(selectedItem.getRoom_ID());
        if (deleteRoom) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Room DELETED Successfully");
            alert.setContentText("Room deleted Keep going!");
            alert.setResizable(false);
            alert.showAndWait();
            ArrayList<RoomDTO> loadallRooms = RoomsMethodController.loadallRooms();
            tblRooms.setItems(FXCollections.observableArrayList(loadallRooms));
        }
    }

    @FXML
    private void btnReloadActionPerformed(ActionEvent event) throws Exception {
        ArrayList<RoomDTO> loadallRooms = RoomsMethodController.loadallRooms();
        tblRooms.setItems(FXCollections.observableArrayList(loadallRooms));
    }

    @FXML
    private void btnUpdateActionPerformed(ActionEvent event) {
        try {
            String packageID = RoomsMethodController.getPackageID(cmbPackageName.getSelectionModel().getSelectedItem());
            String typeID = RoomsMethodController.gettypeID(cmbRoomTypeName.getSelectionModel().getSelectedItem());
            boolean updateRoom = RoomsMethodController.updateRoom(new RoomDTO(txtRoomID.getText(), typeID, txtRoomNO.getText(), packageID, txtRoomFloor.getText()));
            if (updateRoom) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Room UPDADED Successfully");
                alert.setContentText("Room updaded Keep going!");
                alert.setResizable(false);
                alert.showAndWait();
                ArrayList<RoomDTO> loadallRooms = RoomsMethodController.loadallRooms();
                tblRooms.setItems(FXCollections.observableArrayList(loadallRooms));
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
