package dao;

import entity.Memgroup;

import java.util.List;

public interface MemgroupDao extends BaseDao {
    public Memgroup findByID(int Id);

    public Memgroup findByMovID(int Id);

    public List<Memgroup> findAll();
}
