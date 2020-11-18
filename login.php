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
  <style>
#card {
        background: #fbfbfb;
        border-radius: 8px;
        box-shadow: 1px 2px 8px rgba(0, 0, 0, 0.65);
        height: 350px;
        margin: 6rem auto 8.1rem auto;
        width: 329px;
}
input[type=text],  
        input[type=password] {  
            width: 100%;  
            padding: 12px 40px;  
            margin: 8px 0;  
            display: inline-block;  
            border: 1px solid #ccc;  
            box-sizing: border-box;  
        }  


.container {  
            padding: 16px;  
        }  
      
        .fontuser { 
            position: relative; 
        } 
          
        .fontuser i{ 
            position: absolute; 
            left: 15px; 
            top: 20px; 
            color: lightblue; 
        } 
          
        .fontpassword { 
            position: relative; 
        } 

        .fontpassword i{ 
            position: absolute; 
            left: 15px; 
            top: 20px; 
            color: lightblue; 
        }
  </style>
</head>
<body>
<div id="card"> 
	  	<br>
	  	<center><h2 class="form-login-heading">Admin</h2></center><br>
		      <form autocomplete="off" class="form-login" action="login_aksi.php" method="post">
		        
          <div style="width: 300px" class="container">
          <div class="form-group fontuser">
              <input type="text" class="form-control" placeholder="Username" onfocus="this.value=''" name="username" required/>
              <i class="fa fa-user fa-lg"></i> 
          </div>
          <div class="form-group fontpassword">
              <input type="password" class="form-control" placeholder="Password" onfocus="this.value=''" name="password" required/>
              <i class="fa fa-key fa-lg"></i> 
          </div>
        <div class="row">
            
          <br>
            <center><button style="width:270px" type="submit" class="btn btn-primary btn-block btn-flat" name="submit">Log In</button></center>
          
        </div>
        </div>
            </div>
            </form>
      <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
</body>
</html>