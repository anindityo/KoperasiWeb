/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import entitas.Akun;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class AkunDAO {
    private FunctionDAO fdao;
    
    public AkunDAO(){
        
    }
    public AkunDAO(SessionFactory factory){
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(Akun akun) {
        return this.fdao.insertOrUpdate(akun);
    }
    public boolean delete(String id){
        return this.fdao.delete("delete from Akun where kd_akun='"+id+" ' ");
    }

    
    public List<Object> getAll() {
        return this.fdao.get("FROM Akun");
    }

    public List<Object> getAkunkaryawan() {
        return this.fdao.get("FROM Akun where kd_role='2'");
    }
   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM Akun WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public Object getAkunById(String kdAkun) {
        return this.fdao.getById("FROM Akun WHERE kdAkun='" + kdAkun + "'");
    }
}
