/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AsusPC
 */
public class User {

    private final IntegerProperty Id_user = new SimpleIntegerProperty();

    public int getId_user() {
        return Id_user.get();
    }

    public void setId_user(int value) {
        Id_user.set(value);
    }

    public IntegerProperty Id_userProperty() {
        return Id_user;
    }
    private final IntegerProperty username = new SimpleIntegerProperty();

    public int getUsername() {
        return username.get();
    }

    public void setUsername(int value) {
        username.set(value);
    }

    public IntegerProperty usernameProperty() {
        return username;
    }
    private final StringProperty password = new SimpleStringProperty();

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }
    private final ObjectProperty<Role> Role_idRole
            = new SimpleObjectProperty<>();

    public Role getRole_idRole() {
        return Role_idRole.get();
    }

    public void setRole_idRole(Role value) {
        Role_idRole.set(value);
    }

    public ObjectProperty Role_idRoleProperty() {
        return Role_idRole;
    }

//
//    int Id_user;
//    String nama;
//    int username;
//    String password;
//    int Role_idRole;
//
//    public int getId_user() {
//        return Id_user;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public int getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public int getRole_idRole() {
//        return Role_idRole;
//    }
//
//    public void setId_user(int Id_user) {
//        this.Id_user = Id_user;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    public void setUsername(int username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setRole_idRole(int Role_idRole) {
//        this.Role_idRole = Role_idRole;
//    }
    private final StringProperty nama = new SimpleStringProperty();

    public String getNama() {
        return nama.get();
    }

    public void setNama(String value) {
        nama.set(value);
    }

    public StringProperty namaProperty() {
        return nama;
    }

}
