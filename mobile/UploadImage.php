<?php
include '../admin/connect.php';
/**
* Created by PhpStorm.
* User: rscheel
* Date: 10-08-2017
* Time: 8:26
*/

$query = pg_query("SELECT max(id_laporan) AS maxid FROM detail_pelapor");
$data = pg_fetch_array($query);
$id_laporan = $data['maxid'];
// $no_lap = substr($id_laporan,2,5);
// $charLap = "L";
// $id_laporan = $charLap . sprintf("%05s",$no_lap);

$query = pg_query("SELECT * FROM detail_pelapor WHERE id_laporan = '$id_laporan'");
$data = pg_fetch_array($query);
$tanggal = $data['tanggal'];

define('KB', 1024);
define('MB', 1048576);
define('GB', 1073741824);
define('TB', 1099511627776);
$jam = date('h:i:s'); 
mkdir('\\ms4w\\Apache\\htdocs\\klik113\\file\\pelaporan\\'.$tanggal, 0777, true);
$target_dir = "../file/pelaporan/$tanggal/$id_laporan";
$target_file = $target_dir . basename($_FILES["file"]["name"]);

$uploadOk = 1;
$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);

// Compruebe si el archivo de imagen es una imagen real o una imagen falsa
$check = getimagesize($_FILES["file"]["tmp_name"]);
if($check !== false) {
    //echo "El archivo es una imagen - " . $check["mime"] . ".";
    $uploadOk = 1;
} else {
    //echo "El archivo no es una imagen.";
    $uploadOk = 0;
}

if($uploadOk) {
    // Comprueba si el archivo ya existe.
    if (file_exists($target_file)) {
        echo "Lo sentimos, el archivo ya existe.";
        $uploadOk = 0;
    }
    // Verificar el tamaño del archivo
    if ($_FILES["file"]["size"] > 1 * MB) {
        echo "Lo siento, su archivo es demasiado grande.";
        $uploadOk = 0;
    }
    // Permitir ciertos formatos de archivo
    if ($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
        && $imageFileType != "gif") {
        echo "Lo sentimos, sólo se permiten archivos JPG, JPEG, PNG y GIF.";
        $uploadOk = 0;
    }
    // Compruebe si $uploadOk está establecido en 0 por un error
    if ($uploadOk == 0) {
        echo "Lo sentimos, su archivo no se ha cargado.";

    // Si esta bien, trata de guardar archivo
    } else {
        if (move_uploaded_file($_FILES["file"]["tmp_name"], $target_file)) {
            echo basename($_FILES["file"]["name"]);
        } else {
            echo "Error!!!";
        }
    }
} else {
    echo "El archivo no es una imagen.";
}
