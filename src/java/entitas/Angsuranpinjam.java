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
@Table(name = "ANGSURANPINJAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Angsuranpinjam.findAll", query = "SELECT a FROM Angsuranpinjam a")
    , @NamedQuery(name = "Angsuranpinjam.findByKdAngsuran", query = "SELECT a FROM Angsuranpinjam a WHERE a.kdAngsuran = :kdAngsuran")
    , @NamedQuery(name = "Angsuranpinjam.findByTanggalAngsur", query = "SELECT a FROM Angsuranpinjam a WHERE a.tanggalAngsur = :tanggalAngsur")
    , @NamedQuery(name = "Angsuranpinjam.findByJumlahAngsuran", query = "SELECT a FROM Angsuranpinjam a WHERE a.jumlahAngsuran = :jumlahAngsuran")
    , @NamedQuery(name = "Angsuranpinjam.findByStatus", query = "SELECT a FROM Angsuranpinjam a WHERE a.status = :status")})
public class Angsuranpinjam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_ANGSURAN")
    private String kdAngsuran;
    @Column(name = "TANGGAL_ANGSUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalAngsur;
    @Column(name = "JUMLAH_ANGSURAN")
    private BigInteger jumlahAngsuran;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "KD_ANGGOTAPINJAM", referencedColumnName = "KD_ANGGOTAPINJAM")
    @ManyToOne(fetch = FetchType.LAZY)
    private AnggotaPinjam kdAnggotapinjam;

    public Angsuranpinjam() {
    }

    public Angsuranpinjam(String kdAngsuran, Date tanggalAngsur, BigInteger jumlahAngsuran, String status, AnggotaPinjam kdAnggotapinjam) {
        this.kdAngsuran = kdAngsuran;
        this.tanggalAngsur = tanggalAngsur;
        this.jumlahAngsuran = jumlahAngsuran;
        this.status = status;
        this.kdAnggotapinjam = kdAnggotapinjam;
    }

    public Angsuranpinjam(String kdAngsuran) {
        this.kdAngsuran = kdAngsuran;
    }

    public Angsuranpinjam(String kdAngsuran, AnggotaPinjam kdAnggotapinjam) {
        this.kdAngsuran = kdAngsuran;
        this.kdAnggotapinjam = kdAnggotapinjam;
    }

    public String getKdAngsuran() {
        return kdAngsuran;
    }

    public void setKdAngsuran(String kdAngsuran) {
        this.kdAngsuran = kdAngsuran;
    }

    public Date getTanggalAngsur() {
        return tanggalAngsur;
    }

    public void setTanggalAngsur(Date tanggalAngsur) {
        this.tanggalAngsur = tanggalAngsur;
    }

    public BigInteger getJumlahAngsuran() {
        return jumlahAngsuran;
    }

    public void setJumlahAngsuran(BigInteger jumlahAngsuran) {
        this.jumlahAngsuran = jumlahAngsuran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AnggotaPinjam getKdAnggotapinjam() {
        return kdAnggotapinjam;
    }

    public void setKdAnggotapinjam(AnggotaPinjam kdAnggotapinjam) {
        this.kdAnggotapinjam = kdAnggotapinjam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdAngsuran != null ? kdAngsuran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Angsuranpinjam)) {
            return false;
        }
        Angsuranpinjam other = (Angsuranpinjam) object;
        if ((this.kdAngsuran == null && other.kdAngsuran != null) || (this.kdAngsuran != null && !this.kdAngsuran.equals(other.kdAngsuran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Angsuranpinjam[ kdAngsuran=" + kdAngsuran + " ]";
    }

}
