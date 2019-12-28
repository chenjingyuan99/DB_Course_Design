package dao;

import entity.Memgroup;

import java.util.List;

public interface MemgroupDao {
    public Memgroup findByMovID(int Id);

    public List<Memgroup> findAll();
}
