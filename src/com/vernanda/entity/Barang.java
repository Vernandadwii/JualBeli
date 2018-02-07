/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

/**
 *
 * @author AsusPC
 */
public class Barang {

    int Kd_barang;
    String nama_brng;
    int jumlah;
    Double HargaModal;
    Double HargaJual;

    public int getKd_barang() {
        return Kd_barang;
    }

    public String getNama_brng() {
        return nama_brng;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Double getHargaModal() {
        return HargaModal;
    }

    public Double getHargaJual() {
        return HargaJual;
    }

    public void setKd_barang(int Kd_barang) {
        this.Kd_barang = Kd_barang;
    }

    public void setNama_brng(String nama_brng) {
        this.nama_brng = nama_brng;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setHargaModal(Double HargaModal) {
        this.HargaModal = HargaModal;
    }

    public void setHargaJual(Double HargaJual) {
        this.HargaJual = HargaJual;
    }

}
