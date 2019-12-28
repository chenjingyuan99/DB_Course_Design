package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Filmcritic {
    private int filmcriticId;
    private int topicsId;

    @Id
    @Column(name = "filmcritic _id", nullable = false)
    public int getFilmcriticId() {
        return filmcriticId;
    }

    public void setFilmcriticId(int filmcriticId) {
        this.filmcriticId = filmcriticId;
    }

    @Basic
    @Column(name = "topics_id", nullable = false)
    public int getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(int topicsId) {
        this.topicsId = topicsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmcritic that = (Filmcritic) o;
        return filmcriticId == that.filmcriticId &&
                topicsId == that.topicsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmcriticId, topicsId);
    }
}
