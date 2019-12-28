package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Responding {
    private int respondId;
    private String promulgator;
    private String releaseTime;
    private String respondContent;
    private int discussId;

    @Id
    @Column(name = "respond_id")
    public int getRespondId() {
        return respondId;
    }

    public void setRespondId(int respondId) {
        this.respondId = respondId;
    }

    @Basic
    @Column(name = "promulgator")
    public String getPromulgator() {
        return promulgator;
    }

    public void setPromulgator(String promulgator) {
        this.promulgator = promulgator;
    }

    @Basic
    @Column(name = "release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Basic
    @Column(name = "respond_content")
    public String getRespondContent() {
        return respondContent;
    }

    public void setRespondContent(String respondContent) {
        this.respondContent = respondContent;
    }

    @Basic
    @Column(name = "discuss_id")
    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responding that = (Responding) o;
        return respondId == that.respondId &&
                discussId == that.discussId &&
                Objects.equals(promulgator, that.promulgator) &&
                Objects.equals(releaseTime, that.releaseTime) &&
                Objects.equals(respondContent, that.respondContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondId, promulgator, releaseTime, respondContent, discussId);
    }
}
