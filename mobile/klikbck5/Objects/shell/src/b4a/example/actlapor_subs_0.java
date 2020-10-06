package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class actlapor_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,31);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_create", _firsttime);}
RemoteObject _permissionsgoodflag = RemoteObject.createImmutable(false);
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _iview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _dir = RemoteObject.createImmutable("");
RemoteObject _media = RemoteObject.createImmutable("");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="Activity.LoadLayout(\"lapor\")";
Debug.ShouldStop(1);
actlapor.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("lapor")),actlapor.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="Dim PermissionsGoodFlag As Boolean = True";
Debug.ShouldStop(8);
_permissionsgoodflag = actlapor.mostCurrent.__c.getField(true,"True");Debug.locals.put("PermissionsGoodFlag", _permissionsgoodflag);Debug.locals.put("PermissionsGoodFlag", _permissionsgoodflag);
 BA.debugLineNum = 37;BA.debugLine="Dim b As BitmapDrawable";
Debug.ShouldStop(16);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("b", _b);
 BA.debugLineNum = 40;BA.debugLine="Dim iView As ImageView";
Debug.ShouldStop(128);
_iview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iView", _iview);
 BA.debugLineNum = 41;BA.debugLine="Dim dir As String = File.DirDefaultExternal";
Debug.ShouldStop(256);
_dir = actlapor.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal");Debug.locals.put("dir", _dir);Debug.locals.put("dir", _dir);
 BA.debugLineNum = 42;BA.debugLine="Dim media As String = \"1.jpg\"";
Debug.ShouldStop(512);
_media = BA.ObjectToString("1.jpg");Debug.locals.put("media", _media);Debug.locals.put("media", _media);
 BA.debugLineNum = 44;BA.debugLine="If PermissionsGoodFlag Then";
Debug.ShouldStop(2048);
if (_permissionsgoodflag.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 45;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
Debug.ShouldStop(4096);
actlapor._rp.runVoidMethod ("CheckAndRequest",actlapor.processBA,(Object)(actlapor._rp.getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE")));
 BA.debugLineNum = 46;BA.debugLine="b.Initialize(LoadBitmap(dir, media))";
Debug.ShouldStop(8192);
_b.runVoidMethod ("Initialize",(Object)((actlapor.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_media)).getObject())));
 BA.debugLineNum = 51;BA.debugLine="iView.Initialize(\"iV\")";
Debug.ShouldStop(262144);
_iview.runVoidMethod ("Initialize",actlapor.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("iV")));
 BA.debugLineNum = 52;BA.debugLine="Activity.AddView(iView,10%x, 50dip, 80%x, 30%y)";
Debug.ShouldStop(524288);
actlapor.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_iview.getObject())),(Object)(actlapor.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),actlapor.mostCurrent.activityBA)),(Object)(actlapor.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(actlapor.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),actlapor.mostCurrent.activityBA)),(Object)(actlapor.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 30)),actlapor.mostCurrent.activityBA)));
 BA.debugLineNum = 54;BA.debugLine="iView.Bitmap=LoadBitmap(dir, media)";
