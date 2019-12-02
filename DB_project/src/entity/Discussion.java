package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Discussion {
    private int discussId;
    private String discussTopic;
    private String promulgator;
    private Object releaseTime;
    private String discussContent;

    @Id
    @Column(name = "discuss_id", nullable = false)
    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    @Basic
    @Column(name = "discuss_topic", nullable = false, length = 32)
    public String getDiscussTopic() {
        return discussTopic;
    }

    public void setDiscussTopic(String discussTopic) {
        this.discussTopic = discussTopic;
    }

    @Basic
    @Column(name = "promulgator", nullable = false, length = 32)
    public String getPromulgator() {
        return promulgator;
    }

    public void setPromulgator(String promulgator) {
        this.promulgator = promulgator;
    }

    @Basic
    @Column(name = "release_time", nullable = false)
    public Object getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Object releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Basic
    @Column(name = "discuss_content", nullable = true, length = 400)
    public String getDiscussContent() {
        return discussContent;
    }

    public void setDiscussContent(String discussContent) {
        this.discussContent = discussContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discussion that = (Discussion) o;
        return discussId == that.discussId &&
                Objects.equals(discussTopic, that.discussTopic) &&
                Objects.equals(promulgator, that.promulgator) &&
                Objects.equals(releaseTime, that.releaseTime) &&
                Objects.equals(discussContent, that.discussContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discussId, discussTopic, promulgator, releaseTime, discussContent);
    }
}
