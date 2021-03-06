/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entitas.Akun;
import org.hibernate.SessionFactory;
import daos.AkunDAO;
import entitas.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tools.BCrypt;

/**
 *
 * @author WIN 10
 */
public class AkunController {

    private AkunDAO adao;

    public AkunController() {
    }

    public AkunController(SessionFactory factory) {
        this.adao = new AkunDAO(factory);

    }

    public boolean saveOrEdit(String kdAkun, String password,
            String telepon, String kdRole, Date tanggallahir) {
        Akun akun = new Akun(kdAkun, BCrypt.hashpw(password, BCrypt.gensalt(12)),
                telepon, new Role(Short.parseShort(kdRole)), tanggallahir);
        return this.adao.insertOrUpdate(akun);
    }
    
    public boolean saveoreditpasskosong(String kdAkun,String telepon, String kdRole, Date tanggallahir)
    {
         Akun akun = new Akun(kdAkun,
                telepon, new Role(Short.parseShort(kdRole)), tanggallahir);
          return this.adao.insertOrUpdate(akun);
    }

    public boolean drop(String id) {
        return this.adao.delete(id);
    }

    public List<Akun> getAll() {
        return this.convertToListAkun(this.adao.getAll());
    }

    public List<Akun> getAkunkaryawan() {
        return this.convertToListAkun(this.adao.getAkunkaryawan());
    }

    private List<Akun> convertToListAkun(List<Object> dataAwal) {
        List<Akun> dataAkun = new ArrayList<>();
        for (Object object : dataAwal) {
            Akun akun = (Akun) object;
            dataAkun.add(akun);
        }
        return dataAkun;
    }

    public List<Akun> search(String category, String data) {
        return this.convertToListAkun(this.adao.search(category, data));
    }

    public Akun getById(String kdAkun) {
        return this.adao.getAkunById(kdAkun);
    }

    public String getAutoIdkaryawan() {
        return this.adao.getAutoIdAkunKaryawan();
    }

    public boolean login(String id, String password) {
        Akun um = (Akun) adao.getAkunById(id);
        return BCrypt.checkpw(password, um.getPassword());
    }

    public boolean login(String category, String username, String password) {
        Akun a = (Akun) adao.search(category, username).get(0);
        return BCrypt.checkpw(password, a.getPassword());
    }

}
