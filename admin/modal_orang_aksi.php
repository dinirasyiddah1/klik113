<?php
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['orang'];
$nama           = $_POST['name'];
$umur			= $_post['age'];
$pekerjaan      = $_POST['job'];
$suku           = $_POST['suku'];
$alamat         = $_POST['address'];
$no_hp         = $_POST['no_hp'];


// query SQL untuk insert data
$sql = pg_query
	("INSERT INTO public.orang
		(id_orang, nama, umur, pekerjaan, id_suku, alamat, no_hp)
	VALUES 
		('$id', '$nama', '$umur', '$pekerjaan', '$suku', '$alamat', '$no_hp')
	");

if($sql){
	

	header('location:input_incident.php');
}else{
	echo"gagal";
}


?>