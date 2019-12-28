package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Actor;

public class ActorDaoImpl extends BaseDaoImpl implements ActorDao {

    Class clone=Actor.class;
    @Override
    public Actor findByID(int actor_id) {
        //Class clone=Actor.class;
        Session session = getSession(clone);
        Query query = session.createQuery("from Actor a where a.actorId="+actor_id);
        //query.setInteger(0, actor_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Actor) list.get(0) : null;
    }

    @Override
    public List<Actor> findAll() {
        //Class clone=Actor.class;
        Session session = getSession(clone);
        Query query = session.createQuery("from Actor");
        List list = (List<Actor>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Actor> findByName(String actor_name) {
        //Class clone=Actor.class;
        Session session = getSession(clone);
        Query query = session.createQuery("from Actor a where a.actorName="+"'"+actor_name+"'");
        //query.setString(0, actor_name);
        List list = (List<Actor>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

}