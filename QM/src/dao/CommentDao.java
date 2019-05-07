package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javabean.Comment;
import javabean.Good;

public interface CommentDao extends Dao{
	public List<Comment> findAllComment() ;
	public void addComment(Comment comment) ;
	/**
	 * 
	 * 根据时间查找留言列表
	 * */
	public List<Comment> findCommentTimer(String commentTimer);
	/**
	 * 根据id删除留言
	 * */
	public void delComment(String id);
	
	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException;
   
}
