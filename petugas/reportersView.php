<?php
include '../admin/connect.php';
include ('include/head.php');




?>

<div class="table-responsive">
<table class="table table-striped table-hover tablesorter">
  <thead>
    <tr>
      <th style='text-align:center; width:50px;'> </th>
      <th style='text-align:center'>No </th>
      <th style='text-align:center'>Reporter </th>
      <th style='text-align:center'>Phone</th>
      <th style='text-align:center'>Location  </th>
      <th style='text-align:center'>Status</th>
    </tr>
  </thead>
  <tbody>
  <script type="text/javascript" language="JavaScript">
              function accept()
              {
              tanya = confirm("Accept this report ?");
              if (tanya == true) return true;
              else return false;
              }
            </script>
  <?php
  
  $no=1;
  $hapus="hapus?";
  $tanggal = date('d-m-Y');
  $jam = date('H:i:s'); 
  
  $query = pg_query("SELECT * FROM detail_pelapor INNER JOIN orang ON 
                    (detail_pelapor.id_orang = orang.id_orang) where tanggal = '$tanggal'");
  
          while ($row=pg_fetch_array($query)){
            
            echo "
            <form method='post' action='ubah_status_pelaporan.php?id_laporan=".$row['id_laporan']."' enctype='multipart/form-data'>
            <tr>
                <td style='text-align:center'><a href='input_laporan.php?id_laporan=".$row['id_laporan']."'><i class='fa fa-pencil'></i></a>&nbsp;&nbsp;<a role='button'   onclick='detailinforepo(\"".$row['id_laporan']."\")'><span style='color:green'><i class='fa fa-map-marker'>&nbsp;</i></span></a></td>
                
                <td style='text-align:center'>$no</td>
                <td style='text-align:center'>".$row['nama_orang']."</td>
                <td style='text-align:center'>".$row['no_hp']."</td>
                <td style='text-align:center'>".$row['lokasi']."</td>
                <td style='text-align:center'>
                  <select id='status_pelaporan' name='status_pelaporan' class='custom-select'>
                    <option selected  value='".$row['status_pelaporan']."'>".$row['status_pelaporan']."</option>
                    <option  value='New Report'>New Report</option>
                      <script type='text/javascript' language='JavaScript'>
                        function konfirmasi()
                        {
                        tanya = confirm('Do you want to change the status? ?');
                        if (tanya == true) return true;
                        else return false;
                        }
                      </script>
                    <option value='Accept'>Accept</></option>
                    <option value='Rejected'>Rejected</option>
                    <option value='Done'>Done</option>
                  </select>
                  &nbsp;&nbsp;
                  <button class='btn btn-warning' onclick='return konfirmasi()' type='submit' value='simpan'>ok</button></td></tr>
                </td>
               
                </form>";
            $no++;
        }
        ?>
  </tbody>
</table>
</div><!-- /#wrapper -->
<script src="../assets/js/bootstrap.js"></script>