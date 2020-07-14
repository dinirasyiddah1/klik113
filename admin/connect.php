<?php
	$host = "127.0.0.1";
	$user = "postgres";
	$pass = "dini";
	$port = "5433";
	$dbname = "klik-1juli";
	$conn = pg_connect("host=".$host." port=".$port." dbname=".$dbname." user=".$user." password=".$pass) or die("Gagal");
?>

