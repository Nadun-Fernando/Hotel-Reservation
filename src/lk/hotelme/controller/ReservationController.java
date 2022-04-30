/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import lk.hotelme.dto.CustomerDTO;
import lk.hotelme.entity.CustomEntity;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class ReservationController implements Initializable {

    @FXML
    private AnchorPane reservationPane;
    @FXML
    private JFXDatePicker checkInDatePicker;
    @FXML
    private JFXDatePicker checkOutDatePicker;
    @FXML
    private Label lblTotalNights;
    @FXML
    private JFXComboBox<String> cmbRoomType;
    @FXML
    private JFXComboBox<String> cmbPackage;
    @FXML
    private JFXComboBox<String> cmbRoomFloor;
    @FXML
    private JFXButton btnCheckAvailability;
    @FXML
    private TableView<CustomEntity> tblAvailableReservations;
    @FXML
    private JFXTextField txtGuests;
    @FXML
    private JFXButton btnNext;
    @FXML
    private JFXButton btnManageReservation;
    @FXML
    private JFXButton btnManagePayments;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblAvailableReservations.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblAvailableReservations.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblAvailableReservations.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblAvailableReservations.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblAvailableReservations.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        //-------------------------------------------------// TODO
        tblAvailableReservations.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Room_No"));
        tblAvailableReservations.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Room_Type"));
        tblAvailableReservations.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Package_Name"));
        tblAvailableReservations.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Room_Floor"));
        tblAvailableReservations.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Room_Price"));
        try {
            ObservableList<String> getPackage = ReservationMethodController.getPackage();
            ObservableList<String> roomType = ReservationMethodController.getRoomType();
            ObservableList<String> roomFloor = FXCollections.observableArrayList("1st Floor", "2nd Floor", "3rd Floor", "4th Floor", "5th Floor", "6th Floor", "7th Floor");
            cmbPackage.setItems(getPackage);
            cmbRoomType.setItems(roomType);
            cmbRoomFloor.setItems(roomFloor);
            // cmbRoomFloor.getSelectionModel().selectFirst();
            // cmbPackage.getSelectionModel().selectFirst();
            //cmbRoomType.getSelectionModel().selectFirst();// TODO
        } catch (Exception ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        checkInDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });

        checkOutDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });
    }

    public void checkavailability() throws Exception {
       try{
        if (Pattern.compile("[0-9]{4}(-)[0-9]{2}(-)[0-9]{2}$").matcher(checkInDatePicker.getValue().format(DateTimeFormatter.ISO_DATE)).matches()) {
            if (Pattern.compile("[0-9]{4}(-)[0-9]{2}(-)[0-9]{2}$").matcher(checkOutDatePicker.getValue().format(DateTimeFormatter.ISO_DATE)).matches()) {
                if (Pattern.compile("[0-9]{1}$").matcher(txtGuests.getText()).matches()) {
                    int guest = Integer.parseInt(txtGuests.getText());
                    ArrayList<CustomEntity> availableReservations = ReservationMethodController.getAvailableReservations(cmbPackage.getSelectionModel().getSelectedItem(),
                            guest, cmbRoomFloor.getSelectionModel().getSelectedItem(), cmbRoomType.getSelectionModel().getSelectedItem(),
                            checkInDatePicker.getValue().format(DateTimeFormatter.ISO_DATE));

                    if (availableReservations.isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("No Rooms Availble");
                        alert.setContentText("Try using different Floor");
                        alert.setResizable(false);
                        alert.showAndWait();
                    }
                    tblAvailableReservations.setItems(FXCollections.observableArrayList(availableReservations));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Invalid Value at Number of Guests");
                    alert.setContentText("Please Enter the Guset Count");
                    alert.setResizable(false);
                    alert.showAndWait();
                    txtGuests.requestFocus();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Please Select the Checkout Date!!!");
                alert.setContentText("Checkout Date not Selected! Please select a date to Continue!");
                alert.setResizable(false);
                alert.showAndWait();
                checkOutDatePicker.requestFocus();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please Select the Check IN date!!!");
            alert.setContentText("Check IN Date is not set!! Select a date to Continue");
            alert.setResizable(false);
            alert.showAndWait();
            txtGuests.requestFocus();
        }
       }catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please Fill the Required Fields!!");
            alert.setContentText("No values Given to Search");
            alert.setResizable(false);
            alert.showAndWait();
            txtGuests.requestFocus();
       }

    }

    @FXML
    private void btncheckAvailabilityActionPerformed(ActionEvent event) {
        try {
            checkavailability();
        } catch (Exception ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public ArrayList<CustomEntity> getTableValues(){
//        CustomEntity selectedItem = tblAvailableReservations.getSelectionModel().getSelectedItem();
//        ArrayList<CustomEntity> values = new ArrayList<>();
//        values.add(new CustomEntity(selectedItem.getPackage_Name(), selectedItem.getRoom_No(), selectedItem.getRoom_Floor(), selectedItem.getRoom_Type(), selectedItem.getRoom_Price()));
//       return values;
//
//    }
    @FXML
    private void tblAvailablereservationsMouseClicked(MouseEvent event) {
//        getTableValues();
    }

    @FXML
    private void btnNextActionPerformed(ActionEvent event) throws IOException {
        try{
        CustomEntity selectedItem = tblAvailableReservations.getSelectionModel().getSelectedItem();
        ObservableList<CustomEntity> datescheck = FXCollections.observableArrayList();
        int guest = Integer.parseInt(txtGuests.getText());
        datescheck.add(new CustomEntity(guest, checkInDatePicker.getValue().format(DateTimeFormatter.ISO_DATE), checkOutDatePicker.getValue().format(DateTimeFormatter.ISO_DATE)));
        //CustomEntity dates = new CustomEntity(checkInDatePicker.getValue().format(DateTimeFormatter.ISO_DATE), checkOutDatePicker.getValue().format(DateTimeFormatter.ISO_DATE));
//            Parent roomreservation=FXMLLoader.load(getClass().getResource("/view/RoomReservation.fxml"));
        //tring[] dates={checkInDatePicker.getValue().format(DateTimeFormatter.ISO_DATE),checkOutDatePicker.getValue().format(DateTimeFormatter.ISO_DATE)};
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/lk/hotelme/view/RoomReservation.fxml"));
        Parent load = fxmlLoader.load();
        RoomReservationController controller = fxmlLoader.<RoomReservationController>getController();
        controller.setT(selectedItem);
        controller.setdates(datescheck);

        Scene reservation = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(reservation);
        stage.show();
        stage.setResizable(true);
        stage.centerOnScreen();
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please select an Available Room to Continue");
            alert.setContentText("No values Given to Selected Room");
            alert.setResizable(false);
            alert.showAndWait();
            txtGuests.requestFocus();
        }
    }

    @FXML
    private void calculatedays(ActionEvent event) {
        long dayin = checkInDatePicker.getValue().toEpochDay();
        long dayout = checkOutDatePicker.getValue().toEpochDay();
        int tottaldays = (int) Math.abs(dayout - dayin);
        lblTotalNights.setText(Integer.toString(tottaldays));
    }

    @FXML
    private void btnManageReservationActionPerformed(ActionEvent event) {
        try {
            AnchorPane manage = FXMLLoader.load(getClass().getResource("/lk/hotelme/view/ManageReservations.fxml"));
            Scene scene = new Scene(manage);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setTitle("Manage Reservations");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnManagePaymentsActionPerformed(ActionEvent event) throws IOException {
        AnchorPane paymentspane = FXMLLoader.load(getClass().getResource("/lk/hotelme/view/ManagePayments.fxml"));
        Scene scene = new Scene(paymentspane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle("Manage Payments");
        stage.show();

    }
}
