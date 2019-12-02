package test;

import dao.DiscussDao;
import dao.DiscussDaoImpl;
import entity.Discuss;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DiscussDaoImplTest extends Discuss {

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
    public void save() {
        System.out.println("增加讨论关系信息");

        System.out.println("增加讨论关系信息");

        int i=6;
        int j=7;
        DiscussDao dao = new DiscussDaoImpl();
        Discuss a1=dao.findByID(i);
        Discuss a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该讨论关系ID!");
        }
        else {
            Discuss discuss = new Discuss();
            discuss.setDiscussId(3);
            discuss.setMovieId(3);
            discuss.setRelationId(i);
            dao.save(discuss);
            discuss.setDiscussId(4);
            discuss.setMovieId(4);
            discuss.setRelationId(j);
            dao.save(discuss);
            //验证是否增加讨论信息成功
            Discuss a = dao.findByID(i);
            Discuss b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加讨论关系ID为 "+i+" 和 "+j+" 的信息成功!");}
        }
    }

    @Test
    public void delete() {
        System.out.println("删除一行指定讨论关系ID信息");
        int i=2;
        DiscussDao dao=new DiscussDaoImpl();
        Discuss discuss = dao.findByID(i);
        if(discuss!=null) {
            try {
                dao.delete(discuss);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除讨论信息成功
        Discuss a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除讨论关系ID为 " + i + " 的讨论信息成功!");
        }
    }

    @Test
    public void update() {
        System.out.println("更新一行信息某列元素");
        int i=2;
        DiscussDao dao=new DiscussDaoImpl();
        Discuss discuss=dao.findByID(i);
        //判断该讨论关系ID是否存在
        if(discuss==null) {
            System.out.println("Find Error!");
        }
        else {
            discuss.setMovieId(1);
            dao.update(discuss);
            //验证是否更新讨论信息成功
            Discuss a = dao.findByID(i);
            if(a.getMovieId()!=1) {
                System.out.println("Update Error!");
            }
            else {
                System.out.println("更新讨论关系ID为" + i + " 的信息成功!");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过讨论关系ID输出一行信息");
        DiscussDao dao = new DiscussDaoImpl();
        int i=1;
        Discuss a = dao.findByID(i);
        //测试是否找到该讨论关系ID
        if(a == null) {
            System.out.println("没有讨论关系ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找讨论关系ID为"+a.getRelationId()+" 的一行信息成功!");
        }
    }

    @Test
    public void findAll() {
        System.out.println("列出所有讨论信息");
        DiscussDao dao = new DiscussDaoImpl();
        List<Discuss> discuss = dao.findAll();
        for(int i = 0; i < discuss.size(); i++) {
            Discuss a = discuss.get(i);
            System.out.println(a.getRelationId()+" "+a.getDiscussId()+" "+a.getMovieId()+" ");
        }
        System.out.println("列出所有讨论信息成功!");
    }

    @Test
    public void findByMovieId() {
        System.out.println("通过查找电影ID输出所有讨论信息");
        DiscussDao dao = new DiscussDaoImpl();
        int i=1;
        List<Discuss> discuss = dao.findByMovieId(i);
        for(int j = 0; j < discuss.size(); j++) {
            Discuss a = discuss.get(j);
            System.out.println(a.getRelationId()+" "+a.getDiscussId()+" "+a.getMovieId()+" ");
        }
        System.out.println("查找电影ID为"+i+" 的所有讨论信息成功!");
    }

    @Test
    public void findByDiscussId() {
        System.out.println("通过查找讨论ID输出所有讨论信息");
        DiscussDao dao = new DiscussDaoImpl();
        int i=1;
        List<Discuss> discuss = dao.findByDiscussId(i);
        for(int j = 0; j < discuss.size(); j++) {
            Discuss a = discuss.get(j);
            System.out.println(a.getRelationId()+" "+a.getDiscussId()+" "+a.getMovieId()+" ");
        }
        System.out.println("查找讨论ID为"+i+" 的所有讨论信息成功!");
    }

}