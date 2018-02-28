/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//vernandaDwi(1672001)
package com.vernanda.controller;

import com.vernanda.MainApp;
import com.vernanda.dao.UserDaoImpl;
import com.vernanda.entity.Transaksi;
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
    private User user;
    private Transaksi transaksi;

    public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    private ObservableList<User> users;

    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return user;
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
        user.setIdUser(Integer.valueOf(txtIdUser.getText()));
        user.setPassword(txtPassword.getText());

        if (getUserDao().getData(user) != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Login berhasil");
            alert.showAndWait();
            setUser(getUserDao().getData(user));

            if (getUserDao().getData(user).getRole().getIdRole() == 1) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/Menu.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);
                Stage seconstaStage = new Stage();
                seconstaStage.setScene(scene);
                seconstaStage.setTitle("Menu Owner");
                seconstaStage.show();
            } else if (getUserDao().getData(user).getRole().getIdRole()
                    == 2) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.
                        getResource("view/Transaksi.fxml"));
                BorderPane pane = loader.load();
                TransaksiController transaksi = loader.getController();
                transaksi.setLoginController(this);
                Scene scene = new Scene(pane);
                Stage seconstaStage = new Stage();
                seconstaStage.setScene(scene);
                seconstaStage.setTitle("Kasir Form");
                seconstaStage.show();
            }
            //close login stage
            bpLogin.getScene().getWindow().hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Id user atau password salah");
            alert.showAndWait();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ObservableList<User> getUsers() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }

}
