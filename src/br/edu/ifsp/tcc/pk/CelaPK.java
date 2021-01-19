/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.pk;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Programar
 */
@Embeddable
public class CelaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cela_id")
    private int celaId;
    @Basic(optional = false)
    @Column(name = "pavilhao_id")
    private int pavilhaoId;

    public CelaPK() {
    }

    public CelaPK(int celaId, int pavilhaoId) {
        this.celaId = celaId;
        this.pavilhaoId = pavilhaoId;
    }

    public int getCelaId() {
        return celaId;
    }

    public void setCelaId(int celaId) {
        this.celaId = celaId;
    }

    public int getPavilhaoId() {
        return pavilhaoId;
    }

    public void setPavilhaoId(int pavilhaoId) {
        this.pavilhaoId = pavilhaoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) celaId;
        hash += (int) pavilhaoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CelaPK)) {
            return false;
        }
        CelaPK other = (CelaPK) object;
        if (this.celaId != other.celaId) {
            return false;
        }
        if (this.pavilhaoId != other.pavilhaoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CelaPK[ celaId=" + celaId + ", pavilhaoId=" + pavilhaoId + " ]";
    }
    
}