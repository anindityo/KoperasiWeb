/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iqbael17
 */
@Entity
@Table(name = "AKUN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Akun.findAll", query = "SELECT a FROM Akun a")
    , @NamedQuery(name = "Akun.findByKdAkun", query = "SELECT a FROM Akun a WHERE a.kdAkun = :kdAkun")
    , @NamedQuery(name = "Akun.findByPassword", query = "SELECT a FROM Akun a WHERE a.password = :password")
    , @NamedQuery(name = "Akun.findByTelepon", query = "SELECT a FROM Akun a WHERE a.telepon = :telepon")})
public class Akun implements Serializable {

    @Column(name = "TANGGALLAHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggallahir;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_AKUN")
    private String kdAkun;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TELEPON")
    private String telepon;
    @OneToMany(mappedBy = "kdAkun", fetch = FetchType.LAZY)
    private List<AnggotaSimpan> anggotaSimpanList;
    @OneToMany(mappedBy = "kdAkun", fetch = FetchType.LAZY)
    private List<AnggotaPinjam> anggotaPinjamList;
    @JoinColumn(name = "KD_ROLE", referencedColumnName = "KD_ROLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role kdRole;

    public Akun() {
    }

    public Akun(String kdAkun, String password, String telepon, Role kdRole, Date tanggallahir) {
  
        this.kdAkun = kdAkun;
        this.password = password;
        this.telepon = telepon;
        this.kdRole = kdRole;
        this.tanggallahir = tanggallahir;
    }

    public Akun( String kdAkun, String telepon, Role kdRole, Date tanggallahir) {
        this.kdAkun = kdAkun;
        this.telepon = telepon;
        this.kdRole = kdRole;
         this.tanggallahir = tanggallahir;
    }

    

        
    public Akun(String kdAkun) {
        this.kdAkun = kdAkun;
    }

    public String getKdAkun() {
        return kdAkun;
    }

    public void setKdAkun(String kdAkun) {
        this.kdAkun = kdAkun;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @XmlTransient
    public List<AnggotaSimpan> getAnggotaSimpanList() {
        return anggotaSimpanList;
    }

    public void setAnggotaSimpanList(List<AnggotaSimpan> anggotaSimpanList) {
        this.anggotaSimpanList = anggotaSimpanList;
    }

    @XmlTransient
    public List<AnggotaPinjam> getAnggotaPinjamList() {
        return anggotaPinjamList;
    }

    public void setAnggotaPinjamList(List<AnggotaPinjam> anggotaPinjamList) {
        this.anggotaPinjamList = anggotaPinjamList;
    }

    public Role getKdRole() {
        return kdRole;
    }

    public void setKdRole(Role kdRole) {
        this.kdRole = kdRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdAkun != null ? kdAkun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Akun)) {
            return false;
        }
        Akun other = (Akun) object;
        if ((this.kdAkun == null && other.kdAkun != null) || (this.kdAkun != null && !this.kdAkun.equals(other.kdAkun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Akun[ kdAkun=" + kdAkun + " ]";
    }

    public Date getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(Date tanggallahir) {
        this.tanggallahir = tanggallahir;
    }
    
}
