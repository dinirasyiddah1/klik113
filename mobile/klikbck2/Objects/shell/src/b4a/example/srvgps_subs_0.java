package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class srvgps_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,40);
if (RapidSub.canDelegate("application_error")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","application_error", _error, _stacktrace);}
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 40;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Return True";
Debug.ShouldStop(256);
if (true) return srvgps.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gps_locationchanged(RemoteObject _location1) throws Exception{
try {
		Debug.PushSubsStack("GPS_LocationChanged (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,34);
if (RapidSub.canDelegate("gps_locationchanged")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","gps_locationchanged", _location1);}
Debug.locals.put("Location1", _location1);
 BA.debugLineNum = 34;BA.debugLine="Sub GPS_LocationChanged (Location1 As Location)";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="CallSub2(actLapor, \"LocationChanged\", Location1)";
Debug.ShouldStop(4);
srvgps.mostCurrent.__c.runMethodAndSync(false,"CallSubNew2",srvgps.processBA,(Object)((srvgps.mostCurrent._actlapor.getObject())),(Object)(BA.ObjectToString("LocationChanged")),(Object)((_location1)));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Public rp As RuntimePermissions";
srvgps._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 8;BA.debugLine="Public GPS1 As GPS";
srvgps._gps1 = RemoteObject.createNew ("anywheresoftware.b4a.gps.GPS");
 //BA.debugLineNum = 9;BA.debugLine="Private gpsStarted As Boolean";
srvgps._gpsstarted = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","service_create");}
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 13;BA.debugLine="GPS1.Initialize(\"GPS\")";
Debug.ShouldStop(4096);
srvgps._gps1.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("GPS")));
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,44);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","service_destroy");}
 BA.debugLineNum = 44;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,16);
if (RapidSub.canDelegate("service_start")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="Service.StopAutomaticForeground 'Call this when t";
Debug.ShouldStop(65536);
srvgps.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _startgps() throws Exception{
try {
		Debug.PushSubsStack("StartGps (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,20);
if (RapidSub.canDelegate("startgps")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","startgps");}
 BA.debugLineNum = 20;BA.debugLine="Public Sub StartGps";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="If gpsStarted = False Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",srvgps._gpsstarted,srvgps.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 22;BA.debugLine="GPS1.Start(0, 0)";
Debug.ShouldStop(2097152);
srvgps._gps1.runVoidMethodAndSync ("Start",srvgps.processBA,(Object)(BA.numberCast(long.class, 0)),(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 23;BA.debugLine="gpsStarted = True";
Debug.ShouldStop(4194304);
srvgps._gpsstarted = srvgps.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _stopgps() throws Exception{
try {
		Debug.PushSubsStack("StopGps (srvgps) ","srvgps",5,srvgps.processBA,srvgps.mostCurrent,27);
if (RapidSub.canDelegate("stopgps")) { return b4a.example.srvgps.remoteMe.runUserSub(false, "srvgps","stopgps");}
 BA.debugLineNum = 27;BA.debugLine="Public Sub StopGps";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="If gpsStarted Then";
Debug.ShouldStop(134217728);
if (srvgps._gpsstarted.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 29;BA.debugLine="GPS1.Stop";
Debug.ShouldStop(268435456);
srvgps._gps1.runVoidMethod ("Stop");
 BA.debugLineNum = 30;BA.debugLine="gpsStarted = False";
Debug.ShouldStop(536870912);
srvgps._gpsstarted = srvgps.mostCurrent.__c.getField(true,"False");
 };
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
}