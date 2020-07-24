
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

public class actlapor implements IRemote{
	public static actlapor mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public actlapor() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("actlapor"), "b4a.example.actlapor");
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
		pcBA = new PCBA(this, actlapor.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _server = RemoteObject.createImmutable("");
public static RemoteObject _lbllon = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _lbllat = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _pnlbg = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlfile = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _address = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _name = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _phone = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _btnlapor = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _arrayid = null;
public static RemoteObject _tampil_id = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.actkamera _actkamera = null;
public static b4a.example.srvgps _srvgps = null;
public static b4a.example.gps _gps = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",actlapor.mostCurrent._activity,"actKamera",Debug.moduleToString(b4a.example.actkamera.class),"address",actlapor.mostCurrent._address,"arrayid",actlapor.mostCurrent._arrayid,"btnLapor",actlapor.mostCurrent._btnlapor,"gps",Debug.moduleToString(b4a.example.gps.class),"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"lblLat",actlapor.mostCurrent._lbllat,"lblLon",actlapor.mostCurrent._lbllon,"Main",Debug.moduleToString(b4a.example.main.class),"name",actlapor.mostCurrent._name,"phone",actlapor.mostCurrent._phone,"pnlBg",actlapor.mostCurrent._pnlbg,"pnlFile",actlapor.mostCurrent._pnlfile,"server",actlapor._server,"srvGPS",Debug.moduleToString(b4a.example.srvgps.class),"Starter",Debug.moduleToString(b4a.example.starter.class),"tampil_id",actlapor.mostCurrent._tampil_id};
}
}