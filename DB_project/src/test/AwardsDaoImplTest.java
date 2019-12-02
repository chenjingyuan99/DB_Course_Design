package test;

import dao.AwardsDao;
import dao.AwardsDaoImpl;
import entity.Awards;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AwardsDaoImplTest extends Awards {

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

        System.out.println("增加获奖信息");

        System.out.println("增加获奖信息");

        int i=6;
        int j=7;
        AwardsDao dao = new AwardsDaoImpl();
        Awards a1=dao.findByID(i);
        Awards a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该奖项ID!");
        }
        else {
            Awards awards = new Awards();
            awards.setMovieId(4);
            awards.setRelationId(i);
            awards.setAwardsId(1);
            dao.save(awards);
            awards.setMovieId(5);
            awards.setRelationId(j);
            awards.setAwardsId(2);
            dao.save(awards);
            //验证是否增加获奖信息成功
            Awards a = dao.findByID(i);
            Awards b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加获奖关系ID为 "+i+" 和 "+j+" 的获奖信息成功!");}
        }
    }

    @Test
    public void delete() {
        System.out.println("删除一行指定获奖关系ID信息");
        int i=2;
        AwardsDao dao=new AwardsDaoImpl();
        Awards awards= dao.findByID(i);
        if(awards!=null) {
            try {
                dao.delete(awards);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除获奖信息成功
        Awards a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除获奖关系ID为 "+i+" 的信息成功!");
        }
    }

    @Test
    public void update() {
        System.out.println("更新一行信息某列元素");
        int i=1;
        AwardsDao dao=new AwardsDaoImpl();
        Awards awards=dao.findByID(i);
        //判断该获奖关系ID是否存在
        if(awards==null) {
            System.out.println("Find Error!");
        }
        else {
            awards.setMovieId(1);
            dao.update(awards);
            //验证是否更新获奖信息成功
            Awards a = dao.findByID(i);
            if(a.getMovieId()!=1) {
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新获奖关系ID为"+i+" 的获奖信息成功!");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过获奖关系ID输出一行信息");
        AwardsDao dao = new AwardsDaoImpl();
        int i=1;
        Awards a = dao.findByID(i);
        //测试是否找到该获奖关系ID
        if(a == null) {
            System.out.println("没有获奖关系ID为 "+i+" 的获奖信息");
        }
        else {
            System.out.println("查找奖项ID为"+a.getRelationId()+" 的一行获奖信息成功!");}

    }

    @Test
    public void findAll() {
        System.out.println("列出所有获奖信息");
        AwardsDao ad = new AwardsDaoImpl();
        List<Awards> awards = ad.findAll();
        for(int i = 0; i < awards.size(); i++) {
            Awards a = awards.get(i);
            System.out.println(a.getAwardsId()+" "+a.getMovieId()+" "+a.getRelationId()+" ");
        }
        System.out.println("列出所有获奖信息成功!");
    }

    @Test
    public void findByMovieId() {
        System.out.println("通过查找电影ID输出所有获奖信息");
        AwardsDao dao = new AwardsDaoImpl();
        int i=1;
        List<Awards> awards = dao.findByMovieId(i);
        for(int j = 0; j < awards.size(); j++) {
            Awards a = awards.get(j);
            System.out.println(a.getAwardsId()+" "+a.getMovieId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找电影ID为"+i+" 的所有获奖信息成功!");
    }

    @Test
    public void findByAwardsId(){
        System.out.println("通过查找奖项ID输出所有获奖信息");
        AwardsDao dao = new AwardsDaoImpl();
        int i=1;
        List<Awards> awards = dao.findByAwardsId(i);
        for(int j = 0; j < awards.size(); j++) {
            Awards a = awards.get(j);
            System.out.println(a.getAwardsId()+" "+a.getMovieId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找奖项ID为"+i+" 的所有获奖信息成功!");
    }
}