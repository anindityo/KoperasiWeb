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
        return this.fdao.get("FROM Pemasukan_Koperasi");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM Pemasukan_Koperasi WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public PemasukanKoperasi getPemasukanById(String kdMasukKoperasi) {
        return (PemasukanKoperasi) this.fdao
                .getById("FROM Pemasukan_Koperasi WHERE kdMasukKoperasi='" + kdMasukKoperasi + "'");
    }
    
}
