package dao;

import entity.ComLab;

import java.util.List;

public interface ComlabDao extends BaseDao {

    public List<ComLab> findAll();

    public ComLab findByLabID(int labId);

    public List<ComLab> findByComID(int comId);
}

