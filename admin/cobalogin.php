<?php
$host = "127.0.0.1";
$user = "postgres";
$pass = "dini";
$port = "5433";
$dbname = "klik";
$conn = pg_connect("host=".$host." port=".$port." dbname=".$dbname." user=".$user." password=".$pass) or die("Gagal");


 $uid = $_GET["strUsername"];
 $pwd = $_GET["strPassword"];
 
 $res = pg_query("SELECT username_admin FROM admin WHERE username_admin = '$uid' AND password = '$pwd'");
 $count = pg_num_rows($res);
 echo $conn;
//  if ($count == 0) {
//      echo 'Username salah!';
//  }
//  else {
//      if ($row = pg_fetch_array($res)) {
//          echo 'Selamat datang, '.$row['User_Name'];
//      }
//  }
?>