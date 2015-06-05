package cn.bnuz.party.service;

import java.util.HashMap;
import java.util.Map;

import cn.bnuz.party.common.DaoConstants;
import cn.bnuz.party.common.ServiceConstants;
import cn.bnuz.party.vo.Result;
import cn.bnuz.party.vo.User;
import cn.bnuz.party.vo.VerificationCode;

public interface UserService {

	public String signUser(User inUser, String verificationCode);

	/**
	 * @author jiaqunz
	 * @time Feb 9 2015
	 * @param
	 * @return User
	 */
	public User getUserInfo(User inUser);

	/**
	 * @author jiaqunz
	 * @time Feb 9 2015
	 * @param
	 * @return Map with user and userServiceTag
	 */
	public Map<String, Object> login(User inUser, String verificationCode);
	
	public Map<String , Object> login(User inUser);

	public Result loginAndRstPwd(User user, String verificationCode);
	
}
