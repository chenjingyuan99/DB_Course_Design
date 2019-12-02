package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_language", schema = "dbo", catalog = "douban_db")
public class MovieLanguage {
    private int relationId;
    private int languageId;
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
    @Column(name = "language_id", nullable = false)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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
        MovieLanguage that = (MovieLanguage) o;
        return relationId == that.relationId &&
                languageId == that.languageId &&
                movieId == that.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationId, languageId, movieId);
    }
}
