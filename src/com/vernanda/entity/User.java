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

    private final IntegerProperty idUser = new SimpleIntegerProperty();
    private final StringProperty nama = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty alamat = new SimpleStringProperty();
    private final IntegerProperty jKelamin = new SimpleIntegerProperty();
    private final ObjectProperty<Role> role = new SimpleObjectProperty<>();

    public User(String idUser) {
        this.setIdUser(Integer.valueOf(idUser));
    }

    public User() {

    }

    public int getIdUser() {
        return idUser.get();
    }

    public void setIdUser(int value) {
        idUser.set(value);
    }

    public IntegerProperty idUserProperty() {
        return idUser;
    }

    //nama
    public String getNama() {
        return nama.get();
    }

    public void setNama(String value) {
        nama.set(value);
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String value) {
        alamat.set(value);
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    public int getjKelamin() {
        return jKelamin.get();
    }

    public void setjKelamin(int value) {
        jKelamin.set(value);
    }

    public IntegerProperty jKelaminProperty() {
        return jKelamin;
    }

    public Role getRole() {
        return role.get();
    }

    public void setRole(Role value) {
        role.set(value);
    }

    public ObjectProperty roleProperty() {
        return role;
    }

}
