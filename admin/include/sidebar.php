

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
           <li <?php if($page == "Home") echo "class='active'";?>><a href="../index.php"><i class="fa fa-dashboard"></i> User Page</a></li>
           <li <?php if($page == "Fire Station") echo "class='active'";?>><a href="fire_station_list.php"><i class="fa fa-file"></i> Fire Station</a></li>
           <li <?php if($page == "Fire Incident") echo "class='active'";?>><a href="fire_incident.php"><i class="fa fa-file"></i> Fire Incident</a></li>
           
          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">                     
            <li class="dropdown user-dropdown">
              <a href="logout.php" class="" ><i class="fa fa-sign-out"></i> Log Out</a>
              
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>


      

