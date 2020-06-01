<?php 
include 'connect.php';
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
<div id="demo" class="carousel slide" data-ride="carousel">

<!-- Indicators -->
<ul class="carousel-indicators">
<?php
$i = 0;
$sql1 = pg_query("SELECT * from gambar_kejadian where id_kejadian='FI0001'");
while($data1 = pg_fetch_array($sql1)){
    $actives = '';
    if($i == 0){
        $actives = 'active';
    }
?>
  <li data-target="#demo" data-slide-to="<?=$i;?>" class="<?=$actives;?>"></li>
  <?php $i++; }?>
</ul>

<!-- The slideshow -->
<div class="carousel-inner">
<?php
$i = 0;
$sql1 = pg_query("SELECT * from gambar_kejadian where id_kejadian='FI0001'");
while($data1 = pg_fetch_array($sql1)){
    $actives = '';
    if($i == 0){
        $actives = 'active';
    }
?>
  <div class="carousel-item <?=$actives;?>">
    <img src="../file/fireincident/FI0001/<?=$data1['nama_photo'];?>" width="100%"  height="200px" >
  </div>
  <?php $i++; }?>
</div>

<!-- Left and right controls -->
<a class="carousel-control-prev" href="#demo" data-slide="prev">
  <span class="carousel-control-prev-icon"></span>
</a>
<a class="carousel-control-next" href="#demo" data-slide="next">
  <span class="carousel-control-next-icon"></span>
</a>

</div>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 
</body>
</html>