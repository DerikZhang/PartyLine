package cn.bnuz.party.dao;

import cn.bnuz.party.vo.VerificationCode;

public interface VerificatedCodeDao {

	void addVCodeByPhone(VerificationCode vCode);

	String getVerCodeByPhoneNumber(String phone_number);

}
