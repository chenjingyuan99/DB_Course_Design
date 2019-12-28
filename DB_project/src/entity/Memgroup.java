package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Memgroup {
    private int groupId;
    private String groupName;
    private Integer movieId;

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "movie_id")
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memgroup memgroup = (Memgroup) o;
        return groupId == memgroup.groupId &&
                Objects.equals(groupName, memgroup.groupName) &&
                Objects.equals(movieId, memgroup.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName, movieId);
    }
}
