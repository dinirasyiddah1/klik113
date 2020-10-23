window.onload=initMap;
var map;
var server = "http://localhost/klik113/";
var infoDua = [];
var markers = [];
var markersDua = [] ;
var pos ='null';
var markersDua1 = [];
var circles=[];
var centerLokasi;
var infowindow;
var centerBaru ;
var rute = [];  //
var marker_1 = []; //MARKER UNTUK POSISI SAAT INIvar marker_2 = []; //MARKER UNTUK POSISI SAAT INI
var marker_2 = [];

function initMap(){
    basemap();
   kecamatan();
  //  kejadian();
  //  pos2();
  //  detailinfopos(id144);
  //  detailinfokej(id143)
}

function basemap() //google maps
{
    
    map = new google.maps.Map(document.getElementById('map'), 
        {
          zoom: 11,
          center: new google.maps.LatLng(-1.0025489,100.39846),
          mapTypeId: google.maps.MapTypeId.ROADMAP,    
        }); 

}

function aktifkanGeolocation(){ //posisi saat ini

            navigator.geolocation.getCurrentPosition(function(position) {
            //hapusMarkerInfowindow();
             hapusInfo();
              pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude

              };console.log(pos.lat);
                marker = new google.maps.Marker({
              position: pos,
              map: map,
              animation: google.maps.Animation.DROP,
              });
              centerLokasi = new google.maps.LatLng(pos.lat, pos.lng);
              markers.push(marker);
              infowindow = new google.maps.InfoWindow({
              position: pos,
              content: "<a style='color:black;'>You Are Here</a> "
              });
              infowindow.open(map, marker);
              map.setCenter(pos);
            });   
          }

function hapusRadius(){
  for(var i=0;i<circles.length;i++)
               {
                   circles[i].setMap(null);
               }
    circles=[];
  cekRadiusStatus = 'off';
  }

function manualLocation(){ //posisi manual
  hapusRadius();
  alert('Click the map');
  map.addListener('click', function(event) {
    addMarker(event.latLng);
    });
  }
  
    function addMarker(location){
    hapusposisi();
    marker = new google.maps.Marker({
      position : location,
      map: map,
      animation: google.maps.Animation.DROP,
      });
    pos = {
      lat: location.lat(), lng: location.lng()
    }
    centerLokasi = new google.maps.LatLng(pos.lat, pos.lng);
    markers.push(marker);
    infowindow = new google.maps.InfoWindow();
    infowindow.setContent('Current Position');
    infowindow.open(map, marker);
    usegeolocation=true;
    google.maps.event.clearListeners(map, 'click');
  console.log(pos);

}
function hapusposisi(){
  for (var i = 0; i < markers.length; i++){
    markers[i].setMap(null);
  }
  markers = [];
}

function panti() //tampil digitasi panti
    {
            pa = new google.maps.Data();
            pa.loadGeoJson(server+'panti.php');
            pa.setStyle(function(feature){
            return({
                    fillColor: '#42cb6f',
                    strokeColor: '#42cb6f',
                    strokeWeight: 1,
                    fillOpacity: 7
                   });          
              });
            pa.setMap(map);
        }

function kejadian(){
    kej = new google.maps.Data();
    kej.loadGeoJson(server+'include/datakejadian.php');
    kej.setStyle(function(feature)
    {
      //var id_kecamatan = feature.getProperty('id_kecamatan');
        color = 'red' 
        return({
          fillColor:color,
          strokeWeight:4.0,
          strokeColor:'orange',
          fillOpacity:0.9,
          clickable: false
        }); 
  } )
  ;
  kej.setMap(map); 
}

function pos2(){
  po = new google.maps.Data();
  po.loadGeoJson(server+'include/datapos.php');
  po.setStyle(function(feature)
  {
    //var id_kecamatan = feature.getProperty('id_kecamatan');
      color = 'yellow' 
      return({
        fillColor:color,
        strokeWeight:4.0,
        strokeColor:'orange',
        fillOpacity:0.9,
        clickable: false
      }); 
} )
;
po.setMap(map); 
}


