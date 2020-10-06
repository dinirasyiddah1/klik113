<?php
include 'connect.php';
include ('include/head.php');




?>

<div class="table-responsive">
<table class="table table-striped table-hover tablesorter">
  <thead>
    <tr>
      <th style='text-align:center'>Name </th>
      <th style='text-align:center'>Age </th>
      <th style='text-align:center'>Job</th>
      <th style='text-align:center'>Tribe  </th>
      <th style='text-align:center'>Address</th>
      <th style='text-align:center'>Phone</th>
    </tr>
  </thead>
  <tbody>
  
  <?php
  
  
  
  $query = pg_query("SELECT * FROM orang INNER JOIN suku ON 
                    (suku.id_suku = orang.id_suku) ORDER BY id_orang DESC LIMIT 1");
  
          while ($row=pg_fetch_array($query)){
?>

<tr>
		<td><?php echo $row['nama_orang'] ?></td>
		<td><?php echo $row['umur_orang'] ?></td>
		<td><?php echo $row['pekerjaan_orang'] ?></td>
		<td><?php echo $row['nama_suku'] ?></td>
		<td><?php echo $row['alamat_orang'] ?></td>
		<td><?php echo $row['no_hp'] ?></td>
	</tr>

<?php } ?>
            
            
  </tbody>
</table>
</div><!-- /#wrapper -->
<script src="../assets/js/bootstrap.js"></script>