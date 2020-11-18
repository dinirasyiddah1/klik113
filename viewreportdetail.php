

<?php
include 'admin/connect.php';
$info = $_GET["info"];
$querysearch	="SELECT detail_pelapor.id_laporan, detail_pelapor.tanggal, detail_pelapor.lokasi, detail_pelapor.lon AS lng, detail_pelapor.lat
            As lat, detail_pelapor.media, detail_pelapor.id_laporan FROM detail_pelapor where detail_pelapor.id_laporan='$info'";
			   
$hasil=pg_query($querysearch);
while($baris = pg_fetch_array($hasil))
	{
        $id=$baris['id_laporan'];
        $tanggal=$baris['tanggal']; 
        $address=$baris['lokasi']; 
        $longitude=$baris['lng'];
        $latitude=$baris['lat'];
        $media = $baris['media'];
        $id_laporan = $baris['id_laporan'];
        $dataarray[]=array('id_detail_pelapor'=>$id,'tanggal'=>$tanggal,'lokasi'=>$address,'lng'=>$longitude,'lat'=>$latitude, 'media'=>$media, 'id_laporan'=>$id_laporan);
    }
echo json_encode ($dataarray);
?>

