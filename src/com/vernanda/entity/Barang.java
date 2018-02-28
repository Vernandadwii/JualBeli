/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//vernandaDwi(1672001)
package com.vernanda.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AsusPC
 */
public class Barang {

    private final IntegerProperty Kd_barang = new SimpleIntegerProperty();
    private final IntegerProperty harga = new SimpleIntegerProperty();
    private final IntegerProperty harga_modal = new SimpleIntegerProperty();
    private final IntegerProperty jumlah = new SimpleIntegerProperty();
    private final StringProperty nama_brng = new SimpleStringProperty();

    public Barang(int Kd_barang) {
        this.setKd_barang(Kd_barang);
    }

    public Barang() {

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

    public int getKd_barang() {
        return Kd_barang.get();
    }

    public void setKd_barang(int value) {
        Kd_barang.set(value);
    }

    public IntegerProperty Kd_barangProperty() {
        return Kd_barang;
    }

    public String getNama_brng() {
        return nama_brng.get();
    }

    public void setNama_brng(String value) {
        nama_brng.set(value);
    }

    public StringProperty nama_brngProperty() {
        return nama_brng;
    }

    public int getHarga() {
        return harga.get();
    }

    public void setHarga(int value) {
        harga.set(value);
    }

    public IntegerProperty hargaProperty() {
        return harga;
    }

    public int getHarga_modal() {
        return harga_modal.get();
    }

    public void setHarga_modal(int value) {
        harga_modal.set(value);
    }

    public IntegerProperty harga_modalProperty() {
        return harga_modal;
    }

    @Override
    public String toString() {
        return String.valueOf(getKd_barang()) + "-" + getNama_brng();
    }
}
