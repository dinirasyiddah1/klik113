

<?php
include 'admin/connect.php';
$id = $_GET['id'];
$tanggal = date('d-m-Y');
$querysearch	="SELECT detail_pelapor.id_laporan, detail_pelapor.tanggal, detail_pelapor.lokasi, detail_pelapor.lon AS lng, detail_pelapor.lat
            As lat, detail_pelapor.media FROM detail_pelapor where detail_pelapor.tanggal='$tanggal'";
			   
$hasil=pg_query($querysearch);
while($baris = pg_fetch_array($hasil))
	{
        $id=$baris['id_laporan'];
        $tanggal=$baris['tanggal']; 
        $address=$baris['lokasi']; 
        $longitude=$baris['lng'];
        $latitude=$baris['lat'];
        $media = $baris['media'];
        $dataarray[]=array('id_detail_pelapor'=>$id,'tanggal'=>$tanggal,'lokasi'=>$address,'lng'=>$longitude,'lat'=>$latitude, 'media'=>$media);
    }
echo json_encode ($dataarray);
?>



