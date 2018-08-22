/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author iqbal yusuff
 */
public class TenorDAO {
     private FunctionDAO fdao;

    public TenorDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
     public List<Object> getAllTenor() {
        return this.fdao.get("FROM Tenor ");
    }
     
}
