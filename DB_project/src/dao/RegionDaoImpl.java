package dao;

import entity.Region;
import org.hibernate.Session;

import java.util.List;

public class RegionDaoImpl extends BaseDaoImpl implements RegionDao {
    @Override
    public Region findByID(int regId) {
        Session session = getSession(entity.Region.class);
        String hql = "from entity.Region rg where rg.regionId=" + regId;
        List<Region> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Region> findAll() {
        Session session = getSession(entity.Region.class);
        List<Region> list = session.createQuery("from entity.Region").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Region findByRegName(String regNa) {
        Session session = getSession(entity.Region.class);
        String hql = "from entity.Region rg where rg.regionName='" + regNa + "'";
        List<Region> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }
}
