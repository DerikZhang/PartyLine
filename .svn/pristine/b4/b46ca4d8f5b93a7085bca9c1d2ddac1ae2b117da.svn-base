package cn.bnuz.party.service.imp;


import org.junit.Test;

import com.RestTest;

import cn.bnuz.party.util.ConfigUtil;
import cn.bnuz.party.vo.VerificationCode;


public class MessageService {

	private String accountSid ;
	private String authToken ;
	private String appId;
	private String templateId ;
	private String to;
	private ConfigUtil configUtil;
	
	public  void SendVerCode(VerificationCode vCode) {
		//TODO send message from msgServer
		configUtil = new ConfigUtil();
		accountSid = configUtil.getProperties("accountSid");
		authToken = configUtil.getProperties("authToken");
		appId = configUtil.getProperties("appId");
		templateId = configUtil.getProperties("templateId");
		to = configUtil.getProperties("to");
		to += vCode.getPhone_number();	//Emergency
		
		
		try {
		String param = vCode.getVer_code();
		System.out.println("param="+param);
		//云之讯平台发送短信通知
		RestTest.testTemplateSMS(true, accountSid, authToken, appId, templateId, to, param);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestCase(){
		VerificationCode vCode = new VerificationCode();
		vCode.setVer_code("123123");
		SendVerCode(vCode);
	}
	
	
}
