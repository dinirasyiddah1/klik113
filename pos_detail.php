<?php 
session_start();
include 'admin/connect.php';
	$page = "Home";
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <?php
      include ('include/head.php');
    ?>
  </head>

  <body>
  <?php 
	//ambil get
	$id = $_GET['id_pos_damkar'];
	//bikin string 
	$sql = pg_query("select * from pos_damkar where id_pos_damkar='$id'");
	
	//tampilakan data
  $data = pg_fetch_assoc($sql);
  
  ?>


  <!-- Sidebar -->
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.php">KLIK113 - WEBGIS Kebakaran Kota Padang</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav ">
            <li <?php if($page == "Home") echo "class='active'";?>><a href="index.php"><i class="fa fa-dashboard"></i> Dashboard</a></li>
           
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">                     
            <li class="dropdown user-dropdown">
              <a href="login.php" class="" ><i class="fa fa-sign-in"></i> Log In</a>
              
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>



 <center>     
      <div class="container">
  <h2><?php echo $data['nama_pos'] ?></h2>
  </center>
  <hr/>
  <div id="wrapper">

<section class="wrapper site-min-height">
    <div class="row mt">
    <div class="panel-body">
    
                </div>
      <div class="card" style="width:185%"> 
        <div class="col-sm-3" id="hide2">
          <!-- menampilkan foto-->
          <div id="myCarousel" class="carousel slide" data-ride="carousel">

<!-- Indicators -->
<ul class="carousel-indicators">
<?php
$i = 0;
$sql1 = pg_query("SELECT * from gambar_pos where id_pos_damkar='$id'");
while($data1 = pg_fetch_array($sql1)){
    $actives = '';
    if($i == 0){
        $actives = 'active';
    }
?>
  <li data-target="#myCarousel" data-slide-to="<?=$i;?>" class="<?=$actives;?>"></li>
  <?php $i++; }?>
</ul>

<!-- The slideshow -->
<div class="carousel-inner">
<?php
$i = 0;
$sql1 = pg_query("SELECT * from gambar_pos where id_pos_damkar='$id'");
while($data1 = pg_fetch_array($sql1)){
    $actives = '';
    if($i == 0){
        $actives = 'active';
    }
?>
  <div class="item <?=$actives;?>">
    <img src="file/firestation/<?=$id;?>/<?=$data1['nama_photo'];?>" width="100%" height="400">
  </div>
  <?php $i++; }?>
</div>

<!-- Left and right controls -->
<a class="left carousel-control" href="#myCarousel" data-slide="prev">
<span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>

</div>
        </div>
        <div class="col-sm-9">
          <div class="card-body">
              <h4 class="card-title"><b>Address</b></h4>
              <p class="card-text"><?php  echo $data['alamat'] ?></p>
              
          </div>
  <br>
        </div>
   </div>
</div>
              <br>
              <div class="col-md-6">
			  
        </div>
      </section>

    </div><!-- /#wrapper -->
    

    <!-- JavaScript -->
    <?php
      include ("admin/connect.php");
    ?>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&callback=initMap">
    </script>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="admin/script.js" type="text/javascript"></script>
    
  </body>
</html>