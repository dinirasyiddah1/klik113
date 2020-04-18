public function cariData($table , $kolom1, $kolom2 ,$value1, $value2 ){
  $cari = $this ->db->prepare("SELECT * FROM $table WHERE $kolom1 LIKE '%{$value1}%' OR $kolom2 LIKE '%{$value1}%' ");
  $cari->execute();
  return $cari;
 }

 public function tampilDataPencarianLokasi($tabel , $kolom, $value){
  $cari = $this->db->prepare("SELECT * FROM $tabel WHERE $kolom=$value");
  $cari->execute();
  return $cari;
 }