/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane dashboardpane;
    @FXML
    private Pane navigationpane;
    @FXML
    private JFXButton btnaddPackage;
    @FXML
    private Pane headerpane;
    @FXML
    private Pane loadingpane;
    @FXML
    private JFXButton btnAddRoomType;
    @FXML
    private JFXButton btnAddRoom;
    @FXML
    private JFXButton btnAddCustomer;
    @FXML
    private JFXButton btnAddReceptionist;
    @FXML
    private JFXButton btnReservation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        loadingpane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Package.fxml"));
        loadingpane.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnPackageAction(ActionEvent event) throws IOException {
        loadingpane.getChildren().clear();
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Package.fxml"));
        loadingpane.getChildren().add(newLoadedPane);
    }

    @FXML
    private void btnAddRoomTypeActionPerformed(ActionEvent event) throws IOException {
        loadingpane.getChildren().clear();
        AnchorPane roomType=FXMLLoader.load(getClass().getResource("/lk/hotelme/view/RoomType.fxml"));
        loadingpane.getChildren().add(roomType);
    }

    @FXML
    private void btnAddRoomActionPerformed(ActionEvent event) throws IOException {
        loadingpane.getChildren().clear();
        Pane room=FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Rooms.fxml"));
        loadingpane.getChildren().add(room);
        
    }

    @FXML
    private void btnAddCustomerActionPerformed(ActionEvent event) throws IOException {
        loadingpane.getChildren().clear();
        Pane customer=FXMLLoader.load(getClass().getResource("/lk/hotelme/view/CustomerForm.fxml"));
        loadingpane.getChildren().add(customer);
    }

    @FXML
    private void btnAddReceptionistActionPerformed(ActionEvent event) throws IOException {
        loadingpane.getChildren().clear();
        Pane user=FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Receptionist.fxml"));
        loadingpane.getChildren().add(user);
    }

    @FXML
    private void btnReservationActionPerformed(ActionEvent event) throws IOException {
        Parent reservation=FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Reservation.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(reservation);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.showAndWait();
        
    }
    
}
