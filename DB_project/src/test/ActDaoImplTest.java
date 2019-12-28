package test;

import dao.ActDao;
import dao.ActDaoImpl;
import entity.Act;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ActDaoImplTest extends Act {
    Class clone=Act.class;
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
        System.out.println("增加参演信息");
        System.out.println("增加参演信息");
        int i=1;
        int j=2;
        ActDao dao=new ActDaoImpl();
        Act a1=dao.findByID(i);
        Act a2=dao.findByID(j);
        if(a1!=null||a2!=null){
            System.out.println("已经存在该参演关系ID！");
        }
        else{
            Act act=new Act();
            System.out.println("增加参演信息");
            act.setRelationId(i);
            act.setMovieId(4);
            act.setActorId(1);
            act.setRoleName("jungkook");
            dao.Insert(act,clone);
            act.setMovieId(5);
            act.setActorId(5);
            act.setRelationId(j);
            act.setRoleName("jin");
            dao.Insert(act,clone);
            Act a=dao.findByID(i);
            Act b=dao.findByID(j);
            if(a==null||b==null)
            {
                System.out.println("Save Error!");
            }
            else
            {
                System.out.println("增加参演关系ID为"+i+"和"+j+"的参演信息成功");
            }
        }
    }

    @Test
    public void Delete() {
        System.out.println("删除一行指定参演关系ID的参演信息");
        int i=2;
        ActDao dao=new ActDaoImpl();
        Act act=dao.findByID(i);
        if(act!=null)
        {
            try{
                dao.Delete(act,clone);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除演员信息成功
        Act a=dao.findByID(i);
        if(a!=null)
        {
            System.out.println("Delete Error!");
        }
        else
        {
            System.out.println("删除参演关系ID为"+i+"的参演信息成功");
        }
    }

    @Test
    public void Update() {
        System.out.println("更新一个记录中的某个元素");
        int i=1;
        ActDao dao=new ActDaoImpl();
        Act act=dao.findByID(i);
        //先判断这个记录存不存在
        if(act==null)
        {
            System.out.println("Find Error!");
        }
        else{
            act.setRoleName("jimin");
            dao.Update(act,clone);
            //验证是否更新成功
            Act a=dao.findByID(i);
            if(!a.getRoleName().equals("jimin")){
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新参演关系ID为"+i+"的参演信息成功");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过参演关系ID输出一行信息");
        ActDao  dao=new ActDaoImpl();
        int i=1;
        Act a=dao.findByID(i);
        if(a==null) {
            System.out.println("没有参演关系ID 为"+i+"的参演信息");
        }
        else {
            System.out.println("查找参演关系ID为"+a.getRelationId()+"的一行参演信息成功");
        }

    }

    @Test
    public void findAll() {
        System.out.println("列出所有参演信息");
        ActDao dao=new ActDaoImpl();
        List<Act> act=dao.findAll();
        for(int i=0;i<act.size();i++){
            Act a=act.get(i);
            System.out.println(a.getRelationId()+" "+a.getActorId()+" "+a.getMovieId()+" "+
                    a.getRoleName()+" ");
        }
        System.out.println("列出所有参演信息成功!");
    }

    @Test
    public void findByMovieId() {
        System.out.println("通过查找电影ID输出所有参演信息");
        ActDao dao = new ActDaoImpl();
        int i = 1;
        List<Act> act = dao.findByMovieId(i);
        for (int j = 0; j < act.size(); j++) {
            Act a = act.get(j);
            System.out.println(a.getActorId() + " " + a.getRelationId()+" "+a.getMovieId() + " " + a.getRoleName() + " ");
        }
        System.out.println("查找电影ID为" + i + "的所有参演信息成功");
    }

    @Test
    public void findByActorId() {
        System.out.println("通过查找演员ID输出所有参演信息");
        ActDao dao = new ActDaoImpl();
        int i = 1;
        List<Act> act = dao.findByActorId(i);
        for (int j = 0; j < act.size(); j++) {
            Act a = act.get(j);
            System.out.println(a.getActorId() + " "+a.getRelationId()+" " + a.getMovieId() + " " + a.getRoleName() + " ");
        }
        System.out.println("查找演员ID为" + i + "的所有参演信息成功");
    }


    @Test
    public void findByName() {
        System.out.println("通过查找角色名称输出所有参演信息");
        ActDao dao =new ActDaoImpl();
        String role_name="jimin";
        List<Act> act=dao.findByName(role_name);
        for(int i=0;i<act.size();i++) {
            Act a=act.get(i);
            System.out.println(a.getRelationId()+" "+a.getActorId()+" "+a.getMovieId()+" "+a.getRoleName()+" ");
        }
        System.out.println("查找角色名称为"+role_name+"的所有参演信息成功");
    }
}