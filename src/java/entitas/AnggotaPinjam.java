/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ANGGOTA_PINJAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnggotaPinjam.findAll", query = "SELECT a FROM AnggotaPinjam a")
    , @NamedQuery(name = "AnggotaPinjam.findByKdAnggotapinjam", query = "SELECT a FROM AnggotaPinjam a WHERE a.kdAnggotapinjam = :kdAnggotapinjam")
    , @NamedQuery(name = "AnggotaPinjam.findByTglPinjam", query = "SELECT a FROM AnggotaPinjam a WHERE a.tglPinjam = :tglPinjam")
    , @NamedQuery(name = "AnggotaPinjam.findByNominalPinjam", query = "SELECT a FROM AnggotaPinjam a WHERE a.nominalPinjam = :nominalPinjam")})
public class AnggotaPinjam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_ANGGOTAPINJAM")
    private String kdAnggotapinjam;
    @Column(name = "TGL_PINJAM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglPinjam;
    @Column(name = "NOMINAL_PINJAM")
    private BigInteger nominalPinjam;
    @OneToMany(mappedBy = "kdAnggotapinjam", fetch = FetchType.LAZY)
    private List<Angsuranpinjam> angsuranpinjamList;
    @JoinColumn(name = "KD_AKUN", referencedColumnName = "KD_AKUN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Akun kdAkun;
    @JoinColumn(name = "KD_ANGGOTA", referencedColumnName = "KD_ANGGOTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anggota kdAnggota;
    @JoinColumn(name = "KD_TENOR", referencedColumnName = "KD_TENOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tenor kdTenor;

    public AnggotaPinjam() {
    }

    public AnggotaPinjam(String kdAnggotapinjam) {
        this.kdAnggotapinjam = kdAnggotapinjam;
    }

    public String getKdAnggotapinjam() {
        return kdAnggotapinjam;
    }

    public void setKdAnggotapinjam(String kdAnggotapinjam) {
        this.kdAnggotapinjam = kdAnggotapinjam;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public BigInteger getNominalPinjam() {
        return nominalPinjam;
    }

    public void setNominalPinjam(BigInteger nominalPinjam) {
        this.nominalPinjam = nominalPinjam;
    }

    @XmlTransient
    public List<Angsuranpinjam> getAngsuranpinjamList() {
        return angsuranpinjamList;
    }

    public void setAngsuranpinjamList(List<Angsuranpinjam> angsuranpinjamList) {
        this.angsuranpinjamList = angsuranpinjamList;
    }

    public Akun getKdAkun() {
        return kdAkun;
    }

    public void setKdAkun(Akun kdAkun) {
        this.kdAkun = kdAkun;
    }

    public Anggota getKdAnggota() {
        return kdAnggota;
    }

    public void setKdAnggota(Anggota kdAnggota) {
        this.kdAnggota = kdAnggota;
    }

    public Tenor getKdTenor() {
        return kdTenor;
    }

    public void setKdTenor(Tenor kdTenor) {
        this.kdTenor = kdTenor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdAnggotapinjam != null ? kdAnggotapinjam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnggotaPinjam)) {
            return false;
        }
        AnggotaPinjam other = (AnggotaPinjam) object;
        if ((this.kdAnggotapinjam == null && other.kdAnggotapinjam != null) || (this.kdAnggotapinjam != null && !this.kdAnggotapinjam.equals(other.kdAnggotapinjam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.AnggotaPinjam[ kdAnggotapinjam=" + kdAnggotapinjam + " ]";
    }
    
}
