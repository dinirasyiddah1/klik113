B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.5
@EndOfDesignText@
#Region  Project Attributes 
#End Region

#Region  Activity Attributes 
#FullScreen: False
#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim server ="http://bb4427ef.ngrok.io/criminal_report/mobile/"
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	
'	LogTable1
	Private Panel2 As Panel
	Private Panel1 As Panel
	Private Button1 As Button
	Private Panel3 As Panel
	Private Panel5 As Panel
	Private Panel4 As Panel
	Private Label4 As Label
	Private Label6 As Label
	Private EditText5 As EditText
	Private Label7 As Label
	Private EditText6 As EditText
	Private Label1 As Label
	Private EditText1 As EditText
	Private Label2 As Label
	Private EditText2 As EditText
	Private Label3 As Label
	Private EditText3 As EditText
	Private Label5 As Label
	Private EditText4 As EditText



	Private Button2 As Button
	Dim id_terpilih As String
	Type id_lines (id_report As String)
	Dim arrayid(100) As String
	Private tampil_id="tampil_id" As String
	
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	
	Activity.LoadLayout("menu")

	Panel3.Visible = False
	Panel5.Visible = False
	Panel4.Visible = False
	Label4.Visible = False
	Label6.Visible = False
	EditText5.Visible = False
	Label7.Visible = False
	EditText6.Visible = False
	Label1.Visible = False
	EditText1.Visible = False
	Label2.Visible = False
	EditText2.Visible = False
	Label3.Visible = False
	EditText3.Visible = False
	Button2.Visible = False
	
	
End Sub

Sub Activity_Resume
	If Starter.GPS1.GPSEnabled = False Then
		ToastMessageShow("Please enable the GPS device.", True)
		StartActivity(Starter.GPS1.LocationSettingsIntent) 'Will open the relevant settings screen.
	Else
		Starter. rp.CheckAndRequest(Starter.rp.PERMISSION_ACCESS_FINE_LOCATION)
		Wait For Activity_PermissionResult (Permission As String, Result As Boolean)
		If Result Then CallSubDelayed(Starter, "StartGPS")
	End If
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	CallSubDelayed(Starter, "StopGPS")
End Sub

Public Sub GpsStatus (Satellites As List)
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append("Satellites:").Append(CRLF)
	For i = 0 To Satellites.Size - 1
		Dim Satellite As GPSSatellite = Satellites.Get(i)
		sb.Append(CRLF).Append(Satellite.Prn).Append($" $1.2{Satellite.Snr}"$).Append(" ").Append(Satellite.UsedInFix)
		sb.Append(" ").Append($" $1.2{Satellite.Azimuth}"$).Append($" $1.2{Satellite.Elevation}"$)
	Next
	'lblSatellites.Text = sb.ToString
End Sub

Public Sub LocationChanged(Location1 As Location)
	EditText5.Text = "" & Location1.Latitude
	EditText6.Text = "" & Location1.Longitude
	'lblSpeed.Text = $"Speed = $1.2{Location1.Speed} m/s "$
End Sub

Sub id_report
	ExecuteRemoteQuery("SELECT max(id_report) FROM report","tampil_id")
End Sub

Sub ExecuteRemoteQuery(Query As String, JobName As String)
	Dim Job As HttpJob
	Job.Initialize(JobName, Me)
	Job.PostString(""&server&"json.php",Query)
	
End Sub

Sub Button1_Click

	Panel3.Visible = True
	Panel5.Visible = True
	Panel4.Visible = True
	Label4.Visible = True
	Label6.Visible = True
	EditText5.Visible = True
	Label7.Visible = True
	EditText6.Visible = True
	Label1.Visible = True
	EditText1.Visible = True
	Label2.Visible = True
	EditText2.Visible = True
	Label3.Visible = True
	EditText3.Visible = True
	Label5.Visible = True
	EditText4.Visible = True
	Button2.Visible = True
	
	Panel2.Visible= False
	Panel1.Visible = False
	Button1.Visible = False
End Sub



Sub Button2_Click
	Dim name As String
	name = EditText1.Text
	Log(name)
	Dim no_hp As String
	no_hp=EditText2.Text
	Log(no_hp)
	Dim occupation As String
	occupation = EditText3.Text
	Log(occupation)

	Dim criminal_type As String
	criminal_type = EditText4.Text
	Log (criminal_type)
	Dim lat As String

	lat = EditText5. Text
	Log(lat)
	Dim lng As String
	lng = EditText6.Text
	Log(lng)
	
	DateTime.DateFormat = "yyyy-MM-dd"
	Dim date= DateTime.Date(DateTime.now)
	Log(date)
	DateTime.TimeFormat = "hh:mm"
	Dim time = DateTime.Time(DateTime.Now)
	Log (time)

	Dim id_criminal As Int
	id_criminal = 0
	Log(id_criminal)
	
	
	
	Dim Job1 As HttpJob
	Job1.Initialize("Job1",Me)
	Job1.PostString(""&server&"insertkejadian.php","&name=" & name &"&no_hp=" & no_hp &"&occupation=" & occupation &"&date=" & date &"&time=" & time  &"&criminal_type=" & criminal_type &"&lat=" & lat &"&lng=" & lng &"&id_criminal=" & id_criminal)
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

Sub Button3_Click
	StartActivity("status")
End Sub