package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class camexx extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.camexx");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.camexx.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.Camera2 _camera = null;
public anywheresoftware.b4j.object.JavaObject _jcamera = null;
public String _id = "";
public boolean _mfront = false;
public anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper _previewsize = null;
public anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper _capturesize = null;
public anywheresoftware.b4a.objects.collections.Map _previewsettingsmap = null;
public anywheresoftware.b4a.objects.collections.Map _capturesettingmap = null;
public anywheresoftware.b4a.objects.collections.List _bothmaps = null;
public anywheresoftware.b4a.objects.PanelWrapper _mpanel = null;
public anywheresoftware.b4a.objects.ConcreteViewWrapper _tv = null;
public anywheresoftware.b4j.object.JavaObject _staticcapturerequest = null;
public anywheresoftware.b4j.object.JavaObject _staticcameracharacteristics = null;
public anywheresoftware.b4j.object.JavaObject _staticcaptureresult = null;
public anywheresoftware.b4a.objects.collections.List _af_state = null;
public anywheresoftware.b4a.objects.collections.List _flash_state = null;
public anywheresoftware.b4a.objects.collections.List _af_mode = null;
public anywheresoftware.b4a.objects.collections.List _ae_mode = null;
public anywheresoftware.b4a.objects.collections.List _flash_mode = null;
public anywheresoftware.b4a.objects.collections.List _scene_mode = null;
public anywheresoftware.b4a.objects.collections.List _effect_mode = null;
public anywheresoftware.b4a.objects.collections.List _supported_hardware_level = null;
public anywheresoftware.b4a.objects.collections.List _control_mode = null;
public boolean _printkeys = false;
public anywheresoftware.b4j.object.JavaObject _previewrequest = null;
public String _focusstate = "";
public anywheresoftware.b4j.object.JavaObject _mediarecorder = null;
public boolean _recordingvideo = false;
public int _taskindex = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.actkamera _actkamera = null;
public b4a.example.actlapor _actlapor = null;
public b4a.example.srvgps _srvgps = null;
public b4a.example.actcam _actcam = null;
public b4a.example.gps _gps = null;
public b4a.example.httputils2service _httputils2service = null;
public anywheresoftware.b4a.objects.collections.List  _boolstolist(b4a.example.camexx __ref,Object _obj) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "boolstolist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "boolstolist", new Object[] {_obj}));}
anywheresoftware.b4a.objects.collections.List _res = null;
boolean[] _i = null;
boolean _ii = false;
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Private Sub BoolsToList (Obj As Object) As List";
RDebugUtils.currentLine=11468801;
 //BA.debugLineNum = 11468801;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=11468803;
 //BA.debugLineNum = 11468803;BA.debugLine="If Obj = Null Then Return res";
if (_obj== null) { 
if (true) return _res;};
RDebugUtils.currentLine=11468804;
 //BA.debugLineNum = 11468804;BA.debugLine="Dim i() As Boolean = Obj";
_i = (boolean[])(_obj);
RDebugUtils.currentLine=11468805;
 //BA.debugLineNum = 11468805;BA.debugLine="For Each ii As Boolean In i";
{
final boolean[] group5 = _i;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_ii = group5[index5];
RDebugUtils.currentLine=11468806;
 //BA.debugLineNum = 11468806;BA.debugLine="res.Add(ii)";
_res.Add((Object)(_ii));
 }
};
RDebugUtils.currentLine=11468808;
 //BA.debugLineNum = 11468808;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=11468809;
 //BA.debugLineNum = 11468809;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _bytestolist(b4a.example.camexx __ref,Object _obj) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "bytestolist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "bytestolist", new Object[] {_obj}));}
anywheresoftware.b4a.objects.collections.List _res = null;
byte[] _i = null;
byte _ii = (byte)0;
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Private Sub BytesToList (Obj As Object) As List";
RDebugUtils.currentLine=11534337;
 //BA.debugLineNum = 11534337;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11534338;
 //BA.debugLineNum = 11534338;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=11534339;
 //BA.debugLineNum = 11534339;BA.debugLine="If Obj = Null Then Return res";
if (_obj== null) { 
if (true) return _res;};
RDebugUtils.currentLine=11534340;
 //BA.debugLineNum = 11534340;BA.debugLine="Dim i() As Byte = Obj";
_i = (byte[])(_obj);
RDebugUtils.currentLine=11534341;
 //BA.debugLineNum = 11534341;BA.debugLine="For Each ii As Byte In i";
{
final byte[] group5 = _i;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_ii = group5[index5];
RDebugUtils.currentLine=11534342;
 //BA.debugLineNum = 11534342;BA.debugLine="res.Add(ii)";
_res.Add((Object)(_ii));
 }
};
RDebugUtils.currentLine=11534344;
 //BA.debugLineNum = 11534344;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=11534345;
 //BA.debugLineNum = 11534345;BA.debugLine="End Sub";
return null;
}
public String  _camera_previewcapturecomplete(b4a.example.camexx __ref,Object _captureresult) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "camera_previewcapturecomplete", false))
	 {return ((String) Debug.delegate(ba, "camera_previewcapturecomplete", new Object[] {_captureresult}));}
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Private Sub Camera_PreviewCaptureComplete (Capture";
RDebugUtils.currentLine=10420225;
 //BA.debugLineNum = 10420225;BA.debugLine="FocusState = IntToConst(GetFromCaptureResult(Capt";
__ref._focusstate /*String*/  = __ref._inttoconst /*String*/ (null,__ref._getfromcaptureresult /*Object*/ (null,_captureresult,"CONTROL_AF_STATE"),__ref._af_state /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=10420228;
 //BA.debugLineNum = 10420228;BA.debugLine="End Sub";
return "";
}
public String  _inttoconst(b4a.example.camexx __ref,Object _int1,anywheresoftware.b4a.objects.collections.List _consts) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "inttoconst", false))
	 {return ((String) Debug.delegate(ba, "inttoconst", new Object[] {_int1,_consts}));}
int _i = 0;
RDebugUtils.currentLine=11075584;
 //BA.debugLineNum = 11075584;BA.debugLine="Private Sub IntToConst (Int1 As Object, Consts As";
RDebugUtils.currentLine=11075585;
 //BA.debugLineNum = 11075585;BA.debugLine="If Int1 = Null Then Return \"\"";
if (_int1== null) { 
if (true) return "";};
RDebugUtils.currentLine=11075586;
 //BA.debugLineNum = 11075586;BA.debugLine="Dim i As Int = Int1";
_i = (int)(BA.ObjectToNumber(_int1));
RDebugUtils.currentLine=11075587;
 //BA.debugLineNum = 11075587;BA.debugLine="If i >= 0 And i < Consts.Size Then";
if (_i>=0 && _i<_consts.getSize()) { 
RDebugUtils.currentLine=11075588;
 //BA.debugLineNum = 11075588;BA.debugLine="Return Consts.Get(i)";
if (true) return BA.ObjectToString(_consts.Get(_i));
 }else {
RDebugUtils.currentLine=11075590;
 //BA.debugLineNum = 11075590;BA.debugLine="Log(Consts)'ignore";
__c.LogImpl("111075590",BA.ObjectToString(_consts),0);
RDebugUtils.currentLine=11075591;
 //BA.debugLineNum = 11075591;BA.debugLine="Log(\"Unknown const: \" & i)";
__c.LogImpl("111075591","Unknown const: "+BA.NumberToString(_i),0);
RDebugUtils.currentLine=11075592;
 //BA.debugLineNum = 11075592;BA.debugLine="Return \"\"";
if (true) return "";
 };
RDebugUtils.currentLine=11075594;
 //BA.debugLineNum = 11075594;BA.debugLine="End Sub";
return "";
}
public Object  _getfromcaptureresult(b4a.example.camexx __ref,Object _captureresult,String _field) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getfromcaptureresult", false))
	 {return ((Object) Debug.delegate(ba, "getfromcaptureresult", new Object[] {_captureresult,_field}));}
anywheresoftware.b4j.object.JavaObject _jresult = null;
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Private Sub GetFromCaptureResult(CaptureResult As";
RDebugUtils.currentLine=10944513;
 //BA.debugLineNum = 10944513;BA.debugLine="Dim jresult As JavaObject = CaptureResult";
_jresult = new anywheresoftware.b4j.object.JavaObject();
_jresult.setObject((java.lang.Object)(_captureresult));
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="Return jresult.RunMethod(\"get\", Array(StaticCaptu";
if (true) return _jresult.RunMethod("get",new Object[]{__ref._staticcaptureresult /*anywheresoftware.b4j.object.JavaObject*/ .GetField(_field)});
RDebugUtils.currentLine=10944515;
 //BA.debugLineNum = 10944515;BA.debugLine="End Sub";
return null;
}
public String  _class_globals(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Public Camera As Camera2";
_camera = new anywheresoftware.b4a.objects.Camera2();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="Private jcamera As JavaObject";
_jcamera = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="Private id As String";
_id = "";
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Private mFront As Boolean = False";
_mfront = __c.False;
RDebugUtils.currentLine=8126469;
 //BA.debugLineNum = 8126469;BA.debugLine="Public PreviewSize, CaptureSize As CameraSize";
_previewsize = new anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper();
_capturesize = new anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper();
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="Public PreviewSettingsMap, CaptureSettingMap As M";
_previewsettingsmap = new anywheresoftware.b4a.objects.collections.Map();
_capturesettingmap = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=8126471;
 //BA.debugLineNum = 8126471;BA.debugLine="Private bothMaps As List";
_bothmaps = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8126472;
 //BA.debugLineNum = 8126472;BA.debugLine="Private mPanel As Panel";
_mpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=8126473;
 //BA.debugLineNum = 8126473;BA.debugLine="Private tv As View";
_tv = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
RDebugUtils.currentLine=8126474;
 //BA.debugLineNum = 8126474;BA.debugLine="Private StaticCaptureRequest As JavaObject";
_staticcapturerequest = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126475;
 //BA.debugLineNum = 8126475;BA.debugLine="Private StaticCameraCharacteristics As JavaObject";
_staticcameracharacteristics = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126476;
 //BA.debugLineNum = 8126476;BA.debugLine="Private StaticCaptureResult As JavaObject";
_staticcaptureresult = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126477;
 //BA.debugLineNum = 8126477;BA.debugLine="Private AF_STATE As List = Array(\"INACTIVE\", \"PAS";
_af_state = new anywheresoftware.b4a.objects.collections.List();
_af_state = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("INACTIVE"),(Object)("PASSIVE_SCAN"),(Object)("PASSIVE_FOCUSED"),(Object)("ACTIVE_SCAN"),(Object)("FOCUSED_LOCKED"),(Object)("NOT_FOCUSED_LOCKED"),(Object)("PASSIVE_UNFOCUSED")});
RDebugUtils.currentLine=8126478;
 //BA.debugLineNum = 8126478;BA.debugLine="Private FLASH_STATE As List = Array(\"UNAVAILABLE\"";
