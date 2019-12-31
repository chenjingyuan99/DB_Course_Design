package dao;

import entity.Judge;

import java.util.List;

public interface JudgeDao extends BaseDao {

    public Judge findByID(int Id);

    public List<Judge> findAll();

    public List<Judge> findByUsrID(int usrId);

    public List<Judge> findByComID(int comId);
}
