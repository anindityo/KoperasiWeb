/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AkunController;
import daos.AkunDAO;
import entitas.Akun;
import method.BCrypt;

/**
 *
 * @author iqbael17
 */
public class tester {

    public static void main(String[] args) {
<<<<<<< HEAD
        //       System.out.println(HibernateUtil.getSessionFactory());
        AkunController ac = new AkunController(HibernateUtil.getSessionFactory());
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


//        if (!ac.login("KRfwY1asdasd")) {
//            System.out.println("sukses");
//        } else {
//            System.out.println("gagal");
//        }

  System.out.println("result: "+ac.login("KRY1", "admin"));
=======
     //       System.out.println(HibernateUtil.getSessionFactory());
//        AkunController ac = new AkunController(
//                HibernateUtil.getSessionFactory());
    //  for (Akun akun : ac.getAll()) {
//        for (Job job : jc.search("jobId", "AD")) {
  //          System.out.println(akun.getKdAkun()
      //              +" - "+akun.getTelepon());
      //  }
//      String del ="KRY2";
//          System.out.println(ac.drop(del));
        System.out.println(BCrypt.checkpw("qwerty", BCrypt.hashpw("qwerty", BCrypt.gensalt(12))));
        System.out.println(BCrypt.hashpw("qwerty", BCrypt.gensalt(12)));
>>>>>>> origin/master
    }
}
