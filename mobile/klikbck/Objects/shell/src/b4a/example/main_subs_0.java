package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,43);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"start\")";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("start")),main.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="VideoFileDir = rp.GetSafeDirDefaultExternal(\"\")";
Debug.ShouldStop(8192);
main._videofiledir = main._rp.runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 47;BA.debugLine="VideoFileName = \"1.mp4\"";
Debug.ShouldStop(16384);
main._videofilename = BA.ObjectToString("1.mp4");
 BA.debugLineNum = 48;BA.debugLine="Activity.LoadLayout(\"kamera\")";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("kamera")),main.mostCurrent.activityBA);
 BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"StillPicture\")";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("StillPicture")),main.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="cam.Initialize(pnlCamera)";
Debug.ShouldStop(131072);
main.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pnlcamera));
 BA.debugLineNum = 51;BA.debugLine="Log(cam.SupportedHardwareLevel)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("LogImpl","6131080",main.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_getsupportedhardwarelevel" /*RemoteObject*/ ),0);
 BA.debugLineNum = 52;BA.debugLine="buttons = Array(btnAutoExposure, btnMode)";
Debug.ShouldStop(524288);
main.mostCurrent._buttons = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(main.mostCurrent._btnautoexposure.getObject()),(main.mostCurrent._btnmode.getObject())})));
 BA.debugLineNum = 53;BA.debugLine="SetState(False, False, VideoMode)";
Debug.ShouldStop(1048576);
_setstate(main.mostCurrent.__c.getField(true,"False"),main.mostCurrent.__c.getField(true,"False"),main._videomode);
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,81);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 81;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,56);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(16777216);
_opencamera(main._frontcamera);
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnreport_click() throws Exception{
try {
		Debug.PushSubsStack("btnReport_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,86);
if (RapidSub.canDelegate("btnreport_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","btnreport_click");}
 BA.debugLineNum = 86;BA.debugLine="Sub btnReport_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="StartActivity(actKamera)";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._actkamera.getObject())));
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private cam As CamEx2";
main.mostCurrent._cam = RemoteObject.createNew ("b4a.example.camex2");
 //BA.debugLineNum = 29;BA.debugLine="Private pnlCamera As Panel";
main.mostCurrent._pnlcamera = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private pnlPicture As Panel";
main.mostCurrent._pnlpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private pnlBackground As Panel";
main.mostCurrent._pnlbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private buttons As List";
main.mostCurrent._buttons = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 34;BA.debugLine="Private btnAutoExposure As Button";
main.mostCurrent._btnautoexposure = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private ProgressBar1 As ProgressBar";
main.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private openstate, busystate As Boolean";
main._openstate = RemoteObject.createImmutable(false);
main._busystate = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 37;BA.debugLine="Private btnRecord As Button";
main.mostCurrent._btnrecord = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private btnMode As Button";
main.mostCurrent._btnmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private btnCamera As Button";
main.mostCurrent._btncamera = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private barZoom As SeekBar";
main.mostCurrent._barzoom = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _opencamera(RemoteObject _front) throws Exception{
try {
		Debug.PushSubsStack("OpenCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
if (RapidSub.canDelegate("opencamera")) { b4a.example.main.remoteMe.runUserSub(false, "main","opencamera", _front); return;}
ResumableSub_OpenCamera rsub = new ResumableSub_OpenCamera(null,_front);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_OpenCamera extends BA.ResumableSub {
public ResumableSub_OpenCamera(b4a.example.main parent,RemoteObject _front) {
this.parent = parent;
this._front = _front;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.main parent;
RemoteObject _front;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _taskindex = RemoteObject.createImmutable(0);
RemoteObject _preparesurface = RemoteObject.createImmutable("");
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("OpenCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,60);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("front", _front);
 BA.debugLineNum = 61;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
Debug.ShouldStop(268435456);
parent._rp.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(parent._rp.getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 62;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "opencamera"), null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 63;BA.debugLine="If Result = False Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",_result,parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 64;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 65;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 68;BA.debugLine="SetState(False, False, VideoMode)";
Debug.ShouldStop(8);
_setstate(parent.mostCurrent.__c.getField(true,"False"),parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 69;BA.debugLine="Wait For (cam.OpenCamera(front)) Complete (TaskIn";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "opencamera"), parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_opencamera" /*RemoteObject*/ ,(Object)(_front)));
this.state = 14;
return;
case 14:
//C
this.state = 5;
_taskindex = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("TaskIndex", _taskindex);
;
 BA.debugLineNum = 70;BA.debugLine="If TaskIndex > 0 Then";
Debug.ShouldStop(32);
if (true) break;

case 5:
//if
this.state = 8;
if (RemoteObject.solveBoolean(">",_taskindex,BA.numberCast(double.class, 0))) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 71;BA.debugLine="MyTaskIndex = TaskIndex 'hold this index. It wil";
Debug.ShouldStop(64);
parent._mytaskindex = _taskindex;
 BA.debugLineNum = 72;BA.debugLine="Wait For(PrepareSurface) Complete (Success As Bo";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "opencamera"), (_preparesurface));
this.state = 15;
return;
case 15:
//C
this.state = 8;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 if (true) break;

case 8:
//C
this.state = 9;
;
 BA.debugLineNum = 74;BA.debugLine="Log(\"Start success: \" & Success)";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","64849678",RemoteObject.concat(RemoteObject.createImmutable("Start success: "),_success),0);
 BA.debugLineNum = 75;BA.debugLine="SetState(Success, False, VideoMode)";
Debug.ShouldStop(1024);
_setstate(_success,parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 76;BA.debugLine="If Success = False Then";
Debug.ShouldStop(2048);
if (true) break;

case 9:
//if
this.state = 12;
if (RemoteObject.solveBoolean("=",_success,parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"Failed to open camera\", True)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Failed to open camera")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static void  _complete(RemoteObject _taskindex) throws Exception{
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
actkamera_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
actkamera.myClass = BA.getDeviceClass ("b4a.example.actkamera");
camex2.myClass = BA.getDeviceClass ("b4a.example.camex2");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private frontCamera As Boolean = False";
main._frontcamera = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 19;BA.debugLine="Private VideoMode As Boolean = False";
main._videomode = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 20;BA.debugLine="Private VideoFileDir, VideoFileName As String";
main._videofiledir = RemoteObject.createImmutable("");
main._videofilename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="Private MyTaskIndex As Int";
main._mytaskindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 22;BA.debugLine="Private rp As RuntimePermissions";
main._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstate(RemoteObject _open,RemoteObject _busy,RemoteObject _video) throws Exception{
try {
		Debug.PushSubsStack("SetState (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,90);
if (RapidSub.canDelegate("setstate")) { return b4a.example.main.remoteMe.runUserSub(false, "main","setstate", _open, _busy, _video);}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _btnrecordtext = RemoteObject.createImmutable("");
Debug.locals.put("Open", _open);
Debug.locals.put("Busy", _busy);
Debug.locals.put("Video", _video);
 BA.debugLineNum = 90;BA.debugLine="Sub SetState(Open As Boolean, Busy As Boolean, Vid";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="For Each b As Button In buttons";
Debug.ShouldStop(67108864);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
{
final RemoteObject group1 = main.mostCurrent._buttons;
final int groupLen1 = group1.runMethod(true,"getSize").<Integer>get()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_b.setObject(group1.runMethod(false,"Get",index1));
Debug.locals.put("b", _b);
 BA.debugLineNum = 92;BA.debugLine="b.Visible = Open And Not(Busy)";
Debug.ShouldStop(134217728);
_b.runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean(".",_open) && RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy)))));
 }
}Debug.locals.put("b", _b);
;
 BA.debugLineNum = 94;BA.debugLine="btnCamera.Visible = Not(Busy)";
Debug.ShouldStop(536870912);
main.mostCurrent._btncamera.runMethod(true,"setVisible",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy)));
 BA.debugLineNum = 95;BA.debugLine="btnRecord.Visible = Open And (Video Or Not(Busy))";
Debug.ShouldStop(1073741824);
main.mostCurrent._btnrecord.runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean(".",_open) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean(".",_video) || RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy))))))));
 BA.debugLineNum = 96;BA.debugLine="openstate = Open";
