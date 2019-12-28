package dao;

import entity.Act;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class BaseDaoImpl implements BaseDao{

    public Session getSession(Class clone) {
        Configuration cfg = new Configuration().configure().addClass(clone);
        //cfg.addClass(Act.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        return cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build()).openSession();
        /*Configuration conf = new Configuration().configure();

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sessionFactory = conf.buildSessionFactory(serviceRegistry);*/
    }

    @Override
    public void Insert(Object obj,Class clone) {
        Session session = getSession(clone);
        session.save(obj);
        session.beginTransaction().commit();
        session.close();
    }

    @Override
    public void Delete(Object obj,Class clone) {
        Session session = getSession(clone);
        session.delete(obj);
        session.beginTransaction().commit();
        session.close();
    }

    @Override
    public void Update(Object obj,Class clone) {
        Session session = getSession(clone);
        session.update(obj);
        session.beginTransaction().commit();
        session.close();
    }

}
