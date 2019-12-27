package dao;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BaseDaoImpl implements BaseDao{
	
	public static Session getSession(Class clana) {
		Configuration cfg = new Configuration().configure().addClass(clana);
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public void Insert(Object obj, Class clana) {
		Session session = getSession(clana);
		session.save(obj);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void Delete(Object obj, Class clana) {
        	Session session = getSession(clana);
		session.delete(obj);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void Update(Object obj, Class clana) {
        Session session = getSession(clana);
        session.update(obj);
		session.beginTransaction().commit();
		session.close();
	}
	
}
