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

        
        <?php
          include "connect.php";

          $id=$_GET['id_pos_damkar'];
          $data=pg_query("SELECT * FROM public.pos_damkar WHERE id_pos_damkar='$id'")or die(pg_error());
          
          
          $hasil=pg_fetch_array($data);
          // $no=1;
          // while($hasil=pg_fetch_array($data)){ 
          //   $img=$hasil['images'];
        ?>
        <form method="post" action="update_pos.php?id_pos_damkar=<?=$id;?>" enctype="multipart/form-data">
                <table>
                
                <div class="form-group">
                <input type="hidden" name="" id="id" name="id_pos_damkar" value="<?=$id; ?>">
                      
                  <label for="geom"><span style="color:red">*</span> Coordinat</label>
                  <?php 
                     $query_geom = pg_query("SELECT ST_AsText(geom) As geom
                        FROM public.pos_damkar
                        WHERE id_pos_damkar = '$id'");
                     $data_geom=pg_fetch_array($query_geom);
                          ?>
                      <textarea class="form-control readonly" id="geom" name="geom" autocomplete="off" value="<?=$data_geom['geom'];?>"  required><?=$data_geom['geom']; ?></textarea>
                      <script>
                        $(".readonly").on('keydown paste', function(e){
                            e.preventDefault();
                        });
                    </script>  
                </div>
                <div class="form-group">
                  <label for="nama_pos"><span style="color:red">*</span> Fire Station Name</label>
                  <input type="text" class="form-control" id="nama_pos" name="nama_pos" value="<?=$hasil['nama_pos'];?>" required>
                </div>
                <div class="form-group">
                    <label for="alamat">Alamat</label>
                    <input type="text" class="form-control" id="alamat" name="alamat" value="<?=$hasil['alamat'];?>">
                </div>
                <div class="form-group">
                  <label for="image">Gambar</label>
                  <input type="file"id="image" class="form-control-file" name="gambar[]" value="<?=$hasil['image'];?>" multiple>
                  
                  
                  <br>
                </div>	
                    </td></tr>
                    <tr><td colspan="2"><button class="btn btn-warning" type="submit" value="simpan">SIMPAN</button></td></tr>
                </table>
        </form>
        </div>
        </div>


    <!-- JavaScript -->
    <?php
      include ("connect.php");
    ?>
    <!-- <script>
      // This example requires the Drawing library. Include the libraries=drawing
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=drawing">
      function initMap() {
        map = new google.maps.Map(
        document.getElementById('map'), 
          {
              zoom: 10,
              center: new google.maps.LatLng(-0.9330859, 100.3610945),
              mapTypeId: google.maps.MapTypeId.ROADMAP
          }
        );
        var drawingManager = new google.maps.drawing.DrawingManager({
          drawingMode: google.maps.drawing.OverlayType.MARKER,
          drawingControl: true,
          drawingControlOptions: {
            position: google.maps.ControlPosition.TOP_CENTER,
            drawingModes: ['marker', 'circle', 'polygon', 'polyline', 'rectangle']
          },
          markerOptions: {icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'},
          circleOptions: {
            fillColor: '#ffff00',
            fillOpacity: 1,
            strokeWeight: 5,
            clickable: false,
            editable: true,
            zIndex: 1
          }
        });
        drawingManager.setMap(map);
      }
    </script> -->
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing">
         
    </script>
    <script src="map_pos.js" type="text/javascript"></script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <!-- <script src="script.js" type="text/javascript"></script> -->
    
    <!-- <script src="map.js" type="text/javascript"></script> -->



    
  </body>
</html>