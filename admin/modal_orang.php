<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="../assets/css/select2.min.css"/>
</head>
<body>
<?php
include("connect.php");


    
                         
?>

            <!-- Modal -->
              <form method="post" action="modal_orang_aksi.php">
              <table>
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
                    <select id="suku" class="form-control" name="suku">
                    
                      <option value="">Please Select</option>
                      <?php
                              $query = "SELECT * FROM suku";
                              $sql=pg_query($query) or die (pg_error());
                              while ($row = pg_fetch_assoc($sql)) {
                          ?>
                          <option value="<?=$row['id_suku']?>" required><?=$row['nama_suku']?></option>
                          <?php }
                            ?>
        
                  </select>
                 </div>
                 <br>
                 <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" autocomplete="off">
                </div>  
                <div class="form-group">
                    <label for="no_hp">Mobile phone number</label>
                    <input type="text" class="form-control" id="no_hp" name="no_hp" autocomplete="off">
                </div>  
                    
                 </div> 
                <table> 
                <div class="form-group">
                    <br>
                             
            </form>
            
      
            <button type="submit" class="btn btn-primary" value="simpan" >SAVE</button>
                
            <script src="../assets/js/select2.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#suku").select2({
                    placeholder: "Please Select"
                });
                
            });
        </script>  
</body>
</html>
