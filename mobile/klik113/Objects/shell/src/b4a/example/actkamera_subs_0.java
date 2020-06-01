package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actkamera_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,35);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 38;BA.debugLine="VideoFileDir = rp.GetSafeDirDefaultExternal(\"\")";
Debug.ShouldStop(32);
actkamera._videofiledir = actkamera._rp.runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 39;BA.debugLine="VideoFileName = \"1.mp4\"";
Debug.ShouldStop(64);
actkamera._videofilename = BA.ObjectToString("1.mp4");
 BA.debugLineNum = 40;BA.debugLine="Activity.LoadLayout(\"kamera\")";
Debug.ShouldStop(128);
actkamera.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("kamera")),actkamera.mostCurrent.activityBA);
 BA.debugLineNum = 41;BA.debugLine="Activity.LoadLayout(\"StillPicture\")";
Debug.ShouldStop(256);
actkamera.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("StillPicture")),actkamera.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="cam.Initialize(pnlCamera)";
Debug.ShouldStop(512);
actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_initialize" /*RemoteObject*/ ,actkamera.mostCurrent.activityBA,(Object)(actkamera.mostCurrent._pnlcamera));
 BA.debugLineNum = 43;BA.debugLine="Log(cam.SupportedHardwareLevel)";
Debug.ShouldStop(1024);
actkamera.mostCurrent.__c.runVoidMethod ("LogImpl","0917512",actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_getsupportedhardwarelevel" /*RemoteObject*/ ),0);
 BA.debugLineNum = 44;BA.debugLine="buttons = Array(btnAutoExposure, btnMode)";
Debug.ShouldStop(2048);
actkamera.mostCurrent._buttons = actkamera.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(actkamera.mostCurrent._btnautoexposure.getObject()),(actkamera.mostCurrent._btnmode.getObject())})));
 BA.debugLineNum = 45;BA.debugLine="SetState(False, False, VideoMode)";
