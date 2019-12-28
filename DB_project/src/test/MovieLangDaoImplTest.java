package test;

import dao.MovieLangDao;
import dao.MovieLangDaoImpl;
import entity.MovieLanguage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MovieLangDaoImplTest extends MovieLanguage {

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
        MovieLangDao dao = new MovieLangDaoImpl();
        MovieLanguage a1=dao.findByID(i);
        MovieLanguage a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            MovieLanguage movi = new MovieLanguage();
            movi.setRelationId(i);
            movi.setMovieId(1);
            movi.setLanguageId(1);
            dao.Insert(movi, MovieLanguage.class);
            movi.setRelationId(j);
            movi.setMovieId(2);
            movi.setLanguageId(2);
            dao.Insert(movi, MovieLanguage.class);
            //验证是否增加属性值信息成功
            MovieLanguage a = dao.findByID(i);
            MovieLanguage b = dao.findByID(j);
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
        MovieLangDao dao = new MovieLangDaoImpl();
        MovieLanguage movi= dao.findByID(i);
        if(movi!=null) {
            try {
                dao.Delete(movi, MovieLanguage.class);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        MovieLanguage a = dao.findByID(i);
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
        MovieLangDao dao = new MovieLangDaoImpl();
        MovieLanguage movi=dao.findByID(i);
        //判断该属性值ID是否存在
        if(movi==null) {
            System.out.println("Find Error!");
        }
        else {
            movi.setMovieId(9);
            dao.Update(movi, MovieLanguage.class);
            //验证是否更新属性值信息成功
            MovieLanguage a = dao.findByID(i);
            if(a.getMovieId()==9) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        MovieLangDao dao = new MovieLangDaoImpl();
        int i=1;
        MovieLanguage a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getRelationId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        MovieLangDao movd = new MovieLangDaoImpl();
        List<MovieLanguage> mov = movd.findAll();
        for(int i = 0; i < mov.size(); i++) {
            MovieLanguage a = mov.get(i);
            System.out.println(a.getLanguageId()+" "+a.getMovieId());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByLangID() {
        System.out.println("通过查找languageID输出所有属性值信息");
        MovieLangDao dao = new MovieLangDaoImpl();
        int i=1;
        List<MovieLanguage> movi = dao.findByLangID(i);
        for(int j = 0; j < movi.size(); j++) {
            MovieLanguage a = movi.get(j);
            System.out.println(a.getLanguageId()+" "+a.getMovieId());}
        System.out.println("查找languageID为"+i+" 的所有属性值信息成功!");
    }

    @Test
    public void findByMovieID() {
        System.out.println("通过查找movieID输出所有属性值信息");
        MovieLangDao dao = new MovieLangDaoImpl();
        int i=1;
        List<MovieLanguage> movi = dao.findByMovieID(i);
        for(int j = 0; j < movi.size(); j++) {
            MovieLanguage a = movi.get(j);
            System.out.println(a.getLanguageId()+" "+a.getMovieId());}
        System.out.println("查找movieID为"+i+" 的所有属性值信息成功!");
    }
}