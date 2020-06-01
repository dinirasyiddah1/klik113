<?php 
session_start();
include 'connect.php';
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
  $sql = pg_query("SELECT * FROM kejadian INNER JOIN regu_piket ON (kejadian.id_regu = regu_piket.id_regu) 
            where id_kejadian='$id'")or die(pg_error());
	
	//tampilakan data
	$hasil = pg_fetch_assoc($sql);
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
            <li <?php if($page == "Home") echo "class='active'";?>><a href="fire_incident.php"><i class="fa fa-dashboard"></i> Dashboard</a></li>
           
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
          
              <div class="col-sm-7 " id="hide2">
              <div class="panel-body">
                  <section class="panel panel-info">
                        <div class="panel-body" >
                            <table cellpadding="10">
									<tbody  style='vertical-align:top;'>
                  <tr>
            <th>1.&nbsp;&nbsp;</th>
            <th>Waktu Kejadian &nbsp<th>
            <td></td>
        </tr>
                  <tr>
            <th></th>
            <th >Hari/Tanggal<th>
            <td>:</td>
            <?php
            include ("format_hari_tanggal.php");
            error_reporting(0);
            $query=pg_query("SELECT tanggal FROM kejadian WHERE id_kejadian='$id'");
            $data=pg_fetch_array($query);
            $date = $data['tanggal'];
            // $tgl = date_create($date);
            // $format_tgl = date_format($tgl,'l, d M Y');
            echo "<td>".format_hari_tanggal($date)."</td>";
            ?>
        </tr>
        <tr>
        <th></th>
            <th>Jam<th>
            <td>:</td>
            <?php
            $query=pg_query("SELECT jam FROM kejadian where id_kejadian='$id'");
            $data=pg_fetch_array($query);
            $time=$data['jam'];
            $jam=date_create($time);
            $format_jam=date_format($jam,'H:i')
            ?>
            <td><?=$format_jam;?> WIB</td>
        </tr>
        <tr>
        <th></th>
            <th>Regu Piket<th>
            <td>:</td>
            <td><?=$hasil['nama_regu'];?></td>
        </tr>
        <tr>
        <th>2.</th>
            <th>Jenis Kejadian<th>
            <td>:</td>
            <?php
            
              $query1 = pg_query("SELECT jenis_kejadian FROM kejadian
                      INNER JOIN detail_objek_terbakar ON kejadian.id_kejadian = detail_objek_terbakar.id_kejadian
                      INNER JOIN objek_terbakar ON objek_terbakar.id_objek = detail_objek_terbakar.id_objek
                      WHERE kejadian.id_kejadian='$id'
                       ");
              $hasil1 = pg_fetch_array($query1);
            ?>
            <td><?=$hasil1['jenis_kejadian'];?></td>
        </tr>
        <tr>
        <th>3.</th>
            <th>Penyebab Kejadian<th>
            <td>:</td>
            <?php
              $query2 = pg_query("SELECT penyebab FROM kejadian
                          INNER JOIN detail_penyebab ON kejadian.id_kejadian = detail_penyebab.id_kejadian
                          WHERE kejadian.id_kejadian='$id'
                          ");
              $hasil2 = pg_fetch_array($query2);
            ?>
            <td><?=$hasil2['penyebab'];?></td>
        </tr>
        <tr>
        <th>4.</th>
            <th>Lokasi Kejadian<th>
            <td>:</td>
            <td><?=$hasil['lokasi'];?></td>            
        </tr>
        <tr>
        <th></th>
            <th>&nbsp;&nbsp;&nbsp;RT/RW &nbsp;&nbsp;&nbsp;&nbsp; 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp; <?=$hasil['rt'];?>/<?=$hasil['rw'];?></th>
            
        </tr>
        <tr>
        <th></th>
            <th>&nbsp;&nbsp;&nbsp;Kelurahan &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;<?=$hasil['kelurahan'];?></th>
            
        </tr>
        <tr>
        <th></th>
        <?php
                $query = pg_query("SELECT C.nama_kecamatan
                FROM kejadian AS K, kecamatan AS C
                WHERE ST_CONTAINS(C.geom, K.geom) AND K.id_kejadian='$id'");
                $data = pg_fetch_array($query);
            ?>
            <th>&nbsp;&nbsp;&nbsp;Kecamatan &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;<?=$data['nama_kecamatan'];?></th>
            
        </tr>
        <tr>
        <th>5.</th>
            <th>Nama Pelapor<th>
            <td>:</td>
            <?php
              $id=$hasil['id_kejadian'];
              $data_pelapor = pg_query("SELECT * FROM kejadian 
                                    INNER JOIN detail_pelapor ON kejadian.id_kejadian=detail_pelapor.id_kejadian
                                    INNER JOIN orang ON detail_pelapor.id_orang = orang.id_orang
                                    where kejadian.id_kejadian = '$id'
                                    ");
              $hasil_pelapor = pg_fetch_array($data_pelapor);
              
              ?>
              <td><?=$hasil_pelapor['nama_orang'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>No. Telepon/HP.<th>
            <td>:</td>
            <td><?=$hasil_pelapor['no_hp'];?></td>
        </tr>
        <tr>
        <th>6.</th>
            <th>Nama Pemilik/Data Korban *<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
        <th></th>
            <th>a. Nama/umur<th>
            <td>:</td>
            <?php
                    $id=$hasil['id_kejadian'];
                    $data_pemilik = pg_query("SELECT * FROM kejadian 
                        INNER JOIN detail_objek_terbakar ON kejadian.id_kejadian=detail_objek_terbakar.id_kejadian
                        INNER JOIN orang ON detail_objek_terbakar.id_orang = orang.id_orang
                        INNER JOIN suku on suku.id_suku = orang.id_suku
                        where kejadian.id_kejadian = '$id'
                        ");
                    $hasil_pemilik = pg_fetch_array($data_pemilik);
                    ?>
                    <td><?=$hasil_pemilik['nama_orang'];?>/<?=$hasil_pemilik['umur_orang'];?> Th</td>
                    
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Pekerjaan<th>
            <td>:</td>
            <td><?=$hasil_pemilik['pekerjaan_orang'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Suku<th>
            <td>:</td>
            <td><?=$hasil_pemilik['nama_suku'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Alamat<th>
            <td>:</td>
            <td><?=$hasil_pemilik['alamat_orang'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>b. Nama/umur(SAKSI)<th>
            <td>:</td>
            <?php
                       
                       $query = pg_query("SELECT * from kejadian
                                     INNER JOIN detail_saksi ON detail_saksi.id_kejadian=kejadian.id_kejadian
                                     INNER JOIN orang ON orang.id_orang = detail_saksi.id_orang
                                     INNER JOIN suku on suku.id_suku = orang.id_suku
                                     WHERE kejadian.id_kejadian = '$id'");
                       $saksi = pg_fetch_array($query);
                     ?>
            <td><?=$saksi['nama_orang'];?>/<?=$saksi['umur_orang'];?> Th</td>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Pekerjaan<th>
            <td>:</td>
            <td><?=$saksi['pekerjaan_orang'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Suku<th>
            <td>:</td>
            <td><?=$saksi['nama_suku'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Alamat<th>
            <td>:</td>
            <td><?=$saksi['alamat_orang'];?></td>
        </tr>
        <tr>
        <th>7.</th>
            <th style="width:15%;">Pengerahan Personil/Kendaraan<th>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
        <th></th>
            <th width="40%">a. Jumlah Personil yang turun<th>
            <td>:</td>
            <?php
                $query_inst=pg_query("SELECT * FROM kejadian
                            INNER JOIN detail_instansi ON kejadian.id_kejadian=detail_instansi.id_kejadian
                            INNER JOIN instansi ON detail_instansi.id_instansi=instansi.id_instansi
                            WHERE kejadian.id_kejadian = '$id'");
                while($data=pg_fetch_array($query_inst)){
                    $jumlah[]=$data['jumlah_personil'];
                };
                $jumlah_personil = array_sum($jumlah);
                
                if($jumlah_personil==0){
                    echo "<td> _ orang </td>";
                }else{
                    echo "<td>".$jumlah_personil." orang</td>";
                }
            ?>
            
            <td><?=$instansi['jumlah_personil'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>b. Instansi yang terlibat<th>
            <td>:</td>
            <td>
            <?php
                $query=pg_query("SELECT * FROM kejadian
                INNER JOIN detail_instansi ON kejadian.id_kejadian=detail_instansi.id_kejadian
                INNER JOIN instansi ON detail_instansi.id_instansi=instansi.id_instansi
                WHERE kejadian.id_kejadian = '$id'");
                
                while ($data=pg_fetch_array($query)){
                    echo $data['nama_instansi'].",";
                };
            ?>
            </td>
        </tr>
        <tr>
        <th></th>
            <th>c. Kendaraan/Peralatan<th>
            <td>:</td>
            <td>
            <?php
                $query=pg_query("SELECT * FROM kejadian
                INNER JOIN detail_kendaraan ON kejadian.id_kejadian=detail_kendaraan.id_kejadian
                INNER JOIN kendaraan ON detail_kendaraan.nomor_plat=kendaraan.nomor_plat
                WHERE kejadian.id_kejadian = '$id'");
                $unit = 0;
                while ($data=pg_fetch_array($query)){
                    echo $data['nama_kendaraan'].", ";
                    $unit++;
                };
                echo "(" .$unit. " unit)";
            ?></td>
        </tr>
        <tr>
        <th>8.</th>
            <th>Kronologis Kejadian<th>
            <td>:</td>
            <td><?=$hasil['kronologis'];?></td>
        </tr>
        <tr>
        <th>9.</th>
            <th>Akibat Kejadian<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
        <th></th>
            <th>a. Korban Manusia<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Nama/Umur<th>
            <td>:</td>
            <?php
                 $query = "SELECT * FROM orang
                             INNER JOIN detail_korban ON orang.id_orang = detail_korban.id_korban
                             INNER JOIN kejadian ON kejadian.id_kejadian = detail_korban.id_kejadian
                             INNER JOIN suku ON suku.id_suku = orang.id_suku
                             where kejadian.id_kejadian = '$id'";
                 $sql=pg_query($query) or die (pg_error());
                 $korban = pg_fetch_assoc($sql);

                 if($korban['id_korban']==[]){
                     echo "<td>nihil</td>";
                 }else{
                     echo "<td>".$korban['nama_orang']." / ".$korban['umur_orang']. "Th</td>";
                 };

            ?>
            
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Pekerjaan<th>
            <td>:</td>
            <?php
            if($korban['id_korban']==[]){
                echo "<td>nihil</td>";
            }else{
                echo "<td>".$korban['pekerjaan_orang']."</td>";
            };
            ?>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Suku<th>
            <td>:</td>
            <?php
            if($korban['id_korban']==[]){
                echo "<td>nihil</td>";
            }else{
                echo "<td>".$korban['nama_suku']."</td>";
            };
            ?>
        </tr>
        <tr>
        <th></th>
            <th>&nbsp&nbsp&nbsp Alamat<th>
            <td>:</td>
            <?php
            if($korban['id_korban']==[]){
                echo "<td>nihil</td>";
            }else{
                echo "<td>".$korban['alamat_orang']."</td>";
            };
            ?>
        </tr>
        <tr>
        <th></th>
            <th>b. Kerusakan<th>
            <td>:</td>
            <td><?=$hasil['kerusakan'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>c. Luas Areal<th>
            <td>:</td>
            <td><?=$hasil['luas_area'];?></td>
        </tr>
        <tr>
        <th></th>
            <th>c. Taksiran Kerugian<th>
            <td>:</td>
            <td><?=$hasil['taksiran_kerugian'];?></td>
        </tr>
        </tbody>
									</table>
                        </div>
                  </section>
                  </div>
              </div>
              <div class="col-sm-5">
              <div class="panel-body">
              
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
    <img src="../file/fireincident/<?=$id;?>/<?=$data1['nama_photo'];?>" width="100%" height="400">
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

    </div><!-- /#wrapper -->

    

    
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1TwYksj1uQg1V_5yPUZqwqYYtUIvidrY&callback=initMap">
    </script>
    <script src="assets/js/IMG-BOX-master/img_box.js"></script>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="admin/script.js" type="text/javascript"></script>
    
  </body>
</html>