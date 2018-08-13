/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.util.List;
import entitas.AnggotaPinjam;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class AnggotaPinjamDAO {
     private FunctionDAO fdao;
    
    public AnggotaPinjamDAO(){
        
    }
    public AnggotaPinjamDAO(SessionFactory factory){
        this.fdao = new FunctionDAO(factory);
    }
    
    public List<Object> getAll() {
        return this.fdao.get("FROM Anggota_Pinjam");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM Anggota_Pinjam WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public AnggotaPinjam getAnggotaPinjamById(String kdAnggotaPinjam) {
        return (AnggotaPinjam) this.fdao
                .getById("FROM Anggota_Pinjam WHERE kdAnggotaPinjam='" + kdAnggotaPinjam + "'");
    }
    
}
