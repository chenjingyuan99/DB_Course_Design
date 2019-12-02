package dao;

import entity.MovieLanguage;

import java.util.List;

public interface MovieLangDao extends BaseDao {

    public MovieLanguage findByID(int Id);

    public List<MovieLanguage> findAll();

    public List<MovieLanguage> findByLangID(int langId);

    public List<MovieLanguage> findByMovieID(int movId);

}
