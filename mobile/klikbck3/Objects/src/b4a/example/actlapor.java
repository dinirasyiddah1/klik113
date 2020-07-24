package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class actlapor extends Activity implements B4AActivity{
	public static actlapor mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.actlapor");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (actlapor).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.actlapor");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.actlapor", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (actlapor) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (actlapor) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return actlapor.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (actlapor) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            actlapor mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (actlapor) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }


public static class _id_lines{
public boolean IsInitialized;
public String id_laporan;
public void Initialize() {
IsInitialized = true;
id_laporan = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _server = "";
public anywheresoftware.b4a.objects.LabelWrapper _lbllon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllat = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbg = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlfile = null;
public anywheresoftware.b4a.objects.EditTextWrapper _address = null;
public anywheresoftware.b4a.objects.EditTextWrapper _name = null;
public anywheresoftware.b4a.objects.EditTextWrapper _phone = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnlapor = null;
public static String[] _arrayid = null;
public static String _tampil_id = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.actkamera _actkamera = null;
public b4a.example.srvgps _srvgps = null;
public b4a.example.gps _gps = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="Activity.LoadLayout(\"lapor\")";
mostCurrent._activity.LoadLayout("lapor",mostCurrent.activityBA);
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="actlapor";
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="End Sub";
return "";
}
public static void  _activity_resume() throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {Debug.delegate(mostCurrent.activityBA, "activity_resume", null); return;}
ResumableSub_Activity_Resume rsub = new ResumableSub_Activity_Resume(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Resume extends BA.ResumableSub {
public ResumableSub_Activity_Resume(b4a.example.actlapor parent) {
this.parent = parent;
}
b4a.example.actlapor parent;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="actlapor";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="srvGPS.rp.CheckAndRequest(srvGPS.rp.PERMISSION_AC";
parent.mostCurrent._srvgps._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,parent.mostCurrent._srvgps._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_ACCESS_FINE_LOCATION);
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "actlapor", "activity_resume"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="If Result Then CallSubDelayed(srvGPS, \"StartGPS\")";
if (true) break;

case 1:
//if
this.state = 6;
if (_result) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(parent.mostCurrent._srvgps.getObject()),"StartGPS");
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _btnlapor_click() throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnlapor_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnlapor_click", null));}
String _lokasi = "";
String _nama_orang = "";
String _no_hp = "";
String _lat = "";
String _lon = "";
String _tanggal = "";
String _jam = "";
int _id_kejadian = 0;
b4a.example.httpjob _job1 = null;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub btnLapor_Click";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Dim lokasi As String";
_lokasi = "";
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="lokasi = address.Text";
_lokasi = mostCurrent._address.getText();
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="Log(lokasi)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029315",_lokasi,0);
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="Dim nama_orang As String";
_nama_orang = "";
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="nama_orang = name.Text";
_nama_orang = mostCurrent._name.getText();
RDebugUtils.currentLine=6029319;
 //BA.debugLineNum = 6029319;BA.debugLine="Log(nama_orang)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029319",_nama_orang,0);
RDebugUtils.currentLine=6029321;
 //BA.debugLineNum = 6029321;BA.debugLine="Dim no_hp As String";
_no_hp = "";
RDebugUtils.currentLine=6029322;
 //BA.debugLineNum = 6029322;BA.debugLine="no_hp = phone.Text";
_no_hp = mostCurrent._phone.getText();
RDebugUtils.currentLine=6029323;
 //BA.debugLineNum = 6029323;BA.debugLine="Log(no_hp)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029323",_no_hp,0);
RDebugUtils.currentLine=6029325;
 //BA.debugLineNum = 6029325;BA.debugLine="Dim lat As String";
_lat = "";
RDebugUtils.currentLine=6029326;
 //BA.debugLineNum = 6029326;BA.debugLine="lat = lblLat.Text";
