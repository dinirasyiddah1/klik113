
<?php
include 'connect.php';
// menyimpan data kedalam variabel
$waktu			= $_POST['jam'];   
$geom 			= $_POST['geom'];
$regu			= $_POST['regu_piket'];
$jenis_kejadian	= $_POST['jenis_kejadian'];
$objek_terbakar	= $_POST['objek_terbakar'];
$penyebab 		= $_POST['penyebab'];
$id_penyebab	= $_POST['kategori_penyebab'];
$alamat         = $_POST['lokasi'];
$kronologis		= $_POST['kronologis'];
$pelapor		= $_POST['pelapor'];
$pemilik		= $_POST['pemilik'];
$saksi			= $_POST['saksi'];
$personil		= $_POST['personil'];
$instansi		= $_POST['instansi'];
$kendaraan		= $_POST['kendaraan'];
$kerusakan		= $_POST['kerusakan'];
$luas_area		= $_POST['luas_area'];
$taksiran_kerugian	= $_POST['taksiran_kerugian'];
$tanggal		= $_POST['tanggal'];
$image=$_FILES['image']['name'];

$query = pg_query("SELECT max(id_kejadian) AS maxid FROM kejadian");
$data = pg_fetch_array($query);
$id_kejadian = $data['maxid'];
$no_urut = substr($id_kejadian,3,4);
$no_urut++;
$char = "FI";
$id_kejadian = $char . sprintf("%04s",$no_urut);




				// query SQL untuk insert data
			$sql = pg_query
			("INSERT INTO public.kejadian
				(id_kejadian, jam, id_regu, lokasi, kronologis, geom, kerusakan, luas_area, taksiran_kerugian, tanggal)
				VALUES 
				('$id_kejadian', '$waktu', '$regu', '$alamat', '$kronologis', ST_GeomFromText('$geom'), '$kerusakan', '$luas_area', '$taksiran_kerugian', '$tanggal')
			");

			foreach($id_penyebab as $penyebab)
			$sql_penyebab = pg_query(
				"INSERT INTO detail_penyebab (id_penyebab,id_kejadian,penyebab)
				VALUES
				('$penyebab','$id_kejadian','$penyebab')
				"
			);
			};

			foreach($pelapor as $pelapor)
			$sql_pelapor = pg_query(
				"INSERT INTO detail_pelapor (id_kejadian,id_orang,status_pelapor)
				VALUES
				 ('$id_kejadian','$pelapor','')
				"
			);

			foreach($objek_terbakar as $objek_terbakar)
			$sql_objek_terbakar = pg_query(
				"INSERT INTO detail_objek_terbakar (id_objek,id_kejadian,id_orang,jenis_kejadian)
				VALUES
				 ('$objek_terbakar','$id_kejadian','$pemilik','$jenis_kejadian')
				"
			);

			$sql_saksi = pg_query(
				"INSERT INTO detail_saksi (id_kejadian,id_orang,status_saksi)
				VALUES
				 ('$id_kejadian','$saksi','')
				"
			);

		foreach ($instansi as $value) {
			$sql_instansi = pg_query(
				"INSERT INTO detail_instansi (id_kejadian,id_instansi,jumlah_personil)
				VALUES
				 ('$id_kejadian','$value','$personil')
				"
			);
		};
			var_dump ($personil);
		foreach ($kendaraan as $isi) {
			$sql_kendaraan = pg_query(
				"INSERT INTO detail_kendaraan (id_kejadian,nomor_plat)
				VALUES
				 ('$id_kejadian','$isi')
				"
			);
		};
			
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
	mkdir('\\ms4w\\Apache\\htdocs\\klik113\\file\\fireincident\\'.$id_kejadian, 0777, true);
  for ($i=0; $i < $jumlah; $i++) { 
	$file_name = $_FILES['gambar']['name'][$i];
	$tmp_name = $_FILES['gambar']['tmp_name'][$i];				
	move_uploaded_file($tmp_name, "../file/fireincident/".$id_kejadian."/".$file_name);
	pg_query($conn,"INSERT INTO gambar_kejadian VALUES('$id_kejadian','$id_gambar', '$file_name')");		
	$id_gambar++;		
  }
  echo "Berhasil Upload";
  
}
else{
  echo "Gambar tidak ada";
}


			if($sql_kendaraan){
			header('location:fire_incident.php');
			}else{
			echo"gagal";
			}
	









?>