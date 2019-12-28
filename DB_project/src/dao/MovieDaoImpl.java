package dao;

import entity.Movie;
import org.hibernate.Session;

import java.util.List;

public class MovieDaoImpl extends BaseDaoImpl implements MovieDao {

    @Override
    public Movie findByID(int movId) {
        Class clana = entity.Movie.class;
        Session session = getSession(clana);
        String hql = "from entity.Movie mv where mv.movieId=" + movId;
        List<Movie> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Movie> findAll() {
        Class clana = entity.Movie.class;
        Session session = getSession(clana);
        List<Movie> list = session.createQuery("from entity.Movie").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Movie findByName(String movNa) {
        Class clana = entity.Movie.class;
        Session session = getSession(clana);
        String hql = "from entity.Movie mv where mv.movieName='" + movNa + "'";
        List<Movie> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
