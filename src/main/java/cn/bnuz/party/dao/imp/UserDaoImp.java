package cn.bnuz.party.dao.imp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.bnuz.party.common.DaoConstants;
import cn.bnuz.party.dao.UserDao;
import cn.bnuz.party.vo.Result;
import cn.bnuz.party.vo.User;

@Repository("userDao")
public class UserDaoImp implements UserDao {

	@Autowired
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;
	Session session;

	Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

	/**
	 * @author jiaqunz
	 * @param 
	 * @return boolean 
	 * @time Feb 9 2015
	 */
	@Override
	public boolean userIsExist(User inUser) {
		
		//init
		String phoneNumber = inUser.getPhone_number();
		int userId = inUser.getU_id();
		Long account = null ;
		String hqlnum = "select count(*) from User u where u.phone_number = "+ phoneNumber;
		String hqluid = "select count(*) from User u where u.u_id = "+ userId;
		
		try {//check user
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query querynum = session.createQuery(hqlnum);
			account	= (Long) querynum.uniqueResult();
			Query queryuid = session.createQuery(hqluid);
			account += (Long)queryuid.uniqueResult();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		
		if(account.SIZE!=0)
		return account.intValue()>0?true:false;
		else return false;
		
	}

	/**
	 * @author jiaqunz
	 * @param
	 * @return String of daoConstants
	 * @time Feb 9 2015
	 */
	@Override
	public String addUser(User inUser) {
		
		//init
		String daoConstants = DaoConstants.USER_DAO_SAVE_SUCCESS;
		//inUser.setU_id(null);
		
		try {//Save user
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(inUser);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			daoConstants = DaoConstants.USER_DAO_SAVE_ERROR;
		}
		session.close();
		
		return daoConstants;
	}

	/**
	 * @author jiaqunz
	 * @time Feb 9 2015
	 * @return User
	 * @param
	 * 
	 */
	@Override
	public User getUserByPhoneNumber(String phone_Number) {
		
		//init

		String daoContants = DaoConstants.USER_DAO_GET_USER_SUCCESS;
		String hql = "from User where phone_number = "+ phone_Number;
		User outUser = new User();
		
		try {//get user by phone number
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			List<User> list = session.createQuery(hql).list();
			outUser = list.get(0);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			daoContants = DaoConstants.USER_DAO_GET_USER_ERROR;
		}
		session.close();
		
		return outUser;
	}

	/**
	 * @author jiaqunz
	 * @time Feb 9 2015
	 * @param
	 * @return User
	 * 
	 */
	@Override
	public User getUserByPrimaryKey(int u_id) {
		// TODO Auto-generated method stub
		User outUser = new User();
		String daoContants = DaoConstants.USER_DAO_GET_USER_SUCCESS;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			outUser = (User) session.get(User.class, u_id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			daoContants = DaoConstants.USER_DAO_GET_USER_ERROR;
			
		}
		session.close();
		logger.info(daoContants);
		return outUser;
	}

	@Override
	public Result updateUser(User inUser) {
		Result result = new Result();
		User user  = new User();
		if(inUser.getPhone_number()!=null&&!("").equals(inUser.getPhone_number())){
			user = getUserByPhoneNumber(inUser.getPhone_number());
		}else if(inUser.getU_id()!=0){
			user = getUserByPrimaryKey(inUser.getU_id());
		}
		if(user==null){
			result.setErrorCode(DaoConstants.USER_ID_AND_PHONENUMBER_NULL);
			result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.USER_ID_AND_PHONENUMBER_NULL));
		} else {
			if (inUser.getPassword() != null&& !inUser.getPassword().equals("")) {
				user.setPassword(inUser.getPassword());
			}
			if (inUser.getUser_name() != null&& !inUser.getUser_name().equals("")) {
				user.setUser_name(inUser.getUser_name());
			}
			if (inUser.getGender() != null&& !inUser.getGender().equals("")) {
				user.setGender(inUser.getGender());
			}
			if (inUser.getAge() != 0) {
				user.setAge(inUser.getAge());
			}
			if (inUser.getJob() != null&& !inUser.getJob().equals("")) {
				user.setJob(inUser.getJob());
			}
			if (inUser.getMotto() != null&& !inUser.getMotto().equals("")) {
				user.setMotto(inUser.getMotto());
			}
			
			try {
				session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.update(user);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.toString());
				result.setErrorCode(DaoConstants.DAO_EDIT_USER_INFO_FAILURE);
				result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.DAO_EDIT_USER_INFO_FAILURE));
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if(result.getErrorCode()==null){
			map.put("user", user);
			result.setParams(map);
			result.setErrorCode(DaoConstants.DAO_EDIT_USER_INFO_SUCCESS);
			result.setMessage(DaoConstants.MESSAGE_MAP.get(DaoConstants.DAO_EDIT_USER_INFO_SUCCESS));
		}
		
		
		return result;
	}

}
