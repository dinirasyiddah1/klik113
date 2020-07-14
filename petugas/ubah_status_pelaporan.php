<?php
include '../admin/connect.php';
$id = $_GET['id_laporan'];
$status= $_POST['status_pelaporan'];

$sql = pg_query
("UPDATE public.detail_pelapor
SET status_pelaporan = '$status'
WHERE id_laporan='$id'
");

if($sql){
	header('location:index.php');
	
}else{
	echo"gagal";
}
?>