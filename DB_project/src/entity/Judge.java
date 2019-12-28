package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Judge {
    private int judgeId;
    private int usrId;
    private int comId;
    private String judgeContent;

    @Basic
    @Column(name = "judge_id")
    public int getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
    }

    @Basic
    @Column(name = "usr_id")
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "com_id")
    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    @Basic
    @Column(name = "judge_content")
    public String getJudgeContent() {
        return judgeContent;
    }

    public void setJudgeContent(String judgeContent) {
        this.judgeContent = judgeContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return judgeId == judge.judgeId &&
                usrId == judge.usrId &&
                comId == judge.comId &&
                Objects.equals(judgeContent, judge.judgeContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(judgeId, usrId, comId, judgeContent);
    }
}
