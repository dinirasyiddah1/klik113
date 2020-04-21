
<?php
include 'connect.php';
// menyimpan data kedalam variabel
$id				= $_POST['id_pos_damkar'];
$geom 			= $_POST['geom'];

$nama           = $_POST['nama_pos'];
$alamat         = $_POST['alamat'];

$image=$_FILES['url_photo']['name'];


$i=0;

$query = pg_query("SELECT max(id_pos_damkar) as maxid FROM pos_damkar");
$data = pg_fetch_array($query);
$id_pos = $data['maxid'];
$no_urut = substr($id_pos,3,4);
$no_urut++;
$char = "FS";
$id_pos = $char. sprintf("%04s",$no_urut);



// query SQL untuk insert data
$sql = pg_query
	("INSERT INTO public.pos_damkar
		(id_pos_damkar, nama_pos, alamat, geom)
	VALUES 
		('$id_pos', '$nama', '$alamat', ST_GeomFromText('$geom'))

	"
	);

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
		mkdir('\\ms4w\\Apache\\htdocs\\klik113\\file\\firestation\\'.$id_pos, 0777, true);
      for ($i=0; $i < $jumlah; $i++) { 
        $file_name = $_FILES['gambar']['name'][$i];
        $tmp_name = $_FILES['gambar']['tmp_name'][$i];				
		move_uploaded_file($tmp_name, "../file/fireincident/".$id_pos."/".$file_name);
        pg_query($conn,"INSERT INTO gambar_pos VALUES('$id_pos','$id_gambar', '$file_name')");		
        $id_gambar++;		
      }
      echo "Berhasil Upload";
    }
    else{
      echo "Gambar tidak ada";
	}


if($sql){
	

	header('location:fire_station_list.php');
	
}else{
	echo"gagal";
}


?>