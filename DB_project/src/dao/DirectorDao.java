package dao;

import entity.Director;

import java.util.List;

public interface DirectorDao extends BaseDao{

    public Director findByID(int director_id);

    public List<Director> findAll();

    public List<Director> findByName(String director_name);
}
