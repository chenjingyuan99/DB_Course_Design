package dao;

import entity.Region;

import java.util.List;

public interface RegionDao extends BaseDao {

    public Region findByID(int regId);

    public List<Region> findAll();

    public Region findByRegName(String regNa);

}
