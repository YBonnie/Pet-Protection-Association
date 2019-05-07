package service;

import java.util.List;

import javabean.Good;
import javabean.Page;

public interface GoodService extends Service{
	Good findGoodById(String id);

	List<Good> findAllGood();
	/**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @return 当前页所有信息
	 */
	Page pageGood(int thispage, int rowperpage);
	/**
	 * 根据goodsName查找商品
	 * */
	List<Good> findGoodsName(String goodsName);
	/**
	 * 根据ID 删除商品列表
	 * */
	void delGoods(String id);
	
	/**
	 * 添加商品
	 * */
	void addGoods(Good good);
	/**
	 * 更新商品数据
	 * */
	void updateGoods(Good goods);

	void batchDel(String[] ids);
}
