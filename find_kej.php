<?php
require 'admin/connect.php';
$cari_nama = $_GET["cari_nama"];
$querysearch	="SELECT distinct id_kejadian, lokasi, st_x(st_centroid(geom)) as longitude, 
st_y(st_centroid(geom)) as latitude, image from kejadian where lower(lokasi)like lower('%$cari_nama%')"; 
$hasil=pg_query($querysearch);
while($row = pg_fetch_array($hasil))
	{
		  $id=$row['id_kejadian'];
		  $lokasi=$row['lokasi']; 
		  $longitude=$row['longitude'];
		  $latitude=$row['latitude'];
		  $dataarray[]=array('id_kejadian'=>$id,'lokasi'=>$name,'longitude'=>$longitude,'latitude'=>$latitude);
	}
echo json_encode ($dataarray);
?>