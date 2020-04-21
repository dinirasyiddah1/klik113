<?php 
include 'connect.php';
// $id = $_GET['id_pos_damkar'];
// pg_query("DELETE FROM public.pos_damkar WHERE id_pos_damkar='$id'");


// header("location:fire_station_list.php");


$id = isset($_REQUEST['id_pos_damkar']) ? $_REQUEST['id_pos_damkar'] : '';
if ($id <> '') {
//    jalankan perintah hapus data
   $delete_pos = pg_query("DELETE FROM public.pos_damkar WHERE id_pos_damkar='$id'");
   $delete3_gambar = pg_query("DELETE FROM public.gambar_pos WHERE id_pos_damkar='$id'");
   // header("location:fire_station_list.php");
}





?>

