package dao;

import entity.Actor;

import java.util.List;

public interface ActorDao extends BaseDao{

    public Actor findByID(int actor_id);

    public List<Actor> findAll();

    public List<Actor> findByName(String actor_name);

}
