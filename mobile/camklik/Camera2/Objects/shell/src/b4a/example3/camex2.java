
package b4a.example3;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class camex2 {
    public static RemoteObject myClass;
	public camex2() {
	}
    public static PCBA staticBA = new PCBA(null, camex2.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _camera = RemoteObject.declareNull("anywheresoftware.b4a.objects.Camera2");
public static RemoteObject _jcamera = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _id = RemoteObject.createImmutable("");
public static RemoteObject _mfront = RemoteObject.createImmutable(false);
public static RemoteObject _previewsize = RemoteObject.declareNull("anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper");
public static RemoteObject _capturesize = RemoteObject.declareNull("anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper");
public static RemoteObject _previewsettingsmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _capturesettingmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _bothmaps = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _mpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _tv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
public static RemoteObject _staticcapturerequest = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _staticcameracharacteristics = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _staticcaptureresult = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _af_state = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _flash_state = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _af_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _ae_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _flash_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _scene_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _effect_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _supported_hardware_level = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _control_mode = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _printkeys = RemoteObject.createImmutable(false);
public static RemoteObject _previewrequest = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _focusstate = RemoteObject.createImmutable("");
public static RemoteObject _mediarecorder = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _recordingvideo = RemoteObject.createImmutable(false);
public static RemoteObject _taskindex = RemoteObject.createImmutable(0);
public static b4a.example3.main _main = null;
public static b4a.example3.starter _starter = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"AE_MODE",_ref.getField(false, "_ae_mode"),"AF_MODE",_ref.getField(false, "_af_mode"),"AF_STATE",_ref.getField(false, "_af_state"),"bothMaps",_ref.getField(false, "_bothmaps"),"camera",_ref.getField(false, "_camera"),"CaptureSettingMap",_ref.getField(false, "_capturesettingmap"),"CaptureSize",_ref.getField(false, "_capturesize"),"CONTROL_MODE",_ref.getField(false, "_control_mode"),"EFFECT_MODE",_ref.getField(false, "_effect_mode"),"FLASH_MODE",_ref.getField(false, "_flash_mode"),"FLASH_STATE",_ref.getField(false, "_flash_state"),"FocusState",_ref.getField(false, "_focusstate"),"id",_ref.getField(false, "_id"),"jcamera",_ref.getField(false, "_jcamera"),"MediaRecorder",_ref.getField(false, "_mediarecorder"),"mFront",_ref.getField(false, "_mfront"),"mPanel",_ref.getField(false, "_mpanel"),"PreviewRequest",_ref.getField(false, "_previewrequest"),"PreviewSettingsMap",_ref.getField(false, "_previewsettingsmap"),"PreviewSize",_ref.getField(false, "_previewsize"),"PrintKeys",_ref.getField(false, "_printkeys"),"RecordingVideo",_ref.getField(false, "_recordingvideo"),"SCENE_MODE",_ref.getField(false, "_scene_mode"),"StaticCameraCharacteristics",_ref.getField(false, "_staticcameracharacteristics"),"StaticCaptureRequest",_ref.getField(false, "_staticcapturerequest"),"StaticCaptureResult",_ref.getField(false, "_staticcaptureresult"),"SUPPORTED_HARDWARE_LEVEL",_ref.getField(false, "_supported_hardware_level"),"TaskIndex",_ref.getField(false, "_taskindex"),"tv",_ref.getField(false, "_tv")};
}
}