package dao;

import entity.Usr;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class UsrDaoImpl extends BaseDaoImpl implements UsrDao {
    @Override
    public Usr findByID(int usrId) {
        Session session = getSession();
        Query query = session.createQuery("from Usr ur where ur.usrId=?");
        query.setInteger(0, usrId);
        List<Usr> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Usr> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Usr");
        List list = (List<Usr>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Usr findByName(String usrNa) {
        Session session = getSession();
        Query query = session.createQuery("from Usr ur where ur.usrNickname=?");
        query.setString(0, usrNa);
        List<Usr> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
