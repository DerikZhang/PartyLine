package cn.bnuz.party.common;

import java.util.HashMap;
import java.util.Map;

public class ServiceConstants {

//	public static final String VERIFICATION_CODE_ERROR = "verification code error";
	public static final String USER_IS_EXIST = "user has exist";
	public static final String USER_DAO_ERROR = "user dao error";
	public static final String PHONE_NUMBER_IS_NULL = "phone number is null";
	public static final String USER_SIGN_SERVICE_SUCCESS = "user sign in service success";
	public static final String USER_IS_NOT_EXIST = "user is not exist";
	public static final String USER_LOGIN_SUCCESS = "user login success";
	public static final String USER_PASSWORD_WRONG = "user password wrong";
	public static final String USER_LOGIN_ERROR = "user login error";
	
	public static final Map<String, String> MESSAGE_MAP = new HashMap<String, String>();
	public static final String PARTY_SERVICE_CREATE_SUCCESS = "50001";
	public static final String PARTY_SERVICE_CREATE_ERROR = "50002";
	public static final String QRCODE_CREATE_SUCCESS = "50003";
	public static final String QRCODE_CREATE_ERROR = "50004";
	public static final String PARTY_SERVICE_UPDATE_SUCCESS = "50005";
	public static final String PARTY_SERVICE_UPDATE_ERROR = "50006";
	public static final String PARTY_IS_NOT_EXIST = "50008";
	public static final String PARTY_SERVICE_JOIN_SUCCESS = "50009";
	public static final String PARTY_SERVICE_JOIN_ERROR = "50010";
	public static final String PARTY_SERVICE_GET_PARTY_ERROR = "50012";
	public static final String PARTY_SERVICE_GET_PARTY_SUCCESS = "50011";
	public static final String EDIT_USER_INFO_SUCCESS = "50013";
	public static final String EDIT_USER_INFO_FAILURE = "50014";
	public static final String VERIFICATION_CODE_ERROR = "50016";
	public static final String SERVICE_LOGIN_AND_RESET_PASSWORD_SUCCESS = "50017";
	public static final String SERVICE_LOGIN_AND_RESET_PASSWORD_ERROR = "50018";
	
		
	static {
		MESSAGE_MAP.put(PARTY_SERVICE_CREATE_SUCCESS, "create party in service success");
		MESSAGE_MAP.put(PARTY_SERVICE_CREATE_ERROR, "create party in service error");
		MESSAGE_MAP.put(QRCODE_CREATE_ERROR, "create qrcode in service error");
		MESSAGE_MAP.put(QRCODE_CREATE_SUCCESS, "create qrcode in service success");
		MESSAGE_MAP.put(PARTY_SERVICE_UPDATE_ERROR, "update party in service error");
		MESSAGE_MAP.put(PARTY_SERVICE_UPDATE_SUCCESS, "update party in service success");
		MESSAGE_MAP.put(PARTY_IS_NOT_EXIST, "party is not exist");
		MESSAGE_MAP.put(PARTY_SERVICE_JOIN_SUCCESS, "join party in service success");
		MESSAGE_MAP.put(PARTY_SERVICE_JOIN_ERROR, "join party in service error");
		MESSAGE_MAP.put(PARTY_SERVICE_GET_PARTY_ERROR, "get party info in service error");
		MESSAGE_MAP.put(PARTY_SERVICE_GET_PARTY_SUCCESS, "get party info in service success");
		MESSAGE_MAP.put(VERIFICATION_CODE_ERROR, "get verification code in service error");
		MESSAGE_MAP.put(SERVICE_LOGIN_AND_RESET_PASSWORD_SUCCESS, "Service login and reset password success");
		MESSAGE_MAP.put(SERVICE_LOGIN_AND_RESET_PASSWORD_ERROR, "Service login and reset password error");
	}
}