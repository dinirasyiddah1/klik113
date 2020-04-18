<?php
include("connect.php");
if($_POST['getDetail']) {
    $id = $_POST['getDetail'];
    $sql = pg_query("SELECT * from pos_damkar where id_pos_damkar='$id'")or die(pg_error());
    $sql2 = pg_query("SELECT * FROM gambar_pos where id_pos_damkar='$id'") or die(pg_error());
    $row = pg_fetch_assoc($sql);
    $row2 = pg_fetch_assoc($sql2);
    
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
                <div class="form-group">
                    <br>
                        &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../file/firestation/<?php echo $row2['nama_photo']; ?>" style="width:450px;height:350px;">
                             
            </form>
            <div class="modal-footer">
      
            <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
            </div> 
                  
        <?php }
?>