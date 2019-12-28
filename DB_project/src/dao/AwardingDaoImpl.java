package dao;

import java.util.List;

import entity.Awarding;
import org.hibernate.Query;
import org.hibernate.Session;


public class AwardingDaoImpl extends BaseDaoImpl implements AwardingDao {
    Class clone=Awarding.class;
    @Override
    public Awarding findByID(int awards_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Awarding a where a.awardsId="+awards_id);
        //query.setInteger(0, awards_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Awarding) list.get(0) : null;
    }

    @Override
    public List<Awarding> findAll() {

        Session session = getSession(clone);
        Query query = session.createQuery("from Awarding");
        List list = (List<Awarding>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Awarding> findByName(String awards_name) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Awarding a where a.awardsName="+"'"+awards_name+"'");
        //query.setString(0, awards_name);
        List list = (List<Awarding>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

}