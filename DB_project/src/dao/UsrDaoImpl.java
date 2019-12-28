package dao;

import entity.Usr;
import org.hibernate.Session;
import java.util.List;

public class UsrDaoImpl extends BaseDaoImpl implements UsrDao {
    @Override
    public Usr findByID(int usrId) {
        Session session = getSession(Usr.class);
        String hql = "from entity.Usr ur where ur.usrId=" + usrId;
        List<Usr> list = session.createQuery(hql).list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Usr> findAll() {
        Session session = getSession(Usr.class);
        List<Usr> list = session.createQuery("from entity.Usr").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Usr findByName(String usrNa) {
        Session session = getSession(Usr.class);
        String hql = "from entity.Usr ur where ur.usrNickname='" + usrNa + "'";
        List<Usr> list = session.createQuery(hql).list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
