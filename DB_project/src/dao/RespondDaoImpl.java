package dao;

import entity.Responding;
import org.hibernate.Session;

import java.util.List;

public class RespondDaoImpl extends BaseDaoImpl implements RespondDao {
    @Override
    public Responding findByID(int resId) {
        Session session = getSession(Responding.class);
        String hql = "from entity.Responding rs where rs.respondId=" + resId;
        List<Responding> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Responding> findAll() {
        Session session = getSession(Responding.class);
        List<Responding> list = session.createQuery("from entity.Responding").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Responding> findByDisID(int disId) {
        Session session = getSession(Responding.class);
        String hql = "from entity.Responding rp where rp.discussId=" + disId;
        List<Responding> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
