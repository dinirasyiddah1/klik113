<?
include "admin/connect.php";
?>
<script type="text/javascript">

var server = "http://localhost/klik113/";
var map;
var markersDua = [];
var koordinat = 'null'
var infoposisi = [];
var markerposisi = [];
var centerLokasi;
var markerposisi = [];
var centerBaru;
var cekRadiusStatus = "off"; 
var circles = [];
var rad;
var fotosrc = 'image/';
var angkot = [];
var directionsDisplay;
var infoDua=[];
var rute = [];

// analisis spasial pos
function dispos(){
    kec = new google.maps.Data();
    kec.loadGeoJson(server+'kecamatan.php');
    kec.setStyle(function(feature)
    {
      var id = feature.getProperty('id_kecamatan');
        
      if (id == '1') {var t = 0;}
          if (id == '2') {var t = 1;}
          if (id == '3') {var t = 1;}
          if (id == '4') {var t = 0;}
          if (id == '5') {var t = 1;}
          if (id == '6') {var t = 1;}
          if (id == '7') {var t = 0;}
          if (id == '8') {var t = 0;}
          if (id == '9') {var t = 0;}
          if (id == '10') {var t = 0;}
          if (id == '11') {var t = 1;}
          
          if (t < 1) {
            color = '#ADD8E6';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
          if (t >= 1 && t <= 2) {
            color = '#1E90FF';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
          if (t > 2) {
            color = '#0000CD';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
        });
      kec.setMap(map); 
  }

// analisis spasial
function diskej(){
    kec = new google.maps.Data();
    kec.loadGeoJson(server+'kecamatan.php');
    kec.setStyle(function(feature)
    {
      var id = feature.getProperty('id_kecamatan');
        
      if (id == '1') {var t = 0;}
          if (id == '2') {var t = 8;}
          if (id == '3') {var t = 8;}
          if (id == '4') {var t = 8;}
          if (id == '5') {var t = 2;}
          if (id == '6') {var t = 0;}
          if (id == '7') {var t = 0;}
          if (id == '8') {var t = 0;}
          if (id == '9') {var t = 4;}
          if (id == '10') {var t = 0;}
          if (id == '11') {var t = 0;}
          
          if (t < 2) {
            color = '#008000';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
          if (t >= 2 && t <= 5) {
            color = '#FFFF00';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
          if (t > 5) {
            color = '	#FF0000';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
        });
      kec.setMap(map); 
  }

  // analisis spasial reset
function disreset(){
  kec = new google.maps.Data();
    kec.loadGeoJson(server+'kecamatan.php');
    kec.setStyle(function(feature)
    {
      var id = feature.getProperty('id_kecamatan');
        
      if (id == '1') {var t = 0;}
          if (id == '2') {var t = 8;}
          if (id == '3') {var t = 8;}
          if (id == '4') {var t = 8;}
          if (id == '5') {var t = 2;}
          if (id == '6') {var t = 0;}
          if (id == '7') {var t = 0;}
          if (id == '8') {var t = 0;}
          if (id == '9') {var t = 4;}
          if (id == '10') {var t = 0;}
          if (id == '11') {var t = 0;}
          
          if (t < 2) {
            color = '#008000';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
          if (t >= 2 && t <= 5) {
            color = '#FFFF00';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
          if (t > 5) {
            color = '	#FF0000';
            return({
              fillColor:color,
              strokeWeight:2.0,
              strokeColor:'black',
              fillOpacity:1,
              clickable: true
            });
          }
        });
      kec.setMap(map); 
  }

//Membuat Fungsi Menampilkan Seluruh pos damkar
function viewpos()
{
  hapusMarkerTerdekat();
  hapusRadius();
  hapusInfo();
  clearroute2();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $.ajax
  ({ 
    url: server+'viewpos.php', data: "", dataType: 'json', success: function(rows) 
    { 
      if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        $('#hasilcari').append("<thead><th width='100px'>Name</th><th colspan='3'>Action</th></thead>");
        console.log(rows);
        for (var i in rows) 
        { 
          var row = rows[i];
          var id = row.id_pos_damkar;
          var name = row.nama_pos;
          var address=row.addrealamatss;
         
          var lat=row.lat;
          var lon = row.lng;
          //var ik_status = row.ik_status;
          console.log(name);
          centerBaru = new google.maps.LatLng(lat, lon);
          map.setCenter(centerBaru);
          map.setZoom(10);  
          var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/pos.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
           $('#hasilcari').append("<tr><td>"+name+"</td><td width='30%'><a align='center' role='button' class='btn btn-success' onclick='detailinfopos(\""+id+"\")'>Show</a></td></tr>");
        }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });           
}


//Membuat Fungsi Menampilkan Seluruh kejadian
function viewkejadian()
{
  hapusMarkerTerdekat();
  hapusRadius();
  hapusInfo();
  clearroute2();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $.ajax
  ({ 
    url: server+'viewkejadian.php', data: "", dataType: 'json', success: function(rows) 
    { 
      if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        $('#hasilcari').append("<thead><th>Address</th><th>Action</th></thead>");
        console.log(rows);
        for (var i in rows) 
        { 
          var row = rows[i];
          var id = row.id_kejadian;
          var address=row.lokasi;
         
          var lat=row.lat;
          var lon = row.lng;
          //var ik_status = row.ik_status;
          console.log(address);
          centerBaru = new google.maps.LatLng(lat, lon);
          map.setCenter(centerBaru);
          map.setZoom(8);  
          var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/fire-512d.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
           $('#hasilcari').append("<tr><td>"+address+"</td><td><a role='button' class='btn btn-success' onclick='detkej(\""+id+"\");detailinfokejadian(\""+id+"\");'>Show</a></td></tr>");
         }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });           
}




//Menampilkan Detail Info pos
function detailinfopos(id144){  
  
  $('#info').empty();
  //$('#hasilcari1').show();
 // $('#hasildetpos').show();
 $('#hasilcaridetpos').empty();
 //$('#hasilcaridetpos').empty();
  $('#hasilcaridetpos1').show();
  $('#hasildet').show();
 $('#hasilcaridet').empty();
 //$('#hasilcaridetpos').empty();
  $('#hasilcaridet1').show();
  hapusInfo();
     // clearroute2();
     //hapusMarkerTerdekat();
      $.ajax({ 
     url: server+'detailinfopos.php?info='+id144, data: "", dataType: 'json', success: function(rows)
       { 
        for (var i in rows) 
         { 
           console.log('ddd');
           var row = rows[i];
           var id = row.id;
           var namaa = row.name;
           var capacity = row.capacity;
           var address=row.address;
           var cp=row.cp;
           var open = row.open;
           var close = row.close;
           var fasilitas = row.fasilitas; 
           var latitude  = row.latitude; ;
           var longitude = row.longitude ;
           centerBaru = new google.maps.LatLng(row.latitude, row.longitude);
           marker = new google.maps.Marker
           ({
             position: centerBaru,
             icon:'assets/img/cul.png',
             map: map,
             animation: google.maps.Animation.DROP,
           });
             console.log(latitude);
             console.log(longitude);
             markersDua.push(marker);
           map.setCenter(centerBaru);
           map.setZoom(18); 

               // $('#hasilcaridet').append("<tr><td><b>Open</b></td><td>:</td><td> "+open+"</td></tr><tr><td><b>Close</b></td><td>:</td><td> "+close+"</td></tr>");
               //$('#hasilcaridet').append("<tr><td colspan='2'> "+culinary+"</td><td> "+price+"</td></tr>");
               $('#hasilcaridet').append("<tr><td><b> Facility </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

               //$('#hasilcaridetpos').append("<tr><td><b> Culinary </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

           if (address==null)
                   {
                     address="tidak ada";
                   } 
         //           if (foto=='null' || foto=='' || foto==null){
         //   foto='eror.png';
         // } 
           // $('#info').append("Nama : "+nama+" <br> Alamat : "+alamat+" <br> Kapasitas : "+kapasitas+"");
         // infowindow = new google.maps.InfoWindow({
         //   position: centerBaru,
         //   content: "<center><span style=color:black><b>Information</b><table><tr><td><i class='fa fa-home'></i>Nama</td><td>:</td><td> "+namaa+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Alamat</td><td>:</td><td> "+address+"</td></tr><br><tr><td><i class='fa fa-phone'></i>Telepon</td><td>:</td><td> "+cp+"</td></tr><br><tr><td><i class='fa fa-clock-o'></i>Open</td><td>:</td><td> "+open+"</td></tr><br><tr><td><i class='fa fa-clock-o'></i>Close</td><td>:</td><td> "+close+"</td></tr></table></span><br><input type='button' class='btn btn-success' value='Radius' onclick='tampil_sekitar(\""+latitude+"\",\""+longitude+"\",\""+namaa+"\")'<br>&nbsp&nbsp<input type='button' class='btn btn-success' value='Gallery' onclick='gallery(\""+id+"\")' />",   
         //   pixelOffset: new google.maps.Size(0, -33)
         //   });
         // infoposisi.push(infowindow); 
         // hapusInfo();
         // infowindow.open(map);
           
         }  
          
           // ;ow();tampilsekitar()
       }
     }); 
}








//Menampilkan Detail Info Pos
function detpos(id14433){  
  
  $('#info').empty();
   //$('#hasilcari1').show();
  // $('#hasildetpos').show();
  $('#hasilcaridetpos').empty();
  //$('#hasilcaridetpos').empty();
   $('#hasilcaridetpos1').show();
   $('#hasildet').show();
  $('#hasilcaridet').empty();
  //$('#hasilcaridetpos').empty();
   $('#hasilcaridet1').show();
   hapusInfo();
      // clearroute2();
      //hapusMarkerTerdekat();

      
      
       $.ajax({ 
      url: server+'detailinfopos.php?info='+id14433, data: "", dataType: 'json', success: function(rows)
        { 

          $('#hasilcaridet').append("<tr><td colspan='2'><strong>Culinary</strong></td><td><strong>Price</strong></td></tr>");

         for (var i in rows) 
          { 
            console.log('ddd');
            var row = rows[i];
            var id = row.id_pos_damkar;
            var namaa = row.nama_pos; 
            var latitude  = row.latitude; ;
            var longitude = row.longitude ;
            centerBaru = new google.maps.LatLng(row.latitude, row.longitude);
            marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'assets/img/pos.png',
              map: map,
              animation: google.maps.Animation.DROP,
            });
              console.log(latitude);
              console.log(longitude);
              console.log(id);
              markersDua.push(marker);
            map.setCenter(centerBaru);
            map.setZoom(18); 

                // $('#hasilcaridet').append("<tr><td><b>Open</b></td><td>:</td><td> "+open+"</td></tr><tr><td><b>Close</b></td><td>:</td><td> "+close+"</td></tr><tr><td><b> Facility </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

                $('#hasilcaridet').append("<tr><td colspan='2'> "+culinary+"</td><td> "+price+"</td></tr>");

            // if (address==null)
            //         {
            //           address="tidak ada";
            //         } 
          //           if (foto=='null' || foto=='' || foto==null){
          //   foto='eror.png';
          // } 
           // $('#info').append("Nama : "+nama+" <br> Alamat : "+alamat+" <br> Kapasitas : "+kapasitas+"");
            infowindow = new google.maps.InfoWindow({
            position: centerBaru,
            content: "<center><span style=color:black><b>Information</b><table><tr><td><i class='fa fa-home'></i>Nama</td><td>:</td><td> "+namaa+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Alamat</td><td>:</td><td> "+address+"</td></tr><br><tr></tr></table></span><br>",   
            pixelOffset: new google.maps.Size(0, -33)
            });
          infoposisi.push(infowindow); 
          hapusInfo();
          infowindow.open(map);
            
          }  
           
            // ;ow();tampilsekitar()
        }
      }); 
}


//Menampilkan Detail Info kejadian
function detailinfokejadian(id14411){  
  
  $('#info').empty();
  //$('#hasilcari1').show();
 // $('#hasildetpos').show();
 $('#hasilcaridetkej').empty();
 //$('#hasilcaridetpos').empty();
  $('#hasilcaridetkej1').show();
  $('#hasildet').show();
 $('#hasilcaridet').empty();
 //$('#hasilcaridetpos').empty();
  $('#hasilcaridet1').show();
  hapusInfo();
     // clearroute2();
     //hapusMarkerTerdekat();
      $.ajax({ 
     url: server+'detailinfokej.php?info='+id14411, data: "", dataType: 'json', success: function(rows)
       { 
        for (var i in rows) 
         { 
           console.log('ddd');
           foto = null;
           var row = rows[i];
           var id = row.id_kejadian;
           var lokasi = row.lokasi;
           var kronologis= row.kronologis;
           var id_pelapor= row.id_pelapor;
           var id_saksi= row.id_saksi; 
		       var longitude= row.lng;
           var latitude= row.lat;
           var kerusakan= row.kerusakan;	
           var taksiran_kerugian=row.taksiran_kerugian;		
           var luas_area=row.luas_area;
           var tanggal=row.tanggal;
           centerBaru = new google.maps.LatLng(row.latitude, row.longitude);
           marker = new google.maps.Marker
           ({
             position: centerBaru,
             icon:'assets/img/fire-512d.png',
             map: map,
             animation: google.maps.Animation.DROP,
           });
             console.log(latitude);
             console.log(longitude);
             markersDua.push(marker);
           map.setCenter(centerBaru);
           map.setZoom(18); 
           

               // $('#hasilcaridet').append("<tr><td><b>Open</b></td><td>:</td><td> "+open+"</td></tr><tr><td><b>Close</b></td><td>:</td><td> "+close+"</td></tr>");
               //$('#hasilcaridet').append("<tr><td colspan='2'> "+culinary+"</td><td> "+price+"</td></tr>");
               $('#hasilcaridet').append("<tr><td><b> Facility </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

               //$('#hasilcaridetpos').append("<tr><td><b> Culinary </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

           if (lokasi==null)
                   {
                     lokasi="tidak ada";
                   } 
                   if (foto=='null' || foto=='' || foto==null){
           foto='eror.png';
         } 
           $('#info').append("Lokasi : "+lokasi);
         infowindow = new google.maps.InfoWindow({
           position: centerBaru,
            
           content: "<center><span style=color:black><b>Information</b><table><tr><td><i class='fa fa-home'></i>Lokasi</td><td>:</td><td> "+lokasi+"</td></tr><br></table></span><br><input type='button' class='btn btn-info' value='Info' onclick='infokej(\""+id+"\")' />",   
           pixelOffset: new google.maps.Size(0, -33)
           });
         infoposisi.push(infowindow); 
         hapusInfo();
         infowindow.open(map);
           
         }  
          
           // ;ow();tampilsekitar()
       }
     }); 
}

function infokej(azz){    
  console.log(azz);
window.open(server+'kejadian_detail.php?id_kejadian='+azz);    
}



//Membuat Fungsi Mencari Kuliner
function find_kej() //kuliner
{
  clearroute2();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  if(kej_nama.value=='')
  {
    alert("Isi kolom pencarian terlebih dahulu !");
  }
  else
  {
    //$('#hasilcari').empty();
    $('#hasilcari').append("<thead><th>Name</th><th colspan='3'>Action</th></thead>");
    var kulpos = document.getElementById('kej_nama').value;
    console.log(kulpos);
    hapusInfo();
    // clearangkot();
    hapusRadius();
    hapusMarkerTerdekat();
    $.ajax
    ({ 
      url: server+'find_kej.php?cari_nama='+kulpos, data: "", dataType: 'json', success: function(rows)
      { 
        if(rows==null)
        {
          alert('Data Did Not Exist !');
        }
        for (var i in rows)
        {   
          var row     = rows[i];
          var id  = row.id_kejadian;
          var lokasi   = row.lokasi;
          var lat  = row.latitude ;
          var lon = row.longitude ;
          centerBaru = new google.maps.LatLng(lat, lon);
          marker = new google.maps.Marker
          ({
            position: centerBaru,
            map: map,
            icon: "assets/img/mapmarker.png",
          });
          // console.log(lat);
          // console.log(lon);
          markersDua.push(marker);
          map.setCenter(centerBaru);
          map.setZoom(15);
          clickMarker(centerBaru, id);
          console.log(lokasi);
          $('#hasilcari').append("<tr><td>"+lokasi+"</td><td><a role='button' class='btn btn-success' onclick='detkej(\""+id+"\");detailinfokejadian(\""+id+"\");'>Show</a></td></tr>");
        }   
        $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
      }

    }); 
  }
}




function detkej(id1443322){  
  
  $('#info').empty();
   //$('#hasilcari1').show();
  // $('#hasildetpos').show();
  $('#hasilcaridetkej').empty();
  //$('#hasilcaridetpos').empty();
   $('#hasilcaridetkej1').show();
   $('#hasildet').show();
  $('#hasilcaridet').empty();
  //$('#hasilcaridetpos').empty();
   $('#hasilcaridet1').show();
   hapusInfo();
      // clearroute2();
      //hapusMarkerTerdekat();

      
      
       $.ajax({ 
      url: server+'detailinfokej.php?info='+id1443322, data: "", dataType: 'json', success: function(rows)
        { 

          $('#hasilcaridet').append("<tr><td colspan='2'><strong>Culinary</strong></td><td><strong>Price</strong></td></tr>");

         for (var i in rows) 
          { 
            console.log('ddd');
            var row = rows[i];
            var id = row.id_kejadian;
            var lokasi = row.lokasi; 
            var latitude  = row.latitude; ;
            var longitude = row.longitude ;
            centerBaru = new google.maps.LatLng(row.latitude, row.longitude);
            marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'assets/img/fire-512d.png',
              map: map,
              animation: google.maps.Animation.DROP,
            });
              console.log(latitude);
              console.log(longitude);
              console.log(id);
              markersDua.push(marker);
            map.setCenter(centerBaru);
            map.setZoom(18); 

                // $('#hasilcaridet').append("<tr><td><b>Open</b></td><td>:</td><td> "+open+"</td></tr><tr><td><b>Close</b></td><td>:</td><td> "+close+"</td></tr><tr><td><b> Facility </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

                $('#hasilcaridet').append("<tr><td colspan='2'> "+culinary+"</td><td> "+price+"</td></tr>");

            // if (address==null)
            //         {
            //           address="tidak ada";
            //         } 
          //           if (foto=='null' || foto=='' || foto==null){
          //   foto='eror.png';
          // } 
           // $('#info').append("Nama : "+nama+" <br> Alamat : "+alamat+" <br> Kapasitas : "+kapasitas+"");
            infowindow = new google.maps.InfoWindow({
            position: centerBaru,
            content: "<center><span style=color:black><b>Information</b><table><tr><td><i class='fa fa-home'></i>Alamat</td><td>:</td><td> "+lokasi+"</td></tr><br><br><tr></tr></table></span><br>",   
             
            pixelOffset: new google.maps.Size(0, -33)
            });
          infoposisi.push(infowindow); 
          hapusInfo();
          infowindow.open(map);
            
          }  
           
            // ;ow();tampilsekitar()
        }
      }); 
}



function clickMarker(centerBaru, id)
{
  
  var marker = new google.maps.Marker
    ({
      icon: "assets/img/pos.png",
      position: centerBaru,
      map: map
    });
    markersDua.push(marker);
    
    google.maps.event.addListener(marker, "click", function(){
        detpos(id);
        detailinfopos(id);
        detailinfokejadian(id14411)
      });

}

//fungsi klik kejadian
// function clickMarkerKej(centerBaru, id)
// {
  
//   var marker = new google.maps.Marker
//     ({
//       icon: "assets/img/fire-512d.png",
//       position: centerBaru,
//       map: map
//     });
//     markersDua.push(marker);
    
//     google.maps.event.addListener(marker, "click", function(){
//         detkej(id);
//         detailinfokej(id);
       
//       });

// }


//Membuat Fungsi Cari Kuliner Berdasarkan Kecamatan
function viewkecamatankul()
{
  clearroute2();
  if (document.getElementById('carikecamatankul').value=="")
    {
      alert("Pilih Option Dahulu !");
    }
    else
    {
  hapusMarkerTerdekat();
  a();
    $('#hasilcari').append("<thead><th>Name</th><th colspan='3'>Action</th></thead>");
    var kulkec = document.getElementById('carikecamatankul').value;
    console.log(kulkec);
    $('#hasilcari').empty();
    $('#hasilpencarian').empty();
    hapusInfo();
    hapusRadius();
    hapusMarkerTerdekat();
    $.ajax
    ({ 
      url: server+'district.php?district='+kulkec, data: "", dataType: 'json', success: function(rows)
      { 
        if(rows==null)
        {
          alert('Data Did Not Exist !');
        }
        for (var i in rows)
        {   
          var row     = rows[i];
          var id_tempat_kuliner  = row.id;
          var nama_tempat_kuliner   = row.name;
          var id_kecamatan   = row.id;
          var lat  = row.latitude ;
          var lon = row.longitude ;
          centerBaru = new google.maps.LatLng(lat, lon);
          marker = new google.maps.Marker
          ({
            position: centerBaru,
            map: map,
            icon: "assets/img/cul.png",
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          map.setZoom(14);
          clickMarker(centerBaru, id_tempat_kuliner);
          console.log(id_kecamatan);
          $('#hasilcari').append("<tr><td>"+nama_tempat_kuliner+"</td><td><a role='button' class='btn btn-success' onclick='detculi(\""+id_tempat_kuliner+"\");detailinfokul(\""+id_tempat_kuliner+"\");'>Show</a></td><td><a role='button' class='btn btn-danger fa fa-taxi' onclick='kulAngkot(\""+id_tempat_kuliner+"\")'></a></td></tr>");
        }   
        $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
      }
    }); 
  }
}



function viewkejadian()
{
  hapusMarkerTerdekat();
  hapusRadius();
  hapusInfo();
  clearroute2();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $.ajax
  ({ 
    url: server+'viewkejadian.php', data: "", dataType: 'json', success: function(rows) 
    { 
      if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        $('#hasilcari').append("<thead><th>Address</th><th>Action</th></thead>");
        console.log(rows);
        for (var i in rows) 
        { 
          var row = rows[i];
          var id = row.id_kejadian;
          var address=row.lokasi;
         
          var lat=row.lat;
          var lon = row.lng;
          //var ik_status = row.ik_status;
          console.log(address);
          centerBaru = new google.maps.LatLng(lat, lon);
          marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/fire-512d.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
           map.setZoom(10);

          
          // console.log(nama);
           $('#hasilcari').append("<tr><td>"+address+"</td><td><a role='button' class='btn btn-success' onclick='detkej(\""+id+"\");detailinfokejadian(\""+id+"\");'>Show</a></td></tr>");
        }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });           
}





  function caritpkec()
{
  var kec=document.getElementById('kecamatan').value;
  hapusMarkerTerdekat();
  hapusRadius();
  hapusInfo();
  clearroute2();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $.ajax
  ({ 
    //url: server+'viewkejadian.php', data: "", dataType: 'json', success: function(rows) 
    url: server+'kecamatan_cari.php?kecamatan='+kec, data: "", dataType: 'json', success: function(rows)
          
    { 
      if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        //$('#hasilcari').append("<thead><th>Address</th><th>Action</th></thead>");
        $('#hasilcari').append("<thead><th>Name</th><th>Action</th></thead>");
         
        console.log(rows);
        for (var i in rows) 
        { 
          

          var row = rows[i];
          var id = row.id_kejadian;
          var lokasi   = row.lokasi;
          var latitude  = row.latitude ;
          var longitude = row.longitude ;
          //var ik_status = row.ik_status;
          console.log(lokasi);
          centerBaru = new google.maps.LatLng(latitude, longitude);
          map.setCenter(centerBaru);
          map.setZoom(10);  
          var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/fire-512d.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
          $('#hasilcari').append("<tr><td>"+lokasi+"</td><td><a role='button' class='btn btn-success' onclick='detkej(\""+id+"\");detailinfokejadian(\""+id+"\");'>Show</a></td></tr>");
             
           
        }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });           
}



  function daftar(){
  alert('Silahkan Login Terlebih Dahulu');
}

function clearroute2(){      
    if(typeof(directionsDisplay) != "undefined" && directionsDisplay.getMap() != undefined){
    directionsDisplay.setMap(null);
    $("#detailrute").remove();
    }     
}

 function clearroute(){
          for (i in rute){
            rute[i].setMap(null);
          } 
          rute=[]; 
        }


  function hapusMarkerTerdekat() {
    for (var i = 0; i < markersDua.length; i++) {
          markersDua[i].setMap(null);
      }
  }

  function hapusMarkerInfowindow(){
         setMapOnAll(null);
         hapusMarkerTerdekat();
         pos = 'null';
    }
//Menghapus Info
function hapusInfo() 
{
  for (var i = 0; i < infoposisi.length; i++) 
    {
      infoposisi[i].setMap(null);
    }
}

function tampilkankej(rows){
  $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
    clearroute();
    //clearangkot();
  hapusRadius();
      hapusMarkerTerdekat();
  
  if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        $('#hasilcari1').empty();
          $('#hasilcari1').append("<table class='table'>");
          $('#hasilcari1').append("<thead><th>Name</th><th colspan='3'>Action</th></thead>");
        console.log(rows);
        for (var i in rows) 
        { 
          var row = rows[i];
          var id = row.id_kejadian;
          var address=row.lokasi;
         
          var lat=row.latitude;
          var lon = row.longitude;
          //var ik_status = row.ik_status;
          console.log(address);
          centerBaru = new google.maps.LatLng(lat, lon);
          map.setCenter(centerBaru);
          map.setZoom(15);  
          var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/fire-512d.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
          $('#hasilcari1').append("<tr><td>"+address+"</td><td><a role='button' class='btn btn-success' onclick='detkej(\""+id+"\");detailinfokejadian(\""+id+"\");info1();'>Show</a></td></tr>");
              $('#hasilcari1').append("</table>");
          }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
   
           
}


function caritahun()
{
  var tahun=document.getElementById('tahuncar').value;
  hapusMarkerTerdekat();
  hapusRadius();
  hapusInfo();
  clearroute2();
  $('#hasilcari').empty();
  $('#hasilpencarian').empty();
  $("#filterik").hide();
  $('#hasilik').show();
  $('#hasilcari1').show();
  $('#hasilcari').empty();
  $.ajax
  ({ 
    //url: server+'viewkejadian.php', data: "", dataType: 'json', success: function(rows) 
    url: server+'tahun.php?cari_tahun='+tahun, data: "", dataType: 'json', success: function(rows)
          
    { 
      if(tahuncar.value=='')
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        //$('#hasilcari').append("<thead><th>Address</th><th>Action</th></thead>");
        $('#hasilcari').append("<thead><th>Address</th><th>Action</th></thead>");
         
        console.log(rows);
        for (var i in rows) 
        { 
          

          var row = rows[i];
          var id = row.id_kejadian;
          var lokasi   = row.lokasi;
          var latitude  = row.latitude ;
          var longitude = row.longitude ;
          //var ik_status = row.ik_status;
          console.log(lokasi);
          centerBaru = new google.maps.LatLng(latitude, longitude);
          map.setCenter(centerBaru);
          map.setZoom(10);  
          var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'assets/img/fire-512d.png',
            animation: google.maps.Animation.DROP,
            map: map
          });
          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
          $('#hasilcari').append("<tr><td>"+lokasi+"</td><td><a role='button' class='btn btn-success' onclick='detkej(\""+id+"\");detailinfokejadian(\""+id+"\");'>Show</a></td></tr>");
             
           
        }
      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });           
}




function caritahun1() //fungsi cari kejadian berdasarkan tahun
  {
    
    $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
      clearroute();
    //clearangkot();
  hapusRadius();
      hapusMarkerTerdekat();
    //var kecamatan= kec.value;
    tahun=document.getElementById('tahuncar');
    if(tahuncar.value==''){
    alert("Fill the input form first!");
    }else{
      //alert(server+'tahun.php?cari_tahun='+tahun.value)
    $.ajax({ url: server+'tahun.php?cari_tahun='+tahun.value, data: "", dataType: 'json', success: function (rows){
      tampilkankej(rows);
      
    }});
  }
  }





function cari_tahun(rows) //fungsi cari panti
  {  
    hapusMarkerTerdekat(); 
    $('#hasilcari1').show();
    $('#hasilcari').empty();
    hapusInfo();
    console.log(rows);
     
            if(rows==null)
            {
              alert('Data Tidak Ditemukan');
            }
        for (var i in rows) 
            {   
              var row     = rows[i];
              var id   = row.id_kejadian;
              var lokasi   = row.lokasi;
              var latitude  = row.latitude ;
              var longitude = row.longitude ;
              centerBaru = new google.maps.LatLng(latitude, longitude);
              marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'src/images/fire-512d.png',
              map: map,
              animation: google.maps.Animation.DROP,
     
            });
            markersDua.push(marker);
              clickMarker(centerBaru, id);
              map.setZoom(12);
              //$('#hasilcari1').show(); 
              $('#hasilcari').append("<tr><td>"+id+"</td><td>&nbsp <a role='button' title='info' class='fa fa-info-circle' onclick='detailpanti_info(\""+id+"\")'></a></td></tr>");
              
            }
    }



</script>
      <!-- Sidebar -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.php">KLIK113 - GIS Fire Data Archiving In Padang City</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav ">
            <li <?php if($page == "Home") echo "class='active'";?>><a href="index.php"><i class="fa fa-dashboard"></i> Dashboard</a></li>
           

           <li class="nav-item">
                                <a class="nav-link " href="#submenu1" data-toggle="collapse" data-target="#submenu1"><span class="fa fa-search"></span> Fire Station <i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                                <div class="collapse" id="submenu1" aria-expanded="false">
                                    <ul class="flex-column pl-2 nav">
                                    <li class="nav-item">
                                            <a class="nav-link collapsed py-0" href="#submenu1sub1" data-toggle="collapse" data-target="#submenu1sub1"><span class="fa fa-globe"> View All</a>
                                            <div class="collapse small" id="submenu1sub1" aria-expanded="false">
                                                <ul class="flex-column nav pl-4">
                                                    
                                                <button type="button" onclick="viewpos()" class="btn btn-primary btn-sm " data-toggle="tooltip" title="Melihat Semua Pos" 
                                                        style="margin: 7px" style="margin-right: 7px;"><i class="fa fa-eye"></i>
                                                </button>
                                                </ul>
                                            </div>
                                          </li>


                                        
                                    </ul>
                                </div>
                            </li>

                        
                            <li class="nav-item">
                                <a class="nav-link " href="#submenu2" data-toggle="collapse" data-target="#submenu2"><span class="fa fa-search"></span> Fire Incident <i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                                <div class="collapse" id="submenu2" aria-expanded="false">
                                    <ul class="flex-column pl-2 nav">
                                    <li class="nav-item">
                                            <a class="nav-link collapsed py-0" href="#submenu2sub1" data-toggle="collapse" data-target="#submenu2sub1"><span class="fa fa-globe"> View All</a>
                                            <div class="collapse small" id="submenu2sub1" aria-expanded="false">
                                                <ul class="flex-column nav pl-4">
                                                    
                                                <button type="button" onclick="viewkejadian()" class="btn btn-primary btn-sm " data-toggle="tooltip" title="Melihat Semua Kejadian" 
                                                        style="margin: 7px" style="margin-right: 7px;"><i class="fa fa-eye"></i>
                                                </button>
                                                </ul>
                                            </div>
                                          </li>


                                        <li class="nav-item">
                                            <a class="nav-link collapsed py-0" href="#submenu2sub2" data-toggle="collapse" data-target="#submenu2sub2">
                                            <span class="fa fa-home"></span> Districts</a>
                                            <div class="collapse small" id="submenu2sub2" aria-expanded="false">
                                                <ul class="flex-column nav pl-4">
                                            
                                                    <li class="nav-item">
                                                    
                                                    <select class="form-control" id="kecamatan" >
                                                    <option value="">-Choose-</option>
                                                        <?php
                                                          include("admin/connect.php");
                                                          $kecamatan=pg_query("select * from kecamatan order by nama_kecamatan ASC ") ;

                                                          while ($result = pg_fetch_array($kecamatan)) 
                                                          {
                                                            echo "<option  value='".$result['id_kecamatan']."'>".$result['nama_kecamatan']."</option>";
                                                          }
                                                        ?>
                                                    </select> 
                                                    <button type="submit" class="btn btn-default" id="caritpkec"  value="cari" onclick="caritpkec()"><i class="fa fa-search"></i></button>
          			                                  </li>
                                                    
                                                </ul>
                                            </div>
                                        </li>

                                        <li class="nav-item">
                                            <a class="nav-link collapsed py-0" href="#submenu2sub3" data-toggle="collapse" data-target="#submenu2sub3">
                                            <span class="fa fa-home"></span> Year</a>
                                            <div class="collapse small" id="submenu2sub3" aria-expanded="false">
                                                <ul class="flex-column nav pl-4">
                                            
                                                    <li class="nav-item">
                                                    
                                                    <select class="form-control" id="tahuncar" >
                                                    <option value="">-Choose-</option>
                                                        <?php
                                                        include("admin/connect.php");
                                                        $sql=pg_query("select * from kejadian order by tanggal ASC");
                                                      $temp=0;
                                                        while($result=pg_fetch_assoc($sql))
                                                          {
                                                            $tahun=$result['tanggal'];
                                                            $subtahun= substr($tahun,0,4);
                                                            if ($subtahun!=$temp) {
                                                              echo "<option   value='$subtahun'>".$subtahun."</option>";
                                                              $temp=$subtahun;
                                                            }
                                                          }
                                                        ?>
                                                    </select>
                                                      <button type="submit" class="btn btn-default" id="caritahun"value="" onclick="caritahun()"> <i class="fa fa-search"></i></button>                          
                                                          
                                                  </li>
                                                    
                                                </ul>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                              </li>

                              <li class="nav-item">
                                <a class="nav-link " href="#submenu3" data-toggle="collapse" data-target="#submenu3"><span class="fa fa-search"></span> Data Distribution <i class="fa fa-arrow-down" aria-hidden="true"></i></a>
                                <div class="collapse" id="submenu3" aria-expanded="false">
                                    <ul class="flex-column pl-2 nav">
                                    <li class="nav-item">
                                    <input type="checkbox" id="dispos" onclick="dispos()">
                                    <label for="dispos" style="color:grey;"> All Fire Station</label><br>
                                    <input type="checkbox" id="diskej" name="diskej" value="" onclick="diskej()">
                                    <label for="diskej" style="color:grey;"> All Fire Incident</label><br>
                                                <li class="nav-item">
                                                    
                                                    <select class="form-control" id="kecamatan" >
                                                    <option value="">-Choose-</option>
                                                    <option value="" >All FIre Station</option>
                                                    <option value="">All Fire Incident</option>
                                                    
                                                        
                                                    </select> 
                                                    <button type="submit" class="btn btn-primary" id="caritpkec"  value="cari" onclick="dispos()">Show On Map</i></button>
          			                                  
                                                    <button type="submit" class="btn btn-danger" id="caritpkec"  value="cari" onclick="disreset()">Reset</i></button>
          			                                  
                                                  </li>
                                            
                                          </li>


                                        
                                    </ul>
                                </div>
                            </li>
                              

          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">                     
            <li class="dropdown user-dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-sign-in"></i> Log In <b class="caret"></b></a>
              
              <ul class="dropdown-menu">
                <li><a href="login.php"><img src="https://img.icons8.com/color/48/000000/administrator-male.png" width="30%"/> Admin</a></li>
                <li><a href="login_petugas.php"><img src="https://img.icons8.com/color/48/000000/worker-beard.png" width="30%"/> Petugas </a></li>
                
              </ul>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>
      

