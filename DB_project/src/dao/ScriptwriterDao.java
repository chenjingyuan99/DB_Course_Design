package dao;

import entity.Scriptwriter;

import java.util.List;

public interface ScriptwriterDao extends BaseDao {

    public Scriptwriter findByID(int swId);

    public List<Scriptwriter> findAll();

    public Scriptwriter findByName(String swNa);

}
