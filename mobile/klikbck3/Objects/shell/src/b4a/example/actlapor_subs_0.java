package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actlapor_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"lapor\")";
Debug.ShouldStop(-2147483648);
actlapor.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("lapor")),actlapor.mostCurrent.activityBA);
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static void  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,38);
if (RapidSub.canDelegate("activity_resume")) { b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_resume"); return;}
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
public ResumableSub_Activity_Resume(b4a.example.actlapor parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.actlapor parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,38);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 39;BA.debugLine="srvGPS.rp.CheckAndRequest(srvGPS.rp.PERMISSION_AC";
Debug.ShouldStop(64);
parent.mostCurrent._srvgps._rp /*RemoteObject*/ .runVoidMethod ("CheckAndRequest",actlapor.processBA,(Object)(parent.mostCurrent._srvgps._rp /*RemoteObject*/ .getField(true,"PERMISSION_ACCESS_FINE_LOCATION")));
 BA.debugLineNum = 40;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", actlapor.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actlapor", "activity_resume"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 41;BA.debugLine="If Result Then CallSubDelayed(srvGPS, \"StartGPS\")";
Debug.ShouldStop(256);
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
parent.mostCurrent.__c.runVoidMethod ("CallSubDelayed",actlapor.processBA,(Object)((parent.mostCurrent._srvgps.getObject())),(Object)(RemoteObject.createImmutable("StartGPS")));
if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 42;BA.debugLine="End Sub";
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
public static void  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
}
public static RemoteObject  _btnlapor_click() throws Exception{
try {
		Debug.PushSubsStack("btnLapor_Click (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,64);
if (RapidSub.canDelegate("btnlapor_click")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","btnlapor_click");}
RemoteObject _lokasi = RemoteObject.createImmutable("");
RemoteObject _nama_orang = RemoteObject.createImmutable("");
RemoteObject _no_hp = RemoteObject.createImmutable("");
RemoteObject _lat = RemoteObject.createImmutable("");
RemoteObject _lon = RemoteObject.createImmutable("");
RemoteObject _tanggal = RemoteObject.createImmutable("");
RemoteObject _jam = RemoteObject.createImmutable("");
RemoteObject _id_kejadian = RemoteObject.createImmutable(0);
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 64;BA.debugLine="Sub btnLapor_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="Dim lokasi As String";
Debug.ShouldStop(1);
_lokasi = RemoteObject.createImmutable("");Debug.locals.put("lokasi", _lokasi);
 BA.debugLineNum = 66;BA.debugLine="lokasi = address.Text";
Debug.ShouldStop(2);
_lokasi = actlapor.mostCurrent._address.runMethod(true,"getText");Debug.locals.put("lokasi", _lokasi);
 BA.debugLineNum = 67;BA.debugLine="Log(lokasi)";
Debug.ShouldStop(4);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029315",_lokasi,0);
 BA.debugLineNum = 69;BA.debugLine="Dim nama_orang As String";
Debug.ShouldStop(16);
_nama_orang = RemoteObject.createImmutable("");Debug.locals.put("nama_orang", _nama_orang);
 BA.debugLineNum = 70;BA.debugLine="nama_orang = name.Text";
Debug.ShouldStop(32);
_nama_orang = actlapor.mostCurrent._name.runMethod(true,"getText");Debug.locals.put("nama_orang", _nama_orang);
 BA.debugLineNum = 71;BA.debugLine="Log(nama_orang)";
Debug.ShouldStop(64);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029319",_nama_orang,0);
 BA.debugLineNum = 73;BA.debugLine="Dim no_hp As String";
Debug.ShouldStop(256);
_no_hp = RemoteObject.createImmutable("");Debug.locals.put("no_hp", _no_hp);
 BA.debugLineNum = 74;BA.debugLine="no_hp = phone.Text";
Debug.ShouldStop(512);
_no_hp = actlapor.mostCurrent._phone.runMethod(true,"getText");Debug.locals.put("no_hp", _no_hp);
 BA.debugLineNum = 75;BA.debugLine="Log(no_hp)";
Debug.ShouldStop(1024);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029323",_no_hp,0);
 BA.debugLineNum = 77;BA.debugLine="Dim lat As String";
Debug.ShouldStop(4096);
_lat = RemoteObject.createImmutable("");Debug.locals.put("lat", _lat);
 BA.debugLineNum = 78;BA.debugLine="lat = lblLat.Text";
Debug.ShouldStop(8192);
_lat = actlapor.mostCurrent._lbllat.runMethod(true,"getText");Debug.locals.put("lat", _lat);
 BA.debugLineNum = 79;BA.debugLine="Log(lat)";
Debug.ShouldStop(16384);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029327",_lat,0);
 BA.debugLineNum = 81;BA.debugLine="Dim lon As String";
Debug.ShouldStop(65536);
_lon = RemoteObject.createImmutable("");Debug.locals.put("lon", _lon);
 BA.debugLineNum = 82;BA.debugLine="lon = lblLon.Text";
Debug.ShouldStop(131072);
_lon = actlapor.mostCurrent._lbllon.runMethod(true,"getText");Debug.locals.put("lon", _lon);
 BA.debugLineNum = 83;BA.debugLine="Log(lon)";
Debug.ShouldStop(262144);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029331",_lon,0);
 BA.debugLineNum = 85;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
Debug.ShouldStop(1048576);
actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 86;BA.debugLine="Dim tanggal= DateTime.Date(DateTime.now)";
Debug.ShouldStop(2097152);
_tanggal = actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("tanggal", _tanggal);Debug.locals.put("tanggal", _tanggal);
 BA.debugLineNum = 87;BA.debugLine="Log(tanggal)";
Debug.ShouldStop(4194304);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029335",_tanggal,0);
 BA.debugLineNum = 89;BA.debugLine="DateTime.TimeFormat = \"hh:mm\"";
Debug.ShouldStop(16777216);
actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh:mm"));
 BA.debugLineNum = 90;BA.debugLine="Dim jam = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(33554432);
_jam = actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("jam", _jam);Debug.locals.put("jam", _jam);
 BA.debugLineNum = 91;BA.debugLine="Log (jam)";
Debug.ShouldStop(67108864);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029339",_jam,0);
 BA.debugLineNum = 93;BA.debugLine="Dim id_kejadian As Int";
Debug.ShouldStop(268435456);
_id_kejadian = RemoteObject.createImmutable(0);Debug.locals.put("id_kejadian", _id_kejadian);
 BA.debugLineNum = 94;BA.debugLine="id_kejadian = 0";
Debug.ShouldStop(536870912);
_id_kejadian = BA.numberCast(int.class, 0);Debug.locals.put("id_kejadian", _id_kejadian);
 BA.debugLineNum = 95;BA.debugLine="Log(id_kejadian)";
Debug.ShouldStop(1073741824);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06029343",BA.NumberToString(_id_kejadian),0);
 BA.debugLineNum = 97;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(1);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 98;BA.debugLine="Job1.Initialize(\"Job1\",Me)";
Debug.ShouldStop(2);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,actlapor.processBA,(Object)(BA.ObjectToString("Job1")),(Object)(actlapor.getObject()));
 BA.debugLineNum = 99;BA.debugLine="Job1.PostString(\"\"&server&\"laporkan.php\",\"&nama_o";
Debug.ShouldStop(4);
_job1.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),actlapor._server,RemoteObject.createImmutable("laporkan.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("&nama_orang="),_nama_orang,RemoteObject.createImmutable("&lokasi="),_lokasi,RemoteObject.createImmutable("&no_hp="),_no_hp,RemoteObject.createImmutable("&tanggal="),_tanggal,RemoteObject.createImmutable("&jam="),_jam,RemoteObject.createImmutable("&lat="),_lat,RemoteObject.createImmutable("&lon="),_lon,RemoteObject.createImmutable("&id_kejadian="),_id_kejadian)));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executeremotequery(RemoteObject _query,RemoteObject _jobname) throws Exception{
try {
		Debug.PushSubsStack("ExecuteRemoteQuery (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,57);
if (RapidSub.canDelegate("executeremotequery")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","executeremotequery", _query, _jobname);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("Query", _query);
Debug.locals.put("JobName", _jobname);
 BA.debugLineNum = 57;BA.debugLine="Sub ExecuteRemoteQuery(Query As String, JobName As";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Dim Job As HttpJob";
Debug.ShouldStop(33554432);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job", _job);
 BA.debugLineNum = 59;BA.debugLine="Job.Initialize(JobName, Me)";
Debug.ShouldStop(67108864);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,actlapor.processBA,(Object)(_jobname),(Object)(actlapor.getObject()));
 BA.debugLineNum = 60;BA.debugLine="Job.PostString(\"\"&server&\"json.php\",Query)";
Debug.ShouldStop(134217728);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),actlapor._server,RemoteObject.createImmutable("json.php"))),(Object)(_query));
 BA.debugLineNum = 62;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
 //BA.debugLineNum = 15;BA.debugLine="Dim lblLon As Label";
actlapor.mostCurrent._lbllon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim lblLat As Label";
actlapor.mostCurrent._lbllat = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private pnlBg As Panel";
actlapor.mostCurrent._pnlbg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pnlFile As Panel";
actlapor.mostCurrent._pnlfile = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private address As EditText";
actlapor.mostCurrent._address = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private name As EditText";
actlapor.mostCurrent._name = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private phone As EditText";
actlapor.mostCurrent._phone = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnLapor As Button";
actlapor.mostCurrent._btnlapor = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Type id_lines (id_laporan As String)";
;
 //BA.debugLineNum = 26;BA.debugLine="Dim arrayid(100) As String";
actlapor.mostCurrent._arrayid = RemoteObject.createNewArray ("String", new int[] {100}, new Object[]{});
 //BA.debugLineNum = 27;BA.debugLine="Private tampil_id=\"tampil_id\" As String";
actlapor.mostCurrent._tampil_id = BA.ObjectToString("tampil_id");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _id_laporan() throws Exception{
try {
		Debug.PushSubsStack("id_laporan (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,53);
if (RapidSub.canDelegate("id_laporan")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","id_laporan");}
 BA.debugLineNum = 53;BA.debugLine="Sub id_laporan";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="ExecuteRemoteQuery(\"SELECT max(id_laporan) FROM d";
Debug.ShouldStop(2097152);
_executeremotequery(BA.ObjectToString("SELECT max(id_laporan) FROM detail_pelapor"),RemoteObject.createImmutable("tampil_id"));
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
public static RemoteObject  _jobdone(RemoteObject _job1) throws Exception{
try {
		Debug.PushSubsStack("JobDone (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,103);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","jobdone", _job1);}
Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 103;BA.debugLine="Sub JobDone (Job1 As HttpJob)";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="Log(\"JobName = \" & Job1.JobName & \", Success = \"";
Debug.ShouldStop(128);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06094849",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job1.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job1.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 105;BA.debugLine="If Job1.Success = True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_job1.getField(true,"_success" /*RemoteObject*/ ),actlapor.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 106;BA.debugLine="Select Job1.JobName";
Debug.ShouldStop(512);
switch (BA.switchObjectToInt(_job1.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("Job1"))) {
case 0: {
 BA.debugLineNum = 109;BA.debugLine="Log(\"behasil\")";
Debug.ShouldStop(4096);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06094854",RemoteObject.createImmutable("behasil"),0);
 BA.debugLineNum = 110;BA.debugLine="Msgbox(\"Report Data Success\",\"Success\")";
Debug.ShouldStop(8192);
actlapor.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Report Data Success")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Success"))),actlapor.mostCurrent.activityBA);
 break; }
}
;
 }else {
 BA.debugLineNum = 116;BA.debugLine="Log(\"Error: \" & Job1.ErrorMessage)";
Debug.ShouldStop(524288);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06094861",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job1.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 117;BA.debugLine="ToastMessageShow(\"Error: \" & Job1.ErrorMessage,";
Debug.ShouldStop(1048576);
actlapor.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job1.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(actlapor.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 119;BA.debugLine="Job1.Release";
Debug.ShouldStop(4194304);
_job1.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone1(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("jobdone1 (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,122);
if (RapidSub.canDelegate("jobdone1")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","jobdone1", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _array_id = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _f = RemoteObject.declareNull("b4a.example.actlapor._id_lines");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 122;BA.debugLine="Sub jobdone1 (Job As HttpJob)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 123;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(67108864);
actlapor.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 124;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(134217728);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 125;BA.debugLine="Dim res As String";
Debug.ShouldStop(268435456);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 126;BA.debugLine="Log(\"response :\" &res)";
Debug.ShouldStop(536870912);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","06160388",RemoteObject.concat(RemoteObject.createImmutable("response :"),_res),0);
 BA.debugLineNum = 127;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1073741824);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 128;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(-2147483648);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 129;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname" /*RemoteObject*/ ),actlapor.mostCurrent._tampil_id)) {
case 0: {
 BA.debugLineNum = 131;BA.debugLine="Dim array_id As List";
Debug.ShouldStop(4);
_array_id = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("array_id", _array_id);
 BA.debugLineNum = 132;BA.debugLine="array_id = parser.NextArray";
Debug.ShouldStop(8);
_array_id = _parser.runMethod(false,"NextArray");Debug.locals.put("array_id", _array_id);
 BA.debugLineNum = 133;BA.debugLine="For i=0 To array_id.Size -1";
Debug.ShouldStop(16);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {_array_id.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11) ;_i = ((int)(0 + _i + step11))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 134;BA.debugLine="Dim m As Map";
Debug.ShouldStop(32);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 135;BA.debugLine="m = array_id.Get(i)";
Debug.ShouldStop(64);
_m.setObject(_array_id.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 136;BA.debugLine="Dim f As id_lines";
Debug.ShouldStop(128);
_f = RemoteObject.createNew ("b4a.example.actlapor._id_lines");Debug.locals.put("f", _f);
 BA.debugLineNum = 137;BA.debugLine="f.Initialize";
Debug.ShouldStop(256);
_f.runVoidMethod ("Initialize");
 BA.debugLineNum = 138;BA.debugLine="f.id_laporan= m.Get(\"id_laporan\")";
Debug.ShouldStop(512);
_f.setField ("id_laporan" /*RemoteObject*/ ,BA.ObjectToString(_m.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id_laporan"))))));
 BA.debugLineNum = 139;BA.debugLine="arrayid (i) =f.id_laporan";
Debug.ShouldStop(1024);
actlapor.mostCurrent._arrayid.setArrayElement (_f.getField(true,"id_laporan" /*RemoteObject*/ ),BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 break; }
}
;
 };
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
public static RemoteObject  _locationchanged(RemoteObject _location1) throws Exception{
try {
		Debug.PushSubsStack("LocationChanged (actlapor) ","actlapor",4,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,48);
if (RapidSub.canDelegate("locationchanged")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","locationchanged", _location1);}
Debug.locals.put("Location1", _location1);
 BA.debugLineNum = 48;BA.debugLine="Public Sub LocationChanged(Location1 As Location)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="lblLat.Text = \"Lat = \" & Location1.ConvertToMinut";
Debug.ShouldStop(65536);
actlapor.mostCurrent._lbllat.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Lat = "),_location1.runMethod(true,"ConvertToMinutes",(Object)(_location1.runMethod(true,"getLatitude"))))));
 BA.debugLineNum = 50;BA.debugLine="lblLon.Text = \"Lon = \" & Location1.ConvertToMinut";
Debug.ShouldStop(131072);
actlapor.mostCurrent._lbllon.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Lon = "),_location1.runMethod(true,"ConvertToMinutes",(Object)(_location1.runMethod(true,"getLongitude"))))));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim server =\"http://27caa6b85e69.ngrok.io/klik113";
actlapor._server = BA.ObjectToString("http://27caa6b85e69.ngrok.io/klik113/mobile/");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}