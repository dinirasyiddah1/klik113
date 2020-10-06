<?php 
session_start();
include 'connect.php';

	$page = "Fire Incident";

?>
<!DOCTYPE html>
<html lang="en">
  <head>
  <?php
      include ('include/head.php');
    ?>
    <style>
.tableFixHead          { overflow-y: auto; height: 500px; }
.tableFixHead thead th { position: sticky; top: 0; }

/* Just common table stuff. Really. */
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; }
th     { background:#eee; }
</style>
  </head>

  <body>
  <?php include('include/sidebar.php'); ?>
    <div id="wrapper">
      <div class="panel-body">
        <a href="input_incident.php" style="font-size:20px">+ Fire Incident</a>
      </div>
      <div style="margin-left:15px;" class="tableFixHead">
        
        <table class="table table-striped ">
  <thead>
    <tr>
      <th style="text-align:center;">ID </th>
      <th style="text-align:center;" width="120px">Time </th>
      <th style="text-align:center;" width="120px">Picket Team </th>
      <th style="text-align:center;" width="350px">Location </th>
      <th style="text-align:center;" width="100px">Report By </th>
      <th style="text-align:center;" width="100px">Witness </th>
      <th style="text-align:center;" width="150px">Damage </th>
      <th style="text-align:center;" width="100px">Area </th>
      <th style="text-align:center;" width="150px">Estimated Losses </th>
      <th style="text-align:center;" ></th>
    </tr>
  </thead>
  <?php
include "connect.php";

 $data2=pg_query("SELECT * FROM kejadian INNER JOIN regu_piket ON (kejadian.id_regu = regu_piket.id_regu)
                    ORDER BY id_kejadian asc
 ")or die(pg_error());
 $no=1;
 while($hasil=pg_fetch_array($data2)){ 
 ?>
  <tbody >
    <tr>
      <th scope="row"><?=$hasil['id_kejadian'];?></th>
      <?php
            $query=pg_query("SELECT jam FROM kejadian");
            $data=pg_fetch_array($query);
            $time=$data['jam'];
            $jam=date_create($time);
            $format_jam=date_format($jam,'H:i')
            ?>
            <td><?=$format_jam;?> WIB</td>
      <td align="center"><?=$hasil['nama_regu'];?></td>
      <td><?=$hasil['lokasi'];?></td>
      <?php
      $id=$hasil['id_kejadian'];
      $data_pelapor = pg_query("SELECT * FROM kejadian 
                            INNER JOIN detail_pelapor ON kejadian.id_kejadian=detail_pelapor.id_kejadian
                            INNER JOIN orang ON detail_pelapor.id_orang = orang.id_orang
                            where kejadian.id_kejadian = '$id'
                            ");
      $hasil_pelapor = pg_fetch_array($data_pelapor);
      
      ?>
      <td><?=$hasil_pelapor['nama_orang'];?></td>
      <?php
      $data_saksi = pg_query("SELECT orang.nama_orang FROM kejadian 
                            JOIN detail_saksi ON kejadian.id_kejadian=detail_saksi.id_kejadian
                            JOIN orang ON detail_saksi.id_orang = orang.id_orang
                            where kejadian.id_kejadian='$id'
                            ");
      $hasil_saksi = pg_fetch_array($data_saksi);
      ?>
      <td><?=$hasil_saksi['nama_orang'];?></td>
      <td><?=$hasil['kerusakan'];?></td>
      <td><?=$hasil['luas_area'];?></td>
      <td><?=$hasil['taksiran_kerugian'];?></td>
      <td>
         <a href='kejadian_detail.php?id_kejadian=<?=$hasil['id_kejadian']?>'><span style='color:cyant'><i class='fa fa-eye'></i></span></a>
        <a   href='edit_incident.php?id_kejadian=<?=$hasil['id_kejadian']?>'><span style='color:green'><i class='fa fa-pencil'></i>  </span> </a>
        <script type="text/javascript" language="JavaScript">
          function konfirmasi()
          {
          tanya = confirm("Anda Yakin Akan Menghapus Data ?");
          if (tanya == true) return true;
          else return false;
          }
        </script>
        <a href="hapus_incident.php?id_kejadian=<?=$hasil['id_kejadian']?>" onclick="return konfirmasi()"><span style='color:red'><i class='fa fa-trash-o'></i>  </span> </a>
                
      </td>
    </tr>

  </tbody>
 <?php };?>

 <!-- Modal start here -->
<div class="modal fade" id="show" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title"><b>Detail </b></h4>
                </div>
                <div class="modal-body">
                    <div class="modal-data"></div>
                </div>
            </div>
      </div>
</div>
<!-- End of Modal -->

<script src="../assets/js/jquery-1.10.2.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>

<!-- Ini merupakan script yang terpenting -->
<script type="text/javascript">
    $(document).ready(function(){
        $('#show').on('show.bs.modal', function (e) {
            var getDetail = $(e.relatedTarget).data('id');
            /* fungsi AJAX untuk melakukan fetch data */
            $.ajax({
                type : 'post',
                url : 'modal_incident.php',
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
</table>
      </div>

    </div>
    <!-- JavaScript -->
    <?php
      include ("connect.php");
    ?>
    
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing&callback=initMap">
    </script>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="script.js" type="text/javascript"></script>

  </body>
</html>