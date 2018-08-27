<%--
    Document   : admin
    Created on : Aug 13, 2018, 3:31:23 PM
    Author     : Gusma
--%>

<%@page import="entitas.Anggota"%>
<%@page import="controllers.AnggotaController"%>
<%@page import="entitas.Akun"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.Hibernate"%>
<%@page import="controllers.AkunController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Anggota - Dashboard</title>

        <!-- Bootstrap core CSS-->
        <link href="../../styleAdmin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="../../styleAdmin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="../../styleAdmin/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../../styleAdmin/css/sb-admin.css" rel="stylesheet">

    </head>

    <body id="page-top">
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");

            if (session.getAttribute("kdagt") == null) {
                response.sendRedirect("../loginAnggota.jsp");
            } else {

                AnggotaController ac = new AnggotaController(HibernateUtil.getSessionFactory());
                String Kode = session.getAttribute("kdagt").toString();
                Anggota anggota = (Anggota) new AnggotaController(HibernateUtil.getSessionFactory()).getById(Kode);

        %>
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="index.html">Anggota Page</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <!--                    <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search"></i>
                                            </button>
                                        </div>-->
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw" style="font-size: 28px;"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="account.jsp">Account</a>
                        <a class="dropdown-item" href="../../logoutAnggota" >Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">
                        <i class="fa fa-home"></i>
                        <span>Home</span>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="simpanan.jsp">
                        <i class="fa fa-calendar"></i>
                        <span>Simpanan</span>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="pinjaman.jsp">
                        <i class="fa fa-book"></i>
                        <span>Pinjaman</span>
                    </a>
                </li>
            </ul>
            <!-- modal tambah-->

            <!-- /modal edit-->

            <!-- DataTables Example -->
            Selamat Datang <%= anggota.getNamaAnggota()%> !!
            <!-- /.container-fluid -->

            <!-- Sticky Footer -->
            <!-- /.content-wrapper -->
            <footer class="sticky-footer">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright © Koperasi TIM 2018</span>
                    </div>
                </div>
            </footer>

            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>



            <!-- Bootstrap core JavaScript-->
            <script src="../../styleAdmin/vendor/jquery/jquery.min.js"></script>
            <script src="../../styleAdmin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="../../styleAdmin/vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Page level plugin JavaScript-->
            <script src="../../styleAdmin/vendor/chart.js/Chart.min.js"></script>
            <script src="../../styleAdmin/vendor/datatables/jquery.dataTables.js"></script>
            <script src="../../styleAdmin/vendor/datatables/dataTables.bootstrap4.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="../../styleAdmin/js/sb-admin.min.js"></script>

            <!-- Demo scripts for this page-->
            <script src="../../styleAdmin/js/demo/datatables-demo.js"></script>
            <script src="../../styleAdmin/js/demo/chart-area-demo.js"></script>
            <% }%>
    </body>
</html>
