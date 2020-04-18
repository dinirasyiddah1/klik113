
<?php 
session_start();
include 'connect.php';

	$page = "Fire Incident";

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

          $id=$_GET['id_kejadian'];
         
          $data=pg_query("SELECT * FROM public.kejadian 
                                WHERE kejadian.id_kejadian='$id'")or die(pg_error());                      
          
         $hasil=pg_fetch_array($data); 
          
          //$hasil=pg_fetch_array($data) 
            //$img=$hasil['images'];
        ?>
        <form method="post" action="update_incident.php" enctype="multipart/form-data">
        <table>
                <div class="form-group">
                    <label for="orang">People involved</label>
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Data Entry</button>  
                    <br>
                    
                      <label for="geom"><span style="color:red">*</span> Coordinat</label>
                     <?php 
                     $query_geom = pg_query("SELECT ST_AsText(geom) As geom
                        FROM public.kejadian
                        WHERE id_kejadian = '$id'");
                     $data_geom=pg_fetch_array($query_geom);
                          ?>
                      <textarea class="form-control readonly" id="geom" name="geom" autocomplete="off" value="<?=$data_geom['geom'];?>"  required><?=$data_geom['geom']; ?></textarea>
                      <script>
                        $(".readonly").on('keydown paste', function(e){
                            e.preventDefault();
                        });
                    </script>
                </div> 
                    <label for="id">1. <span style="color:red">*</span> Date & Time </label><br>
                    <div class="panel panel-default">    
                    <div class="form-group panel-body">
                      <input type="date" class="form-control" name="tanggal" value="<?=$hasil['tanggal'];?>" required>
                      <input type="time" class="form-control" name="jam" value="<?=$hasil['jam'];?>"required> 
                   <br>
                    <label for="id"><span style="color:red">*</span> Picket Team </label>
                      <select name="regu_piket" onchange="changeValue(this.value)" required>
                      <?php
                          $query=pg_query("SELECT * FROM kejadian
                                    INNER JOIN regu_piket ON regu_piket.id_regu=kejadian.id_regu
                                    WHERE kejadian.id_kejadian='$id'");
                          $data=pg_fetch_array($query);
                          var_dump($data);
                        ?>
                      <option value="<?=$data['id_regu']?>">Team <?=$data['nama_regu']?></option>
                          <?php
                              $query = "SELECT * FROM regu_piket";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                                
                          ?>
                          <option value="<?=$row['id_regu']?>" required>Team <?=$row['nama_regu']?></option>
                          <?php    
                              };   
                                ?>
                      </select>
                    </div>
                </div>
                
                <div class="panel panel-default">    
                    <div class="form-group panel-body">
                    <label for="jenis_kejadian">2. Type Of Incident</label>
                    <?php
            
                  $query1 = pg_query("SELECT * FROM kejadian
                          INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian = kejadian.id_kejadian
                          INNER JOIN objek_terbakar ON objek_terbakar.id_objek = detail_objek_terbakar.id_objek 
                          WHERE kejadian.id_kejadian='$id'
                          ");
                  $hasil1 = pg_fetch_array($query1);
            ?>
                    <input type="text" class="form-control" id="jenis_kejadian" name="jenis_kejadian" value="<?=$hasil1['jenis_kejadian'];?>" autocomplete="off">
                    <br>
                    &nbsp;<label for="objek_terbakar">Burning Object</label>&nbsp;
                    <select name="objek_terbakar">
                       <option value="<?=$hasil1['id_objek']?>"><?=$hasil1['nama_objek']?></option>
                          <?php
                              $query = "SELECT * FROM objek_terbakar";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_objek']?>" required><?=$row['nama_objek']?></option>
                          <?php    
                              };   
                                ?>
                          
                        <option>-- Add new --</option>
                  </select>
                </div>
                </div>
                <div class="panel panel-default">    
                    <div class="form-group panel-body">
                    <label for="penyebab">3. The Cause Of The Incident</label>
                    <?php
            
                  $query_peny = pg_query("SELECT * FROM kejadian
                          INNER JOIN detail_penyebab ON detail_penyebab.id_kejadian = kejadian.id_kejadian
                          INNER JOIN penyebab ON penyebab.id_penyebab = detail_penyebab.id_penyebab 
                          WHERE kejadian.id_kejadian='$id'
                          ");
                  $hasil_peny = pg_fetch_array($query_peny);
            ?>
                    <input type="text" class="form-control" id="penyebab" name="penyebab" value="<?=$hasil_peny['penyebab'];?>" autocomplete="off">
                    <br>
                    &nbsp;<label for="penyebab_terbakar">Category Of Cause</label>&nbsp;
                    <select name="penyebab_terbakar">
                       <option value="<?=$hasil_peny['id_penyebab']?>"><?=$hasil_peny['nama_penyebab']?></option>
                          <?php
                              $query = "SELECT * FROM penyebab";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_penyebab']?>" required><?=$row['nama_penyebab']?></option>
                          <?php    
                              };   
                                ?>
                          
                        <option>-- Add new --</option>
                  </select>
                </div>
                </div>
                <div class="form-group">
                    <label for="lokasi">4. Location</label>
                    <input type="text" class="form-control" id="lokasi" name="lokasi" value="<?=$hasil['lokasi'];?>" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="pelapor">5. Reported By <span style="color:red">*</span></label>
                    <select name="pelapor" onchange="changeValue(this.value)">
                      
                    <?php
                              $query = "SELECT * FROM kejadian
                                          INNER JOIN detail_pelapor ON detail_pelapor.id_kejadian = kejadian.id_kejadian
                                          INNER JOIN orang ON orang.id_orang = detail_pelapor.id_orang
                                          WHERE kejadian.id_kejadian = '$id'";
                              $sql=pg_query($query) or die (pg_error());
                              $data_pelapor = pg_fetch_array($sql);
                          ?>
                          
                          <option value="<?=$data_pelapor['id_orang']?>" required><?=$data_pelapor['nama_orang']?></option>
                          <?php
                          $query = pg_query("SELECT * FROM orang");
                          while ($row = pg_fetch_assoc($query)) {
                            ?>
                          <option value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                          <?php    
                              };   
                                ?>
                        
                      </select>
                    
                    <input type="text" class="form-control" id="no_hp" name="no_hp" value="<?=$data_pelapor['no_hp']?>" autocomplete="off">
                </div>
                
                    <label for="pemilik">6. Owner</label>
            <div class="panel panel-default"> 
              <div class="form-group panel-body"> 
                <label for="pemilik">Owner</label><br>
                <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show1'> + Enter owner data</button>
                <select name="pemilik" class="pemilik" id='pemilik' required>
                  <?php
                    $query = pg_query("SELECT * from kejadian
                                  INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian=kejadian.id_kejadian
                                  INNER JOIN orang ON orang.id_orang = detail_objek_terbakar.id_orang
                                  WHERE kejadian.id_kejadian = '$id'");
                    $data_pemilik = pg_fetch_array($query);
                  ?>
                
                <option value="<?=$data_pemilik['id_orang']?>" required><?=$data_pemilik['nama_orang']?></option>
                          
                          <?php
                              $query = "SELECT * FROM orang";
                              $sql=pg_query($query) or die (pg_error());
                             
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option name="pemilik" value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                          
                          <?php   
                          
                          };   
                                ?>

                          <!-- ajax -->
                    <!-- <script type="text/javascript">
                      $(document).ready(function(){
                        $(".pemilik").on('change',function(){

                          const pemilik = $( "#pemilik" ).val();
                          // var data = $('.pemilik').serialize();
                          // console.log(pemilik);
                        
                          $.ajax({
                            type: 'POST',
                            url: "owner_aksi.php",
                            data: {pemilik : pemilik },
                            success: function(res) {
                              let response = JSON.parse(res);
                              $('.tampildata').empty();
                              $('.tampildata').html(response.data);
                            },
                            error: function() {
                              $('.tampildata').empty();
                              $('.tampildata').html('data tidak masuk');
                            }
                          });
                        });
                      });
                      </script> -->


                  </select>
                  <div class="tampildata"></div>
                 

                    


                <br>
                    <label for="id_saksi">Witness <span style="color:red">*</span></label> &nbsp; 
                    <br>
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Enter witness data</button>
                    <select id="saksi" name="saksi" required>
                      <?php
                       
                        $query = pg_query("SELECT * from kejadian
                                      INNER JOIN detail_saksi ON detail_saksi.id_kejadian=kejadian.id_kejadian
                                      INNER JOIN orang ON orang.id_orang = detail_saksi.id_orang
                                      WHERE kejadian.id_kejadian = '$id'");
                        $data_saksi = pg_fetch_array($query);
                      ?>
                   <option value="<?=$data_saksi['id_orang']?>" required><?=$data_saksi['nama_orang']?></option>
                       <?php
                              $query = "SELECT * FROM orang";
                              $sql=pg_query($query) or die (pg_error());
                             
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                          
                          <?php    
                          };   
                                ?>
                        <option>-- Add new --</option>
                  </select>

                   <br>
                 </div>
                
              </div>
              </div>
              
                <label for="personil">7. Personnel</label>
                <div class="panel panel-default">
                  <div class="form-group panel-body"> 
                      <label for="personil">Number of personnel</label>
                          <?php
                            $query = pg_query("SELECT * from kejadian
                                INNER JOIN detail_instansi ON detail_instansi.id_kejadian=kejadian.id_kejadian
                                INNER JOIN instansi ON instansi.id_instansi = detail_instansi.id_instansi
                                WHERE kejadian.id_kejadian = '$id'");
                            $data_instansi = pg_fetch_array($query);
                          ?>
                      <input type="text" class="form-control" id="personil" name="personil" value="<?=$data_instansi['jumlah_personil']?>" autocomplete="off">
                    <br>
                      <label for="instansi">Agent involved</label>
                      <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Enter agent data</button>
                      
                      <select id="instansi" name="instansi[]" class="form-control" required multiple="multiple" > 
                    
                      <?php
                              $query_instansi = pg_query("SELECT * FROM instansi");
                              while ($instansi = pg_fetch_array($query_instansi)) {
                          ?>
                          <option value="<?=$instansi['id_instansi']?>" ><?=$instansi['nama_instansi']?></option>

                        <?php
                          }
                        ?>
                          <option>-- Add new --</option>
                    </select>
                    <?php
                      $query_id = pg_query("SELECT min(detail_instansi.id_instansi) AS minid FROM kejadian
                          INNER JOIN detail_instansi ON detail_instansi.id_kejadian=kejadian.id_kejadian
                          INNER JOIN instansi ON instansi.id_instansi = detail_instansi.id_instansi
                          WHERE kejadian.id_kejadian = '$id'");
                      $data = pg_fetch_array($query_id);
                      $id_instansi = $data['minid'];
                      
                      $query = pg_query("SELECT * FROM kejadian
                                  INNER JOIN detail_instansi ON detail_instansi.id_kejadian=kejadian.id_kejadian
                                  INNER JOIN instansi ON instansi.id_instansi = detail_instansi.id_instansi
                                  WHERE detail_instansi.id_instansi = '$id_instansi'");
                      
                      while($data_ins = pg_fetch_array($query)){
                      ?>
                      <input type="text" class="form-control" id="instansi" name="instansi" value="<?=$data_ins['nama_instansi']?>" autocomplete="off">
                    
                      <?php
                      $id_instansi++;
                      }
                    ?>
                    
                      
                      <br>
                    <label for="kendaraan">Vehicle / Equipment</label>
                      <input type="text" class="form-control" id="kendaraan" name="kendaraan" autocomplete="off">
                  </div>   
                </div>
                <div class="form-group">
                  <label for="kronologis">8. Chronology</label>
                  <textarea class="form-control" id="kronologis" name="kronologis" value="<?=$hasil['kronologis']?>" autocomplete="off"><?=$hasil['kronologis'];?></textarea>
                </div>
                
                <label for="korban">9. Due to events</label>
                <div class="panel panel-default"> 
                <div class="form-group panel-body"> 
                  <label for="korban">Victim</label>
                  <?php
                 $query = "SELECT * FROM orang
                             INNER JOIN detail_korban ON orang.id_orang = detail_korban.id_korban
                             INNER JOIN kejadian ON kejadian.id_kejadian = detail_korban.id_kejadian
                             INNER JOIN suku ON suku.id_suku = orang.id_suku
                             where kejadian.id_kejadian = '$id'";
                 $sql=pg_query($query) or die (pg_error());
                 $korban = pg_fetch_assoc($sql);

                 if($korban['id_korban']==[]){
                     echo '
                     <input type="text" class="form-control" id="korban" name="korban" value="nihil" autocomplete="off">
                     ';
                 }else{
                     echo '
                     <input type="text" class="form-control" id="korban" name="korban" value="'.$korban["nama_orang"].' / '.$korban["umur_orang"].' Th" autocomplete="off">
                     ';
                 };

            ?>
                  
                <br>
                    <label for="kerusakan">Damage</label>
                    <input type="text" class="form-control" id="kerusakan" name="kerusakan" value="<?=$hasil['kerusakan'];?>" autocomplete="off">
                <br>
                    <label for="luas_area">Area</label>
                    <input type="text" class="form-control" id="luas_area" name="luas_area" value="<?=$hasil['luas_area'];?>" autocomplete="off">
                <br> 
                    <label for="taksiran_kerugian">estimated loss</label>
                    <input type="text" class="form-control" id="taksiran_kerugian" name="taksiran_kerugian" value="<?=$hasil['taksiran_kerugian'];?>" autocomplete="off">
                </div>
                </div>
                <div class="form-group">
                  <label for="image">Gambar</label>
                  <input type="file"id="image" class="form-control-file" name="gambar[]" multiple>
                  <?php
                    $query_gambar = pg_query("SELECT * from kejadian
                                        INNER JOIN gambar_kejadian ON gambar_kejadian.id_kejadian = kejadian.id_kejadian
                                        WHERE kejadian.id_kejadian = '$id'");
                    $gambar=0;
                    while($data_gambar = pg_fetch_array($query_gambar)){
                      $data_gambar['nama_photo'];
                      $gambar++;
                    };
                    echo "(" .$gambar. " files)";
                  ?>
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
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing&callback=initMap">
         
    </script>
    <script src="map_incident.js" type="text/javascript"></script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <!-- <script src="script.js" type="text/javascript"></script> -->
    
    <!-- <script src="map.js" type="text/javascript"></script> -->



    
  </body>
</html>