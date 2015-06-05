package cn.bnuz.party.common;

import java.util.HashMap;
import java.util.Map;

public class DaoConstants {

	public static final String USER_DAO_SAVE_SUCCESS = "user dao save success";
	public static final String USER_DAO_SAVE_ERROR = "user dao save error";
	public static final String USER_DAO_GET_USER_ERROR = "user dao get user error";
	public static final String USER_DAO_GET_USER_SUCCESS = "user dao get user success";
	
	
	public static final Map<String, String> MESSAGE_MAP = new HashMap<String, String>();
	public static final String PARTY_DAO_SAVE_SUCCESS = "60001";
	public static final String PARTY_DAO_SAVE_ERROR = "60002";
	public static final String PARTY_DAO_UPDATE_SUCCESS = "60003";
	public static final String PARTY_DAO_UPDATE_ERROR = "60004";
	public static final String PARTY_DAO_ADD_USER_ERROR = "60006";
	public static final String PARTY_DAO_ADD_USER_SUCCESS = "60005";
	public static final String PARTY_DAO_GET_USER_SUCCESS = "60007";
	public static final String PARTY_DAO_GET_USER_ERROR = "60008";
	public static final String PARTY_DAO_GET_PARTY_INFO_SUCCESS = "60009";
	public static final String PARTY_DAO_GET_PARTY_INFO_ERROR = "60010";
	public static final String PARTY_DAO_GET_PARTY_LIST_SUCCESS = "60011";
	public static final String PARTY_DAO_GET_PARTY_LIST_FAILURE = "60012";
	public static final String DAO_EDIT_USER_INFO_SUCCESS = "6013";
	public static final String DAO_EDIT_USER_INFO_FAILURE = "6014";
	public static final String USER_ID_AND_PHONENUMBER_NULL = "60016";
	

	static {
		MESSAGE_MAP.put(PARTY_DAO_SAVE_ERROR, "party save in dao error");
		MESSAGE_MAP.put(PARTY_DAO_SAVE_SUCCESS, "party save in dao success");
		MESSAGE_MAP.put(PARTY_DAO_UPDATE_SUCCESS, "party update in dao success");
		MESSAGE_MAP.put(PARTY_DAO_UPDATE_ERROR, "party update in dao error");
		MESSAGE_MAP.put(PARTY_DAO_ADD_USER_ERROR, "add user to party in dao error");
		MESSAGE_MAP.put(PARTY_DAO_ADD_USER_SUCCESS, "add user to party in dao success");
		MESSAGE_MAP.put(PARTY_DAO_GET_USER_SUCCESS, "get users from party in dao success");
		MESSAGE_MAP.put(PARTY_DAO_GET_USER_ERROR, "get users from party in dao error");
		MESSAGE_MAP.put(PARTY_DAO_GET_PARTY_INFO_SUCCESS, "get party info in dao success");
		MESSAGE_MAP.put(PARTY_DAO_GET_PARTY_INFO_ERROR, "get party info in dao error");
		MESSAGE_MAP.put(PARTY_DAO_GET_PARTY_LIST_SUCCESS, "get party list in dao success");
		MESSAGE_MAP.put(PARTY_DAO_GET_PARTY_LIST_FAILURE, "get party list in dao failure");
		MESSAGE_MAP.put(DAO_EDIT_USER_INFO_FAILURE, "edit user info failure");
		MESSAGE_MAP.put(DAO_EDIT_USER_INFO_SUCCESS, "edit user info success");
		MESSAGE_MAP.put(USER_ID_AND_PHONENUMBER_NULL, "user id and phone number are null");
		}
	
}