
<?php 
session_start();
include 'connect.php';

  $page = "Fire Incident";
  
  // untuk modal people bagian select suku
  $querySuku = "SELECT * FROM suku";
  $sqlSuku=pg_query($querySuku) or die (pg_error());

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
                    <input type="text" class="form-control" id="jenis_kejadian" name="jenis_kejadian" value="<?=$hasil1['jenis_kejadian'];?>" autocomplete="off" maxlength="70">
                    <br>
                    
                    &nbsp;<label for="objek_terbakar">Burning Object</label>&nbsp;
                    <select name="objek_terbakar[]" id="objek_terbakar" class="form-control"  required multiple="multiple">
                          <?php $objek = pg_query("SELECT * FROM kejadian
                                INNER JOIN detail_objek_terbakar ON detail_objek_terbakar.id_kejadian = kejadian.id_kejadian
                                INNER JOIN objek_terbakar ON objek_terbakar.id_objek = detail_objek_terbakar.id_objek 
                                WHERE kejadian.id_kejadian='$id'
                                ");
                                while($objekx = pg_fetch_array($objek)){
                          ?>
                       <option selected value="<?=$objekx['id_objek']?>"><?=$objekx['nama_objek']?></option>
                       
                          <?php
                                
                              $query = "SELECT * FROM objek_terbakar";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_objek']?>" required><?=$row['nama_objek']?></option>
                          <?php    
                              }; 
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
                    <input type="text" class="form-control" id="penyebab" name="penyebab" value="<?=$hasil_peny['penyebab'];?>" autocomplete="off" maxlength="70">
                    <br>
                    &nbsp;<label for="kategori_penyebab">Category Of Cause</label>&nbsp;
                    <select id="kategori_penyebab" name="kategori_penyebab[]" class="form-control" multiple required>
                       <?php
                          $penyebab = pg_query("SELECT * FROM kejadian
                          INNER JOIN detail_penyebab ON detail_penyebab.id_kejadian = kejadian.id_kejadian
                          INNER JOIN penyebab ON penyebab.id_penyebab = detail_penyebab.id_penyebab 
                          WHERE kejadian.id_kejadian='$id'
                          ");
                          while($penyebabx = pg_fetch_array($penyebab)){
                       ?>
                       <option selected value="<?=$penyebabx['id_penyebab']?>"><?=$penyebabx['nama_penyebab']?></option>
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
                    <input type="text" class="form-control" id="lokasi" name="lokasi" value="<?=$hasil['lokasi'];?>" autocomplete="off" maxlength="100">
                  <br>
                  &nbsp;&nbsp;&nbsp;&nbsp;<label for="rtrw">RT / RW</label>&nbsp;
                  <br>
                  <div class="col-sm-6">
                  <input type="number" class="form-control" id="rt" name="rt" value="<?=$hasil['rt'];?>" autocomplete="off" min="0" max="99">
                  </div>
                  <div class="col-sm-6">
                  <input type="number" class="form-control"  id="rw" name="rw" value="<?=$hasil['rw'];?>" autocomplete="off" min="0" max="99">
                 </div>
                  <br><br><br>
                  <label for="kelurahan">Village</label>
                    <input type="text" class="form-control" id="kelurahan" name="kelurahan" value="<?=$hasil['kelurahan'];?>" autocomplete="off" maxlength="30">
                  
                </div>
                </div>
                <br>
                <button type="button" name="People" id="People" class="btn btn-info" data-toggle='modal'  data-target='#showPeople'> People Involved</button>  

                    <br><br>
                <div class="form-group">
                    <label for="pelapor">5. Reported By <span style="color:red">*</span></label>
                    <select name="pelapor[]" id="pelapor" class="form-control" multiple required onchange="changeValue(this.value)">
                      
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
                              };
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
                      <input type="number" class="form-control" id="personil" name="personil" value="<?=$data_instansi['jumlah_personil']?>" autocomplete="off" min="0" max="9999">
                    <br>
                      <label for="instansi">Agent involved</label>
                   <br>

                      <div class="col-sm-7">
                      <select id="instansi" name="instansi[]" class="form-control"  multiple="multiple" > 
                      <?php
                            $instansi_query = pg_query("SELECT * FROM kejadian
                                              INNER JOIN detail_instansi ON detail_instansi.id_kejadian = kejadian.id_kejadian
                                              INNER JOIN instansi ON instansi.id_instansi = detail_instansi.id_instansi
                                              WHERE kejadian.id_kejadian = '$id'");
                            while($instansi_data = pg_fetch_array($instansi_query)){
                            
                          ?>
                          <option selected="selected" value="<?=$data_instansi['id_instansi'];?>" required><?=$data_instansi['nama_instansi'];?></option>
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
                    <button type="button" name="addAgent" id="addAgent" class="btn btn-info" data-toggle='modal'  data-target='#showAgent'> + Enter agent data</button>  
                    
                    </div> 
                   
                      <br><br>
                    <label for="kendaraan">Vehicle / Equipment</label>
                    <select id="kendaraan" name="kendaraan[]" class="form-control" required multiple="multiple" > 
                    <?php
                            $kendaraan_query = pg_query("SELECT * FROM kejadian
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
                <div style="float:right">
                      <button class="btn btn-success add-more" type="button">
                        <i class="glyphicon glyphicon-plus"></i> Add
                      </button>
                  </div>
                  <label for="korban">Victim</label>              
                  <div class="panel-body">
                  <!--  -->
                  <div class="after-add-more">
                    <?php
                      $korban = pg_query("SELECT * FROM detail_korban 
                                INNER JOIN orang ON orang.id_orang = detail_korban.id_korban
                                INNER JOIN kondisi ON kondisi.id_kondisi = detail_korban.id_kondisi
                                WHERE id_kejadian = '$id'");
                      while($kej_korban = pg_fetch_array($korban)){
                        $korbid = $kej_korban['id_korban'];
                        $korbad = $kej_korban['nama_orang'];
                        $konid = $kej_korban['id_kondisi'];
                        $konad = $kej_korban['kondisi'];
                  ?>
                  <div class= "row" id="row_<?=$korbid?>">
                  <div class="col-sm-5">
                  <select name="korban[]" class="form-control">
                  <option  value="" disabled selected>Please Select</option>
                  <option selected value="<?=$korbid?>" required><?=$korbad?></option>                   
                         <?php
                      
                              $query = "SELECT * FROM orang WHERE id_orang!='$korbid'";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                          <?php    
                          }; ?>     
                  </select>
                 
                  </div>
                  <div class="col-sm-5">
                 
                  <select name="kondisi[]" class="form-control">
                  <option  value="" disabled selected>Please Select</option>
                  <option selected value="<?=$konid?>" required><?=$konad?></option>
                       <?php
                        $query = "SELECT * FROM kondisi where id_kondisi!='$konid'";
                        $sql=pg_query($query) or die (pg_error());
                        while ($row = pg_fetch_assoc($sql)) {
                    ?>
                    <option  value="<?=$row['id_kondisi']?>" required><?=$row['kondisi']?></option>
                   <?php    
                     };   
                          ?>
                     </select> 
                  <br>
                </div>
                <div class="col-sm-2">
                      <button class="btn btn-danger remove" onclick="delete_row(this.id)" id="<?=$korbid?>" type="button">
                      <i class="glyphicon glyphicon-remove"></i> Del</button>
                      </div>
                  </div>
                <?php }
               ?>
                </div>
                  <!-- copy -->
                  <div class="copy hide">
                   <div class="control-group">
                    <div class="row" id>
                      <div class="col-sm-5">
                      <select name="korban[]" class="form-control">
                      <option disabled selected> Please Select </option>
                              <?php
                                  $query = "SELECT * FROM orang";
                                  $sql=pg_query($query) or die (pg_error());
                                
                                  while ($row = pg_fetch_assoc($sql)) {
                              ?>
                              <option  value="<?=$row['id_orang']?>" required><?=$row['nama_orang']?></option>
                              
                              <?php    
                              };   
                                    ?>
                      </select>
                      <br>
                      </div>
                      <div class="col-sm-5">
                      <select  name="kondisi[]" class="form-control">
                      <option disabled selected> Please Select </option>
                        <?php
                            $query = "SELECT * FROM kondisi";
                            $sql=pg_query($query) or die (pg_error());
                          
                            while ($row = pg_fetch_assoc($sql)) {
                        ?>
                        <option  value="<?=$row['id_kondisi']?>" required><?=$row['kondisi']?></option>
                        
                        <?php    
                        };   
                              ?>
                      </select> 
                      <br>
                      </div>
                      <div class="col-sm-2">
                      <button class="btn btn-danger remove" type="button">
                      <i class="glyphicon glyphicon-remove"></i> Del</button>
                      </div>
                      </div>
                   </div>
                   </div>
                    <!-- and copy -->
                
                    <label for="kerusakan">Damage</label>
                    <input type="text" class="form-control" id="kerusakan" name="kerusakan" value="<?=$hasil['kerusakan'];?>" autocomplete="off" maxlength="40">
                <br>
                    <label for="luas_area">Area</label>
                    <input type="text" class="form-control" id="luas_area" name="luas_area" value="<?=$hasil['luas_area'];?>" autocomplete="off" maxlength="40">
                <br> 
                    <label for="taksiran_kerugian">estimated loss</label>
                    <input type="text" class="form-control" id="taksiran_kerugian" name="taksiran_kerugian" value="<?=$hasil['taksiran_kerugian'];?>" autocomplete="off" maxlength="80">
                </div>
                </div>
                </div>
                <div class=" panel-succes">
                <label for="yang_melapor">Report Created By</label>
                <select id="admin" name="admin" class="form-control" required > 
                <?php $sql_admin=pg_query("SELECT * FROM kejadian 
                                INNER JOIN admin ON admin.username_admin = kejadian.username_admin
                                WHERE kejadian.id_kejadian='$id'"); 
                      $admin_data=pg_fetch_array($sql_admin);
                      $username=$admin_data['username_admin'];
                ?>
                <option selected value="<?=$admin_data['username_admin']?>"><?=$admin_data['nama']?></option>
                      <?php
                              $query_admin = pg_query("SELECT * FROM admin WHERE username_admin!='$username'");
                              while ($admin = pg_fetch_array($query_admin)) {
                          ?>
                          <option  value="<?=$admin['username_admin']?>"><?=$admin['nama']?></option>
                     
                        <?php
                          }
                        ?>
                    </select>
                </div> <br>
                <div class="form-group">
                  <label for="image">Gambar</label>
                  <?php
                    $query_gambar = pg_query("SELECT * from kejadian
                                        INNER JOIN gambar_kejadian ON gambar_kejadian.id_kejadian = kejadian.id_kejadian
                                        WHERE kejadian.id_kejadian = '$id'");
                    
                    while($data_gambar = pg_fetch_array($query_gambar)){
                      $img=count($data_gambar);
                      
                    };
                    echo "(" .$img. "&nbsp;file )";
                    ?>
                  <input type="file"id="image" class="form-control-file" name="gambar[]" multiple>
                 
                    
                  
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

<!-- people -->
<div id="showPeople" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- konten modal-->
      <div class="modal-content">
        <!-- heading modal -->
        <div class="modal-header">
          <button type="button" class="close"  data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><b>People Involved </b></h4>
        </div>
        <!-- body modal -->
        <div class="modal-body">
  <button type="button"   class="btn btn-warning btn-sm" data-toggle='modal'  data-target='#addOrang'> Add New</button>
  <br><br>
<input type="text" id="myInput" class="form-control"  placeholder="Search" title="Search">
<br>
<div class="table-responsive">
<table id="myTable" class="table table-striped">
     <tr class="header">
        <th>No</th>
        <th>Name</th>
        <th>Phone Number</th>
        <th>Detail</th>
      </tr>
  <?php
include "connect.php";

 $data2=pg_query("SELECT * FROM orang ")or die(pg_error());
 $no=1;
 while($hasil=pg_fetch_array($data2)){ 
 ?>
    <tr>
      <td><?=$no?></td>
      <td><?=$hasil['nama_orang'];?></td>
      <td><?=$hasil['no_hp'];?></td>
      <td><button type="button" id="detail<?=$hasil['id_orang'];?>" class="btn btn-info btn-sm detail" data-toggle='modal'  data-target='#showPeople2'> Detail</button>  
      </td>
    </tr>
  <?php $no++; }; ?>
</table>
</div>

</div>
        <!-- footer modal -->
        
      </div>
    </div>
  </div>

<!-- modal add data orang baru -->
<div id="addOrang" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- konten modal-->
      <div class="modal-content">
        <!-- heading modal -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><b>Add Data </b></h4>
        </div>
        <!-- body modal -->
        <div class="modal-body">
        
          <form method="post" id="form_people" class="ajax">
            <div class="alert alert-success js-alert hidden" role="alert">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <strong>Success!</strong> People data entered successfully !
            </div>
                 
             <div class="form-group">
                    <label for="name"><span style="color:red">*</span> Name</label>
                    <input type="text" class="form-control" id="name" name="name" autocomplete="off" required maxlength="20">
                </div>
                <div class="form-group">
                    <label for="age">Age</label>
                    <input type="number" class="form-control" id="age" name="age" autocomplete="off" min="0" max="200">
                </div>
                <div class="form-group">
                    <label for="job">Job</label>
                    <input type="text" class="form-control" id="job" name="job" autocomplete="off" maxlength="30">
                </div>
        <div class="dropdown">
                    <label for="suku"><span style="color:red">*</span>Suku</label><br>
                    <select style="width:569px" id="suku" class="form-control" name="suku" required>
                    
                      <option value="">Please Select</option>
                      <?php
                              
                              while ($rsuku = pg_fetch_assoc($sqlSuku)) {
                          ?>
                          <option value="<?=$rsuku['id_suku']?>" required><?=$rsuku['nama_suku']?></option>
                          <?php }
                            ?>
        
                  </select>
                 </div>
                 <br>
                 <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" autocomplete="off" maxlength="100">
                </div>  
                <div class="form-group">
                    <label for="no_hp">Mobile phone number</label>
                    <input type="tel" pattern="^\d{12}$" class="form-control" id="no_hp" name="no_hp" autocomplete="off">
                    
                </div>
        <div class="modal-footer">
                    <button type="submit" name="simpanPeople"  class="btn js-btn btn-primary" id="simpanPeople" >Save</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                 </div>
                       
                    </form>
        </div>
        <!-- footer modal -->
        
      </div>
    </div>
  </div>
<!-- akhir modal add data baru -->

<div id="showPeople2" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- konten modal-->
      <div class="modal-content">
        <!-- heading modal -->
        <div class="modal-header">
          <button type="button" class="close"  data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><b>Detail</b></h4>
        </div>
        <!-- body modal -->
        <div class="modal-body">
             <div id="detail_button"></div>
             <table id="detail_data">
              
            </table>
        </div>
         <div class="modal-footer" id="detail_footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>    
          </div>
        <!-- footer modal -->
        
      </div>
    </div>
  </div>
                            
<div id="showPeople3" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- konten modal-->
      <div class="modal-content">
        <!-- heading modal -->
        <div class="modal-header">
          <button type="button" class="close"  data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><b>Edit Data </b></h4>
        </div>
        <!-- body modal -->
        <div class="modal-body" id="edit_modal">
          
        </div>
          <div class="modal-footer" id="edit_footer">
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>    
          </div>
        <!-- footer modal -->
        
      </div>
    </div>
  </div>
<!-- script people -->

<!-- agent -->
<div id="showAgent" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- konten modal-->
      <div class="modal-content">
        <!-- heading modal -->
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><b>Agent Data</b></h4>
        </div>
        <!-- body modal -->
        <div class="modal-body">
          <form method="post" id="form_agent">
          <div class="alert alert-success js-alert hidden" role="alert">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <strong>Success!</strong> Agent data entered successfully !
            </div>
            <table>
            <div class="form-group">
                          <label for="name">Name</label>
                          <input type="text" class="form-control" id="name" name="name" autocomplete="off" maxlength="50">
                      </div>
            <div class="form-group">
                          <button type="submit" name="simpan" id="simpan" class="btn btn-primary">SAVE</button>
                      </div>
             </table>
                                                  
                    </form>
        </div>
        <!-- footer modal -->
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Tutup Modal</button>
        </div>
      </div>
    </div>
  </div>





    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing">
         
    </script>
    
    <script src="mapupdate_incident.js" type="text/javascript"></script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <!-- <script src="script.js" type="text/javascript"></script> -->
    
    <!-- <script src="map.js" type="text/javascript"></script> -->
    <script src="../assets/js/select2.min.js"></script> 
   
      <script>
            $(document).ready(function () {
                $(".add-more").click(function(){ 
          var html = $(".copy").html();
          $(".after-add-more").after(html);
      });

      // saat tombol remove dklik control group akan dihapus 
      $("body").on("click",".remove",function(){ 
          $(this).parents(".control-group").remove();
      });

      $(".detail").on("click",function(){ 
        var idx = $(this).attr("id");
        var data_id = idx.split('detail');

        $("#detail_button").empty();
        $("#detail_data").empty();

        var edit = document.createElement("SPAN");  
        edit.setAttribute("class", "btn btn-warning btn-sm edit");
        edit.setAttribute("id", "edit"+data_id[1]);
        empty.innerHTML="Edit";
        document.getElementById("detail_button").appendChild(edit);
        document.getElementById("edit"+data_id[1]).style.cursor="pointer";

        var delete_data = document.createElement("SPAN");  
        delete_data.setAttribute("class", "btn btn-danger btn-sm delete");
        delete_data.setAttribute("id", "delete"+data_id[1]);
        delete_data.innerHTML="Delete";
        document.getElementById("detail_button").appendChild(delete_data);
        document.getElementById("delete"+data_id[1]).style.cursor="pointer";

        $.get('/detail_data?id='+data_id[1], function(data) 
        {  
         var table = document.getElementById("detail_data");
         var row = table.insertRow(0);
         var cell1 = row.insertCell(0);
         var cell2 = row.insertCell(1);
         cell1.innerHTML = "Name :";
         cell2.innerHTML = data.nama_orang;

         var row = table.insertRow(1);
         var cell1 = row.insertCell(0);
         var cell2 = row.insertCell(1);
         cell1.innerHTML = "Age :";
         cell2.innerHTML = data.umur_orang;

         var row = table.insertRow(2);
         var cell1 = row.insertCell(0);
         var cell2 = row.insertCell(1);
         cell1.innerHTML = "Job :";
         cell2.innerHTML = data.pekerjaan_orang;
     
         var row = table.insertRow(3);
         var cell1 = row.insertCell(0);
         var cell2 = row.insertCell(1);
         cell1.innerHTML = "Suku :";
         cell2.innerHTML = data.id_suku;
    
         var row = table.insertRow(4);
         var cell1 = row.insertCell(0);
         var cell2 = row.insertCell(1);
         cell1.innerHTML = "Address :";
         cell2.innerHTML = data.alamat_orang;
     
         var row = table.insertRow(5);
         var cell1 = row.insertCell(0);
         var cell2 = row.insertCell(1);
         cell1.innerHTML = "Mobile Phone Number :";
         cell2.innerHTML = data.no_hp;

        });
        
      });

      $(".edit").on("click",function(){ 
        var idx = $(this).attr("id");
        var data_id = idx.split('edit');  

        $.get('/detail_data?id='+data_id[1], function(data) 
        {  
        var i =0;
        var form = document.createElement("FORM");
        form.setAttribute("method", "post"); 
        form.setAttribute("class", "form_edit_people");
        form.setAttribute("id", "form_edit_people"+data_id[1]);
        document.getElementById("edit_modal").appendChild(form);

        var fg = document.createElement("DIV");  
        fg.setAttribute("class", "form-group"); 
        fg.setAttribute("id", "form-group"+i); 
        document.getElementById("form_edit_people"+data_id[1]).appendChild(fg);
        var ket = document.createElement("INPUT");
         ket.setAttribute("type", "text");
         ket.setAttribute("class", "form-control");
         ket.setAttribute("id", "name");
         ket.setAttribute("value", data.nama_orang);
         ket.setAttribute("placeholder", "Name");
         ket.setAttribute("name", "name");                
         document.getElementById("form-group"+i).appendChild(ket);  
        i++;  

        var fg2 = document.createElement("DIV");  
        fg2.setAttribute("class", "form-group"); 
        fg2.setAttribute("id", "form-group"+i); 
        document.getElementById("form_edit_people"+data_id[1]).appendChild(fg2);
        var ket2 = document.createElement("INPUT");
         ket2.setAttribute("type", "number");
         ket2.setAttribute("class", "form-control");
         ket2.setAttribute("value", data.umur_orang);
         ket2.setAttribute("id", "age");
         ket2.setAttribute("placeholder", "Age");
         ket2.setAttribute("name", "age");                
         document.getElementById("form-group"+i).appendChild(ket2);  
        i++;  

        var fg3 = document.createElement("DIV");  
        fg3.setAttribute("class", "form-group"); 
        fg3.setAttribute("id", "form-group"+i); 
        document.getElementById("form_edit_people"+data_id[1]).appendChild(fg3);
        var ket3 = document.createElement("INPUT");
         ket3.setAttribute("type", "text");
         ket3.setAttribute("class", "form-control");
         ket3.setAttribute("value", data.pekerjaan_orang);
         ket3.setAttribute("id", "job");
         ket3.setAttribute("placeholder", "Job");
         ket3.setAttribute("name", "job");                
         document.getElementById("form-group"+i).appendChild(ket3);  
        i++; 

        var fgselect = document.createElement("DIV");  
        fgselect.setAttribute("class", "form-group"); 
        fgselect.setAttribute("id", "form-group"+i); 
        document.getElementById("form_edit_people"+data_id[1]).appendChild(fgselect);
         var suku = document.createElement("SELECT");
         suku.setAttribute("class", "form-control");
         suku.setAttribute("id", "suku_edit");
         suku.setAttribute("name", "suku");
         suku.setAttribute("required", true);

         var sk_option_select = document.createElement("option");
         sk_option_select.setAttribute("value", data.id_suku);
         sk_option_select.setAttribute("selected", "true");
         var sk_capt_select = document.createTextNode(data.nama_suku);
         sk_option_select.appendChild(sk_capt_select);    ;
         suku.appendChild(sk_option_select);
         
         var sk_option = document.createElement("option");
         sk_option.setAttribute("disabled", "true");
         sk_option.setAttribute("value", "");
         var sk_capt = document.createTextNode("Please Select");
         sk_option.appendChild(sk_capt);    ;
         suku.appendChild(sk_option);
              
        $.get('/suku_list', function(data) 
        {  
         $.each(data, function(index, sukuObj)
         {
             $('#suku_edit').append('<option value="'+sukuObj.id+'">'+sukuObj.nama+'</option>');
          })
        });
        document.getElementById("form-group"+i).appendChild(suku); 

       i++; 

       var fg4 = document.createElement("DIV");  
        fg4.setAttribute("class", "form-group"); 
        fg4.setAttribute("id", "form-group"+i); 
        document.getElementById("form_edit_people"+data_id[1]).appendChild(fg4);
        var ket4 = document.createElement("INPUT");
         ket4.setAttribute("type", "text");
         ket4.setAttribute("class", "form-control");
         ket4.setAttribute("id", "address");
         ket4.setAttribute("autocomplete", "off");
         ket4.setAttribute("maxlength", "100");
         ket4.setAttribute("placeholder", "Address");
         ket4.setAttribute("value", data.alamat_orang);
         ket4.setAttribute("name", "address");                
         document.getElementById("form-group"+i).appendChild(ket4);  
        i++; 

       var fg5 = document.createElement("DIV");  
        fg5.setAttribute("class", "form-group"); 
        fg5.setAttribute("id", "form-group"+i); 
        document.getElementById("form_edit_people"+data_id[1]).appendChild(fg5);
        var ket5 = document.createElement("INPUT");
         ket5.setAttribute("type", "tel");
         ket5.setAttribute("pattern", "^\d{12}$");
         ket5.setAttribute("class", "form-control");
         ket5.setAttribute("autocomplete", "off");
         ket5.setAttribute("id", "no_hp");
         ket5.setAttribute("value", data.no_hp);
         ket5.setAttribute("placeholder", "Mobile Phone Number");
         ket5.setAttribute("name", "no_hp");                
         document.getElementById("form-group"+i).appendChild(ket5);  
        i++; 
        
        var change = document.createElement("BUTTON");  
        change.setAttribute("class", "btn btn-primary");
        change.setAttribute("type", "submit");
        change.setAttribute("id", "save_change");
        change.innerHTML="Save Changes";
        document.getElementById("edit_footer").appendChild(change);
      
        });

       $('.form_edit_people').on('submit', function (event) {
          event.preventDefault();
          var idx = $(this).attr("id");
          var data_id = idx.split('form_edit_people');  
          /* fungsi AJAX untuk melakukan fetch data */
          event.preventDefault();
           $.ajax({
                url : 'modal_change_orang_aksi.php?id='+data_id[1],  
                method : 'POST',
                data   : $('#form_edit_people').serialize(),
                beforeSend:function(){
                  $('#save_change').val("Simpan")
                },
                success : function(data){
                alert("Data Berhasil Diubah");
                // $('#showPeople').modal('hide');  
                /* menampilkan data dalam bentuk dokumen HTML */
                }
            });
         });

      $(".delete").on("click",function(){ 
        var idx = $(this).attr("id");
        var data_id = idx.split('delete');  
        if (confirm('Anda Yakin Ingin Menghapus Data Ini?')) 
        {
          $.get('/delete_data?id='+data_id[1], function(data) 
          {  
           alert("Data Berhasil Dihapus");
          });
        } 
        });

    $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });

  $('#form_people').on('submit', function (event) {
          event.preventDefault();
          /* fungsi AJAX untuk melakukan fetch data */
          event.preventDefault();
          $('.js-alert').addClass('hidden');
          $('.js-btn').button('loading');

            $.ajax({
                url : 'modal_orang_aksi.php',
                method : 'POST',
                data   : $('#form_people').serialize(),
                beforeSend:function(){
                  $('#simpanPeople').val("Simpan")
                },
                success : function(data){
                $('#form_people')[0].reset();
                $('.js-alert').removeClass('hidden');
                 $('.js-btn').button('reset');
                // $('#showPeople').modal('hide');  
                /* menampilkan data dalam bentuk dokumen HTML */
                }
            });
         });

            $('#form_agent').on('submit', function (event) {
          event.preventDefault();
          /* fungsi AJAX untuk melakukan fetch data */
          $('.js-alert').addClass('hidden');
          $('.js-btn').button('loading');

            $.ajax({
                url : 'modal_instansi_aksi.php',
                method : 'POST',
                data   : $('#form_agent').serialize(),
                beforeSend:function(){
                  $('#simpan').val("Simpan")
                },
                success : function(data){
                $('#form_agent')[0].reset();
                $('.js-alert').removeClass('hidden');
                 $('.js-btn').button('reset');
                // $('#showAgent').modal('hide');  
                /* menampilkan data dalam bentuk dokumen HTML */
                }
            });
         });

            <?php echo $jsArray; ?>
            function changeValue(id){
            document.getElementById('no_hp').value = NoHp[id].satu;
            };
            function delete_row(id){
            document.getElementById("row_"+id).remove();
               }
            

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
              
                $("#admin").select2({
                    placeholder: "Fill in the name"
                });
            });


      </script>

    
  </body>
</html>