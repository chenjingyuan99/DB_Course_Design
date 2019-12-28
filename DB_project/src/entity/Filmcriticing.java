package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Filmcriticing {
    private int filmcriticId;
    private String filmcriticContent;
    private String promulgator;
    private Object releaseTime;

    @Id
    @Column(name = "filmcritic _id", nullable = false)
    public int getFilmcriticId() {
        return filmcriticId;
    }

    public void setFilmcriticId(int filmcriticId) {
        this.filmcriticId = filmcriticId;
    }

    @Basic
    @Column(name = "filmcritic _ content", nullable = true, length = 100)
    public String getFilmcriticContent() {
        return filmcriticContent;
    }

    public void setFilmcriticContent(String filmcriticContent) {
        this.filmcriticContent = filmcriticContent;
    }

    @Basic
    @Column(name = "promulgator", nullable = true, length = 32)
    public String getPromulgator() {
        return promulgator;
    }

    public void setPromulgator(String promulgator) {
        this.promulgator = promulgator;
    }

    @Basic
    @Column(name = "release_time", nullable = true)
    public Object getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Object releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filmcriticing that = (Filmcriticing) o;
        return filmcriticId == that.filmcriticId &&
                Objects.equals(filmcriticContent, that.filmcriticContent) &&
                Objects.equals(promulgator, that.promulgator) &&
                Objects.equals(releaseTime, that.releaseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmcriticId, filmcriticContent, promulgator, releaseTime);
    }
}
