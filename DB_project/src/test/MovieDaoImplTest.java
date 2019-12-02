package test;

import entity.Movie;
import dao.MovieDao;
import dao.MovieDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.sql.Date;

public class MovieDaoImplTest extends Movie {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        System.out.println("增加movie信息");
        int i=1;
        int j=2;
        MovieDao dao = new MovieDaoImpl();
        Movie a1=dao.findByID(i);
        Movie a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Movie movi = new Movie();
            movi.setMovieId(i);
            movi.setMovieName("3 idoits");
            Date mvdate = new Date(2011,12,8);
            movi.setReleaseDate(mvdate);
            movi.setMovieTime(171);
            movi.setMovieIntroduction("本片根据印度畅销书作家奇坦·巴哈特（Chetan Bhagat）的处女作小说《五点人》（Five Point Someone）改编而成。");
            dao.Insert(movi);
            movi.setMovieId(j);
            movi.setMovieName("红海行动");
            Date date = new Date(2018,2,16);
            movi.setReleaseDate(date);
            movi.setMovieTime(138);
            movi.setMovieIntroduction("中东国家伊维亚共和国发生政变，武装冲突不断升级。");
            dao.Insert(movi);
            //验证是否增加属性值信息成功
            Movie a = dao.findByID(i);
            Movie b = dao.findByID(j);
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
        MovieDao dao = new MovieDaoImpl();
        Movie movi= dao.findByID(i);
        if(movi!=null) {
            try {
                dao.Delete(movi);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Movie a = dao.findByID(i);
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
        MovieDao dao = new MovieDaoImpl();
        Movie movi=dao.findByID(i);
        //判断该属性值ID是否存在
        if(movi==null) {
            System.out.println("Find Error!");
        }
        else {
            movi.setMovieTime(172);
            dao.Update(movi);
            //验证是否更新属性值信息成功
            Movie a = dao.findByID(i);
            if(a.getMovieTime()!=172) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        MovieDao dao = new MovieDaoImpl();
        int i=1;
        Movie a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getMovieId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        MovieDao mvd = new MovieDaoImpl();
        List<Movie> mv = mvd.findAll();
        for(int i = 0; i < mv.size(); i++) {
            Movie a = mv.get(i);
            System.out.println(a.getMovieId()+" "+a.getMovieName()+" "+a.getReleaseDate()+
                    " "+a.getMovieTime()+" "+a.getMovieIntroduction()+" "+a.getMovieIntroduction());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByName() {
        System.out.println("通过电影名输出一行信息");
        MovieDao dao = new MovieDaoImpl();
        String str="3 Idiots";
        Movie a = dao.findByName(str);
        if(a == null) {
            System.out.println("没有电影名为 "+str+" 的信息");
        }
        else {
            System.out.println("查找电影名为"+a.getMovieName()+" 的一行信息成功!");}
    }
}