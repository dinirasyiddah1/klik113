<?php
include('../admin/connect.php');
$sql  = "SELECT  
			ST_AsGeoJSON(geom) AS geometry,
			id_kejadian, lokasi
		FROM kejadian
		";
$geojson = array(
	'type'      => 'FeatureCollection',
	'features'  => array()
);
$query = pg_query($sql);
if(pg_num_rows($query)==0) return 0;
while($rows=pg_fetch_assoc($query)){
	$feature = array(
		"type" => 'Feature',
		'geometry' => json_decode($rows['geometry'], true),
		'jenis' => "House",
		'properties' => array(
			'id' => $rows['id_kejadian'],
			'nama' => $rows['lokasi']
		)
	);
	array_push($geojson['features'], $feature);
}
echo json_encode($geojson);