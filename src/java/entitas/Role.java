/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iqbael17
 */
@Entity
@Table(name = "ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByKdRole", query = "SELECT r FROM Role r WHERE r.kdRole = :kdRole")
    , @NamedQuery(name = "Role.findByNamaRole", query = "SELECT r FROM Role r WHERE r.namaRole = :namaRole")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_ROLE")
    private Short kdRole;
    @Column(name = "NAMA_ROLE")
    private String namaRole;
    @OneToMany(mappedBy = "kdRole", fetch = FetchType.LAZY)
    private List<Anggota> anggotaList;
    @OneToMany(mappedBy = "kdRole", fetch = FetchType.LAZY)
    private List<Akun> akunList;

    public Role() {
    }

    public Role(Short kdRole) {
        this.kdRole = kdRole;
    }

    public Short getKdRole() {
        return kdRole;
    }

    public void setKdRole(Short kdRole) {
        this.kdRole = kdRole;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    @XmlTransient
    public List<Anggota> getAnggotaList() {
        return anggotaList;
    }

    public void setAnggotaList(List<Anggota> anggotaList) {
        this.anggotaList = anggotaList;
    }

    @XmlTransient
    public List<Akun> getAkunList() {
        return akunList;
    }

    public void setAkunList(List<Akun> akunList) {
        this.akunList = akunList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdRole != null ? kdRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.kdRole == null && other.kdRole != null) || (this.kdRole != null && !this.kdRole.equals(other.kdRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Role[ kdRole=" + kdRole + " ]";
    }
    
}
