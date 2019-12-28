package test;

import dao.RegionDao;
import dao.RegionDaoImpl;
import entity.Region;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RegionDaoImplTest extends Region {

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
        RegionDao dao = new RegionDaoImpl();
        Region a1=dao.findByID(i);
        Region a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Region reg = new Region();
            reg.setRegionId(i);
            reg.setRegionName("中国大陆");
            dao.Insert(reg, Region.class);
            reg.setRegionId(j);
            reg.setRegionName("美国");
            dao.Insert(reg, Region.class);
            //验证是否增加属性值信息成功
            Region a = dao.findByID(i);
            Region b = dao.findByID(j);
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
        RegionDao dao = new RegionDaoImpl();
        Region reg= dao.findByID(i);
        if(reg!=null) {
            try {
                dao.Delete(reg, Region.class);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Region a = dao.findByID(i);
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
        RegionDao dao = new RegionDaoImpl();
        Region reg=dao.findByID(i);
        //判断该属性值ID是否存在
        if(reg==null) {
            System.out.println("Find Error!");
        }
        else {
            reg.setRegionName("印度");
            dao.Update(reg, Region.class);
            //验证是否更新属性值信息成功
            Region a = dao.findByID(i);
            if(!a.getRegionName().equals("印度")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        RegionDao dao = new RegionDaoImpl();
        int i=1;
        Region a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getRegionId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        RegionDao regd = new RegionDaoImpl();
        List<Region> reg = regd.findAll();
        for(int i = 0; i < reg.size(); i++) {
            Region a = reg.get(i);
            System.out.println(a.getRegionId()+" "+a.getRegionName()+" ");
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByRegName() {
        System.out.println("通过电影名输出一行信息");
        RegionDao dao = new RegionDaoImpl();
        String str="中国";
        Region a = dao.findByRegName(str);
        if(a == null) {
            System.out.println("没有电影名为 "+str+" 的信息");
        }
        else {
            System.out.println("查找电影名为"+a.getRegionName()+" 的一行信息成功!");}
    }
}