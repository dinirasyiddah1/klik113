
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
    <link rel="stylesheet" href="../assets/css/select2.min.css"/>
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
        <form method="post" action="update_incident.php?id_kejadian=<?=$id;?>" enctype="multipart/form-data">
        <table>
                <div class="form-group">
                    <br>
                      <input type="hidden" name="" id="id_kej" value="<?=$id; ?>">
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
                      <select id="regu_piket" class="form-control" name="regu_piket" required>
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
                    <?php $objek_sql = pg_query("SELECT * FROM kejadian
                                INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian = kejadian.id_kejadian
                                INNER JOIN objek_terbakar ON objek_terbakar.id_objek = detail_objek_terbakar.id_objek 
                                WHERE kejadian.id_kejadian='$id'
                                ");
                                while($objek_x = pg_fetch_array($objek_sql)){
                          ?>
                    <input type="text " name="id_objk" id="id_objk" value="<?=$objek_x['id_objek']?>">
                                <?php $i++; }?>
                    <select name="objek_terbakar[]" id="objek_terbakar" class="form-control" multiple="multiple" required>
                          <?php $objek = pg_query("SELECT * FROM kejadian
                                INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian = kejadian.id_kejadian
                                INNER JOIN objek_terbakar ON objek_terbakar.id_objek = detail_objek_terbakar.id_objek 
                                WHERE kejadian.id_kejadian='$id'
                                ");
                                while($objekx = pg_fetch_array($objek)){
                          ?>
                       <option selected value="<?=$objekx['id_objek']?>"><?=$objekx['nama_objek']?></option>
                       
                          <?php
                                };
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
                    &nbsp;<label for="kategori_penyebab">Category Of Cause</label>&nbsp;
                    <select id="kategori_penyebab" name="kategori_penyebab[]" class="form-control" multiple="multiple" required>
                       <?php
                          $penyebab = pg_query("SELECT * FROM kejadian
                          INNER JOIN detail_penyebab ON detail_penyebab.id_kejadian = kejadian.id_kejadian
                          INNER JOIN penyebab ON penyebab.id_penyebab = detail_penyebab.id_penyebab 
                          WHERE kejadian.id_kejadian='$id'
                          ");
                          while($penyebabx = pg_fetch_array($penyebab)){
                       ?>
                       <option selected disabled value="<?=$penyebabx['id_penyebab']?>"><?=$penyebabx['nama_penyebab']?></option>
                              <?php
                              }
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
                

                <div class="panel panel-default">    
                    <div class="form-group panel-body">
                    <label for="lokasi">4. Location</label>
                    <input type="text" class="form-control" id="lokasi" name="lokasi" value="<?=$hasil['lokasi'];?>" autocomplete="off">
                  <br>
                  &nbsp;&nbsp;&nbsp;&nbsp;<label for="rtrw">RT / RW</label>&nbsp;
                  <br>
                  <div class="col-sm-6">
                  <input type="text" class="form-control" id="rt" name="rt" value="<?=$hasil['rt'];?>" autocomplete="off">
                  </div>
                  <div class="col-sm-6">
                  <input type="text" class="form-control"  id="rw" name="rw" value="<?=$hasil['rw'];?>" autocomplete="off">
                 </div>
                  <br><br><br>
                  <label for="kelurahan">Village</label>
                    <input type="text" class="form-control" id="kelurahan" name="kelurahan" value="<?=$hasil['kelurahan'];?>" autocomplete="off">
                  
                </div>
                </div>
                <br>
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Enter Data of People Involved</button>  
                    <br><br>
                <div class="form-group">
                    <label for="pelapor">5. Reported By <span style="color:red">*</span></label>
                    <select name="pelapor[]" id="pelapor" class="form-control" multiple="multiple" required onchange="changeValue(this.value)">
                      
                    <?php
                              $query = "SELECT * FROM kejadian
                                          INNER JOIN detail_pelapor ON detail_pelapor.id_kejadian = kejadian.id_kejadian
                                          INNER JOIN orang ON orang.id_orang = detail_pelapor.id_orang
                                          WHERE kejadian.id_kejadian = '$id'";
                              $sql=pg_query($query) or die (pg_error());
                              $jsArray = "var NoHp = new Array();\n";
                              while($data_pelapor = pg_fetch_array($sql)){
                          ?>
                          
                          <option selected  value="<?=$data_pelapor['id_orang']?>" required><?=$data_pelapor['nama_orang']?></option>
                          <?php
                              }
                          $query = pg_query("SELECT * FROM orang");
                          $jsArray = "var NoHp = new Array();\n";
                          while ($row = pg_fetch_assoc($query)) {
                            ?>
                          <option value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                          <?php    
                          $jsArray .= "NoHp['".$row['id_orang']."'] = {satu:'".addslashes($row['no_hp'])."'};\n";
                              };   
                                ?>
                        
                      </select>
                    <br><br>
                    <input type="text" class="form-control" id="no_hp" name="no_hp" value="<?=$data_pelapor['no_hp']?>" autocomplete="off">
                </div>
                
                    <label for="pemilik">6. Owner</label>
            <div class="panel panel-default"> 
              <div class="form-group panel-body"> 
                <label for="pemilik">Owner</label><br>
                <?php
                    $query_pem = pg_query("SELECT * from kejadian
                                  INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian=kejadian.id_kejadian
                                  INNER JOIN orang ON orang.id_orang = detail_objek_terbakar.id_orang
                                  WHERE kejadian.id_kejadian = '$id'");
                   $i=0;
                    while ($pemilik =  pg_fetch_array($query_pem))
                    {
                   
                  ?>
                <input type="text" name="id_pemilik<?=$i;?>" id="id_pemilik<?=$i;?>" value="<?=$pemilik['id_orang'];?>">
                    <?php $i++; }?>
                <select name="pemilik[]" class="form-control" id='pemilik' multiple="multiple" required>
                  <?php
                    $query = pg_query("SELECT * from kejadian
                                  INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian=kejadian.id_kejadian
                                  INNER JOIN orang ON orang.id_orang = detail_objek_terbakar.id_orang
                                  WHERE kejadian.id_kejadian = '$id'");
                    while($data_pemilik = pg_fetch_array($query)){
                  ?>
                
                <option selected value="<?=$data_pemilik['id_orang']?>" required><?=$data_pemilik['nama_orang']?></option>
                          
                          <?php
                    }
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
                    <select id="saksi" name="saksi[]" class="form-control" multiple="multiple" required>
                      <?php
                       
                        $query = pg_query("SELECT * from kejadian
                                      INNER JOIN detail_saksi ON detail_saksi.id_kejadian=kejadian.id_kejadian
                                      INNER JOIN orang ON orang.id_orang = detail_saksi.id_orang
                                      WHERE kejadian.id_kejadian = '$id'");
                        while($data_saksi = pg_fetch_array($query)){
                      ?>
                   <option selected value="<?=$data_saksi['id_orang']?>" required><?=$data_saksi['nama_orang']?></option>
                       <?php
                        }
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
                   <br>

                      <div class="col-sm-7">
                      <select id="instansi" name="instansi[]" class="form-control" required multiple="multiple" > 
                      <?php
                            $instansi_query = pg_query("SELECT nama_instansi FROM kejadian
                                              INNER JOIN detail_instansi ON detail_instansi.id_kejadian = kejadian.id_kejadian
                                              INNER JOIN instansi ON instansi.id_instansi = detail_instansi.id_instansi
                                              WHERE kejadian.id_kejadian = '$id'");
                            while($instansi_data = pg_fetch_array($instansi_query)){
                            
                          ?>
                          <option selected="selected" value="<?=$instansi_data['id_instansi'];?>"><?=$instansi_data['nama_instansi'];?></option>
                      <?php
                            };
                              $query_instansi = pg_query("SELECT * FROM instansi");
                              while ($instansi = pg_fetch_array($query_instansi)) {
                          ?>
                          <option value="<?=$instansi['id_instansi']?>" ><?=$instansi['nama_instansi']?></option>

                        <?php
                          }
                        ?>
                    </select>
                    </div>
                    <div class="col-sm-5">
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show1'> + Enter agent data</button>
                    </div> 
                   
                      <br><br>
                    <label for="kendaraan">Vehicle / Equipment</label>
                    <select id="kendaraan" name="kendaraan[]" class="form-control" required multiple="multiple" > 
                    <?php
                            $kendaraan_query = pg_query("SELECT nama_kendaraan FROM kejadian
                                              INNER JOIN detail_kendaraan ON detail_kendaraan.id_kejadian = kejadian.id_kejadian
                                              INNER JOIN kendaraan ON kendaraan.nomor_plat = detail_kendaraan.nomor_plat
                                              WHERE kejadian.id_kejadian = '$id'");
                            while($kendaraan_data = pg_fetch_array($kendaraan_query)){
                            
                          ?>
                          <option selected="selected" value="<?=$kendaraan_data['nomor_plat'];?>"><?=$kendaraan_data['nama_kendaraan'];?></option>
                    <?php
                            };
                            $query_kendaraan = pg_query("SELECT * FROM kendaraan");
                            while ($kendaraan = pg_fetch_array($query_kendaraan)) {
                        ?>
                        <option value="<?=$kendaraan['nomor_plat']?>" >Unit <?=$kendaraan['nama_kendaraan']?></option>

                      <?php
                        }
                      ?>
                        <option>-- Add new --</option>
                  </select>
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
                  <br>
                <div class="col-sm-7">
                  <select id="korban" name="korban[]" class="form-control" multiple="multiple">
                  <?php
                       
                       $query_korban = pg_query("SELECT * from kejadian
                                     INNER JOIN detail_korban ON detail_korban.id_kejadian=kejadian.id_kejadian
                                     INNER JOIN orang ON orang.id_orang = detail_korban.id_korban
                                     inner join kondisi ON kondisi.id_kondisi = detail_korban.id_kondisi
                                     WHERE kejadian.id_kejadian = '$id'");
                       while($data_korban = pg_fetch_array($query_korban)){
                     ?>
                  <option selected value="<?=$data_korban['id_orang']?>" required><?=$data_korban['nama_orang']?></option>
                          <?php
                       }
                              $query = "SELECT * FROM orang";
                              $sql=pg_query($query) or die (pg_error());
                             
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                          
                          <?php    
                          };   
                                ?>
                  </select>
                  </div>
                  <div class="col-sm-5">
                  <select id="kondisi" name="kondisi[]" class="form-control" multiple="multiple">
                  <?php
                  $query_korbann = pg_query("SELECT * from kejadian
                  INNER JOIN detail_korban ON detail_korban.id_kejadian=kejadian.id_kejadian
                  INNER JOIN orang ON orang.id_orang = detail_korban.id_korban
                  inner join kondisi ON kondisi.id_kondisi = detail_korban.id_kondisi
                  WHERE kejadian.id_kejadian = '$id'");
                    while($kondisi=pg_fetch_array($query_korbann)){
                  ?>
                  <option selected value="<?=$kondisi['id_kondisi']?>" required><?=$kondisi['kondisi']?></option>
                    
                    <?php
                    }
                        $query = "SELECT * FROM kondisi";
                        $sql=pg_query($query) or die (pg_error());
                       
                        while ($row = pg_fetch_assoc($sql)) {
                    ?>
                    <option  value="<?=$row['id_kondisi']?>" required><?=$row['kondisi']?></option>
                    
                    <?php    
                    };   
                          ?>
                  </select> 
                  </div>  
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
                <div class=" panel-succes">
                <label for="yang_melapor">Report Created By</label>
                <select id="admin" name="admin" class="form-control" required > 
                <?php $sql_admin=pg_query("SELECT * FROM kejadian 
                                INNER JOIN admin ON admin.username_admin = kejadian.username_admin
                                WHERE kejadian.id_kejadian='$id'"); 
                      $admin_data=pg_fetch_array($sql_admin);
                ?>
                <option disabled selected value="<?=$admin_data['username_admin']?>"><?=$admin_data['nama']?></option>
                      <?php
                              $query_admin = pg_query("SELECT * FROM admin");
                              while ($admin = pg_fetch_array($query_admin)) {
                          ?>
                          <option value="<?=$admin['username_admin']?>" ><?=$admin['nama']?></option>

                        <?php
                          }
                        ?>
                    </select>
                </div> <br>
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
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing">
         
    </script>
    <script type="text/javascript"><?php echo $jsArray; ?>
    function changeValue(id){
    document.getElementById('no_hp').value = NoHp[id].satu;
    };
    </script>
    <script src="map_incident.js" type="text/javascript"></script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <!-- <script src="script.js" type="text/javascript"></script> -->
    
    <!-- <script src="map.js" type="text/javascript"></script> -->
    <script src="../assets/js/select2.min.js"></script>
      <script>
            $(document).ready(function () {
                $("#regu_piket").select2({
                    placeholder: "Please Select"
                });
                $("#pelapor").select2({
                    placeholder: "Please Select"
                });
                $("#pemilik").select2({
                    placeholder: "Please Select"
                });
                $("#saksi").select2({
                    placeholder: "Please Select"
                });
                $("#objek_terbakar").select2({
                    placeholder: "Please Select"
                });
                $("#kategori_penyebab").select2({
                    placeholder: "Please Select"
                });
                $("#instansi").select2({
                    placeholder: "Please Select"
                });
                $("#kendaraan").select2({
                    placeholder: "Please Select"
                });
                $("#korban").select2({
                    placeholder: "Please Select"
                });
                $("#kondisi").select2({
                    placeholder: "Please Select"
                });
                $("#admin").select2({
                    placeholder: "Fill in the name"
                });
            });

      </script>

    
  </body>
</html>