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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ANGGOTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anggota.findAll", query = "SELECT a FROM Anggota a")
    , @NamedQuery(name = "Anggota.findByKdAnggota", query = "SELECT a FROM Anggota a WHERE a.kdAnggota = :kdAnggota")
    , @NamedQuery(name = "Anggota.findByPassword", query = "SELECT a FROM Anggota a WHERE a.password = :password")
    , @NamedQuery(name = "Anggota.findByNamaAnggota", query = "SELECT a FROM Anggota a WHERE a.namaAnggota = :namaAnggota")
    , @NamedQuery(name = "Anggota.findByTelepon", query = "SELECT a FROM Anggota a WHERE a.telepon = :telepon")
    , @NamedQuery(name = "Anggota.findByJenisKelamin", query = "SELECT a FROM Anggota a WHERE a.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Anggota.findByAlamat", query = "SELECT a FROM Anggota a WHERE a.alamat = :alamat")})
public class Anggota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_ANGGOTA")
    private String kdAnggota;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAMA_ANGGOTA")
    private String namaAnggota;
    @Column(name = "TELEPON")
    private String telepon;
    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;
    @Column(name = "ALAMAT")
    private String alamat;
    @OneToMany(mappedBy = "kdAnggota", fetch = FetchType.LAZY)
    private List<AnggotaSimpan> anggotaSimpanList;
    @OneToMany(mappedBy = "kdAnggota", fetch = FetchType.LAZY)
    private List<Penarikan> penarikanList;
    @JoinColumn(name = "KD_ROLE", referencedColumnName = "KD_ROLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role kdRole;
    @OneToMany(mappedBy = "kdAnggota", fetch = FetchType.LAZY)
    private List<AnggotaPinjam> anggotaPinjamList;

    public Anggota(String kdAnggota, String password, String namaAnggota, String telepon, String jenisKelamin, String alamat, Role kdRole) {
        this.kdAnggota = kdAnggota;
        this.password = password;
        this.namaAnggota = namaAnggota;
        this.telepon = telepon;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.kdRole = kdRole;
    }

    public Anggota(String kdAnggota) {
        this.kdAnggota = kdAnggota;
    }

    public String getKdAnggota() {
        return kdAnggota;
    }

    public void setKdAnggota(String kdAnggota) {
        this.kdAnggota = kdAnggota;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @XmlTransient
    public List<AnggotaSimpan> getAnggotaSimpanList() {
        return anggotaSimpanList;
    }

    public void setAnggotaSimpanList(List<AnggotaSimpan> anggotaSimpanList) {
        this.anggotaSimpanList = anggotaSimpanList;
    }

    @XmlTransient
    public List<Penarikan> getPenarikanList() {
        return penarikanList;
    }

    public void setPenarikanList(List<Penarikan> penarikanList) {
        this.penarikanList = penarikanList;
    }

    public Role getKdRole() {
        return kdRole;
    }

    public void setKdRole(Role kdRole) {
        this.kdRole = kdRole;
    }

    @XmlTransient
    public List<AnggotaPinjam> getAnggotaPinjamList() {
        return anggotaPinjamList;
    }

    public void setAnggotaPinjamList(List<AnggotaPinjam> anggotaPinjamList) {
        this.anggotaPinjamList = anggotaPinjamList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdAnggota != null ? kdAnggota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anggota)) {
            return false;
        }
        Anggota other = (Anggota) object;
        if ((this.kdAnggota == null && other.kdAnggota != null) || (this.kdAnggota != null && !this.kdAnggota.equals(other.kdAnggota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Anggota[ kdAnggota=" + kdAnggota + " ]";
    }
    
}
