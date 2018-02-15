/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("asddd33dssss");
        System.out.println("asdasdasdsadsadsad");
        System.out.println("hasdsadsadsadsadsad");
        // TODO
    }

    @FXML
    private void btnAddBarangOnAction(ActionEvent event) {
    }

    @FXML
    private void btnAddUserOnAction(ActionEvent event) {
    }

    @FXML
    private void btnLaporanOnAction(ActionEvent event) {
    }

}
