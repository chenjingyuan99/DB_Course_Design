package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Label {
    private int labId;
    private String labComment;

    @Id
    @Column(name = "lab_id")
    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    @Basic
    @Column(name = "lab_comment")
    public String getLabComment() {
        return labComment;
    }

    public void setLabComment(String labComment) {
        this.labComment = labComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return labId == label.labId &&
                Objects.equals(labComment, label.labComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(labId, labComment);
    }
}
