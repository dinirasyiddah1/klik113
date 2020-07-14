package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actgps_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actgps) ","actgps",6,actgps.mostCurrent.activityBA,actgps.mostCurrent,16);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.actgps.remoteMe.runUserSub(false, "actgps","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 16;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 18;BA.debugLine="Activity.LoadLayout(\"gps\")";
Debug.ShouldStop(131072);
actgps.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("gps")),actgps.mostCurrent.activityBA);
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Pause (actgps) ","actgps",6,actgps.mostCurrent.activityBA,actgps.mostCurrent,30);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.actgps.remoteMe.runUserSub(false, "actgps","activity_pause", _userclosed);}
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
public static void  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (actgps) ","actgps",6,actgps.mostCurrent.activityBA,actgps.mostCurrent,22);
if (RapidSub.canDelegate("activity_resume")) { b4a.example.actgps.remoteMe.runUserSub(false, "actgps","activity_resume"); return;}
ResumableSub_Activity_Resume rsub = new ResumableSub_Activity_Resume(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Activity_Resume extends BA.ResumableSub {
public ResumableSub_Activity_Resume(b4a.example.actgps parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actgps parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (actgps) ","actgps",6,actgps.mostCurrent.activityBA,actgps.mostCurrent,22);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 24;BA.debugLine="srvGPS.rp.CheckAndRequest(srvGPS.rp.PERMISSION_A";
Debug.ShouldStop(8388608);
parent.mostCurrent._srvgps._rp /*RemoteObject*/ .runVoidMethod ("CheckAndRequest",actgps.processBA,(Object)(parent.mostCurrent._srvgps._rp /*RemoteObject*/ .getField(true,"PERMISSION_ACCESS_FINE_LOCATION")));
 BA.debugLineNum = 25;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
Debug.ShouldStop(16777216);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", actgps.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actgps", "activity_resume"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 26;BA.debugLine="If Result Then CallSubDelayed(srvGPS, \"StartGPS\"";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//if
this.state = 6;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
parent.mostCurrent.__c.runVoidMethod ("CallSubDelayed",actgps.processBA,(Object)((parent.mostCurrent._srvgps.getObject())),(Object)(RemoteObject.createImmutable("StartGPS")));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Dim lblLon As Label";
actgps.mostCurrent._lbllon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Dim lblLat As Label";
actgps.mostCurrent._lbllat = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _locationchanged(RemoteObject _location1) throws Exception{
try {
		Debug.PushSubsStack("LocationChanged (actgps) ","actgps",6,actgps.mostCurrent.activityBA,actgps.mostCurrent,36);
if (RapidSub.canDelegate("locationchanged")) { return b4a.example.actgps.remoteMe.runUserSub(false, "actgps","locationchanged", _location1);}
Debug.locals.put("Location1", _location1);
 BA.debugLineNum = 36;BA.debugLine="Public Sub LocationChanged(Location1 As Location)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="lblLat.Text = \"Lat = \" & Location1.ConvertToMinut";
Debug.ShouldStop(16);
actgps.mostCurrent._lbllat.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Lat = "),_location1.runMethod(true,"ConvertToMinutes",(Object)(_location1.runMethod(true,"getLatitude"))))));
 BA.debugLineNum = 38;BA.debugLine="lblLon.Text = \"Lon = \" & Location1.ConvertToMinut";
Debug.ShouldStop(32);
actgps.mostCurrent._lbllon.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Lon = "),_location1.runMethod(true,"ConvertToMinutes",(Object)(_location1.runMethod(true,"getLongitude"))))));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}