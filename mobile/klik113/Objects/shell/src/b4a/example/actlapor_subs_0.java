package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actlapor_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"lapor\")";
Debug.ShouldStop(1048576);
actlapor.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("lapor")),actlapor.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="viewPicture";
Debug.ShouldStop(2097152);
_viewpicture();
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,30);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,26);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_resume");}
 BA.debugLineNum = 26;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Dim bmp As Bitmap";
actlapor.mostCurrent._bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private pnlPicture As Panel";
actlapor.mostCurrent._pnlpicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _viewpicture() throws Exception{
try {
		Debug.PushSubsStack("viewPicture (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,34);
if (RapidSub.canDelegate("viewpicture")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","viewpicture");}
 BA.debugLineNum = 34;BA.debugLine="Sub viewPicture";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="pnlPicture.SetBackgroundImage(bmp.Resize(pnlPict";
Debug.ShouldStop(4);
actlapor.mostCurrent._pnlpicture.runMethod(false,"SetBackgroundImageNew",(Object)((actlapor.mostCurrent._bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, actlapor.mostCurrent._pnlpicture.runMethod(true,"getWidth"))),(Object)(BA.numberCast(float.class, actlapor.mostCurrent._pnlpicture.runMethod(true,"getHeight"))),(Object)(actlapor.mostCurrent.__c.getField(true,"True"))).getObject()))).runMethod(true,"setGravity",actlapor.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}