package dao;

import entity.Scriptwriter;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class ScriptwriterDaoImpl extends BaseDaoImpl implements ScriptwriterDao {
    @Override
    public Scriptwriter findByID(int swId) {
        Session session = getSession();
        Query query = session.createQuery("from Scriptwriter sw where sw.scriptwriterId=?");
        query.setInteger(0, swId);
        List<Scriptwriter> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Scriptwriter> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Scriptwriter");
        List list = (List<Scriptwriter>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Scriptwriter findByName(String swNa) {
        Session session = getSession();
        Query query = session.createQuery("from Scriptwriter sw where sw.scriptwriterName=?");
        query.setString(0, swNa);
        List<Scriptwriter> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
