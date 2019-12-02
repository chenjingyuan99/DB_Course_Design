package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Awards;

public class AwardsDaoImpl extends BaseDaoImpl implements AwardsDao {

    @Override
    public Awards findByID(int relation_id) {

        Session session = getSession();
        Query query = session.createQuery("from Awards a where a.relationId=?");
        query.setInteger(0, relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Awards) list.get(0) : null;
    }

    @Override
    public List<Awards> findByAwardsId(int awards_id) {

        Session session = getSession();
        Query query = session.createQuery("from Awards a where a.awardsId=?");
        query.setInteger(0, awards_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Awards> findAll() {

        Session session = getSession();
        Query query = session.createQuery("from Awards ");
        List list = (List<Awards>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Awards> findByMovieId(int movie_id) {

        Session session = getSession();
        Query query = session.createQuery("from Awards a where a.movieId=?");
        query.setInteger(0, movie_id);
        List list = (List<Awards>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}