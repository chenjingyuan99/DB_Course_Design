package dao;

import entity.Scriptwriter;
import org.hibernate.Session;

import java.util.List;

public class ScriptwriterDaoImpl extends BaseDaoImpl implements ScriptwriterDao {
    @Override
    public Scriptwriter findByID(int swId) {

        Session session = getSession(Scriptwriter.class);
        String hql = "from entity.Scriptwriter sw where sw.scriptwriterId=" + swId;
        List<Scriptwriter> list = session.createQuery(hql).list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Scriptwriter> findAll() {
        Session session = getSession(Scriptwriter.class);
        List<Scriptwriter> list = session.createQuery("from entity.Scriptwriter").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Scriptwriter findByName(String swNa) {
        Session session = getSession(Scriptwriter.class);
        String hql = "from entity.Scriptwriter sw where sw.scriptwriterName='" + swNa + "'";
        List<Scriptwriter> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