_flash_state = new anywheresoftware.b4a.objects.collections.List();
_flash_state = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("UNAVAILABLE"),(Object)("CHARGING"),(Object)("READY"),(Object)("FIRED"),(Object)("PARTIAL")});
RDebugUtils.currentLine=8126480;
 //BA.debugLineNum = 8126480;BA.debugLine="Private AF_MODE As List = Array(\"OFF\", \"AUTO\", \"M";
_af_mode = new anywheresoftware.b4a.objects.collections.List();
_af_mode = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("OFF"),(Object)("AUTO"),(Object)("MACRO"),(Object)("CONTINUOUS_VIDEO"),(Object)("CONTINUOUS_PICTURE"),(Object)("EDOF")});
RDebugUtils.currentLine=8126482;
 //BA.debugLineNum = 8126482;BA.debugLine="Private AE_MODE As List = Array(\"OFF\", \"ON\", \"ON_";
_ae_mode = new anywheresoftware.b4a.objects.collections.List();
_ae_mode = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("OFF"),(Object)("ON"),(Object)("ON_AUTO_FLASH"),(Object)("ON_ALWAYS_FLASH"),(Object)("ON_AUTO_FLASH_REDEYE")});
RDebugUtils.currentLine=8126483;
 //BA.debugLineNum = 8126483;BA.debugLine="Private FLASH_MODE As List = Array(\"OFF\", \"SINGLE";
_flash_mode = new anywheresoftware.b4a.objects.collections.List();
_flash_mode = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("OFF"),(Object)("SINGLE"),(Object)("TORCH")});
RDebugUtils.currentLine=8126484;
 //BA.debugLineNum = 8126484;BA.debugLine="Private SCENE_MODE As List = Array(\"DISABLED\", \"F";
_scene_mode = new anywheresoftware.b4a.objects.collections.List();
_scene_mode = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("DISABLED"),(Object)("FACE_PRIORITY"),(Object)("ACTION"),(Object)("PORTRAIT"),(Object)("LANDSCAPE"),(Object)("NIGHT"),(Object)("PORTRAIT"),(Object)("THEATRE"),(Object)("BEACH"),(Object)("SNOW"),(Object)("SUNSET"),(Object)("STEADYPHOTO"),(Object)("FIREWORKS"),(Object)("SPORTS"),(Object)("PARTY"),(Object)("CANDLELIGHT"),(Object)("BARCODE"),(Object)("HIGH_SPEED_VIDEO"),(Object)("MODE_HDR"),(Object)("FACE_PRIORITY_LOW_LIGHT")});
RDebugUtils.currentLine=8126486;
 //BA.debugLineNum = 8126486;BA.debugLine="Private EFFECT_MODE As List = Array(\"OFF\", \"MONO\"";
_effect_mode = new anywheresoftware.b4a.objects.collections.List();
_effect_mode = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("OFF"),(Object)("MONO"),(Object)("NEGATIVE"),(Object)("SOLARIZE"),(Object)("SEPIA"),(Object)("POSTERIZE"),(Object)("WHITEBOARD"),(Object)("BLACKBOARD"),(Object)("AQUA")});
RDebugUtils.currentLine=8126487;
 //BA.debugLineNum = 8126487;BA.debugLine="Private SUPPORTED_HARDWARE_LEVEL As List = Array(";
_supported_hardware_level = new anywheresoftware.b4a.objects.collections.List();
_supported_hardware_level = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("LIMITED"),(Object)("FULL"),(Object)("LEGACY"),(Object)("LEVEL_3")});
RDebugUtils.currentLine=8126488;
 //BA.debugLineNum = 8126488;BA.debugLine="Private CONTROL_MODE As List = Array(\"OFF\", \"AUTO";
_control_mode = new anywheresoftware.b4a.objects.collections.List();
_control_mode = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("OFF"),(Object)("AUTO"),(Object)("USE_SCENE_MODE"),(Object)("OFF_KEEP_STATE")});
RDebugUtils.currentLine=8126489;
 //BA.debugLineNum = 8126489;BA.debugLine="Public PrintKeys As Boolean = False";
_printkeys = __c.False;
RDebugUtils.currentLine=8126490;
 //BA.debugLineNum = 8126490;BA.debugLine="Private PreviewRequest As JavaObject";
_previewrequest = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126491;
 //BA.debugLineNum = 8126491;BA.debugLine="Private FocusState As String";
_focusstate = "";
RDebugUtils.currentLine=8126492;
 //BA.debugLineNum = 8126492;BA.debugLine="Private MediaRecorder As JavaObject";
_mediarecorder = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8126493;
 //BA.debugLineNum = 8126493;BA.debugLine="Public RecordingVideo As Boolean";
_recordingvideo = false;
RDebugUtils.currentLine=8126494;
 //BA.debugLineNum = 8126494;BA.debugLine="Public TaskIndex As Int = 1";
_taskindex = (int) (1);
RDebugUtils.currentLine=8126495;
 //BA.debugLineNum = 8126495;BA.debugLine="End Sub";
return "";
}
public String  _closesession(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "closesession", false))
	 {return ((String) Debug.delegate(ba, "closesession", null));}
