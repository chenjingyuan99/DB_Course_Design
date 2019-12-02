package dao;

import entity.Direct;

import java.util.List;

public interface DirectDao extends BaseDao{

    public Direct findByID(int relation_id);

    public List<Direct> findByDirectorId(int director_id);

    public List<Direct> findAll();

    public List<Direct> findByMovieId(int movie_id);
}
