<?php
$host = "127.0.0.1";
$user = "postgres";
$pass = "dini";
$port = "5432";
$dbname = "gambar";
$conn = pg_connect("host=".$host." port=".$port." dbname=".$dbname." user=".$user." password=".$pass) or die("Gagal");
?>