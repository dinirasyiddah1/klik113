<?php
include("connect.php");


    
                         
?>

            <!-- Modal -->
              <form method="post" action="modal_owner_aksi.php">
              <table>
               
                <div class="form-group">
                    <label for="owner">Owner ID</label>
                    <input type="text" class="form-control" id="owner" name="owner" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="age">Age</label>
                    <input type="text" class="form-control" id="age" name="age" autocomplete="off">
                </div>
                <div class="form-group">
                    <label for="job">Job</label>
                    <input type="text" class="form-control" id="job" name="job" autocomplete="off">
                </div>
                <div class="dropdown">
                    <label for="id_suku">Tribe</label>
                    <select name="suku">
                      <option>-----</option>
                      <?php
                              $query = "SELECT * FROM suku";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option name="<?=$row['id_suku']?>" id="<?=$row['id_suku']?>" value="<?=$row['id_suku']?>" required><?=$row['nama_suku']?></option>
                          <?php }
                            ?>
        
                        <option>-- Add new --</option>
                  </select>
                 </div>
                 <br>
                 <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" autocomplete="off">
                </div>  
                    
                 </div> 
                <table> 
                <div class="form-group">
                    <br>
                             
            </form>
            <div class="modal-footer">
      
            <button type="submit" class="btn btn-primary" value="simpan" >SAVE</button>
                
            </div> 
                  
       