<!DOCTYPE html>
<html>
<head>
	<?php include('include/head.php'); 
		  include('connect.php');
	?>
</head>
<body>
	
	<?php include('include/sidebar.php'); 
	//ambil get
    $id=$_GET['id_pos_damkar'];
	//bikin string 
    
    $sql=pg_query("SELECT * FROM public.pos_damkar WHERE id_pos_damkar='$id'")or die(pg_error());
	
	//tampilakan data
	$data = pg_fetch_assoc($sql);
	?>
    <div id="wrapper">
    <div class="panel-body">
	<div class="main-container">
		<div class="pd-ltr-20 customscroll customscroll-10-p height-100-p xs-pd-20-10">
			<div class="min-height-200px">
				<div class="page-header">
				<div class="row clearfix">
				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 mb-30">
					<div class="bg-white pd-20 box-shadow border-radius-5 height-100-p">
						<!-- <h4 class="mb-20">Recent Messages</h4> -->
						<div class="notification-list mx-h-450 customscroll">
							<ul>
								<div class="col-sm-12" id="hide2"> <!-- menampilkan data detail panti-->
									<table>
									<tbody  style='vertical-align:top;'>
                                        <tr><td width="220px"><b>&nbsp; Fire Station ID</b></td><td> :&nbsp; </td><td style='text-transform:capitalize;'><?php echo $data['id_pos_damkar'] ?></td></tr>
										<tr><td width="220px"><b>&nbsp; Fire Station Name</b></td><td> :&nbsp; </td><td style='text-transform:capitalize;'><?php echo $data['nama_pos'] ?></td></tr>
										<tr><td><b>&nbsp; Address</b></td><td>:</td><td><?php echo $data['alamat'] ?> </td></tr>
										
									</tbody>
									</table>
								<br>
					                        	<table>
					                        		<tbody>
					                        			<tr><td><b>&nbsp; &nbsp;<img src="../image/fire station/<?php echo $data['image']; ?>" style="width:450px;height:350px;"></td></tr>
					                        		</tbody>	
					                        	</table>		
					                        </div>				
					                    </div>
					                </section>
					            </div>
					        </ul>
					    </div>
					</div>
				</div>
			</div>
            </div>
            </div>
			
		</div>
	</div>
	
</body>
</html>