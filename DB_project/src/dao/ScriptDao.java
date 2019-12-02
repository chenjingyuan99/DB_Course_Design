package dao;

import entity.Script;

import java.util.List;

public interface ScriptDao extends BaseDao {

    public Script findByID(int Id);

    public List<Script> findAll();

    public List<Script> findByWritterID(int wrId);

    public List<Script> findByMovieID(int movId);

}
