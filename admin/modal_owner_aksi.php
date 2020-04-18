<?php
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['owner'];
$nama           = $_POST['name'];
$umur			= $_post['age'];
$pekerjaan      = $_POST['job'];
$suku           = $_POST['suku'];
$alamat         = $_POST['address'];


// query SQL untuk insert data
$sql = pg_query
	("INSERT INTO public.pemilik
		(id_pemilik, nama_pemilik, umur_pemilik, pekerjaan_pemilik, id_suku, alamat_pemilik)
	VALUES 
		('$id', '$nama', '$umur', '$pekerjaan', '$suku', '$alamat')
	");

if($sql){
	

	header('location:input_incident.php');
	var_dump($sql);
}else{
	echo"gagal";
}


?>