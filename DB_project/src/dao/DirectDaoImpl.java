package dao;

import java.util.List;

import entity.Direct;
import org.hibernate.Query;
import org.hibernate.Session;

public class DirectDaoImpl extends BaseDaoImpl implements DirectDao {

    @Override
    public Direct findByID(int relation_id) {

        Session session = getSession();
        Query query = session.createQuery("from Direct a where a.relationId=?");
        query.setInteger(0,relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Direct) list.get(0) : null;
    }

    @Override
    public List<Direct> findAll() {

        Session session = getSession();
        Query query = session.createQuery("from Direct ");
        List list = (List<Direct>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Direct> findByMovieId(int movie_id) {

        Session session = getSession();
        Query query = session.createQuery("from Direct a where a.movieId=?");
        query.setInteger(0, movie_id);
        List list = (List<Direct>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

        @Override
        public List<Direct> findByDirectorId(int director_id) {

            Session session = getSession();
            Query query = session.createQuery("from Direct a where a.directorId=?");
            query.setInteger(0, director_id);
            List list = (List<Direct>) query.list();
            session.beginTransaction().commit();
            session.close();
            return list;
    }
}