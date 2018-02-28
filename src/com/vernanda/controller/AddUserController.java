/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//vernandaDwi(1672001)
package com.vernanda.controller;

import com.vernanda.dao.UserDaoImpl;
import com.vernanda.entity.Role;
import com.vernanda.entity.User;
import com.vernanda.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private TableColumn<User, String> j_kelamin;
    @FXML
    private TableColumn<User, String> alamat;
    private MenuController menuController;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ToggleGroup jeniskel;
    public User selectedUser;
    @FXML
    private TableColumn<User, String> satus;
    @FXML
    private ComboBox<Role> cmbStatus;

    private Stage userStage;
    private UserDaoImpl userDao;

    public Role selectedRole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        id_user.setCellValueFactory(p -> p.getValue().idUserProperty().
                asObject());
        nama.setCellValueFactory(p -> p.getValue().namaProperty());
        j_kelamin.
                setCellValueFactory(
                        new Callback<TableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            TableColumn.CellDataFeatures<User, String> param) {
                        User u = (User) param.getValue();
                        if (u.getjKelamin() == 1) {
                            return new SimpleStringProperty("Perempuan");
                        } else {
                            return new SimpleStringProperty("Laki-laki");
                        }
                    }
                });
        alamat.
                setCellValueFactory(p -> p.getValue().alamatProperty());
        satus.
                setCellValueFactory((
                        TableColumn.CellDataFeatures<User, String> param)
                        -> new SimpleStringProperty(param.getValue().getRole().
                                getKeterangan()));
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
        tabelAddUser.setItems(menuController.getUser());

        cmbStatus.setItems(menuController.getRoles());
    }

    @FXML
    private void btnTambahOnAction(ActionEvent event) {
//        Utility utility = new Utility();
        if (!Utility.isEmptyField(txtNama, txtPassword, txtAlamat)) {
            User user = new User();
            Role role = new Role();
            user.setNama(txtNama.getText().trim());
            user.setPassword(txtPassword.getText().trim());

//            StringProperty jenis = null;
            if (perempuan.isSelected()) {
                user.setjKelamin(1);
//                jenis.setValue();
            } else {
                user.setjKelamin(2);
//                jenis.setValue("L");
            }
//            user.setJ_kelamin(jenis);
            user.setAlamat(txtAlamat.getText().trim());
            role.setIdRole(cmbStatus.getValue().getIdRole());
            role.setKeterangan(cmbStatus.getValue().getKeterangan());
            user.setRole(role);

            if (txtPassword.getText().equals(txtPassword.getText())) {
                if (menuController.getUserDao().addData(user) == 1) {
                    menuController.getUser().clear();
                    menuController.getUser().addAll(menuController.getUserDao().
                            showAllData());

                    tabelAddUser.refresh();

                    txtNama.clear();
                    txtPassword.clear();
                    txtAlamat.clear();
                    cmbStatus.setValue(null);
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Pass tidak sama, isi lagi!");
                alert.showAndWait();
                txtPassword.clear();

            }
        }
    }

    @FXML
    private void btnUbahOnAction(ActionEvent event) {
//        Utility utility = new Utility();
        if (!Utility.isEmptyField(txtNama, txtPassword, txtAlamat)) {
            selectedUser.setNama(txtNama.getText().trim());
            selectedUser.setPassword(txtPassword.getText().trim());
            if (perempuan.isSelected()) {
                selectedUser.setjKelamin(1);
//                jenis.setValue();
            } else {
                selectedUser.setjKelamin(2);
//                jenis.setValue("L");
            }
            selectedUser.setAlamat(txtAlamat.getText().trim());
            selectedUser.setRole(cmbStatus.getValue());

            if (menuController.getUserDao().updateData(selectedUser) == 1) {
                menuController.getUser().clear();
                menuController.getUser().addAll(menuController.getUserDao().
                        showAllData());

                tabelAddUser.refresh();
            }
            txtNama.clear();
            txtPassword.clear();
            txtAlamat.clear();

            selectedUser = null;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Silahkan ketik ulang");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnHapusOnAction(ActionEvent event) {
//        Utility utility = new Utility();
        if (!Utility.isEmptyField(txtNama, txtPassword, txtAlamat)) {
//            User user = new User();
            selectedUser.setNama(txtNama.getText().trim());
            selectedUser.setPassword(txtPassword.getText().trim());

            if (perempuan.isSelected()) {
                selectedUser.setjKelamin(1);
//                jenis.setValue();
            } else {
                selectedUser.setjKelamin(2);
//                jenis.setValue("L");
            }
            selectedUser.setAlamat(txtAlamat.getText().trim());
            selectedUser.setRole(cmbStatus.getValue());

            if (menuController.getUserDao().deleteData(selectedUser) == 1) {
                menuController.getUser().clear();
                menuController.getUser().addAll(menuController.getUserDao().
                        showAllData());

                tabelAddUser.refresh();

                txtNama.clear();
                txtPassword.clear();
                txtAlamat.clear();
                cmbStatus.setValue(null);
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
            cmbStatus.setValue(selectedUser.getRole());
        }
    }

}
