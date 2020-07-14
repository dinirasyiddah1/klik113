<?php
include ('admin/connect.php');
session_start();
if(isset($_POST['username'])){
	$username = $_POST['username'];
	$password = $_POST['password'];
	$pass = md5($password);
	$sql = pg_query("SELECT * FROM petugas WHERE username_petugas='$username' and password='$pass'");
	$num = pg_num_rows($sql);
	$dt = pg_fetch_array($sql);
	if($num==1){
		$_SESSION['petugas'] = true;
		$_SESSION['username'] = $username;
		// $result = pg_query("update login set last_login = now() where username='$username'");
		?><script language="JavaScript">document.location='petugas/'</script><?php
		//console.log('suksess');
	}else{
		//console.log('gagal');
		echo "<script>
		alert (' Maaf Login Gagal, Silahkan Isi Username dan Password Anda Dengan Benar');
		eval(\"parent.location='login.php '\");
		</script>";
	}
}
?>