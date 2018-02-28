/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//vernandaDwi(1672001)
package com.vernanda.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author AsusPC
 */
public class Detail_transaksi {

    private final ObjectProperty<Transaksi> transaksi_No_transaksi
            = new SimpleObjectProperty<>();
    private final ObjectProperty<Barang> barang_Kd_barang
            = new SimpleObjectProperty<>();
    private final IntegerProperty jumlah = new SimpleIntegerProperty();
    private final IntegerProperty saling_price = new SimpleIntegerProperty();

    public Transaksi getTransaksi_No_transaksi() {
        return transaksi_No_transaksi.get();
    }

    public void setTransaksi_No_transaksi(Transaksi value) {
        transaksi_No_transaksi.set(value);
    }

    public ObjectProperty transaksi_No_transaksiProperty() {
        return transaksi_No_transaksi;
    }

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int value) {
        jumlah.set(value);
    }

    public IntegerProperty jumlahProperty() {
        return jumlah;
    }

    public int getSaling_price() {
        return saling_price.get();
    }

    public void setSaling_price(int value) {
        saling_price.set(value);
    }

    public IntegerProperty saling_priceProperty() {
        return saling_price;
    }

    public Barang getBarang_Kd_barang() {
        return barang_Kd_barang.get();
    }

    public void setBarang_Kd_barang(Barang value) {
        barang_Kd_barang.set(value);
    }

    public ObjectProperty barang_Kd_barangProperty() {
        return barang_Kd_barang;
    }

}