_lat = mostCurrent._lbllat.getText();
RDebugUtils.currentLine=6029327;
 //BA.debugLineNum = 6029327;BA.debugLine="Log(lat)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029327",_lat,0);
RDebugUtils.currentLine=6029329;
 //BA.debugLineNum = 6029329;BA.debugLine="Dim lon As String";
_lon = "";
RDebugUtils.currentLine=6029330;
 //BA.debugLineNum = 6029330;BA.debugLine="lon = lblLon.Text";
_lon = mostCurrent._lbllon.getText();
RDebugUtils.currentLine=6029331;
 //BA.debugLineNum = 6029331;BA.debugLine="Log(lon)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029331",_lon,0);
RDebugUtils.currentLine=6029333;
 //BA.debugLineNum = 6029333;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
RDebugUtils.currentLine=6029334;
 //BA.debugLineNum = 6029334;BA.debugLine="Dim tanggal= DateTime.Date(DateTime.now)";
_tanggal = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=6029335;
 //BA.debugLineNum = 6029335;BA.debugLine="Log(tanggal)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029335",_tanggal,0);
RDebugUtils.currentLine=6029337;
 //BA.debugLineNum = 6029337;BA.debugLine="DateTime.TimeFormat = \"hh:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("hh:mm");
RDebugUtils.currentLine=6029338;
 //BA.debugLineNum = 6029338;BA.debugLine="Dim jam = DateTime.Time(DateTime.Now)";
_jam = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=6029339;
 //BA.debugLineNum = 6029339;BA.debugLine="Log (jam)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029339",_jam,0);
RDebugUtils.currentLine=6029341;
 //BA.debugLineNum = 6029341;BA.debugLine="Dim id_kejadian As Int";
_id_kejadian = 0;
RDebugUtils.currentLine=6029342;
 //BA.debugLineNum = 6029342;BA.debugLine="id_kejadian = 0";
_id_kejadian = (int) (0);
RDebugUtils.currentLine=6029343;
 //BA.debugLineNum = 6029343;BA.debugLine="Log(id_kejadian)";
anywheresoftware.b4a.keywords.Common.LogImpl("06029343",BA.NumberToString(_id_kejadian),0);
RDebugUtils.currentLine=6029345;
 //BA.debugLineNum = 6029345;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=6029346;
 //BA.debugLineNum = 6029346;BA.debugLine="Job1.Initialize(\"Job1\",Me)";
_job1._initialize /*String*/ (null,processBA,"Job1",actlapor.getObject());
RDebugUtils.currentLine=6029347;
 //BA.debugLineNum = 6029347;BA.debugLine="Job1.PostString(\"\"&server&\"laporkan.php\",\"&nama_o";
_job1._poststring /*String*/ (null,""+_server+"laporkan.php","&nama_orang="+_nama_orang+"&lokasi="+_lokasi+"&no_hp="+_no_hp+"&tanggal="+_tanggal+"&jam="+_jam+"&lat="+_lat+"&lon="+_lon+"&id_kejadian="+BA.NumberToString(_id_kejadian));
RDebugUtils.currentLine=6029349;
 //BA.debugLineNum = 6029349;BA.debugLine="End Sub";
