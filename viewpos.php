<?php
    include 'admin/connect.php';
    $id = $_GET['id'];
    $querysearch	="SELECT pos_damkar.id_pos_damkar, pos_damkar.nama_pos, pos_damkar.alamat, 
    ST_X(ST_Centroid(pos_damkar.geom)) AS lng, ST_Y(ST_CENTROID(pos_damkar.geom)) 
                As lat FROM pos_damkar";
                
    $hasil=pg_query($querysearch);
    while($baris = pg_fetch_array($hasil))
        {
            $id=$baris['id_pos_damkar'];
            $name=$baris['nama_pos'];
            $address=$baris['alamat']; 
            $longitude=$baris['lng'];
            $latitude=$baris['lat'];
            $dataarray[]=array('id_pos_damkar'=>$id,'nama_pos'=>$name,'alamat'=>$address,'lng'=>$longitude,'lat'=>$latitude);
        }
    echo json_encode ($dataarray);
?>

