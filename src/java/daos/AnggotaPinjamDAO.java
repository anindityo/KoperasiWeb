/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import entitas.AnggotaPinjam;
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
public class AnggotaPinjamDAO {

    private FunctionDAO fdao;

    public AnggotaPinjamDAO() {

    }

    public AnggotaPinjamDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    public List<Object> getAll() {
        return this.fdao.get("FROM AnggotaPinjam");
    }

    public List<Object> search(String category, String data) {
        return this.fdao.get("FROM AnggotaPinjam WHERE "
                + category + " LIKE '%" + data + "%'");
    }

    public AnggotaPinjam getAnggotaPinjamById(String kdAnggotaPinjam) {
        return (AnggotaPinjam) this.fdao
                .getById("FROM AnggotaPinjam WHERE kdAnggotaPinjam='" + kdAnggotaPinjam + "'");
    }

    public boolean insanggotapinjam(AnggotaPinjam ap) throws SQLException {
        boolean flag = false;
        try {
            Connection kon = HibernateUtil.getSessionFactory()
                    .getSessionFactoryOptions().getServiceRegistry()
                    .getService(ConnectionProvider.class)
                    .getConnection();
            kon.createStatement().execute("alter session set current_schema=koperasierd");
            CallableStatement cs = kon.prepareCall("{Call insPinjaman(?,?,?,?,?)}");
            cs.setString(1, ap.getKdAnggotapinjam());
            cs.setString(2, ap.getKdAnggota().getKdAnggota());
            cs.setString(3, ap.getKdAkun().getKdAkun());
            cs.setString(4, ap.getKdTenor().getKdTenor());
            cs.setInt(5, ap.getNominalPinjam());
            cs.execute();
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaPinjamDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return flag;

    }
    public String getKdAutoAnggotaPinjam(){
            return (String) this.fdao.getById("Select CONCAT('ASP',LPAD((TO_NUMBER(SUBSTR(MAX(kd_anggotapinjam),4,3))+1),3, '0')) FROM AnggotaPinjam");
  
    }

}
