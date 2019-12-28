package dao;

import java.util.List;

import entity.Discussion;
import org.hibernate.Query;
import org.hibernate.Session;


public class DiscussionDaoImpl extends BaseDaoImpl implements DiscussionDao {
    Class clone= Discussion.class;
    @Override
    public Discussion findByID(int discuss_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Discussion a where a.discussId="+discuss_id);
        //query.setInteger(0, discuss_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Discussion) list.get(0) : null;
    }

    @Override
    public List<Discussion> findAll() {

        Session session = getSession(clone);
        Query query = session.createQuery("from Discussion ");
        List list = (List<Discussion>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Discussion> findByName(String discuss_topic) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Discussion a where a.discussTopic="+"'"+discuss_topic+"'");
        //query.setString(0, discuss_topic);
        List list = (List<Discussion>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

}