package test;

import dao.ActorDao;
import dao.ActorDaoImpl;
import entity.Actor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ActorDaoImplTest extends Actor {

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
        System.out.println("增加演员信息");

        System.out.println("增加演员信息");

        int i=6;
        int j=7;
        ActorDao dao = new ActorDaoImpl();
        Actor a1=dao.findByID(i);
        Actor a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该演员ID!");
        }
        else {
            Actor actor = new Actor();
            actor.setActorName("Hope");
            actor.setActorId(i);
            actor.setIsStar((byte) 1);
            dao.save(actor);
            actor.setActorName("Hobi");
            actor.setActorId(j);
            actor.setIsStar((byte)0);
            dao.save(actor);
            //验证是否增加演员信息成功
            Actor a = dao.findByID(i);
            Actor b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加演员ID为 "+i+" 和 "+j+" 的演员信息成功!");}
        }
    }

    @Test
    public void delete() {
        System.out.println("删除一行指定演员ID信息");
        int i=1;
        ActorDao dao=new ActorDaoImpl();
        Actor actor= dao.findByID(i);
        if(actor!=null) {
            try {
                dao.delete(actor);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除演员信息成功
        Actor a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除电影ID为 "+i+" 的演员信息成功!");
        }
    }

    @Test
    public void update() {
        System.out.println("更新一行信息中的某些元素");
        int i=2;
        ActorDao dao=new ActorDaoImpl();
        Actor actor=dao.findByID(i);
        //判断记录是否存在
        if(actor==null)
        {
            System.out.println("Find Error!");
        }
        else
        {
            actor.setActorName("yonggi");
            dao.update(actor);
            //验证是否更新成功
            Actor a=dao.findByID(i);
            if(!a.getActorName().equals("yonggi"))
            {
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新演员ID为"+i+"的演员信息成功");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过演员ID输出一行信息");
        ActorDao dao = new ActorDaoImpl();
        int i=1;
        Actor a = dao.findByID(i);
        //测试是否找到该演员ID
        if(a == null) {
            System.out.println("没有演员ID为 "+i+" 的演员信息");
        }
        else {
            System.out.println("查找演员ID为"+a.getActorId()+" 的一行演员信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有演员信息");
        ActorDao dao = new ActorDaoImpl();
        List<Actor> actors= dao.findAll();
        for(int i = 0; i < actors.size(); i++) {
            Actor a = actors.get(i);
            System.out.println(a.getActorId()+" "+a.getActorName()+" "+a.getIsStar()+" ");
        }
        System.out.println("列出所有演员信息成功!");
    }

    @Test
    public void findByName() {
        System.out.println("通过查找演员名字输出所有信息");
        ActorDao dao = new ActorDaoImpl();
        String i="jungkook";
        List<Actor> actors= dao.findByName(i);
        for(int j = 0; j < actors.size(); j++) {
            Actor a = actors.get(j);
            System.out.println(a.getActorId()+" "+a.getIsStar()+" "+a.getActorName()+" ");
        }
        System.out.println("查找演员名字为"+i+" 的所有演员信息成功!");
    }
}