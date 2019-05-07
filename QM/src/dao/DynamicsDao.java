package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javabean.Dynamics;
import javabean.News;

public interface DynamicsDao extends Dao{
	
	public Dynamics findDynamicsById(String id) ;

	/**
	 * 查询遍历所有的Dynamics内容
	 * */
	public List<Dynamics> findAllDynamics();
	
	public void addDynamics(Dynamics dynamics) ;
	int getCountRow();
	List<Dynamics> getDynamicsByPage(int from, int count);
	/**
	 * 根据动态名查询协会动态
	 * 
	 * */
	public List<Dynamics> findDynamicsTitle(String findDynaTitle);
	/**
	 * 根据id删除动态信息
	 * 
	 * */
	public void delDynamics(String id);
/**
 * 更新协会动态信息*/
	public void updateDynamics(Dynamics dynamics);

public void delCustByIDWithTrans(Connection conn, String id) throws SQLException;

}
