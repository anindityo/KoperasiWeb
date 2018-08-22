<%-- 
    Document   : anggota
    Created on : Aug 15, 2018, 8:47:05 AM
    Author     : Gusma
--%>

<%@page import="entitas.AnggotaSimpan"%>
<%@page import="entitas.Simpanan"%>
<%@page import="controllers.SimpananController"%>
<%@page import="controllers.AnggotaSimpanController"%>
<%@page import="entitas.Anggota"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="controllers.AnggotaController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="au theme templat">
        <meta name="keywords" content="au theme template">

        <!-- Title Page-->
        <title>Simpanan Anggota</title>

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
         <%AnggotaSimpanController asc = new AnggotaSimpanController(HibernateUtil.getSessionFactory());
            AnggotaController ac = new AnggotaController(HibernateUtil.getSessionFactory());
            SimpananController sc = new SimpananController(HibernateUtil.getSessionFactory());


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
                            <li>
                                <a class="js-arrow" href="home.jsp">
                                    <i class="fas fa-home"></i>Dashboard
                                </a>
                            </li>
                            <li class="active has-sub">
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
                                <form class="form-header" action="" method="POST">

                                </form>
                                <div class="header-button">
                                    <div class="account-wrap">
                                        <div class="account-item clearfix js-item-menu">
                                            <div class="content fa fa-user" style="font-size: 30px;">
                                                <a class="js-acc-btn" href="#" style="font-size: 20px;"></a>
                                            </div>
                                            <div class="account-dropdown js-dropdown">
                                                <div class="account-dropdown__body">
                                                    <div class="account-dropdown__item">
                                                        <a href="#">
                                                            <i class="zmdi zmdi-account"></i>Account</a>
                                                    </div>
                                                    <div class="account-dropdown__footer">
                                                        <a href="#">
                                                            <i class="zmdi zmdi-power"></i>Logout</a>
                                                    </div>
                                                </div>                                              
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </header>
                <!-- HEADER DESKTOP-->

                <!-- MAIN CONTENT-->
                <div class="main-content">


                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Data Table Simpanan Anggota
                        </div>
                        <div class="col-lg-6">
                            <div class="container-login100-form-btn">
                                <a class="btn btn-success" href="#" data-toggle="modal"
                                   data-target="#modaltambahanggotasimpan">Tambah </a>
                                <a class="btn btn-primary" href=""> Print</a>
                            </div>
                        </div>
                        <div class="card-body">


                            <% for (Simpanan simpanan : sc.getSimpananPokok()) {


                            %>
                            <h5>Total Simpanan Pokok = <%= simpanan.getJumlahSimpanan()%> </h5> <br>
                            <% } %>
                            <% for (Simpanan simpanan : sc.getSimpananWajib()) {


                            %>
                            <h5>Total Simpanan Wajib = <%= simpanan.getJumlahSimpanan()%> </h5>
                            <% } %>

                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Kode Anggota Simpan</th>
                                        <th>Nama Anggota</th>
                                        <th>Tanggal Simpan</th>
                                        <th>Nominal Simpan</th>
                                        <th>Jenis Simpanan</th>

                                    </tr>
                                </thead>

                                <tbody>


                                    <%            for (AnggotaSimpan as : asc.getAll()) {


                                    %>
                                    <tr>
                                        <td><%= as.getKdAnggotasimpan()%></td>
                                        <td><% out.print(as.getKdAnggota().getNamaAnggota());%> </td>
                                        <td><%= as.getTglSimpan()%></td>
                                        <td><%= as.getNominal()%></td>
                                        <td><% out.print(as.getKdSimpanan().getNamaSimpanan()); %></td>
                                        <% }%>
                                    </tr>
                                </tbody>

                            </table>
                        </div>
                    </div>

                </div>

                <div class="modal fade" id="modaltambahanggotasimpan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="../../tambahAnggotaSimpanServlet" method="POST">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold">Tambah Data</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body mx-3">
                                    <div class="md-form mb-5">
                                        <%  String kdagsimpan = asc.getAutoIdAnggotaSimpan();%>
                                        <i class="fa fa-user prefix grey-text"></i>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name">Kode Anggota Simpan</label>
                                        <input  readonly="true" type="text" id="orangeForm-name" class="form-control validate" name="txtkodeagtsimpan" value="<%= kdagsimpan%>">
                                    </div>
                                    <div class="md-form mb-5">
                                        <i class="datepicker-decades"></i>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name">Tanggal Simpan</label>
                                        <input  type="date" id="orangeForm-name" class="form-control validate" name="txttanggal" >
                                    </div>

                                    <div class="md-form mb-5">
                                        <i class="fa fa-user prefix grey-text"></i>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name">Nominal Simpan</label>
                                        <input type="text" id="orangeForm-name" class="form-control validate" name="txtnominal">
                                    </div>
                                    <div class="md-form mb-5">
                                        <i class="fa fa-phone"></i>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name"> Kode akun karyawan</label>
                                        <input type="text" id="orangeForm-name" class="form-control validate" name="txtakunkaryawan" value="KRY001">
                                    </div>
                                    <div class="md-form mb-5">
                                        <i class="fa fa-user prefix grey-text"></i>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name">Kode Anggota</label>
                                        <select  class="form-control"  name="cmbkdanggota">
                                            <% for (Anggota anggota : ac.getAll()) {


                                            %>
                                            <option value="<%= anggota.getKdAnggota()%>"><%= anggota.getKdAnggota()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                    <div class="md-form mb-5">
                                        <i class="fa fa-user prefix grey-text"></i>
                                        <label data-error="wrong" data-success="right" for="orangeForm-name"  >Nama Simpanan</label><br>
                                        Simpanan Pokok  <input type="radio" id="orangeForm-name" class="form-control validate" name="txtjenissimpanan" value="S01">
                                        Simpanan Wajib<input type="radio" id="orangeForm-name" class="form-control validate" name="txtjenissimpanan" value="S02">
                                    </div>

                                </div>
                                <div class="modal-footer d-flex justify-content-center">
                                    <button class="btn btn-deep-orange" type="submit">Tambah</button>
                                </div>
                            </form>
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


<!-- END MAIN CONTENT-->
<!-- END PAGE CONTAINER-->




<!-- Jquery JS-->
<script src="../../styleKaryawan/vendor/jquery-3.2.1.min.js"></script>
 <script src="../../styleAdmin/vendor/chart.js/Chart.min.js"></script>
        <script src="../../styleAdmin/vendor/datatables/jquery.dataTables.js"></script>
        <script src="../../styleAdmin/vendor/datatables/dataTables.bootstrap4.js"></script>

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



        <script src="../../styleAdmin/js/demo/datatables-demo.js"></script>
        <script src="../../styleAdmin/js/demo/chart-area-demo.js"></script>
</body>

</html>
<!-- end document-->
