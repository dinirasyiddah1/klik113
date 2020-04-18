<?php 
session_start();
include 'admin/connect.php';
	$page = "Home";
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <?php
      include ('include/head.php');
    ?>

<script type="text/javascript">

var server = "http://localhost/klik113/";
var map;
var markersDua = [];
var koordinat = 'null'
var infoposisi = [];
var markerposisi = [];
var centerLokasi;
var markerposisi = [];
var centerBaru;
var cekRadiusStatus = "off"; 
var circles = [];
var rad;
var fotosrc = 'image/';
var angkot = [];
var directionsDisplay;
var infoDua=[];
var rute = [];

//Membuat Fungsi Menampilkan Seluruh pos damkar
function viewkej()
{
  hapusMarkerTerdekat();
  hapusRadius();
  hapusInfo();
  clearroute2();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $.ajax
  ({ 
    url: server+'viewpos.php', data: "", dataType: 'json', success: function(rows) 
    { 
      if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        $('#hasilcari').append("<thead><th>Name</th><th colspan='3'>Action</th></thead>");
        console.log(rows);
        for (var i in rows) 
        { 
          var row = rows[i];
          var id = row.id_pos_damkar;
          var name = row.nama_pos;
          var address=row.addrealamatss;
         
          var lat=row.lat;
          var lon = row.lng;
          //var ik_status = row.ik_status;
          console.log(name);
          centerBaru = new google.maps.LatLng(lat, lon);
          map.setCenter(centerBaru);
          map.setZoom(15);  
          var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/cul.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
           $('#hasilcari').append("<tr><td>"+name+"</td><td><a role='button' class='btn btn-success' onclick='detculi(\""+id+"\");detailinfokul(\""+id+"\");'>Show</a></td><td><a role='button' class='btn btn-danger fa fa-taxi' onclick='kulAngkot(\""+id+"\")'></a></td></tr>");
        }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });           
}

</script>
  </head>

  <body>
  <?php include('include/sidebar.php'); ?>
    <div id="wrapper">

      <section class="wrapper site-min-height">
          <div class="row mt">
          <div class="col-sm-7" id="hide2">
          <div class="panel-body">
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
              </div>
              <div class="col-md-5">
              <div class="panel-body">
              <section class="panel panel-success">
              <header class="panel-heading" text-align="center" >
                              <center><b>Result</b></center>
                              </header>

                              <div class="panel-body" > 
                                <div class="form-group" id="hasilcari1" style="display:none">
                                  <table class="table table-bordered" id='hasilcari'>
                                  </table>                    
                                </div>
                              </div>
                            </div>
        </div>
      </section>
      </div>

    </div><!-- /#wrapper -->

    

    <!-- JavaScript -->
    <?php
      include ("admin/connect.php");
    ?>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&callback=initMap">
    </script>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="admin/script.js" type="text/javascript"></script>
    
  </body>
</html>