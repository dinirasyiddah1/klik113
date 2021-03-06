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
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllat = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbg = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlfile = null;
public anywheresoftware.b4a.objects.EditTextWrapper _address = null;
public anywheresoftware.b4a.objects.EditTextWrapper _name = null;
public anywheresoftware.b4a.objects.EditTextWrapper _phone = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnlapor = null;
public anywheresoftware.b4a.objects.EditTextWrapper _editlat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _editlon = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.actkamera _actkamera = null;
public b4a.example.srvgps _srvgps = null;
public b4a.example.actcam _actcam = null;
public b4a.example.gps _gps = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
boolean _permissionsgoodflag = false;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _b = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iview = null;
String _dir = "";
String _media = "";
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Activity.LoadLayout(\"lapor\")";
mostCurrent._activity.LoadLayout("lapor",mostCurrent.activityBA);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Dim PermissionsGoodFlag As Boolean = True";
_permissionsgoodflag = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="Dim b As BitmapDrawable";
_b = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="Dim iView As ImageView";
_iview = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="Dim dir As String = File.DirDefaultExternal";
_dir = anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal();
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="Dim media As String = \"1.jpg\"";
_media = "1.jpg";
RDebugUtils.currentLine=2097165;
 //BA.debugLineNum = 2097165;BA.debugLine="If PermissionsGoodFlag Then";
if (_permissionsgoodflag) { 
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
_rp.CheckAndRequest(processBA,_rp.PERMISSION_WRITE_EXTERNAL_STORAGE);
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="b.Initialize(LoadBitmap(dir, media))";
_b.Initialize((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(_dir,_media).getObject()));
RDebugUtils.currentLine=2097172;
 //BA.debugLineNum = 2097172;BA.debugLine="iView.Initialize(\"iV\")";
_iview.Initialize(mostCurrent.activityBA,"iV");
RDebugUtils.currentLine=2097173;
 //BA.debugLineNum = 2097173;BA.debugLine="Activity.AddView(iView,10%x, 50dip, 80%x, 30%y)";
mostCurrent._activity.AddView((android.view.View)(_iview.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
RDebugUtils.currentLine=2097175;
 //BA.debugLineNum = 2097175;BA.debugLine="iView.Bitmap=LoadBitmap(dir, media)";
_iview.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(_dir,_media).getObject()));
 };
RDebugUtils.currentLine=2097179;
 //BA.debugLineNum = 2097179;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="actlapor";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="srvGPS.rp.CheckAndRequest(srvGPS.rp.PERMISSION_AC";
parent.mostCurrent._srvgps._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .CheckAndRequest(processBA,parent.mostCurrent._srvgps._rp /*anywheresoftware.b4a.objects.RuntimePermissions*/ .PERMISSION_ACCESS_FINE_LOCATION);
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "actlapor", "activity_resume"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="If Result Then CallSubDelayed(srvGPS, \"StartGPS\")";
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
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _btnlapor_click() throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnlapor_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnlapor_click", null); return;}
ResumableSub_btnLapor_Click rsub = new ResumableSub_btnLapor_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnLapor_Click extends BA.ResumableSub {
public ResumableSub_btnLapor_Click(b4a.example.actlapor parent) {
this.parent = parent;
}
b4a.example.actlapor parent;
String _lokasi = "";
String _nama_orang = "";
String _no_hp = "";
double _lat = 0;
double _lon = 0;
String _tanggal = "";
String _jam = "";
int _id_kejadian = 0;
b4a.example.httpjob _job1 = null;
b4a.example.httpjob _j = null;
String _img = "";
b4a.example.httpjob._multipartfiledata _mp = null;

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
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Dim lokasi As String";
_lokasi = "";
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="lokasi = address.Text";
_lokasi = parent.mostCurrent._address.getText();
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="Log(lokasi)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490373",_lokasi,0);
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Dim nama_orang As String";
_nama_orang = "";
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="nama_orang = name.Text";
_nama_orang = parent.mostCurrent._name.getText();
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="Log(nama_orang)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490377",_nama_orang,0);
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="Dim no_hp As String";
_no_hp = "";
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="no_hp = phone.Text";
_no_hp = parent.mostCurrent._phone.getText();
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="Log(no_hp)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490381",_no_hp,0);
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="Dim lat As Double";
_lat = 0;
RDebugUtils.currentLine=2490384;
 //BA.debugLineNum = 2490384;BA.debugLine="lat = EditLat.Text";
_lat = (double)(Double.parseDouble(parent.mostCurrent._editlat.getText()));
RDebugUtils.currentLine=2490385;
 //BA.debugLineNum = 2490385;BA.debugLine="Log(lat)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490385",BA.NumberToString(_lat),0);
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="Dim lon As Double";
_lon = 0;
RDebugUtils.currentLine=2490388;
 //BA.debugLineNum = 2490388;BA.debugLine="lon = EditLon.Text";
