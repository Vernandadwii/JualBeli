/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

import java.util.Date;

/**
 *
 * @author AsusPC
 */
public class Transaksi {

    String No_transaksi;
    Date tgl_transaksi;
    Double harga;
    Double tot_harga;
    int User_Id_user;

    public String getNo_transaksi() {
        return No_transaksi;
    }

    public Date getTgl_transaksi() {
        return tgl_transaksi;
    }

    public Double getHarga() {
        return harga;
    }

    public Double getTot_harga() {
        return tot_harga;
    }

    public int getUser_Id_user() {
        return User_Id_user;
    }

    public void setNo_transaksi(String No_transaksi) {
        this.No_transaksi = No_transaksi;
    }

    public void setTgl_transaksi(Date tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public void setTot_harga(Double tot_harga) {
        this.tot_harga = tot_harga;
    }

    public void setUser_Id_user(int User_Id_user) {
        this.User_Id_user = User_Id_user;
    }

}
