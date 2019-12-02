package dao;

import entity.Label;

import java.util.List;

public interface LabelDao extends BaseDao {

    public Label findByID(int labId);

    public List<Label> findAll();

    public List<Label> findByComID(int comId);

}
