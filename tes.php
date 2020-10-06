<?
include "admin/connect.php";

$querysearch=" SELECT kejadian.geom from kejadian, kecamatan  
WHERE st_contains(kecamatan.geom, kejadian.geom) and kecamatan.id_kecamatan='4'
	 ";

$hasil=pg_query($querysearch);
$jumlah = 0;
while($data=pg_fetch_array($hasil))
 {
	$jumlah=$jumlah+1;
 };

?>
<script type="text/javascript">
    var MyJSStringVar = "<?php Print($jumlah); ?>";
    alert(MyJSStringVar);
</script>

