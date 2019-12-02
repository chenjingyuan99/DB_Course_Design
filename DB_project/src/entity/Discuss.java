package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Discuss {
    private int discussId;
    private int movieId;
    private int relationId;

    @Basic
    @Column(name = "discuss_id", nullable = false)
    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    @Basic
    @Column(name = "movie_id", nullable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
        Discuss discuss = (Discuss) o;
        return discussId == discuss.discussId &&
                movieId == discuss.movieId &&
                relationId == discuss.relationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discussId, movieId, relationId);
    }
}
