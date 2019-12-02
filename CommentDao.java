package dao;

import entity.Comment;

import java.util.List;

public interface CommentDao extends BaseDao{

    public Comment findByID(int relation_id);

    public List<Comment> findAll();

    public List<Comment> findByMovieId(int mov_id);

    public List<Comment> findByUsrId(int usr_id);

    public List<Comment> findByComId(int com_id);
}
