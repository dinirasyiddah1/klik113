<?php 
include 'connect.php';
// $id = $_GET['id_pos_damkar'];
// pg_query("DELETE FROM public.pos_damkar WHERE id_pos_damkar='$id'");


// header("location:fire_station_list.php");


$id = isset($_REQUEST['id_kejadian']) ? $_REQUEST['id_kejadian'] : '';
if ($id <> '') {
//    jalankan perintah hapus data
   
   $delete1=pg_query("DELETE FROM public.detail_saksi WHERE id_kejadian='$id'");
   $delete2=pg_query("DELETE FROM public.detail_pelapor WHERE id_kejadian='$id'");
   $delete3=pg_query("DELETE FROM public.gambar_kejadian WHERE id_kejadian='$id'");
   $delete4=pg_query("DELETE FROM public.detail_instansi WHERE id_kejadian='$id'");
   $delete5=pg_query("DELETE FROM public.detail_kendaraan WHERE id_kejadian='$id'");
   $delete6=pg_query("DELETE FROM public.detail_korban WHERE id_kejadian='$id'");
   $delete7=pg_query("DELETE FROM public.detail_objek_terbakar WHERE id_kejadian='$id'");
   $delete8=pg_query("DELETE FROM public.detail_penyebab WHERE id_kejadian='$id'");
   $delete=pg_query("DELETE FROM public.kejadian WHERE id_kejadian='$id'");
}

if($delete){
			header('location:fire_incident.php');
			}else{
			echo"gagal";
			}



?>

