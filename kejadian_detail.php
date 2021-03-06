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
    <style type="text/css">
        .container {
            border: 1px solid #000;
            width: 90%;
        }
        .margin {
            margin: 10px 0px 10px 0px;
        }
    </style>
  </head>

  <body>
  <?php   
	//ambil get
	$id = $_GET['id_kejadian'];
	//bikin string 
  $sql = pg_query("select * from kejadian where id_kejadian='$id'");
  $sql1 = pg_query("select * from gambar_kejadian where id_kejadian='$id'");
	
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
          <a class="navbar-brand" href="index.php">KLIK113 - GIS Fire Data Archiving In Padang City</a>
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



      
    <div id="wrapper">

      <section class="wrapper site-min-height">
          <div class="row mt">
          <div class="panel-body">
          
                      </div>
              <div class="col-sm-6" id="hide2">
                  <section class="panel">
                        <div class="panel-body">
                            <table>
									<tbody  style='vertical-align:top;'>
										<tr><td width="220px"><b>&nbsp; Location</b></td><td> :&nbsp; </td><td style='text-transform:capitalize;'><?php echo $data['lokasi'] ?></td></tr>
										<tr><td><b>&nbsp; Time</b></td><td>:</td><td><?php  echo $data['jam'] ?> </td></tr>
										<tr><td><b>&nbsp; Date</b> </td><td>: </td><td><?php echo $data['tanggal'] ?> </td></tr>
                    <tr><td><b>&nbsp; Chronology</b> </td><td>: </td><td><?php echo $data['kronologis'] ?> </td></tr>	
									</tbody>
									</table>
                        </div>
                  </section>
              </div>
              <br>
              <div class="col-md-6">
			  <div class="bg-white pd-20 box-shadow border-radius-5 height-100-p">
						<div class="to-do-list mx-h-450 customscroll">
							<ul>
								<div class="col-sm-12" id="hide3"> <!-- menampilkan foto-->
					   	 			<section class="panel">
					                    <div class="panel-body">
					                       <!--  <a class="btn btn-primary btn-lg btn-block">Tambah Panti Asuhan</a> -->
					                        <div class="box-body">
					                        	<!-- menampilkan foto-->
<div id="myCarousel" class="carousel slide" data-ride="carousel">

<!-- Indicators -->
<ul class="carousel-indicators">
<?php
$i = 0;
$sql1 = pg_query("SELECT * from gambar_kejadian where id_kejadian='$id'");
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
$sql1 = pg_query("SELECT * from gambar_kejadian where id_kejadian='$id'");
while($data1 = pg_fetch_array($sql1)){
    $actives = '';
    if($i == 0){
        $actives = 'active';
    }
?>
    <div class="item <?=$actives;?>">
        <img src="file/fireincident/<?=$id;?>/<?=$data1['nama_photo'];?>" width="100%" height="400">
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
					                    </div>
					                </section>
					            </div>
					        </ul>
					    </div>
					</div>
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
    <script src="assets/js/IMG-BOX-master/img_box.js"></script>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="admin/script.js" type="text/javascript"></script>
    
  </body>
</html>