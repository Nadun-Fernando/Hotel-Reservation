/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import lk.hotelme.db.DBConnection;
import lk.hotelme.dto.CustomerDTO;
import lk.hotelme.dto.PaymentDTO;
import lk.hotelme.dto.Payment_DetailsTO;
import lk.hotelme.dto.ReservationDTO;
import lk.hotelme.entity.CustomEntity;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class RoomReservationController implements Initializable {

    @FXML
    private AnchorPane RoomReservationPane;
    @FXML
    private JFXTextField txtRoomNo;
    @FXML
    private JFXTextField txtRoomType;
    @FXML
    private JFXTextField txtRoomPrice;
    @FXML
    private JFXTextField txtRoomFloor;
    @FXML
    private JFXTextField txtPackageName;
    @FXML
    private Label lblReservationID;
    @FXML
    private Label lblRoomID;
    @FXML
    private Label lblCustomerIDHeader;
    @FXML
    public Label lblCustomerName;
    @FXML
    public Label lblCustomerID;
    @FXML
    private JFXButton btnSelectCustomer;
    @FXML
    private JFXComboBox<String> cmbReceptionisID;
    @FXML
    private Label lblReceptionistName;
    @FXML
    private Label lblPaymentID;
    @FXML
    private JFXTextField txtValuePaid;
    @FXML
    private Label lblRemaingValue;
    @FXML
    private JFXButton btnPAyment;
    @FXML
    private JFXButton btnPrint;
    @FXML
    private Label lblTotalPayment;
    @FXML
    private JFXComboBox<String> cmbMealTypes;
    @FXML
    private Label lblMealID;
    @FXML
    private Label lblmealPrice;
    private String ArrivalDate;
    private String DepartureDate;
    private int noofGuest;
    double tot;
    double paid;
    double remain;
    private static DecimalFormat df2=new DecimalFormat("#.##");
    public static String[] cusinfo= new String[2];
    @FXML
    private TextField txtSearchContactNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<String> receptionistID = RoomReservationMethodController.getReceptionistID();
            cmbReceptionisID.setItems(receptionistID);
            
            ObservableList<String> mealID = RoomReservationMethodController.getMealID();
            cmbMealTypes.setItems(mealID);
            String paymentID = RoomReservationMethodController.getPaymentID();
            String[] paymentIDPart = paymentID.split("-");
            String Pay = paymentIDPart[0];
            int nextpaymentID = Integer.parseInt(paymentIDPart[1]);
            if (nextpaymentID < 9) {
                lblPaymentID.setText(Pay + "-00" + (nextpaymentID + 1));
            } else if (nextpaymentID < 99) {
                lblPaymentID.setText(Pay + "-0" + (nextpaymentID + 1));
            } else {
                lblPaymentID.setText(Pay + "-" + (nextpaymentID + 1));
            }

            String ReservationID = RoomReservationMethodController.getnextReservationID();
            String[] reservationIDpart = ReservationID.split("-");
            String rEC = reservationIDpart[0];
            int nextreservation = Integer.parseInt(reservationIDpart[1]);
            if (nextreservation < 9) {
                lblReservationID.setText(rEC + "-00" + (nextreservation + 1));
            } else if (nextreservation < 99) {
                lblReservationID.setText(rEC + "-0" + (nextreservation + 1));
            } else {
                lblReservationID.setText(rEC + "-" + (nextreservation + 1));
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setT(CustomEntity alllust) {
        try {
            txtPackageName.setText(alllust.getPackage_Name());
            txtRoomFloor.setText(alllust.getRoom_Floor());
            txtRoomNo.setText(alllust.getRoom_No());
            txtRoomPrice.setText(alllust.getRoom_Price() + "");
            txtRoomType.setText(alllust.getRoom_Type());
            String roomID = RoomReservationMethodController.getRoomID(alllust.getRoom_No());
            lblRoomID.setText(roomID);
        } catch (Exception ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setdates(ObservableList<CustomEntity> e) {
        ArrivalDate = e.get(0).getArrival_Date();
        DepartureDate = e.get(0).getDeparture_Date();
        noofGuest = e.get(0).getNo_of_Guests();
    }

    public void setCustomer() {
        lblCustomerID.setText(cusinfo[0]);
        lblCustomerName.setText(cusinfo[1]);
        lblCustomerIDHeader.setText(cusinfo[0]);
    }

    @FXML
    private void btnSelectCustomerAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/lk/hotelme/view/customerSelection.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.showAndWait();
        setCustomer();
    }

    @FXML
    private void btnPaymentActionPerformed(ActionEvent event) {
        try {
            String id = RoomReservationMethodController.getPackageID(txtPackageName.getText());
            tot = Double.parseDouble(lblTotalPayment.getText());
            PaymentDTO p = new PaymentDTO(lblPaymentID.getText(), tot);
            //System.out.println(p.getPayment_ID()+" "+p.getTotal_Payment());
            remain = Double.parseDouble(lblRemaingValue.getText());
            String paymenttype = null;
            if (remain == 0) {
                paymenttype = "PT-003";
                paid = Double.parseDouble(lblTotalPayment.getText());
            } else {
                paymenttype = "PT-002";
                paid = Double.parseDouble(txtValuePaid.getText());
            }
            Payment_DetailsTO pd = new Payment_DetailsTO(lblPaymentID.getText(), paymenttype, LocalDate.now().format(DateTimeFormatter.ISO_DATE), paid, remain);
            //System.out.println(pd.getPayment_ID()+" "+pd.getPayment_Type_ID()+" "+pd.getPayment_Date()+" "+pd.getAmount_Paid()+" "+pd.getRemaining_Amount());
            ReservationDTO res = new ReservationDTO(lblReservationID.getText(), lblCustomerIDHeader.getText(), noofGuest, ArrivalDate, DepartureDate, id,cmbMealTypes.getSelectionModel().getSelectedItem(),lblRoomID.getText(), cmbReceptionisID.getSelectionModel().getSelectedItem(), lblPaymentID.getText());
            //System.out.println(res.getReservation__ID()+" "+res.getCustomer_ID()+" "+res.getNo_of_Guests()+" "+res.getArrival_Date()+" "+res.getDeparture_Date()+" "+res.getPackage_ID()+" "+res.getReceptionist_ID()+" "+res.getPayment_ID());
            Boolean confirmed = RoomReservationMethodController.confirmbooking(p, pd, res);
            if (confirmed) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Done");
                alert.setContentText("done");
                alert.show();
                Stage stage=(Stage) this.RoomReservationPane.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error No Reservation Added");
                alert.setContentText("Please contact the developer");
                alert.show();
            }
//        } catch (Exception ex) {
//            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnPrintActionPerformed(ActionEvent event) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            //CustomerSelectionController cusselect = new CustomerSelectionController();
//            System.out.println(cusinfo[0]);
//            System.out.println(cusselect.cusinfo[1]);
            InputStream invoice = this.getClass().getResourceAsStream("/lk/hotelme/reports/Invoice.jasper");
            double remainingvalue;
            double paymnet;
            double paidvalue=Double.parseDouble(txtValuePaid.getText());
            double roomPrice = Double.parseDouble(txtRoomPrice.getText());
            double totalprice=Double.parseDouble(lblTotalPayment.getText());
//            remainingvalue=totalprice-paidvalue;
            if(paidvalue>=totalprice){
                remainingvalue=0.0;
                paymnet=totalprice;
            }else{
                remainingvalue=totalprice-paidvalue;
                paymnet=paidvalue;
            }
            double mealprice = Double.parseDouble(lblmealPrice.getText());
            HashMap invoicemap = new HashMap();
            invoicemap.put("CheckinDate", ArrivalDate);
            invoicemap.put("CheckoutDate", DepartureDate);
            invoicemap.put("RoomPrice", roomPrice);
            invoicemap.put("PackageName", txtPackageName.getText());
            invoicemap.put("MealName", lblMealID.getText());
            invoicemap.put("MealPrice", mealprice);
            invoicemap.put("TotalPrice", totalprice);
            invoicemap.put("ValuePaid", paidvalue);
            invoicemap.put("RemainingValue", remainingvalue);
            invoicemap.put("ReceptionistID", cmbReceptionisID.getSelectionModel().getSelectedItem());
            invoicemap.put("ReceptionistName", lblReceptionistName.getText());
            invoicemap.put("ReservationID", lblReservationID.getText());
            invoicemap.put("PaymentID", lblPaymentID.getText());
            invoicemap.put("CustomerID", lblCustomerID.getText());
            invoicemap.put("CustomerName", lblCustomerName.getText());
            invoicemap.put("RoomNo", txtRoomNo.getText());
            invoicemap.put("Floor", txtRoomFloor.getText());
            JasperPrint fillReport = JasperFillManager.fillReport(invoice, invoicemap, connection);
            JasperViewer.viewReport(fillReport, false);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cmbReceptionistIDActionPerformed(ActionEvent event) {
        try {
            String receptionistName = RoomReservationMethodController.getReceptionistName(cmbReceptionisID.getSelectionModel().getSelectedItem());
            lblReceptionistName.setText(receptionistName);
        } catch (Exception ex) {
            Logger.getLogger(RoomReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cmbMealTypesActionPerformed(ActionEvent event) throws Exception {
        CustomEntity mealName = RoomReservationMethodController.getMealName(cmbMealTypes.getSelectionModel().getSelectedItem());
        lblMealID.setText(mealName.getMeal_Name());
        lblmealPrice.setText(mealName.getMeal_Price() + "");
        calculateTotal();
    }

    public void calculateTotal() {
        double roomPrice = Double.parseDouble(txtRoomPrice.getText());
        double mealPrice = Double.parseDouble(lblmealPrice.getText());
        double tot = roomPrice + mealPrice;
        lblTotalPayment.setText(tot + "");
    }

    public void calculateRemaingValue() {
        double total = Double.parseDouble(lblTotalPayment.getText());
        double paymentvalue = Double.parseDouble(txtValuePaid.getText());
        double remaingvalue = total - paymentvalue;
        //lblRemaingValue.setText(remaingvalue+"");
        if (paymentvalue >= total) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("The Balance is : " + df2.format(-remaingvalue));
            alert.setContentText("Please take the Balance");
            alert.show();
            lblRemaingValue.setText("0.0");
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Your Remaining Balance is : " + df2.format(remaingvalue));
            alert.setContentText("Please pay your remaining Balnce before leave");
            alert.show();
            lblRemaingValue.setText(df2.format(remaingvalue) + "");
        }

    }

    @FXML
    private void txtValuepaidActionPerformed(ActionEvent event) {
        calculateRemaingValue();
    }

    @FXML
    private void txtSearchbyContactNoActionPerformed(ActionEvent event) throws Exception {
        try{
        if (Pattern.compile("[+][0-9]{11,13}$").matcher(txtSearchContactNo.getText()).matches()) {
        CustomerDTO seacrhcutomerbyContactNo = RoomReservationMethodController.seacrhcutomerbyContactNo(txtSearchContactNo.getText());
        lblCustomerID.setText(seacrhcutomerbyContactNo.getID());
        lblCustomerName.setText(seacrhcutomerbyContactNo.getName());
        lblCustomerIDHeader.setText(seacrhcutomerbyContactNo.getID());
        }else{
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Incorrect Syntax near Search bar : "+txtSearchContactNo.getText());
            alert.setContentText("Please enter a valid mobile number to Continue");
            alert.setResizable(false);
            alert.showAndWait();
            txtSearchContactNo.requestFocus();
        }
    }catch(NullPointerException e){
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No values for Search");
            alert.setContentText("Please Enter a Contact Number to Search Customer");
            alert.setResizable(false);
            alert.showAndWait();
            txtSearchContactNo.requestFocus();
    }
    
}

}