anywheresoftware.b4j.object.JavaObject _session = null;
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Private Sub CloseSession";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="Dim session As JavaObject = jcamera.GetFieldJO(\"c";
_session = new anywheresoftware.b4j.object.JavaObject();
_session = __ref._jcamera /*anywheresoftware.b4j.object.JavaObject*/ .GetFieldJO("captureSession");
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="If session.IsInitialized Then";
if (_session.IsInitialized()) { 
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="session.RunMethod(\"stopRepeating\", Null)";
_session.RunMethod("stopRepeating",(Object[])(__c.Null));
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="session.RunMethod(\"abortCaptures\", Null)";
_session.RunMethod("abortCaptures",(Object[])(__c.Null));
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="jcamera.SetField(\"captureSession\", Null)";
__ref._jcamera /*anywheresoftware.b4j.object.JavaObject*/ .SetField("captureSession",__c.Null);
 };
RDebugUtils.currentLine=8323079;
 //BA.debugLineNum = 8323079;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _createsurface(b4a.example.camexx __ref) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "createsurface", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "createsurface", null));}
ResumableSub_CreateSurface rsub = new ResumableSub_CreateSurface(this,__ref);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_CreateSurface extends BA.ResumableSub {
public ResumableSub_CreateSurface(b4a.example.camexx parent,b4a.example.camexx __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="If tv.IsInitialized Then tv.RemoveView";
if (true) break;

case 1:
//if
this.state = 6;
if (__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .IsInitialized()) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .RemoveView();
if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="tv = Camera.CreateSurface";
__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/  = __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreateSurface(ba);
RDebugUtils.currentLine=8781827;
 //BA.debugLineNum = 8781827;BA.debugLine="mPanel.AddView(tv, 0, 0, mPanel.Width, mPanel.Hei";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .AddView((android.view.View)(__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getWidth(),__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/ .getHeight());
RDebugUtils.currentLine=8781828;
 //BA.debugLineNum = 8781828;BA.debugLine="tv.SendToBack";
__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .SendToBack();
RDebugUtils.currentLine=8781829;
 //BA.debugLineNum = 8781829;BA.debugLine="Wait For Camera_SurfaceReady";
parent.__c.WaitFor("camera_surfaceready", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "createsurface"), null);
this.state = 7;
return;
case 7:
//C
this.state = -1;
;
RDebugUtils.currentLine=8781830;
 //BA.debugLineNum = 8781830;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
RDebugUtils.currentLine=8781831;
 //BA.debugLineNum = 8781831;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _datatobitmap(b4a.example.camexx __ref,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "datatobitmap", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "datatobitmap", new Object[] {_data}));}
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Public Sub DataToBitmap(Data() As Byte) As Bitmap";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="Dim in As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="in.InitializeFromBytesArray(Data, 0, Data.Length)";
_in.InitializeFromBytesArray(_data,(int) (0),_data.length);
RDebugUtils.currentLine=10682371;
 //BA.debugLineNum = 10682371;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=10682372;
 //BA.debugLineNum = 10682372;BA.debugLine="bmp.Initialize2(in)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
RDebugUtils.currentLine=10682373;
 //BA.debugLineNum = 10682373;BA.debugLine="in.Close";
_in.Close();
RDebugUtils.currentLine=10682374;
 //BA.debugLineNum = 10682374;BA.debugLine="Return bmp";
if (true) return _bmp;
RDebugUtils.currentLine=10682375;
 //BA.debugLineNum = 10682375;BA.debugLine="End Sub";
return null;
}
public String  _datatofile(b4a.example.camexx __ref,byte[] _data,String _dir,String _filename) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "datatofile", false))
	 {return ((String) Debug.delegate(ba, "datatofile", new Object[] {_data,_dir,_filename}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Public Sub DataToFile(Data() As Byte, Dir As Strin";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir, Fi";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="out.WriteBytes(Data, 0, Data.Length)";
_out.WriteBytes(_data,(int) (0),_data.length);
RDebugUtils.currentLine=10747907;
 //BA.debugLineNum = 10747907;BA.debugLine="out.Close";
_out.Close();
RDebugUtils.currentLine=10747908;
 //BA.debugLineNum = 10747908;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _floatstolist(b4a.example.camexx __ref,Object _obj) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "floatstolist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "floatstolist", new Object[] {_obj}));}
anywheresoftware.b4a.objects.collections.List _res = null;
float[] _f = null;
float _ff = 0f;
RDebugUtils.currentLine=11665408;
 //BA.debugLineNum = 11665408;BA.debugLine="Private Sub FloatsToList (Obj As Object) As List";
RDebugUtils.currentLine=11665409;
 //BA.debugLineNum = 11665409;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11665410;
 //BA.debugLineNum = 11665410;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=11665411;
 //BA.debugLineNum = 11665411;BA.debugLine="If Obj = Null Then Return res";
if (_obj== null) { 
if (true) return _res;};
RDebugUtils.currentLine=11665412;
 //BA.debugLineNum = 11665412;BA.debugLine="Dim f() As Float = Obj";
_f = (float[])(_obj);
RDebugUtils.currentLine=11665413;
 //BA.debugLineNum = 11665413;BA.debugLine="For Each ff As Float In f";
{
final float[] group5 = _f;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_ff = group5[index5];
RDebugUtils.currentLine=11665414;
 //BA.debugLineNum = 11665414;BA.debugLine="res.Add(ff)";
_res.Add((Object)(_ff));
 }
};
RDebugUtils.currentLine=11665416;
 //BA.debugLineNum = 11665416;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=11665417;
 //BA.debugLineNum = 11665417;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _focusandtakepicture(b4a.example.camexx __ref,int _mytaskindex) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "focusandtakepicture", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "focusandtakepicture", new Object[] {_mytaskindex}));}
ResumableSub_FocusAndTakePicture rsub = new ResumableSub_FocusAndTakePicture(this,__ref,_mytaskindex);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_FocusAndTakePicture extends BA.ResumableSub {
public ResumableSub_FocusAndTakePicture(b4a.example.camexx parent,b4a.example.camexx __ref,int _mytaskindex) {
this.parent = parent;
this.__ref = __ref;
this._mytaskindex = _mytaskindex;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
int _mytaskindex;
String _previewfocusmode = "";
String _previewaemode = "";
anywheresoftware.b4j.object.JavaObject _previewbuilder = null;
boolean _success = false;
byte[] _data = null;
Object _captureresult = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=10289153;
 //BA.debugLineNum = 10289153;BA.debugLine="Dim PreviewFocusMode As String = AF_MODE.Get(GetF";
_previewfocusmode = BA.ObjectToString(__ref._af_mode /*anywheresoftware.b4a.objects.collections.List*/ .Get((int)(BA.ObjectToNumber(__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_AF_MODE")))));
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="Dim PreviewAEMode As String = AE_MODE.Get(GetFrom";
_previewaemode = BA.ObjectToString(__ref._ae_mode /*anywheresoftware.b4a.objects.collections.List*/ .Get((int)(BA.ObjectToNumber(__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_AE_MODE")))));
RDebugUtils.currentLine=10289155;
 //BA.debugLineNum = 10289155;BA.debugLine="If PreviewFocusMode = \"OFF\" Or PreviewFocusMode =";
if (true) break;

case 1:
//if
this.state = 12;
if ((_previewfocusmode).equals("OFF") || (_previewfocusmode).equals("EDOF")) { 
this.state = 3;
}else 
{RDebugUtils.currentLine=10289157;
 //BA.debugLineNum = 10289157;BA.debugLine="Else if PreviewFocusMode.Contains(\"CONTINUOUS\") =";
if (_previewfocusmode.contains("CONTINUOUS")==parent.__c.False || (_previewaemode).equals("ON_ALWAYS_FLASH")) { 
this.state = 5;
}}
if (true) break;

case 3:
//C
this.state = 12;
RDebugUtils.currentLine=10289156;
 //BA.debugLineNum = 10289156;BA.debugLine="Log(\"Focus not supported\")";
parent.__c.LogImpl("110289156","Focus not supported",0);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=10289158;
 //BA.debugLineNum = 10289158;BA.debugLine="Dim PreviewBuilder As JavaObject = Camera.Create";
_previewbuilder = new anywheresoftware.b4j.object.JavaObject();
_previewbuilder.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreatePreviewBuilder()));
RDebugUtils.currentLine=10289159;
 //BA.debugLineNum = 10289159;BA.debugLine="PreviewSettingsMap.Put(\"CONTROL_AF_TRIGGER\", 1)";
__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("CONTROL_AF_TRIGGER"),(Object)(1));
RDebugUtils.currentLine=10289160;
 //BA.debugLineNum = 10289160;BA.debugLine="SetSettingsFromMap(PreviewBuilder, PreviewSettin";
__ref._setsettingsfrommap /*String*/ (null,_previewbuilder,__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ );
RDebugUtils.currentLine=10289161;
 //BA.debugLineNum = 10289161;BA.debugLine="Camera.AddCaptureRequest(PreviewBuilder)";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .AddCaptureRequest((Object)(_previewbuilder.getObject()));
RDebugUtils.currentLine=10289162;
 //BA.debugLineNum = 10289162;BA.debugLine="Wait For (WaitForFocusWithTimeout(5000)) Complet";
parent.__c.WaitFor("complete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "focusandtakepicture"), __ref._waitforfocuswithtimeout /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,(int) (5000)));
this.state = 13;
return;
case 13:
//C
this.state = 6;
_success = (Boolean) result[1];
;
RDebugUtils.currentLine=10289163;
 //BA.debugLineNum = 10289163;BA.debugLine="If Success = False Then";
if (true) break;

case 6:
//if
this.state = 11;
if (_success==parent.__c.False) { 
this.state = 8;
}else {
this.state = 10;
}if (true) break;

case 8:
//C
this.state = 11;
RDebugUtils.currentLine=10289164;
 //BA.debugLineNum = 10289164;BA.debugLine="Log(\"Focus failed\")";
parent.__c.LogImpl("110289164","Focus failed",0);
 if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=10289166;
 //BA.debugLineNum = 10289166;BA.debugLine="Log(\"Focused!\")";
parent.__c.LogImpl("110289166","Focused!",0);
 if (true) break;

case 11:
//C
this.state = 12;
;
RDebugUtils.currentLine=10289168;
 //BA.debugLineNum = 10289168;BA.debugLine="Wait For (TakePictureNow(MyTaskIndex)) Complete";
parent.__c.WaitFor("complete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "focusandtakepicture"), __ref._takepicturenow /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,_mytaskindex));
this.state = 14;
return;
case 14:
//C
this.state = 12;
_data = (byte[]) result[1];
;
RDebugUtils.currentLine=10289169;
 //BA.debugLineNum = 10289169;BA.debugLine="Dim PreviewBuilder As JavaObject = Camera.Create";
_previewbuilder = new anywheresoftware.b4j.object.JavaObject();
_previewbuilder.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreatePreviewBuilder()));
RDebugUtils.currentLine=10289170;
 //BA.debugLineNum = 10289170;BA.debugLine="PreviewSettingsMap.Put(\"CONTROL_AF_TRIGGER\", 2)";
__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("CONTROL_AF_TRIGGER"),(Object)(2));
RDebugUtils.currentLine=10289171;
 //BA.debugLineNum = 10289171;BA.debugLine="SetSettingsFromMap(PreviewBuilder, PreviewSettin";
__ref._setsettingsfrommap /*String*/ (null,_previewbuilder,__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ );
RDebugUtils.currentLine=10289172;
 //BA.debugLineNum = 10289172;BA.debugLine="Camera.AddCaptureRequest(PreviewBuilder)";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .AddCaptureRequest((Object)(_previewbuilder.getObject()));
RDebugUtils.currentLine=10289173;
 //BA.debugLineNum = 10289173;BA.debugLine="PreviewSettingsMap.Remove(\"CONTROL_AF_TRIGGER\")";
__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .Remove((Object)("CONTROL_AF_TRIGGER"));
RDebugUtils.currentLine=10289174;
 //BA.debugLineNum = 10289174;BA.debugLine="Wait For (PreviewBuilder) Camera_CaptureComplete";
parent.__c.WaitFor("camera_capturecomplete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "focusandtakepicture"), (Object)(_previewbuilder.getObject()));
this.state = 15;
return;
case 15:
//C
this.state = 12;
_captureresult = (Object) result[1];
;
RDebugUtils.currentLine=10289175;
 //BA.debugLineNum = 10289175;BA.debugLine="Return data";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_data));return;};
 if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=10289177;
 //BA.debugLineNum = 10289177;BA.debugLine="Wait For (TakePictureNow(MyTaskIndex)) Complete (";
parent.__c.WaitFor("complete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "focusandtakepicture"), __ref._takepicturenow /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,_mytaskindex));
this.state = 16;
return;
case 16:
//C
this.state = -1;
_data = (byte[]) result[1];
;
RDebugUtils.currentLine=10289178;
 //BA.debugLineNum = 10289178;BA.debugLine="Return data";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_data));return;};
RDebugUtils.currentLine=10289179;
 //BA.debugLineNum = 10289179;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public Object  _getfromcapturerequest(b4a.example.camexx __ref,Object _capturerequest,String _field) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getfromcapturerequest", false))
	 {return ((Object) Debug.delegate(ba, "getfromcapturerequest", new Object[] {_capturerequest,_field}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=11010048;
 //BA.debugLineNum = 11010048;BA.debugLine="Private Sub GetFromCaptureRequest(CaptureRequest A";
RDebugUtils.currentLine=11010049;
 //BA.debugLineNum = 11010049;BA.debugLine="Dim jo As JavaObject = CaptureRequest";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_capturerequest));
RDebugUtils.currentLine=11010050;
 //BA.debugLineNum = 11010050;BA.debugLine="Return jo.RunMethod(\"get\", Array(StaticCaptureReq";
if (true) return _jo.RunMethod("get",new Object[]{__ref._staticcapturerequest /*anywheresoftware.b4j.object.JavaObject*/ .GetField(_field)});
RDebugUtils.currentLine=11010051;
 //BA.debugLineNum = 11010051;BA.debugLine="End Sub";
return null;
}
public String  _setsettingsfrommap(b4a.example.camexx __ref,anywheresoftware.b4j.object.JavaObject _builder,anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "setsettingsfrommap", false))
	 {return ((String) Debug.delegate(ba, "setsettingsfrommap", new Object[] {_builder,_m}));}
String _key = "";
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Private Sub SetSettingsFromMap (Builder As JavaObj";
RDebugUtils.currentLine=11206657;
 //BA.debugLineNum = 11206657;BA.debugLine="For Each key As String In m.Keys";
{
final anywheresoftware.b4a.BA.IterableList group1 = _m.Keys();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_key = BA.ObjectToString(group1.Get(index1));
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="Builder.RunMethod(\"set\", Array(StaticCaptureRequ";
_builder.RunMethod("set",new Object[]{__ref._staticcapturerequest /*anywheresoftware.b4j.object.JavaObject*/ .GetField(_key),_m.Get((Object)(_key))});
 }
};
RDebugUtils.currentLine=11206660;
 //BA.debugLineNum = 11206660;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _waitforfocuswithtimeout(b4a.example.camexx __ref,int _timeoutms) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "waitforfocuswithtimeout", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "waitforfocuswithtimeout", new Object[] {_timeoutms}));}
ResumableSub_WaitForFocusWithTimeout rsub = new ResumableSub_WaitForFocusWithTimeout(this,__ref,_timeoutms);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_WaitForFocusWithTimeout extends BA.ResumableSub {
public ResumableSub_WaitForFocusWithTimeout(b4a.example.camexx parent,b4a.example.camexx __ref,int _timeoutms) {
this.parent = parent;
this.__ref = __ref;
this._timeoutms = _timeoutms;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
int _timeoutms;
long _start = 0L;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=10354689;
 //BA.debugLineNum = 10354689;BA.debugLine="Dim start As Long = DateTime.Now";
_start = parent.__c.DateTime.getNow();
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="Do Until FocusState = \"FOCUSED_LOCKED\" Or FocusSt";
if (true) break;

case 1:
//do until
this.state = 10;
while (!((__ref._focusstate /*String*/ ).equals("FOCUSED_LOCKED") || (__ref._focusstate /*String*/ ).equals("NOT_FOCUSED_LOCKED"))) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=10354691;
 //BA.debugLineNum = 10354691;BA.debugLine="Sleep(50)";
parent.__c.Sleep(ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "waitforfocuswithtimeout"),(int) (50));
this.state = 11;
return;
case 11:
//C
this.state = 4;
;
RDebugUtils.currentLine=10354692;
 //BA.debugLineNum = 10354692;BA.debugLine="If DateTime.Now - start > TimeoutMs Then Return";
if (true) break;

case 4:
//if
this.state = 9;
if (parent.__c.DateTime.getNow()-_start>_timeoutms) { 
this.state = 6;
;}if (true) break;

case 6:
//C
this.state = 9;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 9:
//C
this.state = 1;
;
 if (true) break;

case 10:
//C
this.state = -1;
;
RDebugUtils.currentLine=10354694;
 //BA.debugLineNum = 10354694;BA.debugLine="Return FocusState = \"FOCUSED_LOCKED\"";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)((__ref._focusstate /*String*/ ).equals("FOCUSED_LOCKED")));return;};
RDebugUtils.currentLine=10354695;
 //BA.debugLineNum = 10354695;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _takepicturenow(b4a.example.camexx __ref,int _mytaskindex) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "takepicturenow", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "takepicturenow", new Object[] {_mytaskindex}));}
ResumableSub_TakePictureNow rsub = new ResumableSub_TakePictureNow(this,__ref,_mytaskindex);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_TakePictureNow extends BA.ResumableSub {
public ResumableSub_TakePictureNow(b4a.example.camexx parent,b4a.example.camexx __ref,int _mytaskindex) {
this.parent = parent;
this.__ref = __ref;
this._mytaskindex = _mytaskindex;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
int _mytaskindex;
anywheresoftware.b4j.object.JavaObject _builder = null;
Object _capturerequest = null;
byte[] _data = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 1:
//if
this.state = 6;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="Camera.AbortCaptures";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .AbortCaptures();
RDebugUtils.currentLine=10485763;
 //BA.debugLineNum = 10485763;BA.debugLine="Dim builder As JavaObject = Camera.CreateCaptureB";
_builder = new anywheresoftware.b4j.object.JavaObject();
_builder.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreateCaptureBuilder()));
RDebugUtils.currentLine=10485764;
 //BA.debugLineNum = 10485764;BA.debugLine="CaptureSettingMap.Put(\"JPEG_ORIENTATION\", GetHint";
__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("JPEG_ORIENTATION"),(Object)(__ref._gethintorientation /*int*/ (null)));
RDebugUtils.currentLine=10485765;
 //BA.debugLineNum = 10485765;BA.debugLine="SetSettingsFromMap(builder, CaptureSettingMap)";
__ref._setsettingsfrommap /*String*/ (null,_builder,__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ );
RDebugUtils.currentLine=10485766;
 //BA.debugLineNum = 10485766;BA.debugLine="Dim CaptureRequest As Object = Camera.AddCaptureR";
_capturerequest = __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .AddCaptureRequest((Object)(_builder.getObject()));
RDebugUtils.currentLine=10485767;
 //BA.debugLineNum = 10485767;BA.debugLine="If PrintKeys Then PrintAllKeys(CaptureRequest, \"C";
if (true) break;

case 7:
//if
this.state = 12;
if (__ref._printkeys /*boolean*/ ) { 
this.state = 9;
;}if (true) break;

case 9:
//C
this.state = 12;
__ref._printallkeys /*String*/ (null,_capturerequest,"Capture Request");
if (true) break;

case 12:
//C
this.state = -1;
;
RDebugUtils.currentLine=10485768;
 //BA.debugLineNum = 10485768;BA.debugLine="Wait For Camera_PictureTaken (Data() As Byte)";
parent.__c.WaitFor("camera_picturetaken", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "takepicturenow"), null);
this.state = 13;
return;
case 13:
//C
this.state = -1;
_data = (byte[]) result[1];
;
RDebugUtils.currentLine=10485769;
 //BA.debugLineNum = 10485769;BA.debugLine="StartPreview(MyTaskIndex, False)";
__ref._startpreview /*String*/ (null,_mytaskindex,parent.__c.False);
RDebugUtils.currentLine=10485770;
 //BA.debugLineNum = 10485770;BA.debugLine="Return Data";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_data));return;};
RDebugUtils.currentLine=10485771;
 //BA.debugLineNum = 10485771;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper  _getactivearraysize(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getactivearraysize", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper) Debug.delegate(ba, "getactivearraysize", null));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Public Sub getActiveArraySize As Rect";
RDebugUtils.currentLine=10158081;
 //BA.debugLineNum = 10158081;BA.debugLine="Return GetFromCameraCharacteristic(\"SENSOR_INFO_A";
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper(), (android.graphics.Rect)(__ref._getfromcameracharacteristic /*Object*/ (null,"SENSOR_INFO_ACTIVE_ARRAY_SIZE")));
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="End Sub";
return null;
}
public Object  _getfromcameracharacteristic(b4a.example.camexx __ref,String _field) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getfromcameracharacteristic", false))
	 {return ((Object) Debug.delegate(ba, "getfromcameracharacteristic", new Object[] {_field}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Private Sub GetFromCameraCharacteristic (Field As";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="Dim jo As JavaObject = Camera.GetCameraCharacteri";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .GetCameraCharacteristics(__ref._id /*String*/ )));
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="Return jo.RunMethod(\"get\", Array(StaticCameraChar";
if (true) return _jo.RunMethod("get",new Object[]{__ref._staticcameracharacteristics /*anywheresoftware.b4j.object.JavaObject*/ .GetField(_field)});
RDebugUtils.currentLine=10878979;
 //BA.debugLineNum = 10878979;BA.debugLine="End Sub";
return null;
}
public String  _getautoexposuremode(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getautoexposuremode", false))
	 {return ((String) Debug.delegate(ba, "getautoexposuremode", null));}
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Public Sub getAutoExposureMode As String";
RDebugUtils.currentLine=9895937;
 //BA.debugLineNum = 9895937;BA.debugLine="Return IntToConst(GetFromCaptureRequest(PreviewRe";
if (true) return __ref._inttoconst /*String*/ (null,__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_AE_MODE"),__ref._ae_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="End Sub";
return "";
}
public String  _getcontrolmode(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getcontrolmode", false))
	 {return ((String) Debug.delegate(ba, "getcontrolmode", null));}
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Public Sub getControlMode As String";
RDebugUtils.currentLine=9961473;
 //BA.debugLineNum = 9961473;BA.debugLine="Return IntToConst(GetFromCaptureRequest(PreviewRe";
if (true) return __ref._inttoconst /*String*/ (null,__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_MODE"),__ref._control_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="End Sub";
return "";
}
public String  _geteffectmode(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "geteffectmode", false))
	 {return ((String) Debug.delegate(ba, "geteffectmode", null));}
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Public Sub getEffectMode As String";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="Return IntToConst(GetFromCaptureRequest(PreviewRe";
if (true) return __ref._inttoconst /*String*/ (null,__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_EFFECT_MODE"),__ref._effect_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="End Sub";
return "";
}
public String  _getfocusmode(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getfocusmode", false))
	 {return ((String) Debug.delegate(ba, "getfocusmode", null));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Public Sub getFocusMode As String";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="Return IntToConst(GetFromCaptureRequest(PreviewRe";
if (true) return __ref._inttoconst /*String*/ (null,__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_AF_MODE"),__ref._af_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="End Sub";
return "";
}
public int  _gethintorientation(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "gethintorientation", false))
	 {return ((Integer) Debug.delegate(ba, "gethintorientation", null));}
int _sensororientation = 0;
int _front = 0;
int _orientation = 0;
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Private Sub GetHintOrientation As Int";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="Dim SensorOrientation As Int = GetFromCameraChara";
_sensororientation = (int)(BA.ObjectToNumber(__ref._getfromcameracharacteristic /*Object*/ (null,"SENSOR_ORIENTATION")));
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="Dim front As Int = -1";
_front = (int) (-1);
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="If getIsFrontFacingCamera Then front = 1";
if (__ref._getisfrontfacingcamera /*boolean*/ (null)) { 
_front = (int) (1);};
RDebugUtils.currentLine=8585220;
 //BA.debugLineNum = 8585220;BA.debugLine="Dim orientation As Int = (SensorOrientation + jca";
_orientation = (int) ((_sensororientation+(double)(BA.ObjectToNumber(__ref._jcamera /*anywheresoftware.b4j.object.JavaObject*/ .GetField("lastKnownOrientation")))*_front+360)%360);
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="Return orientation";
if (true) return _orientation;
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="End Sub";
return 0;
}
public boolean  _getisfrontfacingcamera(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getisfrontfacingcamera", false))
	 {return ((Boolean) Debug.delegate(ba, "getisfrontfacingcamera", null));}
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Public Sub getIsFrontFacingCamera As Boolean";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="Return GetFromCameraCharacteristic(\"LENS_FACING\")";
if (true) return (__ref._getfromcameracharacteristic /*Object*/ (null,"LENS_FACING")).equals((Object)(0));
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="End Sub";
return false;
}
public float  _getmaxdigitalzoom(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getmaxdigitalzoom", false))
	 {return ((Float) Debug.delegate(ba, "getmaxdigitalzoom", null));}
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Public Sub getMaxDigitalZoom As Float";
RDebugUtils.currentLine=9764865;
 //BA.debugLineNum = 9764865;BA.debugLine="Return GetFromCameraCharacteristic(\"SCALER_AVAILA";
if (true) return (float)(BA.ObjectToNumber(__ref._getfromcameracharacteristic /*Object*/ (null,"SCALER_AVAILABLE_MAX_DIGITAL_ZOOM")));
RDebugUtils.currentLine=9764866;
 //BA.debugLineNum = 9764866;BA.debugLine="End Sub";
return 0f;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getpreviewbitmap(b4a.example.camexx __ref,int _width,int _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getpreviewbitmap", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getpreviewbitmap", new Object[] {_width,_height}));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _mbmp = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Public Sub GetPreviewBitmap(Width As Int, Height A";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="Dim mbmp As Bitmap";
_mbmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="mbmp.InitializeMutable(Width, Height)";
_mbmp.InitializeMutable(_width,_height);
RDebugUtils.currentLine=10616835;
 //BA.debugLineNum = 10616835;BA.debugLine="Dim jo As JavaObject = tv";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .getObject()));
RDebugUtils.currentLine=10616836;
 //BA.debugLineNum = 10616836;BA.debugLine="Return jo.RunMethod(\"getBitmap\", Array(mbmp))";
if (true) return (anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_jo.RunMethod("getBitmap",new Object[]{(Object)(_mbmp.getObject())})));
RDebugUtils.currentLine=10616837;
 //BA.debugLineNum = 10616837;BA.debugLine="End Sub";
return null;
}
public String  _getscenemode(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getscenemode", false))
	 {return ((String) Debug.delegate(ba, "getscenemode", null));}
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Public Sub getSceneMode As String";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="Return IntToConst(GetFromCaptureRequest(PreviewRe";
if (true) return __ref._inttoconst /*String*/ (null,__ref._getfromcapturerequest /*Object*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"CONTROL_SCENE_MODE"),__ref._scene_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedautoexposuremodes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedautoexposuremodes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedautoexposuremodes", null));}
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Public Sub getSupportedAutoExposureModes As List";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="Return IntsToConstsList(GetFromCameraCharacterist";
if (true) return __ref._intstoconstslist /*anywheresoftware.b4a.objects.collections.List*/ (null,__ref._getfromcameracharacteristic /*Object*/ (null,"CONTROL_AE_AVAILABLE_MODES"),__ref._ae_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _intstoconstslist(b4a.example.camexx __ref,Object _ints,anywheresoftware.b4a.objects.collections.List _consts) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "intstoconstslist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "intstoconstslist", new Object[] {_ints,_consts}));}
anywheresoftware.b4a.objects.collections.List _res = null;
int[] _f = null;
int _mode = 0;
RDebugUtils.currentLine=11141120;
 //BA.debugLineNum = 11141120;BA.debugLine="Private Sub IntsToConstsList (Ints As Object, Cons";
RDebugUtils.currentLine=11141121;
 //BA.debugLineNum = 11141121;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11141122;
 //BA.debugLineNum = 11141122;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=11141123;
 //BA.debugLineNum = 11141123;BA.debugLine="If Ints = Null Then Return res";
if (_ints== null) { 
if (true) return _res;};
RDebugUtils.currentLine=11141124;
 //BA.debugLineNum = 11141124;BA.debugLine="Dim f() As Int = Ints";
_f = (int[])(_ints);
RDebugUtils.currentLine=11141125;
 //BA.debugLineNum = 11141125;BA.debugLine="For Each mode As Int In f";
{
final int[] group5 = _f;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_mode = group5[index5];
RDebugUtils.currentLine=11141126;
 //BA.debugLineNum = 11141126;BA.debugLine="If mode >=0 And mode < Consts.Size Then";
if (_mode>=0 && _mode<_consts.getSize()) { 
RDebugUtils.currentLine=11141127;
 //BA.debugLineNum = 11141127;BA.debugLine="res.Add(Consts.Get(mode))";
_res.Add(_consts.Get(_mode));
 }else {
RDebugUtils.currentLine=11141129;
 //BA.debugLineNum = 11141129;BA.debugLine="Log(Consts) 'ignore";
__c.LogImpl("111141129",BA.ObjectToString(_consts),0);
RDebugUtils.currentLine=11141130;
 //BA.debugLineNum = 11141130;BA.debugLine="Log(\"Unknown consts: \" & mode)";
__c.LogImpl("111141130","Unknown consts: "+BA.NumberToString(_mode),0);
 };
 }
};
RDebugUtils.currentLine=11141133;
 //BA.debugLineNum = 11141133;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=11141134;
 //BA.debugLineNum = 11141134;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedcapturesizes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedcapturesizes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedcapturesizes", null));}
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Public Sub getSupportedCaptureSizes As List";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="Return Camera.GetSupportedCaptureSizes(id)";
if (true) return __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .GetSupportedCaptureSizes(__ref._id /*String*/ );
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedeffectmodes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedeffectmodes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedeffectmodes", null));}
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Public Sub getSupportedEffectModes As List";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="Return IntsToConstsList(GetFromCameraCharacterist";
if (true) return __ref._intstoconstslist /*anywheresoftware.b4a.objects.collections.List*/ (null,__ref._getfromcameracharacteristic /*Object*/ (null,"CONTROL_AVAILABLE_EFFECTS"),__ref._effect_mode /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedfocusmodes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedfocusmodes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedfocusmodes", null));}
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Public Sub getSupportedFocusModes As List";
RDebugUtils.currentLine=9502721;
 //BA.debugLineNum = 9502721;BA.debugLine="Return RemoveDuplicates(IntsToConstsList(GetFromC";
if (true) return __ref._removeduplicates /*anywheresoftware.b4a.objects.collections.List*/ (null,__ref._intstoconstslist /*anywheresoftware.b4a.objects.collections.List*/ (null,__ref._getfromcameracharacteristic /*Object*/ (null,"CONTROL_AF_AVAILABLE_MODES"),__ref._af_mode /*anywheresoftware.b4a.objects.collections.List*/ ));
RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _removeduplicates(b4a.example.camexx __ref,anywheresoftware.b4a.objects.collections.List _raw) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "removeduplicates", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "removeduplicates", new Object[] {_raw}));}
anywheresoftware.b4a.objects.collections.Map _unique = null;
String _f = "";
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Private Sub RemoveDuplicates(Raw As List) As List";
RDebugUtils.currentLine=9568257;
 //BA.debugLineNum = 9568257;BA.debugLine="Dim unique As Map";
_unique = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="unique.Initialize";
_unique.Initialize();
RDebugUtils.currentLine=9568259;
 //BA.debugLineNum = 9568259;BA.debugLine="For Each f As String In Raw";
{
final anywheresoftware.b4a.BA.IterableList group3 = _raw;
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_f = BA.ObjectToString(group3.Get(index3));
RDebugUtils.currentLine=9568260;
 //BA.debugLineNum = 9568260;BA.debugLine="unique.Put(f, \"\")";
_unique.Put((Object)(_f),(Object)(""));
 }
};
RDebugUtils.currentLine=9568262;
 //BA.debugLineNum = 9568262;BA.debugLine="Raw.Clear";
_raw.Clear();
RDebugUtils.currentLine=9568263;
 //BA.debugLineNum = 9568263;BA.debugLine="For Each f As String In unique.Keys";
{
final anywheresoftware.b4a.BA.IterableList group7 = _unique.Keys();
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_f = BA.ObjectToString(group7.Get(index7));
RDebugUtils.currentLine=9568264;
 //BA.debugLineNum = 9568264;BA.debugLine="Raw.Add(f)";
_raw.Add((Object)(_f));
 }
};
RDebugUtils.currentLine=9568266;
 //BA.debugLineNum = 9568266;BA.debugLine="Return Raw";
if (true) return _raw;
RDebugUtils.currentLine=9568267;
 //BA.debugLineNum = 9568267;BA.debugLine="End Sub";
return null;
}
public String  _getsupportedhardwarelevel(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedhardwarelevel", false))
	 {return ((String) Debug.delegate(ba, "getsupportedhardwarelevel", null));}
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Public Sub getSupportedHardwareLevel As String";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Dim jo As JavaObject = Camera.GetCameraCharacteri";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .GetCameraCharacteristics(BA.NumberToString(0))));
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="Return IntToConst(jo.RunMethod(\"get\", Array(Stati";
if (true) return __ref._inttoconst /*String*/ (null,_jo.RunMethod("get",new Object[]{__ref._staticcameracharacteristics /*anywheresoftware.b4j.object.JavaObject*/ .GetField("INFO_SUPPORTED_HARDWARE_LEVEL")}),__ref._supported_hardware_level /*anywheresoftware.b4a.objects.collections.List*/ );
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedpreviewsizes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedpreviewsizes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedpreviewsizes", null));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Public Sub getSupportedPreviewSizes As List";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="Return Camera.GetSupportedPreviewSizes(id)";
if (true) return __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .GetSupportedPreviewSizes(__ref._id /*String*/ );
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedscenemodes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedscenemodes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedscenemodes", null));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Public Sub getSupportedSceneModes As List";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="Return RemoveDuplicates(IntsToConstsList(GetFromC";
if (true) return __ref._removeduplicates /*anywheresoftware.b4a.objects.collections.List*/ (null,__ref._intstoconstslist /*anywheresoftware.b4a.objects.collections.List*/ (null,__ref._getfromcameracharacteristic /*Object*/ (null,"CONTROL_AVAILABLE_SCENE_MODES"),__ref._scene_mode /*anywheresoftware.b4a.objects.collections.List*/ ));
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedvideosizes(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "getsupportedvideosizes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getsupportedvideosizes", null));}
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Public Sub getSupportedVideoSizes As List";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="Return Camera.GetSupportedVideoSizes(id)";
if (true) return __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .GetSupportedVideoSizes(__ref._id /*String*/ );
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="End Sub";
return null;
}
public String  _initialize(b4a.example.camexx __ref,anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _camerapanel) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_camerapanel}));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Public Sub Initialize (CameraPanel As Panel)";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="mPanel = CameraPanel";
__ref._mpanel /*anywheresoftware.b4a.objects.PanelWrapper*/  = _camerapanel;
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="Camera.Initialize(\"Camera\")";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .Initialize(ba,"Camera");
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="jcamera = Camera";
__ref._jcamera /*anywheresoftware.b4j.object.JavaObject*/ .setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ ));
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="PreviewSize.Initialize(640, 480)";
__ref._previewsize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ .Initialize((int) (640),(int) (480));
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="CaptureSize.Initialize(1920, 1080)";
__ref._capturesize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ .Initialize((int) (1920),(int) (1080));
RDebugUtils.currentLine=8192006;
 //BA.debugLineNum = 8192006;BA.debugLine="StaticCaptureRequest.InitializeStatic(\"android.ha";
__ref._staticcapturerequest /*anywheresoftware.b4j.object.JavaObject*/ .InitializeStatic("android.hardware.camera2.CaptureRequest");
RDebugUtils.currentLine=8192007;
 //BA.debugLineNum = 8192007;BA.debugLine="StaticCameraCharacteristics.InitializeStatic(\"and";
__ref._staticcameracharacteristics /*anywheresoftware.b4j.object.JavaObject*/ .InitializeStatic("android.hardware.camera2.CameraCharacteristics");
RDebugUtils.currentLine=8192008;
 //BA.debugLineNum = 8192008;BA.debugLine="StaticCaptureResult.InitializeStatic(\"android.har";
__ref._staticcaptureresult /*anywheresoftware.b4j.object.JavaObject*/ .InitializeStatic("android.hardware.camera2.CaptureResult");
RDebugUtils.currentLine=8192009;
 //BA.debugLineNum = 8192009;BA.debugLine="PreviewSettingsMap.Initialize";
__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
RDebugUtils.currentLine=8192010;
 //BA.debugLineNum = 8192010;BA.debugLine="CaptureSettingMap.Initialize";
__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ .Initialize();
RDebugUtils.currentLine=8192011;
 //BA.debugLineNum = 8192011;BA.debugLine="bothMaps = Array(PreviewSettingsMap, CaptureSetti";
__ref._bothmaps /*anywheresoftware.b4a.objects.collections.List*/  = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .getObject()),(Object)(__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ .getObject())});
RDebugUtils.currentLine=8192012;
 //BA.debugLineNum = 8192012;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _intstolist(b4a.example.camexx __ref,Object _obj) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "intstolist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "intstolist", new Object[] {_obj}));}
anywheresoftware.b4a.objects.collections.List _res = null;
int[] _i = null;
int _ii = 0;
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Private Sub IntsToList (Obj As Object) As List";
RDebugUtils.currentLine=11599873;
 //BA.debugLineNum = 11599873;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11599874;
 //BA.debugLineNum = 11599874;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=11599875;
 //BA.debugLineNum = 11599875;BA.debugLine="If Obj = Null Then Return res";
if (_obj== null) { 
if (true) return _res;};
RDebugUtils.currentLine=11599876;
 //BA.debugLineNum = 11599876;BA.debugLine="Dim i() As Int = Obj";
_i = (int[])(_obj);
RDebugUtils.currentLine=11599877;
 //BA.debugLineNum = 11599877;BA.debugLine="For Each ii As Int In i";
{
final int[] group5 = _i;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_ii = group5[index5];
RDebugUtils.currentLine=11599878;
 //BA.debugLineNum = 11599878;BA.debugLine="res.Add(ii)";
_res.Add((Object)(_ii));
 }
};
RDebugUtils.currentLine=11599880;
 //BA.debugLineNum = 11599880;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=11599881;
 //BA.debugLineNum = 11599881;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _objectstolist(b4a.example.camexx __ref,Object _obj) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "objectstolist", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "objectstolist", new Object[] {_obj}));}
anywheresoftware.b4a.objects.collections.List _res = null;
Object[] _o = null;
Object _oo = null;
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Private Sub ObjectsToList(Obj As Object) As List";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=11403267;
 //BA.debugLineNum = 11403267;BA.debugLine="If Obj = Null Then Return res";
if (_obj== null) { 
if (true) return _res;};
RDebugUtils.currentLine=11403268;
 //BA.debugLineNum = 11403268;BA.debugLine="Dim o() As Object = Obj";
_o = (Object[])(_obj);
RDebugUtils.currentLine=11403269;
 //BA.debugLineNum = 11403269;BA.debugLine="For Each oo As Object In o";
{
final Object[] group5 = _o;
final int groupLen5 = group5.length
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_oo = group5[index5];
RDebugUtils.currentLine=11403270;
 //BA.debugLineNum = 11403270;BA.debugLine="res.Add(oo)";
_res.Add(_oo);
 }
};
RDebugUtils.currentLine=11403272;
 //BA.debugLineNum = 11403272;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=11403273;
 //BA.debugLineNum = 11403273;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _opencamera(b4a.example.camexx __ref,boolean _front) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "opencamera", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "opencamera", new Object[] {_front}));}
ResumableSub_OpenCamera rsub = new ResumableSub_OpenCamera(this,__ref,_front);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_OpenCamera extends BA.ResumableSub {
public ResumableSub_OpenCamera(b4a.example.camexx parent,b4a.example.camexx __ref,boolean _front) {
this.parent = parent;
this.__ref = __ref;
this._front = _front;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
boolean _front;
boolean _open = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="TaskIndex = TaskIndex + 1";
__ref._taskindex /*int*/  = (int) (__ref._taskindex /*int*/ +1);
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="If Camera.IsCameraOpen Then";
if (true) break;

case 1:
//if
this.state = 4;
if (__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .getIsCameraOpen()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="Stop";
__ref._stop /*String*/ (null);
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="mFront = Front";
__ref._mfront /*boolean*/  = _front;
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="id = Camera.FindCameraId(mFront)";
__ref._id /*String*/  = __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .FindCameraId(__ref._mfront /*boolean*/ );
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="If id = \"\" Then";
if (true) break;

case 5:
//if
this.state = 8;
if ((__ref._id /*String*/ ).equals("")) { 
this.state = 7;
}if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=8257544;
 //BA.debugLineNum = 8257544;BA.debugLine="Log(\"Camera not found.\")";
parent.__c.LogImpl("18257544","Camera not found.",0);
RDebugUtils.currentLine=8257545;
 //BA.debugLineNum = 8257545;BA.debugLine="id = Camera.CameraIDs(0)";
__ref._id /*String*/  = __ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .getCameraIDs()[(int) (0)];
 if (true) break;

case 8:
//C
this.state = 9;
;
RDebugUtils.currentLine=8257547;
 //BA.debugLineNum = 8257547;BA.debugLine="Camera.OpenCamera(id)";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .OpenCamera(__ref._id /*String*/ );
RDebugUtils.currentLine=8257548;
 //BA.debugLineNum = 8257548;BA.debugLine="Wait For Camera_CameraState (Open As Boolean)";
parent.__c.WaitFor("camera_camerastate", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "opencamera"), null);
this.state = 18;
return;
case 18:
//C
this.state = 9;
_open = (Boolean) result[1];
;
RDebugUtils.currentLine=8257549;
 //BA.debugLineNum = 8257549;BA.debugLine="If Open = False Then";
if (true) break;

case 9:
//if
this.state = 12;
if (_open==parent.__c.False) { 
this.state = 11;
}if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=8257550;
 //BA.debugLineNum = 8257550;BA.debugLine="Log(\"Failed to open camera\")";
parent.__c.LogImpl("18257550","Failed to open camera",0);
RDebugUtils.currentLine=8257551;
 //BA.debugLineNum = 8257551;BA.debugLine="Return 0";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(0));return;};
 if (true) break;
;
RDebugUtils.currentLine=8257553;
 //BA.debugLineNum = 8257553;BA.debugLine="If PrintKeys Then PrintAllKeys(Camera.GetCameraCh";

case 12:
//if
this.state = 17;
if (__ref._printkeys /*boolean*/ ) { 
this.state = 14;
;}if (true) break;

case 14:
//C
this.state = 17;
__ref._printallkeys /*String*/ (null,__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .GetCameraCharacteristics(__ref._id /*String*/ ),"Camera Characteristics");
if (true) break;

case 17:
//C
this.state = -1;
;
RDebugUtils.currentLine=8257554;
 //BA.debugLineNum = 8257554;BA.debugLine="Return TaskIndex";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(__ref._taskindex /*int*/ ));return;};
RDebugUtils.currentLine=8257555;
 //BA.debugLineNum = 8257555;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _stop(b4a.example.camexx __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "stop", false))
	 {return ((String) Debug.delegate(ba, "stop", null));}
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Public Sub Stop";
RDebugUtils.currentLine=11272193;
 //BA.debugLineNum = 11272193;BA.debugLine="RecordingVideo = False";
__ref._recordingvideo /*boolean*/  = __c.False;
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="Camera.Stop";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .Stop();
RDebugUtils.currentLine=11272195;
 //BA.debugLineNum = 11272195;BA.debugLine="TaskIndex = TaskIndex + 1";
__ref._taskindex /*int*/  = (int) (__ref._taskindex /*int*/ +1);
RDebugUtils.currentLine=11272196;
 //BA.debugLineNum = 11272196;BA.debugLine="End Sub";
return "";
}
public String  _printallkeys(b4a.example.camexx __ref,Object _cameramap,String _title) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "printallkeys", false))
	 {return ((String) Debug.delegate(ba, "printallkeys", new Object[] {_cameramap,_title}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.objects.collections.List _keys = null;
anywheresoftware.b4j.object.JavaObject _k = null;
Object _value = null;
String _typ = "";
RDebugUtils.currentLine=11337728;
 //BA.debugLineNum = 11337728;BA.debugLine="Private Sub PrintAllKeys (CameraMap As Object, tit";
RDebugUtils.currentLine=11337729;
 //BA.debugLineNum = 11337729;BA.debugLine="Log($\"******  ${title} **********\"$)";
__c.LogImpl("111337729",("******  "+__c.SmartStringFormatter("",(Object)(_title))+" **********"),0);
RDebugUtils.currentLine=11337730;
 //BA.debugLineNum = 11337730;BA.debugLine="Dim jo As JavaObject = CameraMap";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_cameramap));
RDebugUtils.currentLine=11337731;
 //BA.debugLineNum = 11337731;BA.debugLine="Dim keys As List = jo.RunMethod(\"getKeys\", Null)";
_keys = new anywheresoftware.b4a.objects.collections.List();
_keys.setObject((java.util.List)(_jo.RunMethod("getKeys",(Object[])(__c.Null))));
RDebugUtils.currentLine=11337732;
 //BA.debugLineNum = 11337732;BA.debugLine="For Each k As JavaObject In keys";
_k = new anywheresoftware.b4j.object.JavaObject();
{
final anywheresoftware.b4a.BA.IterableList group4 = _keys;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_k.setObject((java.lang.Object)(group4.Get(index4)));
RDebugUtils.currentLine=11337733;
 //BA.debugLineNum = 11337733;BA.debugLine="Dim value As Object = jo.RunMethod(\"get\", Array(";
_value = _jo.RunMethod("get",new Object[]{(Object)(_k.getObject())});
RDebugUtils.currentLine=11337734;
 //BA.debugLineNum = 11337734;BA.debugLine="If value = Null Then Continue";
if (_value== null) { 
if (true) continue;};
RDebugUtils.currentLine=11337735;
 //BA.debugLineNum = 11337735;BA.debugLine="Dim typ As String = GetType(value)";
_typ = __c.GetType(_value);
RDebugUtils.currentLine=11337736;
 //BA.debugLineNum = 11337736;BA.debugLine="If typ = \"[F\" Then";
if ((_typ).equals("[F")) { 
RDebugUtils.currentLine=11337737;
 //BA.debugLineNum = 11337737;BA.debugLine="value = FloatsToList(value)";
_value = (Object)(__ref._floatstolist /*anywheresoftware.b4a.objects.collections.List*/ (null,_value).getObject());
 }else 
{RDebugUtils.currentLine=11337738;
 //BA.debugLineNum = 11337738;BA.debugLine="Else If typ = \"[I\" Then";
if ((_typ).equals("[I")) { 
RDebugUtils.currentLine=11337739;
 //BA.debugLineNum = 11337739;BA.debugLine="value = IntsToList(value)";
_value = (Object)(__ref._intstolist /*anywheresoftware.b4a.objects.collections.List*/ (null,_value).getObject());
 }else 
{RDebugUtils.currentLine=11337740;
 //BA.debugLineNum = 11337740;BA.debugLine="Else If typ = \"[Z\" Then";
if ((_typ).equals("[Z")) { 
RDebugUtils.currentLine=11337741;
 //BA.debugLineNum = 11337741;BA.debugLine="value = BoolsToList(value)";
_value = (Object)(__ref._boolstolist /*anywheresoftware.b4a.objects.collections.List*/ (null,_value).getObject());
 }else 
{RDebugUtils.currentLine=11337742;
 //BA.debugLineNum = 11337742;BA.debugLine="Else If typ = \"[B\" Then";
if ((_typ).equals("[B")) { 
RDebugUtils.currentLine=11337743;
 //BA.debugLineNum = 11337743;BA.debugLine="value = BytesToList(value)";
_value = (Object)(__ref._bytestolist /*anywheresoftware.b4a.objects.collections.List*/ (null,_value).getObject());
 }else 
{RDebugUtils.currentLine=11337744;
 //BA.debugLineNum = 11337744;BA.debugLine="Else if typ.StartsWith(\"[\") Then";
if (_typ.startsWith("[")) { 
RDebugUtils.currentLine=11337745;
 //BA.debugLineNum = 11337745;BA.debugLine="value = ObjectsToList(value)";
_value = (Object)(__ref._objectstolist /*anywheresoftware.b4a.objects.collections.List*/ (null,_value).getObject());
 }}}}}
;
RDebugUtils.currentLine=11337747;
 //BA.debugLineNum = 11337747;BA.debugLine="Log($\"${k.RunMethod(\"getName\", Null)}: ${value}\"";
__c.LogImpl("111337747",(""+__c.SmartStringFormatter("",_k.RunMethod("getName",(Object[])(__c.Null)))+": "+__c.SmartStringFormatter("",_value)+""),0);
 }
};
RDebugUtils.currentLine=11337749;
 //BA.debugLineNum = 11337749;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _preparesurface(b4a.example.camexx __ref,int _mytaskindex) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "preparesurface", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "preparesurface", new Object[] {_mytaskindex}));}
ResumableSub_PrepareSurface rsub = new ResumableSub_PrepareSurface(this,__ref,_mytaskindex);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_PrepareSurface extends BA.ResumableSub {
public ResumableSub_PrepareSurface(b4a.example.camexx parent,b4a.example.camexx __ref,int _mytaskindex) {
this.parent = parent;
this.__ref = __ref;
this._mytaskindex = _mytaskindex;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
int _mytaskindex;
boolean _result = false;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 1:
//if
this.state = 6;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="CloseSession";
__ref._closesession /*String*/ (null);
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="Wait For (CreateSurface) Complete (Result As Bool";
parent.__c.WaitFor("complete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "preparesurface"), __ref._createsurface /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null));
this.state = 19;
return;
case 19:
//C
this.state = 7;
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 7:
//if
this.state = 12;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 9;
;}if (true) break;

case 9:
//C
this.state = 12;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 12:
//C
this.state = 13;
;
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="Camera.StartSession(tv, PreviewSize, CaptureSize,";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .StartSession((android.view.TextureView)(__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .getObject()),__ref._previewsize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ ,__ref._capturesize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ ,(int) (256),(int) (0),parent.__c.False);
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="Wait For Camera_SessionConfigured (Success As Boo";
parent.__c.WaitFor("camera_sessionconfigured", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "preparesurface"), null);
this.state = 20;
return;
case 20:
//C
this.state = 13;
_success = (Boolean) result[1];
;
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 13:
//if
this.state = 18;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 15;
;}if (true) break;

case 15:
//C
this.state = 18;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 18:
//C
this.state = -1;
;
RDebugUtils.currentLine=8454152;
 //BA.debugLineNum = 8454152;BA.debugLine="Return Success";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_success));return;};
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _preparesurfaceforvideo(b4a.example.camexx __ref,int _mytaskindex,String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "preparesurfaceforvideo", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "preparesurfaceforvideo", new Object[] {_mytaskindex,_dir,_filename}));}
ResumableSub_PrepareSurfaceForVideo rsub = new ResumableSub_PrepareSurfaceForVideo(this,__ref,_mytaskindex,_dir,_filename);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_PrepareSurfaceForVideo extends BA.ResumableSub {
public ResumableSub_PrepareSurfaceForVideo(b4a.example.camexx parent,b4a.example.camexx __ref,int _mytaskindex,String _dir,String _filename) {
this.parent = parent;
this.__ref = __ref;
this._mytaskindex = _mytaskindex;
this._dir = _dir;
this._filename = _filename;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
int _mytaskindex;
String _dir;
String _filename;
boolean _result = false;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 1:
//if
this.state = 6;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="CloseSession";
__ref._closesession /*String*/ (null);
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="Wait For (CreateSurface) Complete (Result As Bool";
parent.__c.WaitFor("complete", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "preparesurfaceforvideo"), __ref._createsurface /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null));
this.state = 19;
return;
case 19:
//C
this.state = 7;
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 7:
//if
this.state = 12;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 9;
;}if (true) break;

case 9:
//C
this.state = 12;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 12:
//C
this.state = 13;
;
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="File.Delete(Dir, FileName)";
parent.__c.File.Delete(_dir,_filename);
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="MediaRecorder = Camera.CreateMediaRecorder(Previe";
__ref._mediarecorder /*anywheresoftware.b4j.object.JavaObject*/ .setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreateMediaRecorder(__ref._previewsize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ ,_dir,_filename)));
RDebugUtils.currentLine=8519687;
 //BA.debugLineNum = 8519687;BA.debugLine="MediaRecorder.RunMethod(\"setOrientationHint\", Arr";
