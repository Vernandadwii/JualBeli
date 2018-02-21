/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.dao.UserDaoImpl;
import com.vernanda.entity.User;
import com.vernanda.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

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
    private TableView<User> tabelAddUser;
    @FXML
    private RadioButton perempuan;
    @FXML
    private RadioButton laki;
    @FXML
    private TableColumn<User, Integer> id_user;
    @FXML
    private TableColumn<User, String> nama;
    @FXML
    private TableColumn<User, Integer> j_kelamin;
    @FXML
    private TableColumn<User, String> alamat;
    private MenuController menuController;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ToggleGroup jeniskel;
    public User selectedUser;

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

    public ObservableList<User> getUser() {
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

    public void setMainController(MenuController menuController) {

    }

    @FXML
    private void btnTambahOnAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtPassword, txtNama, txtAlamat)) {
            User user = new User();
            user.setPassword(txtPassword.getText().trim());
            user.setNama(txtNama.getText().trim());
            user.setAlamat(txtAlamat.getText().trim());
            if (jeniskel.getSelectedToggle().equals("perempuan")) {
                user.setJ_kelamin(1);
            } else if (jeniskel.getSelectedToggle().equals("laki")) {
                user.setJ_kelamin(2);
            }

            if (getUserDao().addData(user) == 1) {
                getUser().clear();
                getUser().addAll(getUserDao().showAllData());
            }
            txtPassword.clear();
            txtNama.clear();
            txtAlamat.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Masih ada yang kosong");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnUbahOnAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtPassword, txtNama, txtAlamat)) {
            User user = new User();
            user.setId_user(selectedUser.getId_user());
            user.setNama(txtNama.getText().trim());
            user.setPassword(txtPassword.getText().trim());
            user.setAlamat(txtAlamat.getText().trim());
            if (getUserDao().updateData(user) == 1) {
                getUserDao().updateData(user);
                getUser().clear();
                getUser().addAll(getUserDao().showAllData());

                tabelAddUser.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Silahkan ketik ulang");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnHapusOnAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtPassword, txtNama, txtAlamat)) {
            User user = new User();
            user.setId_user(selectedUser.getId_user());
            user.setNama(txtNama.getText().trim());
            user.setPassword(txtPassword.getText().trim());
            user.setAlamat(txtAlamat.getText().trim());
            if (getUserDao().deleteData(user) == 1) {
                getUserDao().deleteData(user);
                getUser().clear();
                getUser().addAll(getUserDao().showAllData());

                tabelAddUser.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Silahkan ketik ulang");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnBackOnAction(ActionEvent event) {
    }

    @FXML
    private void tableAddOwnerOnClick(MouseEvent event) {
        selectedUser = tabelAddUser.getSelectionModel().getSelectedItem();
        btnHapus.setDisable(false);

        if (selectedUser != null) {
            txtNama.setText(selectedUser.getNama());
            txtPassword.setText(String.valueOf(selectedUser.getPassword()));
            txtAlamat.setText(String.valueOf(selectedUser.getAlamat()));

            System.out.println(selectedUser.getNama());

        }
    }

}
