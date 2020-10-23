<?php
include('admin/connect.php');
$latit=$_GET["lat"];
$longi=$_GET["lng"];
$rad=$_GET["rad"];
$querysearch="SELECT id_kejadian, lokasi,st_x(st_centroid(geom)) as lon,st_y(st_centroid(geom)) as lat,
	st_distance_sphere(ST_GeomFromText('POINT(".$longi." ".$latit.")',-1), kejadian.geom) as jarak 
	FROM kejadian where st_distance_sphere(ST_GeomFromText('POINT(".$longi." ".$latit.")',-1),
	kejadian.geom) <= ".$rad." ORDER BY jarak
			 "; 
$hasil=pg_query($querysearch);
while($row = pg_fetch_array($hasil))
	{
		  $id=$row['id_kejadian'];
		  $name=$row['lokasi'];
		  $longitude=$row['lon'];
		  $latitude=$row['lat'];
		  $dataarray[]=array('id'=>$id,'name'=>$name,
		  'longitude'=>$longitude,'latitude'=>$latitude);
	}
echo json_encode ($dataarray);
?>