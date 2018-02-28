/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.controller;

import com.vernanda.dao.BarangDaoImpl;
import com.vernanda.dao.Detail_transaksiDaoImpl;
import com.vernanda.dao.TransaksiDaoImpl;
import com.vernanda.entity.Barang;
import com.vernanda.entity.Detail_transaksi;
import com.vernanda.entity.Table;
import com.vernanda.entity.Transaksi;
import com.vernanda.entity.User;
import com.vernanda.utility.Utility;
import java.net.URL;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private TableView<Table> tabelTransaksi;
    @FXML
    private TableColumn<Table, String> colKdBarang;
    @FXML
    private TableColumn<Table, String> colNamaBarang;
    @FXML
    private TableColumn<Table, String> colHarga;
    @FXML
    private TableColumn<Table, String> colJumlah;
    @FXML
    private TableColumn<Table, String> colTotHar;
    @FXML
    private Button btnAddTable;

    private MenuController menuController;
    private LoginController loginController;
    private ObservableList<Barang> barangs;
    private BarangDaoImpl barangDao;
    @FXML
    private TextField txtTotalharga;
    @FXML
    private TextField txtPembayaran;
    @FXML
    private TextField txtKembalian;
    @FXML
    private TextField txtId_Kasir;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
        System.out.println(this.menuController);
        tabelTransaksi.setItems(getTables());
        cmbKodeBrng.setItems(getBarangs());
        txtId_Kasir.setText(String.valueOf(menuController.getSelectedUser().
                getIdUser()));
        txtNamaKasir.setText(menuController.getSelectedUser().getNama());
        txtNoTrans.setText(String.valueOf(getTransaksis().size() + 1));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cmbKodeBrng.setItems(getBarangs());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();

        colKdBarang.setCellValueFactory((
                TableColumn.CellDataFeatures<Table, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getKd_barang())));

        colNamaBarang.setCellValueFactory((
                TableColumn.CellDataFeatures<Table, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getNama_brng())));

        colHarga.setCellValueFactory((
                TableColumn.CellDataFeatures<Table, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getSaling_price())));

        colJumlah.setCellValueFactory((
                TableColumn.CellDataFeatures<Table, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getJumlah())));

        colTotHar.setCellValueFactory((
                TableColumn.CellDataFeatures<Table, String> param)
                -> new SimpleStringProperty(String.valueOf(param.getValue().
                        getSaling_price() * param.getValue().getJumlah())));

        txtTglTrans.setText(dateFormat.format(date));

        txtNoTrans.setText("");
