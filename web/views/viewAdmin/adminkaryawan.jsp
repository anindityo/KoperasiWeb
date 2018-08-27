<%--
    Document   : admin
    Created on : Aug 13, 2018, 3:31:23 PM
    Author     : Gusma
--%>

<%@page import="java.text.SimpleDateFormat"%>
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

        <title>Admin - Dashboard</title>

        <!-- Bootstrap core CSS-->
        <link href="../../styleAdmin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="../../styleAdmin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="../../styleAdmin/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="../../styleAdmin/css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="https://code.jquery.com/jquery-3.3.1.js">
    </head>

    <body id="page-top">
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");

            if (session.getAttribute("kd") == null) {
                response.sendRedirect("../login.jsp");
            } else {

                AkunController ac = new AkunController(HibernateUtil.getSessionFactory());

                String id = session.getAttribute("kd").toString();
                Akun akuns = (Akun) new AkunController(HibernateUtil.getSessionFactory()).getById(id);

        %>

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="index.html">Admin Page</a>

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
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#modaledit">Account</a>
                        <a class="dropdown-item" href="../../logoutServlet">Logout</a>    </div>
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
                    <a class="nav-link" href="adminkaryawan.jsp">
                        <i class="fa fa-users"></i>
                        <span>Karyawan</span>
                    </a>
                </li>
                <li class=" active nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Report</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">

                        <a class="dropdown-item" href="#">Anggota Simpan</a>
                        <a class="dropdown-item" href="#">Anggota Pinjam</a>
                        <a class="dropdown-item" href="#">Angsuran Pinjam</a>
                        <a class="dropdown-item" href="#">Penarikan</a>
                        <a class="dropdown-item" href="#">Pemasukan Koperasi</a>
                    </div>
                </li>
            </ul>

            <div id="content-wrapper">
                <div class="container-fluid">
                    <div class="container-login100-form-btn">
                        <a class="btn btn-success" href="" data-toggle="modal"
                           data-target="#modaltambah">Tambah </a>
                        <a class="btn btn-success" href="reportKaryawan.jsp" >Print </a>


                    </div>
                    </br>
                    <!-- Area Chart Example-->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Data Table Karyawan
                        </div>
                        <div class="card-body">

                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Kode Akun</th>
                                        <th>Telepon</th>
                                        <th>Tanggal lahir</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Akun akun : ac.getAkunkaryawan()) {
                                    %>
                                    <tr>
                                        <td><%= akun.getKdAkun()%></td>
                                        <td><%
                                            if (akun.getTelepon() != null) {
                                                out.print(akun.getTelepon());
                                            }
                                            %></td>
                                        <td><%= new SimpleDateFormat("dd-MM-yyyy").format(akun.getTanggallahir())%></td>
                                        <% }
                                        %>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            <!-- modal edit-->

            <div class="modal fade" id="modaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="../../editAdminServlet" method="POST">
                            <div class="modal-header text-center">
                                <h4 class="modal-title w-100 font-weight-bold">Edit Data</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body mx-3">

                                <div class="md-form mb-5" data-validate="Telepon is required">
                                    <i class="fa fa-address-book"></i>
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
            <!-- modal edit-->

            <div class="modal fade" id="modaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="../../editAdminServlet" method="POST">
                            <div class="modal-header text-center">
                                <h4 class="modal-title w-100 font-weight-bold">Edit Data</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body mx-3">

                                <div class="md-form mb-5" data-validate="Telepon is required">
                                    <i class="fa fa-address-book"></i>
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
            <!-- Modal tambah -->
            <div class="modal fade" id="modaltambah" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="../../tambahKaryawanServlet" method="POST">
                            <div class="modal-header text-center">
                                <h4 class="modal-title w-100 font-weight-bold">Tambah Data</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body mx-3">
                                <div class="md-form mb-5">
                                    <!--<i class="fa fa-user prefix grey-text"></i>-->
                                    <!--<label data-error="wrong" data-success="right" for="orangeForm-name">Kode Anggota</label>-->
                                    <input  hidden="true" type="text" id="orangeForm-name" class="form-control validate" name="txtkode" value="<%= ac.getAutoIdkaryawan()%>">
                                </div>

                                <div class="md-form mb-5">
                                    <i class="fa fa-phone"></i>
                                    <label data-error="wrong" data-success="right" for="orangeForm-name"  >Telepon</label>
                                    <input type="number" id="orangeForm-name" class="form-control validate" name="txttelepon" required="" maxlength="13" placeholder="Maksimal 13 Digit Angka">
                                </div>
                                <div class="md-form mb-5">
                                    <i class="fa fa-calendar prefix grey-text"></i>
                                    <label data-error="wrong" data-success="right" for="orangeForm-name"  >Tanggal lahir</label>
                                    <input type="date" id="orangeForm-name" class="form-control validate" name="txttgl" required="" max="2009-08-20">
                                </div>


                            </div>
                            <div class="modal-footer d-flex justify-content-center">
                                <button class="btn btn-deep-orange" type="submit">Tambah</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- DataTables Example -->

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
