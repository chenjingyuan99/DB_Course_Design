package test;

import entity.Language;
import dao.LangDao;
import dao.LangDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LangDaoImplTest extends Language {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        System.out.println("增加language信息");
        int i=1;
        int j=2;
        LangDao dao = new LangDaoImpl();
        Language a1=dao.findByID(i);
        Language a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Language lan = new Language();
            lan.setLanguageId(i);
            lan.setLanguageName("西班牙语");
            dao.Insert(lan);
            lan.setLanguageId(j);
            lan.setLanguageName("德语");
            dao.Insert(lan);
            //验证是否增加属性值信息成功
            Language a = dao.findByID(i);
            Language b = dao.findByID(j);
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
        LangDao dao = new LangDaoImpl();
        Language lan= dao.findByID(i);
        if(lan!=null) {
            try {
                dao.Delete(lan);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Language a = dao.findByID(i);
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
        LangDao dao = new LangDaoImpl();
        Language lan=dao.findByID(i);
        //判断该属性值ID是否存在
        if(lan==null) {
            System.out.println("Find Error!");
        }
        else {
            lan.setLanguageName("日语");
            dao.Update(lan);
            //验证是否更新属性值信息成功
            Language a = dao.findByID(i);
            if(!a.getLanguageName().equals("日语")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        LangDao dao = new LangDaoImpl();
        int i=1;
        Language a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getLanguageId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        LangDao land = new LangDaoImpl();
        List<Language> lan = land.findAll();
        for(int i = 0; i < lan.size(); i++) {
            Language a = lan.get(i);
            System.out.println(a.getLanguageId()+" "+a.getLanguageName());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByLangName() {
        System.out.println("通过语言名输出一行信息");
        LangDao dao = new LangDaoImpl();
        String str="英语";
        Language a = dao.findByLangName(str);
        if(a == null) {
            System.out.println("没有语言名为 "+str+" 的信息");
        }
        else {
            System.out.println("查找语言名为"+a.getLanguageName()+" 的一行信息成功!");}
    }
}