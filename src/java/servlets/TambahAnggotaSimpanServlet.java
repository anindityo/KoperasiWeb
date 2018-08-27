/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controllers.AnggotaSimpanController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class TambahAnggotaSimpanServlet extends HttpServlet {

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
        String tanggal = request.getParameter("txttanggal");
        String kdanggota = request.getParameter("txtkodeAnggota");
        String nominal = request.getParameter("txtnominal");
        String akunkaryawan = session.getAttribute("kd").toString();
        String kdsimpanan = request.getParameter("txtjenissimpanan");
        try (PrintWriter out = response.getWriter()) {
            AnggotaSimpanController asc = new AnggotaSimpanController(HibernateUtil.getSessionFactory());
            DateFormat formatTanggal = new SimpleDateFormat("yyyy-MM-dd");
            Date tanggalL = formatTanggal.parse(tanggal);
            if (asc.saveOrEdit(asc.getAutoIdAnggotaSimpan(), tanggalL, nominal, akunkaryawan, kdanggota, kdsimpanan)) {
                out.print("sukses");
                response.sendRedirect("views/viewKaryawan/anggotasimpan.jsp");
            } else {
                out.print("gagal");
                response.sendRedirect("views/viewKaryawan/anggotasimpan.jsp");

            }

        } catch (ParseException ex) {
            Logger.getLogger(TambahAnggotaSimpanServlet.class.getName()).log(Level.SEVERE, null, ex);
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
