/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class LoginController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private JFXTextField txtusername;
    @FXML
    private JFXPasswordField txtpassword;
    @FXML
    private JFXButton btnsignin;
    
    @FXML
    private AnchorPane loginformpane;
    @FXML
    private JFXButton btnAdmin;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void txtUsernameAction(ActionEvent event) throws Exception {
        //pass = LoginMethodController.getpass(txtusername.getText());
     txtpassword.requestFocus();
    }

    @FXML
    private void txtPasswordAction(ActionEvent event) {
        btnsignin.requestFocus();
    }

    @FXML
    private void btnSignInAction(ActionEvent event) throws Exception {
        String pass = LoginMethodController.getpass(txtusername.getText());
        
        if(pass == null ? txtpassword.getText() == null : pass.equals(txtpassword.getText())){
            try {
                Parent root=FXMLLoader.load(getClass().getResource("/lk/hotelme/view/Reservation.fxml"));
                
                Stage primaryStage = (Stage) this.loginformpane.getScene().getWindow();
                primaryStage.close();
                Scene mainScene=new Scene(root);
                primaryStage.setScene(mainScene);
                primaryStage.setTitle("Hotel Reservation");
                primaryStage.setResizable(false);
                primaryStage.show();
                primaryStage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Password or Username");
            alert.setContentText("Try Again");
            alert.show();
        }
        
    }

    @FXML
    private void btnAdminActionPerformed(ActionEvent event) throws IOException {
        AnchorPane admin = FXMLLoader.load(getClass().getResource("/lk/hotelme/view/AdminAccess.fxml"));
        Stage stage = (Stage) this.loginformpane.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(admin);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    
}
