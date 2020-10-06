
<?php
   $FileName = $_GET['FileName'];

   if (!$FileName)
      $FileName = "FileName";

   if (strstr($FileName,"php"))
      return;

   $PostData = file_get_contents("php://input");

   if ( is_uploaded($_FILES['newpicture']['tmp_name'])) {
      if ( $_FILES['newpicture']['type'] != 'image/jpeg' ) {
        // not a jpeg, perhaps create an error message
      } else {
        // move it somewhere
        move_uploaded_file($_FILES['newpicture']['tmp_name'],'../file/pelaporan/L00023/1.jpg') ;
      }
    }
?>
