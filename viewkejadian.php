<?php
    include 'admin/connect.php';
    $id = $_GET['id'];
    $querysearch	="SELECT kejadian.id_kejadian, kejadian.lokasi, ST_X(ST_Centroid(kejadian.geom)) AS lng, ST_Y(ST_CENTROID(kejadian.geom)) 
                As lat FROM kejadian";
                
    $hasil=pg_query($querysearch);
    while($baris = pg_fetch_array($hasil))
        {
            $id=$baris['id_kejadian'];
            $address=$baris['lokasi']; 
            $longitude=$baris['lng'];
            $latitude=$baris['lat'];
            $dataarray[]=array('id_kejadian'=>$id,'lokasi'=>$address,'lng'=>$longitude,'lat'=>$latitude);
        }
    echo json_encode ($dataarray);
?>

