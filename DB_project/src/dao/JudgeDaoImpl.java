package dao;

import entity.Judge;
import org.hibernate.Session;

import java.util.List;

public class JudgeDaoImpl extends BaseDaoImpl implements JudgeDao {
    @Override
    public Judge findByID(int Id) {
        Class clana = Judge.class;
        Session session = getSession(clana);
        String hql = "from entity.Judge ju where ju.judgeId = " + Id;
        List<Judge> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list.size()>0?list.get(0):null;
    }

    @Override
    public List<Judge> findAll() {
        Class clana = Judge.class;
        Session session = getSession(clana);
        List<Judge> list = session.createQuery("from entity.Judge").list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Judge> findByUsrID(int usrId) {
        Class clana = Judge.class;
        Session session = getSession(clana);
        String hql = "from entity.Judge ju where ju.usrId = " + usrId;
        List<Judge> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }

    @Override
    public List<Judge> findByComID(int comId) {
        Class clana = Judge.class;
        Session session = getSession(clana);
        String hql = "from entity.Judge ju where ju.comId = " + comId;
        List<Judge> list = session.createQuery(hql).list();
        session.beginTransaction().commit();
        session.close();

        return list;
    }
}
