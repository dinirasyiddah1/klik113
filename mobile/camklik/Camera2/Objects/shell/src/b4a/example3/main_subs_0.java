package b4a.example3;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,42);
if (RapidSub.canDelegate("activity_create")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="VideoFileDir = rp.GetSafeDirDefaultExternal(\"\")";
Debug.ShouldStop(1024);
main._videofiledir = main._rp.runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 44;BA.debugLine="VideoFileName = \"1.mp4\"";
Debug.ShouldStop(2048);
main._videofilename = BA.ObjectToString("1.mp4");
 BA.debugLineNum = 45;BA.debugLine="Activity.LoadLayout(\"1\")";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 46;BA.debugLine="Activity.LoadLayout(\"StillPicture\")";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("StillPicture")),main.mostCurrent.activityBA);
 BA.debugLineNum = 47;BA.debugLine="cam.Initialize(pnlCamera)";
Debug.ShouldStop(16384);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._pnlcamera));
 BA.debugLineNum = 48;BA.debugLine="Log(cam.SupportedHardwareLevel)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4131078",main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getsupportedhardwarelevel" /*RemoteObject*/ ),0);
 BA.debugLineNum = 49;BA.debugLine="buttons = Array(btnScene, btnAutoExposure, btnEff";
Debug.ShouldStop(65536);
main.mostCurrent._buttons = main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {(main.mostCurrent._btnscene.getObject()),(main.mostCurrent._btnautoexposure.getObject()),(main.mostCurrent._btneffects.getObject()),(main.mostCurrent._btnfocus.getObject()),(main.mostCurrent._btnmode.getObject())})));
 BA.debugLineNum = 50;BA.debugLine="SetState(False, False, VideoMode)";
