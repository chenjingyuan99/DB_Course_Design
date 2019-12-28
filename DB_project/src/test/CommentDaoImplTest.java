package test;

import dao.CommentDao;
import dao.CommentDaoImpl;
import entity.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommentDaoImplTest extends Comment {
    Class clone=Comment.class;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSession() {
    }

    @Test
    public void Insert() {
        System.out.println("增加评论信息");

        System.out.println("增加评论信息");

        int i=1;
        int j=2;
        CommentDao dao = new CommentDaoImpl();
        Comment a1=dao.findByID(i);
        Comment a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该评论关系ID!");
        }
        else {
            Comment comment = new Comment();
            comment.setComId(1);
            comment.setRelationId(i);
            comment.setComStar((byte)1);
            comment.setComSeen((byte)1);
            comment.setComContent("none");
            comment.setComTime("1995-09-10");
            comment.setMovId(3);
            comment.setUsrId(3);
            dao.Insert(comment,clone);
            comment.setComId(2);
            comment.setRelationId(j);
            comment.setComStar((byte)0);
            comment.setComSeen((byte)0);
            comment.setComContent("none_1");
            comment.setComTime("1999-10-10");
            comment.setMovId(2);
            comment.setUsrId(2);
            dao.Insert(comment,clone);
            //验证是否增加评价信息成功
            Comment a = dao.findByID(i);
            Comment b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加评论关系ID为 "+i+" 和 "+j+" 的信息成功!");
            }
        }
    }

    @Test
    public void Delete() {
        System.out.println("删除一行指定评论关系ID信息");
        int i=2;
        CommentDao dao=new CommentDaoImpl();
        Comment comment= dao.findByID(i);
        if(comment!=null) {
            try {
                dao.Delete(comment,clone);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除评论信息成功
        Comment a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除评论关系ID为 "+i+" 的信息成功!");
        }
    }

    @Test
    public void Update() {
        System.out.println("更新一行信息某列元素");
        int i=1;
        CommentDao dao=new CommentDaoImpl();
        Comment comment=dao.findByID(i);
        //判断该评论ID是否存在
        if(comment==null) {
            System.out.println("Find Error!");
        }
        else {
            comment.setComSeen((byte)1);
            dao.Update(comment,clone);
            //验证是否更新评论信息成功
            Comment a = dao.findByID(i);
            if(a.getComSeen()!=1) {
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新评论关系ID为"+i+" 的信息成功!");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过评论关系ID输出一行信息");
        CommentDao dao = new CommentDaoImpl();
        int i=1;
        Comment a = dao.findByID(i);
        //测试是否找到该评论关系ID
        if(a == null) {
            System.out.println("没有评论关系ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找评论关系ID为"+a.getRelationId()+" 的一行信息成功!");
        }
    }

    @Test
    public void findAll() {
        System.out.println("列出所有评论信息");
        CommentDao dao = new CommentDaoImpl();
        List<Comment> comment = dao.findAll();
        for(int i = 0; i < comment.size(); i++) {
            Comment a = comment.get(i);
            System.out.println(a.getRelationId()+" "+a.getComContent()+" "+a.getComId()+" "+a.getComSeen()+" "+a.getComStar()+" "+a.getComTime()+" "+a.getMovId()+" "+a.getUsrId()+" ");
        }
        System.out.println("列出所有评论信息成功!");
    }

    @Test
    public void findByMovieId() {
        System.out.println("通过查找电影ID输出所有评论信息");
        CommentDao dao = new CommentDaoImpl();
        int i=1;
        List<Comment> comment = dao.findByMovieId(i);
        for(int j = 0; j < comment.size(); j++) {
            Comment a = comment.get(j);
            System.out.println(a.getRelationId()+" "+a.getComContent()+" "+a.getComId()+" "+a.getComSeen()+" "+a.getComStar()+" "+a.getComTime()+" "+a.getMovId()+" "+a.getUsrId()+" ");
        }
        System.out.println("查找电影ID为"+i+" 的所有评论信息成功!");
    }

    @Test
    public void findByUsrId() {
        System.out.println("通过查找用户ID输出所有评论信息");
        CommentDao dao = new CommentDaoImpl();
        int i=1;
        List<Comment> comment = dao.findByUsrId(i);
        for(int j = 0; j < comment.size(); j++) {
            Comment a = comment.get(j);
            System.out.println(a.getRelationId()+" "+a.getComContent()+" "+
                    a.getComId()+" "+a.getComSeen()+" "+a.getComStar()+" "+
                    a.getComTime()+" "+a.getMovId()+" "+a.getUsrId()+" ");
        }
        System.out.println("查找用户ID为"+i+" 的所有评论信息成功!");
    }

    @Test
    public void findByComId() {
        System.out.println("通过查找评论ID输出所有评论信息");
        CommentDao dao = new CommentDaoImpl();
        int i=1;
        List<Comment> comment = dao.findByComId(i);
        for(int j = 0; j < comment.size(); j++) {
            Comment a = comment.get(j);
            System.out.println(a.getRelationId()+" "+a.getRelationId()+" "+a.getComContent()+" "+a.getComId()+" "+a.getComSeen()+" "+a.getComStar()+" "+a.getComTime()+" "+a.getMovId()+" "+a.getUsrId()+" ");
        }
        System.out.println("查找评论ID为"+i+" 的所有评论信息成功!");
    }
}