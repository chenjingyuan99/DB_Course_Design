package dao;

import java.util.List;

import entity.Discuss;
import org.hibernate.Query;
import org.hibernate.Session;

public class DiscussDaoImpl extends BaseDaoImpl implements DiscussDao {

    @Override
    public Discuss findByID(int relation_id) {

        Session session = getSession();
        Query query = session.createQuery("from Discuss a where a.relationId=?");
        query.setInteger(0,relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Discuss) list.get(0) : null;
    }

    @Override
    public List<Discuss> findAll() {

        Session session = getSession();
        Query query = session.createQuery("from Discuss ");
        List list = (List<Discuss>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Discuss> findByMovieId(int movie_id) {

        Session session = getSession();
        Query query = session.createQuery("from Discuss a where a.movieId=?");
        query.setInteger(0, movie_id);
        List list = (List<Discuss>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Discuss> findByDiscussId(int discuss_id) {

        Session session = getSession();
        Query query = session.createQuery("from Discuss a where a.discussId=?");
        query.setInteger(0, discuss_id);
        List list = (List<Discuss>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

}