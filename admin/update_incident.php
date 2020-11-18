<?php 
 
include 'connect.php';
// menyimpan data kedalam variabel
$id					= $_GET['id_kejadian'];
$jam				= $_POST['jam'];
$tanggal			= $_POST['tanggal'];
$geom 				= $_POST['geom'];
$id_regu     		= $_POST['regu_piket'];
$lokasi         	= $_POST['lokasi'];
$kronologis         = $_POST['kronologis'];
$id_pelapor         = $_POST['pelapor'];
$id_saksi        	= $_POST['saksi'];
$kerusakan          = $_POST['kerusakan'];
$luas_area          = $_POST['luas_area'];
$taksiran_kerugian  = $_POST['taksiran_kerugian'];
$admin				= $_POST['admin'];
$rt					= $_POST['rt'];
$rw					= $_POST['rw'];
$kelurahan			= $_POST['kelurahan'];
$jenis_kejadian		= $_POST['jenis_kejadian'];
$personil			= $_POST['personil'];
$instansi			= $_POST['instansi'];
$kendaraan			= $_POST['kendaraan'];
$id_korban			= $_POST['korban'];
$kondisi		= $_POST['kondisi'];
$penyebab			= $_POST['penyebab'];
$id_penyebab		= $_POST['kategori_penyebab'];
$objek_terbakar		= $_POST['objek_terbakar'];
$pemilik			= $_POST['pemilik'];

$image=$_FILES['image']['name'];
$cek=0;
// query SQL untuk update data
$sql = pg_query
	("UPDATE public.kejadian
	SET id_kejadian='$id', jam='$jam',  id_regu='$id_regu', lokasi='$lokasi', kronologis='$kronologis', 
		geom=ST_GeomFromText('$geom'), kerusakan='$kerusakan',
		luas_area='$luas_area', taksiran_kerugian='$taksiran_kerugian', username_admin='$admin', 
		username_petugas='admin', tanggal = '$tanggal', rt='$rt', rw='$rw', kelurahan='$kelurahan'
	WHERE kejadian.id_kejadian='$id'
	");
$cek++;
//update detail_pelapor


// $pelapors = pg_query("SELECT max(id_laporan) AS maxidpel FROM detail_pelapor where id_orang ='$id_pelapor'");
// 		$laporan = pg_fetch_array($pelapors);
// 		$id_laporan = $laporan['maxidpel'];
// 		$id_laporan++;
$sql_pelapor;
foreach($id_pelapor as $pelapor_val){
	//$pelapor = pg_query("SELECT id_laporan FROM detail_pelapor where id_kejadian = '$id' and id_orang='$pelapor_val'");
	$sql_pelapor = pg_query("UPDATE public.detail_pelapor
	SET id_orang='$pelapor_val'	WHERE id_kejadian='$id' 
	");
};

//var_dump($sql_pelapor);

$delete_saksi = pg_query("DELETE FROM detail_saksi WHERE id_kejadian='$id'");
//update detail_saksi
foreach ($id_saksi as $saksi_val) {	
	$sql_saksi = pg_query(
		"INSERT INTO detail_saksi (id_kejadian,id_orang)
		VALUES
		 ('$id','$saksi_val')
		"
	);
};
		if($sql_saksi){
			$cek++;
		}


	//update detail_korban
$delete_korban = pg_query("DELETE FROM detail_korban WHERE id_kejadian='$id'");
		foreach ($id_korban as $key=>$value) {	
			$sql_korban = pg_query("INSERT INTO detail_korban (id_kejadian, id_korban, id_kondisi)
			VALUES ('$id','$value', '$kondisi[$key]')
			");
		};

//update detail_objek_terbakar
$delete_objek = pg_query("DELETE FROM detail_objek_terbakar WHERE id_kejadian='$id'");
foreach($objek_terbakar as $key=>$value){
		$sql_objek = pg_query("INSERT INTO detail_objek_terbakar (id_objek, id_kejadian, id_orang, jenis_kejadian)
					VALUEs ('$value', '$id', '$pemilik[$key]', '$jenis_kejadian')
			");
};

//update detail_penyebab
$delete_penyebab = pg_query("DELETE FROM detail_penyebab WHERE id_kejadian='$id'");
foreach($id_penyebab as $key=>$value){	
	$sql_penyebab = pg_query("INSERT INTO detail_penyebab (id_penyebab, id_kejadian, penyebab)
	VALUES('$value', '$id', '$penyebab')
	");
};

//update detail_instansi
$delete_instansi = pg_query("DELETE FROM detail_instansi WHERE id_kejadian='$id'");
foreach ($instansi as $value) {
	$sql_instansi = pg_query("INSERT INTO detail_instansi (id_kejadian, id_instansi, jumlah_personil)
					VALUES ('$id', '$value', $personil)
			");
};

//update detail_kendaraan
$delete_kendaraan = pg_query("DELETE FROM detail_kendaraan WHERE id_kejadian='$id'");
foreach ($kendaraan as $value) {
	$sql_kendaraan = pg_query("INSERT INTO detail_kendaraan (id_kejadian, nomor_plat)
						VALUES ('$id', '$value')
			");
};





//upload foto
$query = pg_query("SELECT max(id_gambar) AS maxid FROM gambar_kejadian");
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
	move_uploaded_file($tmp_name, "../file/fireincident/".$id."/".$file_name);
	pg_query($conn,"INSERT INTO gambar_kejadian VALUES('$id','$id_gambar', '$file_name')");		
	$id_gambar++;		
  }
//   header('location:fire_incident.php');
  
}
else{
//   echo "Gambar tidak ada";
}


// if($sql){
// 	header('location:fire_incident.php');
// }else{
// 	echo"gagal";
// }

 
?>