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
public class User {

    int Id_user;
    String password;
    String nama;
    String alamat;
    int Role_idRole;

    public int getId_user() {
        return Id_user;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getRole_idRole() {
        return Role_idRole;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setRole_idRole(int Role_idRole) {
        this.Role_idRole = Role_idRole;
    }

}
