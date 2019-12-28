package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Script {
    private int scriptwriterId;
    private int movieId;
    private int relationId;

    @Basic
    @Column(name = "scriptwriter_id")
    public int getScriptwriterId() {
        return scriptwriterId;
    }

    public void setScriptwriterId(int scriptwriterId) {
        this.scriptwriterId = scriptwriterId;
    }

    @Basic
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Id
    @Column(name = "relation_id")
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
        Script script = (Script) o;
        return scriptwriterId == script.scriptwriterId &&
                movieId == script.movieId &&
                relationId == script.relationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptwriterId, movieId, relationId);
    }
}