//        btnHapus.setDisable(true);
        tabelTransaksi.setItems(getTables());
        tabelTransaksi.refresh();
    }

    //hapus dari tabel per baris
    @FXML
    private void btnHapusOnAction(ActionEvent event) {
        if (selectedTable != null) {
            tables.remove(selectedTable);
            getTransaksi().setPembayaran(0);
            for (Table t : tables) {
                getTransaksi().setPembayaran(getTransaksi().getPembayaran() + t.
                        getJumlah() * t.getSaling_price());
            }
            txtTotalharga.
                    setText(String.valueOf(getTransaksi().getPembayaran()));

            btnHapus.setDisable(true);

            selectedTable = null;
        }
    }

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

    //cuma yg buat ke table, bukan ke databes
    private ObservableList<Table> tables;

    public ObservableList<Table> getTables() {
        if (tables == null) {
            tables = FXCollections.observableArrayList();
        }
        return tables;
    }

    private ObservableList<Transaksi> transaksis;
    private TransaksiDaoImpl transaksiDao;

    public TransaksiDaoImpl getTransaksiDao() {
        if (transaksiDao == null) {
            transaksiDao = new TransaksiDaoImpl();
        }
        return transaksiDao;
    }
    private Detail_transaksiDaoImpl detail_transaksiDaoImpl;

    public Detail_transaksiDaoImpl getDetail_transaksiDao() {
        if (detail_transaksiDaoImpl == null) {
            detail_transaksiDaoImpl = new Detail_transaksiDaoImpl();
        }
        return detail_transaksiDaoImpl;
    }

    public ObservableList<Transaksi> getTransaksis() {
        if (transaksis == null) {
            transaksis = FXCollections.observableArrayList();
            transaksis.addAll(getTransaksiDao().showAllData());
        }
        return transaksis;
    }

    private Transaksi transaksi;

    public Transaksi getTransaksi() {
        if (transaksi == null) {
            transaksi = new Transaksi();
            transaksi.setNo_transaksi(
                    getTransaksiDao().
                    showAllData().size() + 1);
            transaksi.setPembayaran(0);
        }
        return transaksi;
    }

    //SubmitOnAction
    @FXML
    private void btnSubmitOnAction(ActionEvent event) {
        if (!tables.isEmpty()) {
            if (Utility.isNumber(txtPembayaran.getText())) {
                if (Integer.valueOf(txtPembayaran.getText()) >= Integer.valueOf(
                        txtTotalharga.getText())) {

                    getTransaksi().setNo_transaksi(Integer.valueOf(txtNoTrans.
                            getText().trim()));
                    getTransaksi().setPembayaran(Integer.valueOf(
                            txtTotalharga.getText().trim()));
                    getTransaksi().setUser_Id_user(new User(
                            txtId_Kasir.getText().
                            trim()));

                    getTransaksiDao().addData(getTransaksi());

                    for (Table t : tables) {
                        Detail_transaksi detail_transaksi
                                = new Detail_transaksi();

                        detail_transaksi.setTransaksi_No_transaksi(
                                getTransaksi());
                        detail_transaksi.setBarang_Kd_barang(new Barang(t.
                                getKd_barang()));
                        detail_transaksi.setJumlah(t.getJumlah());
                        detail_transaksi.setSaling_price(t.getSaling_price());

                        getDetail_transaksiDao().addData(detail_transaksi);

                    }

                    txtKembalian.setText(String.valueOf((Utility.StoI(
                            txtPembayaran.getText()) - Utility.StoI(
                                    txtTotalharga.getText()))));

                    Utility.showAlert("Infomasi", "Kembalian : Rp" + (Utility.
                            StoI(
                                    txtPembayaran.getText()) - Utility.StoI(
                                    txtTotalharga.getText())),
                            Alert.AlertType.INFORMATION);

                    setTransaksi(null);

                    tables.clear();

                    txtTotalharga.setText("");
                    txtJumlah.setText("");
                    txtKembalian.setText("");
                    txtPembayaran.setText("");

                    cmbKodeBrng.setValue(null);

//                    txtId_Kasir.setText(String.valueOf(
//                            menuController.getSelectedUser().
//                            getIdUser()));
//                    txtNamaKasir.setText(menuController.getSelectedUser().
//                            getNama());
                    getTransaksis().clear();
                    getTransaksis().addAll(getTransaksiDao().showAllData());

                    txtNoTrans.setText(String.
                            valueOf(getTransaksis().size() + 1));

                    DateFormat dateFormat = new SimpleDateFormat(
                            "dd/MM/yyyy HH:mm");
                    Date date = new Date();

                    txtTglTrans.setText(dateFormat.format(date));

                } else {
                    Utility.showAlert("Error", "Uang tidak cukup",
                            Alert.AlertType.ERROR);
                }
            }

        }
    }

    //AddtoCart
    @FXML
    private void btnAddTableOnAction(ActionEvent event) {
        if (!Utility.isEmptyField(txtTglTrans, txtId_Kasir, txtNamaKasir,
                txtNoTrans,
                txtJumlah) && cmbKodeBrng != null) {
            if (Utility.isNumber(txtJumlah.getText())) {
                Table tab = new Table();

                tab.setKd_barang(cmbKodeBrng.getValue().getKd_barang());
                tab.setNama_brng(cmbKodeBrng.getValue().getNama_brng());
                tab.setJumlah(Integer.valueOf(txtJumlah.getText().trim()));
                tab.setSaling_price(Integer.valueOf(cmbKodeBrng.getValue().
                        getHarga()));

                boolean ganda = false;

//                for (Table t : tables) {
//                    if (cmbKodeBrng.getValue().getNama_brng().equals(t.
//                            getNama_brng())) {
//                        ganda = true;
//                        t.setJumlah(t.getJumlah() + Integer.valueOf(txtJumlah.
//                                getText()));
//                        tabelTransaksi.refresh();
//                    }
//                }
//                if (!ganda) {
//
//                    getTables().add(tab);
//                }
                getTables().add(tab);
                getTransaksi().setPembayaran(0);
                for (Table t : tables) {

                    getTransaksi().setPembayaran(getTransaksi().getPembayaran()
                            + t.getJumlah() * t.getSaling_price());
                }
                txtTotalharga.setText(String.valueOf(getTransaksi().
                        getPembayaran()));
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Isi semua terlebih dahulu");
            alert.showAndWait();
        }
    }

    //hapus keseluruhan
    @FXML
    private void btnCancelOnAction(ActionEvent event) {
        setTransaksi(null);

        tables.clear();

        txtTotalharga.setText("");
        txtJumlah.setText("");
        txtKembalian.setText("");
        txtPembayaran.setText("");

        cmbKodeBrng.setValue(null);

//        txtId_Kasir.setText(String.valueOf(menuController.getSelectedUser().
//                getIdUser()));
//        txtNamaKasir.setText(menuController.getSelectedUser().getNama());
        getTransaksis().clear();
        getTransaksis().addAll(getTransaksiDao().showAllData());

        txtNoTrans.setText(String.valueOf(getTransaksis().size() + 1));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date ddate = new Date();

        txtTglTrans.setText(dateFormat.format(ddate));
    }

    public Table selectedTable;

    @FXML
    private void tableTableOnClicked(MouseEvent event) {
        selectedTable = tabelTransaksi.getSelectionModel().getSelectedItem();
        if (selectedTable != null) {
            btnHapus.setDisable(false);
        }
    }

    private void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    void setLoginController(LoginController loginController) {
        this.loginController = loginController;
        txtId_Kasir.setText(String.
                valueOf(loginController.getUser().getIdUser()));
        txtNamaKasir.setText(String.
                valueOf(loginController.getUser().getNama()));

        txtNoTrans.setText(String.valueOf(getTransaksi().getNo_transaksi()));
    }

}
