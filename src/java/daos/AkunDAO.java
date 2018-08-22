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
        return this.fdao.get("FROM Akun where kd_role='2' order by kd_akun asc");
    }
   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM Akun WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public Akun getAkunById(String kdAkun) {
        return (Akun)this.fdao.getById("FROM Akun WHERE kd_akun='" + kdAkun + "'");
    }
    
    public boolean getLogin(String kdAkun) {
        return this.fdao.log("FROM Akun WHERE kd_akun='" + kdAkun + "'");
    }
    public String getAutoIdAkunKaryawan(){
        return (String) this.fdao.getById("Select CONCAT('KRY',LPAD((TO_NUMBER(SUBSTR(MAX(kd_akun),4,3))+1),3, '0')) FROM Akun");
    }
    
}
