package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_language", schema = "dbo", catalog = "douban_db")
public class MovieLanguage {
    private int languageId;
    private int movieId;
    private int relationId;

    @Basic
    @Column(name = "language_id")
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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
        MovieLanguage that = (MovieLanguage) o;
        return languageId == that.languageId &&
                movieId == that.movieId &&
                relationId == that.relationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, movieId, relationId);
    }
}
