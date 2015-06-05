package cn.bnuz.party.service.imp;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bnuz.party.dao.VerificatedCodeDao;
import cn.bnuz.party.service.VerificatedCodeService;
import cn.bnuz.party.vo.VerificationCode;

@Repository("verCodeService")
public class VerificatedCodeServiceImp implements VerificatedCodeService{
	
	@Autowired 
	@Resource
	VerificatedCodeDao vCodeDao;
	
	@Override
	public void addVCodeByPhone(VerificationCode vCode) {
		vCode.setVer_code(getViCode(6));
		//TODO calc time is over or not
		
		vCodeDao.addVCodeByPhone(vCode);
	}

	private String getViCode(int i) {
		Random random = new Random();
		String rCode = "";
		for (int j = 0; j < 6; j++) {
			int code = random.nextInt(10);
			rCode += String.valueOf(code);
		}
		return String.valueOf(rCode);
	}
	
	MessageService ms = new MessageService();
	
	@Override
	public void sendVerCodeToUser(VerificationCode vCode) {
		String verCode = vCodeDao.getVerCodeByPhoneNumber(vCode.getPhone_number());
//		String verCode = vCode.getVer_code();
		vCode.setVer_code(verCode);
		ms.SendVerCode(vCode);
		
	}

}
