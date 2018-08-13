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
import java.util.List;

/**
 *
 * @author WIN 10
 */
public class AkunController {
    private AkunDAO adao;
    
    public AkunController(){
    }
    
    public AkunController(SessionFactory factory){
        this.adao = new AkunDAO(factory);
    }
    
    public boolean saveOrEdit(String kdAkun, String password,
            String telepon, String kdRole) {
        Akun akun = new Akun(kdAkun, password, telepon, new Role(Short.parseShort(kdRole)));
        return this.adao.insertOrUpdate(akun);
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
    
    public Akun getById(String kdAkun){
        return this.adao.getAkunById(kdAkun);
  }
    
}
