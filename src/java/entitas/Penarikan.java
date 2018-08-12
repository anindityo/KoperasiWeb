/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitas;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iqbael17
 */
@Entity
@Table(name = "PENARIKAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penarikan.findAll", query = "SELECT p FROM Penarikan p")
    , @NamedQuery(name = "Penarikan.findByKdPenarikan", query = "SELECT p FROM Penarikan p WHERE p.kdPenarikan = :kdPenarikan")})
public class Penarikan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_PENARIKAN")
    private String kdPenarikan;
    @JoinColumn(name = "KD_ANGGOTA", referencedColumnName = "KD_ANGGOTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anggota kdAnggota;

    public Penarikan() {
    }

    public Penarikan(String kdPenarikan) {
        this.kdPenarikan = kdPenarikan;
    }

    public String getKdPenarikan() {
        return kdPenarikan;
    }

    public void setKdPenarikan(String kdPenarikan) {
        this.kdPenarikan = kdPenarikan;
    }

    public Anggota getKdAnggota() {
        return kdAnggota;
    }

    public void setKdAnggota(Anggota kdAnggota) {
        this.kdAnggota = kdAnggota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdPenarikan != null ? kdPenarikan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penarikan)) {
            return false;
        }
        Penarikan other = (Penarikan) object;
        if ((this.kdPenarikan == null && other.kdPenarikan != null) || (this.kdPenarikan != null && !this.kdPenarikan.equals(other.kdPenarikan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Penarikan[ kdPenarikan=" + kdPenarikan + " ]";
    }
    
}
