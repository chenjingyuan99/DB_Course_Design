package dao;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BaseDaoImpl implements BaseDao{
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure();		
		//ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
	}

	@Override
	public void Insert(Object obj) {
		Session session = getSession();
		session.save(obj);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void Delete(Object obj) {
		Session session = getSession();
		session.delete(obj);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void Update(Object obj) {
		Session session = getSession();
		session.update(obj);
		session.beginTransaction().commit();
		session.close();
	}
	
}
