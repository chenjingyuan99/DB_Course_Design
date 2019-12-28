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
    private String releaseDate;
    private int movieTime;
    private String movieIntroduction;
    private String movieImDb;
    private byte movieOnline;

    @Id
    @Column(name = "movie_id")
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "movie_name")
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Basic
    @Column(name = "release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "movie_time")
    public int getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(int movieTime) {
        this.movieTime = movieTime;
    }

    @Basic
    @Column(name = "movie_introduction")
    public String getMovieIntroduction() {
        return movieIntroduction;
    }

    public void setMovieIntroduction(String movieIntroduction) {
        this.movieIntroduction = movieIntroduction;
    }

    @Basic
    @Column(name = "movie_IMDb")
    public String getMovieImDb() {
        return movieImDb;
    }

    public void setMovieImDb(String movieImDb) {
        this.movieImDb = movieImDb;
    }

    @Basic
    @Column(name = "movie_online")
    public byte getMovieOnline() {
        return movieOnline;
    }

    public void setMovieOnline(byte movieOnline) {
        this.movieOnline = movieOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId &&
                movieTime == movie.movieTime &&
                movieOnline == movie.movieOnline &&
                Objects.equals(movieName, movie.movieName) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(movieIntroduction, movie.movieIntroduction) &&
                Objects.equals(movieImDb, movie.movieImDb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, releaseDate, movieTime, movieIntroduction, movieImDb, movieOnline);
    }
}
