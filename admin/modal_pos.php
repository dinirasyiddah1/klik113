<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>.carousel-inner > .item > img,.carousel-inner > .item > a > img { width: 80%; margin: auto;}</style>
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
                  
                <table> 


<div id="WJSlider" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
    <?php
            $sql2 = pg_query("SELECT * FROM pos_damkar
                        INNER JOIN gambar_pos ON gambar_pos.id_pos_damkar = pos_damkar.id_pos_damkar 
                        where pos_damkar.id_pos_damkar='$id'") or die(pg_error());
            $i=0;
            while($row2 = pg_fetch_array($sql2)){
             echo "<li data-target='#WJSlider' data-slide-to='".$i."'></li>";
             $i++;
        ?>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        
      <div class="item active">
      &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../file/firestation/<?php echo $row2['nama_photo']; ?>" style="width:450px;height:350px;">
        <div class="carousel-caption">
          <h3><?php echo $row2['alamat']; ?></h3>
          <p>Ini adalah deskripsi singkat dari judul gambar yang pertama.</p>
        </div>
      </div> 
      <?php    
            }
            ?> 
    </div>
<!-- Left and right controls -->
<a class="left carousel-control" href="#WJSlider" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Kembali</span>
    </a>
    <a class="right carousel-control" href="#WJSlider" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Lanjut</span>
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
