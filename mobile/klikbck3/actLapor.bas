B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim server ="http://27caa6b85e69.ngrok.io/klik113/mobile/"
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim lblLon As Label
	Dim lblLat As Label
	Private pnlBg As Panel
	Private pnlFile As Panel

	Private address As EditText
	Private name As EditText
	Private phone As EditText
	
	Private btnLapor As Button
	Type id_lines (id_laporan As String)
	Dim arrayid(100) As String
	Private tampil_id="tampil_id" As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("lapor")

	

End Sub

Sub Activity_Resume
	srvGPS.rp.CheckAndRequest(srvGPS.rp.PERMISSION_ACCESS_FINE_LOCATION)
	Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
	If Result Then CallSubDelayed(srvGPS, "StartGPS")
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Public Sub LocationChanged(Location1 As Location)
	lblLat.Text = "Lat = " & Location1.ConvertToMinutes(Location1.Latitude)
	lblLon.Text = "Lon = " & Location1.ConvertToMinutes(Location1.Longitude)
End Sub

Sub id_laporan
	ExecuteRemoteQuery("SELECT max(id_laporan) FROM detail_pelapor","tampil_id")
End Sub

Sub ExecuteRemoteQuery(Query As String, JobName As String)
	Dim Job As HttpJob
	Job.Initialize(JobName, Me)
	Job.PostString(""&server&"json.php",Query)
	
End Sub

Sub btnLapor_Click
	Dim lokasi As String
	lokasi = address.Text
	Log(lokasi)
	
	Dim nama_orang As String
	nama_orang = name.Text
	Log(nama_orang)
	
	Dim no_hp As String
	no_hp = phone.Text
	Log(no_hp)
	
	Dim lat As String
	lat = lblLat.Text
	Log(lat)
	
	Dim lon As String
	lon = lblLon.Text
	Log(lon)
	
	DateTime.DateFormat = "yyyy-MM-dd"
	Dim tanggal= DateTime.Date(DateTime.now)
	Log(tanggal)
	
	DateTime.TimeFormat = "hh:mm"
	Dim jam = DateTime.Time(DateTime.Now)
	Log (jam)
	
	Dim id_kejadian As Int
	id_kejadian = 0
	Log(id_kejadian)
	
	Dim Job1 As HttpJob
	Job1.Initialize("Job1",Me)
	Job1.PostString(""&server&"laporkan.php","&nama_orang=" & nama_orang &"&lokasi="& lokasi &"&no_hp=" & no_hp &"&tanggal=" & tanggal &"&jam=" & jam  &"&lat=" & lat &"&lon=" & lon &"&id_kejadian=" & id_kejadian)

End Sub

Sub JobDone (Job1 As HttpJob)
	Log("JobName = " & Job1.JobName & ", Success = " & Job1.Success)
	If Job1.Success = True Then
		Select Job1.JobName
			Case "Job1"
				'print the result to the logs
				Log("behasil")
				Msgbox("Report Data Success","Success")
				'StartActivity("all_criminal")

			
		End Select
	Else
		Log("Error: " & Job1.ErrorMessage)
		ToastMessageShow("Error: " & Job1.ErrorMessage, True)
	End If
	Job1.Release
End Sub

Sub jobdone1 (Job As HttpJob)
	ProgressDialogHide
	If Job.Success Then
		Dim res As String
		Log("response :" &res)
		Dim parser As JSONParser
		parser.Initialize(res)
		Select Job.JobName
			Case tampil_id
				Dim array_id As List
				array_id = parser.NextArray
				For i=0 To array_id.Size -1
					Dim m As Map
					m = array_id.Get(i)
					Dim f As id_lines
					f.Initialize
					f.id_laporan= m.Get("id_laporan")
					arrayid (i) =f.id_laporan
	
				Next
				
		End Select
	End If
	
End Sub