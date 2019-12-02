package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Browse {
    private int browseId;
    private Integer topicsId;
    private int relationId;

    @Basic
    @Column(name = "browse _id", nullable = false)
    public int getBrowseId() {
        return browseId;
    }

    public void setBrowseId(int browseId) {
        this.browseId = browseId;
    }

    @Basic
    @Column(name = "topics_id", nullable = true)
    public Integer getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(Integer topicsId) {
        this.topicsId = topicsId;
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
        Browse browse = (Browse) o;
        return browseId == browse.browseId &&
                relationId == browse.relationId &&
                Objects.equals(topicsId, browse.topicsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(browseId, topicsId, relationId);
    }
}
