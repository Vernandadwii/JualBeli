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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AsusPC
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField txtIdUser;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtKeterangan;
    @FXML
    private TextField txtAlamat;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTambahOnAction(ActionEvent event) {
    }

    @FXML
    private void btnUbahOnAction(ActionEvent event) {
    }

    @FXML
    private void btnHapusOnAction(ActionEvent event) {
    }

    @FXML
    private void btnBackOnAction(ActionEvent event) {
    }

}
