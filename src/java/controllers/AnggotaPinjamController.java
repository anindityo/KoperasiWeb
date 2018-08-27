/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitas.AnggotaPinjam;
import org.hibernate.SessionFactory;
import daos.AnggotaPinjamDAO;
import entitas.Akun;
import entitas.Anggota;
import entitas.Tenor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class AnggotaPinjamController {

    private AnggotaPinjamDAO anggotapinjamdao;

    public AnggotaPinjamController() {
    }

    public AnggotaPinjamController(SessionFactory factory) {
        this.anggotapinjamdao = new AnggotaPinjamDAO(factory);
    }

    public List<AnggotaPinjam> getAll() {
        return this.convertToListAnggotaPinjam(this.anggotapinjamdao.getAll());
    }

    private List<AnggotaPinjam> convertToListAnggotaPinjam(List<Object> dataAwal) {
        List<AnggotaPinjam> dataAnggotaPinjam = new ArrayList<>();
        for (Object object : dataAwal) {
            AnggotaPinjam anggotaPinjam = (AnggotaPinjam) object;
            dataAnggotaPinjam.add(anggotaPinjam);
        }
        return dataAnggotaPinjam;
    }

    public List<AnggotaPinjam> search(String category, String data) {
        return this.convertToListAnggotaPinjam(this.anggotapinjamdao.search(category, data));
    }

    public AnggotaPinjam getById(String kdAnggotaPinjam) {
        return this.anggotapinjamdao.getAnggotaPinjamById(kdAnggotaPinjam);
    }

    public boolean inspinjaman(String kdpinjam, String nominal, String kodekaryawan,
            String kdanggota, String kdtenor) throws
            SQLException {
        AnggotaPinjam ap = new AnggotaPinjam(kdpinjam,
                Integer.parseInt(nominal),
                new Akun(kodekaryawan),
                new Anggota(kdanggota),
                new Tenor(kdtenor));
        return this.anggotapinjamdao.insanggotapinjam(ap);
    }

    public String getAutoIdAnggotaPinjam() {
        return this.anggotapinjamdao.getKdAutoAnggotaPinjam();
    }

}
