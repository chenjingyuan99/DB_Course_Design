package test;

import entity.Usr;
import dao.UsrDao;
import dao.UsrDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UsrDaoImplTest extends Usr {

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
        UsrDao dao = new UsrDaoImpl();
        Usr a1=dao.findByID(i);
        Usr a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Usr user = new Usr();
            user.setUsrId(i);
            user.setUsrAccount("1310135143");
            user.setUsrNickname("涤尘");
            user.setUsrPasswd("123456");
            dao.Insert(user);
            user.setUsrId(j);
            user.setUsrAccount("2200722984");
            user.setUsrNickname("八方轮");
            user.setUsrPasswd("654321");
            dao.Insert(user);
            //验证是否增加属性值信息成功
            Usr a = dao.findByID(i);
            Usr b = dao.findByID(j);
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
        UsrDao dao = new UsrDaoImpl();
        Usr user= dao.findByID(i);
        if(user!=null) {
            try {
                dao.Delete(user);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除属性值信息成功
        Usr a = dao.findByID(i);
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
        UsrDao dao = new UsrDaoImpl();
        Usr user=dao.findByID(i);
        //判断该属性值ID是否存在
        if(user==null) {
            System.out.println("Find Error!");
        }
        else {
            user.setUsrNickname("怕热。");
            dao.Update(user);
            //验证是否更新属性值信息成功
            Usr a = dao.findByID(i);
            if(!a.getUsrNickname().equals("CHANGE")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过ID输出一行信息");
        UsrDao dao = new UsrDaoImpl();
        int i=1;
        Usr a = dao.findByID(i);
        if(a == null) {
            System.out.println("没有ID为 "+i+" 的信息");
        }
        else {
            System.out.println("查找ID为"+a.getUsrId()+" 的一行信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        UsrDao usrd = new UsrDaoImpl();
        List<Usr> usr = usrd.findAll();
        for(int i = 0; i < usr.size(); i++) {
            Usr a = usr.get(i);
            System.out.println(a.getUsrId()+" "+a.getUsrAccount()+" "+a.getUsrNickname()+
                    " "+a.getUsrPasswd());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByName() {
        System.out.println("通过昵称输出一行信息");
        UsrDao dao = new UsrDaoImpl();
        String str="hello";
        Usr a = dao.findByName(str);
        if(a == null) {
            System.out.println("没有昵称为 "+str+" 的信息");
        }
        else {
            System.out.println("查找昵称为"+a.getUsrNickname()+" 的一行信息成功!");}
    }
}