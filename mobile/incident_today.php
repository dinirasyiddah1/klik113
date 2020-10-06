<?php 
include '../admin/connect.php';
?>

<!DOCTYPE html>
<html lang="en">
  <head>
        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="">
            <meta name="author" content="">

            <?php if($page == "Home") echo "<title>KLIK113 - ADMIN</title>";?>
            <?php if($page == "Fire Station") echo "<title>Fire Station</title>";?>
            <?php if($page == "Fire Incident") echo "<title>Fire Incident</title>";?>

            <!-- Bootstrap core CSS -->
            <link href="../assets/css/bootstrap.css" rel="stylesheet">
            <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <!-- Add custom CSS here -->
            <link href="../assets/css/sb-admin.css" rel="stylesheet">
            <link rel="stylesheet" href="../assets/font-awesome/css/font-awesome.min.css">
            <style>
            #map{
                height:400px;
                width:100%;
            }
            </style>
  </head>

  <body>
    <div id="wrapper">

    


    <div class="table-responsive">
<table class="table table-striped table-hover tablesorter">
  <thead>
    <tr>
      <th style='text-align:center'>No </th>
      <th style='text-align:center'>Jam </th>
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
                <td style='text-align:center'>$no</td>
                <td>".$row['jam']."</td>
                <td>".$row['lokasi']."</td>
                <td style='text-align:center'>".$row['status_pelaporan']."</td>
            </tr>
               
                </form>";
            $no++;
        }
        ?>
  </tbody>
</table>
     

    </div><!-- /#wrapper -->

    <!-- JavaScript -->
    <?php
      include ("../admin/connect.php");
    ?>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&callback=initMap">
    </script>
    <script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../admin/script.js" type="text/javascript"></script>
    
  </body>
</html>