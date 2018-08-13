/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entitas.Penarikan;
import org.hibernate.SessionFactory;
import daos.PenarikanDAO;
import entitas.Anggota;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class PenarikanController {
    private PenarikanDAO penarikandao;
    
    public PenarikanController(){
    }
    
    public PenarikanController(SessionFactory factory){
        this.penarikandao = new PenarikanDAO(factory);
    }
    
    public boolean saveOrEdit(String kdPenarikan, String kdAnggota) {
        Penarikan penarikan = new Penarikan(kdPenarikan,
               new Anggota (kdAnggota));
        return this.penarikandao.insertOrUpdate(penarikan);
    }

    public List<Penarikan> getAll() {
        return this.convertToListPenarikan(this.penarikandao.getAll());
    }

    private List<Penarikan> convertToListPenarikan(List<Object> dataAwal) {
        List<Penarikan> dataPenarikan = new ArrayList<>();
        for (Object object : dataAwal) {
            Penarikan penarikan = (Penarikan) object;
            dataPenarikan.add(penarikan);
        }
        return dataPenarikan;
    }

    public List<Penarikan> search(String category, String data) {
        return this.convertToListPenarikan(this.penarikandao.search(category, data));
    }
    
    public Penarikan getById(String kdPenarikan){
        return this.penarikandao.getPenarikanById(kdPenarikan);
  }
    
}
