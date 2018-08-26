/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AkunController;
import controllers.AnggotaController;
import controllers.AnggotaPinjamController;
import controllers.AnggotaSimpanController;
import daos.AkunDAO;
import entitas.Akun;
import entitas.AnggotaSimpan;
import entitas.Anggota;
import controllers.AnggotaSimpanController;
import controllers.PemasukanKoperasiController;
import controllers.SimpananController;
import entitas.AnggotaPinjam;
import entitas.PemasukanKoperasi;
import entitas.Simpanan;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

/**
 *
 * @author iqbael17
 */
public class tester {

    public static void main(String[] args) throws SQLException {

        // try {
        //       System.out.println(HibernateUtil.getSessionFactory());
        AnggotaController agtc = new AnggotaController(HibernateUtil.getSessionFactory());
        AkunController ac = new AkunController(HibernateUtil.getSessionFactory());
        AnggotaPinjamController ap = new AnggotaPinjamController(HibernateUtil.getSessionFactory());
        AnggotaSimpanController asc = new AnggotaSimpanController(HibernateUtil.getSessionFactory());
        SimpananController sc = new SimpananController(HibernateUtil.getSessionFactory());
        PemasukanKoperasiController pkc = new PemasukanKoperasiController(HibernateUtil.getSessionFactory());
        //  for (Akun akun : ac.getAll()) {
        //   for (Job job : jc.search("jobId", "AD")) {
        //     System.out.println(akun.getKdAkun()
        //             +" - "+akun.getTelepon());
        // }
//            System.out.println(BCrypt.checkpw("admin", BCrypt.hashpw("admin", BCrypt.gensalt(12))));
//            System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt(12)));
//       System.out.println("result: "
//                +new AkunController().login("2", "089435"));
//      Job j = jc.getById("AD_PRES");
//DateFormat formatTanggal = new SimpleDateFormat("yyyy/MM/dd");
//Date tanggal = formatTanggal.parse("2018/08/11");
//System.out.println(asc.saveOrEdit("ASP003",tanggal, "5000", "KRY001", "AGT004", "S01"));
//      System.out.println(ac.getAutoIdkaryawan());
//    System.out.println(asc.getAutoIdAnggotaSimpan());
//        if (!ac.login("KRfwY1asdasd")) {
//            System.out.println("sukses");
//        } else {
//            System.out.println("gagal");
//        }
// System.out.println("result: "+ac.login("KRY1", "admin"));
//       System.out.println(HibernateUtil.getSessionFactory());
//        AkunController ac = new AkunController(
//                HibernateUtil.getSessionFactory());
//  for (Akun akun : ac.getAll()) {
//     for (Job job : jc.search("jobId", "AD")) {
//          System.out.println(akun.getKdAkun()
//              +" - "+akun.getTelepon());
//  }
//      String del ="KRY2";
//          System.out.println(ac.drop(del));
 System.out.println(BCrypt.checkpw("karyawan", BCrypt.hashpw("karyawan", BCrypt.gensalt(12))));
 System.out.println(BCrypt.hashpw("karyawan", BCrypt.gensalt(12)));
//        String kodelogin = "Admin";
//        String pass = "admin";
//        String role = "akun";
//
//        Anggota agt = (Anggota) new AnggotaController(HibernateUtil.getSessionFactory()).getById(kodelogin);
//        AkunController ak = new AkunController(HibernateUtil.getSessionFactory());
//
//        if (role == "akun") {
//            Akun a = (Akun) new AkunController(HibernateUtil.getSessionFactory()).getById(kodelogin);
//
//            if (ak.search("kd_akun", kodelogin).isEmpty() || !ak.login(kodelogin, pass)) {
//                System.out.println("gagal pass/kode akun salah ");
//            } else {
//                if (a.getKdRole().getKdRole().toString().equals("1")) {
//                    System.out.println("sukses ");
//                } else if (a.getKdRole().getKdRole().toString().equals("2")) {
//                    System.out.println("sukses 2");
//                } else {
//                    System.out.println("gagal");
//                }
//
//            }
//        } else {
//            if (agtc.search("kd_anggota", kodelogin).isEmpty() || !agtc.loginanggota(kodelogin, pass)) {
//                System.out.println("gagal pass/kode anggota salah");
//            } else {
//                System.out.println("sukses 3");
//            }
//        }
//
//        if (ak.search("kd_akun", kodelogin).isEmpty() || !ak.login(kodelogin, pass)) {
//                    System.out.println("gagal pass/kode salah");
//                } else {
//                    if (a.getKdRole().getKdRole().toString().equals("1")) {
//                        System.out.println("sukses ");
//                    } else if (a.getKdRole().getKdRole().toString().equals("2")) {
//                        System.out.println("sukses 2");
//                    } else {
//                        System.out.println("gagal");
//                    }
        //                // dispatcher = request.getRequestDispatcher("login.jsp");
        //                //dispatcher.include(request, response);
        //            }
        //        }
        //        else if (ak.login(kodelogin, pass)) {
        //            if (a.getKdRole().getKdRole().toString().equals("1")) {
        //                System.out.println("sukses ");
        //            } else if (a.getKdRole().getKdRole().toString().equals("2")) {
        //                System.out.println("sukses 2");
        //            } else {
        //                System.out.println("gagal");
        //                // dispatcher = request.getRequestDispatcher("login.jsp");
        //                //dispatcher.include(request, response);
        //            }
        //        }
        //      
        //      else if (agtc.loginanggota(kodelogin, pass)) {
        //            System.out.println("sukses 3");
        //        } 
        //            else {
        //                System.out.println("gagal pass");
        //            }
        //      if(a.getKdAkun()==null ){
        //          System.out.println("gagal");
        //      }else{
        //          System.out.println("sukses");
        //      }
        //      
        //        System.out.println(akun.getKdRole().getKdRole());
        //        for (AnggotaSimpan as : asc.getAll()) {
        //            System.out.println(as.getKdAnggotasimpan()
        //                    + as.getKdAnggota().getNamaAnggota()+as.getTglSimpan());
        //   }
        //        } catch (ParseException ex) {
        //            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        for (PemasukanKoperasi pk : pkc.getAll()) {
        //            System.out.println(pk.getNominal());
        //        }
        //     
        //            Connection kon = HibernateUtil.getSessionFactory()
        //                    .getSessionFactoryOptions().getServiceRegistry()
        //                    .getService(ConnectionProvider.class)
        //                    .getConnection();
        //            kon.createStatement().execute("alter session set current_schema=koperasierd");
        //            CallableStatement cs = kon.prepareCall("{Call insPinjaman(?,?,?,?,?)}");
        //            cs.setString(1, "APJ001");
        //            cs.setString(2, "AGT003");
        //            cs.setString(3, "KRY001");
        //            cs.setString(4, "T1");
        //            cs.setInt(5, 5000);
        //            cs.execute();
        //  System.out.println(ap.inspinjaman("APJ007", "5000", "KRY001", "AGT003", "T1"));
        //Anggota a = agtc.getById("AGT003");
//  String id="Tes";
//  String kd="Tes";
//  
//  if(id.equals(kd)){
//      System.out.println("sukses");
//  }else{
//      
//      System.out.println("gagla");
//  }
    }

}
