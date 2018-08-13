/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import entitas.Penarikan;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class PenarikanDAO {
    private FunctionDAO fdao;
    
    public PenarikanDAO(){
        
    }
    public PenarikanDAO(SessionFactory factory){
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Penarikan penarikan) {
        return this.fdao.insertOrUpdate(penarikan);
    }

    
    public List<Object> getAll() {
        return this.fdao.get("FROM Penarikan");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM Penarikan WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public Penarikan getPenarikanById(String kdPenarikan) {
        return (Penarikan) this.fdao
                .getById("FROM Akun WHERE kdAkun='" + kdPenarikan + "'");
    }
    
}
