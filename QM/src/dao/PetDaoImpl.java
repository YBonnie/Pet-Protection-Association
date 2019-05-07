package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import util.DaoUtils;
import util.TransactionManager;

import javabean.News;
import javabean.Pet;
import javabean.User;

public  class PetDaoImpl implements PetDao{

	public Pet findPetByName(String name) {
		String sql = "select * from pets where name = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Pet>(Pet.class),name);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Pet> findAllPet() {
		String sql = "select * from pets order by id desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Pet>(Pet.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据领养状态status 查找未领养宠物，同时以id倒序的方式显示
	 * */

	public List<Pet> findPetItems(int status) {
		String sql = "select * from pets where status = ? order by id desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Pet>(Pet.class),status);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getCountRow() {
		String sql = "select count(*) from pets";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Pet> getPetByPage(int from, int count) {
		String sql = "select * from pets order by id desc limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Pet>(Pet.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Pet> getPetAdopByPage(int num, int from, int count) {
		String sql = "select * from pets where status = ? limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Pet>(Pet.class),num,from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<Pet> getPetSelectByPage(Pet pets, int from, int count) {
		// TODO Auto-generated method stub
				String sql = "select * from pets where 1=1 ";
				List<Object> list = new ArrayList<Object>();
				if(pets.getKind()!=null && !"".equals(pets.getKind())){
					sql += " and kind like ?";
					list.add("%"+pets.getKind()+"%");
				}
				list.add(from);
				list.add(count);
				sql += "limit ?,?";
				try{
					QueryRunner runner = new QueryRunner(DaoUtils.getSource());
					if(list.size()<=0){
						return runner.query(sql, new BeanListHandler<Pet>(Pet.class));
					}else{
						return runner.query(sql, new BeanListHandler<Pet>(Pet.class),list.toArray());
					}
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
	}

	public List<Pet> getPetDiviedByPage(String kind, int from, int count) {
		String sql = "select * from pets where kind = ? limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<Pet>(Pet.class),kind,from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	

	public List<Pet> getPetDivByPage(int num, String kind, int from, int count) {
		// TODO Auto-generated method stub
				String sql = "select * from pets where 1=1 ";
				List<Object> list = new ArrayList<Object>();
				
				if(num == 0||num ==1){
					sql += " and status = ? ";
					list.add(num);
					
				}
				if(kind!=""){
					sql += " and kind like ?";
					list.add(kind);
				}
				list.add(from);
				list.add(count);
				sql += "limit ?,?";
				try{
					QueryRunner runner = new QueryRunner(DaoUtils.getSource());
					if(list.size()<=0){
						return runner.query(sql, new BeanListHandler<Pet>(Pet.class));
					}else{
						return runner.query(sql, new BeanListHandler<Pet>(Pet.class),list.toArray());
					}
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
	}

	public void addPet(Pet pet) {
		String sql = "insert into pets values(null,?,?,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,pet.getKind(),pet.getName(),pet.getAge(),pet.getSex(),pet.getType(),pet.getStatus(),pet.getImgurl());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
		
	}

	public List<Pet> findPetName(String petName) {
		String sql = "select * from pets where name = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Pet>(Pet.class),petName);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delPet(String id) {
		// TODO Auto-generated method stub
				String sql = "delete from pets where id = ?";
				try{
					QueryRunner runner = new QueryRunner(TransactionManager.getSource());
					runner.update(sql,id);
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		
	}

	public Pet findPetById(String id) {
		String sql = "select * from pets where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Pet>(Pet.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updatePet(Pet pet) {
		// TODO Auto-generated method stub
				String sql = "update pets set kind = ? ,name = ? ,age = ? ,sex = ? ,type = ? ,status = ? , imgurl = ? where id=?";
				try{
					QueryRunner runner = new QueryRunner(TransactionManager.getSource());
					runner.update(sql,pet.getKind(),pet.getName(),pet.getAge(),pet.getSex(),pet.getType(),pet.getStatus(),pet.getImgurl(),pet.getId());
				}catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
				
		
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from pets where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}



}
