<!DOCTYPE html>
<html>
<head>
	<title>dini</title>
	<style>
	.demobox{
		border: 1px dotted gray;
		padding: 20px;
		margin: 20px;
	}
	.spacey{
		padding: 3px;
	}
	.remove{
		color: red;
	}
	.edit{
		color: orange;
	}
	.changes{
		color: skyblue;
	}
</style>
	</head>
<body>
	<div style="padding: 20px;">
	<h3>Input data </h3>
	<button id="myFunction">Add Data Tabel Satu</button>
	<div class="spacey"></div>
	<div class="spacey"></div>
	<div id="arr_data_tabel_satu">
	</div>
	<br>
	<div style="padding-left: 10px;">
	<form action="save_data.php" method="post">		
	<select id="arr_satu" multiple="true" name="arr_satu[]">
	<option value="" disabled="" selected="true">Pilih Data Satu</option>
    </select>
	 <div class="spacey"></div>
	 <input type="text" name="detail_data" placeholder="Keterangan Data" required="true">
    <input type="submit" value="Simpan">					
			
	</form>
	</div>
	</div>
	<script src="jquery-1.8.3.min.js"></script>
	<script src="js.js"></script>

</body>
</html>