return "";
}
public static String  _executeremotequery(String _query,String _jobname) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "executeremotequery", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "executeremotequery", new Object[] {_query,_jobname}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub ExecuteRemoteQuery(Query As String, JobName As";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Dim Job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Job.Initialize(JobName, Me)";
_job._initialize /*String*/ (null,processBA,_jobname,actlapor.getObject());
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="Job.PostString(\"\"&server&\"json.php\",Query)";
_job._poststring /*String*/ (null,""+_server+"json.php",_query);
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="End Sub";
return "";
}
public static String  _id_laporan() throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "id_laporan", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "id_laporan", null));}
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub id_laporan";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="ExecuteRemoteQuery(\"SELECT max(id_laporan) FROM d";
_executeremotequery("SELECT max(id_laporan) FROM detail_pelapor","tampil_id");
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job1) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job1}));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub JobDone (Job1 As HttpJob)";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Log(\"JobName = \" & Job1.JobName & \", Success = \"";
anywheresoftware.b4a.keywords.Common.LogImpl("06094849","JobName = "+_job1._jobname /*String*/ +", Success = "+BA.ObjectToString(_job1._success /*boolean*/ ),0);
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="If Job1.Success = True Then";
if (_job1._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Select Job1.JobName";
switch (BA.switchObjectToInt(_job1._jobname /*String*/ ,"Job1")) {
case 0: {
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="Log(\"behasil\")";
anywheresoftware.b4a.keywords.Common.LogImpl("06094854","behasil",0);
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="Msgbox(\"Report Data Success\",\"Success\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Report Data Success"),BA.ObjectToCharSequence("Success"),mostCurrent.activityBA);
 break; }
}
;
 }else {
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="Log(\"Error: \" & Job1.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("06094861","Error: "+_job1._errormessage /*String*/ ,0);
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="ToastMessageShow(\"Error: \" & Job1.ErrorMessage,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job1._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=6094864;
 //BA.debugLineNum = 6094864;BA.debugLine="Job1.Release";
_job1._release /*String*/ (null);
RDebugUtils.currentLine=6094865;
 //BA.debugLineNum = 6094865;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone1(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone1", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone1", new Object[] {_job}));}
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _array_id = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
b4a.example.actlapor._id_lines _f = null;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub jobdone1 (Job As HttpJob)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="Log(\"response :\" &res)";
anywheresoftware.b4a.keywords.Common.LogImpl("06160388","response :"+_res,0);
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname /*String*/ ,mostCurrent._tampil_id)) {
case 0: {
RDebugUtils.currentLine=6160393;
 //BA.debugLineNum = 6160393;BA.debugLine="Dim array_id As List";
_array_id = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="array_id = parser.NextArray";
_array_id = _parser.NextArray();
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="For i=0 To array_id.Size -1";
{
final int step11 = 1;
final int limit11 = (int) (_array_id.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit11 ;_i = _i + step11 ) {
RDebugUtils.currentLine=6160396;
 //BA.debugLineNum = 6160396;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=6160397;
 //BA.debugLineNum = 6160397;BA.debugLine="m = array_id.Get(i)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_array_id.Get(_i)));
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="Dim f As id_lines";
_f = new b4a.example.actlapor._id_lines();
RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="f.Initialize";
_f.Initialize();
RDebugUtils.currentLine=6160400;
 //BA.debugLineNum = 6160400;BA.debugLine="f.id_laporan= m.Get(\"id_laporan\")";
_f.id_laporan /*String*/  = BA.ObjectToString(_m.Get((Object)("id_laporan")));
RDebugUtils.currentLine=6160401;
 //BA.debugLineNum = 6160401;BA.debugLine="arrayid (i) =f.id_laporan";
mostCurrent._arrayid[_i] = _f.id_laporan /*String*/ ;
 }
};
 break; }
}
;
 };
RDebugUtils.currentLine=6160408;
 //BA.debugLineNum = 6160408;BA.debugLine="End Sub";
return "";
}
public static String  _locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "locationchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "locationchanged", new Object[] {_location1}));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Public Sub LocationChanged(Location1 As Location)";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="lblLat.Text = \"Lat = \" & Location1.ConvertToMinut";
mostCurrent._lbllat.setText(BA.ObjectToCharSequence("Lat = "+_location1.ConvertToMinutes(_location1.getLatitude())));
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="lblLon.Text = \"Lon = \" & Location1.ConvertToMinut";
mostCurrent._lbllon.setText(BA.ObjectToCharSequence("Lon = "+_location1.ConvertToMinutes(_location1.getLongitude())));
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="End Sub";
return "";
}
}