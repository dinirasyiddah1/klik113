<?php
include "koneksi.php";

$a=$_FILES['photo']['name'];

pg_query("INSERT INTO simpan(photo) VALUES('$a')");
echo "<script>window.alert('Foto berhasil diupload')
	window.location='index.php'</script>";

//upload foto
if (strlen($a)>0) {
		if (is_uploaded_file($_FILES['photo']['tmp_name'])) {
			move_uploaded_file($_FILES['photo']['tmp_name'], "gambar/".$a);
		}
	}
?>