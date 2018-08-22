/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import java.util.List;
import entitas.AnggotaSimpan;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN 10
 */
public class AnggotaSimpanDAO {
    private FunctionDAO fdao;
    
    public AnggotaSimpanDAO(){
        
    }
    public AnggotaSimpanDAO (SessionFactory factory){
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean insertOrUpdate(AnggotaSimpan anggotaSimpan) {
        return this.fdao.insertOrUpdate(anggotaSimpan);
    }

    
    public List<Object> getAll() {
        return this.fdao.get("FROM AnggotaSimpan");
    }

   
    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM AnggotaSimpan WHERE "
                +category+ " LIKE '%"+data+"%'");
    }

   
    public AnggotaSimpan getAnggotaSimpanById(String kdAnggotaSimpan) {
        return (AnggotaSimpan) this.fdao
                .getById("FROM AnggotaSimpan WHERE kdAnggotaSimpan='" + kdAnggotaSimpan + "'");
    }
    public String getKdAutoAnggotaSimpan(){
            return (String) this.fdao.getById("Select CONCAT('ASP',LPAD((TO_NUMBER(SUBSTR(MAX(kd_anggotasimpan),4,3))+1),3, '0')) FROM AnggotaSimpan");
  
    }
    
    
}
