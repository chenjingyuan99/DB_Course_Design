package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Seen {
    private int relationId;
    private int usrId;
    private int movieId;

    @Id
    @Column(name = "relation_id")
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
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
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seen seen = (Seen) o;
        return relationId == seen.relationId &&
                usrId == seen.usrId &&
                movieId == seen.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, usrId, movieId);
    }
}
