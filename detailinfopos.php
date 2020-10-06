<?php
require 'admin/connect.php';
$info = $_GET["info"];
$querysearch ="select pos_damkar.id_pos_damkar,pos_damkar.nama_pos,pos_damkar.alamat,
ST_X(ST_Centroid(pos_damkar.geom)) AS lng, ST_Y(ST_CENTROID(pos_damkar.geom)) As lat 
from pos_damkar where pos_damkar.id_pos_damkar = '$info'
";


$hasil=pg_query($querysearch);
while($row = pg_fetch_array($hasil))
	{
		  $id=$row['id_pos_damkar'];
		  $name=$row['nama_pos'];
		  $alamat=$row['alamat'];
		  $image=$row['image'];		 
		  $longitude=$row['lng'];
		  $latitude=$row['lat'];
		  $dataarray[]=array('id_pos_damkar'=>$id,'nama_pos'=>$name,'alamat'=>$alamat,'image'=>$image,'longitude'=>$longitude,'latitude'=>$latitude);
	}
echo json_encode ($dataarray);
?>
