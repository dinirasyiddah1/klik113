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
        <form method="post" action="input_incident_aksi.php" enctype="multipart/form-data">
                <table>
                <div class="form-group">
                    <label for="orang">People involved</label>
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Data Entry</button>  
                    <br>
                    
                      <label for="geom"><span style="color:red">*</span> Coordinat</label>
                      <textarea class="form-control readonly" id="geom" name="geom" autocomplete="off"  required></textarea>
                      <script>
                        $(".readonly").on('keydown paste', function(e){
                            e.preventDefault();
                        });
                    </script>
                </div> 
                    <label for="id">1. <span style="color:red">*</span> Date & Time </label><br>
                    <div class="panel panel-default">    
                    <div class="form-group panel-body">
                      <input type="date" class="form-control" name="tanggal" value="" required>
                      <input type="time" class="form-control" name="jam" value=""required> 
                   <br>
                    <label for="id"><span style="color:red">*</span> Picket Team </label>
                      <select id="regu_piket" name="regu_piket" class="form-control" required>
                     <option value="">Please Select</option>
                          <?php
                              $query = "SELECT * FROM regu_piket";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option value="<?=$row['id_regu']?>" required><?=$row['nama_regu']?></option>
                          <?php    
                              };   
                                ?>
                        
                      </select>
                    </div>
                </div>
                
                <div class="panel panel-default">    
                    <div class="form-group panel-body">
                    <label for="jenis_kejadian">2. Type Of Incident</label>
                    <input type="text" class="form-control" id="jenis_kejadian" name="jenis_kejadian" autocomplete="off">
                    <br>
                    &nbsp;<label for="objek_terbakar">Burning Object</label>&nbsp;
                    <select id="objek_terbakar" name="objek_terbakar[]" class="form-control" required multiple="multiple">
                      <?php
                              $query = "SELECT * FROM objek_terbakar";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_objek']?>" ><?=$row['nama_objek']?></option>
                          
                          <?php    
                            };   
                                ?>
                        <option>-- Add new --</option>
                  </select>
                </div>
                </div>

                <div class="panel panel-default">    
                    <div class="form-group panel-body">
                    <label for="penyebabn">3. The Cause Of The Incident</label>
                    <input type="text" class="form-control" id="penyebab" name="penyebab" autocomplete="off">
                    <br>
                    &nbsp;<label for="objek_terbakar">Category Of Cause</label>&nbsp;
                    <select id="kategori_penyebab" name="kategori_penyebab[]" class="form-control" required multiple="multiple">
                    
                    <?php
                              $query = "SELECT * FROM penyebab";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option  value="<?=$row['id_penyebab']?>" ><?=$row['nama_penyebab']?></option>
                          
                          <?php    
                            };   
                                ?>
                        <option>-- Add new --</option>
                  </select>
                </div>
                </div>
                
                <div class="form-group">
                    <label for="lokasi">4. Location</label>
                    <input type="text" class="form-control" id="lokasi" name="lokasi" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="pelapor">5. Reported By <span style="color:red">*</span></label>
                    <select id="pelapor" name="pelapor[]" class="form-control" required multiple="multiple" onchange="changeValue(this.value)">
                      <?php
                              $query = "SELECT * FROM orang";
                              $sql=pg_query($query) or die (pg_error());
                              $jsArray = "var NoHp = new Array();\n";
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option name="pelapor" value="<?=$row['id_orang']?>" ><?=$row['nama_orang']?></option>
                          
                          <?php    
                          $jsArray .= "NoHp['".$row['id_orang']."'] = {satu:'".addslashes($row['no_hp'])."'};\n";
                              };   
                                ?>
                        <option>-- Add new --</option>
                  </select>
                    
                    <input type="text" class="form-control" id="no_hp" name="no_hp"autocomplete="off">
                </div>
                
                    <label for="pemilik">6. Owner</label>
            <div class="panel panel-default"> 
              <div class="form-group panel-body"> 
                <label for="pemilik">Owner</label><br>
                <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show1'> + Enter owner data</button>
                <select id="pemilik" name="pemilik[]" class="form-control" multiple="multiple" required>
               
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
                    <select id="saksi" name="saksi[]" class="form-control" multiple="multiple" required>
                    <option selected="selected" value="">-----</option>
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
                      <input type="text" class="form-control" id="personil" name="personil" autocomplete="off">
                    <br>
                      <label for="instansi">Agent involved</label><br>
                      
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
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Enter agent data</button>
                      
                   
                      <br><br>
                    <label for="kendaraan">Vehicle / Equipment</label>
                    <select id="kendaraan" name="kendaraan[]" class="form-control" required multiple="multiple" > 
                    
                      <?php
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
                  <textarea class="form-control" id="kronologis" name="kronologis" autocomplete="off"></textarea>
                </div>
                
                <label for="korban">9. Due to events</label>
                <div class="panel panel-default"> 
                <div class="form-group panel-body"> 
                  <label for="korban">Victim</label>
                  <input type="text" class="form-control" id="korban" name="korban" autocomplete="off">
                <br>
                    <label for="kerusakan">Damage</label>
                    <input type="text" class="form-control" id="kerusakan" name="kerusakan" autocomplete="off">
                <br>
                    <label for="luas_area">Area</label>
                    <input type="text" class="form-control" id="luas_area" name="luas_area" autocomplete="off">
                <br> 
                    <label for="taksiran_kerugian">estimated loss</label>
                    <input type="text" class="form-control" id="taksiran_kerugian" name="taksiran_kerugian" autocomplete="off">
                </div>
                </div>
                <div class="form-group">
                  <label for="image">Gambar</label>
                  <input type="file"id="image" class="form-control-file" name="gambar[]" multiple>
                  <br>
                </div>	
                    </td></tr>
                    <tr><td colspan="2"><button class="btn btn-warning" type="submit" value="simpan">SIMPAN</button></td></tr>
                </table>
        </form>
        </div>
        </div>

