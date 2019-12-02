package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Browsing {
    private int browseId;
    private String browseContent;
    private String browser;
    private String browseTime;

    @Id
    @Column(name = "browse _id", nullable = false)
    public int getBrowseId() {
        return browseId;
    }

    public void setBrowseId(int browseId) {
        this.browseId = browseId;
    }

    @Basic
    @Column(name = "browse _content", nullable = false, length = 100)
    public String getBrowseContent() {
        return browseContent;
    }

    public void setBrowseContent(String browseContent) {
        this.browseContent = browseContent;
    }

    @Basic
    @Column(name = "browser", nullable = false, length = 32)
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Basic
    @Column(name = "browse_time", nullable = true, length = 10)
    public String getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(String browseTime) {
        this.browseTime = browseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Browsing browsing = (Browsing) o;
        return browseId == browsing.browseId &&
                Objects.equals(browseContent, browsing.browseContent) &&
                Objects.equals(browser, browsing.browser) &&
                Objects.equals(browseTime, browsing.browseTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(browseId, browseContent, browser, browseTime);
    }
}