Debug.ShouldStop(131072);
_setstate(main.mostCurrent.__c.getField(true,"False"),main.mostCurrent.__c.getField(true,"False"),main._videomode);
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,100);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 100;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="cam.Stop";
Debug.ShouldStop(16);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_stop" /*RemoteObject*/ );
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(2097152);
_opencamera(main._frontcamera);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("barZoom_ValueChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,233);
if (RapidSub.canDelegate("barzoom_valuechanged")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","barzoom_valuechanged", _value, _userchanged);}
RemoteObject _originalsize = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _zoom = RemoteObject.createImmutable(0f);
RemoteObject _crop = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _newwidth = RemoteObject.createImmutable(0);
RemoteObject _newheight = RemoteObject.createImmutable(0);
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 233;BA.debugLine="Sub barZoom_ValueChanged (Value As Int, UserChange";
Debug.ShouldStop(256);
 BA.debugLineNum = 234;BA.debugLine="Dim OriginalSize As Rect = cam.ActiveArraySize";
Debug.ShouldStop(512);
_originalsize = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
_originalsize = main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getactivearraysize" /*RemoteObject*/ );Debug.locals.put("OriginalSize", _originalsize);Debug.locals.put("OriginalSize", _originalsize);
 BA.debugLineNum = 235;BA.debugLine="Dim Zoom As Float = 1 + Value / 100 * (cam.MaxDig";
Debug.ShouldStop(1024);
_zoom = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),_value,RemoteObject.createImmutable(100),(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getmaxdigitalzoom" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 0))}, "+/*",1, 0));Debug.locals.put("Zoom", _zoom);Debug.locals.put("Zoom", _zoom);
 BA.debugLineNum = 236;BA.debugLine="Dim Crop As Rect";
Debug.ShouldStop(2048);
_crop = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("Crop", _crop);
 BA.debugLineNum = 237;BA.debugLine="Dim NewWidth As Int = OriginalSize.Width / Zoom";
Debug.ShouldStop(4096);
_newwidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getWidth"),_zoom}, "/",0, 0));Debug.locals.put("NewWidth", _newwidth);Debug.locals.put("NewWidth", _newwidth);
 BA.debugLineNum = 238;BA.debugLine="Dim NewHeight As Int = OriginalSize.Height / Zoom";
Debug.ShouldStop(8192);
_newheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getHeight"),_zoom}, "/",0, 0));Debug.locals.put("NewHeight", _newheight);Debug.locals.put("NewHeight", _newheight);
 BA.debugLineNum = 239;BA.debugLine="Crop.Initialize(OriginalSize.CenterX - NewWidth /";
Debug.ShouldStop(16384);
_crop.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterX"),_newwidth,RemoteObject.createImmutable(2)}, "-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterY"),_newheight,RemoteObject.createImmutable(2)}, "-/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterX"),_newwidth,RemoteObject.createImmutable(2)}, "+/",1, 0))),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_originalsize.runMethod(true,"getCenterY"),_newheight,RemoteObject.createImmutable(2)}, "+/",1, 0))));
 BA.debugLineNum = 241;BA.debugLine="cam.PreviewCropRegion = Crop";
Debug.ShouldStop(65536);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_setpreviewcropregion",_crop);
 BA.debugLineNum = 242;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(131072);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(main._mytaskindex),(Object)(main._videomode));
 BA.debugLineNum = 243;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("btnAutoExposure_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,190);
if (RapidSub.canDelegate("btnautoexposure_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","btnautoexposure_click");}
RemoteObject _flashes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 190;BA.debugLine="Sub btnAutoExposure_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="Dim flashes As List = cam.SupportedAutoExposureMo";
Debug.ShouldStop(1073741824);
_flashes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_flashes = main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getsupportedautoexposuremodes" /*RemoteObject*/ );Debug.locals.put("flashes", _flashes);Debug.locals.put("flashes", _flashes);
 BA.debugLineNum = 192;BA.debugLine="Dim i As Int = flashes.IndexOf(cam.AutoExposureMo";
Debug.ShouldStop(-2147483648);
_i = _flashes.runMethod(true,"IndexOf",(Object)((main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getautoexposuremode" /*RemoteObject*/ ))));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 193;BA.debugLine="i = (i + 1) Mod flashes.Size";
Debug.ShouldStop(1);
_i = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1)),_flashes.runMethod(true,"getSize")}, "%",0, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 194;BA.debugLine="cam.AutoExposureMode = flashes.Get(i)";
Debug.ShouldStop(2);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_setautoexposuremode" /*RemoteObject*/ ,BA.ObjectToString(_flashes.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 195;BA.debugLine="btnAutoExposure.Text = flashes.Get(i)";
Debug.ShouldStop(4);
main.mostCurrent._btnautoexposure.runMethod(true,"setText",BA.ObjectToCharSequence(_flashes.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 196;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(8);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(main._mytaskindex),(Object)(main._videomode));
 BA.debugLineNum = 197;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("btnCamera_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,95);
if (RapidSub.canDelegate("btncamera_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","btncamera_click");}
 BA.debugLineNum = 95;BA.debugLine="Sub btnCamera_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="frontCamera = Not(frontCamera)";
Debug.ShouldStop(-2147483648);
main._frontcamera = main.mostCurrent.__c.runMethod(true,"Not",(Object)(main._frontcamera));
 BA.debugLineNum = 97;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(1);
_opencamera(main._frontcamera);
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btneffects_click() throws Exception{
try {
		Debug.PushSubsStack("btnEffects_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,172);
if (RapidSub.canDelegate("btneffects_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","btneffects_click");}
RemoteObject _effects = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 172;BA.debugLine="Sub btnEffects_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 173;BA.debugLine="Dim effects As List = cam.SupportedEffectModes";
Debug.ShouldStop(4096);
_effects = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_effects = main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getsupportedeffectmodes" /*RemoteObject*/ );Debug.locals.put("effects", _effects);Debug.locals.put("effects", _effects);
 BA.debugLineNum = 174;BA.debugLine="Dim i As Int = effects.IndexOf(cam.EffectMode)";
Debug.ShouldStop(8192);
_i = _effects.runMethod(true,"IndexOf",(Object)((main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_geteffectmode" /*RemoteObject*/ ))));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 175;BA.debugLine="i = (i + 1) Mod effects.Size";
Debug.ShouldStop(16384);
_i = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1)),_effects.runMethod(true,"getSize")}, "%",0, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 176;BA.debugLine="cam.EffectMode = effects.Get(i)";
Debug.ShouldStop(32768);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_seteffectmode" /*RemoteObject*/ ,BA.ObjectToString(_effects.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 177;BA.debugLine="btnEffects.Text = effects.Get(i)";
Debug.ShouldStop(65536);
main.mostCurrent._btneffects.runMethod(true,"setText",BA.ObjectToCharSequence(_effects.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 178;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(131072);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(main._mytaskindex),(Object)(main._videomode));
 BA.debugLineNum = 179;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnfocus_click() throws Exception{
try {
		Debug.PushSubsStack("btnFocus_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,199);
if (RapidSub.canDelegate("btnfocus_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","btnfocus_click");}
RemoteObject _focuses = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 199;BA.debugLine="Sub btnFocus_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 200;BA.debugLine="Dim focuses As List = cam.SupportedFocusModes";
Debug.ShouldStop(128);
_focuses = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_focuses = main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getsupportedfocusmodes" /*RemoteObject*/ );Debug.locals.put("focuses", _focuses);Debug.locals.put("focuses", _focuses);
 BA.debugLineNum = 201;BA.debugLine="Dim i As Int = focuses.IndexOf(cam.FocusMode)";
Debug.ShouldStop(256);
_i = _focuses.runMethod(true,"IndexOf",(Object)((main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getfocusmode" /*RemoteObject*/ ))));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 202;BA.debugLine="i = (i + 1) Mod focuses.Size";
Debug.ShouldStop(512);
_i = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1)),_focuses.runMethod(true,"getSize")}, "%",0, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 203;BA.debugLine="cam.FocusMode = focuses.Get(i)";
Debug.ShouldStop(1024);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_setfocusmode" /*RemoteObject*/ ,BA.ObjectToString(_focuses.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 204;BA.debugLine="btnFocus.Text = focuses.Get(i)";
Debug.ShouldStop(2048);
main.mostCurrent._btnfocus.runMethod(true,"setText",BA.ObjectToCharSequence(_focuses.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 205;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(4096);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(main._mytaskindex),(Object)(main._videomode));
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("btnMode_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,104);
if (RapidSub.canDelegate("btnmode_click")) { b4a.example3.main.remoteMe.runUserSub(false, "main","btnmode_click"); return;}
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
public ResumableSub_btnMode_Click(b4a.example3.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example3.main parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnMode_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,104);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 105;BA.debugLine="VideoMode = Not(VideoMode)";
Debug.ShouldStop(256);
parent._videomode = parent.mostCurrent.__c.runMethod(true,"Not",(Object)(parent._videomode));
 BA.debugLineNum = 106;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(512);
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
 BA.debugLineNum = 107;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECORD_AUDIO)";
Debug.ShouldStop(1024);
parent._rp.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(parent._rp.getField(true,"PERMISSION_RECORD_AUDIO")));
 BA.debugLineNum = 108;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "btnmode_click"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 109;BA.debugLine="If Result = False Then";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 110;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 111;BA.debugLine="VideoMode = False";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 114;BA.debugLine="SetState(openstate, busystate, VideoMode)";
Debug.ShouldStop(131072);
_setstate(parent._openstate,parent._busystate,parent._videomode);
 BA.debugLineNum = 115;BA.debugLine="PrepareSurface";
Debug.ShouldStop(262144);
_preparesurface();
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("btnRecord_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,118);
if (RapidSub.canDelegate("btnrecord_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","btnrecord_click");}
 BA.debugLineNum = 118;BA.debugLine="Sub btnRecord_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(4194304);
if (main._videomode.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 120;BA.debugLine="CaptureVideo";
Debug.ShouldStop(8388608);
_capturevideo();
 }else {
 BA.debugLineNum = 122;BA.debugLine="TakePicture";
Debug.ShouldStop(33554432);
_takepicture();
 };
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnscene_click() throws Exception{
try {
		Debug.PushSubsStack("btnScene_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,181);
if (RapidSub.canDelegate("btnscene_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","btnscene_click");}
RemoteObject _scenes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _i = RemoteObject.createImmutable(0);
 BA.debugLineNum = 181;BA.debugLine="Sub btnScene_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 182;BA.debugLine="Dim scenes As List = cam.SupportedSceneModes";
Debug.ShouldStop(2097152);
_scenes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_scenes = main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getsupportedscenemodes" /*RemoteObject*/ );Debug.locals.put("scenes", _scenes);Debug.locals.put("scenes", _scenes);
 BA.debugLineNum = 183;BA.debugLine="Dim i As Int = scenes.IndexOf(cam.SceneMode)";
Debug.ShouldStop(4194304);
_i = _scenes.runMethod(true,"IndexOf",(Object)((main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_getscenemode" /*RemoteObject*/ ))));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 184;BA.debugLine="i = (i + 1) Mod scenes.Size";
Debug.ShouldStop(8388608);
_i = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1)),_scenes.runMethod(true,"getSize")}, "%",0, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 185;BA.debugLine="cam.SceneMode = scenes.Get(i)";
Debug.ShouldStop(16777216);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_setscenemode" /*RemoteObject*/ ,BA.ObjectToString(_scenes.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 186;BA.debugLine="btnScene.Text = scenes.Get(i)";
Debug.ShouldStop(33554432);
main.mostCurrent._btnscene.runMethod(true,"setText",BA.ObjectToCharSequence(_scenes.runMethod(false,"Get",(Object)(_i))));
 BA.debugLineNum = 187;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
Debug.ShouldStop(67108864);
main.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(main._mytaskindex),(Object)(main._videomode));
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("CaptureVideo (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
if (RapidSub.canDelegate("capturevideo")) { b4a.example3.main.remoteMe.runUserSub(false, "main","capturevideo"); return;}
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
public ResumableSub_CaptureVideo(b4a.example3.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example3.main parent;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("CaptureVideo (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 127;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
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
 BA.debugLineNum = 128;BA.debugLine="SetState(openstate, True, VideoMode)";
Debug.ShouldStop(-2147483648);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"True"),parent._videomode);
 BA.debugLineNum = 129;BA.debugLine="If cam.RecordingVideo = False Then";
Debug.ShouldStop(1);
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
 BA.debugLineNum = 130;BA.debugLine="cam.StartVideoRecording (MyTaskIndex)";
Debug.ShouldStop(2);
parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startvideorecording" /*RemoteObject*/ ,(Object)(parent._mytaskindex));
 if (true) break;

case 8:
//C
this.state = 9;
 BA.debugLineNum = 132;BA.debugLine="cam.StopVideoRecording (MyTaskIndex)";
Debug.ShouldStop(8);
parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_stopvideorecording" /*RemoteObject*/ ,(Object)(parent._mytaskindex));
 BA.debugLineNum = 133;BA.debugLine="File.Copy(VideoFileDir, \"temp-\" & VideoFileName";
Debug.ShouldStop(16);
parent.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(parent._videofiledir),(Object)(RemoteObject.concat(RemoteObject.createImmutable("temp-"),parent._videofilename)),(Object)(parent._videofiledir),(Object)(parent._videofilename));
 BA.debugLineNum = 134;BA.debugLine="ToastMessageShow($\"Video file saved: $1.2{File.";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence((RemoteObject.concat(RemoteObject.createImmutable("Video file saved: "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("1.2")),(Object)((RemoteObject.solve(new RemoteObject[] {parent.mostCurrent.__c.getField(false,"File").runMethod(true,"Size",(Object)(parent._videofiledir),(Object)(parent._videofilename)),RemoteObject.createImmutable(1024),RemoteObject.createImmutable(1024)}, "//",0, 0)))),RemoteObject.createImmutable(" MB"))))),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 135;BA.debugLine="Wait For (PrepareSurface) Complete (Success As";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "capturevideo"), _preparesurface());
this.state = 13;
return;
case 13:
//C
this.state = 9;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 136;BA.debugLine="SetState(openstate, False, VideoMode)";
Debug.ShouldStop(128);
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
 BA.debugLineNum = 140;BA.debugLine="HandleError(LastException)";
Debug.ShouldStop(2048);
_handleerror(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA));
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
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
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private cam As CamEx2";
main.mostCurrent._cam = RemoteObject.createNew ("b4a.example3.camex2");
 //BA.debugLineNum = 26;BA.debugLine="Private pnlCamera As Panel";
main.mostCurrent._pnlcamera = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private pnlPicture As Panel";
main.mostCurrent._pnlpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private pnlBackground As Panel";
main.mostCurrent._pnlbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private btnEffects As Button";
main.mostCurrent._btneffects = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private btnScene As Button";
main.mostCurrent._btnscene = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private buttons As List";
main.mostCurrent._buttons = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 32;BA.debugLine="Private btnAutoExposure As Button";
main.mostCurrent._btnautoexposure = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private btnFocus As Button";
main.mostCurrent._btnfocus = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private ProgressBar1 As ProgressBar";
main.mostCurrent._progressbar1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ProgressBarWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private openstate, busystate As Boolean";
main._openstate = RemoteObject.createImmutable(false);
main._busystate = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 36;BA.debugLine="Private btnRecord As Button";
main.mostCurrent._btnrecord = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private btnMode As Button";
main.mostCurrent._btnmode = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private btnCamera As Button";
main.mostCurrent._btncamera = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private barZoom As SeekBar";
main.mostCurrent._barzoom = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _handleerror(RemoteObject _error) throws Exception{
try {
		Debug.PushSubsStack("HandleError (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,144);
if (RapidSub.canDelegate("handleerror")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","handleerror", _error);}
Debug.locals.put("Error", _error);
 BA.debugLineNum = 144;BA.debugLine="Sub HandleError (Error As Exception)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="Log(\"Error: \" & Error)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("LogImpl","4720897",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_error),0);
 BA.debugLineNum = 146;BA.debugLine="ToastMessageShow(Error, True)";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_error.getObject())),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 147;BA.debugLine="OpenCamera(frontCamera)";
Debug.ShouldStop(262144);
_opencamera(main._frontcamera);
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("OpenCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("opencamera")) { b4a.example3.main.remoteMe.runUserSub(false, "main","opencamera", _front); return;}
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
public ResumableSub_OpenCamera(b4a.example3.main parent,RemoteObject _front) {
this.parent = parent;
this._front = _front;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example3.main parent;
RemoteObject _front;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _taskindex = RemoteObject.createImmutable(0);
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("OpenCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("front", _front);
 BA.debugLineNum = 59;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
Debug.ShouldStop(67108864);
parent._rp.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(parent._rp.getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 60;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "opencamera"), null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 61;BA.debugLine="If Result = False Then";
Debug.ShouldStop(268435456);
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
 BA.debugLineNum = 62;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 63;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 66;BA.debugLine="SetState(False, False, VideoMode)";
Debug.ShouldStop(2);
_setstate(parent.mostCurrent.__c.getField(true,"False"),parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 67;BA.debugLine="Wait For (cam.OpenCamera(front)) Complete (TaskIn";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "opencamera"), parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_opencamera" /*RemoteObject*/ ,(Object)(_front)));
this.state = 14;
return;
case 14:
//C
this.state = 5;
_taskindex = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("TaskIndex", _taskindex);
;
 BA.debugLineNum = 68;BA.debugLine="If TaskIndex > 0 Then";
Debug.ShouldStop(8);
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
 BA.debugLineNum = 69;BA.debugLine="MyTaskIndex = TaskIndex 'hold this index. It wil";
Debug.ShouldStop(16);
parent._mytaskindex = _taskindex;
 BA.debugLineNum = 70;BA.debugLine="Wait For(PrepareSurface) Complete (Success As Bo";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "opencamera"), _preparesurface());
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
 BA.debugLineNum = 72;BA.debugLine="Log(\"Start success: \" & Success)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4262158",RemoteObject.concat(RemoteObject.createImmutable("Start success: "),_success),0);
 BA.debugLineNum = 73;BA.debugLine="SetState(Success, False, VideoMode)";
Debug.ShouldStop(256);
_setstate(_success,parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 74;BA.debugLine="If Success = False Then";
Debug.ShouldStop(512);
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
 BA.debugLineNum = 75;BA.debugLine="ToastMessageShow(\"Failed to open camera\", True)";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Failed to open camera")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 12:
//C
this.state = -1;
;
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("pnlPicture_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,168);
if (RapidSub.canDelegate("pnlpicture_click")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","pnlpicture_click");}
 BA.debugLineNum = 168;BA.debugLine="Sub pnlPicture_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 169;BA.debugLine="pnlBackground.Visible = False";
Debug.ShouldStop(256);
main.mostCurrent._pnlbackground.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
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
		Debug.PushSubsStack("PrepareSurface (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("preparesurface")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","preparesurface");}
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
public ResumableSub_PrepareSurface(b4a.example3.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example3.main parent;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("PrepareSurface (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
 BA.debugLineNum = 80;BA.debugLine="SetState(False, busystate, VideoMode)";
Debug.ShouldStop(32768);
_setstate(parent.mostCurrent.__c.getField(true,"False"),parent._busystate,parent._videomode);
 BA.debugLineNum = 82;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(131072);
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
 BA.debugLineNum = 83;BA.debugLine="cam.PreviewSize.Initialize(640, 480)";
Debug.ShouldStop(262144);
parent.mostCurrent._cam.getField(false,"_previewsize" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 640)),(Object)(BA.numberCast(int.class, 480)));
 BA.debugLineNum = 85;BA.debugLine="Wait For (cam.PrepareSurfaceForVideo(MyTaskIndex";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "preparesurface"), parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_preparesurfaceforvideo" /*RemoteObject*/ ,(Object)(parent._mytaskindex),(Object)(parent._videofiledir),(Object)(RemoteObject.concat(RemoteObject.createImmutable("temp-"),parent._videofilename))));
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
 BA.debugLineNum = 87;BA.debugLine="cam.PreviewSize.Initialize(1920, 1080)";
Debug.ShouldStop(4194304);
parent.mostCurrent._cam.getField(false,"_previewsize" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 1920)),(Object)(BA.numberCast(int.class, 1080)));
 BA.debugLineNum = 88;BA.debugLine="Wait For (cam.PrepareSurface(MyTaskIndex)) Compl";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "preparesurface"), parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_preparesurface" /*RemoteObject*/ ,(Object)(parent._mytaskindex)));
this.state = 13;
return;
case 13:
//C
this.state = 6;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 if (true) break;
;
 BA.debugLineNum = 90;BA.debugLine="If Success Then cam.StartPreview(MyTaskIndex, Vid";
Debug.ShouldStop(33554432);

case 6:
//if
this.state = 11;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 8;
;}if (true) break;

case 8:
//C
this.state = 11;
parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_startpreview" /*RemoteObject*/ ,(Object)(parent._mytaskindex),(Object)(parent._videomode));
if (true) break;

case 11:
//C
this.state = -1;
;
 BA.debugLineNum = 91;BA.debugLine="SetState(Success, busystate, VideoMode)";
Debug.ShouldStop(67108864);
_setstate(_success,parent._busystate,parent._videomode);
 BA.debugLineNum = 92;BA.debugLine="Return Success";
Debug.ShouldStop(134217728);
if (true) {
parent.mostCurrent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(_success));return;};
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example3.main");
camex2.myClass = BA.getDeviceClass ("b4a.example3.camex2");
starter.myClass = BA.getDeviceClass ("b4a.example3.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private frontCamera As Boolean = False";
main._frontcamera = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 18;BA.debugLine="Private VideoMode As Boolean = False";
main._videomode = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 19;BA.debugLine="Private VideoFileDir, VideoFileName As String";
main._videofiledir = RemoteObject.createImmutable("");
main._videofilename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Private MyTaskIndex As Int";
main._mytaskindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 21;BA.debugLine="Private rp As RuntimePermissions";
main._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setstate(RemoteObject _open,RemoteObject _busy,RemoteObject _video) throws Exception{
try {
		Debug.PushSubsStack("SetState (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,209);
if (RapidSub.canDelegate("setstate")) { return b4a.example3.main.remoteMe.runUserSub(false, "main","setstate", _open, _busy, _video);}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _btnrecordtext = RemoteObject.createImmutable("");
Debug.locals.put("Open", _open);
Debug.locals.put("Busy", _busy);
Debug.locals.put("Video", _video);
 BA.debugLineNum = 209;BA.debugLine="Sub SetState(Open As Boolean, Busy As Boolean, Vid";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="For Each b As Button In buttons";
Debug.ShouldStop(131072);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
{
final RemoteObject group1 = main.mostCurrent._buttons;
final int groupLen1 = group1.runMethod(true,"getSize").<Integer>get()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_b.setObject(group1.runMethod(false,"Get",index1));
Debug.locals.put("b", _b);
 BA.debugLineNum = 211;BA.debugLine="b.Visible = Open And Not(Busy)";
Debug.ShouldStop(262144);
_b.runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean(".",_open) && RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy)))));
 }
}Debug.locals.put("b", _b);
;
 BA.debugLineNum = 213;BA.debugLine="btnCamera.Visible = Not(Busy)";
Debug.ShouldStop(1048576);
main.mostCurrent._btncamera.runMethod(true,"setVisible",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy)));
 BA.debugLineNum = 214;BA.debugLine="btnRecord.Visible = Open And (Video Or Not(Busy))";
Debug.ShouldStop(2097152);
main.mostCurrent._btnrecord.runMethod(true,"setVisible",BA.ObjectToBoolean(RemoteObject.solveBoolean(".",_open) && RemoteObject.solveBoolean(".",BA.ObjectToBoolean((RemoteObject.solveBoolean(".",_video) || RemoteObject.solveBoolean(".",main.mostCurrent.__c.runMethod(true,"Not",(Object)(_busy))))))));
 BA.debugLineNum = 215;BA.debugLine="openstate = Open";
Debug.ShouldStop(4194304);
main._openstate = _open;
 BA.debugLineNum = 216;BA.debugLine="ProgressBar1.Visible = Busy";
Debug.ShouldStop(8388608);
main.mostCurrent._progressbar1.runMethod(true,"setVisible",_busy);
 BA.debugLineNum = 217;BA.debugLine="busystate = Busy";
Debug.ShouldStop(16777216);
main._busystate = _busy;
 BA.debugLineNum = 218;BA.debugLine="VideoMode = Video";
Debug.ShouldStop(33554432);
main._videomode = _video;
 BA.debugLineNum = 219;BA.debugLine="barZoom.Visible = Open";
Debug.ShouldStop(67108864);
main.mostCurrent._barzoom.runMethod(true,"setVisible",_open);
 BA.debugLineNum = 220;BA.debugLine="Dim btnRecordText As String";
Debug.ShouldStop(134217728);
_btnrecordtext = RemoteObject.createImmutable("");Debug.locals.put("btnRecordText", _btnrecordtext);
 BA.debugLineNum = 221;BA.debugLine="If VideoMode Then";
Debug.ShouldStop(268435456);
if (main._videomode.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 222;BA.debugLine="If Busy Then";
Debug.ShouldStop(536870912);
if (_busy.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 223;BA.debugLine="btnRecordText = Chr(0xF04D)";
Debug.ShouldStop(1073741824);
_btnrecordtext = BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf04d))));Debug.locals.put("btnRecordText", _btnrecordtext);
 }else {
 BA.debugLineNum = 225;BA.debugLine="btnRecordText = Chr(0xF03D)";
Debug.ShouldStop(1);
_btnrecordtext = BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf03d))));Debug.locals.put("btnRecordText", _btnrecordtext);
 };
 }else {
 BA.debugLineNum = 228;BA.debugLine="btnRecordText = Chr(0xF030)";
Debug.ShouldStop(8);
_btnrecordtext = BA.ObjectToString(main.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0xf030))));Debug.locals.put("btnRecordText", _btnrecordtext);
 };
 BA.debugLineNum = 230;BA.debugLine="btnRecord.Text = btnRecordText";
