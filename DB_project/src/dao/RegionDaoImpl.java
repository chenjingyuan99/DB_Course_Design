package dao;

import entity.Region;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class RegionDaoImpl extends BaseDaoImpl implements RegionDao {
    @Override
    public Region findByID(int regId) {
        Session session = getSession();
        Query query = session.createQuery("from Region rg where rg.regionId=?");
        query.setInteger(0, regId);
        List<Region> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Region> findAll() {
        Session session = getSession();
        Query query = session.createQuery("from Region");
        List list = (List<Region>)query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Region findByRegName(String regNa) {
        Session session = getSession();
        Query query = session.createQuery("from Region rg where rg.regionName=?");
        query.setString(0, regNa);
        List<Region> list = query.list();

        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
