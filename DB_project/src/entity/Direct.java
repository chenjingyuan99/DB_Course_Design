package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Direct {
    private int directorId;
    private int movieId;
    private int relationId;

    @Basic
    @Column(name = "director_id", nullable = false)
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
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
        Direct direct = (Direct) o;
        return directorId == direct.directorId &&
                movieId == direct.movieId &&
                relationId == direct.relationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId, movieId, relationId);
    }
}
