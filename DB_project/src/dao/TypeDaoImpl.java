package dao;

import entity.Type;
import org.hibernate.Session;
import java.util.List;

public class TypeDaoImpl extends BaseDaoImpl implements TypeDao {
    @Override
    public Type findByID(int typId) {

        Session session = getSession(Type.class);
        String hql = "from entity.Type tp where tp.typeId=" + typId;
        List<Type> list = session.createQuery(hql).list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Type> findAll() {
        Session session = getSession(Type.class);
        List<Type> list = session.createQuery("from entity.Type").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Type findByTypeName(String typNa) {

        Session session = getSession(Type.class);
        String hql = "from entity.Type tp where tp.typeName='" + typNa + "'";
        List<Type> list = session.createQuery(hql).list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
