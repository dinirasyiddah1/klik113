<?php
	$host = "localhost";
	$user = "postgres";
	$pass = "dini";
	$port = "5433";
	$dbname = "kuliner_bkt";
	$conn = pg_connect("host=".$host." port=".$port." dbname=".$dbname." user=".$user." password=".$pass) or die("Gagal");
?>