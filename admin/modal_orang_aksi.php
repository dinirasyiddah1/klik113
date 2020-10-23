<?php
include 'connect.php';
// menyimpan data kedalam variabel
$nama           = $_POST['name'];
$umur			= $_POST['age'];
$pekerjaan      = $_POST['job'];
$suku           = $_POST['suku'];
$alamat         = $_POST['address'];
$no_hp         = $_POST['no_hp'];

$query = pg_query("SELECT max(id_orang) AS maxid FROM orang");
$data = pg_fetch_array($query);
$id_orang = $data['maxid'];
$no_urut = substr($id_orang,2,5);
$no_urut++;
$char = "P";
$id_orang = $char . sprintf("%05s",$no_urut);

// query SQL untuk insert data
$sql = pg_query
	("INSERT INTO public.orang
		(id_orang, nama_orang, umur_orang, pekerjaan_orang, id_suku, alamat_orang, no_hp)
	VALUES 
		('$id_orang', '$nama', '$umur', '$pekerjaan', '$suku', '$alamat', '$no_hp')
	");

if($sql){
	

	header('location:input_incident.php');
	echo "<div class='alert alert-success' role='alert'>
	Data entered successfully
  </div>";
}else{
	echo"gagal";
}


?>