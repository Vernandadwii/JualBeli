/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.dao.UserDaoImpl;
import com.vernanda.entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AsusPC
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField txtNama;
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
    private ObservableList<User> Users;
    private UserDaoImpl userDao;
    @FXML
    private TableView<?> tabelAddUser;
    @FXML
    private TextField txtAlamat1;
    @FXML
    private RadioButton perempuan;
    @FXML
    private RadioButton laki;
    @FXML
    private TableColumn<?, ?> id_user;
    @FXML
    private TableColumn<?, ?> nama;
    @FXML
    private TableColumn<?, ?> j_kelamin;
    @FXML
    private TableColumn<?, ?> alamat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabelAddUser.setItems(getUser());
        id_user.setCellValueFactory(p -> p.getValue().Id_userProperty().
                asObject());
        nama.setCellValueFactory(p -> p.getValue().namaProperty());
        j_kelamin.
                setCellValueFactory(p -> p.getValue().j_kelaminProperty().
                        asObject());
        alamat.
                setCellValueFactory(p -> p.getValue().alamatProperty());

    }

    public ObservableList<User> getUsers() {
        if (Users == null) {
            Users = FXCollections.observableArrayList();
            Users.addAll(getUserDao().showAllData());
        }
        return Users;
    }

    public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public void setMainController(MenuController mainController) {
        //   categoryDao = new CategoryDaoImpl();

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
