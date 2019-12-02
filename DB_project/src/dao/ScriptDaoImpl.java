package dao;

import entity.Script;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ScriptDaoImpl extends BaseDaoImpl implements ScriptDao {
    @Override
    public Script findByID(int Id) {
        Session session = getSession();
        Query query = session.createQuery("from Script sc where sc.relationId=?");
        query.setInteger(0, Id);
        List<Script> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Script> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Script");
        List list = (List<Script>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Script> findByWritterID(int wrId) {
        Session session = getSession();
        Query query = session.createQuery("from Script sc where sc.scriptwriterId=?");
        query.setInteger(0, wrId);
        List<Script> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public List<Script> findByMovieID(int movId) {
        Session session = getSession();
        Query query = session.createQuery("from Script sc where sc.movieId=?");
        query.setInteger(0, movId);
        List<Script> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
