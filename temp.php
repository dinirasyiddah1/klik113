<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
<?php
  include ('admin/connect.php');
  $query = pg_query("SELECT * FROM gambar_kejadian");
  $data=pg_fetch_assoc($query);
  echo $data['id_kejadian'];
  echo "<br>";
  echo $data['url_photo'];
  echo "<br>";
  echo "<img src=".$data['url_photo']." style='width:450px;height:350px;'/>"
?>

</body>
</html>