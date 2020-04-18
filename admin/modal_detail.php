<?php 
include('connect.php');

if($_POST['getDetail']){
  $id =$_POST['getDetail'];
  $sql=pg_query("SELECT * from pos_damkar where id_pos_damkar='$id'")or die(pg_error());

  //tampilakan data
  $data = pg_fetch_assoc($sql);



?>


<!-- Modal daftar -->
<div id="modaldetail" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Detail Fire Station</h4>
      </div>
      <div class="modal-body">
        <form>
     <div class="form-group">
     <tr><td width="220px"><b>&nbsp; Fire Station ID</b></td><td> :&nbsp; </td><td style='text-transform:capitalize;' id="id_pos_damkar"><?php echo $data['id_pos_damkar']; ?></td></tr>

     
    </div>
    <div class="form-group">
    <tr><td width="220px"><b>&nbsp; Fire Station Name</b></td><td> :&nbsp; </td><td style='text-transform:capitalize;' id="nama_pos"><?php echo $data['nama_pos']; ?></td></tr>
										
    </div>
    <div class="form-group">
    <tr><td><b>&nbsp; Address</b></td><td>:</td><td id="alamat"><?php echo $data['alamat']; ?> </td></tr>
										
    </div>
    <div class="form-group">
    <tr><td><b>&nbsp; &nbsp;<img src="../image/fire station/<?php echo $data['image']; ?>" style="width:450px;height:350px;"></td></tr>
</div>
  </form>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<?php }
?>
<!-- end modal detail -->
