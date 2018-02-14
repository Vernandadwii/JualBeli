/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AsusPC
 */
public class Transaksi {

    private final StringProperty no_transaksi = new SimpleStringProperty();

    public String getNo_transaksi() {
        return no_transaksi.get();
    }

    public void setNo_transaksi(String value) {
        no_transaksi.set(value);
    }

    public StringProperty no_transaksiProperty() {
        return no_transaksi;
    }
    private final IntegerProperty User_Id_user = new SimpleIntegerProperty();

    public int getUser_Id_user() {
        return User_Id_user.get();
    }

    public void setUser_Id_user(int value) {
        User_Id_user.set(value);
    }

    public IntegerProperty User_Id_userProperty() {
        return User_Id_user;
    }

//    String no_transaksi;
//    Timestamp tgl_transaksi;
//    int harga;
//    int User_Id_user;
//
//    public String getNo_transaksi() {
//        return no_transaksi;
//    }
//
//    public Timestamp getTgl_transaksi() {
//        return tgl_transaksi;
//    }
//
//    public int getHarga() {
//        return harga;
//    }
//
//    public int getUser_Id_user() {
//        return User_Id_user;
//    }
//
//    public void setNo_transaksi(String No_transaksi) {
//        this.no_transaksi = No_transaksi;
//    }
//
//    public void setTgl_transaksi(Timestamp tgl_transaksi) {
//        this.tgl_transaksi = tgl_transaksi;
//    }
//
//    public void setHarga(int harga) {
//        this.harga = harga;
//    }
//
//    public void setUser_Id_user(int User_Id_user) {
//        this.User_Id_user = User_Id_user;
//    }
    private final IntegerProperty harga = new SimpleIntegerProperty();

    public int getHarga() {
        return harga.get();
    }

    public void setHarga(int value) {
        harga.set(value);
    }

    public IntegerProperty hargaProperty() {
        return harga;
    }

}
