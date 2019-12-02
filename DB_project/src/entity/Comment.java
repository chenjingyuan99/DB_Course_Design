package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Comment {
    private int comId;
    private int movId;
    private int usrId;
    private byte comSeen;
    private Byte comStar;
    private String comContent;
    private Object comTime;
    private int relationId;

    @Basic
    @Column(name = "com_id", nullable = false)
    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    @Basic
    @Column(name = "mov_id", nullable = false)
    public int getMovId() {
        return movId;
    }

    public void setMovId(int movId) {
        this.movId = movId;
    }

    @Basic
    @Column(name = "usr_id", nullable = false)
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "com_seen", nullable = false)
    public byte getComSeen() {
        return comSeen;
    }

    public void setComSeen(byte comSeen) {
        this.comSeen = comSeen;
    }

    @Basic
    @Column(name = "com_star", nullable = true)
    public Byte getComStar() {
        return comStar;
    }

    public void setComStar(Byte comStar) {
        this.comStar = comStar;
    }

    @Basic
    @Column(name = "com_content", nullable = true, length = 16)
    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    @Basic
    @Column(name = "com_time", nullable = true)
    public Object getComTime() {
        return comTime;
    }

    public void setComTime(Object comTime) {
        this.comTime = comTime;
    }

    @Id
    @Column(name = "relation_id", nullable = false)
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return comId == comment.comId &&
                movId == comment.movId &&
                usrId == comment.usrId &&
                comSeen == comment.comSeen &&
                relationId == comment.relationId &&
                Objects.equals(comStar, comment.comStar) &&
                Objects.equals(comContent, comment.comContent) &&
                Objects.equals(comTime, comment.comTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comId, movId, usrId, comSeen, comStar, comContent, comTime, relationId);
    }
}
