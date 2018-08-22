/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitas.AnggotaSimpan;
import org.hibernate.SessionFactory;
import daos.AnggotaSimpanDAO;
import entitas.Akun;
import entitas.Anggota;
import entitas.Simpanan;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author WIN 10
 */

public class AnggotaSimpanController {

    private AnggotaSimpanDAO anggotasimpandao;

    public AnggotaSimpanController() {
    }

    public AnggotaSimpanController(SessionFactory factory) {
        this.anggotasimpandao = new AnggotaSimpanDAO(factory);
    }

    public boolean saveOrEdit(String kdAnggotaSimpan,
            Date tglSimpan, String nominal, String kdAkun, String kdAnggota,
            String kdSimpanan) {
        AnggotaSimpan anggotaSimpan = new AnggotaSimpan(kdAnggotaSimpan,
                tglSimpan,
                Integer.parseInt(nominal),
                new Akun(kdAkun),
                new Anggota(kdAnggota),
                new Simpanan(kdSimpanan));
        return this.anggotasimpandao.insertOrUpdate(anggotaSimpan);
    }

    public List<AnggotaSimpan> getAll() {
        return this.convertToListAnggotaSimpan(this.anggotasimpandao.getAll());
    }

    private List<AnggotaSimpan> convertToListAnggotaSimpan(List<Object> dataAwal) {
        List<AnggotaSimpan> dataAnggotaSimpan = new ArrayList<>();
        for (Object object : dataAwal) {
            AnggotaSimpan anggotaSimpan = (AnggotaSimpan) object;
            dataAnggotaSimpan.add(anggotaSimpan);
        }
        return dataAnggotaSimpan;
    }

    public List<AnggotaSimpan> search(String category, String data) {
        return this.convertToListAnggotaSimpan(this.anggotasimpandao.search(category, data));
    }

    public AnggotaSimpan getById(String kdAnggotaSimpan) {
        return this.anggotasimpandao.getAnggotaSimpanById(kdAnggotaSimpan);
    }
     public String getAutoIdAnggotaSimpan(){
        return this.anggotasimpandao.getKdAutoAnggotaSimpan();
    }

}
