package dao;

import entity.Awards;

import java.util.List;

public interface AwardsDao extends BaseDao {

    public Awards findByID(int relation_id);

    public List<Awards> findByAwardsId(int awards_id);

    public List<Awards> findAll();

    public List<Awards> findByMovieId(int movie_id);
}
