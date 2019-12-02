package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Actor {
    private int actorId;
    private String actorName;
    private byte isStar;

    @Id
    @Column(name = "actor_id", nullable = false)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "actor_name", nullable = false, length = 32)
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Basic
    @Column(name = "is_star", nullable = false)
    public byte getIsStar() {
        return isStar;
    }

    public void setIsStar(byte isStar) {
        this.isStar = isStar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId == actor.actorId &&
                isStar == actor.isStar &&
                Objects.equals(actorName, actor.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, actorName, isStar);
    }
}
