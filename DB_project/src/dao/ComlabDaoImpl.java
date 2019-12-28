package dao;

import entity.ComLab;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.List;

public class ComlabDaoImpl extends BaseDaoImpl implements ComlabDao {

    @Override
    public List<ComLab> findAll() {
        Class clana = ComLab.class;
        Session session = getSession(clana);
        List<ComLab> list = session.createQuery("from entity.ComLab").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public ComLab findByLabID(int labId) {
        Class clana = ComLab.class;
        Session session = getSession(clana);
        String hql = "from entity.ComLab la where la.labId = " + labId;
        List<ComLab> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<ComLab> findByComID(int comId) {
        Class clana = ComLab.class;
        Session session = getSession(clana);
        String hql = "from entity.ComLab com where com.comId = " + comId;
        List<ComLab> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}

