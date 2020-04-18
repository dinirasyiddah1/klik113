<?php
include 'conf.php';
$konfigurasi = new konfigurasi();
if (isset($_GET['term'])) {
$getData = $konfigurasi->cariData('tabel_data','id','keterangan', $_GET['term'],$_GET['term']);
$arr = array();
while ($data = $getData->fetch(PDO::FETCH_ASSOC)) {
    $arr[] = array(
      'label' => $data['id'].' - '.$data['keterangan'],
      'value' => $data['id'].','.$data['keterangan'].','.$data['latitude'].','.$data['longitude'],
    );
}
echo json_encode($arr);
}
 ?>