function kecamatan(){
    kec = new google.maps.Data();
    kec.loadGeoJson(server+'kecamatan.php');
    kec.setStyle(function(feature)
    {
      var id_kecamatan = feature.getProperty('id_kecamatan');
      if (id_kecamatan == 1 ){ color = '#778899' 
        return({
          fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        }); 
    }
      else if(id_kecamatan == 2 ){ color = '#ffd777' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });
    }
      else if(id_kecamatan == 3 ){ color = '#ec87ec' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });

    }  
    else if(id_kecamatan == 4 ){ color = '#000080' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });

    } 
    else if(id_kecamatan == 5 ){ color = '#4C4CE0' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });

    }
    else if(id_kecamatan == 6 ){ color = '#CD853F' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });

    } 
    else if(id_kecamatan == 7 ){ color = '#EF3551' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });
    }
    else if(id_kecamatan == 8 ){ color = '#00FFFF' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });
    }
    else if(id_kecamatan == 9 ){ color = '#800000' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });
    }
    else if(id_kecamatan == 10 ){ color = '#32CD32' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });
    }
    else if(id_kecamatan == 11 ){ color = '#9932CC' 
        return({
        fillColor:color,
          strokeWeight:2.0,
          strokeColor:'black',
          fillOpacity:0.3,
          clickable: false
        });

    } 
    });
    kec.setMap(map); 
}

function tampilsemua(){ //menampilkan semua panti
    hapusMarkerTerdekat();
    $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
      clearroute();
    //clearangkot();
      hapusRadius();
      
  $.ajax({ url: server+'allpanti.php', data: "", dataType: 'json', success: function (rows){
      cari_panti(rows);
  }});

}

function tampil_hari_ini(){ //menampilkan kegiatan hari ini
    $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
      clearroute();
    //clearangkot();
      hapusRadius();
      hapusMarkerTerdekat();

  $.ajax({ url: server+'kegiatan_hari_ini.php', data: "", dataType: 'json', success: function (rows){
      hari_ini(rows);
  }});

} 

function cari_panti(rows) //fungsi cari panti
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
              var id   = row.id_panti;
              var nama   = row.nama;
              var latitude  = row.latitude ;
              var longitude = row.longitude ;
              centerBaru = new google.maps.LatLng(latitude, longitude);
              marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'src/images/marker1.png',
              map: map,
              animation: google.maps.Animation.DROP,
     
            });
            markersDua.push(marker);
           /*console.log(id);
              console.log(latitude);
              console.log(longitude);
              markersDua.push(marker);
              map.setCenter(centerBaru);*/

              /*infowindow = new google.maps.InfoWindow({
              //position: pos,
              //content: "<a style='color:black;'>Kegiatan Hari Ini</a> "
              });
              infoDua.push(infowindow); 
              infowindow.open(map, marker);
              //map.setCenter(pos);*/

    klikInfoWindow(id);
              map.setZoom(12);
              //$('#hasilcari1').show(); 
              $('#hasilcari1').append("<tr><td>"+id+"</td><td>&nbsp <a role='button' title='info' class='fa fa-info-circle' onclick='detailpanti_info(\""+id+"\")'></a></td></tr>");
            }
    }


function hari_ini(rows) //fungsi cari panti
  {   
     $('#hasilcari1').show();
    $('#hasilcari').empty();
    hapusInfo();
    hapusMarkerTerdekat();
     
            if(rows==null)
            {
              alert('Tidak Ada Kegiatan Sosial pada Panti Asuhan');
            }
        for (var i in rows) 
            {   
              var row     = rows[i];
              var id   = row.id_panti;
              var nama   = row.nama;
              var latitude  = row.latitude ;
              var longitude = row.longitude ;
              centerBaru = new google.maps.LatLng(latitude, longitude);
              marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'src/images/marker1.png',
              map: map,
              animation: google.maps.Animation.DROP,
     
            });
            console.log(id);
              console.log(latitude);
              console.log(longitude);
              markersDua.push(marker);
              map.setCenter(centerBaru);

              infowindow = new google.maps.InfoWindow({
              //position: pos,
              content: "<a style='color:black;'>Kegiatan Hari Ini</a> "
              });
              infoDua.push(infowindow); 
              infowindow.open(map, marker);
              //map.setCenter(pos);

    klikInfoWindow(id);
              map.setZoom(12);
              $('#hasilcari1').show(); 
              $('#hasilcari1').append("<tr><td>"+nama+"</td><td>&nbsp <a role='button' title='info' class='fa fa-info-circle' onclick='detailpanti_info(\""+id+"\")'></a></td></tr>");
            }
    }



