/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AkunController;
import controllers.AnggotaController;
import entitas.Akun;
import entitas.Anggota;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import tools.HibernateUtil;

/**
 *
 * @author iqbal yusuff
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        String kodelogin = request.getParameter("kode");
        String pass = request.getParameter("pass");
   
        AnggotaController agtc = new AnggotaController(HibernateUtil.getSessionFactory());
        AkunController ak = new AkunController(HibernateUtil.getSessionFactory());
      
        try (PrintWriter out = response.getWriter()) {

            Anggota agt = (Anggota) new AnggotaController(HibernateUtil.getSessionFactory()).getById(kodelogin);

 
                Akun a = (Akun) new AkunController(HibernateUtil.getSessionFactory()).getById(kodelogin);

                if (ak.search("kd_akun", kodelogin).isEmpty() || !ak.login(kodelogin, pass)) {
                    response.sendRedirect("views/login.jsp");
                } else {
                    if (a.getKdRole().getKdRole().toString().equals("1")) {
                        response.sendRedirect("views/viewAdmin/home.jsp");
                        session.setAttribute("kd", kodelogin);
                    } else if (a.getKdRole().getKdRole().toString().equals("2")) {
                        response.sendRedirect("views/viewKaryawan/home.jsp");
                        session.setAttribute("kd", kodelogin);
                    } else {
                        response.sendRedirect("views/login.jsp");
                    }

                }
//            } else {
//                if (agtc.search("kd_anggota", kodelogin).isEmpty() || !agtc.loginanggota(kodelogin, pass)) {
//                    response.sendRedirect("login.jsp");
//                } else {
//                    response.sendRedirect("views/viewAnggota/home.jsp");
//                }
//            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
