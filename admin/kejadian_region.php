<?php
require 'connect.php';
$id=$_GET['id_kejadian'];

$querysearch=" SELECT row_to_json(fc) 
    FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features 
    FROM (SELECT 'Feature' As type , ST_AsGeoJSON(kejadian.geom)::json As geometry , row_to_json((SELECT l 
    FROM (SELECT kejadian.id_kejadian, kejadian.lokasi,ST_X(ST_Centroid(kejadian.geom)) AS lon, ST_Y(ST_CENTROID(kejadian.geom)) As lat) As l )) As properties 
    FROM kejadian As kejadian  where id_kejadian='$id'
    ) As f ) As fc
     ";
$hasil=pg_query($querysearch);
while($data=pg_fetch_array($hasil))
 {
  $load=$data['row_to_json'];
 }
 echo $load;
?>

