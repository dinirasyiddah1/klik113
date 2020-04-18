<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Water Sources</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="css/sb-admin.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    
  </head>

  <body>

    <div id="wrapper">

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
          <a class="navbar-brand" href="index.php">SB Admin</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav side-nav">
            <li><a href="index.php"><i class="fa fa-dashboard"></i> Dashboard</a></li>
           
            <li ><a href="fire_station_list.php"><i class="fa fa-file"></i> Fire Station</a></li>
            <li><a href="fire_incident.php"><i class="fa fa-file"></i> Fire Incident</a></li>
            <li class="active"><a href="water_sources.php"><i class="fa fa-file"></i> Water Sources</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Dropdown Item</a></li>
                <li><a href="#">Another Item</a></li>
                <li><a href="#">Third Item</a></li>
                <li><a href="#">Last Item</a></li>
              </ul>
            </li>
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">
            <li class="dropdown messages-dropdown">
              
              <ul class="dropdown-menu">
               
                
                <li class="divider"></li>
                <li><a href="#">View Inbox <span class="badge">7</span></a></li>
              </ul>
            </li>
           
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                <li><a href="#"><i class="fa fa-envelope"></i> Inbox <span class="badge">7</span></a></li>
                <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                <li class="divider"></li>
                <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>


      <div class="panel-body">
        <a href="input_water.php" style="font-size:20px">+ Water Source</a>
<table class="table table-striped table-hover tablesorter">
  <thead>
    <tr>
      <th>No <i class="fa fa-sort"></th>
      <th>Water Source Name <i class="fa fa-sort"></th>
      <th>Address <i class="fa fa-sort"></th>
      <th>Option <i class="fa fa-sort"></th>
    </tr>
  </thead>

  <?php
include "connect.php";


 $data=pg_query("SELECT * FROM public.sumber_air order by id_sumber_air");
 if ($data === FALSE) {
 die(pg_error());

 }
 
 while($hasil=pg_fetch_array($data)){ 
 
 ?>

  <tbody>
    <tr>
      <th scope="row"><?=$hasil['id_pos_damkar'];?></th>
      <td><?=$hasil["nama_pos"];?></td>
      <td><?=$hasil["alamat"];?></td>
      <td>
        <a href="edit_pos.php?id_pos_damkar=<?=$hasil['id_pos_damkar']; ?>">Edit</a>
        <a href="hapus.php">Hapus</a>
      </td>
    </tr>
    
  </tbody>
  <?php
  $no++;
  }
 ?>
</table>
      </div>

    </div>
    <!-- JavaScript -->
    <?php
      include ("connect.php");
    ?>
    
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&libraries=drawing&callback=initMap">
    </script>
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="script.js" type="text/javascript"></script>

  </body>
</html>