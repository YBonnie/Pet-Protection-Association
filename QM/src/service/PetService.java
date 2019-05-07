package service;

import java.util.List;

import javabean.News;
import javabean.Page;
import javabean.Pet;

public interface PetService extends Service {
	Pet findPetByName(String name);
	
	List<Pet> findAllPet();

	List<Pet> findPetItem(int status);
	/**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @return 当前页所有信息
	 */
	Page pagePet(int thispage, int rowperpage);
	
	Page getPetAdopByPage(int num, int from, int count);
	
	List<Pet> findPetByCond(Pet pets,int from, int count);
	
	Page getPetDiviedByPage(String kind, int from, int count);
	 
	Page getPetDivByPage(int num, String kind, int from, int count);

	void addPet(Pet pet);
	/**
	 * 依据petName 查询列表信息
	 * 存进List里面
	 * */
	List<Pet> findPetName(String petName);
	/**
	 * 根据id 删除宠物
	 * */
	void delPet(String id);
	/**
	 * 根据id 查找宠物信息你，用于修改宠物信息
	 * */
	Pet findPetById(String id);

	void updatePet(Pet pet);

	void batchDel(String[] ids);

}
