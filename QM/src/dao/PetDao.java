package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javabean.News;
import javabean.Pet;

public interface PetDao extends Dao {
	public Pet findPetByName(String name) ;

	/**
	 * Pet
	 * 查询数据库中一共有多少条记录
	 * @return
	 */
	public List<Pet> findAllPet() ;
	
	/**
	 * 
	 * 在数据库中查找Pet是否被领养
	 * @return
	 */
	List<Pet> findPetItems(int status);
	/**
	 * 查询数据库中一共有多少条记录
	 * @return
	 */
	int getCountRow();

	/**
	 * 查询指定记录后多少条记录
	 * @param from 从哪条记录后取
	 * @param count 取多少条
	 * @return
	 */
	List<Pet> getPetByPage(int from, int count);
	
	List<Pet> getPetAdopByPage(int num, int from, int count);
	
	List<Pet> getPetSelectByPage(Pet pets, int from, int count);

    List<Pet> getPetDiviedByPage(String kind, int from, int count);
    
    List<Pet> getPetDivByPage(int status, String kind, int from, int count);

	public void addPet(Pet pet);

	public List<Pet> findPetName(String petName);

	public void delPet(String id);

	public Pet findPetById(String id);

	public void updatePet(Pet pet);

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException;
    
 



	



}
