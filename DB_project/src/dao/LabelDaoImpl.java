package dao;

import java.util.List;

import entity.Label;
import org.hibernate.Query;
import org.hibernate.Session;

public class LabelDaoImpl extends BaseDaoImpl implements LabelDao {

    @Override
    public Label findByID(int labId) {
        Session session = getSession();
        Query query = session.createQuery("from Label la where la.labId=?");
        query.setInteger(0, labId);
        List<Label> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Label> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Label");
        List list = (List<Label>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Label> findByComID(int comId) {
        Session session = getSession();
        Query query = session.createQuery("from Label la where la.comId=?");
        query.setInteger(0, comId);
        List<Label> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }

}