_lon = (double)(Double.parseDouble(parent.mostCurrent._editlon.getText()));
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="Log(lon)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490389",BA.NumberToString(_lon),0);
RDebugUtils.currentLine=2490391;
 //BA.debugLineNum = 2490391;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
RDebugUtils.currentLine=2490392;
 //BA.debugLineNum = 2490392;BA.debugLine="Dim tanggal= DateTime.Date(DateTime.now)";
_tanggal = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2490393;
 //BA.debugLineNum = 2490393;BA.debugLine="Log(tanggal)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490393",_tanggal,0);
RDebugUtils.currentLine=2490396;
 //BA.debugLineNum = 2490396;BA.debugLine="DateTime.TimeFormat = \"hh:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("hh:mm");
RDebugUtils.currentLine=2490397;
 //BA.debugLineNum = 2490397;BA.debugLine="Dim jam = DateTime.Time(DateTime.Now)";
_jam = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
RDebugUtils.currentLine=2490398;
 //BA.debugLineNum = 2490398;BA.debugLine="Log (jam)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490398",_jam,0);
RDebugUtils.currentLine=2490400;
 //BA.debugLineNum = 2490400;BA.debugLine="Dim id_kejadian As Int";
_id_kejadian = 0;
RDebugUtils.currentLine=2490401;
 //BA.debugLineNum = 2490401;BA.debugLine="id_kejadian = 0";
_id_kejadian = (int) (0);
RDebugUtils.currentLine=2490402;
 //BA.debugLineNum = 2490402;BA.debugLine="Log(id_kejadian)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490402",BA.NumberToString(_id_kejadian),0);
RDebugUtils.currentLine=2490406;
 //BA.debugLineNum = 2490406;BA.debugLine="Dim Job1 As HttpJob";
_job1 = new b4a.example.httpjob();
RDebugUtils.currentLine=2490407;
 //BA.debugLineNum = 2490407;BA.debugLine="Job1.Initialize(\"Job1\",Me)";
_job1._initialize /*String*/ (null,processBA,"Job1",actlapor.getObject());
RDebugUtils.currentLine=2490408;
 //BA.debugLineNum = 2490408;BA.debugLine="Job1.PostString(\"\"&server&\"laporkan.php\",\"&nama_o";
_job1._poststring /*String*/ (null,""+parent._server+"laporkan.php","&nama_orang="+_nama_orang+"&lokasi="+_lokasi+"&no_hp="+_no_hp+"&tanggal="+_tanggal+"&jam="+_jam+"&lat="+BA.NumberToString(_lat)+"&lon="+BA.NumberToString(_lon)+"&id_kejadian="+BA.NumberToString(_id_kejadian));
RDebugUtils.currentLine=2490412;
 //BA.debugLineNum = 2490412;BA.debugLine="Dim j As HttpJob";
_j = new b4a.example.httpjob();
RDebugUtils.currentLine=2490413;
 //BA.debugLineNum = 2490413;BA.debugLine="Dim img As String = \"1.jpg\"";
_img = "1.jpg";
RDebugUtils.currentLine=2490414;
 //BA.debugLineNum = 2490414;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize /*String*/ (null,processBA,"",actlapor.getObject());
RDebugUtils.currentLine=2490415;
 //BA.debugLineNum = 2490415;BA.debugLine="Dim mp As MultipartFileData";
_mp = new b4a.example.httpjob._multipartfiledata();
RDebugUtils.currentLine=2490416;
 //BA.debugLineNum = 2490416;BA.debugLine="mp.Initialize";
_mp.Initialize();
RDebugUtils.currentLine=2490417;
 //BA.debugLineNum = 2490417;BA.debugLine="mp.Dir = File.DirDefaultExternal";
_mp.Dir /*String*/  = anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal();
RDebugUtils.currentLine=2490418;
 //BA.debugLineNum = 2490418;BA.debugLine="mp.FileName = img";
_mp.FileName /*String*/  = _img;
RDebugUtils.currentLine=2490419;
 //BA.debugLineNum = 2490419;BA.debugLine="mp.KeyName = \"file\"";
_mp.KeyName /*String*/  = "file";
RDebugUtils.currentLine=2490420;
 //BA.debugLineNum = 2490420;BA.debugLine="mp.ContentType = \"image/jpg\"";
_mp.ContentType /*String*/  = "image/jpg";
RDebugUtils.currentLine=2490421;
 //BA.debugLineNum = 2490421;BA.debugLine="j.PostMultipart(\"http://369dbe9d93aa.ngrok.io/kli";
