package dao;

import entity.Memgroup;
import org.hibernate.Session;

import java.util.List;

public class MemgroupDaoImpl extends BaseDaoImpl implements MemgroupDao {
    @Override
    public Memgroup findByID(int Id) {
        Class clana = Memgroup.class;
        Session session = getSession(clana);
        String hql = "from entity.Memgroup la where la.groupId = " + Id;
        List<Memgroup> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public Memgroup findByMovID(int Id) {
        Class clana = Memgroup.class;
        Session session = getSession(clana);
        String hql = "from entity.Memgroup la where la.movieId = " + Id;
        List<Memgroup> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Memgroup> findAll() {
        Class clana = Memgroup.class;
        Session session = getSession(clana);
        List<Memgroup> list = session.createQuery("from entity.Memgroup").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}
