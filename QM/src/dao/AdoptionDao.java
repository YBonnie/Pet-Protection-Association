package dao;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import javabean.Adopt;

public interface AdoptionDao extends Dao{
	public void addAdoption(Adopt adopt) ;
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Adopt> findAllAdopt();

	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	Adopt findAdoptById(String id);

	public void delAdoption(String id);

	public void AdminupdateAdoption(Adopt adopt);

	public List<Adopt> AdminfindAdoptByName(String aptName);

	public void delCustByIDWithTrans(java.sql.Connection conn, String id) throws SQLException;

	
	
}
