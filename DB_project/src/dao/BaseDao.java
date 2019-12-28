package dao;

public interface BaseDao {

    /**
     * TODO insert an object to db
     * @param obj
     */
    public void Insert(Object obj,Class clone);

    /**
     * TODO delete an object from db
     * @param obj
     */
    public void Delete(Object obj,Class clone);

    /**
     * todo update an object from db
     * @param obj
     */
    public void Update(Object obj,Class clone);

}
