<?php
    require 'admin/connect.php';
    $info = $_GET["info"];
    $querysearch ="select kejadian.id_kejadian, kejadian.jam, kejadian.id_regu, kejadian.lokasi,
    kejadian.kronologis, 
    ST_X(ST_Centroid(kejadian.geom)) AS lng, ST_Y(ST_CENTROID(kejadian.geom)) As lat, kejadian.kerusakan,
    kejadian.luas_area, kejadian.taksiran_kerugian, kejadian.username_admin, kejadian.username_petugas, kejadian.tanggal 
    from kejadian  where kejadian.id_kejadian = '$info'
    ";


$hasil=pg_query($querysearch);
while($row = pg_fetch_array($hasil))
	{
		  $id=$row['id_kejadian'];
		  $jam=$row['jam'];
          $id_regu=$row['id_regu'];
          $lokasi=$row['lokasi'];
          $kronologis=$row['kronologis'];
		  $longitude=$row['lng'];
          $latitude=$row['lat'];
          $kerusakan=$row['kerusakan'];			
          $luas_area=$row['luas_area'];
          $taksiran_kerugian=$row['taksiran_kerugian'];
          $username_admin =$row['username_admin'];
          $username_petugas =$row['username_petugas'];
          $tanggal=$row['tanggal'];
		  $dataarray[]=array('id_kejadian'=>$id,'jam'=>$jam, 'id_regu'=>$id_regu, 'lokasi'=>$lokasi,
          'kronologis'=>$kronologis,'longitude'=>$longitude,
          'latitude'=>$latitude, 'kerusakan'=>$kerusakan, 'luas_area'=>$luas_area,
          'taksiran_kerugian'=>$taksiran_kerugian, 'username_admin' =>$username_admin,
          'username_petugas' =>$username_petugas,
          'tanggal'=>$tanggal);
	}
echo json_encode ($dataarray);
?>
