package dao;

import java.util.List;

import entity.Label;
import org.hibernate.Session;


public class LabelDaoImpl extends BaseDaoImpl implements LabelDao {

    @Override
    public Label findByID(int labId) {
        Class clana = Label.class;
        Session session = getSession(clana);
        String hql = "from entity.Label la where la.labId = " + labId;
        List<Label> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;

    }

    @Override
    public List<Label> findAll() {
        Class clana = Label.class;
        Session session = getSession(clana);
        List<Label> list = session.createQuery("from entity.Label").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

}