__ref._mediarecorder /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("setOrientationHint",new Object[]{(Object)(__ref._gethintorientation /*int*/ (null))});
RDebugUtils.currentLine=8519688;
 //BA.debugLineNum = 8519688;BA.debugLine="Camera.StartSession(tv, PreviewSize, CaptureSize,";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .StartSession((android.view.TextureView)(__ref._tv /*anywheresoftware.b4a.objects.ConcreteViewWrapper*/ .getObject()),__ref._previewsize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ ,__ref._capturesize /*anywheresoftware.b4a.objects.Camera2.CameraSizeWrapper*/ ,(int) (0),(int) (0),parent.__c.True);
RDebugUtils.currentLine=8519689;
 //BA.debugLineNum = 8519689;BA.debugLine="Wait For Camera_SessionConfigured (Success As Boo";
parent.__c.WaitFor("camera_sessionconfigured", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "preparesurfaceforvideo"), null);
this.state = 20;
return;
case 20:
//C
this.state = 13;
_success = (Boolean) result[1];
;
RDebugUtils.currentLine=8519690;
 //BA.debugLineNum = 8519690;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 13:
//if
this.state = 18;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 15;
;}if (true) break;

case 15:
//C
this.state = 18;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 18:
//C
this.state = -1;
;
RDebugUtils.currentLine=8519691;
 //BA.debugLineNum = 8519691;BA.debugLine="Return Success";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_success));return;};
