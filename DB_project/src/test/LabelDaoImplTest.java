package test;

import entity.Label;
import dao.LabelDao;
import dao.LabelDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LabelDaoImplTest extends Label {

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
        LabelDao dao = new LabelDaoImpl();
        Label l1=dao.findByID(i);
        Label l2=dao.findByID(j);
        if(l1!=null||l2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Label lab = new Label();
            lab.setLabId(i);
            lab.setLabComment("Gorgeous");
            lab.setComId(1);
            dao.Insert(lab);
            lab.setLabId(j);
            lab.setLabComment("Shit");
            lab.setComId(2);
            dao.Insert(lab);
            //验证是否增加属性值信息成功
            Label a = dao.findByID(i);
            Label b = dao.findByID(j);
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
        LabelDao dao = new LabelDaoImpl();
        Label lab= dao.findByID(i);
        if(lab!=null) {
            try {
                dao.Delete(lab);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Label a = dao.findByID(i);
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
        LabelDao dao = new LabelDaoImpl();
        Label lab=dao.findByID(i);
        //判断该属性值ID是否存在
        if(lab==null) {
            System.out.println("Find Error!");
        }
        else {
            lab.setLabComment("WoW");
            dao.Update(lab);
            //验证是否更新属性值信息成功
            Label a = dao.findByID(i);
            if(!a.getLabComment().equals("WoW")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        LabelDao dao = new LabelDaoImpl();
        int i=1;
        Label a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getLabId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        LabelDao labd = new LabelDaoImpl();
        List<Label> lab = labd.findAll();
        for(int i = 0; i < lab.size(); i++) {
            Label a = lab.get(i);
            System.out.println(a.getLabId()+" "+a.getComId()+" "+a.getLabComment());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByComID() {
        System.out.println("通过查找commentID输出所有属性值信息");
        LabelDao dao = new LabelDaoImpl();
        int i=1;
        List<Label> attrva = dao.findByComID(i);
        for(int j = 0; j < attrva.size(); j++) {
            Label a = attrva.get(j);
            System.out.println(a.getLabId()+" "+a.getComId()+" "+a.getLabComment());}
        System.out.println("查找commentID为"+i+" 的所有属性值信息成功!");
    }
}