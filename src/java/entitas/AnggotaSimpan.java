/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iqbael17
 */
@Entity
@Table(name = "ANGGOTA_SIMPAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnggotaSimpan.findAll", query = "SELECT a FROM AnggotaSimpan a")
    , @NamedQuery(name = "AnggotaSimpan.findByKdAnggotasimpan", query = "SELECT a FROM AnggotaSimpan a WHERE a.kdAnggotasimpan = :kdAnggotasimpan")
    , @NamedQuery(name = "AnggotaSimpan.findByTglSimpan", query = "SELECT a FROM AnggotaSimpan a WHERE a.tglSimpan = :tglSimpan")
    , @NamedQuery(name = "AnggotaSimpan.findByNominal", query = "SELECT a FROM AnggotaSimpan a WHERE a.nominal = :nominal")})
public class AnggotaSimpan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_ANGGOTASIMPAN")
    private String kdAnggotasimpan;
    @Column(name = "TGL_SIMPAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglSimpan;
    @Column(name = "NOMINAL")
    private BigInteger nominal;
    @JoinColumn(name = "KD_AKUN", referencedColumnName = "KD_AKUN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Akun kdAkun;
    @JoinColumn(name = "KD_ANGGOTA", referencedColumnName = "KD_ANGGOTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anggota kdAnggota;
    @JoinColumn(name = "KD_SIMPANAN", referencedColumnName = "KD_SIMPANAN")
    @ManyToOne(fetch = FetchType.LAZY)
    private Simpanan kdSimpanan;

    public AnggotaSimpan() {
    }

    public AnggotaSimpan(String kdAnggotasimpan) {
        this.kdAnggotasimpan = kdAnggotasimpan;
    }

    public String getKdAnggotasimpan() {
        return kdAnggotasimpan;
    }

    public void setKdAnggotasimpan(String kdAnggotasimpan) {
        this.kdAnggotasimpan = kdAnggotasimpan;
    }

    public Date getTglSimpan() {
        return tglSimpan;
    }

    public void setTglSimpan(Date tglSimpan) {
        this.tglSimpan = tglSimpan;
    }

    public BigInteger getNominal() {
        return nominal;
    }

    public void setNominal(BigInteger nominal) {
        this.nominal = nominal;
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

    public Simpanan getKdSimpanan() {
        return kdSimpanan;
    }

    public void setKdSimpanan(Simpanan kdSimpanan) {
        this.kdSimpanan = kdSimpanan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdAnggotasimpan != null ? kdAnggotasimpan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnggotaSimpan)) {
            return false;
        }
        AnggotaSimpan other = (AnggotaSimpan) object;
        if ((this.kdAnggotasimpan == null && other.kdAnggotasimpan != null) || (this.kdAnggotasimpan != null && !this.kdAnggotasimpan.equals(other.kdAnggotasimpan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.AnggotaSimpan[ kdAnggotasimpan=" + kdAnggotasimpan + " ]";
    }
    
}
