package dao;

import entity.Language;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class LangDaoImpl extends BaseDaoImpl implements LangDao {
    @Override
    public Language findByID(int lanId) {
        Session session = getSession();
        Query query = session.createQuery("from Language lg where lg.languageId=?");
        query.setInteger(0, lanId);
        List<Language> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Language> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Language");
        List list = (List<Language>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Language findByLangName(String langNa) {
        Session session = getSession();
        Query query = session.createQuery("from Language lg where lg.languageName=?");
        query.setString(0, langNa);
        List<Language> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
