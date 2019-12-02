package dao;

import entity.Classify;

import java.util.List;

public interface ClassifyDao extends BaseDao{

    public Classify findByID(int relation_id);

    public List<Classify> findByTypeId(int type_id);

    public List<Classify> findAll();

    public List<Classify> findByMovieId(int movie_id);

}
