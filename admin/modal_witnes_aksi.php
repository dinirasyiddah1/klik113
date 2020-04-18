<?php
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['witness'];
$nama           = $_POST['name'];
$pekerjaan      = $_POST['job'];
$suku           = $_POST['suku'];
$alamat         = $_POST['address'];


// query SQL untuk insert data
$sql = pg_query
	("INSERT INTO public.saksi
		(id_saksi, nama_saksi, pekerjaan_saksi, id_suku, alamat_saksi)
	VALUES 
		('$id', '$nama', '$pekerjaan', '$suku', '$alamat')
	");

if($sql){
	

	header('location:input_incident.php');
	
}else{
	echo"gagal";
}


?>