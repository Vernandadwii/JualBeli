/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

import java.sql.Timestamp;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author AsusPC
 */
//vernandaDwi(1672001)
public class Transaksi {

    private final IntegerProperty no_transaksi = new SimpleIntegerProperty();

    public int getNo_transaksi() {
        return no_transaksi.get();
    }

    public void setNo_transaksi(int value) {
        no_transaksi.set(value);
    }

    public IntegerProperty no_transaksiProperty() {
        return no_transaksi;
    }

    //tglTransaksi
    private final ObjectProperty<Timestamp> tgl_transaksi
            = new SimpleObjectProperty<>();

    public Timestamp getTgl_transaksi() {
        return tgl_transaksi.get();
    }

    public void setTgl_transaksi(Timestamp value) {
        tgl_transaksi.set(value);
    }

    public ObjectProperty tgl_transaksiProperty() {
        return tgl_transaksi;
    }

    //User_id_user
    private final ObjectProperty<User> User_Id_user
            = new SimpleObjectProperty<>();

    public User getUser_Id_user() {
        return User_Id_user.get();
    }

    public void setUser_Id_user(User value) {
        User_Id_user.set(value);
    }

    public ObjectProperty User_Id_userProperty() {
        return User_Id_user;
    }

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

    private final IntegerProperty pembayaran = new SimpleIntegerProperty();

    public int getPembayaran() {
        return pembayaran.get();
    }

    public void setPembayaran(int value) {
        pembayaran.set(value);
    }

    public IntegerProperty pembayaranProperty() {
        return pembayaran;
    }
//
//    public Transaksi() {
//    }

//    public Transaksi(String no_transaksi, Timestamp tgl_transaksi,
//            int pembayaran, int User_Id_user) {
//        this.setNo_transaksi(no_transaksi);
//        this.setTgl_transaksi(tgl_transaksi);
//        this.setPembayaran(pembayaran);
//        this.setUser_Id_user(User_Id_user);
//
//    }
}
