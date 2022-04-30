/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.entity.CustomEntity;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class ManagePaymentsController implements Initializable {

    @FXML
    private AnchorPane managePaymentPane;
    @FXML
    private TableView<CustomEntity> tblmanagePayments;
    @FXML
    private TextField txtSearchbyCusID;
    @FXML
    private JFXButton btnSearchbyCustomerID;
    @FXML
    private TextField txtSearchbyPaymentID;
    @FXML
    private JFXButton btnSearchbyPaymentID;
    @FXML
    private Label lblPAymentID;
    @FXML
    private Label lblCustomerID;
    @FXML
    private Label lblTotalAmount;
    @FXML
    private Label lblAmountPaid;
    @FXML
    private Label lblRemainigAmount;
    @FXML
    private JFXButton btnSettlePayment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblmanagePayments.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblmanagePayments.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblmanagePayments.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblmanagePayments.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblmanagePayments.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        //-------------------------------------------------// TODO
        tblmanagePayments.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
        tblmanagePayments.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Payment_ID"));
        tblmanagePayments.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Total_Amount"));
        tblmanagePayments.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Amount_Paid"));
        tblmanagePayments.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Remaining_Amount"));

        try {
            ArrayList<CustomEntity> allPaymentDetails = ManagePaymentsMethodController.getallPaymentDetails(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            tblmanagePayments.setItems(FXCollections.observableArrayList(allPaymentDetails));
        } catch (Exception ex) {
            Logger.getLogger(ManagePaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tblPanagePaymentsMouseClicked(MouseEvent event) {
        CustomEntity selectedItem = tblmanagePayments.getSelectionModel().getSelectedItem();
        lblAmountPaid.setText(selectedItem.getAmount_Paid()+"");
        lblCustomerID.setText(selectedItem.getCustomer_ID());
        lblPAymentID.setText(selectedItem.getPayment_ID());
        lblRemainigAmount.setText(selectedItem.getRemaining_Amount()+"");
        lblTotalAmount.setText(selectedItem.getTotal_Amount()+"");
    }

    @FXML
    private void btnSearchbyCustomerIDActionPerformed(ActionEvent event) throws Exception {
        if(Pattern.compile("(C){1}[0-9]{3}$").matcher(txtSearchbyCusID.getText()).matches()){
            ArrayList<CustomEntity> paymentDetailsbyCustomerID = ManagePaymentsMethodController.getPaymentDetailsbyCustomerID(txtSearchbyCusID.getText(), LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            tblmanagePayments.setItems(FXCollections.observableArrayList(paymentDetailsbyCustomerID));
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Value at Search Bar");
            alert.setContentText("Synatax Error near : " +" ' "+ txtSearchbyCusID.getText()+" ' ");
            alert.setResizable(false);
            alert.showAndWait();
            txtSearchbyCusID.requestFocus();
        }
    }

    @FXML
    private void btnSearchbyPaymentIDActionPerformed(ActionEvent event) throws Exception {
        if (Pattern.compile("(Pay)[-]{1}[0-9]{3}$").matcher(txtSearchbyPaymentID.getText()).matches()) {
            ArrayList<CustomEntity> paymentDetailsbyPaymentID = ManagePaymentsMethodController.getPaymentDetailsbyPaymentID(txtSearchbyPaymentID.getText(), LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            tblmanagePayments.setItems(FXCollections.observableArrayList(paymentDetailsbyPaymentID));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Value at Search Bar");
            alert.setContentText("Synatax Error near : " +" ' "+ txtSearchbyPaymentID.getText()+" ' ");
            alert.setResizable(false);
            alert.showAndWait();
            txtSearchbyPaymentID.requestFocus();
        }
    }

    @FXML
    private void btnSettlePaymentActionPerformed(ActionEvent event) throws Exception {
        double tot=Double.parseDouble(lblTotalAmount.getText());
        double remain=Double.parseDouble(lblRemainigAmount.getText());
        double paid=Double.parseDouble(lblAmountPaid.getText());
        
        boolean updatePaymentDetail = ManagePaymentsMethodController.updatePaymentDetail(new Payment_DetailsTO(lblPAymentID.getText(), "PT-003", LocalDate.now().format(DateTimeFormatter.ISO_DATE), tot, 0));
        if(updatePaymentDetail){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Payment Settled");
            alert.setContentText("Thank You and Come Again!");
            alert.setResizable(false);
            alert.showAndWait();
        }
    }

}
