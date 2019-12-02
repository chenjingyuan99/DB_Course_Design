package dao;

import entity.Movie;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class MovieDaoImpl extends BaseDaoImpl implements MovieDao {

    @Override
    public Movie findByID(int movId) {
        Session session = getSession();
        Query query = session.createQuery("from Movie mv where mv.movieId=?");
        query.setInteger(0, movId);
        List<Movie> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Movie> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Movie");
        List list = (List<Movie>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Movie findByName(String movNa) {
        Session session = getSession();
        Query query = session.createQuery("from Movie mv where mv.movieName=?");
        query.setString(0, movNa);
        List<Movie> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
