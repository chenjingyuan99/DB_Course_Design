package dao;

import java.security.acl.LastOwnerException;
import java.util.List;

import entity.Location;
import org.hibernate.Query;
import org.hibernate.Session;

public class LocationDaoImpl extends BaseDaoImpl implements LocationDao {

    @Override
    public Location findByID(int Id) {
        Session session = getSession();
        Query query = session.createQuery("from Location loc where loc.relationId=?");
        query.setInteger(0, Id);
        List<Location> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Location> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Location");
        List list = (List<Location>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Location> findByRegID(int regId) {
        Session session = getSession();
        Query query = session.createQuery("from Location la where la.regionId=?");
        query.setInteger(0, regId);
        List<Location> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public List<Location> findByMovieID(int movId) {
        Session session = getSession();
        Query query = session.createQuery("from Location la where la.movieId=?");
        query.setInteger(0, movId);
        List<Location> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
