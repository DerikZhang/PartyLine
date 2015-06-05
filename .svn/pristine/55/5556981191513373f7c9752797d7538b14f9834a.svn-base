package cn.bnuz.party.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bnuz.party.common.APIErrorCode;
import cn.bnuz.party.dao.VerificatedCodeDao;
import cn.bnuz.party.vo.VerificationCode;

@Service
@Repository("vCodeDao")
public class VerificatedCodeDaoImp implements VerificatedCodeDao {

	@Autowired(required = false)
	Logger logger = LoggerFactory.getLogger(VerificatedCodeDaoImp.class);
	
	@Autowired
	@Resource(name = "sessionFactory")
	SessionFactory sf ;
	Session session ;
	
	@Override
//	@Transactional(readOnly=false)
	public void addVCodeByPhone(VerificationCode vCode) {
		try {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(vCode);
		transaction.commit();
		} catch (Exception e) {
			System.out.println("Error");
		}
		session.close();
	}

	@Override
	public String getVerCodeByPhoneNumber(String phone_number) {
		VerificationCode vCode = new VerificationCode() ;
		String max = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
//			vCode = (VerificationCode) session.get(VerificationCode.class, "phone_number");
			Query query = session.createSQLQuery("select ver_code from verification_code where phone_number =\""+ phone_number +"\"  order by id desc limit 0,1");
			List ls = query.list();
			for(Object index : ls){
				max = index.toString();
			}
			transaction.commit();
			if(!session.isOpen()){
				return APIErrorCode.SESSION_ERROR;
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		finally{
			session.close();
		}
		return max;
	}
	
	@Test
	public void testCase(){
		String vc = getVerCodeByPhoneNumber("15820588570");
		System.out.println("vCode="+vc);
	}
	
}
