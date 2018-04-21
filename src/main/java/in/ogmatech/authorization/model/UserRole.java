package in.ogmatech.authorization.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole {

    private long idUserRole;
    private Date userRoleCat;
    private Date userRoleUat;
    private Date userRoleDat;
    private byte isDeleted;

    private User user;

    private Role roll;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_user_role", nullable = false)
    public long getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(long idUserRole) {
        this.idUserRole = idUserRole;
    }

    @Column(name = "user_role_cat", nullable = true)
    public Date getUserRoleCat() {
        return userRoleCat;
    }

    public void setUserRoleCat(Date userRoleCat) {
        this.userRoleCat = userRoleCat;
    }

    @Column(name = "user_role_uat", nullable = true)
    public Date getUserRoleUat() {
        return userRoleUat;
    }

    public void setUserRoleUat(Date userRoleUat) {
        this.userRoleUat = userRoleUat;
    }

    @Column(name = "user_role_dat", nullable = true)
    public Date getUserRoleDat() {
        return userRoleDat;
    }

    public void setUserRoleDat(Date userRoleDat) {
        this.userRoleDat = userRoleDat;
    }

    @Column(name = "is_deleted", nullable = false)
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id_role")
    public Role getRoll() {
        return roll;
    }

    public void setRoll(Role roll) {
        this.roll = roll;
    }
}
