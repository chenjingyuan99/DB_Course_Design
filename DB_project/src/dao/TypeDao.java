package dao;

import entity.Type;

import java.util.List;

public interface TypeDao extends BaseDao {

    public Type findByID(int typId);

    public List<Type> findAll();

    public Type findByTypeName(String typNa);

}
