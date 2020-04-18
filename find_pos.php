<?php
require 'admin/connect.php';
$cari_nama = $_GET["cari_nama"];
$querysearch	="SELECT distinct id_pos_damkar, nama_pos_damkar,alamat, st_x(st_centroid(geom)) as longitude, 
st_y(st_centroid(geom)) as latitude, image from pos_damkar where lower(nama_pos_damkar)like lower('%$cari_nama%')"; 
$hasil=pg_query($querysearch);
while($row = pg_fetch_array($hasil))
	{
		  $id=$row['id_pos_damkar'];
		  $name=$row['nama_pos_damkar']; 
		  $address=$row['alamat'];
		  $longitude=$row['longitude'];
		  $latitude=$row['latitude'];
		  $dataarray[]=array('id_pos_damkar'=>$id,'nama_pos_damkar'=>$name,'alamat'=>$address,'longitude'=>$longitude,'latitude'=>$latitude);
	}
echo json_encode ($dataarray);
?>