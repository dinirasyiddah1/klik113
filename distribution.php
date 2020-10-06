<?php
// require 'admin/connect.php';
// $querysearch=" SELECT row_to_json(fc) 
//     FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features 
//     FROM (SELECT 'Feature' As type , ST_AsGeoJSON(kecamatan.geom)::json As geometry , row_to_json((SELECT l 
//     FROM (SELECT kecamatan.id_kecamatan) As l )) As properties 
//     FROM kecamatan As kecamatan  
//     ) As f ) As fc
//      ";
// $hasil=pg_query($querysearch);
// while($data=pg_fetch_array($hasil))
//  {
//   $load=$data['row_to_json'];
//  }
//  echo $load;
?>

<?php
require 'admin/connect.php';
$querysearch=" SELECT kejadian.geom from kejadian, kecamatan  
WHERE st_contains(kecamatan.geom, kejadian.geom) and kecamatan.id_kecamatan='4'
	 ";

$hasil=pg_query($querysearch);
$jumlah = 0;
while($data=pg_fetch_array($hasil))
 {
	$jumlah=$jumlah+1;
 };
 echo $jumlah;

?>
