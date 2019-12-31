package test;

import dao.JudgeDao;
import dao.JudgeDaoImpl;
import entity.Judge;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JudgeDaoImplTest extends Judge {

    @Test
    public void insert() {
        System.out.println("增加label值信息");
        int i=1;
        int j=2;
        JudgeDao dao = new JudgeDaoImpl();
        Judge a1=dao.findByID(i);
        Judge a2=dao.findByID(j);
        if(a1!=null||a2!=null) {
            System.out.println("已经存在该属性值ID!");
        }
        else {
            Judge jdg = new Judge();
            jdg.setJudgeId(i);
            jdg.setUsrId(i);
            jdg.setComId(i);
            jdg.setJudgeContent("abc");
            dao.Insert(jdg, Judge.class);
            jdg.setJudgeId(j);
            jdg.setUsrId(j);
            jdg.setComId(j);
            dao.Insert(jdg, Judge.class);
            //验证是否增加属性值信息成功
            Judge a = dao.findByID(i);
            Judge b = dao.findByID(j);
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
        JudgeDao dao = new JudgeDaoImpl();
        Judge lab= dao.findByID(i);
        if(lab!=null) {
            try {
                Class clana = Judge.class;
                dao.Delete(lab, clana);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("找不到该ID相关信息");
            return;
        }
        //验证是否删除属性值信息成功
        Judge a = dao.findByID(i);
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
        JudgeDao dao = new JudgeDaoImpl();
        Judge lab=dao.findByID(i);
        //判断该属性值ID是否存在
        if(lab==null) {
            System.out.println("Find Error!");
        }
        else {
            lab.setJudgeContent("WoW");
            Class clana = Judge.class;
            dao.Update(lab, clana);
            //验证是否更新属性值信息成功
            Judge a = dao.findByID(i);
            if(!a.getJudgeContent().equals("WoW")) {
                System.out.println("Update Error!");
            }
            System.out.println("更新属性值ID为"+i+" 的信息成功!");
        }
    }

    @Test
    public void findAll() {
        System.out.println("列出所有信息");
        JudgeDao labd = new JudgeDaoImpl();
        List<Judge> lab = labd.findAll();
        for(int i = 0; i < lab.size(); i++) {
            Judge a = lab.get(i);
            System.out.println(a.getJudgeId()+" "+a.getUsrId()+" "+a.getComId()+" "+a.getJudgeContent());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByUsrID() {
        System.out.println("列出所有信息");
        JudgeDao judg = new JudgeDaoImpl();
        int j=1;
        List<Judge> jdg = judg.findByUsrID(j);
        for(int i = 0; i < jdg.size(); i++) {
            Judge a = jdg.get(i);
            System.out.println(a.getJudgeId()+" "+a.getUsrId()+" "+a.getComId()+" "+a.getJudgeContent());
        }
        System.out.println("列出所有信息成功!");
    }

    @Test
    public void findByComID() {
        System.out.println("列出所有信息");
        JudgeDao judg = new JudgeDaoImpl();
        int j=1;
        List<Judge> jdg = judg.findByComID(j);
        for(int i = 0; i < jdg.size(); i++) {
            Judge a = jdg.get(i);
            System.out.println(a.getJudgeId()+" "+a.getUsrId()+" "+a.getComId()+" "+a.getJudgeContent());
        }
        System.out.println("列出所有信息成功!");
    }
}