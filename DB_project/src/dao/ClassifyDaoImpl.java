package dao;

import java.util.List;

import entity.Classify;
import org.hibernate.Query;
import org.hibernate.Session;

public class ClassifyDaoImpl extends BaseDaoImpl implements ClassifyDao {
    Class clone=Classify.class;
    @Override
    public Classify findByID(int relation_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Classify a where a.relationId="+relation_id);
        //query.setInteger(0,relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Classify) list.get(0) : null;
    }

    @Override
    public List<Classify> findAll() {

        Session session = getSession(clone);
        Query query = session.createQuery("from Classify ");
        List list = (List<Classify>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Classify> findByMovieId(int movie_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Classify a where a.movieId="+movie_id);
        //query.setInteger(0, movie_id);
        List list = (List<Classify>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Classify> findByTypeId(int type_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Classify a where a.typeId="+type_id);
        //query.setInteger(0, type_id);
        List list = (List<Classify>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}