/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "SIMPANAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simpanan.findAll", query = "SELECT s FROM Simpanan s")
    , @NamedQuery(name = "Simpanan.findByKdSimpanan", query = "SELECT s FROM Simpanan s WHERE s.kdSimpanan = :kdSimpanan")
    , @NamedQuery(name = "Simpanan.findByNamaSimpanan", query = "SELECT s FROM Simpanan s WHERE s.namaSimpanan = :namaSimpanan")
    , @NamedQuery(name = "Simpanan.findByJumlahSimpanan", query = "SELECT s FROM Simpanan s WHERE s.jumlahSimpanan = :jumlahSimpanan")})
public class Simpanan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_SIMPANAN")
    private String kdSimpanan;
    @Column(name = "NAMA_SIMPANAN")
    private String namaSimpanan;
    @Column(name = "JUMLAH_SIMPANAN")
    private BigInteger jumlahSimpanan;
    @OneToMany(mappedBy = "kdSimpanan", fetch = FetchType.LAZY)
    private List<AnggotaSimpan> anggotaSimpanList;
    @OneToMany(mappedBy = "kdSimpanan", fetch = FetchType.LAZY)
    private List<PemasukanKoperasi> pemasukanKoperasiList;

    public Simpanan() {
    }

    public Simpanan(String kdSimpanan) {
        this.kdSimpanan = kdSimpanan;
    }

    public String getKdSimpanan() {
        return kdSimpanan;
    }

    public void setKdSimpanan(String kdSimpanan) {
        this.kdSimpanan = kdSimpanan;
    }

    public String getNamaSimpanan() {
        return namaSimpanan;
    }

    public void setNamaSimpanan(String namaSimpanan) {
        this.namaSimpanan = namaSimpanan;
    }

    public BigInteger getJumlahSimpanan() {
        return jumlahSimpanan;
    }

    public void setJumlahSimpanan(BigInteger jumlahSimpanan) {
        this.jumlahSimpanan = jumlahSimpanan;
    }

    @XmlTransient
    public List<AnggotaSimpan> getAnggotaSimpanList() {
        return anggotaSimpanList;
    }

    public void setAnggotaSimpanList(List<AnggotaSimpan> anggotaSimpanList) {
        this.anggotaSimpanList = anggotaSimpanList;
    }

    @XmlTransient
    public List<PemasukanKoperasi> getPemasukanKoperasiList() {
        return pemasukanKoperasiList;
    }

    public void setPemasukanKoperasiList(List<PemasukanKoperasi> pemasukanKoperasiList) {
        this.pemasukanKoperasiList = pemasukanKoperasiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdSimpanan != null ? kdSimpanan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simpanan)) {
            return false;
        }
        Simpanan other = (Simpanan) object;
        if ((this.kdSimpanan == null && other.kdSimpanan != null) || (this.kdSimpanan != null && !this.kdSimpanan.equals(other.kdSimpanan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Simpanan[ kdSimpanan=" + kdSimpanan + " ]";
    }
    
}
