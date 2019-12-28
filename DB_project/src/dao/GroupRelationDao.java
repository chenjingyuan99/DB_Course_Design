package dao;
import entity.GroupRelation;
import java.util.List;

public interface GroupRelationDao extends BaseDao{

        public GroupRelation findByID(int relation_id);

        public List<GroupRelation> findByUsrId(int usr_id);

        public List<GroupRelation> findAll();

        public List<GroupRelation> findByGroupId(int group_id);

}

