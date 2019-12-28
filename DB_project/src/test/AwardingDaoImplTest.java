package test;

import dao.AwardingDao;
import dao.AwardingDaoImpl;
import entity.Awarding;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AwardingDaoImplTest extends Awarding {
    Class clone= Awarding.class;
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
        System.out.println("增加奖项信息");

        System.out.println("增加奖项信息");

        int i=1;
        int j=2;
        AwardingDao dao = new AwardingDaoImpl();
        Awarding a1=dao.findByID(i);
        Awarding a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该奖项ID!");
        }
        else {
            Awarding awarding = new Awarding();
            awarding.setActivities("电影节");
            awarding.setAwardsId(i);
            awarding.setAwardObject("unknown");
            awarding.setAwardsName("金鹰奖");
            awarding.setMovieId(1);
            dao.Insert(awarding,clone);
            awarding.setActivities("国际电影节");
            awarding.setAwardsId(j);
            awarding.setAwardObject("unknown");
            awarding.setAwardsName("金象奖");
            awarding.setMovieId(3);
            dao.Insert(awarding,clone);
            //验证是否增加奖项信息成功
            Awarding a = dao.findByID(i);
            Awarding b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加奖项ID为 "+i+" 和 "+j+" 的奖项信息成功!");}
        }
    }

    @Test
    public void Delete() {
        System.out.println("删除一行指定奖项ID信息");
        int i=2;
        AwardingDao dao=new AwardingDaoImpl();
        Awarding awarding= dao.findByID(i);
        if(awarding!=null) {
            try {
                dao.Delete(awarding,clone);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除奖项信息成功
        Awarding a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除奖项ID为 "+i+" 的奖项信息成功!");
        }
    }

    @Test
    public void Update() {
        System.out.println("更新一行信息某列元素");
        int i=1;
        AwardingDao dao=new AwardingDaoImpl();
        Awarding awarding=dao.findByID(i);
        //判断该奖项ID是否存在
        if(awarding==null) {
            System.out.println("Find Error!");
        }
        else {
            awarding.setAwardsName("change");
            dao.Update(awarding,clone);
            //验证是否更新奖项信息成功
            Awarding a = dao.findByID(i);
            if(!a.getAwardsName().equals("change")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新奖项ID为"+i+" 的奖项信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过奖项ID输出一行信息");
        AwardingDao dao = new AwardingDaoImpl();
        int i=1;
        Awarding a = dao.findByID(i);
        //测试是否找到该奖项ID
        if(a == null) {
            System.out.println("没有奖项ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找奖项ID为"+a.getAwardsId()+" 的一行信息成功!");}
    }


    @Test
    public void findAll() {
        System.out.println("列出所有奖项信息");
        AwardingDao dao = new AwardingDaoImpl();
        List<Awarding> awardings = dao.findAll();
        for(int i = 0; i < awardings.size(); i++) {
            Awarding a = awardings.get(i);
            System.out.println(a.getActivities()+" "+a.getMovieId()+" "+a.getAwardObject()+" "+a.getAwardsName()+" ");
        }
        System.out.println("列出所有奖项信息成功!");
    }

    @Test
    public void findByName() {
        System.out.println("通过查找奖项名称输出所有信息");
        AwardingDao dao = new AwardingDaoImpl();
        String i="金鹰奖";
        List<Awarding> awarding = dao.findByName(i);
        for(int j = 0; j < awarding.size(); j++) {
            Awarding a = awarding.get(j);
            System.out.println(a.getActivities()+" "+a.getMovieId()+" "+a.getAwardObject()+" "+a.getAwardsName()+" ");
        }
        System.out.println("查找奖项名称为"+i+" 的所有信息成功!");
    }
}