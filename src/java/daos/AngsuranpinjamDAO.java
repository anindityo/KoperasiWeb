/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import entitas.Angsuranpinjam;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class AngsuranpinjamDAO {

    private FunctionDAO fdao;

    public AngsuranpinjamDAO() {

    }

    public AngsuranpinjamDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
     public List<Object> getAll() {
        return this.fdao.get("FROM AngsuranPinjam");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM AngsuranPinjam WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public Angsuranpinjam getAngsuranById(String kdAngsuran) {
        return (Angsuranpinjam) this.fdao
                .getById("FROM Angsuran WHERE kdAngsuran='" + kdAngsuran + "'");
    }

}
