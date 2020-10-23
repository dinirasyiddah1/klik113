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
// require 'admin/connect.php';
// $querysearch=" SELECT kejadian.geom from kejadian, kecamatan  
// WHERE st_contains(kecamatan.geom, kejadian.geom) and kecamatan.id_kecamatan='4'
// 	 ";

// $hasil=pg_query($querysearch);
// $jumlah = 0;
// while($data=pg_fetch_array($hasil))
//  {
// 	$jumlah=$jumlah+1;
//  };
//  echo $jumlah;

?>



<!-- menampilkan jumlah data per id -->
<?php
// require 'admin/connect.php';

// for($i=1; $i<12; $i++){
// 	$querysearch=" SELECT kejadian.geom from kejadian, kecamatan  
// WHERE st_contains(kecamatan.geom, kejadian.geom) and kecamatan.id_kecamatan='$i'
// 	 ";
// 	 $hasil=pg_query($querysearch);
// $jumlah = 0;
// while($data=pg_fetch_array($hasil))
//  {
// 	$jumlah=$jumlah+1;
//  };
//  echo $i; echo '&nbsp';
//  echo $jumlah;
//  echo '<br>';	 
// }


?>


<!-- conversi sql to json -->
<?php
require 'admin/connect.php';

$id_kecamatan = $_GET['id'];
$querysearch=" SELECT kejadian.geom from kejadian, kecamatan  
WHERE st_contains(kecamatan.geom, kejadian.geom) and kecamatan.id_kecamatan='$id_kecamatan'
	 ";
	 $hasil=pg_query($querysearch);

	 $kecamatan = array();

while($data=pg_fetch_array($hasil))
 {
	 $kecamatan[] = $data;
	// $jumlah=$jumlah+1;
 };
 echo json_encode($kecamatan);
//  echo $i; echo '&nbsp';
//  echo $jumlah;
//  echo '<br>';	 



?>

<!-- dari tes.php -->
<?php
require 'admin/connect.php';
$id_kecamatan = $_GET['id'];
$querysearch=" SELECT row_to_json(fc) 
    FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features 
    FROM (SELECT 'Feature' As type , ST_AsGeoJSON(kejadian.geom)::json As geometry , row_to_json((SELECT l 
    FROM (SELECT kejadian.id_kejadian, kecamatan.id_kecamatan, ST_X(ST_Centroid(kejadian.geom)) AS lon, ST_Y(ST_CENTROID(kejadian.geom)) As lat) As l )) As properties 
    FROM kecamatan,kejadian WHERE st_contains(kecamatan.geom, kejadian.geom) and id_kecamatan='1'
    ) As f ) As fc
     ";
$hasil=pg_query($querysearch);
while($data=pg_fetch_array($hasil))
 {
  $load=$data['row_to_json'];
 }
 echo $load;
?>
