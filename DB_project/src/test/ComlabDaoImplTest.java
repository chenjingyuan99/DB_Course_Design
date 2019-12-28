package test;

import dao.ComlabDao;
import dao.ComlabDaoImpl;
import entity.ComLab;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComlabDaoImplTest extends ComLab {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        System.out.println("增加label信息");
        int i=1;
        int j=2;
        ComlabDao dao = new ComlabDaoImpl();
        ComLab l1=dao.findByLabID(i);
        ComLab l2=dao.findByLabID(j);
        if(l1!=null||l2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            ComLab lab = new ComLab();
            lab.setLabId(i);
            lab.setComId(i);
            //lab.setComId(1);
            Class clana = ComLab.class;
            dao.Insert(lab, clana);
            lab.setLabId(j);
            lab.setComId(j);
            //lab.setComId(2);
            dao.Insert(lab, clana);
            //验证是否增加属性值信息成功
            ComLab a = dao.findByLabID(i);
            ComLab b = dao.findByLabID(j);
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
    }

    @Test
    public void update() {
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        ComlabDao labd = new ComlabDaoImpl();
        List<ComLab> lab = labd.findAll();
        for(int i = 0; i < lab.size(); i++) {
            ComLab a = lab.get(i);
            System.out.println(a.getLabId()+" "+a.getComId());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByLabID() {
        System.out.println("通过ID输出一行信息");
        ComlabDao dao = new ComlabDaoImpl();
        int i=1;
        ComLab a = dao.findByLabID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getLabId()+" 的一行信息成功!");}
    }

    @Test
    public void testFindByComID() {
        System.out.println("通过查找commentID输出所有属性值信息");
        ComlabDao dao = new ComlabDaoImpl();
        int i=1;
        List<ComLab> attrva = dao.findByComID(i);
        for(int j = 0; j < attrva.size(); j++) {
            ComLab a = attrva.get(j);
            System.out.println(a.getLabId()+" "+a.getComId());
        }
        System.out.println("查找commentID为"+i+" 的所有属性值信息成功!");
    }
}