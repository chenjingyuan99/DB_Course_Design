package dao;

import entity.MovieLanguage;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class MovieLangDaoImpl extends BaseDaoImpl implements MovieLangDao {
    @Override
    public MovieLanguage findByID(int Id) {
        Session session = getSession();
        Query query = session.createQuery("from MovieLanguage mov where mov.relationId=?");
        query.setInteger(0, Id);
        List<MovieLanguage> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<MovieLanguage> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from MovieLanguage");
        List list = (List<MovieLanguage>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<MovieLanguage> findByLangID(int langId) {
        Session session = getSession();
        Query query = session.createQuery("from MovieLanguage ml where ml.languageId=?");
        query.setInteger(0, langId);
        List<MovieLanguage> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public List<MovieLanguage> findByMovieID(int movId) {
        Session session = getSession();
        Query query = session.createQuery("from MovieLanguage ml where ml.movieId=?");
        query.setInteger(0, movId);
        List<MovieLanguage> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