Debug.ShouldStop(4096);
_setstate(actkamera.mostCurrent.__c.getField(true,"False"),actkamera.mostCurrent.__c.getField(true,"False"),actkamera._videomode);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Pause (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,97);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 97;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 98;BA.debugLine="cam.Stop";
Debug.ShouldStop(2);
actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_stop" /*RemoteObject*/ );
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,51);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","activity_resume");}
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(524288);
_opencamera(actkamera._frontcamera);
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _barzoom_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("barZoom_ValueChanged (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,227);
if (RapidSub.canDelegate("barzoom_valuechanged")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","barzoom_valuechanged", _value, _userchanged);}
RemoteObject _originalsize = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _zoom = RemoteObject.createImmutable(0f);
RemoteObject _crop = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _newwidth = RemoteObject.createImmutable(0);
RemoteObject _newheight = RemoteObject.createImmutable(0);
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 227;BA.debugLine="Sub barZoom_ValueChanged (Value As Int, UserChange";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="Dim OriginalSize As Rect = cam.ActiveArraySize";
Debug.ShouldStop(8);
_originalsize = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
_originalsize = actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_getactivearraysize" /*RemoteObject*/ );Debug.locals.put("OriginalSize", _originalsize);Debug.locals.put("OriginalSize", _originalsize);
 BA.debugLineNum = 229;BA.debugLine="Dim Zoom As Float = 1 + Value / 100 * (cam.MaxDig";
Debug.ShouldStop(16);
_zoom = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),_value,RemoteObject.createImmutable(100),(RemoteObject.solve(new RemoteObject[] {actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_getmaxdigitalzoom" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 0))}, "+/*",1, 0));Debug.locals.put("Zoom", _zoom);Debug.locals.put("Zoom", _zoom);
 BA.debugLineNum = 230;BA.debugLine="Dim Crop As Rect";
Debug.ShouldStop(32);
_crop = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("Crop", _crop);
 BA.debugLineNum = 231;BA.debugLine="Dim NewWidth As Int = OriginalSize.Width / Zoom";
Debug.ShouldStop(64);
_newwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getWidth"),_zoom}, "/",0, 0));Debug.locals.put("NewWidth", _newwidth);Debug.locals.put("NewWidth", _newwidth);
 BA.debugLineNum = 232;BA.debugLine="Dim NewHeight As Int = OriginalSize.Height / Zoom";
Debug.ShouldStop(128);
_newheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getHeight"),_zoom}, "/",0, 0));Debug.locals.put("NewHeight", _newheight);Debug.locals.put("NewHeight", _newheight);
 BA.debugLineNum = 233;BA.debugLine="Crop.Initialize(OriginalSize.CenterX - NewWidth /";
Debug.ShouldStop(256);
_crop.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterX"),_newwidth,RemoteObject.createImmutable(2)}, "-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterY"),_newheight,RemoteObject.createImmutable(2)}, "-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterX"),_newwidth,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterY"),_newheight,RemoteObject.createImmutable(2)}, "+/",1, 0))));
 BA.debugLineNum = 235;BA.debugLine="cam.PreviewCropRegion = Crop";
Debug.ShouldStop(1024);
actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_setpreviewcropregion",_crop);
 BA.debugLineNum = 236;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(2048);
actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(actkamera._mytaskindex),(Object)(actkamera._videomode));
 BA.debugLineNum = 237;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnautoexposure_click() throws Exception{
try {
		Debug.PushSubsStack("btnAutoExposure_Click (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,193);
if (RapidSub.canDelegate("btnautoexposure_click")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","btnautoexposure_click");}
RemoteObject _flashes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 193;BA.debugLine="Sub btnAutoExposure_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="Dim flashes As List = cam.SupportedAutoExposureMo";
Debug.ShouldStop(2);
_flashes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_flashes = actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_getsupportedautoexposuremodes" /*RemoteObject*/ );Debug.locals.put("flashes", _flashes);Debug.locals.put("flashes", _flashes);
 BA.debugLineNum = 195;BA.debugLine="Dim i As Int = flashes.IndexOf(cam.AutoExposureMo";
Debug.ShouldStop(4);
_i = _flashes.runMethod(true,"IndexOf",(Object)((actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_getautoexposuremode" /*RemoteObject*/ ))));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 196;BA.debugLine="i = (i + 1) Mod flashes.Size";
Debug.ShouldStop(8);
_i = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1)),_flashes.runMethod(true,"getSize")}, "%",0, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 197;BA.debugLine="cam.AutoExposureMode = flashes.Get(i)";
Debug.ShouldStop(16);
actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_setautoexposuremode" /*RemoteObject*/ ,BA.ObjectToString(_flashes.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 198;BA.debugLine="btnAutoExposure.Text = flashes.Get(i)";
Debug.ShouldStop(32);
actkamera.mostCurrent._btnautoexposure.runMethod(true,"setText",BA.ObjectToCharSequence(_flashes.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 199;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(64);
actkamera.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(actkamera._mytaskindex),(Object)(actkamera._videomode));
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncamera_click() throws Exception{
try {
		Debug.PushSubsStack("btnCamera_Click (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,92);
if (RapidSub.canDelegate("btncamera_click")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","btncamera_click");}
 BA.debugLineNum = 92;BA.debugLine="Sub btnCamera_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="frontCamera = Not(frontCamera)";
Debug.ShouldStop(268435456);
actkamera._frontcamera = actkamera.mostCurrent.__c.runMethod(true,"Not",(Object)(actkamera._frontcamera));
 BA.debugLineNum = 94;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(536870912);
_opencamera(actkamera._frontcamera);
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btnmode_click() throws Exception{
try {
		Debug.PushSubsStack("btnMode_Click (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,101);
if (RapidSub.canDelegate("btnmode_click")) { b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","btnmode_click"); return;}
ResumableSub_btnMode_Click rsub = new ResumableSub_btnMode_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnMode_Click extends BA.ResumableSub {
public ResumableSub_btnMode_Click(b4a.example.actkamera parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actkamera parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnMode_Click (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,101);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 102;BA.debugLine="VideoMode = Not(VideoMode)";
Debug.ShouldStop(32);
parent._videomode = parent.mostCurrent.__c.runMethod(true,"Not",(Object)(parent._videomode));
 BA.debugLineNum = 103;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(64);
if (true) break;

case 1:
//if
this.state = 8;
if (parent._videomode.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 104;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECORD_AUDIO)";
Debug.ShouldStop(128);
parent._rp.runVoidMethod ("CheckAndRequest",actkamera.processBA,(Object)(parent._rp.getField(true,"PERMISSION_RECORD_AUDIO")));
 BA.debugLineNum = 105;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "btnmode_click"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 106;BA.debugLine="If Result = False Then";
Debug.ShouldStop(512);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_result,parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 108;BA.debugLine="VideoMode = False";
Debug.ShouldStop(2048);
parent._videomode = parent.mostCurrent.__c.getField(true,"False");
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 BA.debugLineNum = 111;BA.debugLine="SetState(openstate, busystate, VideoMode)";
Debug.ShouldStop(16384);
_setstate(parent._openstate,parent._busystate,parent._videomode);
 BA.debugLineNum = 112;BA.debugLine="PrepareSurface";
Debug.ShouldStop(32768);
_preparesurface();
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
public static RemoteObject  _btnrecord_click() throws Exception{
try {
		Debug.PushSubsStack("btnRecord_Click (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,115);
if (RapidSub.canDelegate("btnrecord_click")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","btnrecord_click");}
 BA.debugLineNum = 115;BA.debugLine="Sub btnRecord_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(524288);
if (actkamera._videomode.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 117;BA.debugLine="CaptureVideo";
Debug.ShouldStop(1048576);
_capturevideo();
 }else {
 BA.debugLineNum = 119;BA.debugLine="TakePicture";
Debug.ShouldStop(4194304);
_takepicture();
 };
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _capturevideo() throws Exception{
try {
		Debug.PushSubsStack("CaptureVideo (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,124);
if (RapidSub.canDelegate("capturevideo")) { b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","capturevideo"); return;}
ResumableSub_CaptureVideo rsub = new ResumableSub_CaptureVideo(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_CaptureVideo extends BA.ResumableSub {
public ResumableSub_CaptureVideo(b4a.example.actkamera parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actkamera parent;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("CaptureVideo (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,124);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 125;BA.debugLine="Try";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//try
this.state = 12;
this.catchState = 11;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 4;
this.catchState = 11;
 BA.debugLineNum = 126;BA.debugLine="SetState(openstate, True, VideoMode)";
Debug.ShouldStop(536870912);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"True"),parent._videomode);
 BA.debugLineNum = 127;BA.debugLine="If cam.RecordingVideo = False Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 4:
//if
this.state = 9;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._cam.getField(true,"_recordingvideo" /*RemoteObject*/ ),parent.mostCurrent.__c.getField(true,"False"))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
 BA.debugLineNum = 128;BA.debugLine="cam.StartVideoRecording (MyTaskIndex)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_startvideorecording" /*RemoteObject*/ ,(Object)(parent._mytaskindex));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 130;BA.debugLine="cam.StopVideoRecording (MyTaskIndex)";
Debug.ShouldStop(2);
parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_stopvideorecording" /*RemoteObject*/ ,(Object)(parent._mytaskindex));
 BA.debugLineNum = 131;BA.debugLine="File.Copy(VideoFileDir, \"temp-\" & VideoFileName";
Debug.ShouldStop(4);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent._videofiledir),(Object)(RemoteObject.concat(RemoteObject.createImmutable("temp-"),parent._videofilename)),(Object)(parent._videofiledir),(Object)(parent._videofilename));
 BA.debugLineNum = 132;BA.debugLine="ToastMessageShow($\"Video file saved: $1.2{File.";
Debug.ShouldStop(8);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Video file saved: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("1.2")),(Object)((RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Size",(Object)(parent._videofiledir),(Object)(parent._videofilename)),RemoteObject.createImmutable(1024),RemoteObject.createImmutable(1024)}, "//",0, 0)))),RemoteObject.createImmutable(" MB"))))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 133;BA.debugLine="Wait For (PrepareSurface) Complete (Success As";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "capturevideo"), _preparesurface());
this.state = 13;
return;
case 13:
//C
this.state = 9;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 134;BA.debugLine="SetState(openstate, False, VideoMode)";
Debug.ShouldStop(32);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 if (true) break;

case 9:
//C
this.state = 12;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 0;
 BA.debugLineNum = 138;BA.debugLine="HandleError(LastException)";
Debug.ShouldStop(512);
_handleerror(parent.mostCurrent.__c.runMethod(false,"LastException",actkamera.mostCurrent.activityBA));
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",actkamera.processBA, e0.toString());}
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
public static void  _complete(RemoteObject _success) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private cam As CamEx2";
actkamera.mostCurrent._cam = RemoteObject.createNew ("b4a.example.camex2");
 //BA.debugLineNum = 21;BA.debugLine="Private pnlCamera As Panel";
actkamera.mostCurrent._pnlcamera = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private pnlPicture As Panel";
actkamera.mostCurrent._pnlpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private pnlBackground As Panel";
actkamera.mostCurrent._pnlbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private buttons As List";
actkamera.mostCurrent._buttons = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 26;BA.debugLine="Private btnAutoExposure As Button";
actkamera.mostCurrent._btnautoexposure = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private ProgressBar1 As ProgressBar";
actkamera.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private openstate, busystate As Boolean";
actkamera._openstate = RemoteObject.createImmutable(false);
actkamera._busystate = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 29;BA.debugLine="Private btnRecord As Button";
actkamera.mostCurrent._btnrecord = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnMode As Button";
actkamera.mostCurrent._btnmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private btnCamera As Button";
actkamera.mostCurrent._btncamera = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private barZoom As SeekBar";
actkamera.mostCurrent._barzoom = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _handleerror(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("HandleError (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,142);
if (RapidSub.canDelegate("handleerror")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","handleerror", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 142;BA.debugLine="Sub HandleError (Error As Exception)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 143;BA.debugLine="Log(\"Error: \" & Error)";
Debug.ShouldStop(16384);
actkamera.mostCurrent.__c.runVoidMethod ("LogImpl","01507329",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_error),0);
 BA.debugLineNum = 144;BA.debugLine="ToastMessageShow(Error, True)";
Debug.ShouldStop(32768);
actkamera.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_error.getObject())),(Object)(actkamera.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 145;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(65536);
_opencamera(actkamera._frontcamera);
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _opencamera(RemoteObject _front) throws Exception{
try {
		Debug.PushSubsStack("OpenCamera (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,55);
if (RapidSub.canDelegate("opencamera")) { b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","opencamera", _front); return;}
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
public ResumableSub_OpenCamera(b4a.example.actkamera parent,RemoteObject _front) {
this.parent = parent;
this._front = _front;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actkamera parent;
RemoteObject _front;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _taskindex = RemoteObject.createImmutable(0);
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("OpenCamera (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,55);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("front", _front);
 BA.debugLineNum = 56;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
Debug.ShouldStop(8388608);
parent._rp.runVoidMethod ("CheckAndRequest",actkamera.processBA,(Object)(parent._rp.getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 57;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "opencamera"), null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 58;BA.debugLine="If Result = False Then";
Debug.ShouldStop(33554432);
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
 BA.debugLineNum = 59;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 60;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 63;BA.debugLine="SetState(False, False, VideoMode)";
Debug.ShouldStop(1073741824);
_setstate(parent.mostCurrent.__c.getField(true,"False"),parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 64;BA.debugLine="Wait For (cam.OpenCamera(front)) Complete (TaskIn";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "opencamera"), parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_opencamera" /*RemoteObject*/ ,(Object)(_front)));
this.state = 14;
return;
case 14:
//C
this.state = 5;
_taskindex = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("TaskIndex", _taskindex);
;
 BA.debugLineNum = 65;BA.debugLine="If TaskIndex > 0 Then";
Debug.ShouldStop(1);
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
 BA.debugLineNum = 66;BA.debugLine="MyTaskIndex = TaskIndex 'hold this index. It wil";
Debug.ShouldStop(2);
parent._mytaskindex = _taskindex;
 BA.debugLineNum = 67;BA.debugLine="Wait For(PrepareSurface) Complete (Success As Bo";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "opencamera"), _preparesurface());
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
 BA.debugLineNum = 69;BA.debugLine="Log(\"Start success: \" & Success)";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","01048590",RemoteObject.concat(RemoteObject.createImmutable("Start success: "),_success),0);
 BA.debugLineNum = 70;BA.debugLine="SetState(Success, False, VideoMode)";
Debug.ShouldStop(32);
_setstate(_success,parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 71;BA.debugLine="If Success = False Then";
Debug.ShouldStop(64);
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
 BA.debugLineNum = 72;BA.debugLine="ToastMessageShow(\"Failed to open camera\", True)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Failed to open camera")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
public static RemoteObject  _pnlpicture_click() throws Exception{
try {
		Debug.PushSubsStack("pnlPicture_Click (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,188);
if (RapidSub.canDelegate("pnlpicture_click")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","pnlpicture_click");}
 BA.debugLineNum = 188;BA.debugLine="Sub pnlPicture_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="pnlBackground.Visible = False";
Debug.ShouldStop(268435456);
actkamera.mostCurrent._pnlbackground.runMethod(true,"setVisible",actkamera.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 190;BA.debugLine="StartActivity(actLapor)";
Debug.ShouldStop(536870912);
actkamera.mostCurrent.__c.runVoidMethod ("StartActivity",actkamera.processBA,(Object)((actkamera.mostCurrent._actlapor.getObject())));
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _preparesurface() throws Exception{
try {
		Debug.PushSubsStack("PrepareSurface (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,76);
if (RapidSub.canDelegate("preparesurface")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","preparesurface");}
ResumableSub_PrepareSurface rsub = new ResumableSub_PrepareSurface(null);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_PrepareSurface extends BA.ResumableSub {
public ResumableSub_PrepareSurface(b4a.example.actkamera parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actkamera parent;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("PrepareSurface (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,76);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
 BA.debugLineNum = 77;BA.debugLine="SetState(False, busystate, VideoMode)";
Debug.ShouldStop(4096);
_setstate(parent.mostCurrent.__c.getField(true,"False"),parent._busystate,parent._videomode);
 BA.debugLineNum = 79;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(16384);
if (true) break;

case 1:
//if
this.state = 6;
if (parent._videomode.<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 80;BA.debugLine="cam.PreviewSize.Initialize(640, 480)";
Debug.ShouldStop(32768);
parent.mostCurrent._cam.getField(false,"_previewsize" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 640)),(Object)(BA.numberCast(int.class, 480)));
 BA.debugLineNum = 82;BA.debugLine="Wait For (cam.PrepareSurfaceForVideo(MyTaskIndex";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "preparesurface"), parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_preparesurfaceforvideo" /*RemoteObject*/ ,(Object)(parent._mytaskindex),(Object)(parent._videofiledir),(Object)(RemoteObject.concat(RemoteObject.createImmutable("temp-"),parent._videofilename))));
this.state = 12;
return;
case 12:
//C
this.state = 6;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 84;BA.debugLine="cam.PreviewSize.Initialize(1920, 1080)";
Debug.ShouldStop(524288);
parent.mostCurrent._cam.getField(false,"_previewsize" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 1920)),(Object)(BA.numberCast(int.class, 1080)));
 BA.debugLineNum = 85;BA.debugLine="Wait For (cam.PrepareSurface(MyTaskIndex)) Compl";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "preparesurface"), parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_preparesurface" /*RemoteObject*/ ,(Object)(parent._mytaskindex)));
this.state = 13;
return;
case 13:
//C
this.state = 6;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 if (true) break;
;
 BA.debugLineNum = 87;BA.debugLine="If Success Then cam.StartPreview(MyTaskIndex, Vid";
Debug.ShouldStop(4194304);

case 6:
//if
this.state = 11;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 8;
;}if (true) break;

case 8:
//C
this.state = 11;
parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(parent._mytaskindex),(Object)(parent._videomode));
if (true) break;

case 11:
//C
this.state = -1;
;
 BA.debugLineNum = 88;BA.debugLine="SetState(Success, busystate, VideoMode)";
Debug.ShouldStop(8388608);
_setstate(_success,parent._busystate,parent._videomode);
 BA.debugLineNum = 89;BA.debugLine="Return Success";
Debug.ShouldStop(16777216);
if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_success));return;};
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private frontCamera As Boolean = False";
actkamera._frontcamera = actkamera.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 10;BA.debugLine="Private VideoMode As Boolean = False";
actkamera._videomode = actkamera.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 11;BA.debugLine="Private VideoFileDir, VideoFileName As String";
actkamera._videofiledir = RemoteObject.createImmutable("");
actkamera._videofilename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="Private MyTaskIndex As Int";
actkamera._mytaskindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 13;BA.debugLine="Private rp As RuntimePermissions";
actkamera._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstate(RemoteObject _open,RemoteObject _busy,RemoteObject _video) throws Exception{
try {
		Debug.PushSubsStack("SetState (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,203);
if (RapidSub.canDelegate("setstate")) { return b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","setstate", _open, _busy, _video);}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _btnrecordtext = RemoteObject.createImmutable("");
Debug.locals.put("Open", _open);
Debug.locals.put("Busy", _busy);
Debug.locals.put("Video", _video);
 BA.debugLineNum = 203;BA.debugLine="Sub SetState(Open As Boolean, Busy As Boolean, Vid";
Debug.ShouldStop(1024);
 BA.debugLineNum = 204;BA.debugLine="For Each b As Button In buttons";
Debug.ShouldStop(2048);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
{
final RemoteObject group1 = actkamera.mostCurrent._buttons;
final int groupLen1 = group1.runMethod(true,"getSize").<Integer>get()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_b.setObject(group1.runMethod(false,"Get",index1));
Debug.locals.put("b", _b);
 BA.debugLineNum = 205;BA.debugLine="b.Visible = Open And Not(Busy)";
Debug.ShouldStop(4096);
_b.runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean(".",_open) && RemoteObject.solveBoolean(".",actkamera.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy)))));
 }
}Debug.locals.put("b", _b);
;
 BA.debugLineNum = 207;BA.debugLine="btnCamera.Visible = Not(Busy)";
Debug.ShouldStop(16384);
actkamera.mostCurrent._btncamera.runMethod(true,"setVisible",actkamera.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy)));
 BA.debugLineNum = 208;BA.debugLine="btnRecord.Visible = Open And (Video Or Not(Busy))";
Debug.ShouldStop(32768);
actkamera.mostCurrent._btnrecord.runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean(".",_open) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean(".",_video) || RemoteObject.solveBoolean(".",actkamera.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy))))))));
 BA.debugLineNum = 209;BA.debugLine="openstate = Open";
Debug.ShouldStop(65536);
actkamera._openstate = _open;
 BA.debugLineNum = 210;BA.debugLine="ProgressBar1.Visible = Busy";
Debug.ShouldStop(131072);
actkamera.mostCurrent._progressbar1.runMethod(true,"setVisible",_busy);
 BA.debugLineNum = 211;BA.debugLine="busystate = Busy";
Debug.ShouldStop(262144);
actkamera._busystate = _busy;
 BA.debugLineNum = 212;BA.debugLine="VideoMode = Video";
Debug.ShouldStop(524288);
actkamera._videomode = _video;
 BA.debugLineNum = 213;BA.debugLine="barZoom.Visible = Open";
Debug.ShouldStop(1048576);
actkamera.mostCurrent._barzoom.runMethod(true,"setVisible",_open);
 BA.debugLineNum = 214;BA.debugLine="Dim btnRecordText As String";
Debug.ShouldStop(2097152);
_btnrecordtext = RemoteObject.createImmutable("");Debug.locals.put("btnRecordText", _btnrecordtext);
 BA.debugLineNum = 215;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(4194304);
if (actkamera._videomode.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 216;BA.debugLine="If Busy Then";
Debug.ShouldStop(8388608);
if (_busy.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 217;BA.debugLine="btnRecordText = Chr(0xF04D)";
Debug.ShouldStop(16777216);
_btnrecordtext = BA.ObjectToString(actkamera.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf04d))));Debug.locals.put("btnRecordText", _btnrecordtext);
 }else {
 BA.debugLineNum = 219;BA.debugLine="btnRecordText = Chr(0xF03D)";
Debug.ShouldStop(67108864);
_btnrecordtext = BA.ObjectToString(actkamera.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf03d))));Debug.locals.put("btnRecordText", _btnrecordtext);
 };
 }else {
 BA.debugLineNum = 222;BA.debugLine="btnRecordText = Chr(0xF030)";
Debug.ShouldStop(536870912);
_btnrecordtext = BA.ObjectToString(actkamera.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf030))));Debug.locals.put("btnRecordText", _btnrecordtext);
 };
 BA.debugLineNum = 224;BA.debugLine="btnRecord.Text = btnRecordText";
Debug.ShouldStop(-2147483648);
actkamera.mostCurrent._btnrecord.runMethod(true,"setText",BA.ObjectToCharSequence(_btnrecordtext));
 BA.debugLineNum = 225;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _takepicture() throws Exception{
try {
		Debug.PushSubsStack("TakePicture (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,148);
if (RapidSub.canDelegate("takepicture")) { b4a.example.actkamera.remoteMe.runUserSub(false, "actkamera","takepicture"); return;}
ResumableSub_TakePicture rsub = new ResumableSub_TakePicture(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_TakePicture extends BA.ResumableSub {
public ResumableSub_TakePicture(b4a.example.actkamera parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actkamera parent;
RemoteObject _data = null;
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _filepath = RemoteObject.createImmutable("");
RemoteObject _phone = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _mediascannerconnection = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _interface = RemoteObject.declareNull("Object");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("TakePicture (actkamera) ","actkamera",2,actkamera.mostCurrent.activityBA,actkamera.mostCurrent,148);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 149;BA.debugLine="Try";
Debug.ShouldStop(1048576);
if (true) break;

case 1:
//try
this.state = 6;
this.catchState = 5;
this.state = 3;
if (true) break;

case 3:
//C
this.state = 6;
this.catchState = 5;
 BA.debugLineNum = 150;BA.debugLine="SetState(openstate, True, VideoMode)";
Debug.ShouldStop(2097152);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"True"),parent._videomode);
 BA.debugLineNum = 151;BA.debugLine="Wait For(cam.FocusAndTakePicture(MyTaskIndex)) C";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "takepicture"), parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_focusandtakepicture" /*RemoteObject*/ ,(Object)(parent._mytaskindex)));
this.state = 17;
return;
case 17:
//C
this.state = 6;
_data = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("Data", _data);
;
 BA.debugLineNum = 152;BA.debugLine="SetState(openstate, False, VideoMode)";
Debug.ShouldStop(8388608);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 153;BA.debugLine="cam.DataToFile(Data, VideoFileDir, \"1.jpg\")";
Debug.ShouldStop(16777216);
parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_datatofile" /*RemoteObject*/ ,(Object)(_data),(Object)(parent._videofiledir),(Object)(RemoteObject.createImmutable("1.jpg")));
 BA.debugLineNum = 154;BA.debugLine="Dim bmp As Bitmap = cam.DataToBitmap(Data)";
Debug.ShouldStop(33554432);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = parent.mostCurrent._cam.runClassMethod (b4a.example.camex2.class, "_datatobitmap" /*RemoteObject*/ ,(Object)(_data));Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 155;BA.debugLine="Log(\"Picture taken: \" & bmp) 'ignore";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","01572871",RemoteObject.concat(RemoteObject.createImmutable("Picture taken: "),_bmp),0);
 BA.debugLineNum = 156;BA.debugLine="pnlBackground.SetVisibleAnimated(100, True)";
Debug.ShouldStop(134217728);
parent.mostCurrent._pnlbackground.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 157;BA.debugLine="pnlPicture.SetBackgroundImage(bmp.Resize(pnlPict";
Debug.ShouldStop(268435456);
parent.mostCurrent._pnlpicture.runMethod(false,"SetBackgroundImageNew",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, parent.mostCurrent._pnlpicture.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, parent.mostCurrent._pnlpicture.runMethod(true,"getHeight"))),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject()))).runMethod(true,"setGravity",parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 158;BA.debugLine="Sleep(4000)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("Sleep",actkamera.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "takepicture"),BA.numberCast(int.class, 4000));
this.state = 18;
return;
case 18:
//C
this.state = 6;
;
 BA.debugLineNum = 159;BA.debugLine="pnlBackground.SetVisibleAnimated(500, False)";
Debug.ShouldStop(1073741824);
parent.mostCurrent._pnlbackground.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 Debug.CheckDeviceExceptions();
if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 BA.debugLineNum = 161;BA.debugLine="HandleError(LastException)";
Debug.ShouldStop(1);
_handleerror(parent.mostCurrent.__c.runMethod(false,"LastException",actkamera.mostCurrent.activityBA));
 if (true) break;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 0;
;
 BA.debugLineNum = 165;BA.debugLine="Dim rp As RuntimePermissions";
Debug.ShouldStop(16);
parent._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 BA.debugLineNum = 166;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_S";
Debug.ShouldStop(32);
parent._rp.runVoidMethod ("CheckAndRequest",actkamera.processBA,(Object)(parent._rp.getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE")));
 BA.debugLineNum = 167;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", actkamera.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actkamera", "takepicture"), null);
this.state = 19;
return;
case 19:
//C
this.state = 7;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 168;BA.debugLine="If Result Then";
Debug.ShouldStop(128);
if (true) break;

case 7:
//if
this.state = 16;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 169;BA.debugLine="File.Copy(File.DirAssets, \"1.jpg\", File.DirRootE";
Debug.ShouldStop(256);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("1.jpg")),(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("Pictures/1.jpg")));
 BA.debugLineNum = 170;BA.debugLine="Dim FilePath As String = File.Combine(File.DirRo";
Debug.ShouldStop(512);
_filepath = parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal")),(Object)(RemoteObject.createImmutable("Pictures/1.jpg")));Debug.locals.put("FilePath", _filepath);Debug.locals.put("FilePath", _filepath);
 BA.debugLineNum = 171;BA.debugLine="Dim Phone As Phone";
Debug.ShouldStop(1024);
_phone = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("Phone", _phone);
 BA.debugLineNum = 172;BA.debugLine="If Phone.SdkVersion <= 18 Then           ' min -";
Debug.ShouldStop(2048);
if (true) break;

case 10:
//if
this.state = 15;
if (RemoteObject.solveBoolean("k",_phone.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 18))) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
 BA.debugLineNum = 173;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(4096);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 174;BA.debugLine="i.Initialize(\"android.intent.action.MEDIA_SCANN";
Debug.ShouldStop(8192);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.intent.action.MEDIA_SCANNER_SCAN_FILE")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("file://"),_filepath)));
 BA.debugLineNum = 175;BA.debugLine="Phone.SendBroadcastIntent(i)";
Debug.ShouldStop(16384);
_phone.runVoidMethod ("SendBroadcastIntent",(Object)((_i.getObject())));
 if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 177;BA.debugLine="Dim ctxt As JavaObject";
Debug.ShouldStop(65536);
_ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("ctxt", _ctxt);
 BA.debugLineNum = 178;BA.debugLine="ctxt.InitializeContext";
Debug.ShouldStop(131072);
_ctxt.runVoidMethod ("InitializeContext",actkamera.processBA);
 BA.debugLineNum = 179;BA.debugLine="Dim MediaScannerConnection As JavaObject";
Debug.ShouldStop(262144);
_mediascannerconnection = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("MediaScannerConnection", _mediascannerconnection);
 BA.debugLineNum = 180;BA.debugLine="MediaScannerConnection.InitializeStatic(\"androi";
Debug.ShouldStop(524288);
_mediascannerconnection.runVoidMethod ("InitializeStatic",(Object)(RemoteObject.createImmutable("android.media.MediaScannerConnection")));
 BA.debugLineNum = 181;BA.debugLine="Dim interface As Object = MediaScannerConnectio";
Debug.ShouldStop(1048576);
_interface = _mediascannerconnection.runMethod(false,"CreateEventFromUI",actkamera.processBA,(Object)(BA.ObjectToString("android.media.MediaScannerConnection.OnScanCompletedListener")),(Object)(BA.ObjectToString("ScanCompleted")),(Object)(parent.mostCurrent.__c.getField(false,"Null")));Debug.locals.put("interface", _interface);Debug.locals.put("interface", _interface);
 BA.debugLineNum = 183;BA.debugLine="MediaScannerConnection.RunMethod(\"scanFile\", Ar";
Debug.ShouldStop(4194304);
_mediascannerconnection.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("scanFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {(_ctxt.getObject()),(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_filepath})),(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("image/jpeg")})),_interface})));
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = -1;
;
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",actkamera.processBA, e0.toString());}
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
}