v<?
include "../admin/connect.php";
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

//Membuat Fungsi Menampilkan Seluruh pos damkar
function viewreport()
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
    url: server+'viewreport.php', data: "", dataType: 'json', success: function(rows) 
    { 
      if(rows==null)
      {
        alert('Data Did Not Exist!');
      }
      else
      {
        console.log(rows);

        
       
        for (var i in rows) 
        { 
          var row = rows[i];
          var id = row.id_laporan;
          var media = row.media;
          var tanggal = row.tanggal;
          var lokasi = row.lokasi;
          var latitude=row.lat;
          var longitude = row.lng;
          //var ik_status = row.ik_status;
          console.log(lokasi);
          centerBaru = new google.maps.LatLng(latitude, longitude);
          map.setCenter(centerBaru);
          map.setZoom(10);
          
        //  var content = document.createElement('div');
        //   div.textContent = row.lokasi;
        //   content.appendChild(content);
        var infowindow = new google.maps.InfoWindow
        ({
            content: "<center><span style=color:black><b>Information</b><table><tr><center><img src='../file/pelaporan/"+media+"' width='50%'></center></tr><tr></tr><tr><td><i class='fa fa-home'></i>Tanggal</td><td>:</td><td> "+tanggal+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Alamat</td><td>:</td><td> "+lokasi+"</td></tr><br><tr></tr></table></span><br>",   
            
          }); 

        var marker = new google.maps.Marker
          ({
            position: centerBaru,              
            icon:'../assets/img/fire-512d.png',
            animation: google.maps.Animation.DROP,
            map: map,
            title : lokasi
          });

          markersDua.push(marker);
          map.setCenter(centerBaru);
          // console.log(nama);
           $('#hasilcari').append("<tr><td>"+lokasi+"</td><td width='30%'><a align='center' role='button' class='btn btn-success' onclick='detpos(\""+id+"\");detailinfopos(\""+id+"\");'>Show</a></td></tr>");
        }

        
         

          marker.addListener('click', function() {
            infowindow.open(map, marker);
          });


      } 
      $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
    }
  });     
             
}

