package dao;

import entity.MovieLanguage;
import org.hibernate.Session;

import java.util.List;

public class MovieLangDaoImpl extends BaseDaoImpl implements MovieLangDao {
    @Override
    public MovieLanguage findByID(int Id) {
        Session session = getSession(entity.MovieLanguage.class);
        String hql = "from entity.MovieLanguage mv where mv.movieId=" + Id;
        List<MovieLanguage> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<MovieLanguage> findAll() {
        Session session = getSession(entity.MovieLanguage.class);
        List<MovieLanguage> list = session.createQuery("from entity.MovieLanguage").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<MovieLanguage> findByLangID(int langId) {
        Session session = getSession(entity.MovieLanguage.class);
        String hql = "from entity.MovieLanguage mv where mv.languageId=" + langId;
        List<MovieLanguage> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public List<MovieLanguage> findByMovieID(int movId) {
        Session session = getSession(entity.MovieLanguage.class);
        String hql = "from entity.MovieLanguage mv where mv.movieId=" + movId;
        List<MovieLanguage> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
