package dao;

import entity.Responding;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class RespondDaoImpl extends BaseDaoImpl implements RespondDao {
    @Override
    public Responding findByID(int resId) {
        Session session = getSession();
        Query query = session.createQuery("from Responding rs where rs.respondId=?");
        query.setInteger(0, resId);
        List<Responding> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Responding> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Responding");
        List list = (List<Responding>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Responding> findByDisID(int disId) {
        Session session = getSession();
        Query query = session.createQuery("from Responding rp where rp.discussId=?");
        query.setInteger(0, disId);
        List<Responding> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
