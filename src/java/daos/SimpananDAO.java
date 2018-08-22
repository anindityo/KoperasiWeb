/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entitas.Simpanan;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author iqbal yusuff
 */
public class SimpananDAO {

    private FunctionDAO fdao;

    public SimpananDAO() {
    }

    public SimpananDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

      
    public List<Object> getAllSimpananPokok() {
        return this.fdao.get("FROM Simpanan where kd_simpanan='S01'");
    }
  public List<Object> getAllSimpananWajib() {
        return this.fdao.get("FROM Simpanan where kd_simpanan='S02'");
    }
   
}
