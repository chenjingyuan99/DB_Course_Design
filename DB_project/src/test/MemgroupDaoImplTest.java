package test;

import dao.MemgroupDao;
import dao.MemgroupDaoImpl;
import entity.Memgroup;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MemgroupDaoImplTest extends Memgroup {

    @Test
    public void insert() {
        System.out.println("增加label值信息");
        int i=1;
        int j=2;
        MemgroupDao dao = new MemgroupDaoImpl();
        Memgroup a1=dao.findByID(i);
        Memgroup a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Memgroup mem = new Memgroup();
            mem.setGroupId(i);
            mem.setMovieId(i);
            mem.setGroupName("涤尘");
            dao.Insert(mem, Memgroup.class);
            mem.setGroupId(j);
            mem.setGroupName("aaa");
            mem.setMovieId(j);
            dao.Insert(mem, Memgroup.class);
            //验证是否增加属性值信息成功
            Memgroup a = dao.findByID(i);
            Memgroup b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加属性值ID为 "+i+" 和 "+j+" 的信息成功!");
            }
        }
    }

    @Test
    public void delete() {
        System.out.println("删除一行指定属性值ID信息");
        int i=1;
        MemgroupDao dao = new MemgroupDaoImpl();
        Memgroup mem= dao.findByID(i);
        if(mem!=null) {
            try {
                Class clana = Memgroup.class;
                dao.Delete(mem, clana);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("找不到该ID相关信息");
            return;
        }
        //验证是否删除属性值信息成功
        Memgroup a = dao.findByID(i);
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
        MemgroupDao dao = new MemgroupDaoImpl();
        Memgroup mem=dao.findByID(i);
        //判断该属性值ID是否存在
        if(mem==null) {
            System.out.println("Find Error!");
        }
        else {
            mem.setGroupName("WoW");
            Class clana = Memgroup.class;
            dao.Update(mem, clana);
            //验证是否更新属性值信息成功
            Memgroup a = dao.findByID(i);
            if(!a.getGroupName().equals("WoW")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }

    }

    @Test
    public void findByMovID() {
        System.out.println("通过ID输出一行信息");
        MemgroupDao dao = new MemgroupDaoImpl();
        int i=1;
        Memgroup a = dao.findByMovID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getMovieId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        MemgroupDao labd = new MemgroupDaoImpl();
        List<Memgroup> lab = labd.findAll();
        for(int i = 0; i < lab.size(); i++) {
            Memgroup a = lab.get(i);
            System.out.println(a.getGroupId()+" "+a.getGroupName()+" "+a.getMovieId());
        }
        System.out.println("列出所有信息成功!");
    }
}