RDebugUtils.currentLine=8519692;
 //BA.debugLineNum = 8519692;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _setautoexposuremode(b4a.example.camexx __ref,String _mode) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "setautoexposuremode", false))
	 {return ((String) Debug.delegate(ba, "setautoexposuremode", new Object[] {_mode}));}
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Public Sub setAutoExposureMode (Mode As String)";
RDebugUtils.currentLine=10027009;
 //BA.debugLineNum = 10027009;BA.debugLine="SetBothMaps(\"CONTROL_AE_MODE\", AE_MODE.IndexOf(Mo";
__ref._setbothmaps /*String*/ (null,"CONTROL_AE_MODE",(Object)(__ref._ae_mode /*anywheresoftware.b4a.objects.collections.List*/ .IndexOf((Object)(_mode))));
RDebugUtils.currentLine=10027010;
 //BA.debugLineNum = 10027010;BA.debugLine="PreviewSettingsMap.Put(\"FLASH_MODE\", FLASH_MODE.I";
__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("FLASH_MODE"),(Object)(__ref._flash_mode /*anywheresoftware.b4a.objects.collections.List*/ .IndexOf((Object)("OFF"))));
RDebugUtils.currentLine=10027011;
 //BA.debugLineNum = 10027011;BA.debugLine="If Mode = \"ON_ALWAYS_FLASH\" Then";
