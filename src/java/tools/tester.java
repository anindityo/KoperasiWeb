/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.AkunController;
import entitas.Akun;

/**
 *
 * @author iqbael17
 */
public class tester {
    public static void main(String[] args) {
     //       System.out.println(HibernateUtil.getSessionFactory());
        AkunController ac = new AkunController(
                HibernateUtil.getSessionFactory());
    //  for (Akun akun : ac.getAll()) {
//        for (Job job : jc.search("jobId", "AD")) {
  //          System.out.println(akun.getKdAkun()
      //              +" - "+akun.getTelepon());
      //  }
      String del ="KRY2";
          System.out.println(ac.drop(del));
       
    }
}
