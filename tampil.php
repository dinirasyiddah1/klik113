<?php 
include "koneksi.php"; 
$sql = "select * FROM simpan";
$tampil = pg_query($sql);
while ($data = pg_fetch_array($tampil)){
// Tampilkan Gambar
echo "<img src='gambar/".$data['gambar']."' width='100px' height='100px'/>";
echo "</br>";
echo $data['keterangan'];
}
?>