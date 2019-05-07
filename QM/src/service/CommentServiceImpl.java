package service;

import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.CommentDao;
import dao.GoodDao;
import factory.BasicFactory;

import javabean.Comment;

public class CommentServiceImpl implements CommentService{
	private CommentDao dao = BasicFactory.getFactory().getDao(CommentDao.class);
	public List<Comment> findAllComment() {
		
		return dao.findAllComment();
	}

	public void addComment(Comment comment) {
		dao.addComment(comment);
	}

	public List<Comment> findCommentTimer(String commentTimer) {
		// TODO Auto-generated method stub
		return dao.findCommentTimer(commentTimer);
	}

	public void delComment(String id) {
		// TODO Auto-generated method stub
		dao.delComment(id);
	}

	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

	
}
