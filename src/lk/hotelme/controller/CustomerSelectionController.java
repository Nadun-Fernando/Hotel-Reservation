/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import lk.hotelme.dto.CustomerDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class CustomerSelectionController implements Initializable {

    @FXML
    private AnchorPane customerselectpane;
    @FXML
    private TableView<CustomerDTO> tblCustomerSelection;
    @FXML
    private TextField txtCustomerSearchID;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXButton btnSelectandGO;
    @FXML
    private JFXButton btnAddNew;
    @FXML
    private JFXButton btnReload;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCustomerSelection.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblCustomerSelection.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblCustomerSelection.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblCustomerSelection.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblCustomerSelection.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        //-------------------------------------------------// TODO
        tblCustomerSelection.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblCustomerSelection.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblCustomerSelection.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblCustomerSelection.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("TelephoneNumber"));
        tblCustomerSelection.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        
        try {
            ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
            tblCustomerSelection.setItems(FXCollections.observableArrayList(loadCustomer));
        } catch (Exception ex) {
            Logger.getLogger(CustomerSelectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnSearchActionPerformed(ActionEvent event) {
        try {
            CustomerDTO searchCustomer = CustomerMethodController.searchCustomer(txtCustomerSearchID.getText());
            ObservableList<CustomerDTO> customer = null;
            customer.add(new CustomerDTO(searchCustomer.getID(), searchCustomer.getName(), searchCustomer.getAddress(), searchCustomer.getTelephoneNumber(), searchCustomer.getEmail()));
            tblCustomerSelection.getSelectionModel().clearSelection();
            tblCustomerSelection.setItems(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerSelectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSelectandGOActionPerformed(ActionEvent event) throws IOException {
        CustomerDTO selectedItem = tblCustomerSelection.getSelectionModel().getSelectedItem();
        //System.out.println(selectedItem.getID());
        RoomReservationController.cusinfo[0]=selectedItem.getID();
        RoomReservationController.cusinfo[1]=selectedItem.getName();
       Stage stage = (Stage) this.customerselectpane.getScene().getWindow();
       stage.close();
        
       
        
    }

    @FXML
    private void btnAddnewActionPerformed(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/lk/hotelme/view/CustomerForm.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void btnReloadActionPerformed(ActionEvent event) throws Exception {
        ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
        tblCustomerSelection.setItems(FXCollections.observableArrayList(loadCustomer));
    }
    
}
