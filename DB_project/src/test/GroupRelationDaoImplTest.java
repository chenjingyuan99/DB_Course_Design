package test;

import dao.GroupRelationDao;
import dao.GroupRelationDaoImpl;
import entity.GroupRelation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GroupRelationDaoImplTest extends GroupRelation {
    Class clone=GroupRelation.class;
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
        System.out.println("增加小组信息");

        System.out.println("增加小组信息");

        int i=1;
        int j=2;
        GroupRelationDao dao = new GroupRelationDaoImpl();
        GroupRelation a1=dao.findByID(i);
        GroupRelation a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该小组关系ID!");
        }
        else {
            GroupRelation GroupRelation = new GroupRelation();
            GroupRelation.setGroupId(1);
            GroupRelation.setUsrId(2);
            GroupRelation.setRelationId(i);
            dao.Insert(GroupRelation,clone);
            GroupRelation.setGroupId(1);
            GroupRelation.setUsrId(2);
            GroupRelation.setRelationId(j);
            dao.Insert(GroupRelation,clone);
            //验证是否增加小组信息成功
            GroupRelation a = dao.findByID(i);
            GroupRelation b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加小组关系ID为 "+i+" 和 "+j+" 的小组信息成功!");
            }
        }
    }

    @Test
    public void Delete() {
        System.out.println("删除一行指定小组关系ID的信息");
        int i=2;
        GroupRelationDao dao=new GroupRelationDaoImpl();
        GroupRelation GroupRelation= dao.findByID(i);
        if(GroupRelation!=null) {
            try {
                dao.Delete(GroupRelation,clone);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除分类信息成功
        GroupRelation a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除小组关系ID为 "+i+" 的小组信息成功!");
        }
    }

    @Test
    public void Update() {
        System.out.println("更新一行信息某列元素");
        int i=1;
        GroupRelationDao dao=new GroupRelationDaoImpl();
        GroupRelation GroupRelation=dao.findByID(i);
        //判断该类型ID是否存在
        if(GroupRelation==null) {
            System.out.println("Find Error!");
        }
        else {
            GroupRelation.setGroupId(1);
            dao.Update(GroupRelation,clone);
            //验证是否更新地址信息成功
            GroupRelation a = dao.findByID(i);
            if(a.getGroupId()!=1) {
                System.out.println("Update Error!");
            }
            else
            {
                System.out.println("更新小组关系ID为"+i+" 的小组信息成功!");
            }
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过小组关系ID输出一行信息");
        GroupRelationDao dao = new GroupRelationDaoImpl();
        int i=1;
        GroupRelation a = dao.findByID(i);
        //测试是否找到该分类关系ID
        if(a == null) {
            System.out.println("没有小组关系ID为 "+i+" 的小组信息");
        }
        else {
            System.out.println("查找小组关系ID为"+a.getRelationId()+" 的一行小组信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有小组信息");
        GroupRelationDao dao = new GroupRelationDaoImpl();
        List<GroupRelation> GroupRelation = dao.findAll();
        for(int i = 0; i < GroupRelation.size(); i++) {
            GroupRelation a = GroupRelation.get(i);
            System.out.println(a.getGroupId()+" "+a.getUsrId()+" "+a.getRelationId()+" ");
        }
        System.out.println("列出所有小组信息成功!");
    }

    @Test
    public void findByGroupId() {
        System.out.println("通过查找小组ID输出所有小组信息");
        GroupRelationDao dao = new GroupRelationDaoImpl();
        int i=1;
        List<GroupRelation> GroupRelation = dao.findByGroupId(i);
        for(int j = 0; j < GroupRelation.size(); j++) {
            GroupRelation a = GroupRelation.get(j);
            System.out.println(a.getGroupId()+" "+a.getGroupId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找小组ID为"+i+" 的所有小组信息成功!");
    }


    @Test
    public void findByUsrId() {
        System.out.println("通过查找用户ID输出所有小组信息");
        GroupRelationDao dao = new GroupRelationDaoImpl();
        int i=1;
        List<GroupRelation> GroupRelation = dao.findByUsrId(i);
        for(int j = 0; j < GroupRelation.size(); j++) {
            GroupRelation a = GroupRelation.get(j);
            System.out.println(a.getGroupId()+" "+a.getUsrId()+" "+a.getRelationId()+" ");
        }
        System.out.println("查找用户ID为"+i+" 的所有小组信息成功!");
    }
}