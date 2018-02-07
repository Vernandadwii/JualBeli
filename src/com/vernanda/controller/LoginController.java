/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.MainApp;
import com.vernanda.dao.UserDaoImpl;
import com.vernanda.entity.Role;
import com.vernanda.entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AsusPC
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtIdUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private BorderPane bpLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLoginOnAction(ActionEvent event) {
        User user = new User();
        user.setId_user(txtIdUser.getText());
        user.setPassword(txtPassword.getText());
        if (getUserDao().getData(user) != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login Anda berhasil");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();

            Role role = user.getRole_idRole();

            //pembeda owner atau kasir
            loader.setLocation(MainApp.class.getResource(view / Login.fxml));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Login");
            secondStage.show();

            //tutup login stage
            bpLogin.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(
                    "Username atau password yang anda masukkan salah !");
            alert.showAndWait();
        }
    }

    public UserDaoImpl getUserDao() {
        if (getUserDao == null) {
            getUserDao() = new UserDaoImpl();
        }
        return getUserDao();
    }

    private ObservableList<User> users;

    public ObservableList<User> getUser() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
    }
}
