package service;

import java.util.List;

import javabean.Adopt;



public interface AdoptionService extends Service{
	void adoption(Adopt adopt);

	List<Adopt> findAllAdopt();
	
	/**
	 * 根据id查找商品信息
	 * @param id
	 * @return
	 */
	Adopt findAdoptById(String id);

	void delAdoption(String id);

	void AdminupdateAdoption(Adopt adopt);

	List<Adopt> AdminfindAdoptByName(String aptName);
	
	/**
	 * 批量伤处客户 其中会进行事务管理
	 * @param ids 所有要删除的id组成的数组
	 */
	void batchDel(String[] ids);

}
