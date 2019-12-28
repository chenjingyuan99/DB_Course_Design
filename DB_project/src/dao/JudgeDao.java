package dao;

import entity.Judge;

import java.util.List;

public interface JudgeDao extends BaseDao {
    public List<Judge> findAll();

    public Judge findByUsrID(int usrId);

    public List<Judge> findByComID(int comId);
}
