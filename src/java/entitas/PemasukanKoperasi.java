/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author iqbal yusuff
 */
@Entity
@Table(name = "PEMASUKAN_KOPERASI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PemasukanKoperasi.findAll", query = "SELECT p FROM PemasukanKoperasi p")
    , @NamedQuery(name = "PemasukanKoperasi.findByKdMasukkoperasi", query = "SELECT p FROM PemasukanKoperasi p WHERE p.kdMasukkoperasi = :kdMasukkoperasi")
    , @NamedQuery(name = "PemasukanKoperasi.findByNamaSimpanan", query = "SELECT p FROM PemasukanKoperasi p WHERE p.namaSimpanan = :namaSimpanan")
    , @NamedQuery(name = "PemasukanKoperasi.findByTglSimpan", query = "SELECT p FROM PemasukanKoperasi p WHERE p.tglSimpan = :tglSimpan")
    , @NamedQuery(name = "PemasukanKoperasi.findByNominal", query = "SELECT p FROM PemasukanKoperasi p WHERE p.nominal = :nominal")})
public class PemasukanKoperasi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_MASUKKOPERASI")
    private String kdMasukkoperasi;
    @Column(name = "NAMA_SIMPANAN")
    private String namaSimpanan;
    @Column(name = "TGL_SIMPAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglSimpan;
    @Column(name = "NOMINAL")
    private Integer nominal;
    @JoinColumn(name = "KD_SIMPANAN", referencedColumnName = "KD_SIMPANAN")
    @ManyToOne
    private Simpanan kdSimpanan;

    public PemasukanKoperasi() {
    }

    public PemasukanKoperasi(String kdMasukkoperasi, String namaSimpanan, Date tglSimpan, Integer nominal, Simpanan kdSimpanan) {
        this.kdMasukkoperasi = kdMasukkoperasi;
        this.namaSimpanan = namaSimpanan;
        this.tglSimpan = tglSimpan;
        this.nominal = nominal;
        this.kdSimpanan = kdSimpanan;
    }

    public PemasukanKoperasi(String kdMasukkoperasi) {
        this.kdMasukkoperasi = kdMasukkoperasi;
    }

    public String getKdMasukkoperasi() {
        return kdMasukkoperasi;
    }

    public void setKdMasukkoperasi(String kdMasukkoperasi) {
        this.kdMasukkoperasi = kdMasukkoperasi;
    }

    public String getNamaSimpanan() {
        return namaSimpanan;
    }

    public void setNamaSimpanan(String namaSimpanan) {
        this.namaSimpanan = namaSimpanan;
    }

    public Date getTglSimpan() {
        return tglSimpan;
    }

    public void setTglSimpan(Date tglSimpan) {
        this.tglSimpan = tglSimpan;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
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
        hash += (kdMasukkoperasi != null ? kdMasukkoperasi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PemasukanKoperasi)) {
            return false;
        }
        PemasukanKoperasi other = (PemasukanKoperasi) object;
        if ((this.kdMasukkoperasi == null && other.kdMasukkoperasi != null) || (this.kdMasukkoperasi != null && !this.kdMasukkoperasi.equals(other.kdMasukkoperasi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.PemasukanKoperasi[ kdMasukkoperasi=" + kdMasukkoperasi + " ]";
    }
    
}
