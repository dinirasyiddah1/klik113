<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    </head>
<body>
<?php
include("connect.php");
if($_POST['getDetail']) {
    $id = $_POST['getDetail'];
    $sql = pg_query("SELECT * from pos_damkar where id_pos_damkar='$id'")or die(pg_error());
    $row = pg_fetch_assoc($sql);
    
?>

            <!-- Modal -->
              <form method="post" action="save.php">
              <table>
                  
                <div class="form-group">
                            <tr>
                            <td width="10px"><b>&nbsp; Fire Station ID</b></td>
                            <td> :&nbsp; </td>
                            <td style='text-transform:capitalize;' id="<?=$row['id_pos_damkar'];?>"><?php echo $row['id_pos_damkar']; ?></td>
                            </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td width="220px"><b>&nbsp; Fire Station Name</b></td>
                        <td> :&nbsp; </td>
                        <td style='text-transform:capitalize;' id="nama_pos"><?php echo $row['nama_pos']; ?></td>
                    </tr>
                                                        
                    </div>
                    <div class="form-group">
                    <tr>
                        <td><b>&nbsp; Address</b></td><td>:</td>
                        <td id="alamat"><?php echo $row['alamat']; ?> </td>
                    </tr>
                                                        
                    </div>
                    
                </div>
                  
                </table> 


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
    <img src="../file/firestation/<?=$id;?>/<?=$data1['nama_photo'];?>" width="100%" >
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
            </form>
            <div class="modal-footer">
      
            <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div> 
                  
        <?php }
?>
</body>
</html>
