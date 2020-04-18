<?php
include "connect.php";
?>
<label for="geom"><span style="color:red">*</span> Coordinat</label>
                     <?php 
                     $query_geom = pg_query("SELECT ST_AsText('0106000000010000000103000000010000000400000022347161E72C5940E4D37F25D224D5BF223471612B255940D315F889C53ADDBF22347161032F59407F58C2F8BFB0DFBF22347161E72C5940E4D37F25D224D5BF')");
                        $data_geom = pg_fetch_array($query_geom);
                     var_dump($data_geom);
                          ?>
                      