
<?php
   $FileName = $_GET['FileName'];

   if (!$FileName)
      $FileName = "FileName";

   if (strstr($FileName,"php"))
      return;

   $PostData = file_get_contents("php://input");
   // $PostData = file_get_contents("content://com.mi.android.globalFileexplorer.myprovider/external_files/Android/data/b4a.example/files/1.jpg");

   $File = fopen("../file/pelaporan/" . $FileName.".jpg","wb");
   
   fwrite($File, $PostData);
   fclose($File);

   echo "ACK";
?>
