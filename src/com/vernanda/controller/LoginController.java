/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.MainApp;
import com.vernanda.dao.UserDaoImpl;
import com.vernanda.entity.User;
import java.io.IOException;
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

    public UserDaoImpl getUserDaoImpl() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    private ObservableList<User> users;

    public ObservableList<User> getUser() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }

    private UserDaoImpl userDao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLoginOnAction(ActionEvent event) throws IOException {
        User user = new User();
        user.setId_user(Integer.valueOf(txtIdUser.getText()));
        user.setPassword(txtPassword.getText());
        if (txtIdUser.getText().trim().isEmpty()
                || txtPassword.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Login Anda berhasil");
            alert.showAndWait();
        } else if (getUserDao().getData(user) != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login berhasil");
            alert.showAndWait();
            FXMLLoader loader = new FXMLLoader();

//            Role role = user.getRole_idRole();
            //pembeda owner atau kasir
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
            BorderPane pane = loader.load();
            getMenuController();
            MenuController.setRole(getUserDao().getData(user).getRole_idRole());
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
        Object UserDao = null;
        if (UserDao == null) {
            UserDao = new UserDaoImpl();
        }
        UserDaoImpl userDao = null;
        return userDao;
    }

    private ObservableList<User> user;

    public ObservableList<User> getUsers() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }

    private void getMenuController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
