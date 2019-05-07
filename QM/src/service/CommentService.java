package service;

import java.util.Date;
import java.util.List;

import javabean.Comment;

public interface CommentService extends Service{
	public List<Comment> findAllComment() ;
	public void addComment(Comment comment) ;
	/**
	 * 根据时间查找留言列表
	 * */
	public List<Comment> findCommentTimer(String commentTimer);
	
	/**
	 * 根据ID删除留言
	 * */
	public void delComment(String id);
	
	
	public void batchDel(String[] ids);
	
	
	
}