_j._postmultipart /*String*/ (null,"http://369dbe9d93aa.ngrok.io/klik113/mobile/UploadImage.php",(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(anywheresoftware.b4a.keywords.Common.Null)),anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_mp)}));
RDebugUtils.currentLine=2490422;
 //BA.debugLineNum = 2490422;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "actlapor", "btnlapor_click"), (Object)(_j));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_j = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=2490423;
 //BA.debugLineNum = 2490423;BA.debugLine="If j.Success Then";
if (true) break;

case 1:
//if
this.state = 10;
if (_j._success /*boolean*/ ) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=2490424;
 //BA.debugLineNum = 2490424;BA.debugLine="Log(j.GetString)";
anywheresoftware.b4a.keywords.Common.LogImpl("12490424",_j._getstring /*String*/ (null),0);
RDebugUtils.currentLine=2490425;
 //BA.debugLineNum = 2490425;BA.debugLine="If img = j.GetString Then";
if (true) break;

case 4:
//if
this.state = 9;
if ((_img).equals(_j._getstring /*String*/ (null))) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
RDebugUtils.currentLine=2490426;
 //BA.debugLineNum = 2490426;BA.debugLine="ToastMessageShow(\"Imagen Cargada.\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Imagen Cargada."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=2490428;
 //BA.debugLineNum = 2490428;BA.debugLine="ToastMessageShow(\"Error al cargar Imagen.\", Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error al cargar Imagen."),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 9:
//C
this.state = 10;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=2490431;
 //BA.debugLineNum = 2490431;BA.debugLine="j.Release";
_j._release /*String*/ (null);
RDebugUtils.currentLine=2490433;
 //BA.debugLineNum = 2490433;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _executeremotequery(String _query,String _jobname) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "executeremotequery", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "executeremotequery", new Object[] {_query,_jobname}));}
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub ExecuteRemoteQuery(Query As String, JobName As";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim Job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Job.Initialize(JobName, Me)";
_job._initialize /*String*/ (null,processBA,_jobname,actlapor.getObject());
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="Job.PostString(\"\"&server&\"json.php\",Query)";
_job._poststring /*String*/ (null,""+_server+"json.php",_query);
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="End Sub";
return "";
}
public static String  _id_laporan() throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "id_laporan", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "id_laporan", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub id_laporan";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="ExecuteRemoteQuery(\"SELECT max(id_laporan) FROM d";
_executeremotequery("SELECT max(id_laporan) FROM detail_pelapor","tampil_id");
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job1) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job1}));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub JobDone (Job1 As HttpJob)";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Log(\"JobName = \" & Job1.JobName & \", Success = \"";
anywheresoftware.b4a.keywords.Common.LogImpl("12555905","JobName = "+_job1._jobname /*String*/ +", Success = "+BA.ObjectToString(_job1._success /*boolean*/ ),0);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="If Job1.Success = True Then";
if (_job1._success /*boolean*/ ==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Select Job1.JobName";
switch (BA.switchObjectToInt(_job1._jobname /*String*/ ,"Job1")) {
case 0: {
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="Log(\"behasil\")";
anywheresoftware.b4a.keywords.Common.LogImpl("12555910","behasil",0);
RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="Msgbox(\"Report Data Success\",\"Success\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Report Data Success"),BA.ObjectToCharSequence("Success"),mostCurrent.activityBA);
 break; }
}
;
 }else {
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="Log(\"Error: \" & Job1.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("12555917","Error: "+_job1._errormessage /*String*/ ,0);
RDebugUtils.currentLine=2555918;
 //BA.debugLineNum = 2555918;BA.debugLine="ToastMessageShow(\"Error: \" & Job1.ErrorMessage,";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job1._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=2555920;
 //BA.debugLineNum = 2555920;BA.debugLine="Job1.Release";
_job1._release /*String*/ (null);
RDebugUtils.currentLine=2555921;
 //BA.debugLineNum = 2555921;BA.debugLine="End Sub";
return "";
}
public static String  _label4_click() throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "label4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "label4_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub Label4_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="StartActivity(Main)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._main.getObject()));
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _locationchanged(anywheresoftware.b4a.gps.LocationWrapper _location1) throws Exception{
RDebugUtils.currentModule="actlapor";
if (Debug.shouldDelegate(mostCurrent.activityBA, "locationchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "locationchanged", new Object[] {_location1}));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Public Sub LocationChanged(Location1 As Location)";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="EditLat.Text = \"\" & Location1.Latitude";
mostCurrent._editlat.setText(BA.ObjectToCharSequence(""+BA.NumberToString(_location1.getLatitude())));
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="EditLon.Text = \"\" & Location1.Longitude";
mostCurrent._editlon.setText(BA.ObjectToCharSequence(""+BA.NumberToString(_location1.getLongitude())));
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="End Sub";
return "";
}
}