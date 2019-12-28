package dao;

import entity.Script;
import org.hibernate.Session;

import java.util.List;

public class ScriptDaoImpl extends BaseDaoImpl implements ScriptDao {
    @Override
    public Script findByID(int Id) {
        Session session = getSession(Script.class);
        String hql = "from entity.Script sc where sc.relationId=" + Id;
        List<Script> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Script> findAll() {
        Session session = getSession(Script.class);
        List<Script> list = session.createQuery("from entity.Script").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Script> findByWritterID(int wrId) {
        Session session = getSession(Script.class);
        String hql = "from entity.Script sc where sc.scriptwriterId=" + wrId;
        List<Script> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Script> findByMovieID(int movId) {
        Session session = getSession(Script.class);
        String hql = "from entity.Script sc where sc.movieId=" + movId;
        List<Script> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
