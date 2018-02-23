/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.dao.BarangDaoImpl;
import com.vernanda.entity.Barang;
import com.vernanda.entity.Detail_transaksi;
import com.vernanda.entity.Transaksi;
import com.vernanda.entity.User;
import com.vernanda.utility.Utility;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AsusPC
 */
public class TransaksiController implements Initializable {

    @FXML
    private TextField txtNamaKasir;
    @FXML
    private ComboBox<Barang> cmbKodeBrng;
    private TextField txtHarga;
    @FXML
    private TextField txtJumlah;
    @FXML
    private TextField txtNoTrans;
    @FXML
    private TextField txtTglTrans;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnSubmit;
    @FXML
    private TableColumn<Detail_transaksi, String> colKdBarang;
    @FXML
    private TableColumn<Detail_transaksi, String> colNamaBarang;
    @FXML
    private TableColumn<Detail_transaksi, String> colHarga;
    @FXML
    private TableColumn<Detail_transaksi, String> colJumlah;
    @FXML
    private TableColumn<Detail_transaksi, String> colTotHar;
    @FXML
    private Button btnAddTable;
    @FXML
    private TableView<Detail_transaksi> tabelTransaksi;
    private MenuController menuController;
    private ObservableList<Barang> barangs;
    private BarangDaoImpl barangDao;
    @FXML
    private TextField txtTotalharga;
    @FXML
    private TextField txtPembayaran;
    @FXML
    private TextField txtKembalian;

    /**
     * Initializes the controller class.
     */
    public ObservableList<Barang> getBarangs() {
        if (barangs == null) {
            barangs = FXCollections.observableArrayList();
            barangs.addAll(getBarangDao().showAllData());
        }
        return barangs;
    }

    public BarangDaoImpl getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImpl();
        }
        return barangDao;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cmbKodeBrng.setItems(getBarangs());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();

        colKdBarang.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_transaksi, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        barang_Kd_barangProperty().Kd_barangProperty()) + param.
                        getValue().getBarang_Kd_barang().
                        getNama_brng()
                ));

        colNamaBarang.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_transaksi, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getBarang_Kd_barang().getNama_brng())));

        colHarga.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_transaksi, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getSaling_price())));

        colJumlah.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_transaksi, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getJumlah())));

        colTotHar.setCellValueFactory((
                TableColumn.CellDataFeatures<Detail_transaksi, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getSaling_price() * param.getValue().getJumlah())));

        txtTglTrans.setText(dateFormat.format(date));
//        txtIdKasir.setText(i_homeController.getSelectedUser().
//                getUsername_access());
//        txtNamaKasir.setText(i_homeController.getSelectedUser().getNm_User());
        txtNoTrans.setText("");
//        txtTotalBelanja.setText(Integer.valueOf());
//        txtKembalian.setText(Integer.valueOf());

    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
        tabelTransaksi.setItems(menuController.getTransaksis());
    }

    @FXML
    private void btnHapusOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSubmitOnAction(ActionEvent event) {

    }

    @FXML
    private void btnAddTableOnAction(ActionEvent event) {
        if (!Utility.isEmptyField(txtNoTrans, txtTglTrans, txtNamaKasir,
                txtJumlah, txtTotalharga, txtPembayaran, txtKembalian)) {
            Detail_transaksi detail_transaksi = new Detail_transaksi();
            Transaksi transaksi = new Transaksi();
            User user = new User();
            transaksi.setNo_transaksi(txtNoTrans.getText().
                    trim());
            transaksi.setTgl_transaksi(Timestamp.valueOf(txtTglTrans.
                    getText().trim()));
            user.setNama(txtNamaKasir.getText().trim());
            detail_transaksi.setJumlah(Integer.valueOf(txtJumlah.getText().
                    trim()));
            transaksi.setPembayaran(Integer.valueOf(txtPembayaran.getText().
                    trim()));

        }

    }

}