<!-- Modal start here -->
<div class="modal fade" id="show" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><b>People Involved </b></h4>
                </div>
                <div class="modal-body">
                    <div class="modal-data"></div>
                </div>
            </div>
      </div>
</div>
<!-- End of Modal -->

<!-- Ini merupakan script yang terpenting -->
<script type="text/javascript">
    $(document).ready(function(){
        $('#show').on('show.bs.modal', function (e) {
            var getDetail = $(e.relatedTarget).data('id');
            /* fungsi AJAX untuk melakukan fetch data */
            $.ajax({
                type : 'post',
                url : 'modal_orang.php',
                /* detail per identifier ditampung pada berkas detail.php yang berada di folder application/view */
                data :  'getDetail='+ getDetail,
                /* memanggil fungsi getDetail dan mengirimkannya */
                success : function(data){
                $('.modal-data').html(data);
                /* menampilkan data dalam bentuk dokumen HTML */
                }
            });
         });
    });
  </script>

  <!-- Modal start here -->
<div class="modal fade" id="show1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><b>Owner </b></h4>
                </div>
                <div class="modal-body">
                    <div class="modal-data"></div>
                </div>
            </div>
      </div>
</div>
<!-- End of Modal -->

<!-- Ini merupakan script yang terpenting -->
<script type="text/javascript">
    $(document).ready(function(){
        $('#show1').on('show.bs.modal', function (e) {
            var getDetail = $(e.relatedTarget).data('id');
            /* fungsi AJAX untuk melakukan fetch data */
            $.ajax({
                type : 'post',
                url : 'modal_owner.php',
                /* detail per identifier ditampung pada berkas detail.php yang berada di folder application/view */
                data :  'getDetail='+ getDetail,
                /* memanggil fungsi getDetail dan mengirimkannya */
                success : function(data){
                $('.modal-data').html(data);
                /* menampilkan data dalam bentuk dokumen HTML */
                }
            });
         });
    });
  </script>
    
    
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing&callback=initMap">
         
    </script>
    <script type="text/javascript"><?php echo $jsArray; ?>
    function changeValue(id){
    document.getElementById('no_hp').value = NoHp[id].satu;
    };
    </script>

        

    <script src="map_pos.js" type="text/javascript"></script>
    <!-- <script src="placeid.js" type="text/javascript"> </script> -->
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
            });
        </script>

    
  </body>
</html>