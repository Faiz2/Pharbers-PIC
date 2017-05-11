package pha.com.common.util;

public interface FinalUtil {
	
	//当前用户
	public static String CURRENT_USER = "user";
	
	//无数据
	public static final String DATA_ISNULL = "NO_DATA";
	
	//有数据
	public static final String DATA_ISFULL = "FULL_DATA";
	
	//有部分数据（数据不完全）
	public static final String DATA_ISPART = "PART_DATA";
	
	//布尔类型 TRUE
	public static final Boolean ISTRUN = true;
	
	//布尔类型FALSE
	public static final Boolean ISFALSE = false;
	
	//无数据显示的JSON 提供给Controller调用返回前端（中文）
	public static final String DATA_ISNULL_SHOWJSONCH = "{\"data\": \"暂无数据\"}";
	
	//无数据显示的JSON 提供给Controller调用返回前端（英文）
	public static final String DATA_ISNULL_SHOWJSONEN = "{\"data\": \"NO DATA\"}";
	
	/**
	 * alidayu（阿里大于）
	 * 短信接口
	 */
	//SMS发送短信的接口 "URL"
	public static final String SMS_URL = "http://gw.api.taobao.com/router/rest";
	
	//SMS发送短信接口的 “KEY”
	public static final String SMS_APPKEY = "23424709";
	
	//SMS发送短信接口的 “秘钥”
	public static final String SMS_SECRET = "f10a6277a2a955d23b413f0b90763308";
	
	//SMS发送短信接口的 “短信类型” 传入值请填写normal
	public static final String SMS_TYPE = "normal";
	
	//SMS发送短信接口的 “短信签名”
	public static final String SMS_FREE_SIGNNAME = "北京砝码科技";
	
	//SMS发送短信接口的 “短信模板ID”
	public static final String SMS_TEMPLATE_CODE = "SMS_12871095";
	
}