Debug.ShouldStop(2097152);
_iview.runMethod(false,"setBitmap",(actlapor.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(_dir),(Object)(_media)).getObject()));
 };
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,66);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Resume (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,60);
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
		Debug.PushSubsStack("Activity_Resume (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,60);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 61;BA.debugLine="srvGPS.rp.CheckAndRequest(srvGPS.rp.PERMISSION_AC";
Debug.ShouldStop(268435456);
parent.mostCurrent._srvgps._rp /*RemoteObject*/ .runVoidMethod ("CheckAndRequest",actlapor.processBA,(Object)(parent.mostCurrent._srvgps._rp /*RemoteObject*/ .getField(true,"PERMISSION_ACCESS_FINE_LOCATION")));
 BA.debugLineNum = 62;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", actlapor.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "actlapor", "activity_resume"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 63;BA.debugLine="If Result Then CallSubDelayed(srvGPS, \"StartGPS\")";
Debug.ShouldStop(1073741824);
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
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("btnLapor_Click (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,88);
if (RapidSub.canDelegate("btnlapor_click")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","btnlapor_click");}
RemoteObject _lokasi = RemoteObject.createImmutable("");
RemoteObject _nama_orang = RemoteObject.createImmutable("");
RemoteObject _no_hp = RemoteObject.createImmutable("");
RemoteObject _lat = RemoteObject.createImmutable(0);
RemoteObject _lon = RemoteObject.createImmutable(0);
RemoteObject _tanggal = RemoteObject.createImmutable("");
RemoteObject _jam = RemoteObject.createImmutable("");
RemoteObject _id_kejadian = RemoteObject.createImmutable(0);
RemoteObject _media = RemoteObject.createImmutable("");
RemoteObject _job1 = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 88;BA.debugLine="Sub btnLapor_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="Dim lokasi As String";
Debug.ShouldStop(16777216);
_lokasi = RemoteObject.createImmutable("");Debug.locals.put("lokasi", _lokasi);
 BA.debugLineNum = 90;BA.debugLine="lokasi = address.Text";
Debug.ShouldStop(33554432);
_lokasi = actlapor.mostCurrent._address.runMethod(true,"getText");Debug.locals.put("lokasi", _lokasi);
 BA.debugLineNum = 91;BA.debugLine="Log(lokasi)";
Debug.ShouldStop(67108864);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490371",_lokasi,0);
 BA.debugLineNum = 93;BA.debugLine="Dim nama_orang As String";
Debug.ShouldStop(268435456);
_nama_orang = RemoteObject.createImmutable("");Debug.locals.put("nama_orang", _nama_orang);
 BA.debugLineNum = 94;BA.debugLine="nama_orang = name.Text";
Debug.ShouldStop(536870912);
_nama_orang = actlapor.mostCurrent._name.runMethod(true,"getText");Debug.locals.put("nama_orang", _nama_orang);
 BA.debugLineNum = 95;BA.debugLine="Log(nama_orang)";
Debug.ShouldStop(1073741824);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490375",_nama_orang,0);
 BA.debugLineNum = 97;BA.debugLine="Dim no_hp As String";
Debug.ShouldStop(1);
_no_hp = RemoteObject.createImmutable("");Debug.locals.put("no_hp", _no_hp);
 BA.debugLineNum = 98;BA.debugLine="no_hp = phone.Text";
Debug.ShouldStop(2);
_no_hp = actlapor.mostCurrent._phone.runMethod(true,"getText");Debug.locals.put("no_hp", _no_hp);
 BA.debugLineNum = 99;BA.debugLine="Log(no_hp)";
Debug.ShouldStop(4);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490379",_no_hp,0);
 BA.debugLineNum = 101;BA.debugLine="Dim lat As Double";
Debug.ShouldStop(16);
_lat = RemoteObject.createImmutable(0);Debug.locals.put("lat", _lat);
 BA.debugLineNum = 102;BA.debugLine="lat = EditLat.Text";
Debug.ShouldStop(32);
_lat = BA.numberCast(double.class, actlapor.mostCurrent._editlat.runMethod(true,"getText"));Debug.locals.put("lat", _lat);
 BA.debugLineNum = 103;BA.debugLine="Log(lat)";
Debug.ShouldStop(64);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490383",BA.NumberToString(_lat),0);
 BA.debugLineNum = 105;BA.debugLine="Dim lon As Double";
Debug.ShouldStop(256);
_lon = RemoteObject.createImmutable(0);Debug.locals.put("lon", _lon);
 BA.debugLineNum = 106;BA.debugLine="lon = EditLon.Text";
Debug.ShouldStop(512);
_lon = BA.numberCast(double.class, actlapor.mostCurrent._editlon.runMethod(true,"getText"));Debug.locals.put("lon", _lon);
 BA.debugLineNum = 107;BA.debugLine="Log(lon)";
Debug.ShouldStop(1024);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490387",BA.NumberToString(_lon),0);
 BA.debugLineNum = 109;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
Debug.ShouldStop(4096);
actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("yyyy-MM-dd"));
 BA.debugLineNum = 110;BA.debugLine="Dim tanggal= DateTime.Date(DateTime.now)";
Debug.ShouldStop(8192);
_tanggal = actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("tanggal", _tanggal);Debug.locals.put("tanggal", _tanggal);
 BA.debugLineNum = 111;BA.debugLine="Log(tanggal)";
Debug.ShouldStop(16384);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490391",_tanggal,0);
 BA.debugLineNum = 114;BA.debugLine="DateTime.TimeFormat = \"hh:mm\"";
Debug.ShouldStop(131072);
actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("hh:mm"));
 BA.debugLineNum = 115;BA.debugLine="Dim jam = DateTime.Time(DateTime.Now)";
Debug.ShouldStop(262144);
_jam = actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(actlapor.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")));Debug.locals.put("jam", _jam);Debug.locals.put("jam", _jam);
 BA.debugLineNum = 116;BA.debugLine="Log (jam)";
Debug.ShouldStop(524288);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490396",_jam,0);
 BA.debugLineNum = 118;BA.debugLine="Dim id_kejadian As Int";
Debug.ShouldStop(2097152);
_id_kejadian = RemoteObject.createImmutable(0);Debug.locals.put("id_kejadian", _id_kejadian);
 BA.debugLineNum = 119;BA.debugLine="id_kejadian = 0";
Debug.ShouldStop(4194304);
_id_kejadian = BA.numberCast(int.class, 0);Debug.locals.put("id_kejadian", _id_kejadian);
 BA.debugLineNum = 120;BA.debugLine="Log(id_kejadian)";
Debug.ShouldStop(8388608);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82490400",BA.NumberToString(_id_kejadian),0);
 BA.debugLineNum = 122;BA.debugLine="Dim media As String = \"1.jpg\"";
Debug.ShouldStop(33554432);
_media = BA.ObjectToString("1.jpg");Debug.locals.put("media", _media);Debug.locals.put("media", _media);
 BA.debugLineNum = 124;BA.debugLine="Dim Job1 As HttpJob";
Debug.ShouldStop(134217728);
_job1 = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 125;BA.debugLine="Job1.Initialize(\"Job1\",Me)";
Debug.ShouldStop(268435456);
_job1.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,actlapor.processBA,(Object)(BA.ObjectToString("Job1")),(Object)(actlapor.getObject()));
 BA.debugLineNum = 126;BA.debugLine="Job1.PostString(\"\"&server&\"upload.php\",\"&nama_ora";
Debug.ShouldStop(536870912);
_job1.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),actlapor._server,RemoteObject.createImmutable("upload.php"))),(Object)(RemoteObject.concat(RemoteObject.createImmutable("&nama_orang="),_nama_orang,RemoteObject.createImmutable("&lokasi="),_lokasi,RemoteObject.createImmutable("&no_hp="),_no_hp,RemoteObject.createImmutable("&tanggal="),_tanggal,RemoteObject.createImmutable("&FileName="),_media,RemoteObject.createImmutable("&jam="),_jam,RemoteObject.createImmutable("&lat="),_lat,RemoteObject.createImmutable("&lon="),_lon,RemoteObject.createImmutable("&id_kejadian="),_id_kejadian)));
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("ExecuteRemoteQuery (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,81);
if (RapidSub.canDelegate("executeremotequery")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","executeremotequery", _query, _jobname);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("Query", _query);
Debug.locals.put("JobName", _jobname);
 BA.debugLineNum = 81;BA.debugLine="Sub ExecuteRemoteQuery(Query As String, JobName As";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="Dim Job As HttpJob";
Debug.ShouldStop(131072);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("Job", _job);
 BA.debugLineNum = 83;BA.debugLine="Job.Initialize(JobName, Me)";
Debug.ShouldStop(262144);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,actlapor.processBA,(Object)(_jobname),(Object)(actlapor.getObject()));
 BA.debugLineNum = 84;BA.debugLine="Job.PostString(\"\"&server&\"json.php\",Query)";
Debug.ShouldStop(524288);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(RemoteObject.concat(RemoteObject.createImmutable(""),actlapor._server,RemoteObject.createImmutable("json.php"))),(Object)(_query));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim lblLon As Label";
actlapor.mostCurrent._lbllon = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim lblLat As Label";
actlapor.mostCurrent._lbllat = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private pnlBg As Panel";
actlapor.mostCurrent._pnlbg = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private pnlFile As Panel";
actlapor.mostCurrent._pnlfile = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private address As EditText";
actlapor.mostCurrent._address = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private name As EditText";
actlapor.mostCurrent._name = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private phone As EditText";
actlapor.mostCurrent._phone = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private btnLapor As Button";
actlapor.mostCurrent._btnlapor = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Type id_lines (id_laporan As String)";
;
 //BA.debugLineNum = 27;BA.debugLine="Private EditLat As EditText";
