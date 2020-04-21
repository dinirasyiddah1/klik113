<?php 
 
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_GET['id_pos_damkar'];
$geom 			= $_POST['geom'];
$nama           = $_POST['nama_pos'];
$alamat         = $_POST['alamat'];

$image=$_FILES['image']['name'];


// query SQL untuk update data
$sql = pg_query
	("UPDATE public.pos_damkar
	SET id_pos_damkar='$id', nama_pos='$nama', alamat='$alamat', geom=ST_GeomFromText('$geom')
	WHERE id_pos_damkar='$id'
	");


//upload foto
$query = pg_query("SELECT max(id_gambar) AS maxid FROM gambar_pos");
$data = pg_fetch_array($query);
$id_gambar = $data['maxid'];
$no_urut = substr($id_gambar,3,5);
$no_urut++;
$char = "IM";
$id_gambar = $char . sprintf("%05s",$no_urut);
var_dump($id_gambar);

$jumlah = count($_FILES['gambar']['name']);
if ($jumlah > 0) {
  for ($i=0; $i < $jumlah; $i++) { 
	$file_name = $_FILES['gambar']['name'][$i];
	$tmp_name = $_FILES['gambar']['tmp_name'][$i];				
	move_uploaded_file($tmp_name, "../file/firestaion/".$file_name);
	pg_query($conn,"INSERT INTO gambar_pos VALUES('$id','$id_gambar', '$file_name')");		
	$id_gambar++;		
  }
  echo "Berhasil Upload";
  
}
else{
  echo "Gambar tidak ada";
}


// if($sql){
// 	header('location:fire_station_list.php');
// }else{
// 	echo"gagal";
// }




?>