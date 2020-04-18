<?php
include 'conf.php';
$konfigurasi = new konfigurasi();
$getData = $konfigurasi->tampilDataPencarianLokasi('tabel_data','id',$_GET['id']);
header("Content-type: text/xml");
try {
 echo "<markers>";
 if ($getData->rowCount() == 1) {
    $result = $getData->fetch(PDO::FETCH_OBJ);
   echo "<marker ";
   echo "a='" . $result->id. "' ";
   echo "b='" . $result->latitude. "' ";
   echo "c='" . $result->longitude. "' ";
   echo "d='" . $result->keterangan. "' ";
   echo "e='" . $result->kategori. "' ";
   echo "/>";
  }
 echo "</markers>";
}
catch (PDOException $e) {
 echo $e->getMessage();
}
?>