Debug.ShouldStop(32);
main.mostCurrent._btnrecord.runMethod(true,"setText",BA.ObjectToCharSequence(_btnrecordtext));
 BA.debugLineNum = 231;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("TakePicture (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,150);
if (RapidSub.canDelegate("takepicture")) { b4a.example3.main.remoteMe.runUserSub(false, "main","takepicture"); return;}
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
public ResumableSub_TakePicture(b4a.example3.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example3.main parent;
RemoteObject _data = null;
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("TakePicture (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,150);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 151;BA.debugLine="Try";
Debug.ShouldStop(4194304);
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
 BA.debugLineNum = 152;BA.debugLine="SetState(openstate, True, VideoMode)";
Debug.ShouldStop(8388608);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"True"),parent._videomode);
 BA.debugLineNum = 153;BA.debugLine="Wait For(cam.FocusAndTakePicture(MyTaskIndex)) C";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "takepicture"), parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_focusandtakepicture" /*RemoteObject*/ ,(Object)(parent._mytaskindex)));
this.state = 7;
return;
case 7:
//C
this.state = 6;
_data = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("Data", _data);
;
 BA.debugLineNum = 154;BA.debugLine="SetState(openstate, False, VideoMode)";
Debug.ShouldStop(33554432);
_setstate(parent._openstate,parent.mostCurrent.__c.getField(true,"False"),parent._videomode);
 BA.debugLineNum = 155;BA.debugLine="cam.DataToFile(Data, VideoFileDir, \"1.jpg\")";