if ((_mode).equals("ON_ALWAYS_FLASH")) { 
RDebugUtils.currentLine=10027012;
 //BA.debugLineNum = 10027012;BA.debugLine="CaptureSettingMap.Put(\"FLASH_MODE\", FLASH_MODE.I";
__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("FLASH_MODE"),(Object)(__ref._flash_mode /*anywheresoftware.b4a.objects.collections.List*/ .IndexOf((Object)("SINGLE"))));
 };
RDebugUtils.currentLine=10027014;
 //BA.debugLineNum = 10027014;BA.debugLine="End Sub";
return "";
}
public String  _setbothmaps(b4a.example.camexx __ref,String _key,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "setbothmaps", false))
	 {return ((String) Debug.delegate(ba, "setbothmaps", new Object[] {_key,_value}));}
anywheresoftware.b4a.objects.collections.Map _m = null;
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Private Sub SetBothMaps(Key As String, Value As Ob";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="For Each m As Map In bothMaps";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group1 = __ref._bothmaps /*anywheresoftware.b4a.objects.collections.List*/ ;
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group1.Get(index1)));
RDebugUtils.currentLine=10223618;
 //BA.debugLineNum = 10223618;BA.debugLine="m.Put(Key, Value)";
_m.Put((Object)(_key),_value);
 }
};
RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="End Sub";
return "";
}
public String  _seteffectmode(b4a.example.camexx __ref,String _mode) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "seteffectmode", false))
	 {return ((String) Debug.delegate(ba, "seteffectmode", new Object[] {_mode}));}
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Public Sub setEffectMode(Mode As String)";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="SetBothMaps(\"CONTROL_EFFECT_MODE\", EFFECT_MODE.In";
__ref._setbothmaps /*String*/ (null,"CONTROL_EFFECT_MODE",(Object)(__ref._effect_mode /*anywheresoftware.b4a.objects.collections.List*/ .IndexOf((Object)(_mode))));
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="End Sub";
return "";
}
public String  _setfocusmode(b4a.example.camexx __ref,String _mode) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "setfocusmode", false))
	 {return ((String) Debug.delegate(ba, "setfocusmode", new Object[] {_mode}));}
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Public Sub setFocusMode(mode As String)";
RDebugUtils.currentLine=9699329;
 //BA.debugLineNum = 9699329;BA.debugLine="SetBothMaps(\"CONTROL_AF_MODE\", AF_MODE.IndexOf(mo";
