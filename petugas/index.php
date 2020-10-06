<?php 
session_start();

if(!isset($_SESSION['petugas'])){
  echo"<script language='JavaScript'>document.location='../login_petugas.php'</script>";
  exit();
}
 
include '../admin/connect.php';

	$page = "Home";
?>



<!DOCTYPE html>
<html lang="en">
  <head>
    <?php
      include ('include/head.php');
    ?>
  </head>

  <body>
  <?php include('include/sidebar.php'); ?>
    <div id="wrapper">

    
    <div class="col-sm-6" id="hide2"> <!-- menampilkan peta-->
    <section class="panel panel-info">
          <header class="panel-heading">
                              <label style="color: black">Google Map with Location List</label>
                              <a type="button" class="btn btn-default" role="button" data-toggle="collapse" onclick="aktifkanGeolocation()" title="Current Position"   ><i class="fa fa-map-marker" style="color:black;"></i></a>
                              <a type="button" class="btn btn-default" role="button" data-toggle="collapse" onclick="manualLocation()" title=" Manual Position"><i class="fa fa-location-arrow" style="color:black;"></i></a>
                              <a type="button" class="btn btn-default" role="button" data-toggle="collapse" href="#terdekat" title="Nearby" aria-controls="terdekat"><i class="fa fa-road" style="color:black;"></i></a>
                              <label id="tombol">
                              <div class="collapse" id="terdekat">
                              <div class="well">
                              <label><b>Radius&nbsp</b></label><label style="color:black" id="km"><b>0</b></label>&nbsp<label><b>m</b></label><br>
                              <input  type="range" onclick="cek();aktifkanRadius();resultt()" id="inputradiusmes" name="inputradiusmes" data-highlight="true" min="1" max="20" value="1" >
                              </div>
                              </div>   
                              <label id="tombol">
                                <a type="button" onclick="legenda()" id="showlegenda" class="btn btn-default" data-toggle="tooltip" title="Legenda" style="margin-right: 7px;"><i class="fa fa-eye"></i>
                                </a>     
                              </label>
                      </header>
                      
              
                  
                        <div class="panel-body">
                            <div id="map" style="width:100%;height:400px; z-index:60"></div> 
                        </div>
                  </section>
              </div>


    <div class="table-responsive">
<table class="table table-striped table-hover tablesorter">
  <thead>
    <tr>
      <th style='text-align:center; width:50px;'> </th>
      <th style='text-align:center'>No </th>
      <th style='text-align:center'>Reporter </th>
      <th style='text-align:center'>Phone</th>
      <th style='text-align:center'>Location  </th>
      <th style='text-align:center'>Status</th>
    </tr>
  </thead>
  <tbody>
  <script type="text/javascript" language="JavaScript">
              function accept()
              {
              tanya = confirm("Accept this report ?");
              if (tanya == true) return true;
              else return false;
              }
            </script>
  <?php
  
  $no=1;
  $hapus="hapus?";
  $tanggal = date('d-m-Y');
  $jam = date('H:i:s'); 
  
  $query = pg_query("SELECT * FROM detail_pelapor INNER JOIN orang ON 
                    (detail_pelapor.id_orang = orang.id_orang) where tanggal = '$tanggal'");
  
          while ($row=pg_fetch_array($query)){
            
            echo "
            <form method='post' action='ubah_status_pelaporan.php?id_laporan=".$row['id_laporan']."' enctype='multipart/form-data'>
            <tr>
                <td style='text-align:center'><a href='input_laporan.php?id_laporan=".$row['id_laporan']."'><i class='fa fa-pencil'></i></a>&nbsp;&nbsp;<a role='button'   onclick='detailinforepo(\"".$row['id_laporan']."\")'><span style='color:green'><i class='fa fa-map-marker'>&nbsp;</i></span></a></td>
                
                <td style='text-align:center'>$no</td>
                <td style='text-align:center'>".$row['nama_orang']."</td>
                <td style='text-align:center'>".$row['no_hp']."</td>
                <td style='text-align:center'>".$row['lokasi']."</td>
                <td style='text-align:center'>
                  <select id='status_pelaporan' name='status_pelaporan' class='custom-select'>
                    <option selected  value='".$row['status_pelaporan']."'>".$row['status_pelaporan']."</option>
                    <option  value='New Report'>New Report</option>
                      <script type='text/javascript' language='JavaScript'>
                        function konfirmasi()
                        {
                        tanya = confirm('Do you want to change the status? ?');
                        if (tanya == true) return true;
                        else return false;
                        }
                      </script>
                    <option style='color: blue' value='On progress'>Accept</></option>
                    <option style='color: red' value='Rejected'>Rejected</option>
                    <option style='color: green' value='Done'>Done</option>
                  </select>
                  &nbsp;&nbsp;
                  <button class='btn btn-warning' onclick='return konfirmasi()' type='submit' value='simpan'>ok</button></td></tr>
                </td>
               
                </form>";
            $no++;
        }
        ?>
  </tbody>
</table>
     

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <?php
      include ("../admin/connect.php");
    ?>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&callback=initMap">
    </script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../admin/script.js" type="text/javascript"></script>
    
  </body>
</html>