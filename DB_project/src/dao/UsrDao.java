package dao;

import entity.Usr;

import java.util.List;

public interface UsrDao extends BaseDao {

    public Usr findByID(int usrId);

    public List<Usr> findAll();

    public Usr findByName(String usrNa);

}
