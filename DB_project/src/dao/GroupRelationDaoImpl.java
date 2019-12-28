package dao;

import java.util.List;

import entity.GroupRelation;
import org.hibernate.Query;
import org.hibernate.Session;

public class GroupRelationDaoImpl extends BaseDaoImpl implements GroupRelationDao {
    Class clone=GroupRelation.class;
    @Override
    public GroupRelation findByID(int relation_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from GroupRelation a where a.relationId="+relation_id);
        //query.setInteger(0,relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (GroupRelation) list.get(0) : null;
    }

    @Override
    public List<GroupRelation> findAll() {

        Session session = getSession(clone);
        Query query = session.createQuery("from GroupRelation ");
        List list = (List<GroupRelation>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<GroupRelation> findByGroupId(int group_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from GroupRelation a where a.groupId="+group_id);
        //query.setInteger(0, movie_id);
        List list = (List<GroupRelation>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<GroupRelation> findByUsrId(int usr_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from GroupRelation a where a.usrId="+usr_id);
        //query.setInteger(0, type_id);
        List list = (List<GroupRelation>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}

