package service;

import java.util.List;

import javabean.Dynamics;
import javabean.Page;

public interface DynamicsService extends Service{
	Dynamics findDynamicsById(String id);

	List<Dynamics> findAllDynamics();
	/**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @return 当前页所有信息
	 */
	Page pageDynamics(int thispage, int rowperpage);

	/**
	 * 根据动态名查询协会动态
	 * 
	 * */
	List<Dynamics> findDynamicsTitle(String findDynaTitle);
	/**
	 * 根据id删除动态信息
	 * 
	 * */
	void delDynamics(String id);
	/**添加协会动态内容*/
	void addDynamics(Dynamics dynamics);
	/**
	 * 更新协会动态信息*/
	void updateDynamics(Dynamics dynamics);

	void batchDel(String[] ids);
}
