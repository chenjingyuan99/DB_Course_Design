package test;

import dao.ClassifyDao;
import dao.ClassifyDaoImpl;
import entity.Classify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClassifyDaoImplTest extends Classify {

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
        System.out.println("增加分类信息");

        System.out.println("增加分类信息");

        int i=6;
        int j=7;
        ClassifyDao dao = new ClassifyDaoImpl();
        Classify a1=dao.findByID(i);
        Classify a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该分类关系ID!");
        }
        else {
            Classify classify = new Classify();
            classify.setMovieId(1);
            classify.setTypeId(2);
            classify.setRelationId(i);
            dao.save(classify);
            classify.setTypeId(1);
            classify.setMovieId(2);
            classify.setRelationId(j);
            dao.save(classify);
            //验证是否增加分类信息成功
            Classify a = dao.findByID(i);
            Classify b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加分类关系ID为 "+i+" 和 "+j+" 的分类信息成功!");
            }
        }
    }

    @Test
    public void delete() {
        System.out.println("删除一行指定分类关系ID的信息");
        int i=2;
        ClassifyDao dao=new ClassifyDaoImpl();
        Classify classify= dao.findByID(i);
        if(classify!=null) {
            try {
                dao.delete(classify);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除分类信息成功
        Classify a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除分类关系ID为 "+i+" 的分类信息成功!");
        }
    }

    @Test
    public void update() {
        System.out.println("更新一行信息某列元素");
        int i=2;
        ClassifyDao dao=new ClassifyDaoImpl();
        Classify classify=dao.findByID(i);
        //判断该类型ID是否存在
        if(classify==null) {
            System.out.println("Find Error!");
        }
        else {
            classify.setTypeId(1);
            dao.update(classify);
            //验证是否更新地址信息成功
            Classify a = dao.findByID(i);
            if(a.getTypeId()!=1) {
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新分类关系ID为"+i+" 的分类信息成功!");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过分类关系ID输出一行信息");
        ClassifyDao dao = new ClassifyDaoImpl();
        int i=1;
        Classify a = dao.findByID(i);
        //测试是否找到该分类关系ID
        if(a == null) {
            System.out.println("没有分类关系ID为 "+i+" 的分类信息");
        }
        else {
            System.out.println("查找分类关系ID为"+a.getRelationId()+" 的一行分类信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有分类信息");
        ClassifyDao dao = new ClassifyDaoImpl();
        List<Classify> classify = dao.findAll();
        for(int i = 0; i < classify.size(); i++) {
            Classify a = classify.get(i);
            System.out.println(a.getMovieId()+" "+a.getTypeId()+" "+a.getRelationId()+" ");
        }
        System.out.println("列出所有分类信息成功!");
    }

    @Test
    public void findByMovieId() {
        System.out.println("通过查找电影ID输出所有分类信息");
        ClassifyDao dao = new ClassifyDaoImpl();
        int i=1;
        List<Classify> classify = dao.findByMovieId(i);
        for(int j = 0; j < classify.size(); j++) {
            Classify a = classify.get(j);
            System.out.println(a.getMovieId()+" "+a.getTypeId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找电影ID为"+i+" 的所有分类信息成功!");
    }


    @Test
    public void findByTypeId() {
        System.out.println("通过查找类型ID输出所有分类信息");
        ClassifyDao dao = new ClassifyDaoImpl();
        int i=1;
        List<Classify> classify = dao.findByTypeId(i);
        for(int j = 0; j < classify.size(); j++) {
            Classify a = classify.get(j);
            System.out.println(a.getMovieId()+" "+a.getTypeId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找类型ID为"+i+" 的所有分类信息成功!");
    }
}