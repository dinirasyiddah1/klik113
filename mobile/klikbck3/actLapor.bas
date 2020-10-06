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
	Dim server ="http://f7d03047bae2.ngrok.io/klik113/mobile/"
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
	
	Private EditLat As EditText
	Private EditLon As EditText
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
	EditLat.Text = "" & Location1.Latitude
	EditLon.Text = "" & Location1.Longitude
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
	
	Dim lat As Double
	lat = EditLat.Text
	Log(lat)
	
	Dim lon As Double
	lon = EditLon.Text
	Log(lon)
	
	
	
	Dim id_kejadian As Int
	id_kejadian = 0
	Log(id_kejadian)
	
	Dim Job1 As HttpJob
	Job1.Initialize("Job1",Me)
	Job1.PostString(""&server&"laporkan.php","&nama_orang=" & nama_orang &"&lokasi="& lokasi &"&no_hp=" & no_hp &"&lat=" & lat &"&lon=" & lon &"&id_kejadian=" & id_kejadian)

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



Sub Activity_Click
	
End Sub