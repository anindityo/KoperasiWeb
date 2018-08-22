<%-- 
    Document   : reportKaryawan
    Created on : Aug 19, 2018, 10:30:28 PM
    Author     : Gusma
--%>

<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cetak</title>
    </head>
    <body>
        <%
            try {

                HashMap parameter = new HashMap();
                String kd_akun = request.getParameter("kd_akun");
                parameter.put("kd_akun", kd_akun);                
                Connection connection = HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
                File reportFile = new File(application.getRealPath("viewAdmin/Report/Karyawan.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameter, connection);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                out.println("Error :" + e.getMessage());
            }
        %>
    </body>
</html>
