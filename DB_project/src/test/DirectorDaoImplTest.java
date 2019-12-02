package test;

import dao.DirectorDao;
import dao.DirectorDaoImpl;
import entity.Director;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DirectorDaoImplTest extends Director {

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
        System.out.println("增加导演信息");

        System.out.println("增加导演信息");

        int i=6;
        int j=7;
        DirectorDao dao = new DirectorDaoImpl();
        Director a1=dao.findByID(i);
        Director a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该导演ID!");
        }
        else {
            Director director = new Director();
            director.setDirectorName("jk");
            director.setDirectorId(i);
            dao.save(director);
            director.setDirectorName("jin");
            director.setDirectorId(j);
            dao.save(director);
            //验证是否增加导演信息成功
            Director a = dao.findByID(i);
            Director b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加导演ID为 "+i+" 和 "+j+" 的导演信息成功!");}
        }

    }

    @Test
    public void delete() {
        System.out.println("删除一行指定导演ID信息");
        int i=2;
        DirectorDao dao=new DirectorDaoImpl();
        Director director= dao.findByID(i);
        if(director!=null) {
            try {
                dao.delete(director);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除导演信息成功
        Director a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除导演ID为 " + i + " 的导演信息成功!");
        }
    }

    @Test
    public void update() {
        System.out.println("更新一行信息某列元素");
        int i=2;
        DirectorDao dao=new DirectorDaoImpl();
        Director director=dao.findByID(i);
        //判断该导演ID是否存在
        if(director==null) {
            System.out.println("Find Error!");
        }
        else {
            director.setDirectorName("change");
            dao.update(director);
            //验证是否更新导演信息成功
            Director a = dao.findByID(i);
            if(!a.getDirectorName().equals("change")) {
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新导演ID为"+i+" 的导演信息成功!");
            }
        }

    }

    @Test
    public void findByID() {
        System.out.println("通过导演ID输出一行信息");
        DirectorDao dao = new DirectorDaoImpl();
        int i=2;
        Director a = dao.findByID(i);
        //测试是否找到该地址ID
        if(a == null) {
            System.out.println("没有导演ID为 "+i+" 的导演信息");
        }
        else {
            System.out.println("查找地址ID为"+a.getDirectorId()+" 的一行地址信息成功!");
        }

    }

    @Test
    public void findAll() {
        System.out.println("列出所有导演信息");
        DirectorDao dao = new DirectorDaoImpl();
        List<Director> directors = dao.findAll();
        for(int i = 0; i < directors.size(); i++) {
            Director a = directors.get(i);
            System.out.println(a.getDirectorId()+" "+a.getDirectorName()+" ");
        }
        System.out.println("列出所有.导演信息成功!");
    }

    @Test
    public void findByName() {
        System.out.println("通过查找导演ID输出所有导演信息");
        DirectorDao dao = new DirectorDaoImpl();
        String i="unknown";
        List<Director> directors = dao.findByName(i);
        for(int j = 0; j < directors.size(); j++) {
            Director a = directors.get(j);
            System.out.println(a.getDirectorId()+" "+a.getDirectorName()+" ");
        }
        System.out.println("查找导演ID为"+i+" 的所有导演信息成功!");
    }
}