/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//vernandaDwi(1672001)
package com.vernanda.controller;

import com.vernanda.dao.Detail_transaksiDaoImpl;
import com.vernanda.entity.Detail_transaksi;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author AsusPC
 */
public class LaporanController implements Initializable {

    @FXML
    private Button btnCari;
    @FXML
    private HBox colHarga;
    @FXML
    private ComboBox<?> cmbSortBy;
    @FXML
    private TableColumn<Detail_transaksi, String> colKd_barang;
    @FXML
    private TableColumn<Detail_transaksi, String> colJumlah;
    @FXML
    private TableColumn<Detail_transaksi, String> colTotal;
    @FXML
    private TableColumn<Detail_transaksi, String> colKd_penjualan;
    @FXML
    private TableColumn<Detail_transaksi, String> colId_penjual;
    @FXML
    private TableColumn<Detail_transaksi, Timestamp> colTanggal;
    @FXML
    private TableView<Detail_transaksi> tabelLaporan;
    private ObservableList<Detail_transaksi> laporans;
    @FXML
    private DatePicker datePickerDari;
    @FXML
    private DatePicker datePickerSampai;
    private ObservableList<Detail_transaksi> notaJuals;
    private Detail_transaksiDaoImpl relasiDao;

    /**
     * Initializes the controller class.
     */
    public ObservableList<Detail_transaksi> getNotaPenjualans() {
        if (notaJuals == null) {
            notaJuals = FXCollections.observableArrayList();
            notaJuals.addAll(getDetail_transaksiDao().showAllData());
        }
        return notaJuals;
    }

    public Detail_transaksiDaoImpl getDetail_transaksiDao() {
        if (relasiDao == null) {
            relasiDao = new Detail_transaksiDaoImpl();
        }
        return relasiDao;
    }

    private ObservableList<Detail_transaksi> notaPenjualanPerTahun;

    public ObservableList<Detail_transaksi> getNotaPenjualansByYear() {
        if (notaPenjualanPerTahun == null) {
            notaPenjualanPerTahun = FXCollections.observableArrayList();

        }
        return notaPenjualanPerTahun;
    }

    private ObservableList<String> tahuns;

    public ObservableList<String> getTahuns() {
        if (tahuns == null) {
            tahuns = FXCollections.observableArrayList();

            for (int i = 2018; i >= 2015; i--) {
                tahuns.add(String.valueOf(i));
            }

        }
        return tahuns;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setMainController(MenuController mainController) {
        //   categoryDao = new CategoryDaoImpl();

    }

    @FXML
    private void btnCariOnAction(ActionEvent event) {
    }

    @FXML
    private void datePickerDariOnAction(ActionEvent event) {
    }

    @FXML
    private void datePickerSampaiOnAction(ActionEvent event) {
    }

    @FXML
    private void cmbSortByOnAction(ActionEvent event) {
    }

}
