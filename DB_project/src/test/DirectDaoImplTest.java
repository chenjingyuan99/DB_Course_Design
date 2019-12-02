package test;

import dao.DirectDao;
import dao.DirectDaoImpl;
import entity.Direct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DirectDaoImplTest extends Direct {

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
        DirectDao dao = new DirectDaoImpl();
        Direct a1=dao.findByID(i);
        Direct a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该导演关系ID!");
        }
        else {
            Direct direct = new Direct();
            direct.setDirectorId(1);
            direct.setRelationId(i);
            direct.setMovieId(4);
            dao.save(direct);
            direct.setDirectorId(2);
            direct.setRelationId(j);
            direct.setMovieId(5);
            dao.save(direct);
            //验证是否增加导演信息成功
            Direct a = dao.findByID(i);
            Direct b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加导演关系ID为 "+i+" 和 "+j+" 的导演信息成功!");}
        }
    }

    @Test
    public void delete() {
        System.out.println("删除一行指定导演关系ID的信息");
        int i=2;
        DirectDao dao=new DirectDaoImpl();
        Direct direct= dao.findByID(i);
        if(direct!=null) {
            try {
                dao.delete(direct);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除导演信息成功
        Direct a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除导演关系ID为 "+i+" 的信息成功!");
        }

    }

    @Test
    public void update() {
        System.out.println("更新一行信息某列元素");
        int i=2;
        DirectDao dao=new DirectDaoImpl();
        Direct direct=dao.findByID(i);
        //判断该导演关系ID是否存在
        if(direct==null) {
            System.out.println("Find Error!");
        }
        else {
            direct.setMovieId(1);
            dao.update(direct);
            //验证是否更新导演信息成功
            Direct a = dao.findByID(i);
            if(a.getMovieId()!=1) {
                System.out.println("Update Error!");
            }
            else {
                System.out.println("更新导演关系ID为" + i + " 的信息成功!");
            }
        }
    }


    @Test
    public void findByID() {
        System.out.println("通过导演关系ID输出一行信息");
        DirectDao dao = new DirectDaoImpl();
        int i=1;
        Direct a = dao.findByID(i);
        //测试是否找到该导演关系ID
        if(a == null) {
            System.out.println("没有导演关系ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找导演关系ID为"+a.getRelationId()+" 的一行信息成功!");}
    }


    @Test
    public void findAll() {
        System.out.println("列出所有导演信息");
        DirectDao dao = new DirectDaoImpl();
        List<Direct> direct = dao.findAll();
        for(int i = 0; i < direct.size(); i++) {
            Direct a = direct.get(i);
            System.out.println(a.getMovieId()+" "+a.getDirectorId()+" "+a.getRelationId()+" ");
        }
        System.out.println("列出所有导演信息成功!");
    }

    @Test
    public void findByMovieId() {
        System.out.println("通过查找电影ID输出所有导演信息");
        DirectDao dao = new DirectDaoImpl();
        int i=1;
        List<Direct> direct = dao.findByMovieId(i);
        for(int j = 0; j < direct.size(); j++) {
            Direct a = direct.get(j);
            System.out.println(a.getMovieId()+" "+a.getDirectorId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找电影ID为"+i+" 的所有导演信息成功!");
    }

    @Test
    public void findByDirectorId() {
        System.out.println("通过查找导演ID输出所有导演信息");
        DirectDao dao = new DirectDaoImpl();
        int i = 1;
        List<Direct> direct = dao.findByDirectorId(i);
        for (int j = 0; j < direct.size(); j++) {
            Direct a = direct.get(j);
            System.out.println(a.getMovieId() + " " + a.getDirectorId() + " " + a.getRelationId() + " ");
        }
        System.out.println("查找导演ID为" + i + " 的所有导演信息成功!");
    }
}