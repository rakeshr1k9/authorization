package in.ogmatech.authorization.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    private long idUser;
    private String username;
    private String password;
    private BigDecimal userMobile;
    private byte isDeleted;
    private Date userCat;
    private Date userUat;
    private Date userDat;
    private String userDeviceId;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    public BigDecimal getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(BigDecimal userMobile) {
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

    public void setUserCat(Date userCat) {
        this.userCat = userCat;
    }

    @Column(name = "user_uat", nullable = true)
    public Date getUserUat() {
        return userUat;
    }

    public void setUserUat(Date userUat) {
        this.userUat = userUat;
    }

    @Column(name = "user_dat", nullable = true)
    public Date getUserDat() {
        return userDat;
    }

    public void setUserDat(Date userDat) {
        this.userDat = userDat;
    }

    @Column(name = "user_device_id", nullable = true, length = 45)
    public String getUserDeviceId() {
        return userDeviceId;
    }

    public void setUserDeviceId(String userDeviceId) {
        this.userDeviceId = userDeviceId;
    }

}
