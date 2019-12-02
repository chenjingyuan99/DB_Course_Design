package dao;

import entity.Type;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

public class TypeDaoImpl extends BaseDaoImpl implements TypeDao {
    @Override
    public Type findByID(int typId) {
        Session session = getSession();
        Query query = session.createQuery("from Type tp where tp.typeId=?");
        query.setInteger(0, typId);
        List<Type> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Type> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Type");
        List list = (List<Type>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Type findByTypeName(String typNa) {
        Session session = getSession();
        Query query = session.createQuery("from Type tp where tp.typeName=?");
        query.setString(0, typNa);
        List<Type> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
