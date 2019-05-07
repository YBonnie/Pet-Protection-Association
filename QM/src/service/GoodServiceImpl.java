package service;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.GoodDao;
import factory.BasicFactory;

import javabean.Good;
import javabean.Page;
import javabean.Pet;

public class GoodServiceImpl implements GoodService{
	private GoodDao dao = BasicFactory.getFactory().getDao(GoodDao.class);
	public Good findGoodById(String id) {
		return dao.findGoodById(id);
	}

	public List<Good> findAllGood() {
		return dao.findAllGood();
	}

	public Page pageGood(int thispage, int rowperpage) {
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
		List<Good> list = dao.getGoodByPage((thispage-1)*rowperpage,rowperpage);
		page.setList4(list);
		
		return page;
	}

	public List<Good> findGoodsName(String goodsName) {
		// TODO Auto-generated method stub
		return dao.findGoodsName(goodsName);
	}

	public void delGoods(String id) {
		// TODO Auto-generated method stub
		dao.delGoods(id);
	}

	public void addGoods(Good good) {
		// TODO Auto-generated method stub
		dao.addGood(good);
	}

	public void updateGoods(Good goods) {
		// TODO Auto-generated method stub
		dao.updateGoods(goods);
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
