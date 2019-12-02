package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Awards {
    private int awardsId;
    private int movieId;
    private int relationId;

    @Basic
    @Column(name = "awards_id", nullable = false)
    public int getAwardsId() {
        return awardsId;
    }

    public void setAwardsId(int awardsId) {
        this.awardsId = awardsId;
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
        Awards awards = (Awards) o;
        return awardsId == awards.awardsId &&
                movieId == awards.movieId &&
                relationId == awards.relationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardsId, movieId, relationId);
    }
}
