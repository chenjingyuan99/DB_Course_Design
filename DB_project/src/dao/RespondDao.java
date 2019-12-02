package dao;

import entity.Responding;

import java.util.List;

public interface RespondDao extends BaseDao {

    public Responding findByID(int resId);

    public List<Responding> findAll();

    public List<Responding> findByDisID(int disId);

}
