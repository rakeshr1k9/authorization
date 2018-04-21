package in.ogmatech.authorization.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "role")
public class Role {

    private long idRole;
    private String roleName;
    private byte isDeleted;
    private Date roleCat;
    private Date roleUat;
    private Date roleDat;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_role", nullable = false)
    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Column(name = "role_name", nullable = true)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "is_deleted", nullable = true)
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name = "role_cat", nullable = true)
    public Date getRoleCat() {
        return roleCat;
    }

    public void setRoleCat(Date roleCat) {
        this.roleCat = roleCat;
    }

    @Column(name = "role_uat", nullable = true)
    public Date getRoleUat() {
        return roleUat;
    }

    public void setRoleUat(Date roleUat) {
        this.roleUat = roleUat;
    }

    @Column(name = "role_dat", nullable = true)
    public Date getRoleDat() {
        return roleDat;
    }

    public void setRoleDat(Date roleDat) {
        this.roleDat = roleDat;
    }
}