__ref._setbothmaps /*String*/ (null,"CONTROL_AF_MODE",(Object)(__ref._af_mode /*anywheresoftware.b4a.objects.collections.List*/ .IndexOf((Object)(_mode))));
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="End Sub";
return "";
}
public String  _setpreviewcropregion(b4a.example.camexx __ref,anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "setpreviewcropregion", false))
	 {return ((String) Debug.delegate(ba, "setpreviewcropregion", new Object[] {_r}));}
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Public Sub setPreviewCropRegion(r As Rect)";
RDebugUtils.currentLine=10092545;
 //BA.debugLineNum = 10092545;BA.debugLine="PreviewSettingsMap.Put(\"SCALER_CROP_REGION\", r)";
__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("SCALER_CROP_REGION"),(Object)(_r.getObject()));
RDebugUtils.currentLine=10092546;
 //BA.debugLineNum = 10092546;BA.debugLine="End Sub";
return "";
}
public String  _setscenemode(b4a.example.camexx __ref,String _mode) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "setscenemode", false))
	 {return ((String) Debug.delegate(ba, "setscenemode", new Object[] {_mode}));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Public Sub setSceneMode(Mode As String)";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="SetBothMaps(\"CONTROL_SCENE_MODE\", SCENE_MODE.Inde";
__ref._setbothmaps /*String*/ (null,"CONTROL_SCENE_MODE",(Object)(__ref._scene_mode /*anywheresoftware.b4a.objects.collections.List*/ .IndexOf((Object)(_mode))));
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="End Sub";
return "";
}
public String  _startpreview(b4a.example.camexx __ref,int _mytaskindex,boolean _videorecording) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "startpreview", false))
	 {return ((String) Debug.delegate(ba, "startpreview", new Object[] {_mytaskindex,_videorecording}));}
