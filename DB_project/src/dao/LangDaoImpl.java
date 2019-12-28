package dao;

import entity.Language;
import org.hibernate.Session;

import java.util.List;

public class LangDaoImpl extends BaseDaoImpl implements LangDao {
    @Override
    public Language findByID(int lanId) {
        Class clana = Language.class;
        Session session = getSession(clana);
        String hql = "from entity.Language la where la.languageId = " + lanId;
        List<Language> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();
        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Language> findAll() {
        Class clana = Language.class;
        Session session = getSession(clana);
        List<Language> list = session.createQuery("from entity.Language").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Language findByLangName(String langNa) {
        Class clana = Language.class;
        Session session = getSession(clana);
        String hql = "from entity.Language la where la.languageName = '" + langNa + "'";
        List<Language> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();
        return list.size()>0?list.get(0):null;
    }
}