function klikInfoWindow(id)
{
    google.maps.event.addListener(marker, "click", function(){
      detailinfopos(id144);
       
      });

}

function clickMarkerKej(centerBaru, id)
{
  
  var marker = new google.maps.Marker
    ({
      icon: "assets/img/fire-512d.png",
      position: centerBaru,
      map: map
    });
    markersDua.push(marker);
    
    google.maps.event.addListener(marker, "click", function(){
        detkej(id);
        detailinfokej(id);
       
      });

}


function detailpanti_info(id){  //menampilkan informasi Unit Medical
  
  $('#info').empty();
  hapusInfo();
  hapusMarkerTerdekat();
       $.ajax({ 
      url: server+'detailpanti.php?cari='+id, data: "", dataType: 'json', success: function(rows)
        { 
   console.log("hiaiii");
          console.log(id);
         for (var i in rows) 
          { 

            console.log('dd');
            var row = rows[i];
            var id = row.id_panti;
            var nama = row.nama;
            var alamat=row.alamat;
            var image = row.foto;
            var latitude  = row.latitude; 
            var longitude = row.longitude ;
            centerBaru = new google.maps.LatLng(row.latitude, row.longitude);
            marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'src/images/marker1.png',
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
            content: "<span style=color:black><center><b>Information</b><br></center><br><i class='fa fa-home'></i> "+nama+"<br><i class='fa fa-map-marker'></i> "+alamat+"<br><br><a role='button' title='tracking' class='fa fa-car' value='Route' onclick='callRoute(centerLokasi, centerBaru);rutetampil();'>&nbsp&nbsp<a role='button' href='"+server+"/detail.php?id="+id+"' title='gallery' class='fa fa-info' value='Info'> - Lihat Info</a></span>",
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


//cari berdasarkan nama panti
function carinamapanti(){
  $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
      clearroute();
    //clearangkot();
      hapusRadius();
      hapusMarkerTerdekat();
  caripanti = document.getElementById('caripanti');
  if(caripanti.value==''){
    alert("Fill the input form first!");
    }else{
  
    $.ajax({ url: server+'caripanti.php?cari_nama='+caripanti.value, data: "", dataType: 'json', success: function (rows){
      cari_panti(rows);
    }});
  }
}


//menampilkan checkbox fasilitas
function fasilitas(){
  
  $('#fasilitaslist .checkbox').remove();
  var v=fasilitaslist.value;
  $.ajax({ url: server+'fasilitas.php?id='+v, data: "", dataType: 'json', success: function(rows){
    for (var i in rows){
      console.log("hy");
      var row = rows[i];
      var id_fasilitas=row.id;
      var nama_fasilitas=row.fas;
      console.log(id_fasilitas);
      $('#fasilitaslist').append('<div class="checkbox" style="color: #f3fff4"><label><input type="checkbox" name="fasilitas" value="'+id_fasilitas+'">'+nama_fasilitas+'</label></div>');
    }
  }});
}

function carifasilitas(){

    $('#hasilcari1').show();
    $('#hasilcari1').empty();
      hapusInfo();
      clearroute2();
      clearroute();
    //clearangkot();
      hapusRadius();
      hapusMarkerTerdekat();
      var array = []
   var checkboxes = document.querySelectorAll('input[type=checkbox]:checked')

       for (var i = 0; i < checkboxes.length; i++) {
     array.push(checkboxes[i].value)
   }

   console.log(array);

   var jumlah_data=array.length;
   console.log(jumlah_data);
  // var fas=fasilitaslist.value;
/*  var arrayLay=[];
  // var d = $("input[name*='fasilitas']:checked")
  // alert(d.length);
  for(i=0;i<$("input[name*='cekboxfasilitas']:checked").length;i++){
    arrayLay.push($("input[name*='cekboxfasilitas']:checked")[i].value);
  }
  if (arrayLay==''){
    alert('Choose Facility !');
  }else{
    console.log("yuhuuuuuuuuu");
      // console.log(server+'carifasilitas.php?lay='+arrayLay);

*/  
    // console.log(server+'carifasilitas.php?lay='+array);  
    console.log(server+'carifasilitas.php?lay='+array);  
    $.ajax({ url: server+'carifasilitas.php?lay='+array, data: "", dataType: 'json', success: function(rows){
      console.log(rows.length);
      if(rows.length== 0)
            {
              alert('Data Tidak Ditemukan');
            }
        for (var i in rows) 
            {   
              var row     = rows[i];
              var id   = row.id_panti;
              var nama   = row.nama;
              var latitude  = row.latitude ;
              var longitude = row.longitude ;
              centerBaru = new google.maps.LatLng(latitude, longitude);
              marker = new google.maps.Marker
            ({
              position: centerBaru,
              icon:'src/images/marker1.png',
              map: map,
              animation: google.maps.Animation.DROP,
            });
            console.log(id);
              console.log(latitude);
              console.log(longitude);
              markersDua.push(marker);
              map.setCenter(centerBaru);
         klikInfoWindow(id);
              map.setZoom(14);
              $('#hasilcari1').append("<tr><td>"+nama+"</td><td>&nbsp<a role='button' title='info' class='fa fa-info-circle' onclick='detailpanti(\""+id+"\");info1();'></a></td></tr>");
            }

    }});
  /*}*/
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

function reset(){
  $("#hasilcari1").hide();

  hapusInfo();
  /*clearroute2();
  clearroute();*/
  hapusMarkerTerdekat();
  $("#att2").hide();
}

function hapusInfo() {
        for (var i = 0; i < infoDua.length; i++) {
              infoDua[i].setMap(null);
              }
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


function aktifkanRadius(){ //fungsi radius panti
    if (pos == 'null'){
    alert ('Click button current position or manual position first !');
    }
    else {
    hapusRadius();
    var inputradiusmes=document.getElementById("inputradiusmes").value;
  console.log(inputradiusmes);
    var circle = new google.maps.Circle({
      center: pos,
      radius: parseFloat(inputradiusmes*100),      
      map: map,
      strokeColor: "blue",
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: "blue",
      fillOpacity: 0.35
      });        
      map.setZoom(14);       
      map.setCenter(pos);
      circles.push(circle);     
    }   
    cekRadiusStatus = 'on';
    kejadianradius();
  }

function kejadianradius(){ //menampilkan kejadian berdasarkan radius
   
    $('#hasilcari1').show();
    $('#hasilcari1').empty();
    $('#hasilpencarian').empty();
      hapusInfo();
      clearroute2();
    clearroute();
    // clearangkot();
      hapusMarkerTerdekat();
      cekRadius();
    console.log(pos.lat);
      console.log(pos.lng);

        $.ajax({ 
        url: server+'kejadianradius.php?lat='+pos.lat+'&lng='+pos.lng+'&rad='+rad, data: "", dataType: 'json', success: function(rows)
        {
          
          $('#hasilcari1').append("<thead><th>Address</th><th>Action</th></thead>");
            console.log("rows");
            for (var i in rows) 
            {   
              var row     = rows[i];
              var id   = row.id;
              var nama   = row.name;
              var latitude  = row.latitude ;
              var longitude = row.longitude ;
              centerBaru = new google.maps.LatLng(latitude, longitude);
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
              klikInfoWindow(id);
              map.setZoom(14);
              $('#hasilcari1').append("<tr><td>"+nama+"</td><td><a role='button'  class='btn btn-success' onclick='detailpanti_info(\""+id+"\");info1();'>Show</a></td></tr>");
              // $('#hasilcari').append("<tr><td>"+nama+"</td><td><a role='button' class='btn btn-success' onclick='detailpanti_info(\""+id+"\");detailinfokejadian(\""+id+"\");'>Show</a></td></tr>");
         
            } 
            $('#hasilpencarian').append("<h5 class='box-title' id='hasilpencarian'>Result :</h5>"+rows.length);
      
          }    
          });
}

function resultt(){
  $("#result").show();
  $("#resultaround").hide();
  $("#eventt").hide();
  $("#infoo").hide();
  $("#att1").hide();
  $("#hide2").show();
  $("#showlist").hide();
  $("#radiuss").hide();
  $("#infoo1").hide();
  $("#att2").hide();
  $("#infoev").hide(); 
}

function cek()
        {
         document.getElementById('km').innerHTML=document.getElementById('inputradiusmes').value*100
        }

function cekRadius(){
          rad = inputradiusmes.value*100;
          console.log(rad);
          }

function rutetampil(){
  $("#att2").show();
  $("#att1").hide();
  $("#radiuss").hide();
  $("#infoo1").hide();
  $("#infoev").hide();
  $("#infoo").show();
}

function callRoute(start, end) {
      if (pos == 'null' || typeof(pos) == "undefined"){
    alert ('Please click button current position or button manual position first');
    }
    else
    {
       directionsService = new google.maps.DirectionsService;
       directionsDisplay = new google.maps.DirectionsRenderer;
         
    
      directionsService.route
      (
        {
            origin: start,
            destination: end,
            travelMode: google.maps.TravelMode.DRIVING
        }, 
        function(response, status) 
        {
            if (status === google.maps.DirectionsStatus.OK) 
            {
              directionsDisplay.setDirections(response);
            } 
            else 
            {
              window.alert('Directions request failed due to ' + status);
            }
          }
      );
      directionsDisplay.setMap(map);
      map.setZoom(16);
      $('#rute').append("<div class='box-body' style='max-height:350px;overflow:auto;'><div class='form-group' id='detailrute'></div></div></div>");
      directionsDisplay.setPanel(document.getElementById('detailrute'));
     }
 }


function legenda()
{
  $('#tombol').empty();
 $('#tombol').append('<a type="button" id="hidelegenda" onclick="hideLegenda()" class="btn btn-default btn-sm " data-toggle="tooltip"  style="margin-right: 7px;" ><i class="fa fa-eye-slash" style="color:black;"></i></a> ');
 
 var layer = new google.maps.FusionTablesLayer(
  {
          query: {
            select: 'Location',
            from: '1NIVOZxrr-uoXhpWSQH2YJzY5aWhkRZW0bWhfZw'
          },
          map: map
        });
       var legend = document.createElement('div');
        legend.id = 'legend';
        var content = [];
        content.push('<h4 style="color: black;">Legend Of Padang</h4>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#9932CC; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Koto Tangah</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#ffd777; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Pauh</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#800000; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Padang Utara</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#32CD32; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Bungus</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#00FFFF; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Padang Barat</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#4C4CE0; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Padang Timur</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#ec87ec; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Padang Selatan</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#000080; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Lubuk Begalung</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#EF3551; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Nanggalo</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#CD853F; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Kuranji</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#778899; height:10px;width:10px"></div><div class="col-sm-8" style="color: black;">Lubuk Kilangan</div></div>');
        
        legend.innerHTML = content.join('');
        legend.index = 1;
        map.controls[google.maps.ControlPosition.LEFT_BOTTOM].push(legend);
}

function hideLegenda() {
 $('#legend').remove();
 $('#tombol').empty();
 $('#tombol').append('<a type="button" id="showlegenda" onclick="legenda()" class="btn btn-default btn-sm " data-toggle="tooltip"  style="margin-right: 7px;" ><i class="fa fa-eye" style="color:black;"> </i></a> ');
}

function legendadis()
{
  $('#tomboldis').empty();
 $('#tomboldis').append('<a type="button" id="hidelegendadis" onclick="hidelegendadis()" class="btn btn-default btn-sm " data-toggle="tooltip"  style="margin-right: 7px;" ><i class="fa fa-eye-slash" style="color:black;"> View Legend</i></a> ');
 
 var layer = new google.maps.FusionTablesLayer(
  {
          query: {
            select: 'Location',
            from: '1NIVOZxrr-uoXhpWSQH2YJzY5aWhkRZW0bWhfZw'
          },
          map: map
        });
       var legend = document.createElement('div');
        legend.id = 'legend';
        var content = [];
        content.push('<h4 style="color: black;">FIre Incident Distribution</h4>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#32CD32; height:20px;width:50px"></div><div class="col-sm-8" style="color: black;">&nbsp;Very Low</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#ADFF2F; height:20px;width:50px"></div><div class="col-sm-8" style="color: black;">&nbsp;Low</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#FFFF00; height:20px;width:50px"></div><div class="col-sm-8" style="color: black;">&nbsp;Medium</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#FF8C00; height:20px;width:50px"></div><div class="col-sm-8" style="color: black;">&nbsp;High</div></div>');
        content.push('<div class="row"><div class="col-sm-4" style="background-color:#FF0000; height:20px;width:50px"></div><div class="col-sm-8" style="color: black;">&nbsp;Very High</div></div>');
        
        legend.innerHTML = content.join('');
        legend.index = 1;
        map.controls[google.maps.ControlPosition.LEFT_BOTTOM].push(legend);
}

function hidelegendadis() {
 $('#legend').remove();
 $('#tomboldis').empty();
 $('#tomboldis').append('<a type="button" id="showlegendadis" onclick="legendadis()" class="btn btn-default btn-sm " data-toggle="tooltip"  style="margin-right: 7px;" ><i class="fa fa-eye" style="color:black;"> View Legend</i></a> ');
}

// legenda pos
function legendadispos()
{
  $('#tomboldis').empty();
 $('#tomboldis').append('<a type="button" id="hidelegendadispos" onclick="hidelegendadispos()" class="btn btn-default btn-sm " data-toggle="tooltip"  style="margin-right: 7px;" ><i class="fa fa-eye-slash" style="color:black;"> View Legend</i></a> ');
 
 var layer = new google.maps.FusionTablesLayer(
  {
          query: {
            select: 'Location',
            from: '1NIVOZxrr-uoXhpWSQH2YJzY5aWhkRZW0bWhfZw'
          },
          map: map
        });
       var legend = document.createElement('div');
        legend.id = 'legend';
        var content = [];
        content.push('<h4 style="color: black;">Fire Station Distribution</h4>');
        content.push('<div class="row"><div class="col-sm-8" style="color: black;">Fire Station</div><div class="col-sm-4" style="background-color:#DC143C; height:20px;width:50px"></div></div>');
        content.push('<div class="row"><div class="col-sm-8" style="color: black;">No Fire Station</div><div class="col-sm-4" style="background-color:#E9967A; height:20px;width:50px"></div></div>');
        
        legend.innerHTML = content.join('');
        legend.index = 1;
        map.controls[google.maps.ControlPosition.LEFT_BOTTOM].push(legend);
}

function hidelegendadispos() {
 $('#legend').remove();
 $('#tomboldis').empty();
 $('#tomboldis').append('<a type="button" id="showlegendadispos" onclick="legendadispos()" class="btn btn-default btn-sm " data-toggle="tooltip"  style="margin-right: 7px;" ><i class="fa fa-eye" style="color:black;"> View Legend</i></a> ');
}



/*function printbulanan(){ //print bulanan
var thn = document.getElementById('yearbln').value;
var bln = document.getElementById('monthbln').value;
console.log(thn);
//console.log(bln);
window.location = server+'/laporan.php?bln='+bln+;
  $.ajax({ url: server+'/printbulanan.php?thn='+thn+'&bln='+bln, data: "", dataType: 'html', success: function (rows)
    {
      alert (' Data Successfully Showing');
  }});

} */


//detail info pos
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
     console.log(server+'detailinfopos.php?info='+id144)
      $.ajax({ 
     url: server+'detailinfopos.php?info='+id144, data: "", dataType: 'json', success: function(rows)
       { 
        for (var i in rows) 
         { 
           console.log('ddd');
           foto=null;
           var nama=null;
           var alamat=null;
           var row = rows[i];
           var id = row.id_pos_damkar;
           var nama = row.nama_pos;
           var alamat=row.alamat;
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
             markersDua.push(marker);
           map.setCenter(centerBaru);
           map.setZoom(18); 

               // $('#hasilcaridet').append("<tr><td><b>Open</b></td><td>:</td><td> "+open+"</td></tr><tr><td><b>Close</b></td><td>:</td><td> "+close+"</td></tr>");
               //$('#hasilcaridet').append("<tr><td colspan='2'> "+culinary+"</td><td> "+price+"</td></tr>");
               $('#hasilcaridet').append("<tr><td><b> Facility </b></td><td>:</td><td> "+nama+"</td></tr>");

               //$('#hasilcaridetpos').append("<tr><td><b> Culinary </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

           if (alamat==null)
                   {
                    alamat="tidak ada";
                   } 
                   if (foto=='null' || foto=='' || foto==null){
           foto='eror.png';
         } 
           $('#info').append("Nama : "+nama+" <br> Alamat : "+alamat+" <br> ");
         infowindow = new google.maps.InfoWindow({
           position: centerBaru,
           content: "<center><span style=color:black><b>Information</b><table><tr><td><i class='fa fa-home'></i>Nama</td><td>:</td><td> "+nama+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Alamat</td><td>:</td><td> "+alamat+"</td></tr><br></table></span><br><br>&nbsp&nbsp<input type='button' class='btn btn-info' value='Info' onclick='infopos(\""+id+"\")' />",   
           pixelOffset: new google.maps.Size(0, -33)
           });
         infoposisi.push(infowindow); 
         hapusInfo();
         infowindow.open(map);
           
         }  
          
           // ;ow();tampilsekitar()
       }
     }); 
     klikInfoWindow(id144)
}

function infopos(azzyy){    
  console.log(azzyy);
window.open(server+'pos_detail.php?id_pos_damkar='+azzyy);    
}


function infokej(azz){    
  console.log(azz);
window.open(server+'kejadian_detail.php?id_kejadian='+azz);    
}



//detail info kejadian
function detailinfokej(id143){  
  
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
     console.log(server+'detailinfokej.php?info='+id143)
      $.ajax({ 
     url: server+'detailinfokej.php?info='+id143, data: "", dataType: 'json', success: function(rows)
       { 
        for (var i in rows) 
         { 
           console.log('ddd');
           foto=null;
           var nama=null;
           var lokasi=null;
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
               $('#hasilcaridet').append("<tr><td><b> Facility </b></td><td>:</td><td> "+nama+"</td></tr>");

               //$('#hasilcaridetpos').append("<tr><td><b> Culinary </b></td><td>:</td><td> "+fasilitas+"</td></tr>");

           if (lokasi==null)
                   {
                    lokasi="tidak ada";
                   } 
                   if (foto=='null' || foto=='' || foto==null){
           foto='eror.png';
         } 
           $('#info').append("Nama : "+nama+" <br> lokasi : "+lokasi+" <br> ");
         infowindow = new google.maps.InfoWindow({
           position: centerBaru,
           content: "<center><span style=color:black><b>Information</b><table><tr><td><i class='fa fa-home'></i>Nama</td><td>:</td><td> "+nama+"</td></tr><br><tr><td><i class='fa fa-map-marker'></i>Lokasi</td><td>:</td><td> "+lokasi+"</td></tr><br></table></span><br><input type='button' class='btn btn-success' value='Radius' onclick='tampil_sekitar(\""+latitude+"\",\""+longitude+"\",\""+nama+"\")'<br>&nbsp&nbsp<input type='button' class='btn btn-info' value='Info' onclick='infokej(\""+id+"\")' />",   
           pixelOffset: new google.maps.Size(0, -33)
           });
         infoposisi.push(infowindow); 
         hapusInfo();
         infowindow.open(map);
           
         }  
          
           // ;ow();tampilsekitar()
       }
     }); 
     clickMarkerKej(id143)
}
