package dao;

import entity.Discuss;

import java.util.List;

public interface DiscussDao extends BaseDao{

    public Discuss findByID(int relation_id);

    public List<Discuss> findByDiscussId(int discuss_id);

    public List<Discuss> findAll();

    public List<Discuss> findByMovieId(int movie_id);

}
