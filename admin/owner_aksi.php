<?php 
error_reporting(E_ERROR | E_PARSE);
include 'connect.php';
$pemilik = $_POST['pemilik'];
 
$sql = pg_query("INSERT INTO tes (id_tes) values('$pemilik')");

if($pemilik == null){
	echo json_encode(['data' => "data kosong"]);
}elseif($sql){
	echo json_encode(['data' => "ok"]);
}else{
	echo json_encode(['data' => "data already exist"]);
}

?>