package dao;

import entity.Awarding;

import java.util.List;

public interface AwardingDao extends BaseDao {

    public Awarding findByID(int awards_id);

    public List<Awarding> findAll();

    public List<Awarding> findByName(String awards_name);

}

