
<%-- 
    Document   : admin
    Created on : Aug 13, 2018, 3:31:23 PM
    Author     : Gusma
--%>

<%@page import="entitas.Akun"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.Hibernate"%>
<%@page import="controllers.AkunController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

    </head>

    <body id="page-top">
        <% AkunController ac = new AkunController(HibernateUtil.getSessionFactory());
         String Kode = session.getAttribute("kd").toString();
  
        %>
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="index.html">Admin Page</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">

                    <div class="input-group-append">

                        <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#modaledit">Account</a>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
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

                    <div class="isi">

                        <p>Selamat datang <%= Kode%>

                        </p>

                    </div>




                    <footer class="sticky-footer">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright © Koperasi TIM 2018</span>
                            </div>
                        </div>
                    </footer>

                </div>
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>



            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="../../logoutServlet">Logout</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal Edit --> 

            <div class="modal fade" id="modaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form action="" method="POST">
                            <div class="modal-header text-center">
                                <h4 class="modal-title w-100 font-weight-bold">Edit Akun</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body mx-3">
                                <div class="md-form mb-5" >
                                    <!--<i class="fa fa-user prefix grey-text"></i>-->
                                    <!--<label data-error="wrong" data-success="right" for="orangeForm-name" type="hidden">Kode Karyawan</label>-->
                                    <input  readonly="true" type="hidden" id="orangeForm-name" class="form-control validate" name="txtkode" value="<%= Kode%> " >
                                </div>
                                <div class="md-form mb-5" data-validate="Telepon is required">
                                    <i class="fa fa-phone"></i>
                                    <label data-error="wrong" data-success="right" for="orangeForm-name"  >Telepon</label>
                                    <input type="text" id="orangeForm-name" class="form-control validate" name="txttelepon">
                                </div>
                                <div class="md-form mb-5" data-validate="Telepon is required">
                                    <i class="fa fa-address-book"></i>
                                    <label data-error="wrong" data-success="right" for="orangeForm-name"  >Password</label>
                                    <input type="password" id="orangeForm-name" class="form-control validate" name="txtpassword">
                                </div>
                                <div class="md-form mb-5" data-validate="Telepon is required">
                                    <i class="fa fa-address-book"></i>
                                    <label data-error="wrong" data-success="right" for="orangeForm-name"  >Confirm Password</label>
                                    <input type="password" id="orangeForm-name" class="form-control validate" name="txtconfirmpass">
                                </div>
                            </div>
                            <div class="modal-footer d-flex justify-content-center">
                                <button class="btn btn-deep-orange" type="submit">Edit</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>



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

    </body>

</html>
