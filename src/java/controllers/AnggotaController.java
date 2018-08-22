/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitas.Anggota;
import org.hibernate.SessionFactory;
import daos.AnggotaDAO;
import entitas.Akun;
import entitas.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import method.BCrypt;

/**
 *
 * @author WIN 10
 */
public class AnggotaController {

    private AnggotaDAO anggotadao;

    public AnggotaController() {
    }

    public AnggotaController(SessionFactory factory) {
        this.anggotadao = new AnggotaDAO(factory);
    }

    public boolean saveOrEdit(String kdAnggota, String password,
            String namaAnggota, String telepon, String jenisKelamin, String alamat, String kdRole, Date tgllahir) {
        Anggota anggota = new Anggota(kdAnggota, BCrypt.hashpw(password, BCrypt.gensalt(12)), namaAnggota, telepon,
                jenisKelamin, alamat, new Role(Short.parseShort(kdRole)), tgllahir);
        return this.anggotadao.insertOrUpdate(anggota);
    }
    public List<Anggota> getAll() {
        return this.convertToListAnggota(this.anggotadao.getAll());
    }
    private List<Anggota> convertToListAnggota(List<Object> dataAwal) {
        List<Anggota> dataAnggota = new ArrayList<>();
        for (Object object : dataAwal) {
            Anggota anggota = (Anggota) object;
            dataAnggota.add(anggota);
        }
        return dataAnggota;
    }
    public List<Anggota> search(String category, String data) {
        return this.convertToListAnggota(this.anggotadao.search(category, data));
    }
    public Anggota getById(String kdAnggota) {
        return this.anggotadao.getAnggotaById(kdAnggota);
    }
    public String getAutoIdAnggota() {
        return this.anggotadao.getKdAutoAnggota();
    }      
    public boolean loginanggota(String id, String password){
        Anggota a = (Anggota) anggotadao.getAnggotaById(id);
        return tools.BCrypt.checkpw(password, a.getPassword());
    }
}