actlapor.mostCurrent._editlat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private EditLon As EditText";
actlapor.mostCurrent._editlon = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _id_laporan() throws Exception{
try {
		Debug.PushSubsStack("id_laporan (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,77);
if (RapidSub.canDelegate("id_laporan")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","id_laporan");}
 BA.debugLineNum = 77;BA.debugLine="Sub id_laporan";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="ExecuteRemoteQuery(\"SELECT max(id_laporan) FROM d";
Debug.ShouldStop(8192);
_executeremotequery(BA.ObjectToString("SELECT max(id_laporan) FROM detail_pelapor"),RemoteObject.createImmutable("tampil_id"));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("JobDone (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,130);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","jobdone", _job1);}
Debug.locals.put("Job1", _job1);
 BA.debugLineNum = 130;BA.debugLine="Sub JobDone (Job1 As HttpJob)";
Debug.ShouldStop(2);
 BA.debugLineNum = 131;BA.debugLine="Log(\"JobName = \" & Job1.JobName & \", Success = \"";
Debug.ShouldStop(4);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82555905",RemoteObject.concat(RemoteObject.createImmutable("JobName = "),_job1.getField(true,"_jobname" /*RemoteObject*/ ),RemoteObject.createImmutable(", Success = "),_job1.getField(true,"_success" /*RemoteObject*/ )),0);
 BA.debugLineNum = 132;BA.debugLine="If Job1.Success = True Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_job1.getField(true,"_success" /*RemoteObject*/ ),actlapor.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 133;BA.debugLine="Select Job1.JobName";
Debug.ShouldStop(16);
switch (BA.switchObjectToInt(_job1.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("Job1"))) {
case 0: {
 BA.debugLineNum = 136;BA.debugLine="Log(\"behasil\")";
Debug.ShouldStop(128);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82555910",RemoteObject.createImmutable("behasil"),0);
 BA.debugLineNum = 137;BA.debugLine="Msgbox(\"Report Data Success\",\"Success\")";
Debug.ShouldStop(256);
actlapor.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Report Data Success")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Success"))),actlapor.mostCurrent.activityBA);
 break; }
}
;
 }else {
 BA.debugLineNum = 143;BA.debugLine="Log(\"Error: \" & Job1.ErrorMessage)";
Debug.ShouldStop(16384);
actlapor.mostCurrent.__c.runVoidMethod ("LogImpl","82555917",RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job1.getField(true,"_errormessage" /*RemoteObject*/ )),0);
 BA.debugLineNum = 144;BA.debugLine="ToastMessageShow(\"Error: \" & Job1.ErrorMessage,";