anywheresoftware.b4j.object.JavaObject _previewbuilder = null;
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Public Sub StartPreview (MyTaskIndex As Int, Video";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="Dim PreviewBuilder As JavaObject";
_previewbuilder = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="If VideoRecording Then";
if (_videorecording) { 
RDebugUtils.currentLine=8847363;
 //BA.debugLineNum = 8847363;BA.debugLine="PreviewBuilder = Camera.CreateVideoRequestBuilde";
_previewbuilder.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreateVideoRequestBuilder()));
 }else {
RDebugUtils.currentLine=8847365;
 //BA.debugLineNum = 8847365;BA.debugLine="PreviewBuilder = Camera.CreatePreviewBuilder";
_previewbuilder.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreatePreviewBuilder()));
 };
RDebugUtils.currentLine=8847367;
 //BA.debugLineNum = 8847367;BA.debugLine="SetSettingsFromMap(PreviewBuilder, PreviewSetting";
__ref._setsettingsfrommap /*String*/ (null,_previewbuilder,__ref._previewsettingsmap /*anywheresoftware.b4a.objects.collections.Map*/ );
RDebugUtils.currentLine=8847368;
 //BA.debugLineNum = 8847368;BA.debugLine="PreviewRequest = Camera.SetRepeatingRequest(Previ";
__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .SetRepeatingRequest((Object)(_previewbuilder.getObject()))));
RDebugUtils.currentLine=8847369;
 //BA.debugLineNum = 8847369;BA.debugLine="If PrintKeys Then PrintAllKeys(PreviewRequest, \"P";
if (__ref._printkeys /*boolean*/ ) { 
__ref._printallkeys /*String*/ (null,(Object)(__ref._previewrequest /*anywheresoftware.b4j.object.JavaObject*/ .getObject()),"Preview Capture Request");};
RDebugUtils.currentLine=8847370;
 //BA.debugLineNum = 8847370;BA.debugLine="End Sub";
return "";
}
public String  _startvideorecording(b4a.example.camexx __ref,int _mytaskindex) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "startvideorecording", false))
	 {return ((String) Debug.delegate(ba, "startvideorecording", new Object[] {_mytaskindex}));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Public Sub StartVideoRecording (MyTaskIndex As Int";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return";
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
if (true) return "";};
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="MediaRecorder.RunMethod(\"start\", Null)";
__ref._mediarecorder /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("start",(Object[])(__c.Null));
RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="RecordingVideo = True";
__ref._recordingvideo /*boolean*/  = __c.True;
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="End Sub";
return "";
}
public String  _stopvideorecording(b4a.example.camexx __ref,int _mytaskindex) throws Exception{
__ref = this;
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "stopvideorecording", false))
	 {return ((String) Debug.delegate(ba, "stopvideorecording", new Object[] {_mytaskindex}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Public Sub StopVideoRecording (MyTaskIndex As Int)";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="CloseSession";
__ref._closesession /*String*/ (null);
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="Try";
try {RDebugUtils.currentLine=8716291;
 //BA.debugLineNum = 8716291;BA.debugLine="MediaRecorder.RunMethod(\"stop\", Null)";
__ref._mediarecorder /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("stop",(Object[])(__c.Null));
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=8716293;
 //BA.debugLineNum = 8716293;BA.debugLine="Log(LastException)";
__c.LogImpl("18716293",BA.ObjectToString(__c.LastException(ba)),0);
 };
RDebugUtils.currentLine=8716295;
 //BA.debugLineNum = 8716295;BA.debugLine="RecordingVideo = False";
__ref._recordingvideo /*boolean*/  = __c.False;
RDebugUtils.currentLine=8716296;
 //BA.debugLineNum = 8716296;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _takepicturesnow(b4a.example.camexx __ref,int _mytaskindex,int _numberofpictures) throws Exception{
RDebugUtils.currentModule="camexx";
if (Debug.shouldDelegate(ba, "takepicturesnow", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "takepicturesnow", new Object[] {_mytaskindex,_numberofpictures}));}
ResumableSub_TakePicturesNow rsub = new ResumableSub_TakePicturesNow(this,__ref,_mytaskindex,_numberofpictures);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_TakePicturesNow extends BA.ResumableSub {
public ResumableSub_TakePicturesNow(b4a.example.camexx parent,b4a.example.camexx __ref,int _mytaskindex,int _numberofpictures) {
this.parent = parent;
this.__ref = __ref;
this._mytaskindex = _mytaskindex;
this._numberofpictures = _numberofpictures;
this.__ref = parent;
}
b4a.example.camexx __ref;
b4a.example.camexx parent;
int _mytaskindex;
int _numberofpictures;
anywheresoftware.b4j.object.JavaObject _builder = null;
anywheresoftware.b4a.objects.collections.List _result = null;
int _i = 0;
byte[] _data = null;
int step8;
int limit8;
int step11;
int limit11;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="camexx";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="If MyTaskIndex <> TaskIndex Then Return False";
if (true) break;

case 1:
//if
this.state = 6;
if (_mytaskindex!=__ref._taskindex /*int*/ ) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
if (true) break;

case 6:
//C
this.state = 7;
;
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="Camera.AbortCaptures";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .AbortCaptures();
RDebugUtils.currentLine=10551299;
 //BA.debugLineNum = 10551299;BA.debugLine="Dim builder As JavaObject = Camera.CreateCaptureB";
_builder = new anywheresoftware.b4j.object.JavaObject();
_builder.setObject((java.lang.Object)(__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .CreateCaptureBuilder()));
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="CaptureSettingMap.Put(\"JPEG_ORIENTATION\", GetHint";
__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ .Put((Object)("JPEG_ORIENTATION"),(Object)(__ref._gethintorientation /*int*/ (null)));
RDebugUtils.currentLine=10551301;
 //BA.debugLineNum = 10551301;BA.debugLine="SetSettingsFromMap(builder, CaptureSettingMap)";
__ref._setsettingsfrommap /*String*/ (null,_builder,__ref._capturesettingmap /*anywheresoftware.b4a.objects.collections.Map*/ );
RDebugUtils.currentLine=10551302;
 //BA.debugLineNum = 10551302;BA.debugLine="Dim result As List";
_result = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=10551303;
 //BA.debugLineNum = 10551303;BA.debugLine="result.Initialize";
_result.Initialize();
RDebugUtils.currentLine=10551304;
 //BA.debugLineNum = 10551304;BA.debugLine="For i = 1 To NumberOfPictures";
if (true) break;

case 7:
//for
this.state = 10;
step8 = 1;
limit8 = _numberofpictures;
_i = (int) (1) ;
this.state = 14;
if (true) break;

case 14:
//C
this.state = 10;
if ((step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8)) this.state = 9;
if (true) break;

case 15:
//C
this.state = 14;
_i = ((int)(0 + _i + step8)) ;
if (true) break;

case 9:
//C
this.state = 15;
RDebugUtils.currentLine=10551305;
 //BA.debugLineNum = 10551305;BA.debugLine="Camera.AddCaptureRequest(builder)";
__ref._camera /*anywheresoftware.b4a.objects.Camera2*/ .AddCaptureRequest((Object)(_builder.getObject()));
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=10551307;
 //BA.debugLineNum = 10551307;BA.debugLine="For i = 1 To NumberOfPictures";

case 10:
//for
this.state = 13;
step11 = 1;
limit11 = _numberofpictures;
_i = (int) (1) ;
this.state = 16;
if (true) break;

case 16:
//C
this.state = 13;
if ((step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11)) this.state = 12;
if (true) break;

case 17:
//C
this.state = 16;
_i = ((int)(0 + _i + step11)) ;
if (true) break;

case 12:
//C
this.state = 17;
RDebugUtils.currentLine=10551308;
 //BA.debugLineNum = 10551308;BA.debugLine="Wait For Camera_PictureTaken (Data() As Byte)";
parent.__c.WaitFor("camera_picturetaken", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "camexx", "takepicturesnow"), null);
this.state = 18;
return;
case 18:
//C
this.state = 17;
_data = (byte[]) result[1];
;
RDebugUtils.currentLine=10551309;
 //BA.debugLineNum = 10551309;BA.debugLine="result.Add(Data)";
_result.Add((Object)(_data));
 if (true) break;
if (true) break;

case 13:
//C
this.state = -1;
;
RDebugUtils.currentLine=10551311;
 //BA.debugLineNum = 10551311;BA.debugLine="StartPreview(MyTaskIndex, False)";
__ref._startpreview /*String*/ (null,_mytaskindex,parent.__c.False);
RDebugUtils.currentLine=10551312;
 //BA.debugLineNum = 10551312;BA.debugLine="Return result";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(_result));return;};
RDebugUtils.currentLine=10551313;
 //BA.debugLineNum = 10551313;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
}