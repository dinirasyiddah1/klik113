<?php
require 'admin/connect.php';
$kecamatan_id=$_GET['kecamatan'];
$querysearch = pg_query("SELECT 
	kejadian.id_kejadian,
	kejadian.lokasi,
	kejadian.geom,
	st_x(st_centroid(kejadian.geom)) as longitude,
	st_y(st_centroid(kejadian.geom)) as latitude 
	from kejadian, kecamatan 
	WHERE st_contains(kecamatan.geom, kejadian.geom) and kecamatan.id_kecamatan='$kecamatan_id'");

while ($row=pg_fetch_assoc($querysearch)) 
$data[]=$row;
echo $_GET['jsoncallback'].''.json_encode($data).'';
?>
