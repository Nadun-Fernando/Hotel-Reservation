/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import lk.hotelme.dto.ReservationDTO;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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
public class ManageReservationsController implements Initializable {

    @FXML
    private AnchorPane manageReservationsPane;
    @FXML
    private TableView<ReservationDTO> tblManageReservations;
    @FXML
    private JFXDatePicker arrivaldate;
    @FXML
    private JFXDatePicker departuredate;
    @FXML
    private Label lblReservationID;
    @FXML
    private JFXButton btnDelete;
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
        tblManageReservations.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(5).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(6).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(7).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(8).setStyle("-fx-alignment: CENTER;");
        tblManageReservations.getColumns().get(9).setStyle("-fx-alignment: CENTER;");
        //-------------------------------------------------// TODO
        tblManageReservations.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Reservation__ID"));
        tblManageReservations.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
        tblManageReservations.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("No_of_Guests"));
        tblManageReservations.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Arrival_Date"));
        tblManageReservations.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Departure_Date"));   
        tblManageReservations.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Package_ID"));
        tblManageReservations.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("Meal_ID"));
        tblManageReservations.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("Room_ID"));
        tblManageReservations.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("Receptionist_ID"));
        tblManageReservations.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("Payment_ID"));
        
        try {
            ArrayList<ReservationDTO> loadallReservation = ReservationMethodController.loadallReservation();
            tblManageReservations.setItems(FXCollections.observableArrayList(loadallReservation));
        } catch (Exception ex) {
            Logger.getLogger(ManageReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    

    @FXML
    private void tblanageReservationMouseClicked(MouseEvent event) {
        ReservationDTO selectedItem = tblManageReservations.getSelectionModel().getSelectedItem();
        lblReservationID.setText(selectedItem.getReservation__ID());
        arrivaldate.setValue(LocalDate.parse(selectedItem.getArrival_Date()));
        departuredate.setValue(LocalDate.parse(selectedItem.getDeparture_Date()));
    }

    @FXML
    private void btnDeleteActionPerformed(ActionEvent event) {
        try {
            ReservationDTO selectedItem = tblManageReservations.getSelectionModel().getSelectedItem();
            boolean deleteReservation = ReservationMethodController.deleteReservation(selectedItem.getReservation__ID());
            if(deleteReservation){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Reservation deleted SuccsessFully");
                alert.setContentText("Reservation Deleted Keep Going");
                alert.showAndWait();
                ArrayList<ReservationDTO> loadallReservation = ReservationMethodController.loadallReservation();
                tblManageReservations.setItems(FXCollections.observableArrayList(loadallReservation));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateActionPerformed(ActionEvent event) {
        try {
            ReservationDTO reservationDTO = new ReservationDTO(lblReservationID.getText(), arrivaldate.getValue().format(DateTimeFormatter.ISO_DATE), departuredate.getValue().format(DateTimeFormatter.ISO_DATE));
            boolean updateReservation = ReservationMethodController.updateReservation(reservationDTO);
            if(updateReservation){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Done Keep Going");
                alert.setContentText("Reservation Updated Successfully");
                alert.showAndWait();
                ArrayList<ReservationDTO> loadallReservation = ReservationMethodController.loadallReservation();
                tblManageReservations.setItems(FXCollections.observableArrayList(loadallReservation));
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearchActionPerformed(ActionEvent event){
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            ReservationDTO searchReservation = ReservationMethodController.searchReservation(txtSearchbyID.getText());
            lblReservationID.setText(searchReservation.getReservation__ID());
            arrivaldate.setValue(LocalDate.parse(searchReservation.getArrival_Date()));
            departuredate.setValue(LocalDate.parse(searchReservation.getDeparture_Date()));
        } catch (Exception ex) {
            Logger.getLogger(ManageReservationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
