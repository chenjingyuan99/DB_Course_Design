package test;

import dao.TypeDao;
import dao.TypeDaoImpl;
import entity.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TypeDaoImplTest extends Type {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        System.out.println("增加Type值信息");
        int i=1;
        int j=2;
        TypeDao dao = new TypeDaoImpl();
        Type a1=dao.findByID(i);
        Type a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Type typ = new Type();
            typ.setTypeId(i);
            typ.setTypeName("喜剧");
            dao.Insert(typ, Type.class);
            typ.setTypeId(j);
            typ.setTypeName("爱情");
            dao.Insert(typ, Type.class);
            //验证是否增加属性值信息成功
            Type a = dao.findByID(i);
            Type b = dao.findByID(j);
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
        TypeDao dao = new TypeDaoImpl();
        Type typ= dao.findByID(i);
        if(typ!=null) {
            try {
                dao.Delete(typ, Type.class);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Type a = dao.findByID(i);
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
        TypeDao dao = new TypeDaoImpl();
        Type typ=dao.findByID(i);
        //判断该属性值ID是否存在
        if(typ==null) {
            System.out.println("Find Error!");
        }
        else {
            typ.setTypeName("歌舞");
            dao.Update(typ, Type.class);
            //验证是否更新属性值信息成功
            Type a = dao.findByID(i);
            if(!a.getTypeName().equals("歌舞")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        TypeDao dao = new TypeDaoImpl();
        int i=1;
        Type a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getTypeId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        TypeDao tpd = new TypeDaoImpl();
        List<Type> tp = tpd.findAll();
        for(int i = 0; i < tp.size(); i++) {
            Type a = tp.get(i);
            System.out.println(a.getTypeId()+" "+a.getTypeName());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByTypeName() {
        System.out.println("通过类型名输出一行信息");
        TypeDao dao = new TypeDaoImpl();
        String str="纪录片";
        Type a = dao.findByTypeName(str);
        if(a == null) {
            System.out.println("没有类型名为 "+str+" 的信息");
        }
        else {
            System.out.println("查找类型名为"+a.getTypeName()+" 的一行信息成功!");}
    }
}