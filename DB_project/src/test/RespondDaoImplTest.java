package test;

import dao.RespondDao;
import dao.RespondDaoImpl;
import entity.Responding;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class RespondDaoImplTest extends Responding {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        System.out.println("增加respond信息");
        int i=1;
        int j=2;
        RespondDao dao = new RespondDaoImpl();
        Responding a1=dao.findByID(i);
        Responding a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Responding res = new Responding();
            res.setRespondId(i);
            res.setDiscussId(1);
            res.setPromulgator("LuckyMe");
            Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int date = c.get(Calendar.DATE);
            String str = year + "-" + month + "-" + date;
            res.setReleaseTime(str);
            res.setRespondContent("Agree!");
            dao.Insert(res, Responding.class);
            res.setRespondId(j);
            res.setDiscussId(1);
            res.setPromulgator("LuckyYou");
            res.setReleaseTime(str);
            res.setRespondContent("Yeah!");
            dao.Insert(res, Responding.class);
            //验证是否增加属性值信息成功
            Responding a = dao.findByID(i);
            Responding b = dao.findByID(j);
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
        RespondDao dao = new RespondDaoImpl();
        Responding res= dao.findByID(i);
        if(res!=null) {
            try {
                dao.Delete(res, Responding.class);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Responding a = dao.findByID(i);
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
        RespondDao dao = new RespondDaoImpl();
        Responding res=dao.findByID(i);
        //判断该属性值ID是否存在
        if(res==null) {
            System.out.println("Find Error!");
        }
        else {
            res.setRespondContent("Disagree!");
            dao.Update(res, Responding.class);
            //验证是否更新属性值信息成功
            Responding a = dao.findByID(i);
            if(!a.getRespondContent().equals("Disagree!")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过查找respondID输出所有属性值信息");
        RespondDao dao = new RespondDaoImpl();
        int i=1;
        Responding a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getRespondId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        RespondDao resd = new RespondDaoImpl();
        List<Responding> res = resd.findAll();
        for(int i = 0; i < res.size(); i++) {
            Responding a = res.get(i);
            System.out.println(a.getRespondId()+" "+a.getDiscussId()+" "+a.getPromulgator()+
                    " "+a.getReleaseTime()+" "+a.getRespondContent());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByDisID() {
        System.out.println("通过查找discussionID输出所有属性值信息");
        RespondDao dao = new RespondDaoImpl();
        int i=1;
        List<Responding> attrva = dao.findByDisID(i);
        for(int j = 0; j < attrva.size(); j++) {
            Responding a = attrva.get(j);
            System.out.println(a.getRespondId()+" "+a.getDiscussId()+" "+a.getPromulgator()+
                    " "+a.getReleaseTime()+" "+a.getRespondContent());}
        System.out.println("查找discussionID为"+i+" 的所有属性值信息成功!");
    }
}