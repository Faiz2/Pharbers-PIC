import java.util.Random;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.request.OpenSmsSendmsgRequest;
//import com.taobao.api.request.OpenSmsBatchsendmsgRequest.SendMessageRequest;
import com.taobao.api.request.OpenSmsSendmsgRequest.SendMessageRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.taobao.api.response.OpenSmsSendmsgResponse;

public class SMS {

	public static void main(String[] args) throws ApiException {
		/*String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "23424709";//23424709
		String secret = "f10a6277a2a955d23b413f0b90763308";//f10a6277a2a955d23b413f0b90763308
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		String code = getSix();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("北京砝码科技");
		req.setSmsParamString("{\"name\":\"Faiz\",\"company\":\"北京砝码科技\",\"code\":\""+code+"\"}");
		req.setRecNum("18994737968");
		req.setSmsTemplateCode("SMS_12871095");
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());*/
	}
	
	public static String getSix(){  
        Random rad=new Random();  
          
        String result  = rad.nextInt(1000000) +"";  
          
        if(result.length()!=6){  
            return getSix();  
        }  
        return result;  
    }
}
