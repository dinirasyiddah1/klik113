
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class actkamera implements IRemote{
	public static actkamera mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public actkamera() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("actkamera"), "b4a.example.actkamera");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, actkamera.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _frontcamera = RemoteObject.createImmutable(false);
public static RemoteObject _videomode = RemoteObject.createImmutable(false);
public static RemoteObject _videofiledir = RemoteObject.createImmutable("");
public static RemoteObject _videofilename = RemoteObject.createImmutable("");
public static RemoteObject _mytaskindex = RemoteObject.createImmutable(0);
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _cam = RemoteObject.declareNull("b4a.example.camex2");
public static RemoteObject _pnlcamera = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlpicture = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlbackground = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _buttons = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _btnautoexposure = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _progressbar1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ProgressBarWrapper");
public static RemoteObject _openstate = RemoteObject.createImmutable(false);
public static RemoteObject _busystate = RemoteObject.createImmutable(false);
public static RemoteObject _btnrecord = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnmode = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncamera = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _barzoom = RemoteObject.declareNull("anywheresoftware.b4a.objects.SeekBarWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.actlapor _actlapor = null;
public static b4a.example.gps _gps = null;
public static b4a.example.actgps _actgps = null;
public static b4a.example.srvgps _srvgps = null;
  public Object[] GetGlobals() {
		return new Object[] {"actGPS",Debug.moduleToString(b4a.example.actgps.class),"Activity",actkamera.mostCurrent._activity,"actLapor",Debug.moduleToString(b4a.example.actlapor.class),"barZoom",actkamera.mostCurrent._barzoom,"btnAutoExposure",actkamera.mostCurrent._btnautoexposure,"btnCamera",actkamera.mostCurrent._btncamera,"btnMode",actkamera.mostCurrent._btnmode,"btnRecord",actkamera.mostCurrent._btnrecord,"busystate",actkamera._busystate,"buttons",actkamera.mostCurrent._buttons,"cam",actkamera.mostCurrent._cam,"frontCamera",actkamera._frontcamera,"gps",Debug.moduleToString(b4a.example.gps.class),"Main",Debug.moduleToString(b4a.example.main.class),"MyTaskIndex",actkamera._mytaskindex,"openstate",actkamera._openstate,"pnlBackground",actkamera.mostCurrent._pnlbackground,"pnlCamera",actkamera.mostCurrent._pnlcamera,"pnlPicture",actkamera.mostCurrent._pnlpicture,"ProgressBar1",actkamera.mostCurrent._progressbar1,"rp",actkamera._rp,"srvGPS",Debug.moduleToString(b4a.example.srvgps.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"VideoFileDir",actkamera._videofiledir,"VideoFileName",actkamera._videofilename,"VideoMode",actkamera._videomode};
}
}