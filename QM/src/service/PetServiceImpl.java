package service;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.PetDao;
import dao.UserDao;
import factory.BasicFactory;

import javabean.News;
import javabean.Page;
import javabean.Pet;

public class PetServiceImpl implements PetService{
	private PetDao dao = BasicFactory.getFactory().getDao(PetDao.class);
	public Pet findPetByName(String name) {
		return dao.findPetByName(name);
	}

	public List<Pet> findAllPet() {
		return dao.findAllPet();
	}

	public List<Pet> findPetItem(int status) {
		// TODO Auto-generated method stub
		return dao.findPetItems(status);
	}

	public Page pagePet(int thispage, int rowperpage) {
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
		List<Pet> list = dao.getPetByPage((thispage-1)*rowperpage,rowperpage);
		page.setList2(list);
		
		return page;
	}

	public Page getPetAdopByPage(int num, int from, int count) {
		Page page = new Page();
		//--当前页
		page.setThispage(from);
		//--每页记录数
		page.setRowperpage(count);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/count+(countrow%count==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(from==1?1:from-1);
		//--下一页
		page.setNextpage(from == countpage ? countpage : from+1);
		//--当前页数据
		List<Pet> list = dao.getPetAdopByPage(num,(from-1)*count,count);
		page.setList2(list);
		
		return page;
	}

	public List<Pet> findPetByCond(Pet pets, int from, int count) {
		// TODO Auto-generated method stub
		return dao.getPetSelectByPage(pets, from, count);
	}

	public Page getPetDiviedByPage(String kind, int from, int count) {
		Page page = new Page();
		//--当前页
		page.setThispage(from);
		//--每页记录数
		page.setRowperpage(count);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/count+(countrow%count==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(from==1?1:from-1);
		//--下一页
		page.setNextpage(from == countpage ? countpage : from+1);
		//--当前页数据
		List<Pet> list = dao.getPetDiviedByPage(kind,(from-1)*count,count);
		page.setList2(list);
		
		return page;
	}

	public Page getPetDivByPage(int num, String kind, int from, int count) {
		Page page = new Page();
		//--当前页
		page.setThispage(from);
		//--每页记录数
		page.setRowperpage(count);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/count+(countrow%count==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(from==1?1:from-1);
		//--下一页
		page.setNextpage(from == countpage ? countpage : from+1);
		//--当前页数据
		List<Pet> list = dao.getPetDivByPage(num, kind,(from-1)*count,count);
		page.setList2(list);
		
		return page;
	}

	public void addPet(Pet pet) {
		dao.addPet(pet);
		
	}

	public List<Pet> findPetName(String petName) {
		// TODO Auto-generated method stub
		return dao.findPetName(petName);
	}

	public void delPet(String id) {
		dao.delPet(id);
	}

	public Pet findPetById(String id) {
		// TODO Auto-generated method stub
		return dao.findPetById(id);
	}

	public void updatePet(Pet pet) {
		dao.updatePet(pet);
		
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
