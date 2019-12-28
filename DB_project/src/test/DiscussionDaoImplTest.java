package test;

import dao.DiscussionDao;
import dao.DiscussionDaoImpl;
import entity.Discussion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DiscussionDaoImplTest extends Discussion {
    Class clone= Discussion.class;
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
        System.out.println("增加讨论信息");

        System.out.println("增加讨论信息");

        int i=1;
        int j=2;
        DiscussionDao dao = new DiscussionDaoImpl();
        Discussion a1=dao.findByID(i);
        Discussion a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该讨论ID!");
        }
        else {
            Discussion discussion = new Discussion();
            discussion.setDiscussContent("xxx");
            discussion.setDiscussId(i);
            discussion.setDiscussTopic("剧情");
            discussion.setPromulgator("blacksheep");
            discussion.setReleaseTime("1993-03-09");
            discussion.setGroupId(1);
            dao.Insert(discussion,clone);
            discussion.setDiscussContent("xxxx");
            discussion.setDiscussId(j);
            discussion.setDiscussTopic("人物");
            discussion.setPromulgator("lumingfei");
            discussion.setReleaseTime("1997-09-12");
            discussion.setGroupId(2);
            dao.Insert(discussion,clone);
            //验证是否增加讨论信息成功
            Discussion a = dao.findByID(i);
            Discussion b = dao.findByID(j);
            if(a==null||b==null) {
                System.out.println("Save Error!");
            }
            else {
                System.out.println("增加讨论ID为 "+i+" 和 "+j+" 的讨论信息成功!");}
        }
    }

    @Test
    public void Delete() {
        System.out.println("删除一行指定讨论ID信息");
        int i=2;
        DiscussionDao dao=new DiscussionDaoImpl();
        Discussion discussion= dao.findByID(i);
        if(discussion!=null) {
            try {
                dao.Delete(discussion,clone);
            }catch (Exception e) {
                //System.err.println("Delete Error!");
                System.out.println(e.getMessage());
            }
        }
        //验证是否删除地址信息成功
        Discussion a = dao.findByID(i);
        if(a!=null) {
            System.out.println("Delete Error!");
        }
        else {
            System.out.println("删除讨论ID为 "+i+" 的讨论信息成功!");
        }
    }

    @Test
    public void Update() {
        System.out.println("更新一行信息某列元素");
        int i=1;
        DiscussionDao dao=new DiscussionDaoImpl();
        Discussion discussion=dao.findByID(i);
        //判断该讨论ID是否存在
        if(discussion==null) {
            System.out.println("Find Error!");
        }
        else {
            discussion.setDiscussTopic("change");
            dao.Update(discussion,clone);
            //验证是否更新地址信息成功
            Discussion a = dao.findByID(i);
            if(!a.getDiscussTopic().equals("change")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新讨论ID为"+i+" 的讨论信息成功!");
        }
    }

    @Test
    public void findByID() {
        System.out.println("通过讨论ID输出一行信息");
        DiscussionDao dao = new DiscussionDaoImpl();
        int i=1;
        Discussion a = dao.findByID(i);
        //测试是否找到该讨论ID
        if(a == null) {
            System.out.println("没有讨论ID为 "+i+" 的讨论信息");
        }
        else {
            System.out.println("查找讨论ID为"+a.getDiscussId()+" 的一行讨论信息成功!");}
    }

    @Test
    public void findAll() {
        System.out.println("列出所有讨论信息");
        DiscussionDao dao = new DiscussionDaoImpl();
        List<Discussion> discussionsis = dao.findAll();
        for(int i = 0; i < discussionsis.size(); i++) {
            Discussion a = discussionsis.get(i);
            System.out.println(a.getDiscussContent()+" "+a.getGroupId()+" "+a.getDiscussTopic()+" "+a.getPromulgator()+" "+a.getDiscussId()+" "+a.getReleaseTime()+" ");
        }
        System.out.println("列出所有讨论信息成功!");
    }

    @Test
    public void findByName() {
        System.out.println("通过查找讨论主题输出所有讨论信息");
        DiscussionDao dao  = new DiscussionDaoImpl();
        String i="剧情";
        List<Discussion> discussions = dao.findByName(i);
        for(int j = 0; j < discussions.size(); j++) {
            Discussion a = discussions.get(j);
            System.out.println(a.getDiscussContent()+" "+a.getGroupId()+" "+a.getDiscussId()+" "+a.getReleaseTime()+" "+a.getPromulgator()+" "+a.getDiscussTopic());
        }
        System.out.println("查找讨论主题为"+i+" 的所有讨论信息成功!");
    }
}