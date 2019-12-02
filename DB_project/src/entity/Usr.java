package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Usr {
    private int usrId;
    private String usrAccount;
    private String usrNickname;
    private String usrPasswd;

    @Id
    @Column(name = "usr_id", nullable = false)
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "usr_account", nullable = false, length = 16)
    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount;
    }

    @Basic
    @Column(name = "usr_nickname", nullable = false, length = 16)
    public String getUsrNickname() {
        return usrNickname;
    }

    public void setUsrNickname(String usrNickname) {
        this.usrNickname = usrNickname;
    }

    @Basic
    @Column(name = "usr_passwd", nullable = false, length = 16)
    public String getUsrPasswd() {
        return usrPasswd;
    }

    public void setUsrPasswd(String usrPasswd) {
        this.usrPasswd = usrPasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usr usr = (Usr) o;
        return usrId == usr.usrId &&
                Objects.equals(usrAccount, usr.usrAccount) &&
                Objects.equals(usrNickname, usr.usrNickname) &&
                Objects.equals(usrPasswd, usr.usrPasswd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usrId, usrAccount, usrNickname, usrPasswd);
    }
}
