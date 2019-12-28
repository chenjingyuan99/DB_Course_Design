package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Awarding {
    private int awardsId;
    private String awardsName;
    private String activities;
    private String awardObject;
    private int movieId;

    @Id
    @Column(name = "awards_id", nullable = false)
    public int getAwardsId() {
        return awardsId;
    }

    public void setAwardsId(int awardsId) {
        this.awardsId = awardsId;
    }

    @Basic
    @Column(name = "awards_name", nullable = false, length = 32)
    public String getAwardsName() {
        return awardsName;
    }

    public void setAwardsName(String awardsName) {
        this.awardsName = awardsName;
    }

    @Basic
    @Column(name = "activities", nullable = true, length = 32)
    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    @Basic
    @Column(name = "award_object", nullable = true, length = 32)
    public String getAwardObject() {
        return awardObject;
    }

    public void setAwardObject(String awardObject) {
        this.awardObject = awardObject;
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
        Awarding awarding = (Awarding) o;
        return awardsId == awarding.awardsId &&
                movieId == awarding.movieId &&
                Objects.equals(awardsName, awarding.awardsName) &&
                Objects.equals(activities, awarding.activities) &&
                Objects.equals(awardObject, awarding.awardObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardsId, awardsName, activities, awardObject, movieId);
    }
}
