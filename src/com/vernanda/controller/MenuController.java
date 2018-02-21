/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vernandaaaaa(1672001)
 */
public class MenuController implements Initializable {

    static void setRole(int role_idRole) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @FXML
    private Button btnAddBarang;
    @FXML
    private Button btnAddUser;
    @FXML
    private Button btnLaporan;
    private Stage items;
    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    @FXML
    private void btnAddBarangOnAction(ActionEvent event) {
        try {
            if (items == null) {
                items = new Stage();
                items.setTitle("item Management");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/AddBarang.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                AddBarangController secondLayoutController = loader.
                        getController();
                secondLayoutController.setMainController(this);
                items.setScene(scene);
                items.initOwner(borderPane.getScene().getWindow());
                items.initModality(Modality.WINDOW_MODAL);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (!items.isShowing()) {
            items.show();
        } else {
            items.toFront();
        }
    }

    @FXML
    private void btnAddUserOnAction(ActionEvent event) {
        try {
            if (items == null) {
                items = new Stage();
                items.setTitle("item Management");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/AddUser.fxml"));
                BorderPane root = loader.load();
                Scene scene = new Scene(root);
                AddBarangController secondLayoutController = loader.
                        getController();
                secondLayoutController.setMainController(this);
                items.setScene(scene);
                items.initOwner(borderPane.getScene().getWindow());
                items.initModality(Modality.WINDOW_MODAL);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (!items.isShowing()) {
            items.show();
        } else {
            items.toFront();
        }
    }

    @FXML
    private void btnLaporanOnAction(ActionEvent event) {
    }

}
