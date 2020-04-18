<?php 

session_start();
if(isset($_SESSION['admin'])){
	echo"<script language='JavaScript'>document.location='admin/'</script>";
    exit();
}

?>


<!DOCTYPE html>
<html>
<head>
	<?php include('include/head.php'); ?>
</head>
<body>
<div id="login-page">
	  	<div style="width: 400px" class="container">
	  	
		      <form class="form-login" action="login_aksi.php" method="post">
		        <h2 class="form-login-heading">LOG IN NOW</h2>
		        <div class="login-wrap" >
		        <!--   <form > -->
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="Username" name="username" autofocus required/>
        <!-- <span class="glyphicon glyphicon-user form-control-feedback"></span> -->
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password" name="password" required/>
        <!-- <span class="glyphicon glyphicon-lock form-control-feedback"></span> -->
      </div>
      <div class="row">
        <div class="col-xs-8">
          
        </div>
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat" name="submit">Log In</button>
        </div>
      </div>
      <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
</body>
</html>