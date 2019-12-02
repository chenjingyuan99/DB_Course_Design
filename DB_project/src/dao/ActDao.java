package dao;

import java.util.List;

import entity.Act;

public interface ActDao extends BaseDao {

    /*****
     * todo find act relationship by relation_id
     * @param relation_id
     * @return act
     */
    public Act findByID(int relation_id);

    /***
     * todo find act relationship by actor_id
     * @param actor_id
     * @return act
     */
    public List<Act> findByActorId(int actor_id);

    /**
     * todo find the list of all the actors
     * @return list of act
     */

    public List<Act> findAll();

    /**
     * todo  find act relationship by movie_id
     * @param movie_id
     * @return act
     */

    public List<Act> findByMovieId(int movie_id);

    /**
     * todo find act relationship by role_name
     * @param role_name
     * @return
     */
    public List<Act> findByName(String role_name);

}
