package dao;

import entity.Location;

import java.util.List;

public interface LocationDao extends BaseDao {

    public Location findByID(int Id);

    public List<Location> findAll();

    public List<Location> findByRegID(int regId);

    public List<Location> findByMovieID(int movId);

}
