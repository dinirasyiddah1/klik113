<?php 
include 'connect.php';
// $id = $_GET['id_pos_damkar'];
// pg_query("DELETE FROM public.pos_damkar WHERE id_pos_damkar='$id'");


// header("location:fire_station_list.php");


$id = isset($_REQUEST['id_kejadian']) ? $_REQUEST['id_kejadian'] : '';
if ($id <> '') {
//    jalankan perintah hapus data
   $delete=pg_query("DELETE FROM public.kejadian WHERE id_kejadian='$id'");
   $delete1=pg_query("DELETE FROM public.detail_saksi WHERE id_kejadian='$id'");
   $delete2=pg_query("DELETE FROM public.detail_pelapor WHERE id_kejadian='$id'");
   $delete3=pg_query("DELETE FROM public.gambar_kejadian WHERE id_kejadian='$id'");
   
}

// if($delete2){
// 			header('location:fire_incident.php');
// 			}else{
// 			echo"gagal";
// 			}



?>

