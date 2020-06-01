package b4a.example3;


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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example3", "b4a.example3.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example3", "b4a.example3.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example3.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _frontcamera = false;
public static boolean _videomode = false;
public static String _videofiledir = "";
public static String _videofilename = "";
public static int _mytaskindex = 0;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public b4a.example3.camex2 _cam = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcamera = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlpicture = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbackground = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btneffects = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnscene = null;
public anywheresoftware.b4a.objects.collections.List _buttons = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnautoexposure = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnfocus = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _progressbar1 = null;
public static boolean _openstate = false;
public static boolean _busystate = false;
public anywheresoftware.b4a.objects.ButtonWrapper _btnrecord = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmode = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncamera = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _barzoom = null;
public b4a.example3.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="VideoFileDir = rp.GetSafeDirDefaultExternal(\"\")";
_videofiledir = _rp.GetSafeDirDefaultExternal("");
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="VideoFileName = \"1.mp4\"";
_videofilename = "1.mp4";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.LoadLayout(\"StillPicture\")";
mostCurrent._activity.LoadLayout("StillPicture",mostCurrent.activityBA);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="cam.Initialize(pnlCamera)";
mostCurrent._cam._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._pnlcamera);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Log(cam.SupportedHardwareLevel)";
anywheresoftware.b4a.keywords.Common.LogImpl("4131078",mostCurrent._cam._getsupportedhardwarelevel /*String*/ (null),0);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="buttons = Array(btnScene, btnAutoExposure, btnEff";
mostCurrent._buttons = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(mostCurrent._btnscene.getObject()),(Object)(mostCurrent._btnautoexposure.getObject()),(Object)(mostCurrent._btneffects.getObject()),(Object)(mostCurrent._btnfocus.getObject()),(Object)(mostCurrent._btnmode.getObject())});
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="SetState(False, False, VideoMode)";
_setstate(anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False,_videomode);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="End Sub";
return "";
}
public static String  _setstate(boolean _open,boolean _busy,boolean _video) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "setstate", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "setstate", new Object[] {_open,_busy,_video}));}
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
String _btnrecordtext = "";
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub SetState(Open As Boolean, Busy As Boolean, Vid";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="For Each b As Button In buttons";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
{
final anywheresoftware.b4a.BA.IterableList group1 = mostCurrent._buttons;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_b.setObject((android.widget.Button)(group1.Get(index1)));
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="b.Visible = Open And Not(Busy)";
_b.setVisible(_open && anywheresoftware.b4a.keywords.Common.Not(_busy));
 }
};
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="btnCamera.Visible = Not(Busy)";
mostCurrent._btncamera.setVisible(anywheresoftware.b4a.keywords.Common.Not(_busy));
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="btnRecord.Visible = Open And (Video Or Not(Busy))";
mostCurrent._btnrecord.setVisible(_open && (_video || anywheresoftware.b4a.keywords.Common.Not(_busy)));
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="openstate = Open";
_openstate = _open;
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="ProgressBar1.Visible = Busy";
mostCurrent._progressbar1.setVisible(_busy);
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="busystate = Busy";
_busystate = _busy;
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="VideoMode = Video";
_videomode = _video;
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="barZoom.Visible = Open";
mostCurrent._barzoom.setVisible(_open);
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="Dim btnRecordText As String";
_btnrecordtext = "";
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="If VideoMode Then";
if (_videomode) { 
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="If Busy Then";
if (_busy) { 
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="btnRecordText = Chr(0xF04D)";
_btnrecordtext = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf04d)));
 }else {
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="btnRecordText = Chr(0xF03D)";
_btnrecordtext = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf03d)));
 };
 }else {
RDebugUtils.currentLine=1179667;
 //BA.debugLineNum = 1179667;BA.debugLine="btnRecordText = Chr(0xF030)";
_btnrecordtext = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0xf030)));
 };
RDebugUtils.currentLine=1179669;
 //BA.debugLineNum = 1179669;BA.debugLine="btnRecord.Text = btnRecordText";
mostCurrent._btnrecord.setText(BA.ObjectToCharSequence(_btnrecordtext));
RDebugUtils.currentLine=1179670;
 //BA.debugLineNum = 1179670;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="cam.Stop";
mostCurrent._cam._stop /*String*/ (null);
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="OpenCamera(frontCamera)";
_opencamera(_frontcamera);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static void  _opencamera(boolean _front) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opencamera", false))
	 {Debug.delegate(mostCurrent.activityBA, "opencamera", new Object[] {_front}); return;}
