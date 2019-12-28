package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Topics {
    private int topicsId;
    private String topicsContent;

    @Id
    @Column(name = "topics_id", nullable = false)
    public int getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(int topicsId) {
        this.topicsId = topicsId;
    }

    @Basic
    @Column(name = "topics_content", nullable = true, length = 32)
    public String getTopicsContent() {
        return topicsContent;
    }

    public void setTopicsContent(String topicsContent) {
        this.topicsContent = topicsContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topics topics = (Topics) o;
        return topicsId == topics.topicsId &&
                Objects.equals(topicsContent, topics.topicsContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicsId, topicsContent);
    }
}
