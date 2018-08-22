/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.util.List;
import entitas.PemasukanKoperasi;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class PemasukanKoperasiDAO {
    private FunctionDAO fdao;
    
    public PemasukanKoperasiDAO(){
        
    }
    public PemasukanKoperasiDAO(SessionFactory factory){
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(PemasukanKoperasi pemasukanKoperasi) {
        return this.fdao.insertOrUpdate(pemasukanKoperasi);
    }

    
    public List<Object> getAll() {
        return this.fdao.get("FROM PemasukanKoperasi");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM PemasukanKoperasi WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public PemasukanKoperasi getPemasukanById(String kdMasukKoperasi) {
        return (PemasukanKoperasi) this.fdao
                .getById("FROM PemasukanKoperasi WHERE kdMasukKoperasi='" + kdMasukKoperasi + "'");
    }
      public String getKdAutoPemasukanKoeparasi(){
            return (String) this.fdao.getById("Select CONCAT('M',LPAD((TO_NUMBER(SUBSTR(MAX(kd_masukkoperasi),2,3))+1),3, '0')) FROM PemasukanKoperasi");
  
    }
    
    
}
