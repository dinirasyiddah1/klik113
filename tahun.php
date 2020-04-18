<?php
require 'admin/connect.php';
$cari_tahun = $_GET["cari_tahun"]."-01-01";
$cari_tahun2 = $_GET["cari_tahun"];
$t = $cari_tahun2."-12-31";
$querysearch	=pg_query(" 	SELECT distinct id_kejadian, lokasi, tanggal,ST_X(ST_Centroid(geom)) AS longitude, 
ST_Y(ST_CENTROID(geom)) As latitude FROM kejadian where tanggal between '$cari_tahun' and '$t'  
				");  
while($row = pg_fetch_array($querysearch))
$data[]=$row;
echo $_GET['jsoncallback'].''.json_encode($data).'';
?>

