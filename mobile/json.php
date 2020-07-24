<?php
	
	//header('content-type: application/json');
	header('content-type: application/json; charset=utf8'); //agar aplikasi bisa diakses dari perangkat lain
	header("access-control-allow-origin: *"); 
	include "../admin/connect.php";
	$query = file_get_contents("php://input");
    $query= "SELECT MAX(id_orang) AS id FROM orang";
	$sth = pg_query($query);
	$items = array();
	while($row = pg_fetch_assoc($sth)){
		$items[] = $row;
	}
	print json_encode($items);
?>
