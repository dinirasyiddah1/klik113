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
$penyebab			= $_POST['penyebab'];
$id_penyebab		= $_POST['kategori_penyebab'];
$objek_terbakar		= $_POST['objek_terbakar'];
$pemilik			= $_POST['pemilik'];
$id_objk			= $_POST['id_objk'];
$id_pemilik			= $_POST['id_pemilik'];

$image=$_FILES['image']['name'];


// query SQL untuk update data
$sql = pg_query
	("UPDATE public.kejadian
	SET id_kejadian='$id', jam='$jam',  id_regu='$id_regu', lokasi='$lokasi', kronologis='$kronologis', 
		geom=ST_GeomFromText('$geom'), kerusakan='$kerusakan',
		luas_area='$luas_area', taksiran_kerugian='$taksiran_kerugian', username_admin='$admin', 
		username_petugas='admin', tanggal = '$tanggal', rt='$rt', rw='$rw', kelurahan='$kelurahan'
	WHERE kejadian.id_kejadian='$id'
	");

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

	

//update detail_saksi
$select_saksi = pg_query("select id_orang from detail_saksi where id_kejadian='$id'");
while($sel_saksi = pg_fetch_array($select_saksi)){
	$sel_saks=$sel_saksi['id_orang'];
		$saksis = pg_query("SELECT max(status_saksi) AS maxstatsak FROM detail_saksi where id_orang ='$id_saksi'");
		$status_saksi = pg_fetch_array($saksis);
		$ssaksi = $status_saksi['maxstatsak'];
		$ssaksi++;

		foreach($id_saksi as $saksi_val){
			$sql_saksi = pg_query("UPDATE public.detail_saksi
			SET id_kejadian = '$id', id_orang='$saksi_val', status_saksi='$ssaksi'
			WHERE id_kejadian='$id' and id_orang='$sel_saks'
			");
		};
	};
		//update detail_korban
$select_korban = pg_query("select id_korban from detail_korban where id_kejadian='$id'");
while($sel_korban = pg_fetch_array($select_korban)){
	$sel_kor=$sel_korban['id_korban'];
		$korbans = pg_query("SELECT max(status_korban) AS maxstatkor FROM detail_korban where id_korban ='$id_korban'");
		$status_korban = pg_fetch_array($korbans);
		$skorban = $status_korban['maxstatkor'];
		$skorban++;

		foreach ($id_korban as $korban_val) {	
			$sql_korban = pg_query("UPDATE public.detail_korban
			SET id_kejadian = '$id', id_korban='$korban_val', status_korban='$skorban'
			WHERE id_kejadian='$id' and id_korban = '$sel_kor'
			");
		};
	};
//update detail_objek_terbakar
$a = 0;
$b=0;	
while ($a< count($objek_terbakar)) {
	$objek=$objek_terbakar[$a];
	$id_objk=$_POST['id_objk'];
if ($b<count($pemilik)){
	$milik=$pemilik[$b];
		$sql_pemilik = pg_query("UPDATE public.detail_objek_terbakar
			SET id_objek='$objek', id_kejadian = '$id', id_orang='$milik', jenis_kejadian='$jenis_kejadian'
			WHERE id_objek = '$id_objk' and id_kejadian='$id' and id_orang = '$id_pemilik'
			");
	echo $id_objk;
		$b++;
 	};
 $a++;
};

//update detail_instansi
$select_instansi = pg_query("select id_instansi from detail_instansi where id_kejadian='$id'");
while($sel_instansi = pg_fetch_array($select_instansi)){
	$sel_inst=$sel_instansi['id_instansi'];
foreach ($instansi as $value) {
	$sql_instansi = pg_query("UPDATE public.detail_instansi
			SET id_kejadian = '$id', id_instansi='$value', jumlah_personil='$sinstansi'
			WHERE id_kejadian='$id' and id_instansi = '$sel_inst'
			");
};
};

//update detail_kendaraan
$select_kendaraan = pg_query("select nomor_plat from detail_kendaraan where id_kejadian='$id'");
while($sel_kendaraan = pg_fetch_array($select_kendaraan)){
	$sel_kend=$sel_kendaraan['nomor_plat'];
foreach ($kendaraan as $nilai) {
	$sql_kendaraan = pg_query("UPDATE public.detail_kendaraan
			SET id_kejadian = '$id', nomor_plat='$nilai'
			WHERE id_kejadian='$id' and nomor_plat='$sel_kend'
			");
};
}
//update detail_penyebab
$select_penyebab = pg_query("select id_penyebab from detail_penyebab where id_kejadian='$id'");
while($sel_penyebab = pg_fetch_array($select_penyebab)){
	$sel_peny=$sel_penyebab['id_penyebab'];
foreach ($id_penyebab as $penyebab_val) {	
	$sql_penyebab = pg_query("UPDATE public.detail_penyebab
	SET id_penyebab='$penyebab_val', id_kejadian = '$id', penyebab='$penyebab'
	WHERE id_kejadian='$id' and id_penyebab = '$sel_peny'
	");
};
}


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
  header('location:fire_incident.php');
  
}
else{
  echo "Gambar tidak ada";
}


// if($sql){
// 	header('location:fire_incident.php');
// }else{
// 	echo"gagal";
// }

 
?>