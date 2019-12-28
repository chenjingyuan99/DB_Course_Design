package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Realation {
    private int relationId;
    private int usrIdA;
    private int usrIdB;

    @Id
    @Column(name = "relation_id")
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "usr_id_A")
    public int getUsrIdA() {
        return usrIdA;
    }

    public void setUsrIdA(int usrIdA) {
        this.usrIdA = usrIdA;
    }

    @Basic
    @Column(name = "usr_id_B")
    public int getUsrIdB() {
        return usrIdB;
    }

    public void setUsrIdB(int usrIdB) {
        this.usrIdB = usrIdB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Realation realation = (Realation) o;
        return relationId == realation.relationId &&
                usrIdA == realation.usrIdA &&
                usrIdB == realation.usrIdB;
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, usrIdA, usrIdB);
    }
}
