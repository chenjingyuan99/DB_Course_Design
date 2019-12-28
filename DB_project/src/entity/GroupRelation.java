package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_relation", schema = "dbo", catalog = "douban_db")
public class GroupRelation {
    private int relationId;
    private int usrId;
    private int groupId;

    @Id
    @Column(name = "relation_id", nullable = false)
    public int getRelationId() {
        return relationId;
    }

    public void setRelationId(int relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "usr_id", nullable = false)
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "group_id", nullable = false)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupRelation that = (GroupRelation) o;
        return relationId == that.relationId &&
                usrId == that.usrId &&
                groupId == that.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, usrId, groupId);
    }
}