ResumableSub_OpenCamera rsub = new ResumableSub_OpenCamera(null,_front);
rsub.resume(processBA, null);
}
public static class ResumableSub_OpenCamera extends BA.ResumableSub {
public ResumableSub_OpenCamera(b4a.example3.main parent,boolean _front) {
this.parent = parent;
this._front = _front;
}
b4a.example3.main parent;
boolean _front;
String _permission = "";
boolean _result = false;
int _taskindex = 0;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
parent._rp.CheckAndRequest(processBA,parent._rp.PERMISSION_CAMERA);
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "opencamera"), null);
this.state = 13;
return;
case 13:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="If Result = False Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="SetState(False, False, VideoMode)";
_setstate(anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False,parent._videomode);
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="Wait For (cam.OpenCamera(front)) Complete (TaskIn";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "opencamera"), parent.mostCurrent._cam._opencamera /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,_front));
this.state = 14;
return;
case 14:
//C
this.state = 5;
_taskindex = (Integer) result[0];
;
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="If TaskIndex > 0 Then";
if (true) break;

case 5:
//if
this.state = 8;
if (_taskindex>0) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="MyTaskIndex = TaskIndex 'hold this index. It wil";
parent._mytaskindex = _taskindex;
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="Wait For(PrepareSurface) Complete (Success As Bo";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "opencamera"), _preparesurface());
this.state = 15;
return;
case 15:
//C
this.state = 8;
_success = (Boolean) result[0];
;
 if (true) break;

case 8:
//C
this.state = 9;
;
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="Log(\"Start success: \" & Success)";
anywheresoftware.b4a.keywords.Common.LogImpl("4262158","Start success: "+BA.ObjectToString(_success),0);
RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="SetState(Success, False, VideoMode)";
_setstate(_success,anywheresoftware.b4a.keywords.Common.False,parent._videomode);
RDebugUtils.currentLine=262160;
 //BA.debugLineNum = 262160;BA.debugLine="If Success = False Then";
if (true) break;