Debug.ShouldStop(32768);
actlapor.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job1.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(actlapor.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 146;BA.debugLine="Job1.Release";
Debug.ShouldStop(131072);
_job1.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _label4_click() throws Exception{
try {
		Debug.PushSubsStack("Label4_Click (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,151);
if (RapidSub.canDelegate("label4_click")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","label4_click");}
 BA.debugLineNum = 151;BA.debugLine="Sub Label4_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(8388608);
actlapor.mostCurrent.__c.runVoidMethod ("StartActivity",actlapor.processBA,(Object)((actlapor.mostCurrent._main.getObject())));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("LocationChanged (actlapor) ","actlapor",3,actlapor.mostCurrent.activityBA,actlapor.mostCurrent,72);
if (RapidSub.canDelegate("locationchanged")) { return b4a.example.actlapor.remoteMe.runUserSub(false, "actlapor","locationchanged", _location1);}
Debug.locals.put("Location1", _location1);
 BA.debugLineNum = 72;BA.debugLine="Public Sub LocationChanged(Location1 As Location)";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="EditLat.Text = \"\" & Location1.Latitude";
Debug.ShouldStop(256);
actlapor.mostCurrent._editlat.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(""),_location1.runMethod(true,"getLatitude"))));
 BA.debugLineNum = 74;BA.debugLine="EditLon.Text = \"\" & Location1.Longitude";
Debug.ShouldStop(512);
actlapor.mostCurrent._editlon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable(""),_location1.runMethod(true,"getLongitude"))));
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim server =\"http://4894ba1bb609.ngrok.io/klik113";
actlapor._server = BA.ObjectToString("http://4894ba1bb609.ngrok.io/klik113-master/mobile/");
 //BA.debugLineNum = 10;BA.debugLine="Private rp As RuntimePermissions";
actlapor._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}