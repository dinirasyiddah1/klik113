<?php
include("admin/connect.php");
if($_POST['getDetail']) {
    $id = $_POST['getDetail'];
    $sql = pg_query("SELECT * from pos_damkar where id_pos_damkar='$id'")or die(pg_error());
    $row = pg_fetch_assoc($sql);
    
?>

            <!-- Modal -->
              <form method="post" action="save.php">
                  <div class="form-group row">
                            <label class="col-sm-4 col-form-label">id</label>
                            <div class="col-sm-8">
                            <input type="text" class="form-control" value="<?=$row['id_pos_damkar'];?>" name="id_pos_damkar">
                            </div>
                            </div>
                  <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Nama Pos</label>
                            <div class="col-sm-8">
                            <input type="text" class="form-control" value="<?php echo $row['nama_pos'];?>" name="nama_pos">
                            </div>
                            </div>
                  <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Alamat</label>
                            <div class="col-sm-8">
                            <input type="text" class="form-control" value="<?php echo $row['alamat'];?>" name="alamat">
                            </div>
                            </div>
                  
                  <div class="modal-footer">
                  <button class="btn btn-danger pull-left" data-dismiss="modal">Cancel</a></button>
                  <button type="submit" class="btn btn-primary pull-right">Save</a></button>
                  </div>            
            </form>
        <?php }
?>