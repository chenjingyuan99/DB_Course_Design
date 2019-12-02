package dao;

import entity.Discussion;

import java.util.List;

public interface DiscussionDao extends BaseDao{

    public Discussion findByID(int discuss_id);

    public List<Discussion> findAll();

    public List<Discussion> findByName(String discuss_topic);
}
