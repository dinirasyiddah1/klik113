<?php
include 'connect.php';
// menyimpan data kedalam variabel
$nama           = $_POST['name'];


$query = pg_query("SELECT max(id_instansi) AS maxid FROM instansi");
$data = pg_fetch_array($query);
$id_instansi = $data['maxid'];
$id_instansi++;
var_dump($instansi);

// query SQL untuk insert data
$sql = pg_query
	("INSERT INTO public.instansi
		(id_instansi, nama_instansi)
	VALUES 
		('$id_instansi', '$nama')
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