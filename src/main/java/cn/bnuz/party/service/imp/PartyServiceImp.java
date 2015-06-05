package cn.bnuz.party.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.spi.ErrorCode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import cn.bnuz.party.common.DaoConstants;
import cn.bnuz.party.common.ServiceConstants;
import cn.bnuz.party.dao.PartyDao;
import cn.bnuz.party.dao.UserDao;
import cn.bnuz.party.service.PartyService;
import cn.bnuz.party.util.QrCodeUtil;
import cn.bnuz.party.vo.Party;
import cn.bnuz.party.vo.Result;
import cn.bnuz.party.vo.User;

@Repository("partyService")
public class PartyServiceImp implements PartyService{

	@Resource
	PartyDao partyDao;
	
	@Resource
	UserDao	userDao;
	
	private Logger logger = LoggerFactory.getLogger(PartyServiceImp.class);
	
	/**
	 * @author jiaqunz
	 * @param
	 * @return Result
	 */
	@Override
	public Result createParty(Party inParty, String filePath,String urlContent) {
		Result result = new Result();
		String qrImg = null;
		Set<User> users = new HashSet<User>();
		users.add(userDao.getUserByPrimaryKey(inParty.getU_id()));
		inParty.setUsers(users);
		result = partyDao.addParty(inParty);//添加party
		if (result.getErrorCode().equals(DaoConstants.PARTY_DAO_SAVE_SUCCESS)) {
			inParty = (Party)result.getParams().get("outParty");
//			try {// 生成二维码
//				QrCodeUtil<Party> qrCodeUtil = new QrCodeUtil<Party>();
//				qrCodeUtil.setImgpath(filePath + inParty.getP_id() + ".png");
//				//二维码URL内容
//				qrCodeUtil.setContent(urlContent + "Party/JoinParty/" + inParty.getP_id());
//				qrImg = qrCodeUtil.getImg();
//			} catch (Exception e) {
//				e.printStackTrace();
//				logger.error(e.toString());
//				result.setErrorCode(ServiceConstants.QRCODE_CREATE_ERROR);
//				result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.QRCODE_CREATE_ERROR));
//			}
			qrImg = "";
			if (qrImg!=null) {//封装数据返回
				inParty.setQRcode(qrImg);
				Map<String,Object> mp = new HashMap<String, Object>();
				mp.put("party",inParty);
				boolean serviceTag = partyDao.update(inParty);//update qrcode into party
				if(serviceTag){
					result.setErrorCode(ServiceConstants.PARTY_SERVICE_CREATE_SUCCESS);
					result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_SERVICE_CREATE_SUCCESS));
					result.setParams(mp);
				}else{
					result.setErrorCode(ServiceConstants.PARTY_SERVICE_UPDATE_ERROR);
					result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_SERVICE_UPDATE_ERROR));
				}
			}
		}
		logger.info(result.getMessage());
		return result;
	}

	@Override
	public Result joinParty(String partyID, String userID) {
		
		Result result = new Result();
		User user  = new User();
		Party party = new Party();
		List<User> users = new ArrayList<User>();
		user.setU_id(Integer.parseInt(userID));
		party.setP_id(Integer.parseInt(partyID));
		
		//TODO verify partyID & userID valid
		if(!userDao.userIsExist(user)){
			result.setErrorCode(ServiceConstants.USER_IS_NOT_EXIST);
			result.setMessage(ServiceConstants.USER_IS_NOT_EXIST);
		}else if(!partyDao.partyIsExist(party)){
			result.setErrorCode(ServiceConstants.PARTY_IS_NOT_EXIST);
			result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_IS_NOT_EXIST));
		}else{
			//TODO addUserToParty
			party = partyDao.getPartyByPrimaryKey(party.getP_id());
			user = userDao.getUserByPrimaryKey(Integer.parseInt(userID));
			users.add(user);
			try {
				result = partyDao.addUserToParty(users, party);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.toString());
				result.setErrorCode(DaoConstants.PARTY_DAO_ADD_USER_ERROR);
				result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.PARTY_DAO_ADD_USER_ERROR));
			}
			if(result.getErrorCode().equals(DaoConstants.PARTY_DAO_ADD_USER_SUCCESS)){
				//TODO getPartyUsers
				try {
					party = partyDao.getPartyByPrimaryKey(party.getP_id());
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(e.toString());
					result.setErrorCode(DaoConstants.PARTY_DAO_GET_PARTY_INFO_ERROR);
					result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.PARTY_DAO_GET_PARTY_INFO_ERROR));
				}
				if(!result.getErrorCode().equals(DaoConstants.PARTY_DAO_GET_PARTY_INFO_ERROR)){
					Map<String , Object > mp = new HashMap<String, Object>();
					List<User> ls = new ArrayList<User>();
					Iterator<User> it = party.getUsers().iterator();
					while(it.hasNext()){
						ls.add(it.next());
					}
					mp.put("userList", ls);
					mp.put("party", party);
					result.setParams(mp);
					result.setErrorCode(ServiceConstants.PARTY_SERVICE_JOIN_SUCCESS);
					result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_SERVICE_JOIN_SUCCESS));
				}
