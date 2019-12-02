package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Director {
    private int directorId;
    private String directorName;

    @Id
    @Column(name = "director_id", nullable = false)
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Basic
    @Column(name = "director_name", nullable = false, length = 32)
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return directorId == director.directorId &&
                Objects.equals(directorName, director.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId, directorName);
    }
}
