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
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private cam As CamEx2
	Dim bmp As Bitmap = cam.DataToBitmap(Data)
	Private pnlPicture As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("lapor")
	viewPicture

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub viewPicture
	cam.DataToFile(Data, VideoFileDir, "1.jpg")
		pnlPicture.SetBackgroundImage(bmp.Resize(pnlPicture.Width, pnlPicture.Height, True)).Gravity = Gravity.CENTER
		
		
	
End Sub
