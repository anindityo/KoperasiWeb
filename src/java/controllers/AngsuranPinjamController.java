/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitas.Angsuranpinjam;
import org.hibernate.SessionFactory;
import daos.AngsuranpinjamDAO;
import entitas.AnggotaPinjam;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class AngsuranPinjamController {

    private AngsuranpinjamDAO angsuranpinjamdao;

    public AngsuranPinjamController() {
    }

    public AngsuranPinjamController(SessionFactory factory) {
        this.angsuranpinjamdao = new AngsuranpinjamDAO(factory);
    }

    public List<Angsuranpinjam> getAll() {
        return this.convertToListAngsuranpinjam(this.angsuranpinjamdao.getAll());
    }

    public List<Angsuranpinjam> getAllblmns() {
        return this.convertToListAngsuranpinjam(this.angsuranpinjamdao.getAllblumlunas());
    }

    private List<Angsuranpinjam> convertToListAngsuranpinjam(List<Object> dataAwal) {
        List<Angsuranpinjam> dataAngsuranpinjam = new ArrayList<>();
        for (Object object : dataAwal) {
            Angsuranpinjam angsuranpinjam = (Angsuranpinjam) object;
            dataAngsuranpinjam.add(angsuranpinjam);
        }
        return dataAngsuranpinjam;
    }

    public List<Angsuranpinjam> search(String category, String data) {
        return this.convertToListAngsuranpinjam(this.angsuranpinjamdao.search(category, data));
    }

    public Angsuranpinjam getById(String kdAngsuran) {
        return this.angsuranpinjamdao.getAngsuranById(kdAngsuran);
    }

    public String kdAutoAngsur() {
        return (String) this.angsuranpinjamdao.getKdAutoAnggotaPinjam();
    }

    public boolean insAngsuran(String kdangsur, String kdpinjam) throws SQLException {
        Angsuranpinjam anp = new Angsuranpinjam(kdangsur, new AnggotaPinjam(kdpinjam));

        return this.angsuranpinjamdao.insangsuran(anp);
    }

}
