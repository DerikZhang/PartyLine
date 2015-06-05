package cn.bnuz.party.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ucpaas.restDemo.DateUtil;

import cn.bnuz.party.service.VerificatedCodeService;
import cn.bnuz.party.vo.User;
import cn.bnuz.party.vo.VerificationCode;

@RequestMapping("/SendVerificationCode")
@Controller
public class VerificateController {
	
	@Autowired
	@Resource
	VerificatedCodeService verCodeService;
	
	/**
	 * 
	 * @param inUser
	 * @param request
	 * @return 
	 */
	@RequestMapping
	@ResponseBody
	public Map<String,Object> getVerificationCode(@ModelAttribute User inUser,HttpServletRequest request){
		
		Logger logger = LoggerFactory.getLogger(VerificateController.class);
		logger.info("Get VerificationCode");

		
		VerificationCode vCode = new VerificationCode();
		vCode.setPhone_number(inUser.getPhone_number());
		vCode.setSendTime(DateUtil.dateToStr(new Date(), 5));
		verCodeService.addVCodeByPhone(vCode);	//Create verifcated-code and save into DB
		verCodeService.sendVerCodeToUser(vCode);//Send Message
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("errorCode", "12001");
//		map.put("verificationCode", "123456");
		
		return map;
	}
	
	@Test
	public void testCase(){
		User user = new User();
		user.setPhone_number("15820588570");
		System.out.println("out="+getVerificationCode(user, null).toString()); 
	}
}