//Menampilkan Detail Info pos
function detailinforepo(id144){  
  
  $('#info').empty();
 $('#hasilcaridetpos').empty();
  $('#hasilcaridetpos1').show();
  $('#hasildet').show();
 $('#hasilcaridet').empty();
  $('#hasilcaridet1').show();
  hapusInfo();
      $.ajax({ 
     url: server+'viewreportdetail.php?info='+id144, data: "", dataType: 'json', success: function(rows)
       { 
        for (var i in rows) 
         { 
           console.log('ddd');


           var row = rows[i];
          var id = row.id_laporan;
          var media = row.media;
          var tanggal = row.tanggal;
          var lokasi = row.lokasi;
          var latitude=row.lat;
          var longitude = row.lng;

          
           centerBaru = new google.maps.LatLng(latitude, longitude);
           marker = new google.maps.Marker
           ({
             position: centerBaru,
             icon:'../assets/img/fire-512d.png',
             map: map,
             animation: google.maps.Animation.DROP,
           });
             console.log(latitude);
             console.log(longitude);
             markersDua.push(marker);
           map.setCenter(centerBaru);
           map.setZoom(18); 

           if (lokasi==null)
                   {
                     lokasi="tidak ada";
                   } 
         //           if (foto=='null' || foto=='' || foto==null){
         //   foto='eror.png';
         // } 
           // $('#info').append("Nama : "+nama+" <br> Alamat : "+alamat+" <br> Kapasitas : "+kapasitas+"");
         infowindow = new google.maps.InfoWindow({
           position: centerBaru,
           content: "<center><span style=color:black><b>Information</b><table><tr><center><img src='../file/pelaporan/"+media+"' width='50%'></center></tr><tr></tr><tr><td><i class='fa fa-home'></i>Tanggal</td><td>:</td><td> "+tanggal+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Alamat</td><td>:</td><td> "+lokasi+"</td></tr><br><tr></tr></table></span><br>",   
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



//Menampilkan Detail Info report
function detailinforeport(id14411){  
  
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


  $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
    clearroute();
    //clearangkot();
  
      hapusMarkerTerdekat();
      $.ajax({ 
     url: server+'viewreportdetail.php?info='+id14411, data: "", dataType: 'json', success: function(rows)
       { 

        if(rows==null)
            {
              alert('Data Tidak Ditemukan');
            }
        for (var i in rows) 
         { 
           console.log('ddd');
           foto = null;
           

           var row = rows[i];
            var id = row.id_laporan;
            var media = row.media;
            var tanggal = row.tanggal;
            var lokasi = row.lokasi;
            var latitude=row.lat;
            var longitude = row.lng;

           centerBaru = new google.maps.LatLng(latitude,longitude);
           marker = new google.maps.Marker
           ({
             position: centerBaru,
             icon:'../assets/img/fire-512d.png',
             map: map,
             animation: google.maps.Animation.DROP,
           });
           markersDua.push(marker);
      

              klikInfoWindow(id);
              map.setZoom(12);
              // $('#hasilcari1').show(); 
              $('#hasilcari1').append("<tr><td>"+id+"</td><td><a role='button' title='info' class='btn btn-default fa fa-info' onclick='detailunit_info(\""+id+"\")'></a></td><td><a role='button' title='detail' class='btn btn-default fa fa-list' data-toggle='modal' data-target='#myModal' onclick='detailunit_info(\""+id+"\")'></a></td></tr>");
            }
       }
     }); 
}


function klikInfoWindow(id)
{
    google.maps.event.addListener(marker, "click", function(){
      detailunit_info(id);
       
      });

}

function detailunit_info(id){  //menampilkan informasi Unit Medical
  
  $('#info').empty();
   hapusInfo();
   hapusMarkerTerdekat();
        $.ajax({ 
       url: server+'viewreportdetail.php?no_hp='+id, data: "", dataType: 'json', success: function(rows)
         { 
      console.log("hiaiii");
        
          for (var i in rows) 
           { 
 
             console.log('dd');

             var row = rows[i];
            var id = row.id_laporan;
            var media = row.media;
            var tanggal = row.tanggal;
            var lokasi = row.lokasi;
            var latitude=row.lat;
            var longitude = row.lng;
          
       //var jumlah = row.jumlah;
       centerBaru = new google.maps.LatLng(latitude, longitude);
             marker = new google.maps.Marker
             ({
               position: centerBaru,
               icon:'../assets/img/fire-512d.png',
               map: map,
               animation: google.maps.Animation.DROP,
             });
               console.log(latitude);
               console.log(longitude);
               markersDua.push(marker);
             map.setCenter(centerBaru);
             map.setZoom(18); 
             infowindow = new google.maps.InfoWindow({
             position: centerBaru,
             content: "<center><span style=color:black><b>Information</b><table><tr><center><img src='../file/pelaporan/"+media+"' width='100%'></center></tr><tr></tr><tr><td><i class='fa fa-home'></i>Tanggal</td><td>:</td><td> "+tanggal+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Alamat</td><td>:</td><td> "+lokasi+"</td></tr><br><tr></tr></table></span><br>",   
            pixelOffset: new google.maps.Size(0, -33)
             });
           infoDua.push(infowindow); 
           
           infowindow.open(map);
             
           }  
            
 
         }
       }); 
 }
function result()
{
  $("#result").show();
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
        detailinforepo(id144);
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
            <button type="button" onclick="viewreport()" class="btn btn-primary btn-sm " data-toggle="tooltip" title="Melihat Semua Pos" 
                                                        style="margin: 7px" style="margin-right: 7px;"><i class="fa fa-eye"></i>
                                                Check today's report</button>

          </ul>

          <ul class="nav navbar-nav navbar-right navbar-user">                     
            <li class="dropdown user-dropdown">
            <a href="logout.php" class="" ><i class="fa fa-sign-out"></i> Log Out</a>
            </li>
          </ul>
        </div><!-- /.navbar-collapse -->
      </nav>
      

