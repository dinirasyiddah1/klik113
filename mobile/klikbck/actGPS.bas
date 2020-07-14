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

End Sub

Sub Globals
	Dim lblLon As Label
	Dim lblLat As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("gps")

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
