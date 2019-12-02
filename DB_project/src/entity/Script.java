package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Script {
    private int relationId;
    private int scriptwriterId;
    private int movieId;

    @Id
    @Column(name = "relation_id", nullable = false)
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "scriptwriter_id", nullable = false)
    public int getScriptwriterId() {
        return scriptwriterId;
    }

    public void setScriptwriterId(int scriptwriterId) {
        this.scriptwriterId = scriptwriterId;
    }

    @Basic
    @Column(name = "movie_id", nullable = false)
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
        Script script = (Script) o;
        return relationId == script.relationId &&
                scriptwriterId == script.scriptwriterId &&
                movieId == script.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, scriptwriterId, movieId);
    }
}
