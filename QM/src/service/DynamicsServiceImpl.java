package service;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.DynamicsDao;
import factory.BasicFactory;

import javabean.Dynamics;
import javabean.News;
import javabean.Page;

public class DynamicsServiceImpl implements DynamicsService{
	private DynamicsDao dao = BasicFactory.getFactory().getDao(DynamicsDao.class);

	public Dynamics findDynamicsById(String id) {
		// TODO Auto-generated method stub
		return dao.findDynamicsById(id);
	}

	public List<Dynamics> findAllDynamics() {
		// TODO Auto-generated method stub
		return dao.findAllDynamics();
	}

	public Page pageDynamics(int thispage, int rowperpage) {
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<Dynamics> list = dao.getDynamicsByPage((thispage-1)*rowperpage,rowperpage);
		for (Dynamics dynamics : list) {
			System.out.println(dynamics);
		}
		page.setList1(list);
		
		return page;
	}

	public List<Dynamics> findDynamicsTitle(String findDynaTitle) {
		// TODO Auto-generated method stub
		return dao.findDynamicsTitle(findDynaTitle);
	}

	public void delDynamics(String id) {
		// TODO Auto-generated method stub
		dao.delDynamics(id);
	}

	public void addDynamics(Dynamics dynamics) {
		// TODO Auto-generated method stub
		dao.addDynamics(dynamics);
	}

	public void updateDynamics(Dynamics dynamics) {
		// TODO Auto-generated method stub
		dao.updateDynamics(dynamics);
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
