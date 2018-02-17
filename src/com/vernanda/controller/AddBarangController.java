/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.dao.BarangDaoImpl;
import com.vernanda.entity.Barang;
import com.vernanda.utility.Utility;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author AsusPC
 */
public class AddBarangController implements Initializable {

    @FXML
    private TextField txtNamaBarang;
    @FXML
    private TextField txtHargaModal;
    @FXML
    private TextField txtHargaJual;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtJumlah;
    @FXML
    private HBox tableAddBarag;

    private MenuController mainController;

    private ObservableList<Barang> Barangs;
    private BarangDaoImpl barangDao;
    @FXML
    private TableColumn<Barang, Integer> kdBarang;
    @FXML
    private TableColumn<Barang, String> namaBarang;
    @FXML
    private TableColumn<Barang, Integer> jumlah;
    @FXML
    private TableColumn<Barang, Integer> h_modal;
    @FXML
    private TableColumn<Barang, Integer> h_jual;
    @FXML
    private TableView<Barang> tabelAddBarang;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public ObservableList<Barang> getBarang() {
        if (Barangs == null) {
            Barangs = FXCollections.observableArrayList();
            Barangs.addAll(getBarangDao().showAllData());
        }
        return Barangs;
    }

    public BarangDaoImpl getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImpl();
        }
        return barangDao;
    }

    public void setMainController(MenuController mainController) {
        //   categoryDao = new CategoryDaoImpl();

        tabelAddBarang.setItems(getBarang());
        kdBarang.setCellValueFactory(p -> p.getValue().Kd_barangProperty().
                asObject());
        namaBarang.setCellValueFactory(p -> p.getValue().nama_brngProperty());
        jumlah.
                setCellValueFactory(p -> p.getValue().jumlahProperty().
                        asObject());
        h_modal.
                setCellValueFactory(p -> p.getValue().harga_modalProperty().
                        asObject());
        h_jual.setCellValueFactory(p -> p.getValue().hargaProperty().asObject());
    }

    @FXML
    private void btnTambahOnAction(ActionEvent event) {
        Utility utility = new Utility();
        if (!utility.isEmptyField(txtNamaBarang, txtJumlah,
                txtHargaModal, txtHargaJual)) {
            Barang barang = new Barang();
            barang.setNama_brng(txtNamaBarang.getText().trim());
            barang.setJumlah(Integer.valueOf(txtJumlah.getText().trim()));
            barang.setHarga_modal(Integer.
                    valueOf(txtHargaModal.getText().trim()));
            barang.setHarga(Integer.valueOf(txtHargaJual.getText().trim()));
            if (getBarangDao().addData(barang) == 1) {
                getBarang().clear();
                getBarang().addAll(getBarangDao().showAllData());
            }
            txtNamaBarang.clear();
            txtJumlah.clear();
            txtHargaModal.clear();
            txtHargaJual.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Masih ada yang kosong");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnUbahOnAction(ActionEvent event) {
        if (!Utility.isEmptyField(txtNamaBarang, txtJumlah,
                txtHargaModal, txtHargaJual)) {
            Barang barang = new Barang();
            barang.setNama_brng(txtNamaBarang.getText().trim());
            barang.setJumlah(Integer.valueOf(txtJumlah.getText().trim()));
            barang.setHarga_modal(Integer.
                    valueOf(txtHargaModal.getText().trim()));
            barang.setHarga(Integer.valueOf(txtHargaJual.getText().trim()));
            getBarangDao().updateData(barang);
            getBarang().clear();
            getBarang().addAll(getBarangDao().showAllData());
            //mainController.getDepartmentDao().updateData(selectedDepartment);
            //mainController.getDepartments().clear();
            //mainController.getDepartments().addAll(mainController.getDepartmentDao().showAllData());
            //this.resetFieldAndButton();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Silahkan ketik ulang");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnHapusOnAction(ActionEvent event) {
    }

    @FXML
    private void btnBackOnAction(ActionEvent event) {

    }

}
