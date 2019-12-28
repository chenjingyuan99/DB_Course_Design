package dao;

import java.util.List;

import entity.Location;
import org.hibernate.Query;
import org.hibernate.Session;

public class LocationDaoImpl extends BaseDaoImpl implements LocationDao {

    @Override
    public Location findByID(int Id) {
        Class clana = entity.Location.class;
        Session session = getSession(clana);
        String hql = "from entity.Location loc where loc.relationId=" + Id;
        List<Location> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();
        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Location> findAll() {
        Class clana = entity.Location.class;
        Session session = getSession(clana);
        Query query = session.createQuery("from entity.Location");
        List list = (List<Location>)session.createQuery("from entity.Label").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Location> findByRegID(int regId) {
        Class clana = entity.Location.class;
        Session session = getSession(clana);
        String hql = "from entity.Location loc where loc.regionId=" + regId;
        List<Location> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public List<Location> findByMovieID(int movId) {
        Class clana = entity.Location.class;
        Session session = getSession(clana);
        String hql = "from entity.Location loc where loc.movieId=" + movId;
        List<Location> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
