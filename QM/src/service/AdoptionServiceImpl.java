package service;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import com.mysql.jdbc.Connection;

import dao.AdoptionDao;
import dao.UserDao;
import factory.BasicFactory;
import javabean.Adopt;

public class AdoptionServiceImpl implements AdoptionService{
	private AdoptionDao dao = BasicFactory.getFactory().getDao(AdoptionDao.class);
	public void adoption(Adopt adopt) {
	     dao.addAdoption(adopt);
		
	}
	public List<Adopt> findAllAdopt() {
		// TODO Auto-generated method stub
		return dao.findAllAdopt();
	}
	public Adopt findAdoptById(String id) {
		// TODO Auto-generated method stub
		return dao.findAdoptById(id);
	}
	public void delAdoption(String id) {
		dao.delAdoption(id);
		
	}
	public void AdminupdateAdoption(Adopt adopt) {
		dao.AdminupdateAdoption(adopt);
		
	}
	public List<Adopt> AdminfindAdoptByName(String aptName) {
		// TODO Auto-generated method stub
		return dao.AdminfindAdoptByName(aptName);
	}
	
	
	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
