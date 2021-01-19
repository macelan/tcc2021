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
public class ObservacaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "observacao_id")
    private int observacaoId;
    @Basic(optional = false)
    @Column(name = "sentenciado_id")
    private int sentenciadoId;

    public ObservacaoPK() {
    }

    public ObservacaoPK(int observacaoId, int sentenciadoId) {
        this.observacaoId = observacaoId;
        this.sentenciadoId = sentenciadoId;
    }

    public int getObservacaoId() {
        return observacaoId;
    }

    public void setObservacaoId(int observacaoId) {
        this.observacaoId = observacaoId;
    }

    public int getSentenciadoId() {
        return sentenciadoId;
    }

    public void setSentenciadoId(int sentenciadoId) {
        this.sentenciadoId = sentenciadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) observacaoId;
        hash += (int) sentenciadoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservacaoPK)) {
            return false;
        }
        ObservacaoPK other = (ObservacaoPK) object;
        if (this.observacaoId != other.observacaoId) {
            return false;
        }
        if (this.sentenciadoId != other.sentenciadoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ObservacaoPK[ observacaoId=" + observacaoId + ", sentenciadoId=" + sentenciadoId + " ]";
    }
    
}
