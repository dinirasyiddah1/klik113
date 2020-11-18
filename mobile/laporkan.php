<?php
include ('../admin/connect.php');
$lat=$_POST['lat'];
$lng=$_POST['lon'];
$id_laporan=$_POST['id_laporan'];
$nama_orang=$_POST['nama_orang'];
$no_hp=$_POST['no_hp'];
$lokasi= $_POST['lokasi'];
//$nov=$_POST['nov'];

$query1 = pg_query("SELECT MAX(id_orang) as id_orang from orang");
	$result1 = pg_fetch_array($query1);
	$id_orang = $result1['id_orang'];
	$id_orang++;


$query = pg_query("SELECT MAX(id_laporan) as id_laporan from detail_pelapor");
	$result = pg_fetch_array($query);
	$id_laporan = $result['id_laporan'];
	$no_lap = substr($id_laporan,2,5);
	$no_lap++;
	$charLap = "L";
	$id_laporan = $charLap . sprintf("%05s",$no_lap);
		var_dump($id_laporan);

	$id_kejadian=0;
	$status='New Report';
	date_default_timezone_set('Asia/Jakarta');
	$tanggal = date('d-m-Y');
	$jam = date('H:i:s');
	$media= $id_laporan . "1.jpg";
	

	$sql1 = pg_query("INSERT INTO public.orang(
	id_orang, nama_orang, no_hp)
	VALUES ('$id_orang', '$nama_orang', '$no_hp')");
	
	
	$sql2= pg_query ("INSERT INTO public.detail_pelapor(
	id_laporan,id_kejadian, id_orang, status_pelaporan, tanggal, jam, lat, lon, media,  lokasi)
	VALUES 
	('$id_laporan','$id_kejadian', '$id_orang', '$status', '$tanggal', '$jam', '$lat', '$lng', '$media','$lokasi')");

// if ($sql){
// 	echo "<script>
// 		alert ('Reported Successfully');
// 		eval(\"parent.location='status.php '\");
// 		</script>";
// }
		

// else{
// 	echo "<script>
// 	alert ('Reported Failed, Please Repeat Again');
// 	// window.location=history.go(-1);
// 	</script>";
// }