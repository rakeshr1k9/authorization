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
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class Role {

    private long idRole;
    private String roleName;
    private byte isDeleted;
    private Date roleCat;
    private Date roleUat;

    private List<UserRole> userRoles;

    @Id
    @GeneratedValue
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

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "role_cat", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date getRoleCat() {
        return roleCat;
    }

    public void setRoleCat(Date roleCat) {
        this.roleCat = roleCat;
    }

    @JsonIgnoreProperties(allowGetters = true)
    @Column(name = "role_uat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    public Date getRoleUat() {
        return roleUat;
    }

    public void setRoleUat(Date roleUat) {
        this.roleUat = roleUat;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
