package dao;

import entity.Movie;

import java.util.List;

public interface MovieDao extends BaseDao {

    public Movie findByID(int movId);

    public List<Movie> findAll();

    public Movie findByName(String movNa);

}
