<!DOCTYPE html>
<html>
<head>
	<title>MEMBUAT CETAK PRINT LAPORAN DENGAN PHP - WWW.MALASNGODING.COM</title>
    <style>
    }
    th{
        align="left";
    }
    </style>
</head>
<body>
 <div id="source-html" style=>
	<center>
		<h2 style="font-family:'Britannic Bold';font-size:10pt;"><u>LAPORAN KEJADIAN</u></h2>
	</center>
 
	<br/>
 
	<p style="font-family:'Franklin Gothic Medium'; font-size:10pt; text-align:left;">
    Melaporkan telah terjadi 
	</p>

    <table style="font-family:'Franklin Gothic Medium'; font-size:10pt; text-align:left;">
    <?php
    session_start();
          include "connect.php";

          $id=$_GET['id_kejadian'];
          $sql1=pg_query("SELECT * FROM kejadian
                            
                            INNER JOIN detail_kendaraan ON (detail_kendaraan.id_kejadian = kejadian.id_kejadian)
                            INNER JOIN kendaraan ON (kendaraan.nomor_plat = detail_kendaraan.nomor_plat)
          WHERE kejadian.id_kejadian='$id'")or die(pg_error());
          
          $no=1;
          $hasil=pg_fetch_array($sql1);
        ?>

        <tr>
            <th>1.</th>
            <th>Waktu Kejadian &nbsp<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th></th>
            <th>Hari/Tanggal<th>
            <td>:</td>
            <?php
            include ("format_hari_tanggal.php");
            error_reporting(0);
            $query=pg_query("SELECT tanggal FROM kejadian where id_kejadian='$id'");
            $data=pg_fetch_array($query);
            $date = $data['tanggal'];
            // $tgl = date_create($date);
            // $format_tgl = date_format($tgl,'l, d M Y');
            echo "<td>".format_hari_tanggal($date)."</td>";
            ?>
        </tr>
        <tr>
            <th></th>
            <th>Jam<th>
            <td>:</td>
            <?php
            $query=pg_query("SELECT jam FROM kejadian where id_kejadian='$id'");
            $data=pg_fetch_array($query);
            $time=$data['jam'];
            $jam=date_create($time);
            $format_jam=date_format($jam,'H:i')
            ?>
            <td><?=$format_jam;?> WIB</td>
        </tr>
        <tr>
            <th></th>
            <th>Regu Piket<th>
            <td>:</td>
            <?php
                $query = pg_query("SELECT nama_regu FROM kejadian
                        INNER JOIN regu_piket ON kejadian.id_regu = regu_piket.id_regu
                         WHERE id_kejadian='$id'");
                $hasil_regu= pg_fetch_array($query);
            ?>
            <td><?=$hasil_regu['nama_regu'];?></td>
        </tr>
        <tr>
            <th>2.</th>
            <th>Jenis Kejadian<th>
            <td>:</td>
            <?php
              $query1 = pg_query("SELECT jenis_kejadian FROM kejadian
                      INNER JOIN detail_objek_terbakar ON kejadian.id_kejadian = detail_objek_terbakar.id_kejadian
                      WHERE kejadian.id_kejadian='$id'
                       ");
              $hasil1 = pg_fetch_array($query1);
            ?>
            <td><?=$hasil1['jenis_kejadian'];?></td>
        </tr>
        <tr>
            <th>3.</th>
            <th>Penyebab Kejadian<th>
            <td>:</td>
            <?php
              $query2 = pg_query("SELECT penyebab FROM kejadian
                          INNER JOIN detail_penyebab ON kejadian.id_kejadian = detail_penyebab.id_kejadian
                          WHERE kejadian.id_kejadian='$id'
                          ");
              $hasil2 = pg_fetch_array($query2);
            ?>
            <td><?=$hasil2['penyebab'];?></td>
        </tr>
        <tr>
            <th>4. </th>
            <th>Lokasi Kejadian<th>
            <td>:</td>
            <td><?=$hasil['lokasi'];?></td>            
        </tr>
        <tr>
            <td><td><td><td>
            <td>RT/RW &nbsp;&nbsp;&nbsp;&nbsp; 
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp; <?=$hasil['rt'];?> / <?=$hasil['rw'];?></td>
            
        </tr>
        <tr>
            <td><td><td><td>
            <td>Kelurahan &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp; <?=$hasil['kelurahan'];?></td>
            
        </tr>
        <tr>
            <td><td><td><td>
            <?php
                $query = pg_query("SELECT C.nama_kecamatan
                FROM kejadian AS K, kecamatan AS C
                WHERE ST_CONTAINS(C.geom, K.geom) AND K.id_kejadian='$id'");
                $data = pg_fetch_array($query);
            ?>
            <td>Kecamatan &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp; <?=$data['nama_kecamatan'];?></td>
            
        </tr>
        <tr>
            <th>5.</th>
            <th>Nama Pelapor<th>
            <td>:</td>
                <?php
                    $id=$hasil['id_kejadian'];
                    $data_pelapor = pg_query("SELECT * FROM kejadian 
                                            INNER JOIN detail_pelapor ON kejadian.id_kejadian=detail_pelapor.id_kejadian
                                            INNER JOIN orang ON detail_pelapor.id_orang = orang.id_orang
                                            where kejadian.id_kejadian = '$id'
                                            ");
                    $hasil_pelapor = pg_fetch_array($data_pelapor);
                    
                    ?>
                    <td><?=$hasil_pelapor['nama_orang'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>No. Telepon/HP.<th>
            <td>:</td>
            <td><?=$hasil_pelapor['no_hp'];?></td>
        </tr>
        <tr>
            <th>6.</th>
            <th>Nama Pemilik/Data Korban *<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th></th>
            <th>a. Nama/umur<th>
            <td>:</td>
            <?php
                    $id=$hasil['id_kejadian'];
                    $data_pemilik = pg_query("SELECT * FROM kejadian 
                        INNER JOIN detail_objek_terbakar ON kejadian.id_kejadian=detail_objek_terbakar.id_kejadian
                        INNER JOIN orang ON detail_objek_terbakar.id_orang = orang.id_orang
                        INNER JOIN suku on suku.id_suku = orang.id_suku
                        where kejadian.id_kejadian = '$id'
                        ");
                    $hasil_pemilik = pg_fetch_array($data_pemilik);
                    ?>
                    <td><?=$hasil_pemilik['nama_orang'];?>/<?=$hasil_pemilik['umur_orang']?> Th</td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Pekerjaan<th>
            <td>:</td>
            <td><?=$hasil_pemilik['pekerjaan_orang'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Suku<th>
            <td>:</td>
            <td><?=$hasil_pemilik['nama_suku'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Alamat<th>
            <td>:</td>
            <td><?=$hasil_pemilik['alamat_orang'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>a. Nama/umur(SAKSI)<th>
            <td>:</td>
            <?php
                $data_saksi = pg_query("SELECT * FROM kejadian 
                                        JOIN detail_saksi ON kejadian.id_kejadian=detail_saksi.id_kejadian
                                        JOIN orang ON detail_saksi.id_orang = orang.id_orang
                                        INNER JOIN suku on suku.id_suku = orang.id_suku
                                        where kejadian.id_kejadian='$id'
                                        ");
                $hasil_saksi = pg_fetch_array($data_saksi);
                ?>
                <td><?=$hasil_saksi['nama_orang'];?>/<?=$hasil_saksi['umur_orang']?> Th</td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Pekerjaan<th>
            <td>:</td>
            <td><?=$hasil_saksi['pekerjaan_orang'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Suku<th>
            <td>:</td>
            <td><?=$hasil_saksi['nama_suku'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Alamat<th>
            <td>:</td>
            <td><?=$hasil_saksi['alamat_orang'];?></td>
        </tr>
        <tr>
            <th>7.</th>
            <th style="width:15%;">Pengerahan Personil/Kendaraan<th>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th></th>
            <th>a. Jumlah Personil yang turun<th>
            <td>:</td>
            <?php
                $id=$_GET['id_kejadian'];
                $query_inst=pg_query("SELECT * FROM kejadian
                            INNER JOIN detail_instansi ON kejadian.id_kejadian=detail_instansi.id_kejadian
                            INNER JOIN instansi ON detail_instansi.id_instansi=instansi.id_instansi
                            WHERE kejadian.id_kejadian = '$id'");
                while($data=pg_fetch_array($query_inst)){
                    $jumlah[]=$data['jumlah_personil'];
                };
                $jumlah_personil = array_sum($jumlah);
                
                if($jumlah_personil==0){
                    echo "<td> _ orang </td>";
                }else{
                    echo "<td>".$jumlah_personil." orang</td>";
                }
            ?>
            
        </tr>
        <tr>
            <th></th>
            <th>b. Instansi yang terlibat<th>
            <td>:</td>
            <td>
            <?php
                $query=pg_query("SELECT * FROM kejadian
                INNER JOIN detail_instansi ON kejadian.id_kejadian=detail_instansi.id_kejadian
                INNER JOIN instansi ON detail_instansi.id_instansi=instansi.id_instansi
                WHERE kejadian.id_kejadian = '$id'");
                
                while ($data=pg_fetch_array($query)){
                    echo $data['nama_instansi'].",";
                };
            ?>
            </td>
        </tr>
        <tr>
            <th></th>
            <th>c. Kendaraan/Peralatan<th>
            <td>:</td>
            <td>
            <?php
                $query=pg_query("SELECT * FROM kejadian
                INNER JOIN detail_kendaraan ON kejadian.id_kejadian=detail_kendaraan.id_kejadian
                INNER JOIN kendaraan ON detail_kendaraan.nomor_plat=kendaraan.nomor_plat
                WHERE kejadian.id_kejadian = '$id'");
                $unit = 0;
                while ($data=pg_fetch_array($query)){
                    echo $data['nama_kendaraan'].", ";
                    $unit++;
                };
                echo "(" .$unit. " unit)";
            ?></td>
        </tr>
        <tr>
            <th>8.</th>
            <th>Kronologis Kejadian<th>
            <td>:</td>
            <td><?=$hasil['kronologis'];?></td>
        </tr>
        <tr>
            <th>9.</th>
            <th>Akibat Kejadian<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th></th>
            <th>a. Korban Manusia<th>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Nama/Umur<th>
            <td>:</td>
            <?php
                 $query = "SELECT * FROM orang
                             INNER JOIN detail_korban ON orang.id_orang = detail_korban.id_korban
                             INNER JOIN kejadian ON kejadian.id_kejadian = detail_korban.id_kejadian
                             INNER JOIN suku ON suku.id_suku = orang.id_suku";
                 $sql=pg_query($query) or die (pg_error());
                 $korban = pg_fetch_assoc($sql);

                 if($korban['id_korban']==[]){
                     echo "<td>nihil</td>";
                 }else{
                     echo "<td>".$korban['nama_orang']."/".$korban['umur_orang']."</td>";
                 };

            ?>
            
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Pekerjaan<th>
            <td>:</td>
            <?php
            if($korban['id_korban']==[]){
                echo "<td>nihil</td>";
            }else{
                echo "<td>".$korban['pekerjaan_orang']."</td>";
            };
            ?>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Suku<th>
            <td>:</td>
            <?php
            if($korban['id_korban']==[]){
                echo "<td>nihil</td>";
            }else{
                echo "<td>".$korban['nama_suku']."</td>";
            };
            ?>
        </tr>
        <tr>
            <th></th>
            <th>&nbsp&nbsp&nbsp Alamat<th>
            <td>:</td>
            <?php
            if($korban['id_korban']==[]){
                echo "<td>nihil</td>";
            }else{
                echo "<td>".$korban['alamat_orang']."</td>";
            };
            ?>
        </tr>
        <tr>
            <th></th>
            <th>b. Kerusakan<th>
            <td>:</td>
            <td><?=$hasil['kerusakan'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>c. Luas Areal<th>
            <td>:</td>
            <td><?=$hasil['luas_area'];?></td>
        </tr>
        <tr>
            <th></th>
            <th>c. Taksiran Kerugian<th>
            <td>:</td>
            <td><?=$hasil['taksiran_kerugian'];?></td>
        </tr>
        
        
    </table>
    
    <table style="font-family:'Franklin Gothic Medium'; font-size:10pt; text-align:center;" align="right">
        <tr><td>Yang Melaporkan<td></tr>
        <?php
            $query=pg_query("SELECT * FROM kejadian
                             join admin on admin.username_admin=kejadian.username_admin
                             where id_kejadian='$id'");
            $data=pg_fetch_array($query);
        ?>
        <tr><th><?=$data['jabatan'];?><br><br><br><th></tr>
        
        <tr><th><u><?=$data['nama'];?></u></th></tr>
        <tr><td><?=$data['username_admin'];?></td></tr>
    </table>
</div>
<div>

</div>
    <div class="content-footer">
                <button id="btn-export" onclick="exportHTML();">Export to word doc</button>
    </div>
	
	<!-- <script>
		window.print();
	</script> -->
	
    <script>
    function exportHTML(){
       var header = "<html xmlns:o='urn:schemas-microsoft-com:office:office' "+
            "xmlns:w='urn:schemas-microsoft-com:office:word' "+
            "xmlns='http://www.w3.org/TR/REC-html40'>"+
            "<head><meta charset='utf-8'><title>Export HTML to Word Document with JavaScript</title></head><body>";
       var footer = "</body></html>";
       var sourceHTML = header+document.getElementById("source-html").innerHTML+footer;
       
       var source = 'data:application/vnd.ms-word;charset=utf-8,' + encodeURIComponent(sourceHTML);
       var fileDownload = document.createElement("a");
       document.body.appendChild(fileDownload);
       fileDownload.href = source;
       fileDownload.download = 'document.doc';
       fileDownload.click();
       document.body.removeChild(fileDownload);
    }
</script>

</body>
</html>