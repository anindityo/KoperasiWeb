/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import entitas.PemasukanKoperasi;
import org.hibernate.SessionFactory;
import daos.PemasukanKoperasiDAO;
import entitas.Simpanan;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class PemasukanKoperasiController {
     private PemasukanKoperasiDAO pemasukandao;
    
    public PemasukanKoperasiController(){
    }
    
    public PemasukanKoperasiController(SessionFactory factory){
        this.pemasukandao = new PemasukanKoperasiDAO(factory);
    }
    
    public boolean saveOrEdit(String kdMasukKoperasi, String namaSimpanan,
            String tglSimpan, BigInteger nominal, String kdSimpanan){
        PemasukanKoperasi pemasukanKoperasi = new PemasukanKoperasi(kdMasukKoperasi, 
        kdSimpanan, namaSimpanan, 
                java.sql.Date.valueOf(tglSimpan), 
               nominal, 
                new Simpanan(kdSimpanan));
        return this.pemasukandao.insertOrUpdate(pemasukanKoperasi);
    }

    public List<PemasukanKoperasi> getAll() {
        return this.convertToListPemasukan(this.pemasukandao.getAll());
    }

    private List<PemasukanKoperasi> convertToListPemasukan(List<Object> dataAwal) {
        List<PemasukanKoperasi> dataPemasukan = new ArrayList<>();
        for (Object object : dataAwal) {
            PemasukanKoperasi pemasukanKoperasi = (PemasukanKoperasi) object;
            dataPemasukan.add(pemasukanKoperasi);
        }
        return dataPemasukan;
    }

    public List<PemasukanKoperasi> search(String category, String data) {
        return this.convertToListPemasukan(this.pemasukandao.search(category, data));
    }
    
    public PemasukanKoperasi getById(String kdPemasukan){
        return this.pemasukandao.getPemasukanById(kdPemasukan);
  }
    
    
}
