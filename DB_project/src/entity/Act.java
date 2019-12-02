package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Act {
    private int actorId;
    private int movieId;
    private String roleName;
    private int relationId;

    @Basic
    @Column(name = "actor_id", nullable = false)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "movie_id", nullable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 32)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        Act act = (Act) o;
        return actorId == act.actorId &&
                movieId == act.movieId &&
                relationId == act.relationId &&
                Objects.equals(roleName, act.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, movieId, roleName, relationId);
    }
}
