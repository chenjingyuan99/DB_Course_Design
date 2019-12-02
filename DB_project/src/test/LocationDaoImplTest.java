package test;

import dao.LocationDao;
import dao.LocationDaoImpl;
import entity.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LocationDaoImplTest extends Location {

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
        LocationDao dao = new LocationDaoImpl();
        Location a1=dao.findByID(i);
        Location a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Location loc = new Location();
            loc.setRelationId(i);
            loc.setRegionId(1);
            loc.setMovieId(1);
            dao.Insert(loc);
            loc.setRelationId(j);
            loc.setRegionId(1);
            loc.setMovieId(1);
            dao.Insert(loc);
            //验证是否增加属性值信息成功
            Location a = dao.findByID(i);
            Location b = dao.findByID(j);
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
        LocationDao dao = new LocationDaoImpl();
        Location loc= dao.findByID(i);
        if(loc!=null) {
            try {
                dao.Delete(loc);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Location a = dao.findByID(i);
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
        LocationDao dao = new LocationDaoImpl();
        Location loc=dao.findByID(i);
        //判断该属性值ID是否存在
        if(loc==null) {
            System.out.println("Find Error!");
        }
        else {
            loc.setRegionId(0);
            dao.Update(loc);
            //验证是否更新属性值信息成功
            Location a = dao.findByID(i);
            if(a.getRegionId()!=0) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        LocationDao dao = new LocationDaoImpl();
        int i=1;
        Location a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getRelationId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        LocationDao locd = new LocationDaoImpl();
        List<Location> loc = locd.findAll();
        for(int i = 0; i < loc.size(); i++) {
            Location a = loc.get(i);
            System.out.println(a.getRegionId()+" "+a.getMovieId());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByRegID() {
        System.out.println("通过查找regionID输出所有属性值信息");
        LocationDao dao = new LocationDaoImpl();
        int i=1;
        List<Location> loca = dao.findByRegID(i);
        for(int j = 0; j < loca.size(); j++) {
            Location a = loca.get(j);
            System.out.println(a.getRegionId()+" "+a.getMovieId());}
        System.out.println("查找regionID为"+i+" 的所有属性值信息成功!");
    }

    @Test
    public void findByMovieID() {
        System.out.println("通过查找movieID输出所有属性值信息");
        LocationDao dao = new LocationDaoImpl();
        int i=1;
        List<Location> loca = dao.findByMovieID(i);
        for(int j = 0; j < loca.size(); j++) {
            Location a = loca.get(j);
            System.out.println(a.getRegionId()+" "+a.getMovieId());}
        System.out.println("查找movieID为"+i+" 的所有属性值信息成功!");
    }
}