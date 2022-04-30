/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class AdminAccessController implements Initializable {

    @FXML
    private AnchorPane adminpane;
    @FXML
    private JFXButton btnadminaccess;
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXPasswordField txtpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAdminAcessActionPerformed(ActionEvent event) throws Exception {
        String adminPass = LoginMethodController.getAdminPass(txtusername.getText());
        if (adminPass == null ? txtpassword.getText() == null : adminPass.equals(txtpassword.getText())) {
            Parent root = FXMLLoader.load(getClass().getResource("/lk/hotelme/view/dashboard.fxml"));

            Stage primaryStage = (Stage) this.adminpane.getScene().getWindow();
            primaryStage.close();
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Hotel Reservation");
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.centerOnScreen();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Password or Username");
            alert.setContentText("Try Again!,If you are not admin Please Log in Normally");
            alert.showAndWait();
            AnchorPane user = FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Login.fxml"));
            Stage stage = (Stage) this.adminpane.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(user);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    private void txtUsernameAction(ActionEvent event) {
        txtpassword.requestFocus();
    }

    @FXML
    private void txtPasswordAction(ActionEvent event) {
        btnadminaccess.requestFocus();
    }

}
