package cn.bnuz.party.common;

import java.util.HashMap;
import java.util.Map;

public class ControllerConstants {
	
	public static final String DONT_WORK = "don't work";
	public static final String USER_INVALID = "user invalid";
	public static final String USER_NOT_EXIST = "user doesn't exist";
	public static final String PHONE_NUMBER_IS_NULL = "phone number is null";
	public static final String PASSWORD_IS_NULL = "passwrod is null";
	public static final String VERIFICATION_CODE_INVALID = "verification code invaild";
	public static final String USER_SERVICE_ERROR = "user service error";
	public static final String USER_SIGN_SUCCESS = "user sign success";
	public static final String PARTY_ID_MUST_EMPTY = "party's user0 id must be empty";

	public static final Map<String, String> MESSAGE_MAP = new HashMap<String, String>();
	public static final String USER_NULL = "41001";
	public static final String PARTY_NULL = "41002";
	public static final String PARTY_SERVICE_JOIN_SUCCESS = "40001";
	public static final String PARTY_SERVICE_JOIN_FAILURE = "40002";
	
	
	static{
		MESSAGE_MAP.put(USER_NULL, USER_INVALID);
		MESSAGE_MAP.put(PARTY_NULL, "party id null");
		MESSAGE_MAP.put(PARTY_SERVICE_JOIN_SUCCESS, "user join party success");
		MESSAGE_MAP.put(PARTY_SERVICE_JOIN_FAILURE, "user join party failure");
	}
	
}
