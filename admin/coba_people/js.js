$(document).ready(function () { 

	var i = 0;  
	$('#myFunction').on( "click",  function()
	{    
    var nama = prompt("Silahkan Masukkan Nama", " ");
	  if (nama != null) {
	   var div = document.createElement("DIV");  
       div.setAttribute("id", "demo"+i);  
        div.setAttribute("class", "demobox"); 
 	   document.getElementById("arr_data_tabel_satu").appendChild(div);
 	
 	  var empty = document.createElement("SPAN");  
		empty.setAttribute("id", i); 
		empty.setAttribute("class", "remove"); 
		empty.onclick=delete_space;
		empty.innerHTML="remove ";
		document.getElementById("demo"+i).appendChild(empty);    
		document.getElementById(i).style.cursor="pointer";
 	
	   var ket = document.createElement("INPUT");
 		ket.setAttribute("type", "hidden");
 		ket.setAttribute("id", "ket"+i);
 		ket.setAttribute("placeholder", "NAMA DATA PADA TABEL SATU");
 		ket.setAttribute("name", "ket[]");    
 		ket.setAttribute("value", nama);
 		document.getElementById("demo"+i).appendChild(ket);  

		var capt = document.createElement("P");
		capt.setAttribute("id", "capt"+i);
		capt.innerHTML = nama;
		document.getElementById("demo"+i).appendChild(capt);  

	   var edit_div = document.createElement("DIV");  
       edit_div.setAttribute("id", "edit_div"+i);  
 	   document.getElementById("demo"+i).appendChild(edit_div);
 		
 		var edit = document.createElement("SPAN");  
		edit.setAttribute("id", i); 
		edit.setAttribute("class", "edit"); 
		edit.onclick=edit_space;
		edit.innerHTML="edit ";
		document.getElementById("edit_div"+i).appendChild(edit);    
		document.getElementById("edit_div"+i).style.cursor="pointer";
 		
		var data_satu_option = document.createElement("option");
		 data_satu_option.setAttribute("value", nama);
		 var data_capt = document.createTextNode(nama);
		 data_satu_option.appendChild(data_capt);    ;
		document.getElementById("arr_satu").appendChild(data_satu_option);
		
		i++;
	  }
	});
	function delete_space() {
 	//  alert(this.id); 
	 	var ket_val = document.getElementById("ket"+this.id).value;
	 	document.getElementById('demo'+this.id).remove();
	 	
	 	var selectobject = document.getElementById("arr_satu");
	 	//alert(selectobject.length);

		for (var i=0; i<selectobject.length; i++) {
	    if (selectobject.options[i].value == ket_val)
	    	  selectobject.remove(i);
		}
		
		var ch = document.getElementById('changes_div'+this.id);
		if(ch)
		{
			ch.remove()
		}
	}
	function edit_space() {
		var ket_val = document.getElementById("ket"+this.id).value;
	 	document.getElementById('ket'+this.id).setAttribute("type", "text");
	 	document.getElementById('capt'+this.id).style.display = "none";
	 	document.getElementById('edit_div'+this.id).style.display = "none";

	 	var nama = document.getElementById("ket"+this.id).value;
	 	var id = this.id;
	 	var changes_div = document.createElement("DIV");  
	    changes_div.setAttribute("id", "changes_div"+this.id);  
	 	document.getElementById("demo"+this.id).appendChild(changes_div);
	 		
	 		var changes = document.createElement("SPAN");  
			changes.setAttribute("id", "save_changes"+this.id); 
			changes.setAttribute("class", "changes"); 
			changes.onclick=function() { save_changes(nama, id); };
			changes.innerHTML="save shanges ";
			document.getElementById("changes_div"+this.id).appendChild(changes);    
			document.getElementById("changes_div"+this.id).style.cursor="pointer";
	 
 	}

 	function save_changes(nama, id) {
 
 	var ket_val = document.getElementById("ket"+id).value;

 	document.getElementById('ket'+id).setAttribute("type", "hidden");
	document.getElementById("capt"+id).innerHTML= ket_val; 
	document.getElementById('capt'+id).style.display = "block";
 	document.getElementById('capt'+id).style.display = "block";
 	document.getElementById('edit_div'+id).style.display = "block"; 
    document.getElementById('changes_div'+id).remove();
		
 	var selectobject = document.getElementById("arr_satu");
	for (var i=0; i<selectobject.length; i++) {
    if (selectobject.options[i].value == nama)
        selectobject.remove(i);
	}
 	var data_satu_option = document.createElement("option");
		 data_satu_option.setAttribute("value", ket_val);
	var data_capt = document.createTextNode(ket_val);
		 data_satu_option.appendChild(data_capt);    ;
		document.getElementById("arr_satu").appendChild(data_satu_option);
 
 	}
});
