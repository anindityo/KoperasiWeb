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
@Table(name = "TENOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tenor.findAll", query = "SELECT t FROM Tenor t")
    , @NamedQuery(name = "Tenor.findByKdTenor", query = "SELECT t FROM Tenor t WHERE t.kdTenor = :kdTenor")
    , @NamedQuery(name = "Tenor.findByNamaTenor", query = "SELECT t FROM Tenor t WHERE t.namaTenor = :namaTenor")})
public class Tenor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KD_TENOR")
    private String kdTenor;
    @Column(name = "NAMA_TENOR")
    private BigInteger namaTenor;
    @OneToMany(mappedBy = "kdTenor", fetch = FetchType.LAZY)
    private List<AnggotaPinjam> anggotaPinjamList;

    public Tenor() {
    }

    public Tenor(String kdTenor) {
        this.kdTenor = kdTenor;
    }

    public String getKdTenor() {
        return kdTenor;
    }

    public void setKdTenor(String kdTenor) {
        this.kdTenor = kdTenor;
    }

    public BigInteger getNamaTenor() {
        return namaTenor;
    }

    public void setNamaTenor(BigInteger namaTenor) {
        this.namaTenor = namaTenor;
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
        hash += (kdTenor != null ? kdTenor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tenor)) {
            return false;
        }
        Tenor other = (Tenor) object;
        if ((this.kdTenor == null && other.kdTenor != null) || (this.kdTenor != null && !this.kdTenor.equals(other.kdTenor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitas.Tenor[ kdTenor=" + kdTenor + " ]";
    }
    
}
