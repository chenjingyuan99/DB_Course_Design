package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Scriptwriter {
    private int scriptwriterId;
    private String scriptwriterName;

    @Id
    @Column(name = "scriptwriter_id")
    public int getScriptwriterId() {
        return scriptwriterId;
    }

    public void setScriptwriterId(int scriptwriterId) {
        this.scriptwriterId = scriptwriterId;
    }

    @Basic
    @Column(name = "scriptwriter_name")
    public String getScriptwriterName() {
        return scriptwriterName;
    }

    public void setScriptwriterName(String scriptwriterName) {
        this.scriptwriterName = scriptwriterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scriptwriter that = (Scriptwriter) o;
        return scriptwriterId == that.scriptwriterId &&
                Objects.equals(scriptwriterName, that.scriptwriterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptwriterId, scriptwriterName);
    }
}
