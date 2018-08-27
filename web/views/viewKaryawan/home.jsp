<%--
    Document   : homeKaryawan
    Created on : Aug 15, 2018, 8:12:34 AM
    Author     : Gusma
--%>

<%@page import="entitas.Akun"%>
<%@page import="controllers.AkunController"%>
<%@page import="tools.HibernateUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="au theme template">
        <meta name="author" content="Hau Nguyen">
        <meta name="keywords" content="au theme template">

        <!-- Title Page-->
        <title>Karyawan - Dashboard</title>

        <!-- Fontfaces CSS-->
        <link href="../../styleKaryawan/css/font-face.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

        <!-- Bootstrap CSS-->
        <link href="../../styleKaryawan/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

        <!-- Vendor CSS-->
        <link href="../../styleKaryawan/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/wow/animate.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/slick/slick.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="../../styleKaryawan/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="../../styleKaryawan/css/theme.css" rel="stylesheet" media="all">

    </head>

    <body class="animsition">
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");

            if (session.getAttribute("kd") == null) {
                response.sendRedirect("../login.jsp");
            } else {
                AkunController ac = new AkunController(HibernateUtil.getSessionFactory());
                String Kode = session.getAttribute("kd").toString();
                Akun akun = (Akun) new AkunController(HibernateUtil.getSessionFactory()).getById(Kode);

        %>
        <div class="page-wrapper">

            <!-- MENU SIDEBAR-->
            <aside class="menu-sidebar d-none d-lg-block">
                <div class="logo">
                    <a href="#" style="font-size: 18px; color: #000000">
                        Koperasi Simpan Pinjam
                    </a>
                </div>
                <div class="menu-sidebar__content js-scrollbar1">
                    <nav class="navbar-sidebar">
                        <ul class="list-unstyled navbar__list">
                            <li class="active has-sub">
                                <a class="js-arrow" href="home.jsp">
                                    <i class="fas fa-home"></i>Dashboard
                                </a>
                            </li>
                            <li>
                                <a href="anggota.jsp">
                                    <i class="fas fa-user"></i>Anggota
                                </a>
                            </li>
                            <li>
                                <a href="anggotasimpan.jsp">
                                    <i class="fas fa-table"></i>Anggota Simpan
                                </a>
                            </li>
                            <li>
                                <a href="anggotapinjam.jsp">
                                    <i class="fas fa-table"></i>Anggota Pinjam
                                </a>
                            </li>
                            <li>
                                <a href="angsuranpinjam.jsp">
                                    <i class="fas fa-table"></i>Angsuran Pinjam
                                </a>
                            </li>
                            <li>
                                <a href="penarikan.jsp">
                                    <i class="fas fa-book"></i>Penarikan
                                </a>
                            </li>

                            <li>
                                <a href="pemasukankoperasi.jsp">
                                    <i class="fas fa-book"></i>Pemasukan Koperasi
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </aside>
            <!-- END MENU SIDEBAR-->

            <!-- PAGE CONTAINER-->
            <div class="page-container">
                <!-- HEADER DESKTOP-->
                <header class="header-desktop">
                    <div class="section__content section__content--p30">
                        <div class="container-fluid">
                            <div class="header-wrap">
                                <form class="form-header" >

                                </form>
                                <div class="header-button">

                                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-user-circle fa-fw"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#modaledit">Account</a>
                                        <a class="dropdown-item" href="../../logoutServlet" >Logout</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </header>
                <!-- HEADER DESKTOP-->

                <!-- MAIN CONTENT-->
                <div class="main-content">
                    <div id="content-wrapper">
                        <div class="section__content section__content--p30">
                        </div>
                        <div class="col-lg-6">
                            <div class="container-fluid">
                                <div class="isi">

                                    <p>Selamat datang <%= akun.getKdAkun()%>

                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p>Copyright © 2018 Koperasi TIM. All rights reserved. Template by <a href="#">Koperasi TIM</a>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal edit akun-->
        <div class="modal fade" id="modaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form action="../../editKaryawanServlet" method="POST">
                        <div class="modal-header text-center">
                            <h4 class="modal-title w-100 font-weight-bold">Edit Data</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body mx-3">

                            <div class="md-form mb-5" data-validate="Telepon is required">
                                <i class="fa fa-address-book"></i>
                                <input type="hidden" id="orangeForm-name" class="form-control validate" maxlength="14" name="txtkode"  value="<%= akun.getKdAkun()%>">
                                <label data-error="wrong" data-success="right" for="orangeForm-name"  >Password Baru</label>
                                <input type="password" id="orangeForm-name" class="form-control validate" maxlength="14" name="txtpassbaru" >
                            </div>
                            <div class="md-form mb-5" data-validate="Telepon is required">
                                <i class="fa fa-address-book"></i>
                                <label data-error="wrong" data-success="right" for="orangeForm-name"  >Confirm Password</label>
                                <input type="password" id="orangeForm-name" class="form-control validate" maxlength="14" name="txtpassbaru1" >
                            </div>

                        </div>
                        <div class="modal-footer d-flex justify-content-center">
                            <button class="btn btn-deep-orange" type="submit">Edit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- end Modal edit akun-->
        <!-- Jquery JS-->
        <script src="../../styleKaryawan/vendor/jquery-3.2.1.min.js"></script>
        <!-- Bootstrap JS-->
        <script src="../../styleKaryawan/vendor/bootstrap-4.1/popper.min.js"></script>
        <script src="../../styleKaryawan/vendor/bootstrap-4.1/bootstrap.min.js"></script>
        <!-- Vendor JS       -->
        <script src="../../styleKaryawan/vendor/slick/slick.min.js">
        </script>
        <script src="../../styleKaryawan/vendor/wow/wow.min.js"></script>
        <script src="../../styleKaryawan/vendor/animsition/animsition.min.js"></script>
        <script src="../../styleKaryawan/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
        </script>
        <script src="../../styleKaryawan/vendor/counter-up/jquery.waypoints.min.js"></script>
        <script src="../../styleKaryawan/vendor/counter-up/jquery.counterup.min.js">
        </script>
        <script src="../../styleKaryawan/vendor/circle-progress/circle-progress.min.js"></script>
        <script src="../../styleKaryawan/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="../../styleKaryawan/vendor/chartjs/Chart.bundle.min.js"></script>
        <script src="../../styleKaryawan/vendor/select2/select2.min.js">
        </script>

        <!-- Main JS-->
        <script src="../../styleKaryawan/js/main.js"></script>
        <% }%>
    </body>

</html>
<!-- end document-->
