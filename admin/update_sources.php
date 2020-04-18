<?php 
 
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['id_sumber_air'];
$id_jenis		= $_POST['id_jenis_sumber_air'];
$geom 			= $_POST['geom'];
$alamat         = $_POST['alamat_sumber_air'];

$image=$_FILES['image']['name'];

 
// query SQL untuk update data
$sql = pg_query
	("UPDATE public.pos_damkar
	SET id_sumber_air='$id', id_jenis_sumber_air='$id_jenis', geom=ST_GeomFromText('$geom'), image='$image', alamat_sumber_air='$alamat'
	WHERE id_sumber_air='$id';
	");

//upload foto
if (strlen($image)>0) {
	if (is_uploaded_file($_FILES['image']['tmp_name'])) {
		move_uploaded_file($_FILES['image']['tmp_name'], "gambar/".$image);
	}
}


if($sql){
	header('location:fire_station_list.php');
}else{
	echo"gagal";
}



mysql_query("UPDATE user SET nama='$nama', alamat='$alamat', pekerjaan='$pekerjaan' WHERE id='$id'");
 
header("location:index.php?pesan=update");
?>