Debug.ShouldStop(67108864);
parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_datatofile" /*RemoteObject*/ ,(Object)(_data),(Object)(parent._videofiledir),(Object)(RemoteObject.createImmutable("1.jpg")));
 BA.debugLineNum = 156;BA.debugLine="Dim bmp As Bitmap = cam.DataToBitmap(Data)";
Debug.ShouldStop(134217728);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = parent.mostCurrent._cam.runClassMethod (b4a.example3.camex2.class, "_datatobitmap" /*RemoteObject*/ ,(Object)(_data));Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 157;BA.debugLine="Log(\"Picture taken: \" & bmp) 'ignore";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","4786439",RemoteObject.concat(RemoteObject.createImmutable("Picture taken: "),_bmp),0);
 BA.debugLineNum = 158;BA.debugLine="pnlBackground.SetVisibleAnimated(100, True)";
Debug.ShouldStop(536870912);
parent.mostCurrent._pnlbackground.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 100)),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 159;BA.debugLine="pnlPicture.SetBackgroundImage(bmp.Resize(pnlPict";
Debug.ShouldStop(1073741824);
parent.mostCurrent._pnlpicture.runMethod(false,"SetBackgroundImageNew",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, parent.mostCurrent._pnlpicture.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, parent.mostCurrent._pnlpicture.runMethod(true,"getHeight"))),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject()))).runMethod(true,"setGravity",parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 160;BA.debugLine="Sleep(4000)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("Sleep",main.mostCurrent.activityBA,anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "takepicture"),BA.numberCast(int.class, 4000));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 BA.debugLineNum = 161;BA.debugLine="pnlBackground.SetVisibleAnimated(500, False)";
Debug.ShouldStop(1);
parent.mostCurrent._pnlbackground.runVoidMethod ("SetVisibleAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 Debug.CheckDeviceExceptions();
if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
 BA.debugLineNum = 163;BA.debugLine="HandleError(LastException)";
Debug.ShouldStop(4);
_handleerror(parent.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA));
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e0.toString());}
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