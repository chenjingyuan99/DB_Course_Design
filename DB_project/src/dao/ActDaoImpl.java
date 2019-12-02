package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Act;

public class ActDaoImpl extends BaseDaoImpl implements ActDao {

    @Override
    public Act findByID(int relation_id) {

        Session session = getSession();
        Query query = session.createQuery("from Act a where a.relationId=?");
        query.setInteger(0, relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Act) list.get(0) : null;
    }

    @Override
    public List<Act> findByActorId(int actor_id) {

        Session session = getSession();
        Query query = session.createQuery("from Act a where a.actorId=?");
        query.setInteger(0, actor_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Act> findAll() {

        Session session = getSession();
        Query query = session.createQuery("from Act");
        List list = (List<Act>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Act> findByMovieId(int movie_id) {

        Session session = getSession();
        Query query = session.createQuery("from Act a where a.movieId=?");
        query.setInteger(0, movie_id);
        List list = (List<Act>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Act> findByName(String role_name) {

        Session session = getSession();
        Query query = session.createQuery("from Act a where a.roleName=?");
        query.setString(0, role_name);
        List list = (List<Act>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}