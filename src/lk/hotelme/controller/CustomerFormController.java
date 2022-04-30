/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.dto.CustomerDTO;
import lk.hotelme.bo.BOFactory;
import lk.hotelme.bo.custom.CustomerBO;
import lk.hotelme.bo.SuperBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TablePosition;
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
public class CustomerFormController implements Initializable {

    @FXML
    private JFXTextField txtCustomerID;
    @FXML
    private JFXTextField txtCustomerFirstName;
    @FXML
    private JFXTextField txtAddress;
    @FXML
    private JFXTextField txtCountry;
    @FXML
    private JFXTextField txtTelephoneNumber;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private TableView<CustomerDTO> tblCustomerInfo;
    @FXML
    private JFXButton btnSaveCustomer;
    @FXML
    private JFXButton btnUpdateCustomer;
    @FXML
    private JFXButton btnDeleteCustomer;
    @FXML
    private JFXButton btnReloadCustomer;
    @FXML
    private TextField txtSearchbyID;
    @FXML
    private JFXTextField txtCustomerLastName;
    ObservableList<CustomerDTO> customer;
    @FXML
    private Pane paneCustomer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCustomerInfo.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblCustomerInfo.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblCustomerInfo.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblCustomerInfo.getColumns().get(3).setStyle("-fx-alignment: CENTER;");
        tblCustomerInfo.getColumns().get(4).setStyle("-fx-alignment: CENTER;");
        //-------------------------------------------------// TODO
        tblCustomerInfo.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ID"));
        tblCustomerInfo.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblCustomerInfo.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblCustomerInfo.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("TelephoneNumber"));
        tblCustomerInfo.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        // TODO
        try {
            ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
            tblCustomerInfo.setItems(FXCollections.observableArrayList(loadCustomer));
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void tblCustomerInfoMouseClicked(MouseEvent event) {
        CustomerDTO selectedItem = tblCustomerInfo.getSelectionModel().getSelectedItem();
        txtCustomerID.setText(selectedItem.getID());
        String Name = selectedItem.getName();
        String Address = selectedItem.getAddress();
        String[] name_parts = Name.split(" ");
        String[] address_parts = Address.split(" - ");
        txtCustomerFirstName.setText(name_parts[0]);
        txtCustomerLastName.setText(name_parts[1]);
        txtAddress.setText(address_parts[0]);
        txtCountry.setText(address_parts[1]);
        txtTelephoneNumber.setText(selectedItem.getTelephoneNumber());
        txtEmail.setText(selectedItem.getEmail());

    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        try {
            if (Pattern.compile("[C][0-9]{3}$").matcher(txtCustomerID.getText()).matches()) {
                if (Pattern.compile("[A-z]{3,20}$").matcher(txtCustomerFirstName.getText()).matches()) {
                    if (Pattern.compile("[A-z]{3,30}$").matcher(txtCustomerLastName.getText()).matches()) {
                        if (Pattern.compile("[A-z0-9 ,.]{10,60}$").matcher(txtAddress.getText()).matches()) {
                            if (Pattern.compile("[A-z ,.]{3,15}$").matcher(txtCountry.getText()).matches()) {
                                if (Pattern.compile("[+][0-9]{11,13}$").matcher(txtTelephoneNumber.getText()).matches()) {
                                    if (Pattern.compile("[a-z]{3,20}(@){1}[a-z]{5}(.){1}(com){1}$").matcher(txtEmail.getText()).matches()) {
                                        try {
                                            String ID = txtCustomerID.getText();
                                            String FirstName = txtCustomerFirstName.getText();
                                            String LastName = txtCustomerLastName.getText();
                                            String StreetAddress = txtAddress.getText();
                                            String Country = txtCountry.getText();
                                            String Telephone = txtTelephoneNumber.getText();
                                            String Email = txtEmail.getText();
                                            String Name = FirstName + " " + LastName;
                                            String Address = StreetAddress + " - " + Country;

                                            CustomerDTO row = new CustomerDTO(ID, Name, Address, Telephone, Email);
                                            boolean addCustomer = CustomerMethodController.addCustomer(row);
                                            if (addCustomer) {
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                alert.setTitle("Done");
                                                alert.setHeaderText("Customer Added");
                                                alert.setContentText("Keep Going");
                                                alert.showAndWait();
                                                ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
                                                tblCustomerInfo.setItems(FXCollections.observableArrayList(loadCustomer));
                                            }
                                        } catch (Exception ex) {
                                            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setHeaderText("Invalid Value near Email " + txtEmail.getText());
                                        alert.setContentText("Please follow the correct syntax : someone@example.com");
                                        alert.setResizable(false);
                                        alert.showAndWait();
                                        txtEmail.requestFocus();
                                    }
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText("Invalid Value near Telephone Number : " + txtTelephoneNumber.getText());
                                    alert.setContentText("Please follow the Correct Syntax : +<county code><telephonenumber>");
                                    alert.setResizable(false);
                                    alert.showAndWait();
                                    txtTelephoneNumber.requestFocus();
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText("Invalid Value near Country : " + txtCountry.getText());
                                alert.setContentText("Please follow the correct Syntax : <Your Country>");
                                alert.setResizable(false);
                                alert.showAndWait();
                                txtCountry.requestFocus();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText("Invalid Value near Address : " + txtAddress.getText());
                            alert.setContentText("Please follow the Correct Syntax : <Your Address without Country");
                            alert.setResizable(false);
                            alert.showAndWait();
                            txtAddress.requestFocus();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid Value Last Name : " + txtCustomerLastName.getText());
                        alert.setContentText("Please Enter your Last Name");
                        alert.setResizable(false);
                        alert.showAndWait();
                        txtCustomerLastName.requestFocus();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Invalid Value near First Name : " + txtCustomerFirstName.getText());
                    alert.setContentText("Please Enter Your First Name");
                    alert.setResizable(false);
                    alert.showAndWait();
                    txtCustomerFirstName.requestFocus();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Value near Customer_ID : " + txtCustomerID.getText());
                alert.setContentText("Please follow the Correct Syntax : Example: C001");
                alert.setResizable(false);
                alert.showAndWait();
                txtCustomerID.requestFocus();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No values for Fields");
            alert.setContentText("Please fill the Values to Continue");
            alert.setResizable(false);
            alert.showAndWait();
            txtCustomerID.requestFocus();
        }
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) {
try {
            if (Pattern.compile("[C][0-9]{3}$").matcher(txtCustomerID.getText()).matches()) {
                if (Pattern.compile("[A-z]{3,20}$").matcher(txtCustomerFirstName.getText()).matches()) {
                    if (Pattern.compile("[A-z]{3,30}$").matcher(txtCustomerLastName.getText()).matches()) {
                        if (Pattern.compile("[A-z0-9 ,.]{10,60}$").matcher(txtAddress.getText()).matches()) {
                            if (Pattern.compile("[A-z ,.]{3,15}$").matcher(txtCountry.getText()).matches()) {
                                if (Pattern.compile("[+][0-9]{11,13}$").matcher(txtTelephoneNumber.getText()).matches()) {
                                    if (Pattern.compile("[a-z]{3,20}(@){1}[a-z]{5}(.){1}(com){1}$").matcher(txtEmail.getText()).matches()) {
                                         try {
                                            String ID = txtCustomerID.getText();
                                            String FirstName = txtCustomerFirstName.getText();
                                            String LastName = txtCustomerLastName.getText();
                                            String StreetAddress = txtAddress.getText();
                                            String Country = txtCountry.getText();
                                            String Telephone = txtTelephoneNumber.getText();
                                            String Email = txtEmail.getText();
                                            String Name = FirstName + " " + LastName;
                                            String Address = StreetAddress + " - " + Country;

                                            CustomerDTO temp = new CustomerDTO(ID, Name, Address, Telephone, Email);
                                            boolean updateCustomer = CustomerMethodController.updateCustomer(temp);
                                            if (updateCustomer) {
                                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                alert.setTitle("Done");
                                                alert.setHeaderText("Customer Updated");
                                                alert.setContentText("Keep Going");
                                                alert.showAndWait();
                                                ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
                                                tblCustomerInfo.setItems(FXCollections.observableArrayList(loadCustomer));
                                            }
                                        } catch (Exception ex) {
                                            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setHeaderText("Invalid Value near Email " + txtEmail.getText());
                                        alert.setContentText("Please follow the correct syntax : someone@example.com");
                                        alert.setResizable(false);
                                        alert.showAndWait();
                                        txtEmail.requestFocus();
                                    }
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setHeaderText("Invalid Value near Telephone Number : " + txtTelephoneNumber.getText());
                                    alert.setContentText("Please follow the Correct Syntax : +<county code><telephonenumber>");
                                    alert.setResizable(false);
                                    alert.showAndWait();
                                    txtTelephoneNumber.requestFocus();
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText("Invalid Value near Country : " + txtCountry.getText());
                                alert.setContentText("Please follow the correct Syntax : <Your Country>");
                                alert.setResizable(false);
                                alert.showAndWait();
                                txtCountry.requestFocus();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText("Invalid Value near Address : " + txtAddress.getText());
                            alert.setContentText("Please follow the Correct Syntax : <Your Address without Country");
                            alert.setResizable(false);
                            alert.showAndWait();
                            txtAddress.requestFocus();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid Value Last Name : " + txtCustomerLastName.getText());
                        alert.setContentText("Please Enter your Last Name");
                        alert.setResizable(false);
                        alert.showAndWait();
                        txtCustomerLastName.requestFocus();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Invalid Value near First Name : " + txtCustomerFirstName.getText());
                    alert.setContentText("Please Enter Your First Name");
                    alert.setResizable(false);
                    alert.showAndWait();
                    txtCustomerFirstName.requestFocus();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Value near Customer_ID : " + txtCustomerID.getText());
                alert.setContentText("Please follow the Correct Syntax : Example: C001");
                alert.setResizable(false);
                alert.showAndWait();
                txtCustomerID.requestFocus();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No values for Fields");
            alert.setContentText("Please fill the Values to Continue");
            alert.setResizable(false);
            alert.showAndWait();
            txtCustomerID.requestFocus();
        }
//       
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
        try {
            boolean deleteCustomer = CustomerMethodController.deleteCustomer(txtCustomerID.getText());
            if (deleteCustomer) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Done");
                alert.setHeaderText("Customer Deleted Succesfully");
                alert.setContentText("Keep Going");
                alert.showAndWait();
                ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
                tblCustomerInfo.setItems(FXCollections.observableArrayList(loadCustomer));
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnReloadAction(ActionEvent event) {
        try {
            ArrayList<CustomerDTO> loadCustomer = CustomerMethodController.loadCustomer();
            tblCustomerInfo.setItems(FXCollections.observableArrayList(loadCustomer));
        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchbyIDAction(ActionEvent event) {
        try {
            CustomerDTO searchCustomer = CustomerMethodController.searchCustomer(txtSearchbyID.getText());
            txtCustomerID.setText(searchCustomer.getID());
            String Name = searchCustomer.getName();
            String Address = searchCustomer.getAddress();
            String[] name_part = Name.split(" ");
            String[] address_part = Address.split(" - ");
            txtCustomerFirstName.setText(name_part[0]);
            txtCustomerLastName.setText(name_part[1]);
            txtAddress.setText(address_part[0]);
            txtCountry.setText(address_part[1]);
            txtTelephoneNumber.setText(searchCustomer.getTelephoneNumber());
            txtEmail.setText(searchCustomer.getEmail());

        } catch (Exception ex) {
            Logger.getLogger(CustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
