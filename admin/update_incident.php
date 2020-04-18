<?php 
 
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['id_kejadian'];
$jam			=$_POST['jam'];
$tanggal			=$_POST['tanggal'];
$geom 			= $_POST['geom'];
$id_regu     = $_POST['id_regu'];
$lokasi         = $_POST['lokasi'];
$kronologis         = $_POST['kronologis'];
$id_pelapor         = $_POST['id_pelapor'];
$id_saksi         = $_POST['id_saksi'];
$kerusakan         = $_POST['kerusakan'];
$luas_area         = $_POST['luas_area'];
$taksiran_kerugian         = $_POST['taksiran_kerugian'];


$image=$_FILES['image']['name'];

 
// query SQL untuk update data
$sql = pg_query
	("UPDATE public.kejadian
	SET id_kejadian='$id', jam='$jam',  id_regu='$id_regu', lokasi='$lokasi', kronologis='$kronologis', 
		geom=ST_GeomFromText('$geom'), kerusakan='$kerusakan',
		luas_area='$luas_area', taksiran_kerugian='$taksiran_kerugian', tanggal = '$tanggal'
	WHERE id_kejadian='$id';
	");

$sql1 = ("UPDATE public.detail_pelapor
		SET id_kejadian = '$id', id_orang='$id_pelapor', status_pelapor=''
		WHERE id_kejadian='$id';
		");
$sql1 = ("UPDATE public.detail_saksi
SET id_kejadian = '$id', id_orang='$id_saksi', status_saksi=''
WHERE id_kejadian='$id';
");

//upload foto
if (strlen($image)>0) {
	if (is_uploaded_file($_FILES['image']['tmp_name'])) {
		move_uploaded_file($_FILES['image']['tmp_name'], "../image/fireincident/".$image);
	}
}


// if($sql){
// 	header('location:fire_incident.php');
// }else{
// 	echo"gagal";
// }

 
?>