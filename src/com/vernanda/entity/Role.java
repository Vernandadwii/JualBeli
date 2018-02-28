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
public class Role {

    private final IntegerProperty idRole = new SimpleIntegerProperty();
    private final StringProperty keterangan = new SimpleStringProperty();

    public int getIdRole() {
        return idRole.get();
    }

    public void setIdRole(int value) {
        idRole.set(value);
    }

    public IntegerProperty idRoleProperty() {
        return idRole;
    }

    public String getKeterangan() {
        return keterangan.get();
    }

    public void setKeterangan(String value) {
        keterangan.set(value);
    }

    public StringProperty keteranganProperty() {
        return keterangan;
    }

    @Override
    public String toString() {
        return getKeterangan();
    }

}
