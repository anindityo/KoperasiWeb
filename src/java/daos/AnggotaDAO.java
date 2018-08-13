/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.util.List;
import entitas.Anggota;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class AnggotaDAO {
    private FunctionDAO fdao;
    
    public AnggotaDAO(){
        
    }
    public AnggotaDAO (SessionFactory factory){
        this.fdao = new FunctionDAO(factory);
    }
    public boolean insertOrUpdate(Anggota anggota) {
        return this.fdao.insertOrUpdate(anggota);
    }

    
    public List<Object> getAll() {
        return this.fdao.get("FROM Anggota");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM Anggota WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public Anggota getAnggotaById(String kdAnggota) {
        return (Anggota) this.fdao
                .getById("FROM Anggota WHERE kdAnggota='" + kdAnggota + "'");
    }
    
}
