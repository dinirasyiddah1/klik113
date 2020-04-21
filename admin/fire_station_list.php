<?php 
session_start();
include 'connect.php';
$query = pg_query("SELECT * FROM pos_damkar");

	$page = "Fire Station";

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

      <div class="panel-body">
      <div class="">
        <a href="input_pos.php" style="font-size:20px">+ Fire Station</a>
      </div>
<div class="table-responsive">
<table class="table table-striped table-hover tablesorter">
  <thead>
    <tr>
      <th style='text-align:center'>No <i class="fa fa-sort"></th>
      <th style='text-align:center'>Code <i class="fa fa-sort"></th>
      <th style='text-align:center'>Fire Station Name <i class="fa fa-sort"></th>
      <th style='text-align:center'>Address <i class="fa fa-sort"></th>
      <th style='text-align:center'>Option <i class="fa fa-sort"></th>
    </tr>
  </thead>

  <?php
// include "connect.php";


//  $data=pg_query("SELECT * FROM public.pos_damkar order by id_pos_damkar");
//  if ($data === FALSE) {
//  die(pg_error());

//  }
 
//  while($hasil=pg_fetch_array($data)){ 
 
 ?>

  <tbody>
  
  
  <?php
  $no=1;
  $hapus="hapus?";
  
        
          while ($row=pg_fetch_array($query)){
            
            echo "<tr>
                <td style='text-align:center'>$no</td>
                <td style='text-align:center'>".$row['id_pos_damkar']."</td>
                <td style='text-align:center'>".$row['nama_pos']."</td>
                <td style='text-align:center'>".$row['alamat']."</td>
                <td style='text-align:center'>
                <a class='btn btn-primary' data-toggle='modal' data-target='#show' data-id=".$row['id_pos_damkar']."><span style='color:black'><i class='fa fa-eye'></i></span></a>
                
                <a class='btn btn-success' href='edit_pos.php?id_pos_damkar=".$row['id_pos_damkar']."'><span style='color:black'><i class='fa fa-pencil'></i>  </span> </a>
                

                <a class='btn btn-danger ' href='hapus_pos.php?id_pos_damkar=".$row['id_pos_damkar']."' onclick='return confirm()'><span style='color:black'><i class='fa fa-trash-o'></i>  </span> </a>
                </td>
                
                </tr>";
            $no++;
        }
        ?>
    
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
                url : 'modal_pos.php',
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

                
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</script>
      </td>
    </tr>
    
  </tbody>
  <?php
  
 ?>
</table>

<div class="modal fade" id="modaldetail" role="dialog">
<div class="modal-dialog" > 
  <!-- modal content -->
  <div class="modal-content">
    <div class="modal-header">
    </div>
    <div class="modal-body">
    </div>
    <div class="modal-footer">
    </div>
</div>
</div>
</div>

      </div>
      </div>
    </div>
    <!-- JavaScript -->
    <?php
      include ("connect.php");
    ?>
    
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing&callback=initMap">
    </script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../assets/js/tablesorter/jquery.tablesorter.js"></script>
    <script src="../assets/js/tablesorter/tables.js"></script>

    <script src="script.js" type="text/javascript"></script>

  </body>
</html>