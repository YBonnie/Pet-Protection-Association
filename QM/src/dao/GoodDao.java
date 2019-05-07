package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javabean.Good;
import javabean.Pet;

public interface GoodDao  extends Dao{
	public Good findGoodById(String id) ;
	public List<Good> findAllGood() ;
	public void addGood(Good good) ;
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
	List<Good> getGoodByPage(int from, int count);

	/**
	 * 扣除商品库存数量
	 * @param Product_id
	 * @param buynum
	 * @throws SQLException 
	 */
	void delPnum(int Product_id, int buynum) throws SQLException;
	public Good findGoodById(int id);
   void addPnum(int product_id, int buynum);
   /**
	 * 根据goodsName查找商品
	 * */
public List<Good> findGoodsName(String goodsName);
/**
 * 根据ID 删除商品列表
 * */
public void delGoods(String id);
/**
 * 更新商品数据
 * */
public void updateGoods(Good goods);

public void delCustByIDWithTrans(Connection conn, String id) throws SQLException;



}