case 9:
//if
this.state = 12;
if (_success==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="ToastMessageShow(\"Failed to open camera\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Failed to open camera"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _barzoom_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "barzoom_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "barzoom_valuechanged", new Object[] {_value,_userchanged}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _originalsize = null;
float _zoom = 0f;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _crop = null;
int _newwidth = 0;
int _newheight = 0;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub barZoom_ValueChanged (Value As Int, UserChange";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim OriginalSize As Rect = cam.ActiveArraySize";
_originalsize = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
_originalsize = mostCurrent._cam._getactivearraysize /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper*/ (null);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Dim Zoom As Float = 1 + Value / 100 * (cam.MaxDig";
_zoom = (float) (1+_value/(double)100*(mostCurrent._cam._getmaxdigitalzoom /*float*/ (null)-1));
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim Crop As Rect";
_crop = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim NewWidth As Int = OriginalSize.Width / Zoom";
_newwidth = (int) (_originalsize.getWidth()/(double)_zoom);
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Dim NewHeight As Int = OriginalSize.Height / Zoom";
_newheight = (int) (_originalsize.getHeight()/(double)_zoom);
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Crop.Initialize(OriginalSize.CenterX - NewWidth /";
_crop.Initialize((int) (_originalsize.getCenterX()-_newwidth/(double)2),(int) (_originalsize.getCenterY()-_newheight/(double)2),(int) (_originalsize.getCenterX()+_newwidth/(double)2),(int) (_originalsize.getCenterY()+_newheight/(double)2));
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="cam.PreviewCropRegion = Crop";
mostCurrent._cam._setpreviewcropregion(null,_crop);
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
mostCurrent._cam._startpreview /*String*/ (null,_mytaskindex,_videomode);
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="End Sub";
return "";
}
public static String  _btnautoexposure_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnautoexposure_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnautoexposure_click", null));}
anywheresoftware.b4a.objects.collections.List _flashes = null;
int _i = 0;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub btnAutoExposure_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Dim flashes As List = cam.SupportedAutoExposureMo";
_flashes = new anywheresoftware.b4a.objects.collections.List();
_flashes = mostCurrent._cam._getsupportedautoexposuremodes /*anywheresoftware.b4a.objects.collections.List*/ (null);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Dim i As Int = flashes.IndexOf(cam.AutoExposureMo";
_i = _flashes.IndexOf((Object)(mostCurrent._cam._getautoexposuremode /*String*/ (null)));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="i = (i + 1) Mod flashes.Size";
_i = (int) ((_i+1)%_flashes.getSize());
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="cam.AutoExposureMode = flashes.Get(i)";
mostCurrent._cam._setautoexposuremode /*String*/ (null,BA.ObjectToString(_flashes.Get(_i)));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="btnAutoExposure.Text = flashes.Get(i)";
mostCurrent._btnautoexposure.setText(BA.ObjectToCharSequence(_flashes.Get(_i)));
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
mostCurrent._cam._startpreview /*String*/ (null,_mytaskindex,_videomode);
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="End Sub";
return "";
}
public static String  _btncamera_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncamera_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncamera_click", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub btnCamera_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="frontCamera = Not(frontCamera)";
_frontcamera = anywheresoftware.b4a.keywords.Common.Not(_frontcamera);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="OpenCamera(frontCamera)";
_opencamera(_frontcamera);
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="End Sub";
return "";
}
public static String  _btneffects_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btneffects_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btneffects_click", null));}
anywheresoftware.b4a.objects.collections.List _effects = null;
int _i = 0;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub btnEffects_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim effects As List = cam.SupportedEffectModes";
_effects = new anywheresoftware.b4a.objects.collections.List();
_effects = mostCurrent._cam._getsupportedeffectmodes /*anywheresoftware.b4a.objects.collections.List*/ (null);
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim i As Int = effects.IndexOf(cam.EffectMode)";
_i = _effects.IndexOf((Object)(mostCurrent._cam._geteffectmode /*String*/ (null)));
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="i = (i + 1) Mod effects.Size";
_i = (int) ((_i+1)%_effects.getSize());
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="cam.EffectMode = effects.Get(i)";
mostCurrent._cam._seteffectmode /*String*/ (null,BA.ObjectToString(_effects.Get(_i)));
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="btnEffects.Text = effects.Get(i)";
mostCurrent._btneffects.setText(BA.ObjectToCharSequence(_effects.Get(_i)));
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
mostCurrent._cam._startpreview /*String*/ (null,_mytaskindex,_videomode);
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="End Sub";
return "";
}
public static String  _btnfocus_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfocus_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnfocus_click", null));}
anywheresoftware.b4a.objects.collections.List _focuses = null;
int _i = 0;
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub btnFocus_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim focuses As List = cam.SupportedFocusModes";
_focuses = new anywheresoftware.b4a.objects.collections.List();
_focuses = mostCurrent._cam._getsupportedfocusmodes /*anywheresoftware.b4a.objects.collections.List*/ (null);
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="Dim i As Int = focuses.IndexOf(cam.FocusMode)";
_i = _focuses.IndexOf((Object)(mostCurrent._cam._getfocusmode /*String*/ (null)));
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="i = (i + 1) Mod focuses.Size";
_i = (int) ((_i+1)%_focuses.getSize());
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="cam.FocusMode = focuses.Get(i)";
mostCurrent._cam._setfocusmode /*String*/ (null,BA.ObjectToString(_focuses.Get(_i)));
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="btnFocus.Text = focuses.Get(i)";
mostCurrent._btnfocus.setText(BA.ObjectToCharSequence(_focuses.Get(_i)));
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
mostCurrent._cam._startpreview /*String*/ (null,_mytaskindex,_videomode);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="End Sub";
return "";
}
public static void  _btnmode_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmode_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnmode_click", null); return;}
ResumableSub_btnMode_Click rsub = new ResumableSub_btnMode_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnMode_Click extends BA.ResumableSub {
public ResumableSub_btnMode_Click(b4a.example3.main parent) {
this.parent = parent;
}
b4a.example3.main parent;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="VideoMode = Not(VideoMode)";
parent._videomode = anywheresoftware.b4a.keywords.Common.Not(parent._videomode);
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="If VideoMode Then";
if (true) break;

case 1:
//if
this.state = 8;
if (parent._videomode) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_RECORD_AUDIO)";
parent._rp.CheckAndRequest(processBA,parent._rp.PERMISSION_RECORD_AUDIO);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "btnmode_click"), null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="If Result = False Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="ToastMessageShow(\"No permission!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="VideoMode = False";
parent._videomode = anywheresoftware.b4a.keywords.Common.False;
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
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="SetState(openstate, busystate, VideoMode)";
_setstate(parent._openstate,parent._busystate,parent._videomode);
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="PrepareSurface";
_preparesurface();
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _preparesurface() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "preparesurface", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(mostCurrent.activityBA, "preparesurface", null));}
ResumableSub_PrepareSurface rsub = new ResumableSub_PrepareSurface(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_PrepareSurface extends BA.ResumableSub {
public ResumableSub_PrepareSurface(b4a.example3.main parent) {
this.parent = parent;
}
b4a.example3.main parent;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="SetState(False, busystate, VideoMode)";
_setstate(anywheresoftware.b4a.keywords.Common.False,parent._busystate,parent._videomode);
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="If VideoMode Then";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._videomode) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="cam.PreviewSize.Initialize(640, 480)";
parent.mostCurrent._cam._previewsize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ .Initialize((int) (640),(int) (480));
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="Wait For (cam.PrepareSurfaceForVideo(MyTaskIndex";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "preparesurface"), parent.mostCurrent._cam._preparesurfaceforvideo /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,parent._mytaskindex,parent._videofiledir,"temp-"+parent._videofilename));
this.state = 12;
return;
case 12:
//C
this.state = 6;
_success = (Boolean) result[0];
;
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="cam.PreviewSize.Initialize(1920, 1080)";
parent.mostCurrent._cam._previewsize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ .Initialize((int) (1920),(int) (1080));
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="Wait For (cam.PrepareSurface(MyTaskIndex)) Compl";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "preparesurface"), parent.mostCurrent._cam._preparesurface /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,parent._mytaskindex));
this.state = 13;
return;
case 13:
//C
this.state = 6;
_success = (Boolean) result[0];
;
 if (true) break;