//				try {
//					result = partyDao.getPartyUser(party);
//				} catch (Exception e) {
//					e.printStackTrace();
//					logger.error(e.toString());
//					result.setErrorCode(DaoConstants.PARTY_DAO_GET_USER_ERROR);
//					result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.PARTY_DAO_GET_USER_ERROR));
//				}
//				if(result.getErrorCode().equals(DaoConstants.PARTY_DAO_GET_USER_SUCCESS)){
					
					//提取出users放到result中
//					Map<String, Object> map = new HashMap<String, Object>();
//					party = (Party)result.getParams().get("party");
//					Iterator<User> it = party.getUsers().iterator();
//					users.clear();
//					while(it.hasNext()){
//						users.add(it.next());
//					}
//					map.put("party", party);
//					map.put("users",users);
//					result.setParams(map);
					
//					result.setErrorCode(ServiceConstants.PARTY_SERVICE_JOIN_SUCCESS);
//					result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_SERVICE_JOIN_SUCCESS));
//					
//				}else return result;
				
			}else return result;
			
		}
		
		logger.info(result.getMessage());
		
		return result;
	}

	@Override
	public Result getParty(String partyID) {
		Result result  = new Result();
		try {
			result = partyDao.getPartyInfo(partyID);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			result.setErrorCode(ServiceConstants.PARTY_SERVICE_GET_PARTY_ERROR);
			result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_SERVICE_GET_PARTY_ERROR));
		}
		
		if(result.getErrorCode().equals(DaoConstants.PARTY_DAO_GET_PARTY_INFO_SUCCESS)){
			result.setErrorCode(ServiceConstants.PARTY_SERVICE_GET_PARTY_SUCCESS);
			result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.PARTY_SERVICE_GET_PARTY_SUCCESS));
		}
		
		logger.info(result.getMessage());
		
		return result;
	}
	
	@Test
	public void ftest(){
		String pid = "32";
		Result result = getParty(pid);
		System.out.println("errorCode :"+result.getErrorCode());
		System.out.println("message:"+result.getMessage());
		Party party= (Party) result.getParams().get("party");
		System.out.println("party id :"+ party.getP_id());
		System.out.println("party name :"+party.getParty_name());
		Set<User> users = new HashSet<User>();
		users = party.getUsers();
		Iterator<User> it = users.iterator();
		while (it.hasNext()) {
			System.out.println("party users:"+it.next()+"");
		}
		
	}

	@Override
	public Result getPartyList() {
		// TODO Auto-generated method stub
		Result result = new Result();
		Map<String,Object> mp = new HashMap<String, Object>();
		List<Party> partyList = new ArrayList<Party>();
		partyList = partyDao.getAllParty();
		if(partyList!=null){
			mp.put("partyList", partyList);
			result.setErrorCode(DaoConstants.PARTY_DAO_GET_PARTY_LIST_SUCCESS);
			result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.PARTY_DAO_GET_PARTY_LIST_SUCCESS));
		}else{
			result.setErrorCode(DaoConstants.PARTY_DAO_GET_PARTY_LIST_FAILURE);
			result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.PARTY_DAO_GET_PARTY_LIST_FAILURE));
		}
		result.setParams(mp);
		
		return result;
	}

	@Override
	public Result updateUserInfo(User inUser) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			
			result = userDao.updateUser(inUser);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.debug(e.toString());
			result.setErrorCode(DaoConstants.DAO_EDIT_USER_INFO_FAILURE);
			result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.DAO_EDIT_USER_INFO_FAILURE));
		}
		if(result.getErrorCode()==DaoConstants.DAO_EDIT_USER_INFO_SUCCESS){
			result.setErrorCode(ServiceConstants.EDIT_USER_INFO_SUCCESS);
			result.setMessage(ServiceConstants.MESSAGE_MAP.get(ServiceConstants.EDIT_USER_INFO_SUCCESS));
		}
		
		return result;
	}
	
	
	
}
