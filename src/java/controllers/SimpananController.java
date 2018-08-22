/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.SimpananDAO;
import entitas.Akun;
import entitas.Simpanan;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author iqbal yusuff
 */
public class SimpananController {

    private SimpananDAO sdao;

    public SimpananController() {
    }

    public SimpananController(SessionFactory factory) {
        this.sdao = new SimpananDAO(factory);
    }

    public List<Simpanan> getSimpananPokok() {
        return this.convertToListSimpanan(this.sdao.getAllSimpananPokok());
    }

    public List<Simpanan> getSimpananWajib() {
        return this.convertToListSimpanan(this.sdao.getAllSimpananWajib());
    }

    private List<Simpanan> convertToListSimpanan(List<Object> dataAwal) {
        List<Simpanan> dataAkun = new ArrayList<>();
        for (Object object : dataAwal) {
            Simpanan simpanan = (Simpanan) object;
            dataAkun.add(simpanan);
        }
        return dataAkun;
    }

}
