/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.TenorDAO;
import entitas.Tenor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author iqbal yusuff
 */
public class TenorController {
     private TenorDAO tdao;

    public TenorController() {
    }

    public TenorController(SessionFactory factory) {
        this.tdao = new TenorDAO(factory);
    }
     private List<Tenor> convertToListPemasukan(List<Object> dataAwal) {
        List<Tenor> dataPemasukan = new ArrayList<>();
        for (Object object : dataAwal) {
            Tenor tenor = (Tenor) object;
            dataPemasukan.add(tenor);
        }
        return dataPemasukan;
    }
    public List<Tenor> getAll() {
        return this.convertToListPemasukan(this.tdao.getAllTenor());
    }
     
}
