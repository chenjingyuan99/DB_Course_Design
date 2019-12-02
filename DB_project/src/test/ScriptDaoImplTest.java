package test;

import dao.ScriptDao;
import dao.ScriptDaoImpl;
import entity.Script;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ScriptDaoImplTest extends Script {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        System.out.println("增加label值信息");
        int i=1;
        int j=2;
        ScriptDao dao = new ScriptDaoImpl();
        Script a1=dao.findByID(i);
        Script a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Script scp = new Script();
            scp.setRelationId(i);
            scp.setMovieId(1);
            scp.setScriptwriterId(1);
            dao.Insert(scp);
            scp.setRelationId(j);
            scp.setMovieId(2);
            scp.setScriptwriterId(2);
            dao.Insert(scp);
            //验证是否增加属性值信息成功
            Script a = dao.findByID(i);
            Script b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加属性值ID为 "+i+" 和 "+j+" 的信息成功!");
            }
        }
    }

    @Test
    public void Delete() {
        System.out.println("删除一行指定属性值ID信息");
        int i=1;
        ScriptDao dao = new ScriptDaoImpl();
        Script scp= dao.findByID(i);
        if(scp!=null) {
            try {
                dao.Delete(scp);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Script a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除属性值ID为 "+i+" 的信息成功!");
        }
    }

    @Test
    public void update() {
        System.out.println("更新一行信息某列元素");
        int i=2;
        ScriptDao dao = new ScriptDaoImpl();
        Script scp=dao.findByID(i);
        //判断该属性值ID是否存在
        if(scp==null) {
            System.out.println("Find Error!");
        }
        else {
            scp.setScriptwriterId(9);
            dao.Update(scp);
            //验证是否更新属性值信息成功
            Script a = dao.findByID(i);
            if(a.getScriptwriterId()==9) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        ScriptDao dao = new ScriptDaoImpl();
        int i=1;
        Script a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getRelationId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        ScriptDao scd = new ScriptDaoImpl();
        List<Script> sc = scd.findAll();
        for(int i = 0; i < sc.size(); i++) {
            Script a = sc.get(i);
            System.out.println(a.getMovieId()+" "+a.getScriptwriterId());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByWritterID() {
        System.out.println("通过查找writerID输出所有属性值信息");
        ScriptDao dao = new ScriptDaoImpl();
        int i=1;
        List<Script> scp = dao.findByWritterID(i);
        for(int j = 0; j < scp.size(); j++) {
            Script a = scp.get(j);
            System.out.println(a.getMovieId()+" "+a.getScriptwriterId());}
        System.out.println("查找属性ID为"+i+" 的所有属性值信息成功!");
    }

    @Test
    public void findByMovieID() {
        System.out.println("通过查找movieID输出所有属性值信息");
        ScriptDao dao = new ScriptDaoImpl();
        int i=1;
        List<Script> scp = dao.findByMovieID(i);
        for(int j = 0; j < scp.size(); j++) {
            Script a = scp.get(j);
            System.out.println(a.getMovieId()+" "+a.getScriptwriterId());}
        System.out.println("查找属性ID为"+i+" 的所有属性值信息成功!");
    }
}