Debug.ShouldStop(-2147483648);
main._openstate = _open;
 BA.debugLineNum = 97;BA.debugLine="ProgressBar1.Visible = Busy";
Debug.ShouldStop(1);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",_busy);
 BA.debugLineNum = 98;BA.debugLine="busystate = Busy";
Debug.ShouldStop(2);
main._busystate = _busy;
 BA.debugLineNum = 99;BA.debugLine="VideoMode = Video";
Debug.ShouldStop(4);
main._videomode = _video;
 BA.debugLineNum = 100;BA.debugLine="barZoom.Visible = Open";
Debug.ShouldStop(8);
main.mostCurrent._barzoom.runMethod(true,"setVisible",_open);
 BA.debugLineNum = 101;BA.debugLine="Dim btnRecordText As String";
Debug.ShouldStop(16);
_btnrecordtext = RemoteObject.createImmutable("");Debug.locals.put("btnRecordText", _btnrecordtext);
 BA.debugLineNum = 102;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(32);
if (main._videomode.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 103;BA.debugLine="If Busy Then";
Debug.ShouldStop(64);
if (_busy.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 104;BA.debugLine="btnRecordText = Chr(0xF04D)";
Debug.ShouldStop(128);
_btnrecordtext = BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf04d))));Debug.locals.put("btnRecordText", _btnrecordtext);
 }else {
 BA.debugLineNum = 106;BA.debugLine="btnRecordText = Chr(0xF03D)";
Debug.ShouldStop(512);
_btnrecordtext = BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf03d))));Debug.locals.put("btnRecordText", _btnrecordtext);
 };
 }else {
 BA.debugLineNum = 109;BA.debugLine="btnRecordText = Chr(0xF030)";
Debug.ShouldStop(4096);
_btnrecordtext = BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf030))));Debug.locals.put("btnRecordText", _btnrecordtext);
 };
 BA.debugLineNum = 111;BA.debugLine="btnRecord.Text = btnRecordText";
Debug.ShouldStop(16384);
main.mostCurrent._btnrecord.runMethod(true,"setText",BA.ObjectToCharSequence(_btnrecordtext));
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}