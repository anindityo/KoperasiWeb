/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import entitas.Angsuranpinjam;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import tools.HibernateUtil;

/**
 *
 * @author WIN 10
 */
public class AngsuranpinjamDAO {

    private FunctionDAO fdao;

    public AngsuranpinjamDAO() {

    }

    public AngsuranpinjamDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public List<Object> getAll() {
        return this.fdao.get("FROM Angsuranpinjam");
    }

    public List<Object> getAllblumlunas() {
        return this.fdao.get("from Angsuranpinjam as np right outer join np.kdAnggotapinjam ap "
                + " where np.status is null ");
    }

    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM AngsuranPinjam WHERE "
                + category + " LIKE '%" + data + "%'");
    }

    public Angsuranpinjam getAngsuranById(String kdAngsuran) {
        return (Angsuranpinjam) this.fdao
                .getById("FROM Angsuran WHERE kdAngsuran='" + kdAngsuran + "'");
    }

    public String getKdAutoAnggotaPinjam() {
        return (String) this.fdao.getById("Select CONCAT('APJ',LPAD((TO_NUMBER(SUBSTR(MAX(kd_anggotapinjam),4,3))+1),3, '0')) FROM AnggotaPinjam");

    }

    public boolean insangsuran(Angsuranpinjam anp) throws SQLException {
        boolean flag = false;
        try {
            Connection kon = HibernateUtil.getSessionFactory()
                    .getSessionFactoryOptions().getServiceRegistry()
                    .getService(ConnectionProvider.class)
                    .getConnection();
            kon.createStatement().execute("alter session set current_schema=koperasierd");
            CallableStatement cs = kon.prepareCall("{Call insAngs(?,?)}");
            cs.setString(1, anp.getKdAngsuran());
            cs.setString(2, anp.getKdAnggotapinjam().getKdAnggotapinjam());
            cs.execute();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaPinjamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return flag;
    }

}
