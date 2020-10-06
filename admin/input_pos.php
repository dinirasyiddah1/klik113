<?php 
session_start();
include 'connect.php';

	$page = "Fire Station";

?>
<!DOCTYPE html>
<html>
  <head>
  <?php
      include ('include/head.php');
    ?>
  </head>
  <body>
  <?php include('include/sidebar.php'); ?>
  <div id="wrapper">
      <div class="col-sm-6" id="hide2"> <!-- menampilkan peta-->
                  <section class="panel">
                      <header class="panel-heading">
                          <h3>
                          <form class="form-inline">
                              <input id="latlng" type="text" class="form-control" style="width:200px" value="" placeholder="Latitude, Longitude">
                              <button class="btn btn-default my-btn" id="btnlatlng" type="button" title="Geocode"><i class="fa fa-search"></i></button>
                              <button class="btn btn-default my-btn" id="delete-button" type="button" title="Remove shape"><i class="fa fa-trash-o" ></i></button> 
                          </form>
                        </h3>
              
                      </header>
                      <div class="panel-body">
                          <div id="map" style="width:100%;height:420px; z-index:50"></div>
                      </div>
                  </section>
              </div>
			  
<div class="col-lg-6">
<div class="panel-body">
        <form method="post" action="input_pos_aksi.php" enctype="multipart/form-data">
                <table>
                
                <div class="form-group">
                  <label for="geom"><span style="color:red">*</span> Coordinat</label>
                  <textarea class="form-control" id="geom" name="geom" autocomplete="off" readonly required></textarea>
                </div>
                <div class="form-group">
                  <label for="nama"><span style="color:red">*</span> Fire Station Name</label>
                  <input type="text" class="form-control" id="nama" name="nama_pos" value="" autocomplete="off" required>
                </div>
                
                <div class="form-group">
                    <label for="alamat">Address</label>
                    <input type="text" class="form-control" id="alamat" name="alamat" autocomplete="off">
                </div>
                    
                <div class="form-group">
                  <label for="image">Picture</label>
                  <input type="file"id="image" class="form-control-file" name="gambar[]" multiple>
                  <br>
                </div>	
                    </td></tr>
                    <tr><td colspan="2"><button class="btn btn-warning" type="submit" name="simpan" value="simpan">Save</button></td></tr>
                </table>
        </form>
        </div>
        </div>


    <!-- JavaScript -->
    <?php
      include ("connect.php");
    ?>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing">
    </script>
    <script src="map_pos.js" type="text/javascript"></script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>  
  </body>
</html>