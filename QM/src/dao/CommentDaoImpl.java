package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.TransactionManager;

import javabean.Comment;
import javabean.Good;
import javabean.Pet;
import javabean.User;

public class CommentDaoImpl implements CommentDao {

	public List<Comment> findAllComment() {
		String sql = "select * from comment order by time desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Comment>(Comment.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addComment(Comment comment) {
		String sql = "insert into comment values(null,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,comment.getTime(),comment.getUser_id(),comment.getText(),comment.getUsername());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Comment> findCommentTimer(String commentTimer) {
		String sql = "select * from comment where time = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Comment>(Comment.class),commentTimer);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delComment(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from comment where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from comment where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}

	
	
	

	
	
}
