package dao;

import entity.Browse;

import java.util.List;

public interface BrowseDao {

    public Browse findByID(int browse_id);

    public List<Browse> findAll();
}
