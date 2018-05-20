package in.ogmatech.authorization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    private long idUser;
    private String username;
    private String password;
    private long userMobile;
    private byte isDeleted;
    private Date userCat;
    private Date userUat;
    private String userDeviceIdentity;

    private List<UserRole> userRoles;

    @Id
    @GeneratedValue
    @Column(name = "id_user", nullable = false)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Column(name = "username", nullable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_mobile", nullable = true, precision = 0)
    public long getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(long userMobile) {
        this.userMobile = userMobile;
    }

    @Column(name = "is_deleted", nullable = false)
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name = "user_cat", nullable = true)
    public Date getUserCat() {
        return userCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "user_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public void setUserCat(Date userCat) {
        this.userCat = userCat;
    }

    @Column(name = "user_uat", nullable = true)
    public Date getUserUat() {
        return userUat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "user_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public void setUserUat(Date userUat) {
        this.userUat = userUat;
    }


    @Column(name = "user_device_identity", nullable = true, length = 45)
    public String getUserDeviceIdentity() {
        return userDeviceIdentity;
    }

    public void setUserDeviceIdentity(String userDeviceIdentity) {
        this.userDeviceIdentity = userDeviceIdentity;
    }






    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
