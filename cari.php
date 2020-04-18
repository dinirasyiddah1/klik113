<?php 
session_start();
include 'admin/connect.php';
?>
<!DOCTYPE html>
<html>
<head>
 <?php include('include/head.php'); ?>
</head>
<body>
 <?php include('include/header.php'); ?>
 <?php include('include/sidebar.php'); ?>
 <div class="main-container">
 <!-- Area google maps-->
      <div class="card mb-3">
        <div class="card-header">
          <!--bagian tombol aksi -->
           <header class="panel-heading">
                    <label style="color: black">Google Map with Location List</label>
                    <a type="button" class="btn btn-default" role="button" data-toggle="collapse" onclick="aktifkanGeolocation()" title="Current Position"   ><i class="fa fa-map-marker" style="color:black;"></i></a>
                    <a type="button" class="btn btn-default" role="button" data-toggle="collapse" onclick="manualLocation()" title=" Manual Position"><i class="fa fa-location-arrow" style="color:black;"></i></a>
                    <a type="button" class="btn btn-default" role="button" data-toggle="collapse" href="#terdekat" title="Nearby" aria-controls="terdekat"><i class="fa fa-road" style="color:black;"></i></a>
                    <a type="button" class="btn btn-default" role="button" data-toggle="collapse" onclick="tampilsemua();result()" title="All Panti Asuhan" aria-controls="terdekat"><i class="fa fa-map-pin" style="color:black;"></i></a>
                    <label id="tombol">
                    <div class="collapse" id="terdekat">
                    <div class="well">
                    <label><b>Radius&nbsp</b></label><label style="color:black" id="km"><b>0</b></label>&nbsp<label><b>m</b></label><br>
                    <input  type="range" onclick="cek();aktifkanRadius();resultt()" id="inputradiusmes" name="inputradiusmes" data-highlight="true" min="1" max="20" value="1" >
                    </div>
                    </div>   
                    <label id="tombol">
                       <a type="button" onclick="legenda()" id="showlegenda" class="btn btn-default" data-toggle="tooltip" title="Legenda" style="margin-right: 7px;"><i class="fa fa-eye"></i>
                       </a>     
                    </label>
          </header>
        </div>
      </div>
<div class="panel panel-info">
  <div class="row">
    <div class="col-md-7">
      <section class="panel primary"> 
        <div class="panel-body" >
        <div style="width:45%; float:left; border-style: ridge;">
        <div id="map" style="width:220%; height: 400px;" ></div>
        </div>
        </div>
        </section>
        </div>
      <section class="panel">
        <div class="panel-body">
        <a class="btn btn-info btn-lg btn-block">Result</a>
        <div class="box-body" style="max-height:400px;overflow:auto;"> 
        <div class="form-group" id="hasilcari1" style="display:none;">
        <table class="table table-bordered" id='hasilcari'>
        </table>                    
        </div>
        </div>
      </section>
    </div>
  </div>
</div>
   
</div>
</div>
<script src="vendors/scripts/script.js"></script>
<script src="script.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBNnzxae2AewMUN0Tt_fC3gN38goeLVdVE&callback=initMap" type="text/javascript"></script>
 <script type="text/javascript">
  tampil_hari_ini();
 </script>
 <style type="text/css">
  #legend
  {
    background: grey;
    padding: 10px;
    padding-right: 120px;
    margin: 5px;
    font-size: 12px;
    font-family: Arial, sans-serif;
   
  }
  .color
  {
    border: 0.2px solid;
    border-color: white;
    height: 7px;
    width: 10px;
    margin-right: 1px;
    float-left;
  }
  .color1
  {
    height: 18px;
    width: 15px;
    margin-right: 5px;
    float-left;
  }
 .a
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #778899;
  }
  .b
  {
    padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #ffd777;
  }
  .c
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #ec87ec;
  }
  .d
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #000080;
  }
  .e
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #4C4CE0;
  }
  .f
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #CD853F;
  }
  .g
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #EF3551;
  }
   .h
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #00FFFF;
  }
   .i
  {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #800000;
  }
  .j
    {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #32CD32;
  }
  .k
    {
   padding-left: 30px;
    background-size: 40%;
    background-position-y: 20%;
    background: #9932CC;
  }
</style>
</body>
</html>