;
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="If Success Then cam.StartPreview(MyTaskIndex, Vid";

case 6:
//if
this.state = 11;
if (_success) { 
this.state = 8;
;}if (true) break;

case 8:
//C
this.state = 11;
parent.mostCurrent._cam._startpreview /*String*/ (null,parent._mytaskindex,parent._videomode);
if (true) break;

case 11:
//C
this.state = -1;
;
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="SetState(Success, busystate, VideoMode)";
_setstate(_success,parent._busystate,parent._videomode);
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="Return Success";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_success));return;};
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _btnrecord_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnrecord_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnrecord_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub btnRecord_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="If VideoMode Then";
if (_videomode) { 
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="CaptureVideo";
_capturevideo();
 }else {
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="TakePicture";
_takepicture();
 };
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="End Sub";
return "";
}
public static void  _capturevideo() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "capturevideo", false))
	 {Debug.delegate(mostCurrent.activityBA, "capturevideo", null); return;}
ResumableSub_CaptureVideo rsub = new ResumableSub_CaptureVideo(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_CaptureVideo extends BA.ResumableSub {
public ResumableSub_CaptureVideo(b4a.example3.main parent) {
this.parent = parent;
}
b4a.example3.main parent;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Try";
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
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="SetState(openstate, True, VideoMode)";
_setstate(parent._openstate,anywheresoftware.b4a.keywords.Common.True,parent._videomode);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="If cam.RecordingVideo = False Then";
if (true) break;

case 4:
//if
this.state = 9;
if (parent.mostCurrent._cam._recordingvideo /*boolean*/ ==anywheresoftware.b4a.keywords.Common.False) { 
this.state = 6;
}else {
this.state = 8;
}if (true) break;

case 6:
//C
this.state = 9;
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="cam.StartVideoRecording (MyTaskIndex)";
parent.mostCurrent._cam._startvideorecording /*String*/ (null,parent._mytaskindex);
 if (true) break;

case 8:
//C
this.state = 9;
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="cam.StopVideoRecording (MyTaskIndex)";
parent.mostCurrent._cam._stopvideorecording /*String*/ (null,parent._mytaskindex);
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="File.Copy(VideoFileDir, \"temp-\" & VideoFileName";
anywheresoftware.b4a.keywords.Common.File.Copy(parent._videofiledir,"temp-"+parent._videofilename,parent._videofiledir,parent._videofilename);
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="ToastMessageShow($\"Video file saved: $1.2{File.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(("Video file saved: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.2",(Object)(anywheresoftware.b4a.keywords.Common.File.Size(parent._videofiledir,parent._videofilename)/(double)1024/(double)1024))+" MB")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="Wait For (PrepareSurface) Complete (Success As";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "capturevideo"), _preparesurface());
this.state = 13;
return;
case 13:
//C
this.state = 9;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="SetState(openstate, False, VideoMode)";
_setstate(parent._openstate,anywheresoftware.b4a.keywords.Common.False,parent._videomode);
 if (true) break;

case 9:
//C
this.state = 12;
;
 if (true) break;

case 11:
//C
this.state = 12;
this.catchState = 0;
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="HandleError(LastException)";
_handleerror(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA));
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _takepicture() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "takepicture", false))
	 {Debug.delegate(mostCurrent.activityBA, "takepicture", null); return;}
