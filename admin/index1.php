<?php 
session_start();
include 'connect.php';
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

      <section class="wrapper site-min-height">
          <div class="row mt">
              <div class="col-sm-6" id="hide2">
                  <section class="panel">
                      <header class="panel-heading">
                          <label style="color: black">Google Map with Location List</label>
                          <a class="btn btn-default" role="button" data-toggle="collapse" onclick="aktifkanGeolocation()" title="Current Position"   ><i class="fa fa-map-marker" style="color:black;"></i></a>
                          <a class="btn btn-default" role="button" data-toggle="collapse" onclick="manualLocation()" title=" Manual Position"><i class="fa fa-location-arrow" style="color:black;"></i></a>
                    <a class="btn btn-default" role="button" data-toggle="collapse" href="#terdekat" title="Nearby" aria-controls="terdekat"><i class="fa fa-road" style="color:black;"></i></a>
                    <a class="btn btn-default" role="button" data-toggle="collapse" onclick="tampilsemua();resultt()" title="All Mosque" aria-controls="terdekat"><i class="fa fa-map-pin" style="color:black;"></i></a>
                    <label id="tombol">
                    <a class="btn btn-default" role="button" id="showlegenda" data-toggle="collapse" onclick="legenda()" title="Legend"   ><i class="fa fa-eye" style="color:black;"></i></a></label>
                      <label></label>         
                    <div class="collapse" id="terdekat">
                    <div class="well">
                    <label><b>Radius&nbsp</b></label><label style="color:black" id="km"><b>0</b></label>&nbsp<label><b>m</b></label><br>
                    <input  type="range" onclick="cek();aktifkanRadius();resultt()" id="inputradiusmes" name="inputradiusmes" data-highlight="true" min="1" max="20" value="1" >
                    </div>
          </div>
					

               </h3>
                      </header>
                        <div class="panel-body">
                            <div id="map" style="width:100%;height:400px; z-index:60"></div>
                        </div>
                  </section>
     

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <?php
      include ("connect.php");
    ?>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&callback=initMap">
    </script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="script.js" type="text/javascript"></script>
    
  </body>
</html>