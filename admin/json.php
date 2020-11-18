<?php
include 'connect.php';
$query = pg_query('SELECT * FROM orang');
while ($row = pg_fetch_array($query)) {
	$data[] = $row;
}				
echo json_encode($data);

?>