ResumableSub_TakePicture rsub = new ResumableSub_TakePicture(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_TakePicture extends BA.ResumableSub {
public ResumableSub_TakePicture(b4a.example3.main parent) {
this.parent = parent;
}
b4a.example3.main parent;
byte[] _data = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Try";
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
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="SetState(openstate, True, VideoMode)";
_setstate(parent._openstate,anywheresoftware.b4a.keywords.Common.True,parent._videomode);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="Wait For(cam.FocusAndTakePicture(MyTaskIndex)) C";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "takepicture"), parent.mostCurrent._cam._focusandtakepicture /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,parent._mytaskindex));
this.state = 7;
return;
case 7:
//C
this.state = 6;
_data = (byte[]) result[0];
;
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="SetState(openstate, False, VideoMode)";
_setstate(parent._openstate,anywheresoftware.b4a.keywords.Common.False,parent._videomode);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="cam.DataToFile(Data, VideoFileDir, \"1.jpg\")";
parent.mostCurrent._cam._datatofile /*String*/ (null,_data,parent._videofiledir,"1.jpg");
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="Dim bmp As Bitmap = cam.DataToBitmap(Data)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = parent.mostCurrent._cam._datatobitmap /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (null,_data);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="Log(\"Picture taken: \" & bmp) 'ignore";
anywheresoftware.b4a.keywords.Common.LogImpl("4786439","Picture taken: "+BA.ObjectToString(_bmp),0);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="pnlBackground.SetVisibleAnimated(100, True)";
parent.mostCurrent._pnlbackground.SetVisibleAnimated((int) (100),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="pnlPicture.SetBackgroundImage(bmp.Resize(pnlPict";
parent.mostCurrent._pnlpicture.SetBackgroundImageNew((android.graphics.Bitmap)(_bmp.Resize((float) (parent.mostCurrent._pnlpicture.getWidth()),(float) (parent.mostCurrent._pnlpicture.getHeight()),anywheresoftware.b4a.keywords.Common.True).getObject())).setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="Sleep(4000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "takepicture"),(int) (4000));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="pnlBackground.SetVisibleAnimated(500, False)";
parent.mostCurrent._pnlbackground.SetVisibleAnimated((int) (500),anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 5:
//C
this.state = 6;
this.catchState = 0;
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="HandleError(LastException)";
_handleerror(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA));
 if (true) break;
if (true) break;

case 6:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _btnscene_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnscene_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnscene_click", null));}
anywheresoftware.b4a.objects.collections.List _scenes = null;
int _i = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub btnScene_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim scenes As List = cam.SupportedSceneModes";
_scenes = new anywheresoftware.b4a.objects.collections.List();
_scenes = mostCurrent._cam._getsupportedscenemodes /*anywheresoftware.b4a.objects.collections.List*/ (null);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim i As Int = scenes.IndexOf(cam.SceneMode)";
_i = _scenes.IndexOf((Object)(mostCurrent._cam._getscenemode /*String*/ (null)));
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="i = (i + 1) Mod scenes.Size";
_i = (int) ((_i+1)%_scenes.getSize());
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="cam.SceneMode = scenes.Get(i)";
mostCurrent._cam._setscenemode /*String*/ (null,BA.ObjectToString(_scenes.Get(_i)));
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="btnScene.Text = scenes.Get(i)";
mostCurrent._btnscene.setText(BA.ObjectToCharSequence(_scenes.Get(_i)));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="cam.StartPreview(MyTaskIndex, VideoMode)";
mostCurrent._cam._startpreview /*String*/ (null,_mytaskindex,_videomode);
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="End Sub";
return "";
}
public static String  _handleerror(anywheresoftware.b4a.objects.B4AException _error) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "handleerror", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "handleerror", new Object[] {_error}));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub HandleError (Error As Exception)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Log(\"Error: \" & Error)";
anywheresoftware.b4a.keywords.Common.LogImpl("4720897","Error: "+BA.ObjectToString(_error),0);
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="ToastMessageShow(Error, True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_error.getObject()),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="OpenCamera(frontCamera)";
_opencamera(_frontcamera);
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="End Sub";
return "";
}
public static String  _pnlpicture_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "pnlpicture_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "pnlpicture_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub pnlPicture_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="pnlBackground.Visible = False";
mostCurrent._pnlbackground.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
}