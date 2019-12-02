package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Movie {
    private int movieId;
    private String movieName;
    private Date releaseDate;
    private int movieTime;
    private String movieIntroduction;

    @Id
    @Column(name = "movie_id", nullable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "movie_name", nullable = false, length = 32)
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "release_date", nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "movie_time", nullable = false)
    public int getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(int movieTime) {
        this.movieTime = movieTime;
    }

    @Basic
    @Column(name = "movie_introduction", nullable = false, length = 400)
    public String getMovieIntroduction() {
        return movieIntroduction;
    }

    public void setMovieIntroduction(String movieIntroduction) {
        this.movieIntroduction = movieIntroduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId &&
                movieTime == movie.movieTime &&
                Objects.equals(movieName, movie.movieName) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(movieIntroduction, movie.movieIntroduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, releaseDate, movieTime, movieIntroduction);
    }
}
