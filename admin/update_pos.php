<?php 
 
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['id_pos_damkar'];
$geom 			= $_POST['geom'];
$nama           = $_POST['nama_pos'];
$alamat         = $_POST['alamat'];

$image=$_FILES['image']['name'];

 
// query SQL untuk update data
$sql = pg_query
	("UPDATE public.pos_damkar
	SET id_pos_damkar='$id', geom=ST_GeomFromText('$geom'), nama_pos='$nama', alamat='$alamat'
	WHERE id_pos_damkar='$id'
	");


//upload foto
if (strlen($image)>0) {
	if (is_uploaded_file($_FILES['image']['tmp_name'])) {
		move_uploaded_file($_FILES['image']['tmp_name'], "../image/fire station/".$image);
	}
}


if($sql){
	header('location:fire_station_list.php');
}else{
	echo"gagal";
}




?>