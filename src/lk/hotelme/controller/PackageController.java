/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.hotelme.dto.PackageDTO;
import lk.hotelme.entity.Packages;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nadun N. T. Fernando
 */
public class PackageController implements Initializable {

    @FXML
    private JFXTextField txtPackageID;
    @FXML
    private JFXTextField txtPackageName;
    @FXML
    private JFXTextField txtPackageDetails;
    @FXML
    private JFXTextField txtPackagePrice;
    @FXML
    private TextField txtSearchbyPackID;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private TableView<PackageDTO> tblPackage;
    @FXML
    private JFXButton btnAddPackage;
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
        tblPackage.getColumns().get(0).setStyle("-fx-alignment: CENTER;");
        tblPackage.getColumns().get(1).setStyle("-fx-alignment: CENTER;");
        tblPackage.getColumns().get(2).setStyle("-fx-alignment: CENTER;");
        tblPackage.getColumns().get(3).setStyle("-fx-alignment: CENTER;");

        //-------------------------------------------------// TODO
        tblPackage.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Package_ID"));
        tblPackage.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Package_Name"));
        tblPackage.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Package_Details"));
        tblPackage.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Package_Price"));
        try {
            ArrayList<PackageDTO> loadPackages = PackageMethodController.loadPackages();
            tblPackage.setItems(FXCollections.observableArrayList(loadPackages));
            // TODO
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSearchActionPerformed(ActionEvent event) {
        try {
            PackageDTO searchPackage = PackageMethodController.searchPackage(txtSearchbyPackID.getText());
            txtPackageID.setText(searchPackage.getPackage_ID());
            txtPackageName.setText(searchPackage.getPackage_Name());
            txtPackageDetails.setText(searchPackage.getPackage_Details());
            txtPackagePrice.setText(searchPackage.getPackage_Price() + "");
        } catch (Exception ex) {
            Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAddRoomActionPerformed(ActionEvent event) {
        try {
            if (Pattern.compile("(P-){1}[0-9]{3}$").matcher(txtPackageID.getText()).matches()) {
                if (Pattern.compile("[A-z ]{4,30}$").matcher(txtPackageName.getText()).matches()) {
                    if (Pattern.compile("[A-z0-9 ]{4,100}$").matcher(txtPackageDetails.getText()).matches()) {
                        if (Pattern.compile("[0-9]{3,10}(.)[0-9]{0,2}$").matcher(txtPackagePrice.getText()).matches()) {
                            double price = Double.parseDouble(txtPackagePrice.getText());

                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setHeaderText("Do you want to add this Package?");
                            alert.setContentText("Select Ok to ADD or Select Cancel to Cancel Adding");
                            alert.setResizable(false);
                            Optional<ButtonType> showAndWait = alert.showAndWait();
                            if (!showAndWait.isPresent()) {

                            } else if (showAndWait.get() == ButtonType.OK) {
                                try {
                                    boolean addPackage = PackageMethodController.addPackage(new PackageDTO(txtPackageID.getText(), txtPackageName.getText(), txtPackageDetails.getText(), price));
                                    if (addPackage) {
                                        Alert addedalert = new Alert(Alert.AlertType.INFORMATION);
                                        addedalert.setHeaderText("Package Added Succesfully");
                                        addedalert.setContentText("Keep Going Package Added");
                                        addedalert.show();
                                        ArrayList<PackageDTO> loadPackages = PackageMethodController.loadPackages();
                                        tblPackage.setItems(FXCollections.observableArrayList(loadPackages));
                                    }
                                } catch (Exception ex) {
                                    Alert a = new Alert(Alert.AlertType.ERROR);
                                    a.setHeaderText("You Cannot Duplicate the ID");
                                    a.setContentText(ex.getMessage());
                                    a.show();
                                }
                            } else if (showAndWait.get() == ButtonType.CANCEL) {
                                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                alert1.setHeaderText("Package Adding Cancelled");
                                alert1.setContentText("Keep editing Package not added");
                                alert1.showAndWait();
                                txtPackageName.requestFocus();

                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText("Invalid Value near Package Price " + txtPackagePrice.getText());
                            alert.setContentText("Please follow the correct syntax : Example: 55200 or 55200.36");
                            alert.setResizable(false);
                            alert.showAndWait();
                            txtPackagePrice.requestFocus();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid Value near Details " + txtPackageDetails.getText());
                        alert.setContentText("Please follow the correct syntax : package details(maximum characters 100)");
                        alert.setResizable(false);
                        alert.showAndWait();
                        txtPackageDetails.requestFocus();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Invalid Value near Package Name " + txtPackageName.getText());
                    alert.setContentText("Please follow the correct syntax : package nam(maximum charaters 30)");
                    alert.setResizable(false);
                    alert.showAndWait();
                    txtPackageName.requestFocus();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Value near ID " + txtPackageID.getText());
                alert.setContentText("Please follow the correct syntax : Example :P-001");
                alert.setResizable(false);
                alert.showAndWait();
                txtPackageID.requestFocus();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No values for Fields");
            alert.setContentText("Please fill the Values to Continue");
            alert.setResizable(false);
            alert.showAndWait();
            txtPackageID.requestFocus();
        }
    }

    @FXML
    private void btnDeleteActionPerformed(ActionEvent event) {
        PackageDTO selectedItem = tblPackage.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Do you want to Delete this Package from your System?");
        alert.setContentText("Press Ok to Delete or Cancel to Cancel Deletion");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if (!showAndWait.isPresent()) {

        } else if (showAndWait.get() == ButtonType.OK) {
            try {
                boolean deletePackage = PackageMethodController.deletePackage(selectedItem.getPackage_ID());
                if (deletePackage) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setHeaderText("Package Deleted Succesfully");
                    alert1.setContentText("Package deleted, Keep Going");
                    alert1.showAndWait();
                    txtPackageID.getText();
                    ArrayList<PackageDTO> loadPackages = PackageMethodController.loadPackages();
                    tblPackage.setItems(FXCollections.observableArrayList(loadPackages));
                }
            } catch (Exception ex) {
                Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (showAndWait.get() == ButtonType.CANCEL) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText("Package Deletion Cancelled");
            alert1.setContentText("Package not deleted");
            alert1.showAndWait();
            txtPackageID.getText();
        }
    }

    @FXML
    private void btnReloadActionPerformed(ActionEvent event) throws Exception {
        ArrayList<PackageDTO> loadPackages = PackageMethodController.loadPackages();
        tblPackage.setItems(FXCollections.observableArrayList(loadPackages));
    }

    @FXML
    private void btnUpdateActionPerformed(ActionEvent event) {
        try {
            if (Pattern.compile("(P-){1}[0-9]{3}$").matcher(txtPackageID.getText()).matches()) {
                if (Pattern.compile("[A-z ]{4,30}$").matcher(txtPackageName.getText()).matches()) {
                    if (Pattern.compile("[A-z0-9 ]{4,100}$").matcher(txtPackageDetails.getText()).matches()) {
                        if (Pattern.compile("[0-9]{3,10}(.)[0-9]{0,2}$").matcher(txtPackagePrice.getText()).matches()) {
                            double price = Double.parseDouble(txtPackagePrice.getText());
                            //
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setHeaderText("Do you want to Update this Package?");
                            alert.setContentText("Press Ok to UPDATE or Cancel to Cancel UPDATE");
                            Optional<ButtonType> showAndWait = alert.showAndWait();
                            if (!showAndWait.isPresent()) {

                            } else if (showAndWait.get() == ButtonType.OK) {
                                try {
                                    boolean updatePackage = PackageMethodController.updatePackage(new PackageDTO(txtPackageID.getText(), txtPackageName.getText(), txtPackageDetails.getText(), price));
                                    if (updatePackage) {
                                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                        alert1.setHeaderText("Package UPDATED Succesfully");
                                        alert1.setContentText("Package updated, Keep Going");
                                        alert1.showAndWait();
                                        txtPackageID.getText();
                                        ArrayList<PackageDTO> loadPackages = PackageMethodController.loadPackages();
                                        tblPackage.setItems(FXCollections.observableArrayList(loadPackages));
                                    }
                                } catch (Exception ex) {
                                    Logger.getLogger(PackageController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            } else if (showAndWait.get() == ButtonType.CANCEL) {
                                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                alert1.setHeaderText("Package not been UPDATED");
                                alert1.setContentText("Package not UPDATED, keep Going");
                                alert1.showAndWait();
                                txtPackageID.getText();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText("Invalid Value near Package Price " + txtPackagePrice.getText());
                            alert.setContentText("Please follow the correct syntax : Example: 55200 or 55200.36");
                            alert.setResizable(false);
                            alert.showAndWait();
                            txtPackagePrice.requestFocus();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Invalid Value near Details " + txtPackageDetails.getText());
                        alert.setContentText("Please follow the correct syntax : package details(maximum characters 100)");
                        alert.setResizable(false);
                        alert.showAndWait();
                        txtPackageDetails.requestFocus();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Invalid Value near Package Name " + txtPackageName.getText());
                    alert.setContentText("Please follow the correct syntax : package nam(maximum charaters 30)");
                    alert.setResizable(false);
                    alert.showAndWait();
                    txtPackageName.requestFocus();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Value near ID " + txtPackageID.getText());
                alert.setContentText("Please follow the correct syntax : Example :P-001");
                alert.setResizable(false);
                alert.showAndWait();
                txtPackageID.requestFocus();
            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No values for Fields");
            alert.setContentText("Please fill the Values to Continue");
            alert.setResizable(false);
            alert.showAndWait();
            txtPackageID.requestFocus();
        }

    }

    @FXML
    private void tblPackageMouseClicked(MouseEvent event) {
        PackageDTO selectedItem = tblPackage.getSelectionModel().getSelectedItem();
        txtPackageID.setText(selectedItem.getPackage_ID());
        txtPackageName.setText(selectedItem.getPackage_Name());
        txtPackageDetails.setText(selectedItem.getPackage_Details());
        txtPackagePrice.setText(selectedItem.getPackage_Price() + "");
    }

}
