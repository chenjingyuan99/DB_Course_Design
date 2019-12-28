package dao;

import java.util.List;

import entity.Comment;
import org.hibernate.Query;
import org.hibernate.Session;

public class CommentDaoImpl extends BaseDaoImpl implements CommentDao {
    Class clone=Comment.class;
    @Override
    public Comment findByID(int relation_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Comment a where a.relationId="+relation_id);
        //query.setInteger(0,relation_id);
        List list = query.list();
        session.beginTransaction().commit();
        session.close();
        return list.size() > 0 ? (Comment) list.get(0) : null;
    }

    @Override
    public List<Comment> findAll() {

        Session session = getSession(clone);
        Query query = session.createQuery("from Comment ");
        List list = (List<Comment>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Comment> findByMovieId(int mov_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Comment a where a.movId="+mov_id);
        //query.setInteger(0, mov_id);
        List list = (List<Comment>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Comment> findByUsrId(int usr_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Comment a where a.usrId="+usr_id);
        //query.setInteger(0, usr_id);
        List list = (List<Comment>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Comment> findByComId(int com_id) {

        Session session = getSession(clone);
        Query query = session.createQuery("from Comment a where a.comId="+com_id);
        //query.setInteger(0, com_id);
        List list = (List<Comment>) query.list();
        session.beginTransaction().commit();
        session.close();
        return list;
    }
}